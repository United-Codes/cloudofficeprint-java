package com.company.Examples;

import com.company.AOPException;
import com.company.Output.Output;
import com.company.PrintJob;
import com.company.RenderElements.ElementCollection;
import com.company.RenderElements.Property;
import com.company.RenderElements.RenderElement;
import com.company.Resources.Base64Resource;
import com.company.Response;
import com.company.Server.Server;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Hashtable;

public class Examples {

    /**
     * Example where the local test.json is read and send to the server. The output is downloaded in downloads under output.
     */
    public void localJson(){
        try {
            Server server = new Server("http://localhost:8010","1C511A58ECC73874E0530100007FD01A",null,null,null,null,null);
            String ret = server.readJson("./src/com/company/Examples/test.json");
            JsonObject jsonObject = new JsonParser().parse(ret).getAsJsonObject();
            Response response = server.sendPOSTRequest(jsonObject);
            response.downloadLocally("./downloads/output");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Example with templateTest.docx as template. The output is downloaded in downloads under output.
     */
    public void localTemplate(){
        try {
            Server server = new Server("http://localhost:8010","1C511A58ECC73874E0530100007FD01A",null,null,null,null,null);
            Output output = new Output("pdf","raw",null,null,null,null);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/templateTest.docx");

            Property property = new Property("first_name","DemoName");
            //ElementCollection collection = new ElementCollection();
            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output",property);

            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/output");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
