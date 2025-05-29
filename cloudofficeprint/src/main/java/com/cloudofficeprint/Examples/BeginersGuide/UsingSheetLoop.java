package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.*;
import com.cloudofficeprint.RenderElements.Loops.Loop;
import com.cloudofficeprint.RenderElements.Loops.SheetLoop;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class UsingSheetLoop {
    public void main() throws Exception {
        System.out.println("I am Using Sheet lOOp example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingLoop/sheet_temp.xlsx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("xlsx");
        template.setMimeType(Mimetype.getMimeType("xlsx"));

        // Set Cloud Office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");


        // Create the main collection
        ElementCollection data = new ElementCollection("data");

        // Customer 1
        ElementCollection element1 = new ElementCollection("element1");
        element1.addElement(new Property("cust_first_name", "John"));
        element1.addElement(new Property("cust_last_name", "Smith"));

        ElementCollection order1_1 = new ElementCollection("order");
        order1_1.addElement(new Property("order_name", "Office Supplies"));
        order1_1.addElement(new Property("order_total", "$525.00"));

        ElementCollection order1_2 = new ElementCollection("order");
        order1_2.addElement(new Property("order_name", "Electronics"));
        order1_2.addElement(new Property("order_total", "$1,299.99"));

        ElementCollection order1_3 = new ElementCollection("order");
        order1_3.addElement(new Property("order_name", "Furniture"));
        order1_3.addElement(new Property("order_total", "$2,450.00"));

        Loop ordersLoop1 = new Loop("orders", new ElementCollection[]{order1_1, order1_2, order1_3});
        element1.addElement(ordersLoop1);

        // Customer 2
        ElementCollection element2 = new ElementCollection("element2");
        element2.addElement(new Property("cust_first_name", "Sarah"));
        element2.addElement(new Property("cust_last_name", "Johnson"));

        ElementCollection order2_1 = new ElementCollection("order");
        order2_1.addElement(new Property("order_name", "Software License"));
        order2_1.addElement(new Property("order_total", "$899.00"));

        ElementCollection order2_2 = new ElementCollection("order");
        order2_2.addElement(new Property("order_name", "IT Support"));
        order2_2.addElement(new Property("order_total", "$750.00"));

        Loop ordersLoop2 = new Loop("orders", new ElementCollection[]{order2_1, order2_2});
        element2.addElement(ordersLoop2);

        ArrayList<RenderElement> elements = new ArrayList<>();
        elements.add(element1);
        elements.add(element2);

        SheetLoop sheetLoop = new SheetLoop("customers", elements);
        data.addElement(sheetLoop);

        Output conf = new Output("xlsx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/usingLoop/sheet_output");
    }
}