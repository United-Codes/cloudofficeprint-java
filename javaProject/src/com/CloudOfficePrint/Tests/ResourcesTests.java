package com.CloudOfficePrint.Tests;

import com.CloudOfficePrint.Output.Output;
import com.CloudOfficePrint.PrintJob;
import com.CloudOfficePrint.Resources.*;
import com.CloudOfficePrint.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;

public class ResourcesTests {

    public void ResourceTest() throws Exception {

        Base64Resource base64resource = new Base64Resource("docx","dummy");
        String correct= "{'file': 'dummy', 'template_type': 'docx'}";
        //System.out.println(base64resource.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,base64resource.getJSONForTemplate());

        ServerResource serverResource = new ServerResource("dummy/path.docx",null);
        correct= "{'filename': 'dummy/path.docx', 'template_type': 'docx'}";
        //System.out.println(serverResource.getJSONForTemplate());
        jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,serverResource.getJSONForTemplate());

        URLResource urlResource = new URLResource("dummy_url","docx",null);
        correct= "{'template_type': 'docx', 'url': 'dummy_url'}";
        //System.out.println(urlResource.getJSONForTemplate());
        jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,urlResource.getJSONForTemplate());

        String htmlString = "\n" +
                "     <!DOCTYPE html>\n" +
                "    <html>\n" +
                "    <body>\n" +
                "\n" +
                "    <h1>My First Heading</h1>\n" +
                "    <p>My first paragraph.</p>\n" +
                "\n" +
                "    </body>\n" +
                "    </html>\n";
        HTMLResource htmlResource = new HTMLResource(htmlString,true);
        correct= "{'template_type': 'html', 'orientation': 'landscape', 'html_template_content': '\n     <!DOCTYPE html>\n    <html>\n    <body>\n\n    <h1>My First Heading</h1>\n    <p>My first paragraph.</p>\n\n    </body>\n    </html>\n'}";
        //System.out.println(htmlResource.getJSONForTemplate());
        jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,htmlResource.getJSONForTemplate());
    }

    public void restResource(){
        JsonArray headers = new JsonArray();
        JsonObject header = new JsonObject();
        header.addProperty("Content-Type","application/json");
        headers.add(header);
        RESTResource restResource = new RESTResource("endpoint_url","GET","","output_file",headers,"username:password");

        String correct= "{'filename': 'output_file', 'datasource': 'rest', 'method': 'GET', 'body': '', 'endpoint': 'endpoint_url', 'headers': [{'Content-Type': 'application/json'}], 'auth': 'username:password'}";
        //System.out.println(restResource.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,restResource.getJSON());
    }


    public void graphQLResource(){
        JsonArray headers = new JsonArray();
        JsonObject header = new JsonObject();
        header.addProperty("Content-Type","application/json");
        headers.add(header);
        GraphQLResource restResource = new GraphQLResource("endpoint_url","test_query","output_file",headers,"username:password");

        String correct= "{'filename': 'output_file', 'datasource': 'graphql', 'query': 'test_query', 'endpoint': 'endpoint_url', 'headers': [{'Content-Type': 'application/json'}], 'auth': 'username:password'}";
        //System.out.println(restResource.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,restResource.getJSON());
    }

    public void restResourcePrintJob() throws Exception {
        JsonArray headers = new JsonArray();
        JsonObject header = new JsonObject();
        header.addProperty("Content-Type","application/json");
        headers.add(header);
        RESTResource restResource = new RESTResource("endpoint_url","GET","","output_file",headers,"username:password");



        Server server = new Server("http://localhost:8010","1C511A58ECC73874E0530100007FD01A",null,
                null,null,null,null);
        Output output = new Output("docx","raw","libreoffice",null,null,null);
        Base64Resource base64Resource = new Base64Resource("docx","test_base64");

        PrintJob printJob = new PrintJob(restResource,server,output,base64Resource,null,null,null,null);


        String correct= "{'tool': 'AOP_java_sdk', 'java_sdk_version': '21.1', 'api_key': '1C511A58ECC73874E0530100007FD01A', 'output': {'output_converter': 'libreoffice', 'output_encoding': 'raw', 'output_type': 'docx'}, 'template': {'template_type': 'docx', 'file': 'test_base64'}, 'files': [{'filename': 'output_file', 'datasource': 'rest', 'method': 'GET', 'body': '', 'endpoint': 'endpoint_url', 'headers': [{'Content-Type': 'application/json'}], 'auth': 'username:password'}]}";
        //System.out.println(printJob.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,printJob.getJSON());
    }
}