package com.CloudOfficePrint.Examples.SolarSystem.pptx;

import com.CloudOfficePrint.Output.Output;
import com.CloudOfficePrint.PrintJob;
import com.CloudOfficePrint.RenderElements.*;
import com.CloudOfficePrint.RenderElements.Loops.Loop;
import com.CloudOfficePrint.Resources.Base64Resource;
import com.CloudOfficePrint.Response;
import com.CloudOfficePrint.Server.Server;
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

        //Main collection that will hold all the data.
        ElementCollection planetData = new ElementCollection("data");

        //Add a property to the data.
        planetData.addElement(new Property("main_title","The solar system"));

        //Add planets to a loop of planets.
        Loop planetsLoop = new Loop("planets");
        for (JsonElement body : bodiesAr){
            JsonObject bodyjson = (JsonObject) body;
            if (bodyjson.get("isPlanet").getAsBoolean()){
                ElementCollection coll = ElementCollection.makeCollectionFromJson("body",bodyjson);
                planetsLoop.addElement(coll);
            }
        }
        //Add the loop to the data.
        planetData.addElement(planetsLoop);

        //Will create one output.
        Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
        data.put("planetData",planetData);

        //Set-Up AOP Server
        Server aopServer = new Server("http://apexofficeprint.com/dev/");
        aopServer.setVerbose(true);
        aopServer.setAPIKey(APIKey);

        //Define template.
        Base64Resource base64Resource = new Base64Resource();
        base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/SolarSystem/pptx/solar_system_template.pptx");

        //Define output options.
        Output output = new Output(null,"raw","libreoffice",null,null,null);
        PrintJob printJob = new PrintJob(data,aopServer,output,base64Resource,null,null,null,null);

        Response responseAOP = printJob.execute();
        responseAOP.downloadLocally("./downloads/SolarSystem");
    }

}
