package com.CloudOfficePrint;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.CloudOfficePrint.Examples.GeneralExamples.Examples;
import com.CloudOfficePrint.Examples.OrderConfirmation.OrderConfirmationExample;
import com.CloudOfficePrint.Examples.SolarSystem.docx.SolarSystemDocx;
import com.CloudOfficePrint.Examples.SolarSystem.pptx.SolarSystemPptx;
import com.CloudOfficePrint.Examples.SpaceX.SpaceXExample;
import com.CloudOfficePrint.Tests.*;

public class Main {

    // First argument should be your API key
    public static void main(String[] args) throws Exception {
        // EXAMPLES

        // Examples example = new Examples();
        // example.localJson(args[0]);
        // example.localTemplateAsync(args[0]);
        // example.localTemplate(args[0]);
        // example.withoutTemplate(args[0]);
        // example.loopExample(args[0]);
        // example.chartExample(args[0]);
        // example.combinedChartExample(args[0]);
        // example.qrCodeExample(args[0]);
        // example.prependAppendSubTemplatesExample(args[0]);
        // example.AOPPDFTextAndImageExample(args[0]);
        // example.waterMarkAndStyledProperty(args[0]);
        // example.signPDF(args[0]);

        // SolarSystemDocx solarSystemDocx = new SolarSystemDocx();
        // solarSystemDocx.main(args[0]);
        // SolarSystemPptx solarSystemPptx = new SolarSystemPptx();
        // solarSystemPptx.main(args[0]);

        // SpaceXExample spaceXExample = new SpaceXExample();
        // spaceXExample.main(args[0], "pptx");
        // spaceXExample.main(args[0], "xlsx");
        // spaceXExample.main(args[0], "docx");

//        OrderConfirmationExample orderConfirmationExample = new OrderConfirmationExample();
//        orderConfirmationExample.main(args[0]);

        // TESTS

        ResourcesTests resourcesTests = new ResourcesTests();
        resourcesTests.ResourceTest();
        resourcesTests.restResource();
        resourcesTests.graphQLResource();
        resourcesTests.restResourcePrintJob();

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
        configTests.testPrinter();

        CodesTests codesTests = new CodesTests();
        codesTests.QROptionsTest();
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

        LoopsTests loopsTests = new LoopsTests();
        loopsTests.forEach();
        loopsTests.testForEachSheet();

        ImagesTests imagesTests = new ImagesTests();
        imagesTests.imageBase64();
        imagesTests.imageURL();

        RenderElementsTests renderElementsTests = new RenderElementsTests();
        renderElementsTests.Property();
        renderElementsTests.cellStylePropertyDocx();
        renderElementsTests.cellStylePropertyXlsx();
        renderElementsTests.hyperLink();
        renderElementsTests.tableOfContent();
        renderElementsTests.CellSpan();
        renderElementsTests.styledProp();
        renderElementsTests.waterMark();
        renderElementsTests.D3Code();
        renderElementsTests.textBox();
        renderElementsTests.elementCollection();
        // footnote, formula, HTML, MarkDownContent, PageBreak, Raw, RightToLeft don't
        // need a test as they are all similar to Property.

        PrintJobTest printJobTest = new PrintJobTest();
        printJobTest.prependAppendSubTemplatesTest();
    }
}
