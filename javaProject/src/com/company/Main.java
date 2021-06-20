package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.company.Resources.Base64Resource;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        try {
            System.out.println("hello world");

            Server server = new Server("http://localhost:8010");

            PrintJob printJob = new PrintJob();
            printJob.setServer(server);
            printJob.setAOP_remote_debug("No");
            printJob.setApex_version("web editor 2");
            printJob.setAPIKey("1C511A58ECC73874E0530100007FD01A");
            printJob.setVersion("3.0");
            printJob.setTool("webeditor-new");
            //printJob.addPrepend_file();
            //printJob.addAppend_file();
            Base64Resource base64Resource = new Base64Resource();
            base64Resource.setFileFromLocalFile("./src/templateTest.docx");
            //template.setFileFromLocalFile("./src/hello.txt");
            printJob.setTemplate(base64Resource);

            Output output = new Output();
            output.setEncoding("raw");
            output.setType("pdf");
            printJob.setOutput(output);

            FileWithData file = new FileWithData();
            file.setName("output");
            String[][] data = {{"first_name", "DemoName"}, {"last_name", "DemoLastName"}, {"city", "DemoCity"}};
            file.addData(data);

            printJob.addFileToGenerate(file);

            //printJob.addSubTemplate(template);

            Response response = printJob.execute();
            response.downloadLocally("output");

            /*
            String ret = server.readJson("./src/test.json");
            System.out.println(ret);
            JSONAssert.assertEquals(ret, json, false);
            JSONObject jsonObject=new JSONObject(ret);
            if (server.isReachable()){
                server.sendPOSTRequest(jsonObject);
            }*/
        }catch (AOPException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
