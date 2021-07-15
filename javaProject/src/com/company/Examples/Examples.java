package com.company.Examples;

import com.company.AOPException;
import com.company.Output.Output;
import com.company.Output.PDFOptions;
import com.company.PrintJob;
import com.company.RenderElements.*;
import com.company.RenderElements.Charts.ChartOptions;
import com.company.RenderElements.Charts.Charts.*;
import com.company.RenderElements.Charts.Series.ColumnSeries;
import com.company.RenderElements.Charts.Series.LineSeries;
import com.company.RenderElements.Codes.BarCode;
import com.company.RenderElements.Codes.WifiQRCode;
import com.company.RenderElements.Images.ImageBase64;
import com.company.RenderElements.Loops.Loop;
import com.company.RenderElements.PDF.PDFImage;
import com.company.RenderElements.PDF.PDFImages;
import com.company.RenderElements.PDF.PDFText;
import com.company.RenderElements.PDF.PDFTexts;
import com.company.Resources.Base64Resource;
import com.company.Response;
import com.company.Server.Server;
import com.company.Tests.PrintJobTest;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Hashtable;

public class Examples {

    /**
     * Example where the local test.json is read and send to the server. The output is downloaded in downloads and named outputLocalJson.
     */
    public void localJson(String APIKey){
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
             //       null,null,"127.0.0.1",8000);
            null,null,null,null);
            server.setVerbose(true);
            String ret = server.readJson("./src/com/company/Examples/test.json");
            JsonObject jsonObject = JsonParser.parseString(ret).getAsJsonObject();
            Response response = server.sendPOSTRequest(jsonObject);
            response.downloadLocally("./downloads/outputLocalJson");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Example without template. AOP will generate the template based on the data. Output type determines the template type generated. Cannot be PDF in this case.
     */
    public void withoutTemplate(String APIKey){
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
                    null,null,null,null);
            server.setVerbose(true);
            Output output = new Output("docx","raw",null,null,null,null);

            Property property1 = new Property("first_name","Quent");
            Property property2 = new Property("last_name","Stroob");
            Property property3 = new Property("city","Leuven");
            ImageBase64 image = new ImageBase64("imageTag");
            image.setFileFromLocalFile("./src/com/company/Examples/test.jpg");
            image.setMaxWidth(500);
            image.setRotation(75);
            ArrayList<RenderElement> dataList =  new ArrayList<RenderElement>();
            dataList.add(property1);
            dataList.add(property2);
            dataList.add(property3);
            dataList.add(image);
            ElementCollection data1 = new ElementCollection("data1",dataList);


            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1",data1);

            PrintJob printJob = new PrintJob(data,server,output,null,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputWithoutTemplate");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Example with templateTest.docx as template, a list of properties and an image as data. A zipfile named outputLocalTemplate will contain
     * 2 outputs files in the downloads folder.
     */
    public void localTemplate(String APIKey){
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
                    null,null,null,null);
            server.setVerbose(true);
            PDFOptions pdfOptions = new PDFOptions();
            pdfOptions.setReadPassword("hello");
            pdfOptions.setLandscape(true);
            Output output = new Output("pdf","raw",null,null,null,pdfOptions);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/localTemplate.docx");

            Property property1 = new Property("first_name","Quent");
            Property property2 = new Property("last_name","Stroob");
            Property property3 = new Property("city","Leuven");
            ImageBase64 image = new ImageBase64("imageTag");
            image.setFileFromLocalFile("./src/com/company/Examples/test.jpg");
            image.setMaxWidth(500);
            image.setRotation(75);
            ArrayList<RenderElement> dataList =  new ArrayList<RenderElement>();
            dataList.add(property1);
            dataList.add(property2);
            dataList.add(property3);
            dataList.add(image);
            ElementCollection data1 = new ElementCollection("data1",dataList);

            Hashtable<String, String> propertyDict = new Hashtable<String, String>();
            propertyDict.put("first_name","B");
            propertyDict.put("last_name","A");
            propertyDict.put("city","C");
            ElementCollection data2 = new ElementCollection("data2");
            data2.addFromDict(propertyDict);
            //data2.addElement(image);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1",data1);
            data.put("output2",data2);

            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputLocalTemplate");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Asynchronous call of execute.
     * Example with templateTest.docx as template, a list of properties and an image as data. A zipfile named outputLocalTemplate will contain
     * 2 outputs files in the downloads folder.
     */
    public void localTemplateAsync(String APIKey){
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
                    null,null,null,null);
            server.setVerbose(true);
            PDFOptions pdfOptions = new PDFOptions();
            pdfOptions.setReadPassword("hello");
            pdfOptions.setLandscape(true);
            Output output = new Output("pdf","raw",null,null,null,pdfOptions);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/localTemplate.docx");

            Property property1 = new Property("first_name","Quent");
            Property property2 = new Property("last_name","Stroob");
            Property property3 = new Property("city","Leuven");
            ImageBase64 image = new ImageBase64("imageTag");
            image.setFileFromLocalFile("./src/com/company/Examples/test.jpg");
            image.setMaxWidth(500);
            image.setRotation(75);
            ArrayList<RenderElement> dataList =  new ArrayList<RenderElement>();
            dataList.add(property1);
            dataList.add(property2);
            dataList.add(property3);
            //dataList.add(image);
            ElementCollection data1 = new ElementCollection("data1",dataList);

            Hashtable<String, String> propertyDict = new Hashtable<String, String>();
            propertyDict.put("first_name","B");
            propertyDict.put("last_name","A");
            propertyDict.put("city","C");
            ElementCollection data2 = new ElementCollection("data2");
            data2.addFromDict(propertyDict);
            //data2.addElement(image);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1",data1);
            data.put("output2",data2);

            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null,null);

            Thread thread = new Thread(printJob); //This is how to run send the POST request asynchronously (because it can sometimes take a few seconds before getting back the response).
            thread.start();
            //System.out.println("in between");
            thread.join();
            //System.out.println("after");
            Response response = printJob.getResponse();
            response.downloadLocally("./downloads/outputLocalTemplateAsync");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * In this example a 2 nested loops are given in the template. One for the orders and one for the products per order.
     */
    public void loopExample(String APIKey){
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
                    null,null,null,null);
            server.setVerbose(true);

            Output output = new Output("pdf","raw",null,null,null,null);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/orderTemplate.docx");

            //Main object that includes all the data
            ElementCollection data = new ElementCollection("data");

            // Company information
            Property companyName = new Property("company_name","APEXOfficePrint");
            ImageBase64 companyLogo = new ImageBase64("company_logo");
            companyLogo.setFileFromLocalFile("./src/com/company/Examples/logoAOP.jpg");
            companyLogo.setMaxWidth(200);
            companyLogo.setMaxHeight(200);
            data.addElement(companyName);
            data.addElement(companyLogo);

            // Customer information
            Hashtable<String, String> customerInfo = new Hashtable<String, String>();
            customerInfo.put("cust_city","Louis");
            customerInfo.put("cust_first_name","Albertos");
            customerInfo.put("cust_last_name","Lambert");
            data.addFromDict(customerInfo);

            //Order 1
            ElementCollection order1 = new ElementCollection("order1");
            Hashtable<String, String> orderInfo = new Hashtable<String, String>();
            orderInfo.put("order_name","Order 1");
            orderInfo.put("order_total","610");
            orderInfo.put("ref_nb","5645");
            order1.addFromDict(orderInfo);

            //Product 1 for order 1
            ElementCollection product1_1 = new ElementCollection("product1");
            Hashtable<String, String> product1_1Info = new Hashtable<String, String>();
            product1_1Info.put("product_name","Business \nShirt");
            product1_1Info.put("quantity","3");
            product1_1Info.put("unit_price","50");
            product1_1Info.put("in_stock","3");
            product1_1.addFromDict(product1_1Info);
            ImageBase64 image1 = new ImageBase64("image","/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBhAQDxINEhQPEw8SEBcVEBQUEBAP\r\nFBAQFBAVFhQQFBQXGyYeFxkjGRISHy8gIygsLCwsFR8xNTwqNSYrLCkBCQoKDQoN\r\nGQwOGikeHBgpNSkpKSk0KSwpKSk0MCw0NSkpKSksMikpLC4wKSwqKSkpKSkpKjQ0\r\nKSkpKjYpNCkyKf/AABEIAGgAaAMBIgACEQEDEQH/xAAbAAACAwEBAQAAAAAAAAAA\r\nAAAABQIDBAEHBv/EADgQAAIBAgMEBgYKAwAAAAAAAAABAgMRBBIhBTFBUWFxgZGx\r\n0RMWIlKhwQYyYnKSorLh8PEUQlP/xAAUAQEAAAAAAAAAAAAAAAAAAAAA/8QAFBEB\r\nAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8A9xAAAAA43YDNjdpU6P13Z8Et\r\nW+wX+tFPhGfwQlxSdSrObu7y046cLdli+ns52vu62A19ZIe5LvRbS2/Se9Sj1q/g\r\nJqWCbbXItlhcu9PxXwA+lp1VJZk00+KJCfYtVRk6d1qsy15NLTv+A4AAAAAAAAAA\r\nAwbRx7ptRSV2r3fDsF06spJyk29G10dhbtN3qtckl8/mQy6NdAGLA1LeybZbtDBK\r\ni4u5vjVWXM2kubAoouTk1mk8u9ejyp3XCTWvYzXOqorMyFDFQnua6tz67bzLj53Q\r\nGKlXbrqb0TurLgmtPiOqGJnHc9OT1Qow1FucXykvEcTQDTDVs8VLdzXJotMWzZaS\r\nj037/wCjaAAAAAAACTFK9Sb+14JIjF2O1PrS+8/FnUwMmNxcKavLe90Vq5dSFTwO\r\nIxLTlelT4J3Vl1b2+kfwpxTbSV3vfHvJ5uICWv8ARySSdObutybt8UcpzrR0rQlZ\r\nf7LXvtvHaqABmwltJKzXQamRVJJ3sk+jS/XzJsC/Au0+uIwF1DScevxQxAAAAAAA\r\nBFU+tL7z/UyJ2b9qS+0/1M7YATLEiOQ7GNgJJO/C1tAtqSQAdsQJORyIFkXZp8mv\r\nEZiqW4aRd0nzQHQAAAjOVk29yV32EjNtCpanLp07wEyXEsvYqlVUd/8AP5clU1Vu\r\nene7AXU5XSb32JoruSTAkpq9tL8gcjmVXvxOMCRKKIRZK4EhhhneEerwFqZvwUvY\r\n6m/G/wAwNAAAAL9sJuMdbe1ustdBgKts1NYx6G+/+gF0r3XFX1emnwLL8en5lfpl\r\nxaXaV1MZDRZo3bVldcwNiJJlDrHP8gDSpHGzI8dHNk4/tcs9OBoTJJmZV0WKogLT\r\nbs6Wkl0371+wuzGzZsvaa5rwf7gMQAAAWbU2FCvJTbkmlZ21uuHQuIABi9ScM9+d\r\n9sV8jtP6E4WMlJekTTunmW/uAANi2BT96r+JeRx/R+lzqfiXkAAQ9WaV82arf7y8\r\nifq9T96r+KPkcADvq/D36nfHyBbAj79T8vkAASWxV/0qfl8i3C7OySzZ5PTc0l4A\r\nAG0AAD//2Q==");
            product1_1.addElement(image1);

            //Product 2 for order 1
            ElementCollection product2_1 = new ElementCollection("product2");
            Hashtable<String, String> product2_1Info = new Hashtable<String, String>();
            product2_1Info.put("product_name","Trousers");
            product2_1Info.put("quantity","2");
            product2_1Info.put("unit_price","80");
            product2_1Info.put("in_stock","1");
            product2_1.addFromDict(product2_1Info);
            ImageBase64 image2 = new ImageBase64("image","/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsU\r\nFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5Ojf/2wBDAQoK\r\nCg0MDRoPDxo3JR8lNzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3\r\nNzc3Nzc3Nzc3Nzc3Nzf/wAARCABoAGgDASIAAhEBAxEB/8QAHAABAQACAwEBAAAA\r\nAAAAAAAAAAcBBQQGCAID/8QAPRAAAQMDAAUHCAgHAAAAAAAAAQACAwQFEQYHEiFB\r\nEyIxUWFxoSMygZGxssHRFBUXQnOiwuEINVJiY5Lw/8QAFgEBAQEAAAAAAAAAAAAA\r\nAAAAAAEC/8QAFhEBAQEAAAAAAAAAAAAAAAAAAAEx/9oADAMBAAIRAxEAPwC4IiIM\r\nrCIg02mV2msWi1zulNyRmpad0kYlBLS7gDgjioH9q+mVRkG5RQ/hUkfxBVE1/wBx\r\nmp9GKKgiJaytqgJSOLWDaA/22fUoZAcwskA+9zh2ZPzVSu1yaw9LZRz9IKvH+OKN\r\nvsYvlmmek4eyV16uLwJBzTOQCenBAxuWjiY1swjxuLNof96Av2iZtU+Cd4dg9+Qi\r\nPUdkucN5tNLcaYERVEYeA7pHWD3HIXOU51J10k1jraF7tptLUbUeTvDXjOPWD61R\r\nlGjiiIgIiIMrCIgysIiCOfxCTbQstM3pHKyeLB81HaPPloXjGDnHYVYtfcYdXWVw\r\nbl3JTA92WKPy+Sq439AcC0+1VHMjOWwv+807JXLi3Pdu3Eg56iuJT+cWg8071ywc\r\nIioajpD9PvEY6DFE71F3zVcUj1GRONZeJgeaI4mEdpLj8FXFFhxRERRERAREQZWE\r\nRBJte0flLHN+Oz3Co5eOZG2TGcOHtVs16szbrPJje2qe3Pez9lFrwM0TtyrNYo3Z\r\n2CuaOhauhf5Nh7ls3bgT1DoKCt6iTmkvO7onjH5SqmpdqIwbZd3jjUs9xVFRqHFE\r\nRAREQZWERBlYREEw16Of9WWho8w1Tye8M3fFRqtbtwFvXn2K068o9qzWx+7m1Z3Z\r\n/sKjFUPJFVm61NAc0+OIOFtXzBpZtea9vVxWotxB5RufvLZAcpA0EZLDgoLPqF/k\r\n91B4VTfcCqKleoUn6tu7DwqGe7+yqijRxREQEREBERAREQTjXfHtWC3yZI2azHfl\r\njvkopVHmY61ateJA0ftw4/Th7jlE6l2B6FUutZbqdxp6qdmTyUzGFvDnB5z+VbKl\r\ndtMeR6WkbwU0coZaux6Qzx9FGKed3aNtzT4OJ9C+WO2XZG8ObvCIsGoZ+YL207nc\r\nrC7HYWu+Sq6iOomqLdI7jS7RxLRh5Hax4H6yrco1BE4ogIiICIiAiIgm+vFubBbn\r\ndVaPccofWuPmbO8g4wrlrxZIdGKJ7Gkhla0uPVzHY8VEWkAgzOGT0AqpVE1QWMT6\r\nFaWzSAbdYx1MMjOyGxkjxf4Kd0+HxjaG9vR3KxainNqtGbzGHDZdXubu4Dk2BSSo\r\npH2+4VFHNukp3uid3tOPgg7hqdcINPI2jOZaWVvsd+lX1eeNVTj9odvA382UHu5N\r\ny9DqEETiiKIiICIiAiIg1mktlh0hsdVaql7o46hoBe0AluCCDv7QugQalLYJM1F3\r\nrXs/pjYxnjvREHdNEtEbXolST09qExE8nKSvmk2nOOMDqHgpppdq20irdIq2uoI6\r\nSaCpnfK3E+y5oJzghwHhlEQdh1eatn2G4C8XeoD65meRihflke00g7Rxzjv7h2qk\r\nIiAiIgIiIP/Z");
            product2_1.addElement(image2);

            //Product 3 for order 1
            ElementCollection product3_1 = new ElementCollection("product3");
            Hashtable<String, String> product3_1Info = new Hashtable<String, String>();
            product3_1Info.put("product_name","Jacket");
            product3_1Info.put("quantity","2");
            product3_1Info.put("unit_price","150");
            product3_1Info.put("in_stock","3");
            product3_1.addFromDict(product3_1Info);
            ImageBase64 image3 = new ImageBase64("image","/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBhQSDRUTExQTExIWFBMZERgVERAV\r\nEhkXExAWGRwVFxQYGygeIxkvHxgUHzAgJTMsLiwsFR4xNTEqNSYrLSsBCQoKBQUF\r\nDQUFDSkYEhgpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkp\r\nKSkpKSkpKSkpKf/AABEIAGgAaAMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAA\r\nAAAABwgDBAYFAgH/xAA1EAABBAEBBQUGBQUBAAAAAAABAAIDEQQhBQYHEmEiMVGB\r\nkRMUQXGhwSMyQ5KxQmRyk6Iz/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAA\r\nAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AJxREQEREBERARLRAREQEREBERAR\r\nEQEReDv1lui2VkvY4seIjyuBogkgaHx1QaW8nErEw3FhLpZRoWRgGj4OcTQPTU9F\r\nFO+PFjJyXM9g5+KxpvljkdzOsD87xXXRcdJMStO7dqg6s7/5/JXvMw79fauJojrr\r\na9/cjivJjSPZmyTZELq5Do+Rhs3q42W9L+Sj+9PJak8mtoLSbv754mb/AOEoc4Cy\r\nxwLJAPHldqR1Fhe2qn7Mz3xSNkjcWPaba5poghWm2VkmTGikNW+ONxrutzATXqg2\r\nkREBERAREQFynFGYN2Jk3pbWAdS6ZgpdWo2455/Ls+KO9ZJga8RGx30tzPogg9x7\r\n1gL1+6l7qBIa3tGtBqBZ8zXmsTe9BmbNpXosbBZX41pJ+GgWVjKKDMDQVndycjn2\r\nTiO77x4v+YwPsquTS9to6X6lWK4Q7QEmxomjvidJG7585eK6U9qDtEREBERAREQF\r\nBvHLaYdtCOMO5hFDq0EGnSPJN9eUMU5FVg37yPabWy3lv68gFaaMdya/tQaWy8a8\r\nDNl+A90b0t+Q416MXjwnVdXs+Et3cyZCCBLnY7WE9x9lE9xr5W5cswIMkQ7z1+wX\r\n04ar5iOh+evoF++zsoNna2zOSHFyG/llbMx1n9SCZ16eHI+L6qRuBu3XNy34xP4c\r\nrC9os0Hx1qB1bd/4jwXH5GI6TYgcAXDGzO1VmmZUIFnwbzxN83rY4ZZRZtnFN1cn\r\nL+9jm19UFlkREBERAREQCqv759nauYP7mf6yuP3VoFE21eEE+TtLImdLFFDJK5za\r\nDnyUa/poC/NBzm+Lmx7ubKiboHsfK4eLi0En1kd6qO7UhcXoxDNi4bXFzMfEYATV\r\n25zhZrS6Y1Ry96D6jJ1+Z+yyNdqteA9nzP8AAWTmQdvujT9i7WYTX4GO8fHWOV7v\r\n5DR5rxdy7G08TTX3nHr/AHsXW8DcZkuTlxSta+N+O0Oa4W0tEutjzXYjg9HFtGDJ\r\nxpC2JkzHvikt1Bpv8N/f3gaO9UEjoiICIiAiIgIiIIt4mcLZszJOVjva5xY1r43n\r\nlPYFAsd3eRr56qKNqbhZ8JIkxJ/m2MyN/dHYVqUQVbh4dZ3uL8o48gY1zRyljhMW\r\nkG5BHXNyjs69b7gSseztx86bVmJOR4mMsb6voK1CIIs4R8PcrCyJcjJDY+eL2bGB\r\n4c/V7XFzuXsj8tVfx+ClNEQEREBERAREQEREBERAREQEREBERAREQf/Z");
            product3_1.addElement(image3);

            //Add products to order 1
            Loop products1 = new Loop("product", new ElementCollection[]{product1_1, product2_1, product3_1});
            order1.addElement(products1);

            //Order 2
            ElementCollection order2 = new ElementCollection("order2");
            Hashtable<String, String> order2Info = new Hashtable<String, String>();
            order2Info.put("order_name","Order 2");
            order2Info.put("order_total","340");
            order2Info.put("ref_nb","4561");
            order2.addFromDict(order2Info);

            //Product 1 for order 2
            ElementCollection product1_2 = new ElementCollection("product1");
            Hashtable<String, String> product1_2Info = new Hashtable<String, String>();
            product1_2Info.put("product_name","Blouse");
            product1_2Info.put("quantity","3");
            product1_2Info.put("unit_price","60");
            product1_2Info.put("in_stock","10");
            product1_2.addFromDict(product1_2Info);
            ImageBase64 image1_2 = new ImageBase64("image","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");
            product1_2.addElement(image1_2);

            //Product 2 for order 2
            ElementCollection product2_2 = new ElementCollection("product2");
            Hashtable<String, String> product2_2Info = new Hashtable<String, String>();
            product2_2Info.put("product_name","Skirt");
            product2_2Info.put("quantity","2");
            product2_2Info.put("unit_price","80");
            product2_2Info.put("in_stock","1");
            product2_2.addFromDict(product2_2Info);
            ImageBase64 image2_2 = new ImageBase64("image","/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsU\r\nFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5Ojf/2wBDAQoK\r\nCg0MDRoPDxo3JR8lNzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3\r\nNzc3Nzc3Nzc3Nzc3Nzf/wAARCABoAGgDASIAAhEBAxEB/8QAHAAAAQQDAQAAAAAA\r\nAAAAAAAAAAIDBwgBBAUG/8QAPBAAAQMCAwIKCAMJAAAAAAAAAQACAwQRBQYhBzES\r\nExRhcYKhscHCIjJBUXKBkdIzUpJCRVRzg5SistH/xAAUAQEAAAAAAAAAAAAAAAAA\r\nAAAA/8QAFBEBAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8AnFCEIBebxjO2\r\nDYNib8Pr5JmSsa1xc2IuaLi43a9i9Iq77Qq11Xm7FJGuBDZjGOhgDfBBMUefssSf\r\nvVjPjje3vatuPN2XJPVxug607R3qtjpX+3vSDO/n+qCzJzVl4b8cw7+5Z/1NPzjl\r\ntgu7HKA/DMD3KtPKHD3/AFWOPfaw70Fi5toWVohrirX/AMuJ7u5qXg+esDxnEosP\r\noJZnzShxbwoS0aAk6nmCroyRxbqQPmu5k6uNDmfC6kv4LWVLA4j8pPBPYSgsqhCE\r\nAhCEAhCEDdRK2CCSZ/qxtLj0AXVXa6Z09RJM83dI4vcecm5VjM6VPJMqYrKDY8me\r\n0dLhwR3qt0x9IoNd6QUtybKBJb7kDRK9iwgy06rZhJBu02PsPOtUJ+LegtLg9YMQ\r\nwmirAb8fAyT6tBW4vJ7LavlWSqEE3dCXwnquNuwhesQCEIQCEIQeO2r1HEZOnYDb\r\njpY2dvC8qgKU6qadtVRwMGoIL/iVBf8ApaR5lCsm9A2d6bcllJcgwNywd6yNyQ46\r\noFBPRGyZTjCgm7YnU8ZgVdTE6xVXCHQ5o8WlSMoh2G1Nq7FKUn14Y5APhJHmCl5A\r\nIQhAIQhBEm22ovW4bTfkhe89YgeVRTIVIO2Go43NRjv+FTxt73eZR7KgRdYWAUOK\r\nBJNk2TcrL0m6BwFONOqZultcgkHY7VGDOMcd9J6eSPsDvKp4VbNn9VyXOGEy3sDU\r\nNYTzO9HzKyaAQhCAQhCCve0qo5RnDE3X0bIGDqtA8F5CUrtZqqeVZgxKYG4fVSuH\r\nRwiuHJuQNgocdEkb0E6IEuKQCLrLtyQN6BwmwCUwptx0ASo9EHRw2c01ZBUNNjFI\r\n2QfIg+CtWxwexr2m4cLjoVTIvWA96tDleo5XlvC6i9zJSRE9PBF0HUQhCATVVKIK\r\naWZ26NhefkLp1cfN8/J8rYtLexFJIAectI8UFbKhxkkc929xuVqyLekjIJ00Wq6M\r\n2Qa1tVgjRPGMrHFm2iDXcNEkNWwYiVjiigYOruZLYNU7xJShERuQEfrBWM2YVHKM\r\nkYab3MbXxnqvcO6yruyIg3sVO+xt5dlJ7CdGVcgHQQ0+KD3aEIQCTJGyVjmSsa9j\r\nhYtcLg/JCEHCxDJeXcQuZ8Kga4/tQgxH/Gy402yzLkjrtFZGPc2e47QUIQMu2TZe\r\nO6fEB/VZ9qbOyPAv4zEP1x/YhCBJ2Q4JfSvxD6x/alDZHgI31mIHrx/YhCB1uyfL\r\no3y17umZvg1blPszyvCPTo5pj75Kh/gQhCDpUuS8t0rg6LBqThDUF7OH/tdd1jGx\r\nsDI2hrRoGtFgEIQKQhCD/9k=");
            product2_2.addElement(image2_2);

            //Add products to order 2
            RenderElement[] elements2 = {product1_2,product2_2};
            Loop products2 = new Loop("product",elements2);
            order2.addElement(products2);

            //Add orders to data
            RenderElement[] orders = {order1,order2};
            Loop ordersLoop = new Loop("orders",orders);
            data.addElement(ordersLoop);

            //Output files
            Hashtable<String, RenderElement> file = new Hashtable<String, RenderElement>();
            file.put("output",data);

            //Create the printjob
            PrintJob printJob = new PrintJob(file,server,output,base64Resource,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputLoop");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This example show how to build charts.
     */
    public void chartExample(String APIKey){
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
                    null,null,null,null);
            server.setVerbose(true);
            Output output = new Output("pdf","raw",null,null,null,null);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/chartname.docx");


            LineSeries lineserie1 = new LineSeries("lineserie1",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"4.3", "2.5", "3.5"},"red",
                    true,"square",null,"0.2cm",null);
            LineSeries lineserie2 = new LineSeries("lineserie2",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"2.4", "4.4", "1.8"},"purple",
                    null,null,null,null,"sysDashDotDot");
            ChartOptions options = new ChartOptions();
            options.setBorder(true);
            options.setLegend("l",null);
            options.setTitle("Line Chart");
            options.setWidth(500);

            LineChart lineChart = new LineChart("chartname",options,lineserie1,lineserie2); //chartname is the tag in the template

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1",lineChart);

            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputChartName");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * This example show how to build a combined chart.
     */
    public void combinedChartExample(String APIKey){
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
                    null,null,null,null);
            server.setVerbose(true);
            Output output = new Output("pdf","raw",null,null,null,null);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/chartname.docx");



            ColumnSeries columnSeries1 = new ColumnSeries("column 1",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"4.3", "2.5", "3.5"});
            ColumnSeries columnSeries2 = new ColumnSeries("column 2",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"2.4", "4.4", "1.8"});
            ColumnChart columnChart = new ColumnChart("columns",null,columnSeries1,columnSeries2);

            LineSeries lineSerie1 = new LineSeries("line 1",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"43", "25", "35"},
                    null,null,null,null,null,null);
            LineSeries lineSerie2 = new LineSeries("line 2",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"24", "44", "18"},
                    null,null,null,null,null,null);
            LineChart lineChart = new LineChart("lines",null,lineSerie1,lineSerie2);
            ChartOptions options = new ChartOptions();
            options.setBorder(true);
            options.setGrid(true);
            options.setLegend("r",null);
            options.setTitle("Combined Chart");
            options.setHeight(500);
            options.setWidth(600);
            CombinedChart combinedChart = new CombinedChart("chartname",options, new Chart[]{columnChart}, new Chart[]{lineChart});

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1",combinedChart);

            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputCombinedChartName");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This example show how to work with Codes (QR code and barcode).
     */
    public void qrCodeExample(String APIKey){
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
                    null,null,null,null);
            server.setVerbose(true);
            Output output = new Output("pdf","raw",null,null,null,null);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/localTemplate.docx");

            //Barcode
            BarCode barCode =new BarCode("barc","ean13","978020137962");
            barCode.setWidth(50);
            barCode.setHeight(50);
            barCode.setQrErrorCorrectionLevel("L");
            barCode.setLinkUrl("url");
            barCode.setRotation(45);
            barCode.setBackgroundColor("red");
            barCode.setPaddingWidth(25);
            barCode.setPaddingHeight(25);
            barCode.setExtraOptions("includetext guardwhitespace");

            //WifiQRCode
            WifiQRCode wifiQRCode =new WifiQRCode("wifiqr","ssid","password","WPA",false);


            ElementCollection codes = new ElementCollection("codes");
            codes.addElement(barCode);
            codes.addElement(wifiQRCode);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1",codes);

            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputCodes");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This example shows you how to prepend/append files and how to use subtemplates in a template.
     * Look in the generalTests to see the code.
     * @throws Exception Exceptions.
     */
    public void prePendAppendSubTemplatesExample(String APIKey) throws Exception {
        PrintJobTest printJobTest = new PrintJobTest();
        printJobTest.prePendAppendSubTemplatesTest(APIKey);
    }


    /**
     * This example shows you how to add text and images on each page of a template without tag.
     */
    public void AOPPDFTextAndImageExample(String APIKey)  {
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
                    null,null,null,null);
            server.setVerbose(true);
            Output output = new Output("pdf","raw",null,null,null,null);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/localTemplate.docx"); //doesn't have importance

            PDFText pdfText1_1 = new PDFText(150,160,1,"test1_1");
            pdfText1_1.setRotation(45);
            pdfText1_1.setBold(false);
            pdfText1_1.setItalic(true);
            pdfText1_1.setFont("Arial");
            pdfText1_1.setFontColor("blue");
            pdfText1_1.setFontSize(12);

            PDFText pdfText1_2 = new PDFText(20,30,1,"test1_2");
            pdfText1_2.setRotation(45);
            pdfText1_2.setBold(false);
            pdfText1_2.setItalic(false);
            pdfText1_2.setFont("Arial");
            pdfText1_2.setFontColor("red");
            pdfText1_2.setFontSize(10);

            PDFText pdfText2 = new PDFText(60,70,2,"test2");
            pdfText2.setRotation(30);
            pdfText2.setBold(true);
            pdfText2.setItalic(true);
            pdfText2.setFont("Times new roman");
            pdfText2.setFontColor("#FF00FF");
            pdfText2.setFontSize(15);

            PDFText pdfTextAll = new PDFText(420,430,-1,"test_all"); //-1 means on all pages
            pdfTextAll.setRotation(15);
            pdfTextAll.setBold(true);
            pdfTextAll.setItalic(false);
            pdfTextAll.setFont("Arial");
            pdfTextAll.setFontColor("red");
            pdfTextAll.setFontSize(20);

            PDFTexts pdfTexts = new PDFTexts(new PDFText[]{pdfText1_1, pdfText1_2, pdfText2, pdfTextAll});

            PDFImage pdfImage = new PDFImage(200,700,1);
            pdfImage.setImageFromLocalFile("./src/com/company/Examples/logoAOP.jpg");
            pdfImage.setWidth(200);

            PDFImages pdfImages = new PDFImages(new PDFImage[]{pdfImage});

            ElementCollection codes = new ElementCollection("codes");
            codes.addElement(pdfTexts);
            codes.addElement(pdfImages);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1",codes);

            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputAOPPDFText");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Example for a styled property and a watermark.
     */
    public void renderElements(String APIKey){
        try {
            Server server = new Server("http://localhost:8010",APIKey,null,
                    null,null,null,null);
            server.setVerbose(true);
            Output output = new Output("pdf","raw",null,null,null,null);
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/com/company/Examples/localTemplate.docx");

            StyledProperty prop = new StyledProperty("first_name","DemoCustomerName");
            prop.setFont("NanumMyeongjo");
            prop.setFontSize("25pt");
            prop.setFontColor("#ff00ff");
            prop.setBold(true);
            prop.setItalic(true);
            prop.setUnderline(false);
            prop.setStrikethrough(false);
            prop.setHighlightColor("darkMagenta");

            Watermark watermark = new Watermark("watermark","wm_text");
            watermark.setFont("Arial");
            watermark.setColor("red");
            watermark.setOpacity(0.5F);
            watermark.setRotation(-45);

            ElementCollection collection = new ElementCollection("collection");
            collection.addElement(prop);
            collection.addElement(watermark);

            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1",collection);

            PrintJob printJob = new PrintJob(data,server,output,base64Resource,null,null,null,null);

            Response response = printJob.execute();
            response.downloadLocally("./downloads/outputRenderElements");

        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
