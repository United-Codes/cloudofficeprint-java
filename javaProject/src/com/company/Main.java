package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.company.Examples.Examples;
import com.company.Examples.SolarSystem.docx.SolarSystemDocx;
import com.company.Examples.SolarSystem.pptx.SolarSystemPptx;
import com.company.Examples.SpaceX.SpaceXExample;
import com.company.Tests.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Examples example = new Examples();
        //example.localJson("1C511A58ECC73874E0530100007FD01A");
        //example.localTemplateAsync("1C511A58ECC73874E0530100007FD01A");
        //example.localTemplate("1C511A58ECC73874E0530100007FD01A");
        /*example.withoutTemplate("1C511A58ECC73874E0530100007FD01A");
        example.loopExample("1C511A58ECC73874E0530100007FD01A");
        example.chartExample("1C511A58ECC73874E0530100007FD01A");
        example.combinedChartExample("1C511A58ECC73874E0530100007FD01A");
        example.qrCodeExample("1C511A58ECC73874E0530100007FD01A");
        example.prePendAppendSubTemplatesExample("1C511A58ECC73874E0530100007FD01A");
        example.AOPPDFTextAndImageExample("1C511A58ECC73874E0530100007FD01A");*/
        //example.renderElements("1C511A58ECC73874E0530100007FD01A");
        example.signPDF("1C511A58ECC73874E0530100007FD01A");

        SolarSystemDocx solarSystemDocx = new SolarSystemDocx();
        //solarSystemDocx.main("1C511A58ECC73874E0530100007FD01A");

        SolarSystemPptx solarSystemPptx = new SolarSystemPptx();
        solarSystemPptx.main("1C511A58ECC73874E0530100007FD01A");

        SpaceXExample spaceXExample = new SpaceXExample();
        //spaceXExample.main("1C511A58ECC73874E0530100007FD01A","pptx");
        //spaceXExample.main("1C511A58ECC73874E0530100007FD01A","xlsx");
        //spaceXExample.main("1C511A58ECC73874E0530100007FD01A","docx");

        PrintJobTest printJobTest = new PrintJobTest();
        //printJobTest.prePendAppendSubTemplatesTest("1C511A58ECC73874E0530100007FD01A"); //contacts server and makes a download so is in comment

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

        LoopsTests loopsTests  = new LoopsTests();
        loopsTests.forEach();
        loopsTests.testForEachSheet();

        ImagesTests imagesTests =new ImagesTests();
        imagesTests.imageBase64();
        imagesTests.imageURL();

        RenderElementsTests renderElementsTests =new RenderElementsTests();
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
        //footnote, formula,HTML,MarkDownContent,PageBreak,Raw,RightToLeft don't need a test as they are all similar to Property.
    }
}
