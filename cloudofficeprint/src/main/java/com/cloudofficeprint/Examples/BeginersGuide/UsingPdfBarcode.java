package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.Output.PDFOptions;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.RenderElements.Codes.BarCode;
import com.cloudofficeprint.RenderElements.Codes.QRCode;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingPdfBarcode {
    public void main() throws Exception {
        System.out.println("I am Using PDF Barcode example");

        Base64Resource template = new Base64Resource();
        InputStream templateStream = getClass().getResourceAsStream("/BeginnerGuide/UsingPdfBarcode/template.pdf");
        byte[] templateBytes = new byte[templateStream.available()];
        templateStream.read(templateBytes);
        template.setFileBase64(Base64.getEncoder().encodeToString(templateBytes));
        template.setFiletype("pdf");
        template.setMimeType(Mimetype.getMimeType("pdf"));

        // Set Cloud Office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        BarCode barCode = new BarCode("product_barcode", "code128", "1234567890");
        barCode.setHeight(50);
        barCode.setWidth(100);

        QRCode qrCode = new QRCode("product_qr", "qrcode", "https://www.cloudofficeprint.com/");

        ElementCollection data = new ElementCollection("data");
        data.addElement(barCode);
        data.addElement(qrCode);

        PDFOptions pdfOptions = new PDFOptions();
        pdfOptions.setInsertBarcode(true);

        Output conf = new Output("pdf", "raw", "libreoffice", null, null, pdfOptions, null);

        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/UsingPdfBarcode/output");
    }
}
