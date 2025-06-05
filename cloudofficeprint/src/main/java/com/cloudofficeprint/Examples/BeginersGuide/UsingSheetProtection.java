package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.ProtectSheet;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingSheetProtection {
    public void main() throws Exception {
        System.out.println("I am in Using Sheet Protection example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingSheetProtection/temp.xlsx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("xlsx");
        template.setMimeType(Mimetype.getMimeType("xlsx"));


        //Set Cloud office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        //Main elementCollection that includes all the data
        ElementCollection data = new ElementCollection("data");
        ProtectSheet sheetProtection = new ProtectSheet("sheet_protection");
        sheetProtection.setPassword("123");
        data.addElement(sheetProtection);

        //Property
        Property fname = new Property("cust_first_name", "John");
        Property lname = new Property("cust_last_name", "Doe");
        data.addElement(fname);
        data.addElement(lname);

        Output conf = new Output("xlsx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        //Save response to file.
        response.downloadLocally("./downloads/BeginnerGuide/usingSheetProtection/output");
    }
}
