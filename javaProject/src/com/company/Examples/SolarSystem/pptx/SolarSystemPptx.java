package com.company.Examples.SolarSystem.pptx;

import com.company.Output.Output;
import com.company.PrintJob;
import com.company.RenderElements.*;
import com.company.RenderElements.Images.ImageUrl;
import com.company.RenderElements.Loops.Loop;
import com.company.Resources.Base64Resource;
import com.company.Response;
import com.company.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Hashtable;

public class SolarSystemPptx {

    public void main(String APIKey) throws Exception {

        //Get solar system data
        Server server =new Server("https://api.le-systeme-solaire.net/rest/bodies/");
        String response = server.sendGETRequest(server.getUrl());
        JsonObject parsed = JsonParser.parseString(response).getAsJsonObject();
        JsonArray bodiesAr = parsed.getAsJsonArray("bodies");


        ElementCollection planetData = new ElementCollection("data");
        planetData.addElement(new Property("main_title","The solar system"));

        //Add planet data
        Loop planetsLoop = new Loop("planets");
        for (JsonElement body : bodiesAr){
            JsonObject bodyjson = (JsonObject) body;
            if (bodyjson.get("isPlanet").getAsBoolean()){
                ElementCollection coll = ElementCollection.makeCollectionFromJson("body",bodyjson);
                planetsLoop.addElement(coll);
            }
        }
        planetData.addElement(planetsLoop);

        Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
        data.put("planetData",planetData);

        //Set-Up AOP Server
        Server aopServer = new Server("http://apexofficeprint.com/dev/");
        aopServer.setVerbose(true);
        aopServer.setAPIKey(APIKey);

        Base64Resource base64Resource = new Base64Resource();
        base64Resource.setFileFromLocalFile("./src/com/company/Examples/SolarSystem/pptx/solar_system_template.pptx");

        Output output = new Output(null,"raw","libreoffice",null,null,null);
        PrintJob printJob = new PrintJob(data,aopServer,output,base64Resource,null,null,null,null);

        Response responseAOP = printJob.execute();
        responseAOP.downloadLocally("./downloads/SolarSystem");
    }

}
