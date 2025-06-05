package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.PptxShapeRemove;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingShapeRemove {
    public void main() throws Exception {
        System.out.println("I am in Using Shape Remove example");
        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingShapeRemove/shapeRemove_temp.pptx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("pptx");
        template.setMimeType(Mimetype.getMimeType("pptx"));

        // Set Cloud Office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");


        // Create the main collection
        ElementCollection data = new ElementCollection("data");

        // Add shape remove elements
        PptxShapeRemove greeting = new PptxShapeRemove("greeting", "Hello World, Thank you for using AOP");
        PptxShapeRemove remove = new PptxShapeRemove("remove", "false");
        PptxShapeRemove quote = new PptxShapeRemove("toShow", "When in doubt, look intelligent. - GARRISON KEILLOR");

        data.addElement(greeting);
        data.addElement(remove);
        data.addElement(quote);

        Output conf = new Output("pptx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/UsingShapeRemove/shape_remove_output");
    }}