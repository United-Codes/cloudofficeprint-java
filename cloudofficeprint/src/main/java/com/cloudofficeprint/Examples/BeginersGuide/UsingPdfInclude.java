package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.PdfInclude;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingPdfInclude {
    public void main() throws Exception {
        System.out.println("I am in  pdf include exmaple using Java SDK");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingPdfInclude/include_temp.docx");
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
        InputStream insertStream = getClass().getResourceAsStream("/BeginnerGuide/UsingPdfInclude/view.png");
        if (insertStream == null) {
            throw new IllegalArgumentException("missing file to insert ");
        }
        // Read the file and convert it to Base64
        byte[] insertBytes = new byte[insertStream.available()];
        // Read the input stream into a byte array
        insertStream.read(insertBytes);
        // Convert the byte array to a Base64 encoded string
        String base64ToInsert = Base64.getEncoder().encodeToString(insertBytes);
// Create a PdfInclude element
        PdfInclude pdfInclude = new PdfInclude("view" , "", "view.png","image/png",base64ToInsert ,"base64");
        data.addElement(pdfInclude);

        // Configure output
        Output conf = new Output("pdf", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save response locally
        response.downloadLocally("./downloads/BeginnerGuide/usingPdfInclude/output");



    }
}
