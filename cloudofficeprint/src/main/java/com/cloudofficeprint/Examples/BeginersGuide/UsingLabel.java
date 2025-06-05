package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.*;
import com.cloudofficeprint.RenderElements.Loops.Labels;
import com.cloudofficeprint.RenderElements.Loops.SlideLoop;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class UsingLabel {
    public void main() throws Exception {
        System.out.println("I am Using Slide lOOp example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingLoop/label_temp.docx");
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

        // element1
        ElementCollection element1 = new ElementCollection("element1");
        element1.addElement(new Property("FirstName", "John"));
        element1.addElement(new Property("LastName", "Smith"));
        element1.addElement(new Property("Company", "Tech Solutions Inc."));
        element1.addElement(new Property("Address1", "123 Business Ave"));
        element1.addElement(new Property("City", "San Francisco"));
        element1.addElement(new Property("State", "CA"));
        element1.addElement(new Property("PostalCode", "94105"));

        ElementCollection element2 = new ElementCollection("element2");
        element2.addElement(new Property("FirstName", "Sarah"));
        element2.addElement(new Property("LastName", "Johnson"));
        element2.addElement(new Property("Company", "Marketing Pro LLC"));
        element2.addElement(new Property("Address1", "456 Market Street"));
        element2.addElement(new Property("City", "New York"));
        element2.addElement(new Property("State", "NY"));
        element2.addElement(new Property("PostalCode", "10013"));

        ElementCollection element3 = new ElementCollection("element3");
        element3.addElement(new Property("FirstName", "Michael"));
        element3.addElement(new Property("LastName", "Brown"));
        element3.addElement(new Property("Company", "Digital Services Co."));
        element3.addElement(new Property("Address1", "789 Innovation Blvd"));
        element3.addElement(new Property("City", "Chicago"));
        element3.addElement(new Property("State", "IL"));
        element3.addElement(new Property("PostalCode", "60601"));


        ArrayList<RenderElement> elements = new ArrayList<>();
        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        Labels label = new Labels("labels", elements);

        data.addElement(label);

        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/usingLoop/label_output");
    }
}