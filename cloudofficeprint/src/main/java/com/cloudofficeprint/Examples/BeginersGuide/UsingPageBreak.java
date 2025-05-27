package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Loops.InlineDataLoop;
import com.cloudofficeprint.RenderElements.PageBreak;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class UsingPageBreak {
    public void main() throws Exception {
        System.out.println("I am in UsingPageBreakTag example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingPageBreak/pagebreak_temp.docx");
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
        ArrayList<RenderElement> customersList = new ArrayList<>();

//customer 1
        ElementCollection customer1 = new ElementCollection("customer");
        customer1.addElement(new Property("cust_first_name", "John"));
        customer1.addElement(new Property("cust_last_name", "Dulles"));
        customer1.addElement(new PageBreak("pageBreak", "page"));

// customer 2
        ElementCollection customer2 = new ElementCollection("customer");
        customer2.addElement(new Property("cust_first_name", "William"));
        customer2.addElement(new Property("cust_last_name", "Hartsfield"));
        customer2.addElement(new PageBreak("pageBreak", "page"));

// customer 3
        ElementCollection customer3 = new ElementCollection("customer");
        customer3.addElement(new Property("cust_first_name", "Edward"));
        customer3.addElement(new Property("cust_last_name", "Logan"));
        customer3.addElement(new PageBreak("pageBreak", "false"));
// Add to list
        customersList.add(customer1);
        customersList.add(customer2);
        customersList.add(customer3);

      //Loop for customers( inline data loop)
        InlineDataLoop customersLoop = new InlineDataLoop("customers", customersList);
        data.addElement(customersLoop);

        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        //Save response to file.
        response.downloadLocally("./downloads/BeginnerGuide/usingPageBreak/output");

    }
}