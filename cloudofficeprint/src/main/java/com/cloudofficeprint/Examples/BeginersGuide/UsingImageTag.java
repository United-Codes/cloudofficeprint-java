package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Images.ImageBase64;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingImageTag {
    public void  main() throws Exception {
        System.out.println("I am in UsingImageTag example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingImage/img_temp.docx");
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

        //Property
        data.addElement(new Property("title", "Image Example"));
        data.addElement(new Property("description",  "This is an example created with the Cloud Office Print Java SDK"));

        //first image from URL
        ImageBase64 img1 = new ImageBase64("image_name");
        img1.setValue("https://picsum.photos/300/200");
        img1.setMaxWidth(100);
        img1.setMaxHeight(100);
        img1.setWidth(150);
        img1.setAltText("Random image");
        img1.setWrapText("square");
        img1.setRotation(0);
        img1.setTransparency("10%");
        img1.setTargetUrl("https://example.com");
        data.addElement(img1);

    // SVG image from URL
        ImageBase64 img2 = new ImageBase64("img_svg");
        img2.setValue("https://upload.wikimedia.org/wikipedia/commons/4/4f/SVG_Logo.svg");
        img2.setMaxWidth(200);
        img2.setMaxHeight(200);
        img2.setWidth(150);
        img2.setHeight(150);
        img2.setAltText("SVG logo");
        img2.setWrapText("square");
        img2.setRotation(45);
        img2.setTransparency("20%");
        img2.setTargetUrl("https://www.w3.org/Graphics/SVG/");
        img2.setDensity(300);
        data.addElement(img2);

       //image from local file
        ImageBase64 img3 = new ImageBase64("img_file");
        img3.setFileFromLocalFile("BeginnerGuide/UsingImage/local_img/UC_Logo.svg"); //path to the local file
        img3.setMaxWidth(300);
        img3.setMaxHeight(300);
        img3.setWidth(150);
        img3.setAltText("United codes logo");
        img3.setWrapText("square");
        img3.setRotation(0);
        img3.setTransparency("15%");
        img3.setTargetUrl("https://www.united-codes.com");
        data.addElement(img3);

        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        //Save response to file.
        response.downloadLocally("./downloads/BeginnerGuide/usingImageTag/output");
    }
}
