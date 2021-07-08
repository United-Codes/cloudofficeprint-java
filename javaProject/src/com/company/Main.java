package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.company.Examples.Examples;
import com.company.Tests.ChartTests;
import com.company.Tests.CodesTests;
import com.company.Tests.ConfigTests;
import com.company.Tests.GeneralTests;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        Examples example = new Examples();
        //example.localJson();
        //example.localTemplate();
        //example.loopExample();
        //example.chartExample();
        //example.combinedChartExample();
        //example.qrCodeExample();

        GeneralTests generalTests = new GeneralTests();
        generalTests.ResourceTest();
        generalTests.PrePendAppendSubTemplatesTest();
        generalTests.ResourceTest();
        generalTests.ResourceTest();
        generalTests.ResourceTest();
        generalTests.ResourceTest();
        generalTests.ResourceTest();
        generalTests.ResourceTest();
        generalTests.ResourceTest();

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
    }
}
