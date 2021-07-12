package com.company.Examples.SolarSystem;

import com.company.RenderElements.Charts.Charts.Pie3DChart;
import com.company.RenderElements.Charts.Series.PieSeries;
import com.company.RenderElements.ElementCollection;
import com.company.RenderElements.Property;
import com.company.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Map;

public class SolarSystemDocx {

    public void main(){

        //Get solar system data
        Server server =new Server("https://api.le-systeme-solaire.net/rest/bodies/");
        String response = server.sendGETRequest(server.getUrl());
        JsonObject parsed = new JsonParser().parse(response).getAsJsonObject();
        JsonArray bodiesAr = parsed.getAsJsonArray("bodies");
        //System.out.println(bodiesAr);

        ElementCollection data = new ElementCollection("data");
        ArrayList<String> planets = new ArrayList<>();
        ArrayList<String> radius = new ArrayList<>();
        for (JsonElement body : bodiesAr){
            JsonObject json = (JsonObject) body;
            for (Map.Entry entry : json.entrySet()){
                data.addElement(new Property(entry.getKey().toString(),entry.getValue().toString()));
            }
            if (json.get("isPlanet").getAsBoolean()==true){
                planets.add(json.get("name").getAsString());
                radius.add(json.get("meanRadius").getAsString());
            }
        }

        PieSeries pieSeries = new PieSeries("Mass",planets.toArray(new String[0]),radius.toArray(new String[0]),null);
        System.out.println(pieSeries.getJSON());
        Pie3DChart pie3DChart = new Pie3DChart("planet_radius_chart",null,pieSeries);

        data.addElement(pie3DChart);

        //Set-Up AOP Server
        Server aopServer = new Server("http://localhost:8010");
        aopServer.setAPIKey("1C511A58ECC73874E0530100007FD01A");

    }
}
