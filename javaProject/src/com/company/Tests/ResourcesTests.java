package com.company.Tests;

import com.company.Resources.Base64Resource;
import com.company.Resources.HTMLResource;
import com.company.Resources.ServerResource;
import com.company.Resources.URLResource;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;

public class ResourcesTests {

    public void ResourceTest() throws Exception {

        Base64Resource base64resource = new Base64Resource("docx",null,"dummy");
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
}
