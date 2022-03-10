package cloudofficeprint;

import com.cloudofficeprint.Output.CloudAcessToken.AWSToken;
import com.cloudofficeprint.Output.CloudAcessToken.FTPToken;
import com.cloudofficeprint.Output.CloudAcessToken.OAuth2Token;
import com.cloudofficeprint.Output.CsvOptions;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.Output.PDFOptions;
import com.cloudofficeprint.Server.Command;
import com.cloudofficeprint.Server.Commands;
import com.cloudofficeprint.Server.Printer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConfigTests {

    /**
     * Test PDFOptions in Outputconfig.
     */
    @Test
    public void testPdfOptions() {
        PDFOptions pdfOptions = new PDFOptions();
        pdfOptions.setReadPassword("test_pw");
        pdfOptions.setWatermark("test_watermark");
        pdfOptions.setWatermarkColor("blue");
        pdfOptions.setWatermarkFont("Aerial");
        pdfOptions.setWatermarkOpacity(60);
        pdfOptions.setWatermarkFontSize(30);
        pdfOptions.setPageWidth("500");
        pdfOptions.setPageHeight("500");
        pdfOptions.setEvenPage(true);
        pdfOptions.setMergeMakingEven(false);
        pdfOptions.setModifyPassword("test_modify_password");
        pdfOptions.setPasswordProtectionFlag(0);
        pdfOptions.setLockForm(true);
        pdfOptions.setCopies(3);
        pdfOptions.setPageMargin(5);
        pdfOptions.setLandscape(false);
        pdfOptions.setMerge(false);
        pdfOptions.setPageFormat("test_page_format");
        pdfOptions.setSignCertificate("test_sign_certificate");
        pdfOptions.setSignCertificatePassword("Base64 certificate with password");
        pdfOptions.setLandscape(false);
        pdfOptions.setIdentifyFormFields(true);
        pdfOptions.setSplit(false);
        pdfOptions.setRemoveLastPage(true);

        Output output = new Output("pdf", "raw", "libreoffice", null, null, pdfOptions, null);

        String correct = "{'output_type': 'pdf', 'output_encoding': 'raw', 'output_converter': 'libreoffice', 'output_read_password': 'test_pw', 'output_watermark': 'test_watermark','output_watermark_color':'blue','output_watermark_font':'Aerial','output_watermark_opacity': 60, 'output_watermark_size':30, 'output_page_width': '500', 'output_page_height': '500', 'output_even_page': True, 'output_merge_making_even': False, 'output_modify_password': 'test_modify_password', 'output_password_protection_flag': 0, 'lock_form': True, 'output_copies': 3, 'page_margin': {'top': 5, 'bottom': 5, 'left': 5, 'right': 5}, 'output_page_format': 'test_page_format', 'output_merge': False, 'output_sign_certificate': 'test_sign_certificate','output_sign_certificate_password':'Base64 certificate with password', 'identify_form_fields': True, 'output_split': False,'output_remove_last_page':true}";
        // System.out.println(output.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, output.getJSON());
    }

    @Test
    public void testCsvOptions() {
        CsvOptions csvOptions = new CsvOptions();
        csvOptions.setCharacterSet(5);
        csvOptions.setFieldSeparator("fieldSep");
        csvOptions.setTextDelimiter("textDelim");

        Output output = new Output("pdf", "raw", "libreoffice", null, null, null, csvOptions);

        String correct = "{'output_type':'pdf','output_encoding':'raw','output_converter':'libreoffice', 'output_field_separator': 'fieldSep', 'output_text_delimiter': 'textDelim', 'output_character_set': 5}";
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        assertEquals(jsonCorrect, output.getJSON());
    }

    @Test
    public void testCloudAccessTokens() {
        OAuth2Token oAuth2Token = new OAuth2Token("dropbox", "dummy_token");
        String correct = "{'output_location': 'dropbox', 'cloud_access_token': 'dummy_token'}";
        // System.out.println(oAuth2Token.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, oAuth2Token.getJSON());

        AWSToken awsToken = new AWSToken("AWS_access_key_id", "AWS_secter_access_key");
        correct = "{'output_location': 'aws_s3', 'cloud_access_token': {'access_key': 'AWS_access_key_id', 'secret_access_key': 'AWS_secter_access_key'}}";
        // System.out.println(awsToken.getJSON());
        jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, awsToken.getJSON());

        FTPToken ftpToken = new FTPToken("host_name", false, 35, "dummy_user", "dummy_pw");
        correct = "{'output_location': 'ftp', 'cloud_access_token': {'host': 'host_name', 'port': 35, 'user': 'dummy_user', 'password': 'dummy_pw'}}";
        // System.out.println(awsToken.getJSON());
        jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, ftpToken.getJSON());

        FTPToken sftpToken = new FTPToken("host_name", true, 35, "dummy_user", "dummy_pw");
        correct = "{'output_location': 'sftp', 'cloud_access_token': {'host': 'host_name', 'port': 35, 'user': 'dummy_user', 'password': 'dummy_pw'}}";
        // System.out.println(awsToken.getJSON());
        jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, sftpToken.getJSON());
    }

    @Test
    public void testCommands() {

        // post_process
        JsonObject argspre = new JsonObject();
        argspre.addProperty("p1", "Parameter1");
        argspre.addProperty("p2", "Parameter2");
        argspre.addProperty("p3", "Parameter3");
        Command postcommand = new Command("echo_post", argspre);

        Commands postCommands = new Commands();
        postCommands.setPostProcess(postcommand);
        postCommands.setPostProcessReturn(false);
        postCommands.setPostProcessDeleteDelay(1500);

        String correct = "{'post_process': {'command': 'echo_post', 'return_output': False, 'delete_delay': 1500, 'command_parameters': {'p1': 'Parameter1', 'p2': 'Parameter2', 'p3': 'Parameter3'}}}";
        // System.out.println(postCommands.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, postCommands.getJSON());

        // conversion
        JsonObject argsconversion = new JsonObject();
        argsconversion.addProperty("p1", "Parameter1");
        argsconversion.addProperty("p2", "Parameter2");
        argsconversion.addProperty("p3", "Parameter3");
        Command preConversionCommand = new Command("echo_pre", argsconversion);

        Command postConversionCommand = new Command("echo_post", argsconversion);

        Commands conversionCommand = new Commands();
        conversionCommand.setPreConversion(preConversionCommand);
        conversionCommand.setPostConversion(postConversionCommand);

        correct = "{'conversion': {'pre_command': 'echo_pre', 'pre_command_parameters': {'p1': 'Parameter1', 'p2': 'Parameter2', 'p3': 'Parameter3'}, 'post_command': 'echo_post', 'post_command_parameters': {'p1': 'Parameter1', 'p2': 'Parameter2', 'p3': 'Parameter3'}}}";
        // System.out.println(conversionCommand.getJSON());
        jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, conversionCommand.getJSON());

        // merge
        Command postMergeCommand = new Command("echo_post", argsconversion);

        Commands postMergeCommands = new Commands();
        postMergeCommands.setPostMerge(postMergeCommand);

        correct = "{'merge': {'post_command': 'echo_post', 'post_command_parameters': {'p1': 'Parameter1', 'p2': 'Parameter2', 'p3': 'Parameter3'}}}";
        // System.out.println(postMergeCommands.getJSON());
        jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, postMergeCommands.getJSON());
    }

    @Test
    public void testPrinter() {
        Printer printer = new Printer("http://10.0.14.223:631/", "1.1", "your name", "Cloud Office Print",true);
        Printer printer1 = new Printer("http://10.0.14.223:631/", "1.1", "your name", "Cloud Office Print");
        String correct = " {  'location': 'http://10.0.14.223:631/', 'version': '1.1','requester': 'your name', 'job_name': 'Cloud Office Print','return_output':true }";
        String correct1 = " {  'location': 'http://10.0.14.223:631/', 'version': '1.1','requester': 'your name', 'job_name': 'Cloud Office Print','return_output':False }";
//         System.out.println(printer1.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        JsonObject jsonCorrect1 = JsonParser.parseString(correct1).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, printer.getJSON());
        assertEquals(jsonCorrect1,printer1.getJSON());
    }
}
