package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.CellSpan;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingSpan {
    public void main() throws Exception {
        System.out.println("I am in hello world");
        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingSpan/span_temp.xlsx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("xlsx");
        template.setMimeType(Mimetype.getMimeType("xlsx"));
        //Set Cloud office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");


        //Main elementCollection that includes all the data
        ElementCollection data = new ElementCollection("data");

        //Properties
        Property firstName = new Property("cust_first_name", "John");
        Property lastName = new Property("cust_last_name", "Doe");
        data.addElement(firstName);
        data.addElement(lastName);

        // Create span elements
        CellSpan span1 = new CellSpan("span", "This cell will span 2 rows and 3 columns", 3, 2);
        CellSpan span2 = new CellSpan("testSpan", "This cell will span 3 rows and 4 columns", 4, 3);

        data.addElement(span1);
        data.addElement(span2);

        Output conf = new Output("xlsx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        //Save response to file.
        response.downloadLocally("./downloads/BeginnerGuide/usingSpan/output");
    }

    }
