package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.Output.PDFOptions;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingImageWatermark {
    public void main() throws Exception {
        System.out.println("I am Using Image Watermark example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/helloWorld/template.docx");
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

        // Create the main collection
        ElementCollection data = new ElementCollection("data");
        data.addElement(new Property("title", "Hello World!"));
        data.addElement(new Property("text", "This document has an image watermark."));

        PDFOptions pdfOptions = new PDFOptions();
        pdfOptions.setImageWatermark(
                "https://www.united-codes.com/assets/images/uc/dimi-signature.webp",
                50, // opacity
                10,  // rotation
                100, // width
                100  // height
        );

        Output conf = new Output("pdf", "raw", "libreoffice", null, null, pdfOptions, null);

        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/UsingImageWatermark/output");
    }
}
