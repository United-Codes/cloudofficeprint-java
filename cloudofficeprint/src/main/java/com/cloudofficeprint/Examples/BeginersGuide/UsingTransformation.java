package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.RawJsonArray;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Server.Server;
import com.cloudofficeprint.TransformationFunction;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.Response;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingTransformation {
    public void runExample() throws Exception {
        // Load template file
        Base64Resource template = new Base64Resource();
        InputStream tplStream = UsingTransformation.class.getResourceAsStream("/BeginnerGuide/UsingTransformation/template.docx");
        byte[] tplBytes = new byte[tplStream.available()];
        tplStream.read(tplBytes);
        String encoded = Base64.getEncoder().encodeToString(tplBytes);
        template.setFileBase64(encoded);
        template.setFiletype("docx");
        template.setMimeType(Mimetype.getMimeType("docx"));

        // Configure server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        // product array
        JsonArray productItems = new JsonArray();

        JsonObject shirt = new JsonObject();
        shirt.addProperty("product_name", "Business Shirt");
        shirt.addProperty("quantity", 3);
        shirt.addProperty("unit_price", 50);
        shirt.addProperty("category", "Mens");
        productItems.add(shirt);
        JsonObject trousers = new JsonObject();
        trousers.addProperty("product_name", "Trousers");
        trousers.addProperty("quantity", 3);
        trousers.addProperty("unit_price", 80);
        trousers.addProperty("category", "Mens");
        productItems.add(trousers);
        JsonObject jacket = new JsonObject();
        jacket.addProperty("product_name", "Jacket");
        jacket.addProperty("quantity", 3);
        jacket.addProperty("unit_price", 150);
        jacket.addProperty("category", "Mens");
        productItems.add(jacket);
        JsonObject mensShoes = new JsonObject();
        mensShoes.addProperty("product_name", "Mens Shoes");
        mensShoes.addProperty("quantity", 2);
        mensShoes.addProperty("unit_price", 110);
        mensShoes.addProperty("category", "Mens");
        productItems.add(mensShoes);
        JsonObject blouse = new JsonObject();
        blouse.addProperty("product_name", "Blouse");
        blouse.addProperty("quantity", 3);
        blouse.addProperty("unit_price", 60);
        blouse.addProperty("category", "Womens");
        productItems.add(blouse);
        JsonObject skirt = new JsonObject();
        skirt.addProperty("product_name", "Skirt");
        skirt.addProperty("quantity", 3);
        skirt.addProperty("unit_price", 80);
        skirt.addProperty("category", "Womens");
        productItems.add(skirt);
        JsonObject ladiesShoes = new JsonObject();
        ladiesShoes.addProperty("product_name", "Ladies Shoes");
        ladiesShoes.addProperty("quantity", 2);
        ladiesShoes.addProperty("unit_price", 120);
        ladiesShoes.addProperty("category", "Womens");
        productItems.add(ladiesShoes);
        JsonObject belt = new JsonObject();
        belt.addProperty("product_name", "Belt");
        belt.addProperty("quantity", 2);
        belt.addProperty("unit_price", 50);
        belt.addProperty("category", "Accessories");
        productItems.add(belt);
        JsonObject bag = new JsonObject();
        bag.addProperty("product_name", "Bag");
        bag.addProperty("quantity", 4);
        bag.addProperty("unit_price", 125);
        bag.addProperty("category", "Accessories");
        productItems.add(bag);
        JsonObject wallet = new JsonObject();
        wallet.addProperty("product_name", "Wallet");
        wallet.addProperty("quantity", 2);
        wallet.addProperty("unit_price", 50);
        wallet.addProperty("category", "Accessories");
        productItems.add(wallet);
//product array
        RawJsonArray productArray = new RawJsonArray("product", productItems);

        ElementCollection dataContent = new ElementCollection("data");
        dataContent.addElement(new Property("cust_first_name", "John"));
        dataContent.addElement(new Property("cust_last_name",  "Dullas"));
        dataContent.addElement(productArray);


        // Transformation Function
        String js = getTransformationFunction();
        TransformationFunction tf = new TransformationFunction(js, null);

        Output conf = new Output("pdf", "raw", "libreoffice", null, null, null, null);

        // Print job
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", dataContent);

        PrintJob job = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        job.setTransformationFunction(tf);

        Response resp = job.execute();
        resp.downloadLocally("./downloads/BeginnerGuide/UsingTransformation/output");
        System.out.println("PDF downloaded ");
    }

    private static String getTransformationFunction() {
        return """
            function generateProductRows(products, category) {
                return products
                    .filter(product => product.category === category)
                    .map(product => {
                        if (category === "Mens") {
                            product.category_bold = "true";
                            product.product_name_font_color = "blue";
                        } else {
                            product.category_italic = "true";
                            product.product_name_font_color = "red";
                        }
                        const totalCost = product.unit_price * product.quantity;
                        return `
                            <tr>
                                <td style="border:1px solid black;padding:8px;">${product.product_name}</td>
                                <td style="border:1px solid black;padding:8px;">${product.unit_price}</td>
                                <td style="border:1px solid black;padding:8px;">${product.quantity}</td>
                                <td style="border:1px solid black;padding:8px;">${totalCost}</td>
                            </tr>
                        `;
                    })
                    .join('');
            }

            function transform() {
                files.forEach(file => {
                    let data = file.data;
                    const headers = `
                        <tr>
                            <th style="border:1px solid black;padding:8px;">Product Name</th>
                            <th style="border:1px solid black;padding:8px;">Unit Price</th>
                            <th style="border:1px solid black;padding:8px;">Quantity</th>
                            <th style="border:1px solid black;padding:8px;">Total Cost</th>
                        </tr>
                    `;

                    // Mens table
                    let mensTable = '<table style="width:100%;border:2px solid blue;border-collapse:collapse;">'
                                  + headers
                                  + generateProductRows(data.product, "Mens")
                                  + '</table>';

                    // Womens table
                    let womensTable = '<table style="width:100%;border:2px solid red;border-collapse:collapse;">'
                                    + headers
                                    + generateProductRows(data.product, "Womens")
                                    + '</table>';

                    // Totals
                    const mensTotals = data.product
                        .filter(p => p.category === "Mens")
                        .reduce((t, p) => ({ quantity: t.quantity + p.quantity, cost: t.cost + p.unit_price * p.quantity }), {quantity:0, cost:0});
                    const womensTotals = data.product
                        .filter(p => p.category === "Womens")
                        .reduce((t, p) => ({ quantity: t.quantity + p.quantity, cost: t.cost + p.unit_price * p.quantity }), {quantity:0, cost:0});

                    // Inject into data
                    data.mens_products = mensTable;
                    data.womens_products = womensTable;
                    data.mens_total_quantity  = mensTotals.quantity;
                    data.mens_total_cost      = mensTotals.cost;
                    data.womens_total_quantity = womensTotals.quantity;
                    data.womens_total_cost     = womensTotals.cost;
                });
                return files;
            }
            """;
    }
}