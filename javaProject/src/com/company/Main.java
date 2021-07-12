package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.company.Examples.Examples;
import com.company.Tests.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Examples example = new Examples();
        //example.localJson();
        //example.localTemplate();
        //example.loopExample();
        //example.chartExample();
        //example.combinedChartExample();
        //example.qrCodeExample();
        //example.prePendAppendSubTemplatesExample();
        //example.AOPPDFTextAndImageExample();
        //example.renderElements();

        PrintJobTest printJobTest = new PrintJobTest();
        //printJobTest.prePendAppendSubTemplatesTest(); //contacts server and makes a download so is in comment

        ResourcesTests resourcesTests = new ResourcesTests();
        resourcesTests.ResourceTest();

        ChartTests chartTests = new ChartTests();
        chartTests.testChartOptions();
        chartTests.testChartLine();
        chartTests.testChartBar();
        chartTests.testChartPie();
        chartTests.testChartArea();
        chartTests.testChartBubble();
        chartTests.testChartStock();
        chartTests.testCombinedChart();
        chartTests.testChartAOP();
        chartTests.testChartStock();
        chartTests.testChartStock();

        ConfigTests configTests = new ConfigTests();
        configTests.testPdfOptions();
        configTests.testCloudAccessTokens();
        configTests.testCommands();

        CodesTests codesTests = new CodesTests();
        codesTests.barCodeTest();
        codesTests.QRWifiTest();
        codesTests.QRTelephoneTest();
        codesTests.QREmailTest();
        codesTests.QRSMSTest();
        codesTests.QRURLTest();
        codesTests.QRVCardTest();
        codesTests.QRMeCardTest();
        codesTests.QRGeoTest();
        codesTests.QREventTest();

        PDFTests pdfTests = new PDFTests();
        pdfTests.AOPPDFTextTest();
        pdfTests.AOPPDFImagesTest();
        pdfTests.AOPPDFForms();

        LoopsTests loopsTests  = new LoopsTests();
        loopsTests.forEach();
        loopsTests.testForEachSheet();

        ImagesTests imagesTests =new ImagesTests();
        imagesTests.imageBase64();
        imagesTests.imageURL();

        RenderElementsTests renderElementsTests =new RenderElementsTests();
        renderElementsTests.Property();
        renderElementsTests.cellStyleProperty();
        renderElementsTests.hyperLink();
        renderElementsTests.tableOfContent();
        renderElementsTests.CellSpan();
        renderElementsTests.styledProp();
        renderElementsTests.waterMark();
        renderElementsTests.D3Code();
        renderElementsTests.textBox();
        renderElementsTests.cellStyleProperty();
        renderElementsTests.cellStyleProperty();
        renderElementsTests.cellStyleProperty();
        renderElementsTests.cellStyleProperty();
    }
}
