package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Loops.InlineDataLoop;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class UsingDistribute {
    public void main() throws Exception {
        System.out.println("I am in UsingDistribute");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingDistribute/template.docx");
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

        // Main elementCollection
        ElementCollection data = new ElementCollection("data");

        // product a list
        ArrayList<RenderElement> productAList = new ArrayList<>();
        for (String name : new String[]{"Business Shirt", "Trousers", "Jacket", "Blouse"}) {
            ElementCollection prod = new ElementCollection("product_a");
            Hashtable<String, String> prodData = new Hashtable<>();
            prodData.put("product_name", name);
            prod.addFromDict(prodData);
            productAList.add(prod);
        }
        InlineDataLoop productALoop = new InlineDataLoop("product_a", productAList);
        data.addElement(productALoop);

        // product b list with distribute
        ArrayList<RenderElement> productBList = new ArrayList<>();
        String[][] productBData = {
                {"Ladies Shoes", "120", "Womens"},
                {"Belt", "30", "Accessories"},
                {"Bag", "125", "Accessories"},
                {"Mens Shoes", "110", "Mens"}
        };
        for (String[] item : productBData) {
            ElementCollection prod = new ElementCollection("product_b");
            Hashtable<String, String> prodData = new Hashtable<>();
            prodData.put("product_name", item[0]);
            prodData.put("price", item[1]);
            prodData.put("category", item[2]);
            prod.addFromDict(prodData);
            productBList.add(prod);
        }
        InlineDataLoop productBLoop = new InlineDataLoop("product_b", productBList);
        productBLoop.setDistribute(true);
        data.addElement(productBLoop);

        // orders list
        ArrayList<RenderElement> ordersList = new ArrayList<>();

        // Order 1
        ElementCollection order1 = new ElementCollection("orders");
        Hashtable<String, String> order1Info = new Hashtable<>();
        order1Info.put("order_name", "Order 1");
        order1Info.put("order_total", "2380");
        order1.addFromDict(order1Info);
        ArrayList<RenderElement> order1Products = new ArrayList<>();
        String[][] order1Items = {
                {"Business Shirt", "3", "50"},
                {"Trousers", "3", "80"},
                {"Jacket", "3", "150"},
                {"Blouse", "3", "60"}
        };
        for (String[] item : order1Items) {
            ElementCollection p = new ElementCollection("product");
            Hashtable<String, String> pData = new Hashtable<>();
            pData.put("product_name", item[0]);
            pData.put("quantity", item[1]);
            pData.put("unit_price", item[2]);
            p.addFromDict(pData);
            order1Products.add(p);
        }
        InlineDataLoop order1Loop = new InlineDataLoop("product", order1Products);
        order1.addElement(order1Loop);
        ordersList.add(order1);

        //Order 2
        ElementCollection order2 = new ElementCollection("orders");
        Hashtable<String, String> order2Info = new Hashtable<>();
        order2Info.put("order_name", "Order 2");
        order2Info.put("order_total", "1640");
        order2.addFromDict(order2Info);
        ArrayList<RenderElement> order2Products = new ArrayList<>();
        String[][] order2Items = {
                {"Blouse", "4", "60"},
                {"Skirt", "4", "80"},
                {"Ladies Shoes", "4", "120"},
                {"Bag", "4", "125"}
        };
        for (String[] item : order2Items) {
            ElementCollection p = new ElementCollection("product");
            Hashtable<String, String> pData = new Hashtable<>();
            pData.put("product_name", item[0]);
            pData.put("quantity", item[1]);
            pData.put("unit_price", item[2]);
            p.addFromDict(pData);
            order2Products.add(p);
        }
        InlineDataLoop order2Loop = new InlineDataLoop("product", order2Products);
        order2.addElement(order2Loop);
        ordersList.add(order2);

        // Order3
        ElementCollection order3 = new ElementCollection("orders");
        Hashtable<String, String> order3Info = new Hashtable<>();
        order3Info.put("order_name", "Order 3");
        order3Info.put("order_total", "730");
        order3.addFromDict(order3Info);
        ArrayList<RenderElement> order3Products = new ArrayList<>();
        String[][] order3Items = {
                {"Blouse", "4", "60"},
                {"Skirt", "3", "80"},
                {"Bag", "2", "125"}
        };
        for (String[] item : order3Items) {
            ElementCollection p = new ElementCollection("product");
            Hashtable<String, String> pData = new Hashtable<>();
            pData.put("product_name", item[0]);
            pData.put("quantity", item[1]);
            pData.put("unit_price", item[2]);
            p.addFromDict(pData);
            order3Products.add(p);
        }
        InlineDataLoop order3Loop = new InlineDataLoop("product", order3Products);
        order3.addElement(order3Loop);
        ordersList.add(order3);

        // Add all orders
        InlineDataLoop ordersLoop = new InlineDataLoop("orders", ordersList);
        data.addElement(ordersLoop);

        // Configure output
        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);

        //  print job
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save response to file
        response.downloadLocally("./downloads/BeginnerGuide/usingDistribute/output");
    }
}
