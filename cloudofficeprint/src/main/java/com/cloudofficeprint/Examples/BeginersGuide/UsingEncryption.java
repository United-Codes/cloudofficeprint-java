package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingEncryption {
    public void main() throws Exception {
        System.out.println("I am in");
        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingEncryption/template.docx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("docx");
        template.setMimeType(Mimetype.getMimeType("docx"));


        //Set Cloud office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        //Main elementCollection that includes all the data
        ElementCollection data = new ElementCollection("data");

        //Property
        Property title = new Property("title", "Hello World!");
        Property text = new Property("text", "This is an example created with the Cloud Office Print Java SDK");
        Property text2 = new Property("text2", "This is an example created with the Cloud Office Print Java SDK");

        data.addElement(title);
        data.addElement(text);
        data.addElement(text2);

        Output conf = new Output("pdf", "raw", "libreoffice", null, null, null, null);
        conf.setOutputReadPassword("123");
        Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        //Save response to file.
        response.downloadLocally("./downloads/BeginnerGuide/usingEncryption/output");
    }
}
