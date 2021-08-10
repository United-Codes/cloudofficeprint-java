package com.CloudOfficePrint.Examples.SolarSystem.docx;

import com.CloudOfficePrint.Mimetype;
import com.CloudOfficePrint.Output.Output;
import com.CloudOfficePrint.PrintJob;
import com.CloudOfficePrint.RenderElements.Charts.Charts.Pie3DChart;
import com.CloudOfficePrint.RenderElements.Charts.Series.PieSeries;
import com.CloudOfficePrint.RenderElements.ElementCollection;
import com.CloudOfficePrint.RenderElements.Loops.Loop;
import com.CloudOfficePrint.RenderElements.RenderElement;
import com.CloudOfficePrint.Resources.Base64Resource;
import com.CloudOfficePrint.Response;
import com.CloudOfficePrint.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class SolarSystemDocx {

    public void main(String APIKey) throws Exception {

        //Get solar system data
        Server server =new Server("https://api.le-systeme-solaire.net/rest/bodies/");
        String response = server.sendGETRequest(server.getUrl());
        JsonObject parsed = JsonParser.parseString(response).getAsJsonObject();
        JsonArray bodiesAr = parsed.getAsJsonArray("bodies");

        //Main collection that will contain all the data.
        ElementCollection planetData = new ElementCollection("data");

        //Parsing the data in a list of planets and a list of radius.
        ArrayList<String> planets = new ArrayList<>();
        ArrayList<String> radius = new ArrayList<>();
        for (JsonElement body : bodiesAr){
            JsonObject json = (JsonObject) body;
            if (json.get("isPlanet").getAsBoolean()==true){
                planets.add(json.get("name").getAsString());
                radius.add(json.get("meanRadius").getAsString());
            }
        }

        //Defining an array of colors for the series.
        String[] colors = new String[bodiesAr.size()];
        colors[0] = "blue"; //minimum one color needs to be specified. Doesn't work otherwise.

        //Creating the series and the chart.
        PieSeries pieSeries = new PieSeries("Mass",planets.toArray(new String[0]),radius.toArray(new String[0]),colors);
        Pie3DChart pie3DChart = new Pie3DChart("planet_radius_chart",null,pieSeries);
        planetData.addElement(pie3DChart);

        //Adding the bodies to a loop and adding this loop to the data.
        Loop bodyLoop = new Loop("bodies");
        for (JsonElement json : bodiesAr){
            JsonObject body = (JsonObject) json;
            ElementCollection coll = ElementCollection.makeCollectionFromJson("body",body);
            bodyLoop.addElement(coll);
        }
        planetData.addElement(bodyLoop);

        //Defining one output.
        Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
        data.put("planetData",planetData);

        //Set-Up AOP Server
        Server aopServer = new Server("https://api.apexofficeprint.com/");
        aopServer.setVerbose(true);
        aopServer.setAPIKey(APIKey);

        Base64Resource base64Resource = new Base64Resource();
        //The next line should normally be used by the user in his project but when the jar is exported the reference to the files don't work anymore, so there is a replacement code to make it work.
        //base64Resource.setFileFromLocalFile("./javaProject/src/com/CloudOfficePrint/Examples/SolarSystem/docx/solar_system_template.docx");
        //Begin replacement code:
        InputStream resourceAsStream = getClass().getResourceAsStream("solar_system_template.docx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        base64Resource.setFileBase64(encodedString);
        base64Resource.setFiletype("docx");
        base64Resource.setMimeType(Mimetype.getMimeType("docx"));
        //End replacement code.

        Output output = new Output("pdf","raw","libreoffice",null,null,null, null);
        PrintJob printJob = new PrintJob(data,aopServer,output,base64Resource,null,null,null,null);

        Response responseAOP = printJob.execute();
        responseAOP.downloadLocally("./downloads/SolarSystem");
    }
}
