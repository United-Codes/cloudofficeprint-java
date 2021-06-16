package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("hello world");

        Server server = new Server("http://localhost:8010");

        PrintJob printJob= new PrintJob();
        printJob.setAop_remote_debug("No");
        printJob.setApex_version("web editor 2");
        printJob.setAPIKey("1C511A58ECC73874E0530100007FD01A");
        printJob.setVersion("3.0");
        printJob.setTool("webeditor-new");
        //printJob.addPrepend_file();
        //printJob.addAppend_file();
        Resource template = new Resource();
        template.setFilename("templateTest");
        template.setFiletype("docx");
        template.setFileFromLocalFile("./src/templateTest.docx");
        printJob.addTemplate(template);

        Output output = new Output();
        output.setEncoding("raw");
        output.setType("pdf");
        printJob.setOutput(output);


        String ret = server.readJson("./src/test.json");
        JSONObject jsonObject=new JSONObject(ret);
        if (server.isReachable()){
            server.sendPOSTRequest(jsonObject);
        }
    }
}
