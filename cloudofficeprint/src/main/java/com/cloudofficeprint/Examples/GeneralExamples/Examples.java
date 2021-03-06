package com.cloudofficeprint.Examples.GeneralExamples;

import com.cloudofficeprint.*;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.Output.PDFOptions;
import com.cloudofficeprint.RenderElements.*;
import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.Charts.*;
import com.cloudofficeprint.RenderElements.Charts.Series.ColumnSeries;
import com.cloudofficeprint.RenderElements.Charts.Series.LineSeries;
import com.cloudofficeprint.RenderElements.Codes.BarCode;
import com.cloudofficeprint.RenderElements.Codes.WifiQRCode;
import com.cloudofficeprint.RenderElements.Images.ImageBase64;
import com.cloudofficeprint.RenderElements.Images.ImageUrl;
import com.cloudofficeprint.RenderElements.Loops.Loop;
import com.cloudofficeprint.RenderElements.PDF.PDFImage;
import com.cloudofficeprint.RenderElements.PDF.PDFImages;
import com.cloudofficeprint.RenderElements.PDF.PDFText;
import com.cloudofficeprint.RenderElements.PDF.PDFTexts;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Resources.Resource;
import com.cloudofficeprint.Server.Server;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class Examples {

    /**
     * Example where the local test.json is read and send to the server. The output
     * is downloaded in downloads and named outputLocalJson.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void localJson(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null,
                    // null,null,"127.0.0.1",8000);
                    null, null, null, null);
            server.setVerbose(true);

            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/test.json");
            String ret = IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8.name());

            JsonObject jsonObject = JsonParser.parseString(ret).getAsJsonObject();
            Response response = server.sendPOSTRequest(jsonObject);
            response.downloadLocally("./downloads/outputLocalJson");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Example without template. Cloud Office Print will generate the template based
     * on the data. Output type determines the template type generated. Cannot be
     * PDF in this case.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void withoutTemplate(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);
            Output output = new Output("docx", "raw", null, null, null, null, null);

            // Main collection that holds all the data elements.
            ElementCollection data1 = new ElementCollection("data");

            // Add some properties to the data.
            Property property1 = new Property("first_name", "Quent");
            Property property2 = new Property("last_name", "Stroob");
            Property property3 = new Property("city", "Leuven");
            data1.addElement(property1);
            data1.addElement(property2);
            data1.addElement(property3);

            // Create an image.
            ImageBase64 image = new ImageBase64("imageTag");

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // image.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/test.jpg");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/test.jpg");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            image.setValue(encodedString);
            // End replacement code.

            image.setMaxWidth(500);
            image.setRotation(75);
            data1.addElement(image);

            // Need to create a hashtable with name of the output and data for the output.
            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", data1);

            PrintJob printJob = new PrintJob(data, server, output, null, null, null, null, null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputWithoutTemplate");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Example with templateTest.docx as template, a list of properties and an image
     * as data. A zipfile named outputLocalTemplate will contain 2 outputs files in
     * the downloads folder.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void localTemplate(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);

            // Set some PDF options for showing purposes.
            PDFOptions pdfOptions = new PDFOptions();
            pdfOptions.setReadPassword("hello");
            pdfOptions.setLandscape(true);
            Output output = new Output("pdf", "raw", null, null, null, pdfOptions, null);

            // Creating the template resource.
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/localTemplate.docx");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/localTemplate.docx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("docx");
            base64Resource.setMimeType(Mimetype.getMimeType("docx"));
            // End replacement code.

            // Analog as above example.
            Property property1 = new Property("first_name", "Quent");
            Property property2 = new Property("last_name", "Stroob");
            Property property3 = new Property("city", "Leuven");
            ImageBase64 image = new ImageBase64("imageTag");

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // image.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/test.jpg");
            // Begin replacement code:
            resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/test.jpg");
            targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            encodedString = Base64.getEncoder().encodeToString(targetArray);
            image.setValue(encodedString);
            // End replacement code.

            image.setMaxWidth(500);
            image.setRotation(75);

            ArrayList<RenderElement> dataList = new ArrayList<RenderElement>();
            dataList.add(property1);
            dataList.add(property2);
            dataList.add(property3);
            dataList.add(image);
            ElementCollection data1 = new ElementCollection("data1", dataList);

            // Another way to add date (from a dict).
            Hashtable<String, String> propertyDict = new Hashtable<String, String>();
            propertyDict.put("first_name", "B");
            propertyDict.put("last_name", "A");
            propertyDict.put("city", "C");
            ElementCollection data2 = new ElementCollection("data2");
            data2.addFromDict(propertyDict);
            data2.addElement(image);

            // Here we specify two different outputs so a zip file containing both of them
            // will be created.
            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", data1);
            data.put("output2", data2);

            PrintJob printJob = new PrintJob(data, server, output, base64Resource, null, null, null, null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputLocalTemplate");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Asynchronous version of the above example. Example with templateTest.docx as
     * template, a list of properties and an image as data. A zipfile named
     * outputLocalTemplate will contain 2 outputs files in the downloads folder.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void localTemplateAsync(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);
            PDFOptions pdfOptions = new PDFOptions();
            pdfOptions.setReadPassword("hello");
            pdfOptions.setLandscape(true);
            Output output = new Output("pdf", "raw", null, null, null, pdfOptions, null);
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/localTemplate.docx");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/localTemplate.docx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("docx");
            base64Resource.setMimeType(Mimetype.getMimeType("docx"));
            // End replacement code.

            Property property1 = new Property("first_name", "Quent");
            Property property2 = new Property("last_name", "Stroob");
            Property property3 = new Property("city", "Leuven");
            ImageBase64 image = new ImageBase64("imageTag");
            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // image.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/test.jpg");
            // Begin replacement code:
            resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/test.jpg");
            targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            encodedString = Base64.getEncoder().encodeToString(targetArray);
            image.setValue(encodedString);
            // End replacement code.

            image.setMaxWidth(500);
            image.setRotation(75);
            ArrayList<RenderElement> dataList = new ArrayList<RenderElement>();
            dataList.add(property1);
            dataList.add(property2);
            dataList.add(property3);
            dataList.add(image);
            ElementCollection data1 = new ElementCollection("data1", dataList);

            Hashtable<String, String> propertyDict = new Hashtable<String, String>();
            propertyDict.put("first_name", "B");
            propertyDict.put("last_name", "A");
            propertyDict.put("city", "C");
            ElementCollection data2 = new ElementCollection("data2");
            data2.addFromDict(propertyDict);
            data2.addElement(image);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", data1);
            data.put("output2", data2);

            PrintJob printJob = new PrintJob(data, server, output, base64Resource, null, null, null, null);

            Thread thread = new Thread(printJob); // This is how to run send the POST request asynchronously (because it
                                                  // can sometimes take a few seconds before getting back the response).
            thread.start();
            // System.out.println("in between");
            thread.join();
            // System.out.println("after");
            Response response = printJob.getResponse();
            response.downloadLocally("./downloads/outputLocalTemplateAsync");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * In this example 2 nested loops are given in the template. One for the orders
     * and one for the products per order.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void loopExample(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);

            Output output = new Output("pdf", "raw", null, null, null, null, null);
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/orderTemplate.docx");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/orderTemplate.docx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("docx");
            base64Resource.setMimeType(Mimetype.getMimeType("docx"));
            // End replacement code.

            // Main object that includes all the data
            ElementCollection data = new ElementCollection("data");

            // Company information
            Property companyName = new Property("company_name", "United Codes");
            ImageUrl companyLogo = new ImageUrl("company_logo",
                    "https://united-codes.com/assets/dist/images/logo-united-codes.svg");

            companyLogo.setMaxWidth(200);
            companyLogo.setMaxHeight(200);
            data.addElement(companyName);
            data.addElement(companyLogo);

            // Customer information
            Hashtable<String, String> customerInfo = new Hashtable<String, String>();
            customerInfo.put("cust_city", "Louis");
            customerInfo.put("cust_first_name", "Albertos");
            customerInfo.put("cust_last_name", "Lambert");
            data.addFromDict(customerInfo);

            // Order 1
            ElementCollection order1 = new ElementCollection("order1");
            Hashtable<String, String> orderInfo = new Hashtable<String, String>();
            orderInfo.put("order_name", "Order 1");
            orderInfo.put("order_total", "610");
            orderInfo.put("ref_nb", "5645");
            order1.addFromDict(orderInfo);

            // Product 1 for order 1
            ElementCollection product1_1 = new ElementCollection("product1");
            Hashtable<String, String> product1_1Info = new Hashtable<String, String>();
            product1_1Info.put("product_name", "Business \nShirt");
            product1_1Info.put("quantity", "3");
            product1_1Info.put("unit_price", "50");
            product1_1Info.put("in_stock", "3");
            product1_1.addFromDict(product1_1Info);
            ImageBase64 image1 = new ImageBase64("image",
                    "/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBhAQDxINEhQPEw8SEBcVEBQUEBAP\r\nFBAQFBAVFhQQFBQXGyYeFxkjGRISHy8gIygsLCwsFR8xNTwqNSYrLCkBCQoKDQoN\r\nGQwOGikeHBgpNSkpKSk0KSwpKSk0MCw0NSkpKSksMikpLC4wKSwqKSkpKSkpKjQ0\r\nKSkpKjYpNCkyKf/AABEIAGgAaAMBIgACEQEDEQH/xAAbAAACAwEBAQAAAAAAAAAA\r\nAAAABQIDBAEHBv/EADgQAAIBAgMEBgYKAwAAAAAAAAABAgMRBBIhBTFBUWFxgZGx\r\n0RMWIlKhwQYyYnKSorLh8PEUQlP/xAAUAQEAAAAAAAAAAAAAAAAAAAAA/8QAFBEB\r\nAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8A9xAAAAA43YDNjdpU6P13Z8Et\r\nW+wX+tFPhGfwQlxSdSrObu7y046cLdli+ns52vu62A19ZIe5LvRbS2/Se9Sj1q/g\r\nJqWCbbXItlhcu9PxXwA+lp1VJZk00+KJCfYtVRk6d1qsy15NLTv+A4AAAAAAAAAA\r\nAwbRx7ptRSV2r3fDsF06spJyk29G10dhbtN3qtckl8/mQy6NdAGLA1LeybZbtDBK\r\ni4u5vjVWXM2kubAoouTk1mk8u9ejyp3XCTWvYzXOqorMyFDFQnua6tz67bzLj53Q\r\nGKlXbrqb0TurLgmtPiOqGJnHc9OT1Qow1FucXykvEcTQDTDVs8VLdzXJotMWzZaS\r\nj037/wCjaAAAAAAACTFK9Sb+14JIjF2O1PrS+8/FnUwMmNxcKavLe90Vq5dSFTwO\r\nIxLTlelT4J3Vl1b2+kfwpxTbSV3vfHvJ5uICWv8ARySSdObutybt8UcpzrR0rQlZ\r\nf7LXvtvHaqABmwltJKzXQamRVJJ3sk+jS/XzJsC/Au0+uIwF1DScevxQxAAAAAAA\r\nBFU+tL7z/UyJ2b9qS+0/1M7YATLEiOQ7GNgJJO/C1tAtqSQAdsQJORyIFkXZp8mv\r\nEZiqW4aRd0nzQHQAAAjOVk29yV32EjNtCpanLp07wEyXEsvYqlVUd/8AP5clU1Vu\r\nene7AXU5XSb32JoruSTAkpq9tL8gcjmVXvxOMCRKKIRZK4EhhhneEerwFqZvwUvY\r\n6m/G/wAwNAAAAL9sJuMdbe1ustdBgKts1NYx6G+/+gF0r3XFX1emnwLL8en5lfpl\r\nxaXaV1MZDRZo3bVldcwNiJJlDrHP8gDSpHGzI8dHNk4/tcs9OBoTJJmZV0WKogLT\r\nbs6Wkl0371+wuzGzZsvaa5rwf7gMQAAAWbU2FCvJTbkmlZ21uuHQuIABi9ScM9+d\r\n9sV8jtP6E4WMlJekTTunmW/uAANi2BT96r+JeRx/R+lzqfiXkAAQ9WaV82arf7y8\r\nifq9T96r+KPkcADvq/D36nfHyBbAj79T8vkAASWxV/0qfl8i3C7OySzZ5PTc0l4A\r\nAG0AAD//2Q==");
            product1_1.addElement(image1);

            // Product 2 for order 1
            ElementCollection product2_1 = new ElementCollection("product2");
            Hashtable<String, String> product2_1Info = new Hashtable<String, String>();
            product2_1Info.put("product_name", "Trousers");
            product2_1Info.put("quantity", "2");
            product2_1Info.put("unit_price", "80");
            product2_1Info.put("in_stock", "1");
            product2_1.addFromDict(product2_1Info);
            ImageBase64 image2 = new ImageBase64("image",
                    "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsU\r\nFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5Ojf/2wBDAQoK\r\nCg0MDRoPDxo3JR8lNzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3\r\nNzc3Nzc3Nzc3Nzc3Nzf/wAARCABoAGgDASIAAhEBAxEB/8QAHAABAQACAwEBAAAA\r\nAAAAAAAAAAcBBQQGCAID/8QAPRAAAQMDAAUHCAgHAAAAAAAAAQACAwQFEQYHEiFB\r\nEyIxUWFxoSMygZGxssHRFBUXQnOiwuEINVJiY5Lw/8QAFgEBAQEAAAAAAAAAAAAA\r\nAAAAAAEC/8QAFhEBAQEAAAAAAAAAAAAAAAAAAAEx/9oADAMBAAIRAxEAPwC4IiIM\r\nrCIg02mV2msWi1zulNyRmpad0kYlBLS7gDgjioH9q+mVRkG5RQ/hUkfxBVE1/wBx\r\nmp9GKKgiJaytqgJSOLWDaA/22fUoZAcwskA+9zh2ZPzVSu1yaw9LZRz9IKvH+OKN\r\nvsYvlmmek4eyV16uLwJBzTOQCenBAxuWjiY1swjxuLNof96Av2iZtU+Cd4dg9+Qi\r\nPUdkucN5tNLcaYERVEYeA7pHWD3HIXOU51J10k1jraF7tptLUbUeTvDXjOPWD61R\r\nlGjiiIgIiIMrCIgysIiCOfxCTbQstM3pHKyeLB81HaPPloXjGDnHYVYtfcYdXWVw\r\nbl3JTA92WKPy+Sq439AcC0+1VHMjOWwv+807JXLi3Pdu3Eg56iuJT+cWg8071ywc\r\nIioajpD9PvEY6DFE71F3zVcUj1GRONZeJgeaI4mEdpLj8FXFFhxRERRERAREQZWE\r\nRBJte0flLHN+Oz3Co5eOZG2TGcOHtVs16szbrPJje2qe3Pez9lFrwM0TtyrNYo3Z\r\n2CuaOhauhf5Nh7ls3bgT1DoKCt6iTmkvO7onjH5SqmpdqIwbZd3jjUs9xVFRqHFE\r\nRAREQZWERBlYREEw16Of9WWho8w1Tye8M3fFRqtbtwFvXn2K068o9qzWx+7m1Z3Z\r\n/sKjFUPJFVm61NAc0+OIOFtXzBpZtea9vVxWotxB5RufvLZAcpA0EZLDgoLPqF/k\r\n91B4VTfcCqKleoUn6tu7DwqGe7+yqijRxREQEREBERAREQTjXfHtWC3yZI2azHfl\r\njvkopVHmY61ateJA0ftw4/Th7jlE6l2B6FUutZbqdxp6qdmTyUzGFvDnB5z+VbKl\r\ndtMeR6WkbwU0coZaux6Qzx9FGKed3aNtzT4OJ9C+WO2XZG8ObvCIsGoZ+YL207nc\r\nrC7HYWu+Sq6iOomqLdI7jS7RxLRh5Hax4H6yrco1BE4ogIiICIiAiIgm+vFubBbn\r\ndVaPccofWuPmbO8g4wrlrxZIdGKJ7Gkhla0uPVzHY8VEWkAgzOGT0AqpVE1QWMT6\r\nFaWzSAbdYx1MMjOyGxkjxf4Kd0+HxjaG9vR3KxainNqtGbzGHDZdXubu4Dk2BSSo\r\npH2+4VFHNukp3uid3tOPgg7hqdcINPI2jOZaWVvsd+lX1eeNVTj9odvA382UHu5N\r\ny9DqEETiiKIiICIiAiIg1mktlh0hsdVaql7o46hoBe0AluCCDv7QugQalLYJM1F3\r\nrXs/pjYxnjvREHdNEtEbXolST09qExE8nKSvmk2nOOMDqHgpppdq20irdIq2uoI6\r\nSaCpnfK3E+y5oJzghwHhlEQdh1eatn2G4C8XeoD65meRihflke00g7Rxzjv7h2qk\r\nIiAiIgIiIP/Z");
            product2_1.addElement(image2);

            // Product 3 for order 1
            ElementCollection product3_1 = new ElementCollection("product3");
            Hashtable<String, String> product3_1Info = new Hashtable<String, String>();
            product3_1Info.put("product_name", "Jacket");
            product3_1Info.put("quantity", "2");
            product3_1Info.put("unit_price", "150");
            product3_1Info.put("in_stock", "3");
            product3_1.addFromDict(product3_1Info);
            ImageBase64 image3 = new ImageBase64("image",
                    "/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBhQSDRUTExQTExIWFBMZERgVERAV\r\nEhkXExAWGRwVFxQYGygeIxkvHxgUHzAgJTMsLiwsFR4xNTEqNSYrLSsBCQoKBQUF\r\nDQUFDSkYEhgpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkp\r\nKSkpKSkpKSkpKf/AABEIAGgAaAMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAA\r\nAAAABwgDBAYFAgH/xAA1EAABBAEBBQUGBQUBAAAAAAABAAIDEQQhBQYHEmEiMVGB\r\nkRMUQXGhwSMyQ5KxQmRyk6Iz/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAA\r\nAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AJxREQEREBERARLRAREQEREBERAR\r\nEQEReDv1lui2VkvY4seIjyuBogkgaHx1QaW8nErEw3FhLpZRoWRgGj4OcTQPTU9F\r\nFO+PFjJyXM9g5+KxpvljkdzOsD87xXXRcdJMStO7dqg6s7/5/JXvMw79fauJojrr\r\na9/cjivJjSPZmyTZELq5Do+Rhs3q42W9L+Sj+9PJak8mtoLSbv754mb/AOEoc4Cy\r\nxwLJAPHldqR1Fhe2qn7Mz3xSNkjcWPaba5poghWm2VkmTGikNW+ONxrutzATXqg2\r\nkREBERAREQFynFGYN2Jk3pbWAdS6ZgpdWo2455/Ls+KO9ZJga8RGx30tzPogg9x7\r\n1gL1+6l7qBIa3tGtBqBZ8zXmsTe9BmbNpXosbBZX41pJ+GgWVjKKDMDQVndycjn2\r\nTiO77x4v+YwPsquTS9to6X6lWK4Q7QEmxomjvidJG7585eK6U9qDtEREBERAREQF\r\nBvHLaYdtCOMO5hFDq0EGnSPJN9eUMU5FVg37yPabWy3lv68gFaaMdya/tQaWy8a8\r\nDNl+A90b0t+Q416MXjwnVdXs+Et3cyZCCBLnY7WE9x9lE9xr5W5cswIMkQ7z1+wX\r\n04ar5iOh+evoF++zsoNna2zOSHFyG/llbMx1n9SCZ16eHI+L6qRuBu3XNy34xP4c\r\nrC9os0Hx1qB1bd/4jwXH5GI6TYgcAXDGzO1VmmZUIFnwbzxN83rY4ZZRZtnFN1cn\r\nL+9jm19UFlkREBERAREQCqv759nauYP7mf6yuP3VoFE21eEE+TtLImdLFFDJK5za\r\nDnyUa/poC/NBzm+Lmx7ubKiboHsfK4eLi0En1kd6qO7UhcXoxDNi4bXFzMfEYATV\r\n25zhZrS6Y1Ry96D6jJ1+Z+yyNdqteA9nzP8AAWTmQdvujT9i7WYTX4GO8fHWOV7v\r\n5DR5rxdy7G08TTX3nHr/AHsXW8DcZkuTlxSta+N+O0Oa4W0tEutjzXYjg9HFtGDJ\r\nxpC2JkzHvikt1Bpv8N/f3gaO9UEjoiICIiAiIgIiIIt4mcLZszJOVjva5xY1r43n\r\nlPYFAsd3eRr56qKNqbhZ8JIkxJ/m2MyN/dHYVqUQVbh4dZ3uL8o48gY1zRyljhMW\r\nkG5BHXNyjs69b7gSseztx86bVmJOR4mMsb6voK1CIIs4R8PcrCyJcjJDY+eL2bGB\r\n4c/V7XFzuXsj8tVfx+ClNEQEREBERAREQEREBERAREQEREBERAREQf/Z");
            product3_1.addElement(image3);

            // Add products to order 1
            Loop products1 = new Loop("product", new ElementCollection[] { product1_1, product2_1, product3_1 });
            order1.addElement(products1);

            // Order 2
            ElementCollection order2 = new ElementCollection("order2");
            Hashtable<String, String> order2Info = new Hashtable<String, String>();
            order2Info.put("order_name", "Order 2");
            order2Info.put("order_total", "340");
            order2Info.put("ref_nb", "4561");
            order2.addFromDict(order2Info);

            // Product 1 for order 2
            ElementCollection product1_2 = new ElementCollection("product1");
            Hashtable<String, String> product1_2Info = new Hashtable<String, String>();
            product1_2Info.put("product_name", "Blouse");
            product1_2Info.put("quantity", "3");
            product1_2Info.put("unit_price", "60");
            product1_2Info.put("in_stock", "10");
            product1_2.addFromDict(product1_2Info);
            ImageBase64 image1_2 = new ImageBase64("image",
                    "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");
            product1_2.addElement(image1_2);

            // Product 2 for order 2
            ElementCollection product2_2 = new ElementCollection("product2");
            Hashtable<String, String> product2_2Info = new Hashtable<String, String>();
            product2_2Info.put("product_name", "Skirt");
            product2_2Info.put("quantity", "2");
            product2_2Info.put("unit_price", "80");
            product2_2Info.put("in_stock", "1");
            product2_2.addFromDict(product2_2Info);
            ImageBase64 image2_2 = new ImageBase64("image",
                    "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsU\r\nFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5Ojf/2wBDAQoK\r\nCg0MDRoPDxo3JR8lNzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3\r\nNzc3Nzc3Nzc3Nzc3Nzf/wAARCABoAGgDASIAAhEBAxEB/8QAHAAAAQQDAQAAAAAA\r\nAAAAAAAAAAIDBwgBBAUG/8QAPBAAAQMCAwIKCAMJAAAAAAAAAQACAwQRBQYhBzES\r\nExRhcYKhscHCIjJBUXKBkdIzUpJCRVRzg5SistH/xAAUAQEAAAAAAAAAAAAAAAAA\r\nAAAA/8QAFBEBAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8AnFCEIBebxjO2\r\nDYNib8Pr5JmSsa1xc2IuaLi43a9i9Iq77Qq11Xm7FJGuBDZjGOhgDfBBMUefssSf\r\nvVjPjje3vatuPN2XJPVxug607R3qtjpX+3vSDO/n+qCzJzVl4b8cw7+5Z/1NPzjl\r\ntgu7HKA/DMD3KtPKHD3/AFWOPfaw70Fi5toWVohrirX/AMuJ7u5qXg+esDxnEosP\r\noJZnzShxbwoS0aAk6nmCroyRxbqQPmu5k6uNDmfC6kv4LWVLA4j8pPBPYSgsqhCE\r\nAhCEAhCEDdRK2CCSZ/qxtLj0AXVXa6Z09RJM83dI4vcecm5VjM6VPJMqYrKDY8me\r\n0dLhwR3qt0x9IoNd6QUtybKBJb7kDRK9iwgy06rZhJBu02PsPOtUJ+LegtLg9YMQ\r\nwmirAb8fAyT6tBW4vJ7LavlWSqEE3dCXwnquNuwhesQCEIQCEIQeO2r1HEZOnYDb\r\njpY2dvC8qgKU6qadtVRwMGoIL/iVBf8ApaR5lCsm9A2d6bcllJcgwNywd6yNyQ46\r\noFBPRGyZTjCgm7YnU8ZgVdTE6xVXCHQ5o8WlSMoh2G1Nq7FKUn14Y5APhJHmCl5A\r\nIQhAIQhBEm22ovW4bTfkhe89YgeVRTIVIO2Go43NRjv+FTxt73eZR7KgRdYWAUOK\r\nBJNk2TcrL0m6BwFONOqZultcgkHY7VGDOMcd9J6eSPsDvKp4VbNn9VyXOGEy3sDU\r\nNYTzO9HzKyaAQhCAQhCCve0qo5RnDE3X0bIGDqtA8F5CUrtZqqeVZgxKYG4fVSuH\r\nRwiuHJuQNgocdEkb0E6IEuKQCLrLtyQN6BwmwCUwptx0ASo9EHRw2c01ZBUNNjFI\r\n2QfIg+CtWxwexr2m4cLjoVTIvWA96tDleo5XlvC6i9zJSRE9PBF0HUQhCATVVKIK\r\naWZ26NhefkLp1cfN8/J8rYtLexFJIAectI8UFbKhxkkc929xuVqyLekjIJ00Wq6M\r\n2Qa1tVgjRPGMrHFm2iDXcNEkNWwYiVjiigYOruZLYNU7xJShERuQEfrBWM2YVHKM\r\nkYab3MbXxnqvcO6yruyIg3sVO+xt5dlJ7CdGVcgHQQ0+KD3aEIQCTJGyVjmSsa9j\r\nhYtcLg/JCEHCxDJeXcQuZ8Kga4/tQgxH/Gy402yzLkjrtFZGPc2e47QUIQMu2TZe\r\nO6fEB/VZ9qbOyPAv4zEP1x/YhCBJ2Q4JfSvxD6x/alDZHgI31mIHrx/YhCB1uyfL\r\no3y17umZvg1blPszyvCPTo5pj75Kh/gQhCDpUuS8t0rg6LBqThDUF7OH/tdd1jGx\r\nsDI2hrRoGtFgEIQKQhCD/9k=");
            product2_2.addElement(image2_2);

            // Add products to order 2
            RenderElement[] elements2 = { product1_2, product2_2 };
            Loop products2 = new Loop("product", elements2);
            order2.addElement(products2);

            // Add orders to data
            RenderElement[] orders = { order1, order2 };
            Loop ordersLoop = new Loop("orders", orders);
            data.addElement(ordersLoop);

            // Output files
            Hashtable<String, RenderElement> file = new Hashtable<String, RenderElement>();
            file.put("output", data);

            // Create the printjob
            PrintJob printJob = new PrintJob(file, server, output, base64Resource, null, null, null, null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputLoop");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This example show how to build a line chart.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void chartExample(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);
            Output output = new Output("pdf", "raw", null, null, null, null, null);
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/chartname.docx");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/chartname.docx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("docx");
            base64Resource.setMimeType(Mimetype.getMimeType("docx"));
            // End replacement code.

            // Create a serie that has the data for one chart "serie".
            LineSeries lineserie1 = new LineSeries("lineserie1", new String[] { "day 1", "day 2", "day 3" },
                    new String[] { "4.3", "2.5", "3.5" }, "red", true, "square", null, "0.2cm", null);
            LineSeries lineserie2 = new LineSeries("lineserie2", new String[] { "day 1", "day 2", "day 3" },
                    new String[] { "2.4", "4.4", "1.8" }, "purple", null, null, null, null, "sysDashDotDot");

            // Define the chart options.
            ChartOptions options = new ChartOptions();
            options.setBorder(true);
            options.setLegend("l", null);
            options.setTitle("Line Chart");
            options.setWidth(500);

            // Create the chart.
            LineChart lineChart = new LineChart("chartname", options, lineserie1, lineserie2); // chartname is the tag
                                                                                               // in the template

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", lineChart);

            PrintJob printJob = new PrintJob(data, server, output, base64Resource, null, null, null, null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputChartName");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This example show how to build a combined chart.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void combinedChartExample(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);
            Output output = new Output("pdf", "raw", null, null, null, null, null);
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/chartname.docx");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/chartname.docx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("docx");
            base64Resource.setMimeType(Mimetype.getMimeType("docx"));
            // End replacement code.

            // Create the series.
            ColumnSeries columnSeries1 = new ColumnSeries("column 1", new String[] { "day 1", "day 2", "day 3" },
                    new String[] { "4.3", "2.5", "3.5" });
            ColumnSeries columnSeries2 = new ColumnSeries("column 2", new String[] { "day 1", "day 2", "day 3" },
                    new String[] { "2.4", "4.4", "1.8" });

            // Create the chart.
            ColumnChart columnChart = new ColumnChart("columns", null, columnSeries1, columnSeries2);

            // Analog
            LineSeries lineSerie1 = new LineSeries("line 1", new String[] { "day 1", "day 2", "day 3" },
                    new String[] { "43", "25", "35" }, null, null, null, null, null, null);
            LineSeries lineSerie2 = new LineSeries("line 2", new String[] { "day 1", "day 2", "day 3" },
                    new String[] { "24", "44", "18" }, null, null, null, null, null, null);
            LineChart lineChart = new LineChart("lines", null, lineSerie1, lineSerie2);
            ChartOptions options = new ChartOptions();
            options.setBorder(true);
            options.setGrid(true);
            options.setLegend("r", null);
            options.setTitle("Combined Chart");
            options.setHeight(500);
            options.setWidth(600);
            CombinedChart combinedChart = new CombinedChart("chartname", options, new Chart[] { columnChart },
                    new Chart[] { lineChart });

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", combinedChart);

            PrintJob printJob = new PrintJob(data, server, output, base64Resource, null, null, null, null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputCombinedChartName");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This example show how to work with Codes (QR code and barcode).
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void qrCodeExample(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);
            Output output = new Output("pdf", "raw", null, null, null, null, null);
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/localTemplate.docx");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/localTemplate.docx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("docx");
            base64Resource.setMimeType(Mimetype.getMimeType("docx"));
            // End replacement code.

            // Barcode
            BarCode barCode = new BarCode("barc", "ean13", "978020137962");
            barCode.setWidth(50);
            barCode.setHeight(50);
            barCode.setQrErrorCorrectionLevel("L");
            barCode.setLinkUrl("url");
            barCode.setRotation(45);
            barCode.setBackgroundColor("red");
            barCode.setPaddingWidth(25);
            barCode.setPaddingHeight(25);
            barCode.setExtraOptions("includetext guardwhitespace");

            // WifiQRCode
            WifiQRCode wifiQRCode = new WifiQRCode("wifiqr", "ssid", "password", "WPA", false);

            // Main collection that holds the data.
            ElementCollection codes = new ElementCollection("codes");
            codes.addElement(barCode);
            codes.addElement(wifiQRCode);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", codes);

            PrintJob printJob = new PrintJob(data, server, output, base64Resource, null, null, null, null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputCodes");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This example shows you how to prepend/append files and how to use
     * subtemplates in a template. Look in the generalTests to see the code.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     * @throws Exception Exceptions.
     */
    public void prependAppendSubTemplatesExample(String APIKey) throws Exception {
        Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
        server.setVerbose(true);

        Base64Resource prependFile = new Base64Resource();
        InputStream prependFileAsStream = getClass().getResourceAsStream("/GeneralExamples/subTemplate.docx");
        byte[] prependFileTargetArray = new byte[prependFileAsStream.available()];
        prependFileAsStream.read(prependFileTargetArray);
        String prependFileEncodedString = Base64.getEncoder().encodeToString(prependFileTargetArray);
        prependFile.setFileBase64(prependFileEncodedString);
        prependFile.setFiletype("docx");
        prependFile.setMimeType(Mimetype.getMimeType("docx"));

        // prependFile.setFileFromLocalFile("./javaProject/src/com/CloudOfficePrint/Examples/GeneralExamples/subTemplate.docx");

        Base64Resource template = new Base64Resource();
        InputStream templateAsStream = getClass().getResourceAsStream("/GeneralExamples/subTemplate.docx");
        byte[] templateTargetArray = new byte[templateAsStream.available()];
        templateAsStream.read(templateTargetArray);
        String templateEncodedString = Base64.getEncoder().encodeToString(templateTargetArray);
        template.setFileBase64(templateEncodedString);
        template.setFiletype("docx");
        template.setMimeType(Mimetype.getMimeType("docx"));
        // template.setFileFromLocalFile("./javaProject/src/com/CloudOfficePrint/Examples/GeneralExamples/subTemplate.docx");

        Base64Resource templateMain = new Base64Resource();
        InputStream templateMainAsStream = getClass()
                .getResourceAsStream("/GeneralExamples/template_prepend_append_subtemplate.docx");
        byte[] templateMainTargetArray = new byte[templateMainAsStream.available()];
        templateMainAsStream.read(templateMainTargetArray);
        String templateMainEncodedString = Base64.getEncoder().encodeToString(templateMainTargetArray);
        templateMain.setFileBase64(templateMainEncodedString);
        templateMain.setFiletype("docx");
        templateMain.setMimeType(Mimetype.getMimeType("docx"));
        // templateMain.setFileFromLocalFile("./javaProject/src/com/CloudOfficePrint/Examples/GeneralExamples/template_prepend_append_subtemplate.docx");

        ElementCollection coll = new ElementCollection("data");
        coll.addElement(new Property("textTag1", "test_text_tag1"));

        Base64Resource appendFile = new Base64Resource();
        InputStream appendFileAsStream = getClass().getResourceAsStream("/GeneralExamples/subTemplate.docx");
        byte[] appendFileTargetArray = new byte[appendFileAsStream.available()];
        appendFileAsStream.read(appendFileTargetArray);
        String appendFileEncodedString = Base64.getEncoder().encodeToString(appendFileTargetArray);
        appendFile.setFileBase64(appendFileEncodedString);
        appendFile.setFiletype("docx");
        appendFile.setMimeType(Mimetype.getMimeType("docx"));
        // appendFile.setFileFromLocalFile("./javaProject/src/com/CloudOfficePrint/Examples/GeneralExamples/subTemplate.docx");

        Hashtable<String, Resource> subTemplates = new Hashtable<String, Resource>();
        subTemplates.put("sub1", template);
        subTemplates.put("sub2", template);

        Output output = new Output("pdf", "raw", "libreoffice", null, null, null, null);

        Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
        data.put("output1", coll);

        PrintJob printJob = new PrintJob(data, server, output, templateMain, subTemplates,
                new Resource[] { prependFile }, new Resource[] { appendFile }, null);

        printJob.execute().downloadLocally("./downloads/prependAppendSubtemplates");

    }

    /**
     * This example shows you how to add text and images on pages of a template
     * without tag. The output format needs to be PDF.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void COPPDFTextAndImageExample(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);
            Output output = new Output("pdf", "raw", "libreoffice", null, null, null, null);
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/localTemplate.docx");
            // //doesn't have importance
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/localTemplate.docx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("docx");
            base64Resource.setMimeType(Mimetype.getMimeType("docx"));
            // End replacement code.

            // Define the text for the first page.
            PDFText pdfText1_1 = new PDFText(150, 160, 1, "test1_1");
            pdfText1_1.setRotation(45);
            pdfText1_1.setBold(false);
            pdfText1_1.setItalic(true);
            pdfText1_1.setFont("Arial");
            pdfText1_1.setFontColor("blue");
            pdfText1_1.setFontSize(12);

            // Another text for the first page.
            PDFText pdfText1_2 = new PDFText(20, 30, 1, "test1_2");
            pdfText1_2.setRotation(45);
            pdfText1_2.setBold(false);
            pdfText1_2.setItalic(false);
            pdfText1_2.setFont("Arial");
            pdfText1_2.setFontColor("red");
            pdfText1_2.setFontSize(10);

            // Text for the second page.
            PDFText pdfText2 = new PDFText(60, 70, 2, "test2");
            pdfText2.setRotation(30);
            pdfText2.setBold(true);
            pdfText2.setItalic(true);
            pdfText2.setFont("Times new roman");
            pdfText2.setFontColor("#FF00FF");
            pdfText2.setFontSize(15);

            // Text for on all pages.
            PDFText pdfTextAll = new PDFText(420, 430, -1, "test_all"); // -1 means on all pages
            pdfTextAll.setRotation(15);
            pdfTextAll.setBold(true);
            pdfTextAll.setItalic(false);
            pdfTextAll.setFont("Arial");
            pdfTextAll.setFontColor("red");
            pdfTextAll.setFontSize(20);

            // Element containing all the text objects.
            PDFTexts pdfTexts = new PDFTexts(new PDFText[] { pdfText1_1, pdfText1_2, pdfText2, pdfTextAll });

            // Image for on all pages.
            PDFImage pdfImage = new PDFImage(200, 700, 1);
            resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/logo-united-codes.jpg");
            targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            encodedString = Base64.getEncoder().encodeToString(targetArray);
            pdfImage.setImage(encodedString);
            // pdfImage.setImage("https://united-codes.com/assets/dist/images/logo-united-codes.svg");
            // // .svg URL not yet supported for AOP_PDF_IMAGES
            pdfImage.setWidth(200);

            PDFImages pdfImages = new PDFImages(new PDFImage[] { pdfImage });

            // Main collection containing all the data.
            ElementCollection texts = new ElementCollection("texts");
            texts.addElement(pdfTexts);
            texts.addElement(pdfImages);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", texts);

            PrintJob printJob = new PrintJob(data, server, output, base64Resource, null, null, null, null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputCOPPDFText");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Example for a styled property and a watermark.
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void waterMarkAndStyledProperty(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);
            Output output = new Output("pdf", "raw", null, null, null, null, null);
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/GeneralExamples/localTemplate.docx");
            // //doesn't have importance
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/localTemplate.docx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("docx");
            base64Resource.setMimeType(Mimetype.getMimeType("docx"));
            // End replacement code.

            // Creating a property that has a particular style.
            StyledProperty prop = new StyledProperty("first_name", "DemoCustomerName");
            prop.setFont("NanumMyeongjo");
            prop.setFontSize("25pt");
            prop.setFontColor("#ff00ff");
            prop.setBold(true);
            prop.setItalic(true);
            prop.setUnderline(false);
            prop.setStrikethrough(false);
            prop.setHighlightColor("darkMagenta");

            // Creating a watermark to display on all pages.
            Watermark watermark = new Watermark("watermark", "wm_text");
            watermark.setFont("Arial");
            watermark.setColor("red");
            watermark.setOpacity(0.5F);
            watermark.setRotation(-45);

            // Main collection containg all the data.
            ElementCollection collection = new ElementCollection("collection");
            collection.addElement(prop);
            collection.addElement(watermark);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", collection);

            PrintJob printJob = new PrintJob(data, server, output, base64Resource, null, null, null, null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputRenderElements");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This example show you how to sign a PDF file. (Invisible signature, only to
     * be seen in the options of the file).
     * 
     * @param APIKey Your Cloud Office Print APIKey.
     */
    public void signPDF(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);

            // Set the sign certificate of the pdf options of the output.
            PDFOptions pdfOptions = new PDFOptions();
            pdfOptions.setSignCertificate(
                    "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\r\ntgICCAA=");

            Output output = new Output("pdf", "raw", null, null, null, pdfOptions, null);
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./javaProject/src/com/CloudOfficePrint/Examples/GeneralExamples/pdfsignature_template.pdf");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/GeneralExamples/pdfsignature_template.pdf");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("pdf");
            base64Resource.setMimeType(Mimetype.getMimeType("pdf"));
            // End replacement code.

            // create empty collection, always need a data collection
            ElementCollection collection = new ElementCollection("collection");
            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", collection);

            PrintJob printJob = new PrintJob(data, server, output, base64Resource, null, null, null, null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/pdfSigned");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
