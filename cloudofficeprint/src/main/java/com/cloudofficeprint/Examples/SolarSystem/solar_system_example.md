# About
In this file we are going to show you how you can use this Cloud (Cloud Office Print) SDK to generate an output file using a template and data to fill the template. The general approach is to create a template file in which you want the data to appear, then process the data with this SDK and finally let Cloud do the work to merge your template with the data. 

In this example, we are going to use solar system data to fill a template we are going to make. The solary system data can be received by sending an HTTP-request to an API. The API used in this example is https://api.le-systeme-solaire.net.

Normally you know the data you will be using to fill in the template, but for this example, we are going to start with a brief overview of the data we will be using. Then we will create a template. Then we will get the data from the solar system API and process this data with this SDK. Finally we send the template together with the data to a Cloud Office Print server and save the response into our output file.

# Input data (API)
The data we use comes from https://api.le-systeme-solaire.net. The data that interests us is about the bodies of the solar system and more specifically the planets and dwarf planets in our solar system. If we go to the URL https://api.le-systeme-solaire.net/rest/bodies, we retrieve a JSON array containing objects for each body in the solar system. One such object may look like this:

```json
{
    "id":"lune",
    "name":"La Lune",
    "englishName":"Moon",
    "isPlanet":false,
    "moons":null,
    "semimajorAxis":384400,
    "perihelion":363300,
    "aphelion":405500,
    "eccentricity":0.05490,
    "inclination":5.14500,
    "mass":{
        "massValue":7.34600,
        "massExponent":22
    },
    "vol":{
        "volValue":2.19680,
        "volExponent":10
    },
    "density":3.34400,
    "gravity":1.62000,
    "escape":2380.00000,
    "meanRadius":33.00000,
    "equaRadius":1738.10000,
    "polarRadius":1736.00000,
    "flattening":0.00120,
    "dimension":"",
    "sideralOrbit":27.32170,
    "sideralRotation":655.72800,
    "aroundPlanet":{
        "planet":"terre",
        "rel":"https://api.le-systeme-solaire.net/rest/bodies/terre"
    },
    "discoveredBy":"",
    "discoveryDate":"",
    "alternativeName":"",
    "axialTilt":6.68,
    "avgTemp":0,
    "mainAnomaly":0.00000,
    "argPeriapsis":0.00000,
    "longAscNode":0.00000,
    "rel":"https://api.le-systeme-solaire.net/rest/bodies/lune"
}
```

# Template
Now we will build the template. We can create templates in different file extensions, namely docx, xlsx, pptx, html, md, txt and csv. In this example we will build a template of filetype pptx and docx. The template has to follow a specific structure which can be found at the official Cloud Office Print documentation: https://www.cloudofficeprint.com/docs/.

## pptx
We will build the template in Google Slides. After choosing a pretty theme, we create the title slide. On this slide, we want the title of our presentation and the source where we got the data from. The title slide looks like this:

<img src="https://raw.githubusercontent.com/United-Codes/cloudofficeprint-java/main/cloudofficeprint/src/main/java/com/cloudofficeprint/Examples/SolarSystem/imgs/pptx_title.png" width="600" />

Here we encounter our first placeholder/tag: `{*data source}`. Tags are defined by surrounding a variable name with curly brackets. This is the way we let the Cloud Office Print server know that data needs to replace this placeholder. We will see what that data is in the section [Process input data](#process-input-data). In this specific case, we used a hyperlink-tag `{*hyperlink}`.

Note: to minimize the modifications to the input data (see [Input Data (API)](#input-data-api)), it is important to use as variable names the keys available in the input data if possible.

Next, we want to have a slide for each planet with information about this planet. Since all planets have the same parameters (such as mass, density, gravity etc.), we want to specify one template slide and use this for each planet. This template slide looks like this:

<img src="https://raw.githubusercontent.com/United-Codes/cloudofficeprint-java/main/cloudofficeprint/src/main/java/com/cloudofficeprint/Examples/SolarSystem/imgs/pptx_planets.png" width="600" />

Again, the placeholders will be replaced with data by the Cloud Office Print server. Since the data given to the Cloud Office Print server will be in JSON-format (see [Process input data](#process-input-data)), it is possible to reach a subfield of an entry by using `entry.subfield`. So if `mass` is a JSON object like this:
```json
"mass": {
    "massValue": ...,
    "massExponent": ...
}
```
we can access the field `massValue` by doing `mass.massValue`, as can be seen on the slide. The tags on this slide are 'normal' tags in the sense that they will just be replaced by a value.

The thing of replicating a certain template slide for each object in a list is exactly what the first tag `{!planets}` is for. For each planet in the planets-array (provided in the data, see [Process input data](#process-input-data)), this slide is repeated.

It might be interesting to plot the radius for each of the planets on a chart. This is the slide used for that:

<img src="https://raw.githubusercontent.com/United-Codes/cloudofficeprint-java/main/cloudofficeprint/src/main/java/com/cloudofficeprint/Examples/SolarSystem/imgs/pptx_chart.png" width="600" />

The tag `{$planet_radius_chart}` is used to insert a chart at the place of this placeholder. The data for the chart can be generated using this SDK.

## docx
The template for the "docx"-filetype is very similar to the template for the "pptx"-filetype in the sense that they use the same parameters. For this template we want to generate a table containing information about the planets in the solar system. The template looks like this:

<img src="https://raw.githubusercontent.com/United-Codes/cloudofficeprint-java/main/cloudofficeprint/src/main/java/com/cloudofficeprint/Examples/SolarSystem/imgs/docx.png" width="600" />

# Process input data (SDK)
Now that our template is finished, we have to process the data used by the template. That is where this SDK comes into play. In this section we will explain in detail all the code needed to generate the data to fill in the template. The full code can also be found in the example file itself.

The beauty of Cloud Office Print is that the data created by the Python SDK can be used in all templates of different file extensions while using the same tags.

## Setup
First we create a new file and import the Cloud Office Print library:
```java
import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.ChartTextStyle;
import com.cloudofficeprint.RenderElements.Charts.Charts.Pie3DChart;
import com.cloudofficeprint.RenderElements.Charts.Series.PieSeries;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.HyperLink;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.Loops.Loop;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Server.Server;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;
```
Then we need to set up the Cloud Office Print server where we will send our template and data to:
```java
Server copServer = new Server("https://api.cloudofficeprint.com");
copServer.setVerbose(true);
copServer.setAPIKey(APIKey);
```
If you have a Cloud Office Print server running on localhost (e.g. on-premise version), replace the server url by the localhost url: http://localhost:8010

We also need to create the main element-collection object that contains all our data:
```java
ElementCollection data = new ElementCollection("data");
```

## Import data
As discussed in [Input data (API)](#input-data-api), we use an API of a cloud server to receive the data about the planets. The information we use for this example can be received as follows:
```java
Server server = new Server("https://api.le-systeme-solaire.net/rest/bodies/");
String response = server.sendGETRequest(server.getUrl());
JsonObject parsed = JsonParser.parseString(response).getAsJsonObject();
JsonArray bodiesAr = parsed.getAsJsonArray("bodies");
```

## Title slide
The template title slide contains a normal tag for the title `{main_title}` and a hyperlink-tag `{*data_source}`. Now we need to add the data for these tags in our code by creating a Cloud Office Print element (property and hyperlink) and adding this to the main data collection:
```java
// Add the title to the data
data.addElement(new Property("main_title", "The solar system"));

// Add the source for the data
data.addElement(new HyperLink("data_source", "Data source", "https://api.le-systeme-solaire.net/rest/bodies/"));
```
The tag `{main_title}` will be replaced by 'The solar system' and the tag `{*data_source}` will be replaced by the text 'Data source' and this text will have a hyperlink to the URL 'https://docs.spacexdata.com'.

## Planets
The data for the planets needs to be put in a loop-element so that the Cloud Office Print server can iterate over all the planets. We also process the body-array so that we only have the bodies that are planets in our data.
```java
List<ElementCollection> planetList = new ArrayList<ElementCollection>();

for (JsonElement body : bodiesAr) {
    JsonObject json = (JsonObject) body;
    if (json.get("isPlanet").getAsBoolean() == true) {
        ElementCollection coll = ElementCollection.makeCollectionFromJson("not_used", json);
        planetList.add(coll);
    }
}

Loop planets = new Loop("planets", planetList.toArray(new ElementCollection[0]));
data.addElement(planets);
```

## Chart
Finally we need to add the data for the planet radius chart. A chart consists of one or more data series. We want the chart to be a 3D pie chart, so we first create a `PieSeries` with the name of the planets on the x-axis and their radius on the y-axis. 
```java
String[] color = new String[planetList.size()];
color[0] = "#7298d4"; // Specify the color for the first pie slice

JsonObject planetsJson = planets.getJSON();
JsonArray planetsArray = (JsonArray) planetsJson.get(planets.getName());
String[] planetNames = new String[planetsArray.size()];
String[] planetRadius = new String[planetsArray.size()];

for (int i = 0; i < planetsArray.size(); i++) {
    String rawName = ((JsonObject) planetsArray.get(i)).get("name").toString();
    String rawRadius = ((JsonObject) planetsArray.get(i)).get("equaRadius").toString();
    planetNames[i] = rawName.substring(1, rawName.length() - 1);
    planetRadius[i] = rawRadius.substring(1, rawRadius.length() - 1);
}

PieSeries radiusSeries = new PieSeries("radius", planetNames, planetRadius, color);
```
We then create options for the pie chart. We disable the border around the chart and specify the color of the chart legend's text:
```java
ChartOptions radiusChartOptions = new ChartOptions();
radiusChartOptions.setBorder(false);

radiusChartOptions.setLegend(null, new ChartTextStyle(null, null, "black", null));
```
Finally, we create the 3D pie chart itself and add it to the element collection:
```java
Pie3DChart radiusChart = new Pie3DChart("planet_radius_chart", radiusChartOptions, radiusSeries);
data.addElement(radiusChart);
```

# Cloud Office Print server and response
Now that we have the template and the data ready, it is time to let Cloud Office Print merge them together. In the SDK this is implemented by creating a print job:
```java
// Load template
Base64Resource base64Resource = new Base64Resource();
InputStream resourceAsStream;
if (templatetype == "docx") {
    resourceAsStream = getClass().getResourceAsStream("/SolarSystem/solar_system_template.docx");
} else {
    resourceAsStream = getClass().getResourceAsStream("/SolarSystem/solar_system_template.pptx");
}
byte[] targetArray = new byte[resourceAsStream.available()];
resourceAsStream.read(targetArray);
String encodedString = Base64.getEncoder().encodeToString(targetArray);
base64Resource.setFileBase64(encodedString);
if (templatetype == "docx") {
    base64Resource.setFiletype("docx");
    base64Resource.setMimeType(Mimetype.getMimeType("docx"));
} else {
    base64Resource.setFiletype("pptx");
    base64Resource.setMimeType(Mimetype.getMimeType("pptx"));
}

// Create print job
Output output = new Output("pdf", "raw", "libreoffice", null, null, null, null);
Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
dataTable.put("data", data);
PrintJob printjob = new PrintJob(dataTable, copServer, output, base64Resource, null, null, null, null);
```
We loaded the template from a local file and passed in our data element collection and our server object.

Finally we actually send this printjob to a Cloud Office Print server and save the response into our output file:
```java
printjob.execute().downloadLocally("./downloads/SolarSystem");
```
The resulting file can now be found in the specified folder.

# Result
For the "pptx" output file, we will not add the result in this text, but the output file can be found in the folder of this example. The "docx" output file will look like this:

<img src="https://raw.githubusercontent.com/United-Codes/cloudofficeprint-java/main/cloudofficeprint/src/main/java/com/cloudofficeprint/Examples/SolarSystem/imgs/docx_result.png" width="600" />
