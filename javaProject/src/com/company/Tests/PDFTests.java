package com.company.Tests;

import com.company.RenderElements.PDF.PDFText;
import com.company.RenderElements.PDF.PDFTexts;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;

public class PDFTests {

    public void AOPPDFTextTest(){

        PDFText pdfText1_1 = new PDFText(50,60,3,"test1_1");
        pdfText1_1.setRotation(45);
        pdfText1_1.setBold(false);
        pdfText1_1.setItalic(true);
        pdfText1_1.setFont("Arial");
        pdfText1_1.setFontColor("blue");
        pdfText1_1.setFontSize(12);

        PDFText pdfText1_2 = new PDFText(20,30,3,"test1_2");
        pdfText1_2.setRotation(45);
        pdfText1_2.setBold(false);
        pdfText1_2.setItalic(false);
        pdfText1_2.setFont("Arial");
        pdfText1_2.setFontColor("red");
        pdfText1_2.setFontSize(10);

        PDFText pdfText2 = new PDFText(60,70,5,"test2");
        pdfText2.setRotation(30);
        pdfText2.setBold(true);
        pdfText2.setItalic(true);
        pdfText2.setFont("Times new roman");
        pdfText2.setFontColor("#FF00FF");
        pdfText2.setFontSize(15);

        PDFText pdfTextAll = new PDFText(20,30,-1,"test_all"); //-1 means on all pages
        pdfTextAll.setRotation(15);
        pdfTextAll.setBold(true);
        pdfTextAll.setItalic(false);
        pdfTextAll.setFont("Arial");
        pdfTextAll.setFontColor("red");
        pdfTextAll.setFontSize(20);

        PDFTexts pdfTexts = new PDFTexts(new PDFText[]{pdfText1_1, pdfText1_2, pdfText2, pdfTextAll});

        String correct= "{'AOP_PDF_TEXTS': [{'3': [{'text': 'test1_1', 'x': 50, 'y': 60, 'rotation': 45, 'bold': False, 'italic': True, 'font': 'Arial', 'font_color': 'blue', 'font_size': 12}, {'text': 'test1_2', 'x': 20, 'y': 30, 'rotation': 45, 'bold': False, 'italic': False, 'font': 'Arial', 'font_color': 'red', 'font_size': 10}], '5': [{'text': 'test2', 'x': 60, 'y': 70, 'rotation': 30, 'bold': True, 'italic': True, 'font': 'Times new roman', 'font_color': '#FF00FF', 'font_size': 15}], 'all': [{'text': 'test_all', 'x': 20, 'y': 30, 'rotation': 15, 'bold': True, 'italic': False, 'font': 'Arial', 'font_color': 'red', 'font_size': 20}]}]}";
        //System.out.println(pdfTexts.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,pdfTexts.getJSON());
    }
}
