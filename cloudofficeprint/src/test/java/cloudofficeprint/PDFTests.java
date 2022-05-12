package cloudofficeprint;

import com.cloudofficeprint.RenderElements.PDF.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class PDFTests {

    @Test
    public void COPPDFTextTest() {

        PDFText pdfText1_1 = new PDFText(50, 60, 3, "test1_1");
        pdfText1_1.setRotation(45);
        pdfText1_1.setBold(false);
        pdfText1_1.setItalic(true);
        pdfText1_1.setFont("Arial");
        pdfText1_1.setFontColor("blue");
        pdfText1_1.setFontSize(12);

        PDFText pdfText1_2 = new PDFText(20, 30, 3, "test1_2");
        pdfText1_2.setRotation(45);
        pdfText1_2.setBold(false);
        pdfText1_2.setItalic(false);
        pdfText1_2.setFont("Arial");
        pdfText1_2.setFontColor("red");
        pdfText1_2.setFontSize(10);

        PDFText pdfText2 = new PDFText(60, 70, 5, "test2");
        pdfText2.setRotation(30);
        pdfText2.setBold(true);
        pdfText2.setItalic(true);
        pdfText2.setFont("Times new roman");
        pdfText2.setFontColor("#FF00FF");
        pdfText2.setFontSize(15);

        PDFText pdfTextAll = new PDFText(20, 30, -1, "test_all"); // -1 means on all pages
        pdfTextAll.setRotation(15);
        pdfTextAll.setBold(true);
        pdfTextAll.setItalic(false);
        pdfTextAll.setFont("Arial");
        pdfTextAll.setFontColor("red");
        pdfTextAll.setFontSize(20);

        PDFTexts pdfTexts = new PDFTexts(new PDFText[] { pdfText1_1, pdfText1_2, pdfText2, pdfTextAll });

        String correct = "{'AOP_PDF_TEXTS': [{'3': [{'text': 'test1_1', 'x': 50, 'y': 60, 'rotation': 45, 'bold': False, 'italic': True, 'font': 'Arial', 'font_color': 'blue', 'font_size': 12}, {'text': 'test1_2', 'x': 20, 'y': 30, 'rotation': 45, 'bold': False, 'italic': False, 'font': 'Arial', 'font_color': 'red', 'font_size': 10}], '5': [{'text': 'test2', 'x': 60, 'y': 70, 'rotation': 30, 'bold': True, 'italic': True, 'font': 'Times new roman', 'font_color': '#FF00FF', 'font_size': 15}], 'all': [{'text': 'test_all', 'x': 20, 'y': 30, 'rotation': 15, 'bold': True, 'italic': False, 'font': 'Arial', 'font_color': 'red', 'font_size': 20}]}]}";
        // System.out.println(pdfTexts.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, pdfTexts.getJSON());
    }

    @Test
    public void COPPDFImagesTest() {

        PDFImage PDFImage1_1 = new PDFImage(50, 60, 3, "test1_1");
        PDFImage1_1.setRotation(45);
        PDFImage1_1.setWidth(50);
        PDFImage1_1.setHeight(50);
        PDFImage1_1.setMaxWidth(100);

        PDFImage PDFImage1_2 = new PDFImage(60, 70, 3, "test1_2");
        PDFImage1_2.setRotation(30);
        PDFImage1_2.setWidth(75);
        PDFImage1_2.setHeight(75);
        PDFImage1_2.setMaxWidth(75);

        PDFImage PDFImage2 = new PDFImage(20, 30, 5, "test2");
        PDFImage2.setRotation(15);
        PDFImage2.setWidth(100);
        PDFImage2.setHeight(100);
        PDFImage2.setMaxWidth(100);

        PDFImage PDFImageAll = new PDFImage(25, 26, -1, "test_all");
        PDFImageAll.setRotation(45);
        PDFImageAll.setWidth(20);
        PDFImageAll.setHeight(20);
        PDFImageAll.setMaxWidth(50);

        PDFImages pdfTexts = new PDFImages(new PDFImage[] { PDFImage1_1, PDFImage1_2, PDFImage2, PDFImageAll });

        String correct = "{'AOP_PDF_IMAGES': [{'3': [{'image': 'test1_1', 'x': 50, 'y': 60, 'rotation': 45, 'image_width': 50, 'image_height': 50, 'image_max_width': 100}, {'image': 'test1_2', 'x': 60, 'y': 70, 'rotation': 30, 'image_width': 75, 'image_height': 75, 'image_max_width': 75}], '5': [{'image': 'test2', 'x': 20, 'y': 30, 'rotation': 15, 'image_width': 100, 'image_height': 100, 'image_max_width': 100}], 'all': [{'image': 'test_all', 'x': 25, 'y': 26, 'rotation': 45, 'image_width': 20, 'image_height': 20, 'image_max_width': 50}]}]}";
        // System.out.println(pdfTexts.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, pdfTexts.getJSON());
    }

    @Test
    public void COPPDFForms() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("f_1", "5");
        data.put("f_2", "test");
        data.put("r_1", "true");
        data.put("r_2", "false");
        PDFFormData pdfFormData = new PDFFormData(data);

        String correct = "{'aop_pdf_form_data': {'f_1': '5', 'f_2': 'test', 'r_1': 'true', 'r_2': 'false'}}";
        // System.out.println(pdfFormData.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, pdfFormData.getJSON());
    }

    @Test
    public void PDFFormTextBox(){
        PDFFormTextBox textbox = new PDFFormTextBox("surname");
        textbox.setValue("Apex R&D");
        textbox.setWidth(100);
        textbox.setHeight(20);

        String correct = "{'surname': {\n" +
                    "    'type': 'text',\n" +
                    "    'value': 'Apex R&D',\n" +
                    "    'name': 'surname',\n" +
                    "    'height': 20,\n" +
                    "    'width': 100\n" +
                    "}" +
                "}";
        // System.out.println(textbox.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, textbox.getJSON());
    }

    @Test
    public void PDFFormCheckBox(){
        PDFFormCheckBox checkbox = new PDFFormCheckBox("Checkbox");
        checkbox.setCheck(true);
        checkbox.setHeight(20);
        checkbox.setWidth(200);
        checkbox.setText("Check?");

        String correct = "{" +
                    "'Checkbox': {\n" +
                    "    'type': 'checkbox',\n" +
                    "    'name': 'Checkbox',\n" +
                    "    'value': true,\n" +
                    "    'height': 20,\n" +
                    "    'width': 200,\n" +
                    "    'text': 'Check?'\n" +
                    "}" +
                "}";
        // System.out.println(checkbox.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, checkbox.getJSON());
    }

    @Test
    public void PDFFormRadioButton(){
        PDFFormRadioButton radio = new PDFFormRadioButton("a");
        radio.setGroup("Radio");
        radio.setValue("A");
        radio.setHeight(20);
        radio.setWidth(200);
        radio.setText("Option A");

        String correct = "{" +
                    "'a': {\n" +
                    "'type': 'radio',\n" +
                    "'name': 'Radio',\n" +
                    "'value': 'A',\n" +
                    "'height': 20,\n" +
                    "'width': 200,\n" +
                    "'text': 'Option A'\n" +
                    "}" +
                "}";
        // System.out.println(radio.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, radio.getJSON());
    }

    @Test
    public void PDFFormSignature(){
        PDFFormSignature signature = new PDFFormSignature("text1");
        signature.setWidth(150);
        signature.setHeight(50);

        String correct = "{" +
                    "'text1': {\n" +
                    "'type': 'signaturefieldunsigned',\n" +
                    "'name': 'text1',\n" +
                    "'width': 150,\n" +
                    "'height': 50\n" +
                    "}" +
                "}";
        // System.out.println(signature.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, signature.getJSON());
    }

    @Test
    public void PDFFormSignatureSigned(){
        PDFFormSignatureSigned signature = new PDFFormSignatureSigned("text2", "base64 encoded certificate");
        signature.setSize("md");
        signature.setPassword("certificate password");
        signature.setBackgroundImage("base64 encoded image");

        String correct = "{" +
                "\"text2\": {\n" +
                    "\"type\": \"signaturefieldsigned\",\n" +
                    "\"name\": \"text2\",\n" +
                    "\"size\": \"md\",\n" +
                    "\"value\": \"base64 encoded certificate\",\n" +
                    "\"background_image\": \"base64 encoded image\",\n" +
                    "\"password\": \"certificate password\"\n" +
                    "}" +
                "}";
        // System.out.println(signature.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, signature.getJSON());
    }
}
