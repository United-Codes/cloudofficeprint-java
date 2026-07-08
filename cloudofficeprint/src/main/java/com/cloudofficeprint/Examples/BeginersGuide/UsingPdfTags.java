package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.RenderElements.Loops.Loop;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingPdfTags {
    public void main() throws Exception {
        System.out.println("I am Using PDF  Tags example");
        Base64Resource template = new Base64Resource();
        InputStream templateStream = getClass().getResourceAsStream("/BeginnerGuide/UsingPdfTags/template.pdf");
        byte[] templateBytes = new byte[templateStream.available()];
        templateStream.read(templateBytes);
        template.setFileBase64(Base64.getEncoder().encodeToString(templateBytes));
        template.setFiletype("pdf");
        template.setMimeType(Mimetype.getMimeType("pdf"));

        // Set Cloud Office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        ElementCollection data = new ElementCollection("data");
        data.addElement(new Property("customer_name", "John Doe"));
        data.addElement(new Property("invoice_number", "INV-2025-001"));
        data.addElement(new Property("issue_date", "2024-06-15"));
        data.addElement(new Property("amount", "$1,500.00"));

        InputStream imageStream = getClass().getResourceAsStream("/BeginnerGuide/UsingPdfTags/image.png");
        byte[] imageBytes = new byte[imageStream.available()];
        imageStream.read(imageBytes);
        data.addElement(new Property("company_logo", Base64.getEncoder().encodeToString(imageBytes)));
        data.addElement(new Loop("employees", new ElementCollection[] {
            employee("Alice", "Engineer"),
            employee("Bob", "Manager"),
            employee("Carol", "Designer"),
        }));

        Output conf = new Output("pdf", "raw", "libreoffice", null, null, null, null);

        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/UsingPdfTags/output");
    }

    private ElementCollection employee(String name, String role) {
        ElementCollection e = new ElementCollection(name);
        e.addElement(new Property("name", name));
        e.addElement(new Property("role", role));
        return e;
    }
}
