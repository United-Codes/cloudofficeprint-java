package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.*;
import com.cloudofficeprint.RenderElements.Images.ImageBase64;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingOtherTagForPPTX {
    public void main() throws Exception {
        System.out.println("Some PPtx tags using Java SDK");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingOtherTagPPTX/other_temp.pptx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("pptx");
        template.setMimeType(Mimetype.getMimeType("pptx"));


        //Set Cloud office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");



        //Main elementCollection that includes all the data
        ElementCollection data = new ElementCollection("data");

        //AutoLink
        AutoLink autoLink = new AutoLink("autoLink", "AutoLink including hyperlinks like https://www.cloudofficeprint.com and other mail like info@cloudofficeprint.com and text combined");
        data.addElement(autoLink);

        //HyperLink
        HyperLink hyperLink = new HyperLink("COP_link", "Visit COP", "https://www.cloudofficeprint.com/index.html");
        data.addElement(hyperLink);

        // Load the document to insert
        // This will be inserted as a file in the output document
        // It can be a PPTX, DOCX, PDF or any other file supported by the Cloud Office Print server
        InputStream insertStream = getClass().getResourceAsStream("/BeginnerGuide/UsingElements/insert_file.pptx");
        if (insertStream == null) {
            throw new IllegalArgumentException("missing file to insert ");
        }
        byte[] insertBytes = new byte[insertStream.available()];
        insertStream.read(insertBytes);
        String base64ToInsert = Base64.getEncoder().encodeToString(insertBytes);
        Insert insert = new Insert("fileToInsert", base64ToInsert);
        data.addElement(insert);

        //insert image from URL
        ImageBase64 img1 = new ImageBase64("image1");
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


        Output conf = new Output("pptx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        //Save response to file.
        response.downloadLocally("./downloads/BeginnerGuide/usingOtherTagPPTX/output");

    }

}
