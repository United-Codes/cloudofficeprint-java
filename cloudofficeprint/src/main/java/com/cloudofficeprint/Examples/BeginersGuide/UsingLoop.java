package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.*;
import com.cloudofficeprint.RenderElements.Loops.Loop;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingLoop {
    public void main() throws Exception {
        System.out.println("I am in Using LOOp example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingLoop/loop_template.docx");
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

        // element1
        ElementCollection element1 = new ElementCollection("element1");
        element1.addElement(new Property("a", 1));
        element1.addElement(new Property("b", 2));
        element1.addElement(new Property("c", 3));

        ElementCollection element2 = new ElementCollection("element2");
        element2.addElement(new Property("a", 4));
        element2.addElement(new Property("b", 5));
        element2.addElement(new Property("c", 6));

        // loop element
        Loop loop = new Loop("loop_name",new ElementCollection[]{element1, element2});

        data.addElement(loop);

        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/usingLoop/output");
    }
}