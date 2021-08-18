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
}
