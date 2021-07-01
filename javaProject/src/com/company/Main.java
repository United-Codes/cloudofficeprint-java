package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.company.Output.Output;
import com.company.RenderElements.AOPChart;
import com.company.RenderElements.Property;
import com.company.RenderElements.RenderElement;
import com.company.Resources.Base64Resource;
import com.company.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        try {
            System.out.println("hello world");

            Server server = new Server("http://localhost:8010","1C511A58ECC73874E0530100007FD01A",null,null,null,null,null);
            Output output = new Output("pdf","raw",null,null,null,null);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/templateTest.docx");


            Property property = new Property("first_name","DemoName");
            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output",property);


            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null);

            //System.out.println("MyJson : " + printJob.getJSON());

            String ret = server.readJson("./src/test.json");
            JsonObject jsonObject = new JsonParser().parse(ret).getAsJsonObject();
            server.sendPOSTRequest(jsonObject);
            //System.out.println("Correct Json : " + jsonObject);
            //JSONAssert.assertEquals(printJob.getJSON().get("template").toString(), jsonObject.get("template").toString(), false);

            //Response response = printJob.execute();
            //response.downloadLocally("./downloads/output");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
