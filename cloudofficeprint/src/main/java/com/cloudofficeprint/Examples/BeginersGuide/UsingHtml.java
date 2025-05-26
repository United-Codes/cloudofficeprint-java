package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.HTML;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingHtml {
    public void main() throws Exception {
        System.out.println("I am in Html example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingHtml/html_temp.docx");
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

        //Main elementCollection that includes all the data
        ElementCollection data = new ElementCollection("data");

      // HTML paragraph and line break
        HTML overview = new HTML("overview",
                "<p>This is a <strong>bold</strong> statement, followed by a line break.<br />" +
                        "And here's a new line in the same paragraph.</p>");
        data.addElement(overview);

         // Empty paragraphs
        HTML htmlWithEmptyP = new HTML("html_with_empty_p",
                "<p>First paragraph.</p> " +
                        "<p></p> " +
                        "<p>Third paragraph.</p>",
                null,
                null,
                null, null,
                null,
                true);
        data.addElement(htmlWithEmptyP);

      // Lists with custom styles
        HTML lists = new HTML("lists", "<ul>" + "  <li>Level 1" +
                        "    <ol>" +
                        "      <li>Sub-item A</li>" +
                        "      <li>Sub-item B</li>" +
                        "    </ol>" +
                        "  </li>" +
                        "  <li>Level 2</li>" +
                        "</ul>",
                null,
                "1",
                "2",
                true,
                null,
                true);
        data.addElement(lists);

       // HTML table
        HTML htmlTable = new HTML("html_table_1", "<table border=\"1\">" + " " +
                " <tr><th>Name</th><th>Age</th><th>Country</th></tr>" + "  " +
                "<tr><td>Alice</td><td>30</td><td>USA</td></tr>" + " " +
                " <tr><td>Bob</td><td>25</td><td>Canada</td></tr>" +
                "</table>");
        data.addElement(htmlTable);

        // HTML image
        HTML htmlImg = new HTML("html_img", "<img src=\"https://picsum.photos/200/100\" "
                +"width=\"100px\" height=\"50px\" />");
        data.addElement(htmlImg);
        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        //Save response to file
        response.downloadLocally("./downloads/BeginnerGuide/usingHtml/output");
    }
}
