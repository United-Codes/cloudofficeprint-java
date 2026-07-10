package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.RenderElements.PDF.PDFFormData;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;

public class UsingPdfFormFilling {
    public void main() throws Exception {
        System.out.println("I am Using PDF Form Filling example");
        Base64Resource template = new Base64Resource();
        InputStream templateStream = getClass().getResourceAsStream("/BeginnerGuide/UsingPdfFormFilling/template.pdf");
        byte[] templateBytes = new byte[templateStream.available()];
        templateStream.read(templateBytes);
        template.setFileBase64(Base64.getEncoder().encodeToString(templateBytes));
        template.setFiletype("pdf");
        template.setMimeType(Mimetype.getMimeType("pdf"));

        // Set Cloud Office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        HashMap<String, String> formFields = new HashMap<>();
        formFields.put("name", "Nishant Thapa");
        formFields.put("email", "nishan@nomail.com");
        formFields.put("country", "nepal");
        formFields.put("subscribe", "true");

        ElementCollection data = new ElementCollection("data");
        data.addElement(new PDFFormData(formFields));

        Output conf = new Output("pdf", "raw", "libreoffice", null, null, null, null);

        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the filled PDF
        response.downloadLocally("./downloads/BeginnerGuide/UsingPdfFormFilling/output");
    }
}
