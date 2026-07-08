package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.RenderElements.PDF.PDFImage;
import com.cloudofficeprint.RenderElements.PDF.PDFImages;
import com.cloudofficeprint.RenderElements.PDF.PDFText;
import com.cloudofficeprint.RenderElements.PDF.PDFTexts;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingPdfTextsAndImages {
    public void main() throws Exception {
        System.out.println("I am Using PDF Texts and Images example");

        Base64Resource template = new Base64Resource();
        InputStream templateStream = getClass().getResourceAsStream("/BeginnerGuide/UsingPdfTextsAndImages/template.pdf");
        byte[] templateBytes = new byte[templateStream.available()];
        templateStream.read(templateBytes);
        template.setFileBase64(Base64.getEncoder().encodeToString(templateBytes));
        template.setFiletype("pdf");
        template.setMimeType(Mimetype.getMimeType("pdf"));

        // Set Cloud Office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        PDFText pdfText = new PDFText(50, 50, -1, "Hello from Cloud Office Print");
        pdfText.setBold(true);
        pdfText.setFontColor("#FF0000");
        pdfText.setFontSize(20);
        PDFTexts pdfTexts = new PDFTexts(new PDFText[] { pdfText });

        PDFImage pdfImage = new PDFImage(50, 100, 1);
        InputStream imageStream = getClass().getResourceAsStream("/BeginnerGuide/UsingPdfTextsAndImages/image.png");
        byte[] imageBytes = new byte[imageStream.available()];
        imageStream.read(imageBytes);
        pdfImage.setImage(Base64.getEncoder().encodeToString(imageBytes));
        pdfImage.setWidth(120);
        pdfImage.setHeight(120);
        PDFImages pdfImages = new PDFImages(new PDFImage[] { pdfImage });

        // Main collection
        ElementCollection data = new ElementCollection("data");
        data.addElement(pdfTexts);
        data.addElement(pdfImages);

        Output conf = new Output("pdf", "raw", "libreoffice", null, null, null, null);

        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/UsingPdfTextsAndImages/output");
    }
}
