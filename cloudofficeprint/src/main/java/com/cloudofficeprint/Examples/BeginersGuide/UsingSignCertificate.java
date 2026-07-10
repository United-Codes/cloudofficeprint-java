package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.Output.PDFOptions;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingSignCertificate {
    public void main() throws Exception {
        System.out.println("I am Using Sign Certificate example");

        Base64Resource template = new Base64Resource();
        InputStream templateStream = getClass().getResourceAsStream("/BeginnerGuide/UsingSignCertificate/template.pdf");
        byte[] templateBytes = new byte[templateStream.available()];
        templateStream.read(templateBytes);
        template.setFileBase64(Base64.getEncoder().encodeToString(templateBytes));
        template.setFiletype("pdf");
        template.setMimeType(Mimetype.getMimeType("pdf"));
        InputStream certStream = getClass().getResourceAsStream("/BeginnerGuide/UsingSignCertificate/certificate.p12");
        byte[] certBytes = new byte[certStream.available()];
        certStream.read(certBytes);
        String certBase64 = Base64.getEncoder().encodeToString(certBytes);

        // Set Cloud Office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        ElementCollection data = new ElementCollection("data");

        // Sign the output PDF with the certificate and its password
        PDFOptions pdfOptions = new PDFOptions();
        pdfOptions.setSignCertificate(certBase64);
        pdfOptions.setSignCertificatePassword("cloudofficeprint");
        pdfOptions.setSignCertificateTxt("Signed by Cloud Office Print");

        Output conf = new Output("pdf", "raw", "libreoffice", null, null, pdfOptions, null);

        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save
        response.downloadLocally("./downloads/BeginnerGuide/UsingSignCertificate/output");
    }
}
