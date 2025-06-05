package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Embed;
import com.cloudofficeprint.RenderElements.Insert;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingAttachAndEmbed {
    public void main() throws Exception {
        System.out.println("I am in Attach and Embed example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingElements/attach_embed_temp.docx");
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

        // Main ElementCollection
        ElementCollection data = new ElementCollection("data");

        // Load the document to insert
        InputStream insertStream = getClass().getResourceAsStream("/BeginnerGuide/UsingElements/insert_file.pptx");
        if (insertStream == null) {
            throw new IllegalArgumentException("missing file to insert ");
        }
        byte[] insertBytes = new byte[insertStream.available()];
        insertStream.read(insertBytes);
        String base64ToInsert = Base64.getEncoder().encodeToString(insertBytes);
        Insert insert = new Insert("fileToInsert1", base64ToInsert);
        data.addElement(insert);

        // Load the document to embed
        InputStream attachStream = getClass().getResourceAsStream("/BeginnerGuide/UsingElements/embed_file.docx"
        );
        if (attachStream == null) {

            throw new IllegalArgumentException("missing file to embed");
        }
        byte[] attachBytes = new byte[attachStream.available()];
        attachStream.read(attachBytes);
        String base64EncodedDoc = Base64.getEncoder().encodeToString(attachBytes);

        //embed
        Embed embed = new Embed("fileToEmbed", base64EncodedDoc);
        data.addElement(embed);

        // Configure output
        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save response locally
        response.downloadLocally("./downloads/BeginnerGuide/usingElements/output/attach_embed_output");
    }
}
