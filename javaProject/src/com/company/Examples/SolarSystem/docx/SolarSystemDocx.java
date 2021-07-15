package com.company.Examples.SolarSystem.docx;

import com.company.Output.Output;
import com.company.PrintJob;
import com.company.RenderElements.Charts.Charts.Pie3DChart;
import com.company.RenderElements.Charts.Series.PieSeries;
import com.company.RenderElements.ElementCollection;
import com.company.RenderElements.HyperLink;
import com.company.RenderElements.Images.ImageUrl;
import com.company.RenderElements.Loops.Loop;
import com.company.RenderElements.RawJsonArray;
import com.company.RenderElements.RenderElement;
import com.company.Resources.Base64Resource;
import com.company.Response;
import com.company.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Hashtable;

public class SolarSystemDocx {

    public void main(String APIKey) throws Exception {

        //Get solar system data
        Server server =new Server("https://api.le-systeme-solaire.net/rest/bodies/");
        String response = server.sendGETRequest(server.getUrl());
        JsonObject parsed = JsonParser.parseString(response).getAsJsonObject();
        JsonArray bodiesAr = parsed.getAsJsonArray("bodies");


        ElementCollection planetData = new ElementCollection("data");

        ArrayList<String> planets = new ArrayList<>();
        ArrayList<String> radius = new ArrayList<>();
        for (JsonElement body : bodiesAr){
            JsonObject json = (JsonObject) body;
            if (json.get("isPlanet").getAsBoolean()==true){
                planets.add(json.get("name").getAsString());
                radius.add(json.get("meanRadius").getAsString());
            }
        }

        String[] colors = new String[bodiesAr.size()];
        colors[0] = "blue"; //minimum one color needs to be specified. Doesn't work otherwise.

        PieSeries pieSeries = new PieSeries("Mass",planets.toArray(new String[0]),radius.toArray(new String[0]),colors);
        Pie3DChart pie3DChart = new Pie3DChart("planet_radius_chart",null,pieSeries);
        planetData.addElement(pie3DChart);

        Loop bodyLoop = new Loop("bodies");
        for (JsonElement json : bodiesAr){
            JsonObject body = (JsonObject) json;
            ElementCollection coll = ElementCollection.makeCollectionFromJson("body",body);
            bodyLoop.addElement(coll);
        }
        planetData.addElement(bodyLoop);


        Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
        data.put("planetData",planetData);

        //Set-Up AOP Server
        Server aopServer = new Server("http://apexofficeprint.com/dev/");
        aopServer.setVerbose(true);
        aopServer.setAPIKey(APIKey);

        Base64Resource base64Resource = new Base64Resource();
        base64Resource.setFileFromLocalFile("./src/com/company/Examples/SolarSystem/docx/solar_system_template.docx");

        Output output = new Output("pdf","raw","libreoffice",null,null,null);
        PrintJob printJob = new PrintJob(data,aopServer,output,base64Resource,null,null,null,null);

        Response responseAOP = printJob.execute();
        responseAOP.downloadLocally("./downloads/SolarSystem");
    }
}
