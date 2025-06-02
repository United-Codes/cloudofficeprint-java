package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Loops.Loop;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.*;

public class UsingHideSlide {
    public void main() throws Exception {
        System.out.println("I am in Using hide slide  example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingHideSlide/hide_temp.pptx");
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


        //Customer #1 ( with orders)
        ElementCollection customer1 = new ElementCollection("customer");
        customer1.addElement(new Property("sheet_name",      "John Chamling Rai"));
        customer1.addElement(new Property("cust_first_name", "John"));
        customer1.addElement(new Property("cust_last_name",  "Chamling Rai"));
        customer1.addElement(new Property("cust_city",       "Dharan"));

        // Build Order for Customer #1
        Hashtable<String, String> order1Info = new Hashtable<>();
        order1Info.put("order_name",  "Order 1");
        order1Info.put("order_total", "2380");
        order1Info.put("order_nb",      "1001");
        ElementCollection order1 = new ElementCollection("order");
        order1.addFromDict(order1Info);

        // Build Order #2
        Hashtable<String, String> order2Info = new Hashtable<>();
        order2Info.put("order_name",  "Order 2");
        order2Info.put("order_total", " 905");
        order2Info.put("oder_nb",      "1002");
        ElementCollection order2 = new ElementCollection("order");
        order2.addFromDict(order2Info);

        // Wrap the two orders into a Loop
        Loop ordersLoop1 = new Loop("orders", new ElementCollection[] { order1, order2 });
        customer1.addElement(ordersLoop1);

        // Customer #2 (slide will hidden)
        ElementCollection customer2 = new ElementCollection("customer");
        customer2.addElement(new Property("sheet_name",      "Purna Rai"));
        customer2.addElement(new Property("cust_first_name", "Purna"));
        customer2.addElement(new Property("cust_last_name",  "Rai"));
        customer2.addElement(new Property("cust_city",       "Kathmandu"));

        // To trigger {hide !orders}, set to "orders"to null so that slide will be hiden
        customer2.addElement(new Property("orders", (String) null));

        // Wrap both customers into a Loop
        RenderElement[] allCustomers = new ElementCollection[] { customer1, customer2 };
        Loop customersLoop = new Loop("customers", allCustomers);
        data.addElement(customersLoop);

        Output conf = new Output("pptx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/UsingHideSlide/hide_output");
    }}