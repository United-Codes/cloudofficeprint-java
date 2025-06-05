package com.cloudofficeprint.Examples.BeginersGuide;
import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Form.Checkbox;
import com.cloudofficeprint.RenderElements.Form.RadioButton;
import com.cloudofficeprint.RenderElements.Form.Textbox;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class UsingFormsExample {
    public void main() throws Exception {
        System.out.println("Starting PDF Form Example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingForm/template.docx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("docx");
        template.setMimeType(Mimetype.getMimeType("docx"));

        // Set server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        //main data collection
        ElementCollection data = new ElementCollection("data");
        // Textboxes
        Textbox firstName = new Textbox("first_name", null, null, null, null);
        Textbox lastName = new Textbox(
                "last_name", "Apex R&D", 20, 200, true);

        // Radio buttons group
        ArrayList<RadioButton> radioOptions = new ArrayList<>();
        radioOptions.add(new RadioButton("radiolist", "A", "Option A", true));
        radioOptions.add(new RadioButton("radiolist", "B", "Option B", false));

        // Checkbox
        Checkbox agreement = new Checkbox("checkbox", true, "Agree to terms");

        // Add elements to collection
        data.addElement(firstName);
        data.addElement(lastName);
        for (RadioButton radio : radioOptions) {
            data.addElement(radio);
        }
        data.addElement(agreement);

        // Configure output
        Output conf = new Output("pdf", "raw", "libreoffice", null, null, null, null);

        // Prepare print job
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save response to file
        response.downloadLocally("./downloads/BeginnerGuide/UsingForm/output");
    }
}