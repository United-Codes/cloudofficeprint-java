package com.company.Examples;

import com.company.AOPException;
import com.company.Output.Output;
import com.company.Output.PDFOptions;
import com.company.PrintJob;
import com.company.RenderElements.ElementCollection;
import com.company.RenderElements.Images.ImageBase64;
import com.company.RenderElements.Property;
import com.company.RenderElements.RenderElement;
import com.company.Resources.Base64Resource;
import com.company.Response;
import com.company.Server.Server;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Hashtable;

public class Examples {

    /**
     * Example where the local test.json is read and send to the server. The output is downloaded in downloads and named outputLocalJson.
     */
    public void localJson(){
        try {
            Server server = new Server("http://localhost:8010","1C511A58ECC73874E0530100007FD01A",null,
                    null,null,null,null);
            String ret = server.readJson("./src/com/company/Examples/test.json");
            JsonObject jsonObject = new JsonParser().parse(ret).getAsJsonObject();
            Response response = server.sendPOSTRequest(jsonObject);
            response.downloadLocally("./downloads/outputLocalJson");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Example with templateTest.docx as template, a list of properties and an image as data. A zipfile named outputLocalTemplate will contain
     * 2 outputs files in the downloads folder.
     */
    public void localTemplate(){
        try {
            Server server = new Server("http://localhost:8010","1C511A58ECC73874E0530100007FD01A",null,
                    null,null,null,null);
            PDFOptions pdfOptions = new PDFOptions();
            pdfOptions.setReadPassword("hello");
            Output output = new Output("pdf","raw",null,null,null,pdfOptions);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/templateTest.docx");

            Property property1 = new Property("first_name","Quent");
            Property property2 = new Property("last_name","Stroob");
            Property property3 = new Property("city","Leuven");
            ImageBase64 image = new ImageBase64("imageTag");
            image.setFileFromLocalFile("./src/com/company/Examples/test.jpg");
            image.setMaxWidth(500);
            image.setRotation(75);
            ArrayList<RenderElement> dataList =  new ArrayList<RenderElement>();
            dataList.add(property1);
            dataList.add(property2);
            dataList.add(property3);
            //dataList.add(image);
            ElementCollection data1 = new ElementCollection("data1",dataList);

            Hashtable<String, String> propertyDict = new Hashtable<String, String>();
            propertyDict.put("first_name","B");
            propertyDict.put("last_name","A");
            propertyDict.put("city","C");
            ElementCollection data2 = new ElementCollection("data2");
            data2.setFromDict(propertyDict);
            //data2.addElement(image);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1",data1);
            data.put("output2",data2);

            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputLocalTemplate");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
