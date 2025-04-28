package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.Loops.MergeCellsLoop;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

public class MergeCellsExample {
    public void main() throws Exception {
        System.out.println("I am in MergeCellsExample");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingMergeLoop/template.docx");
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

        // Main elementCollection that includes all the data
        ElementCollection data = new ElementCollection("data");

        // Department 1
        ElementCollection dept1 = new ElementCollection("dept");
        Hashtable<String, String> d1 = new Hashtable<>();
        d1.put("department", "Engineering");
        dept1.addFromDict(d1);

        ArrayList<RenderElement> emps1 = new ArrayList<>();
        for (String[] emp : new String[][]{
                {"John Smith", "Website Redesign", "In Progress"},
                {"Emily Johnson", "API Development", "Completed"},
                {"Michael Brown", "Mobile App", "Planning"}
        }) {
            ElementCollection e = new ElementCollection("emp");
            Hashtable<String, String> h = new Hashtable<>();
            h.put("name", emp[0]);
            h.put("project", emp[1]);
            h.put("status", emp[2]);
            e.addFromDict(h);
            emps1.add(e);
        }
        dept1.addElement(new MergeCellsLoop("employees", emps1));

        // Department 2
        ElementCollection dept2 = new ElementCollection("dept");
        Hashtable<String, String> d2 = new Hashtable<>();
        d2.put("department", "Marketing");
        dept2.addFromDict(d2);

        ArrayList<RenderElement> emps2 = new ArrayList<>();
        for (String[] emp : new String[][]{
                {"Sarah Wilson", "Brand Campaign", "In Progress"},
                {"David Thompson", "Market Research", "Not Started"}
        }) {
            ElementCollection e = new ElementCollection("emp");
            Hashtable<String, String> h = new Hashtable<>();
            h.put("name", emp[0]);
            h.put("project", emp[1]);
            h.put("status", emp[2]);
            e.addFromDict(h);
            emps2.add(e);
        }
        dept2.addElement(new MergeCellsLoop("employees", emps2));

        // Departments Loop
        ArrayList<RenderElement> depts = new ArrayList<>();
        depts.add(dept1);
        depts.add(dept2);
        MergeCellsLoop deptLoop = new MergeCellsLoop("departments", depts);

        data.addElement(deptLoop);

        // Configure output
        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);

        // Prepare print job
        Hashtable<String, RenderElement> dataTable = new Hashtable<>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        // Save response to file
        response.downloadLocally("./downloads/BeginnerGuide/usingMergeLoop/output");
    }
}
