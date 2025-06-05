package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.*;
import com.cloudofficeprint.RenderElements.Loops.Loop;
import com.cloudofficeprint.RenderElements.Loops.SlideLoop;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class UsingSlideLoop {
    public void main() throws Exception {
        System.out.println("I am Using Slide lOOp example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingLoop/slide_temp.pptx");
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

        // element1
        ElementCollection element1 = new ElementCollection("element1");
        element1.addElement(new Property("a", "Sales Report Q1"));
        element1.addElement(new Property("b", "Total Revenue: $125,000"));
        element1.addElement(new Property("c", "Growth: 15% YoY"));

        ElementCollection element2 = new ElementCollection("element2");
        element2.addElement(new Property("a", "Marketing Metrics Q1"));
        element2.addElement(new Property("b", "New Customers: 2,500"));
        element2.addElement(new Property("c", "Campaign ROI: 225%"));

        ElementCollection element3 = new ElementCollection("element3");
        element3.addElement(new Property("a", "Product Performance Q1"));
        element3.addElement(new Property("b", "Units Sold: 45,000"));
        element3.addElement(new Property("c", "Customer Satisfaction: 4.8/5"));

        ElementCollection element4 = new ElementCollection("element4");
        element4.addElement(new Property("a", "Support Analytics Q1"));
        element4.addElement(new Property("b", "Tickets Resolved: 3,200"));
        element4.addElement(new Property("c", "Average Response Time: 2.5h"));

        ArrayList<RenderElement> elements = new ArrayList<>();
        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        elements.add(element4);
        SlideLoop slideLoop = new SlideLoop("slideloop", elements);

        data.addElement(slideLoop);

        Output conf = new Output("pptx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/usingLoop/slide_output");
    }
}