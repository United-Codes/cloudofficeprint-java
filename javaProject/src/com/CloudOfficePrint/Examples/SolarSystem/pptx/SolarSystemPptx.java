package com.CloudOfficePrint.Examples.SolarSystem.pptx;

import com.CloudOfficePrint.Mimetype;
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

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class SolarSystemPptx {

    public void main(String APIKey) throws Exception {

        // Get solar system data
        Server server = new Server("https://api.le-systeme-solaire.net/rest/bodies/");
        String response = server.sendGETRequest(server.getUrl());
        JsonObject parsed = JsonParser.parseString(response).getAsJsonObject();
        JsonArray bodiesAr = parsed.getAsJsonArray("bodies");

        // Main collection that will hold all the data.
        ElementCollection planetData = new ElementCollection("data");

        // Add a property to the data.
        planetData.addElement(new Property("main_title", "The solar system"));

        // Add planets to a loop of planets.
        Loop planetsLoop = new Loop("planets");
        for (JsonElement body : bodiesAr) {
            JsonObject bodyjson = (JsonObject) body;
            if (bodyjson.get("isPlanet").getAsBoolean()) {
                ElementCollection coll = ElementCollection.makeCollectionFromJson("body", bodyjson);
                planetsLoop.addElement(coll);
            }
        }
        // Add the loop to the data.
        planetData.addElement(planetsLoop);

        // Will create one output.
        Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
        data.put("planetData", planetData);

        // Set-Up AOP Server
        Server aopServer = new Server("https://api.apexofficeprint.com/");
        aopServer.setVerbose(true);
        aopServer.setAPIKey(APIKey);

        // Define template.
        Base64Resource base64Resource = new Base64Resource();

        // The next line should normally be used by the user in his project but when the
        // jar is exported the reference to the files don't work anymore, so there is a
        // replacement code to make it work.
        // base64Resource.setFileFromLocalFile("./javaProject/src/com/CloudOfficePrint/Examples/SolarSystem/docx/solar_system_template.pptx");
        // Begin replacement code:
        InputStream resourceAsStream = getClass().getResourceAsStream("solar_system_template.pptx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        base64Resource.setFileBase64(encodedString);
        base64Resource.setFiletype("pptx");
        base64Resource.setMimeType(Mimetype.getMimeType("pptx"));
        // End replacement code.

        // Define output options.
        Output output = new Output(null, "raw", "libreoffice", null, null, null, null);
        PrintJob printJob = new PrintJob(data, aopServer, output, base64Resource, null, null, null, null);

        Response responseAOP = printJob.execute();
        responseAOP.downloadLocally("./downloads/SolarSystem");
    }

}
