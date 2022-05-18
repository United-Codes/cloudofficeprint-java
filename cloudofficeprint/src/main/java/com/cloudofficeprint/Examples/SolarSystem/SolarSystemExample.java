package com.cloudofficeprint.Examples.SolarSystem;

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

public class SolarSystemExample {

    /**
     * @param APIKey       Your Cloud Office Print API key
     * @param templatetype The type of the template: either "docx" or "pptx"
     * @throws Exception   if something went wrong
     */
    public void main(String APIKey, String templatetype) throws Exception {

        // Set-Up Cloud Office Print server
        Server copServer = new Server("https://api.cloudofficeprint.com");
        copServer.setVerbose(true);
        copServer.setAPIKey(APIKey);

        // Create the main element collection that contains all data
        ElementCollection data = new ElementCollection("data");

        // Add the title to the data
        data.addElement(new Property("main_title", "The solar system"));

        // Add the source for the data
        data.addElement(new HyperLink("data_source", "Data source", "https://api.le-systeme-solaire.net/rest/bodies/"));

        // Process data: we only want planets
        // Get solar system data
        Server server = new Server("https://api.le-systeme-solaire.net/rest/bodies/");
        String response = server.sendGETRequest(server.getUrl());
        JsonObject parsed = JsonParser.parseString(response).getAsJsonObject();
        JsonArray bodiesAr = parsed.getAsJsonArray("bodies");
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

        // Add planet radius chart to data
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

        ChartOptions radiusChartOptions = new ChartOptions();
        radiusChartOptions.setBorder(false);

        radiusChartOptions.setLegend(null, new ChartTextStyle(null, null, "black", null));

        Pie3DChart radiusChart = new Pie3DChart("planet_radius_chart", radiusChartOptions, radiusSeries);
        data.addElement(radiusChart);

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
        PrintJob printjob = new PrintJob(dataTable, copServer, output, base64Resource, null, null, null, null, null);
        printjob.execute().downloadLocally("./downloads/SolarSystem");
    }
}
