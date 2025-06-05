package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Loops.InlineDataLoop;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class UsingMarkdown {
    public void main() throws Exception {
        System.out.println("I am in UsingMarkdown example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingMarkdown/template.docx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("docx");
        template.setMimeType(Mimetype.getMimeType("docx"));

        //Set Cloud office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");
        // Create main element collection
        ElementCollection data = new ElementCollection("data");

// Markdown content
        String markdownContent = "# Heading level 1\n\n" +
                "## Heading level 2\n\n" +
                "===============\n\n" +
                "I just love **bold text**.\n\n" +
                "Italicized text is the *cat's meow*.\n\n" +
                "1. First item\n" +
                "2. Second item\n" +
                "3. Third item\n" +
                "4. Fourth item\n\n" +
                "---\n\n" +
                "* First item\n" +
                "* Second item\n" +
                "* Third item\n" +
                "* Fourth item\n\n" +
                "| Syntax    | Description |\n" +
                "| --------- | ----------- |\n" +
                "| Header    | Title       |\n" +
                "| Paragraph | Text        |\n\n" +
                "<strike>The world is flat.</strike> We now know that the world is round.";

// Add markdown content to template
        data.addElement(new Property("markdowncontent", markdownContent));

// Create customers array
        ArrayList<RenderElement> customersList = new ArrayList<>();

// Customer data
        String[][] customersData = {
                {"Albert", "**Albert**"},
                {"Edward", "**Edward**"},
                {"Eugene", "**Eugene**"},
                {"Fiorello", "**Fiorello**"},
                {"Frank", "**Frank**"},
                {"John", "**John**"},
                {"William", "**William**"}
        };

// Create collections for each customer
        for (String[] customer : customersData) {
            ElementCollection custCollection = new ElementCollection("customer");
            custCollection.addElement(new Property("first", customer[0]));
            custCollection.addElement(new Property("cust_name_bold", customer[1]));
            customersList.add(custCollection);
        }

// Create loop for customers
        InlineDataLoop customersLoop = new InlineDataLoop("cust_names", customersList);
        data.addElement(customersLoop);


        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();
        // Save the response to a file
        response.downloadLocally("./downloads/BeginnerGuide/UsingMarkdown/output");

    }
}
