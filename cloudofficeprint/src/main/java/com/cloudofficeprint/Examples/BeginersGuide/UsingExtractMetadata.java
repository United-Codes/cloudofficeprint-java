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

public class UsingExtractMetadata {
    public void main() throws Exception {
        System.out.println("I am Using Extract Metadata example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingExtractMetadata/template.docx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("docx");
        template.setMimeType(Mimetype.getMimeType("docx"));

        // Set Cloud Office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        // Create the main collection
        ElementCollection data = new ElementCollection("data");
        data.addElement(new Property("title", "Hello World!"));
        data.addElement(new Property("text", "This document is used to extract metadata."));
        Output conf = new Output("meta_data", "raw", "libreoffice", null, null, null, null);

        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Print the returned metadata and save it to a file
        System.out.println(response.asString());
        response.downloadLocally("./downloads/BeginnerGuide/UsingExtractMetadata/output");
    }
}
