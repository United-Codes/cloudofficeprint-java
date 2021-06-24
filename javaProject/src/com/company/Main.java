package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.company.Output.Output;
import com.company.RenderElements.Element;
import com.company.RenderElements.RenderElement;
import com.company.Resources.Base64Resource;
import com.company.Server.Server;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        try {
            System.out.println("hello world");

            Server server = new Server("http://localhost:8010","1C511A58ECC73874E0530100007FD01A",null,null,null);
            Output output = new Output("pdf","raw",null,null,null,null);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/templateTest.docx");

            Element file = new Element("output", " [{\"first_name\":\"DemoName\",\"last_name\":\"DemoLastName\",\"city\":\"DemoCity\"}] ");
            Hashtable<String, RenderElement> test = new Hashtable<String, RenderElement>();
            test.put(file.getName(),file);

            PrintJob printJob = new PrintJob(test,server,output,base64Resource,null,null,null);

            System.out.println("MyJson : " + printJob.getJSON());

            String ret = server.readJson("./src/test.json");
            JsonObject jsonObject = new JsonParser().parse(ret).getAsJsonObject();
            System.out.println("Correct Json : " + jsonObject);

            System.out.println("Mine : " + printJob.getJSON().get("files").toString().replace("\\\"","\""));
            System.out.println("Correct : " + jsonObject.get("files"));
            //JSONAssert.assertEquals(printJob.getJSON().get("template").toString(), jsonObject.get("template").toString(), false);

            Response response = printJob.execute();
            //response.downloadLocally("./downloads/output");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
