package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.company.Examples.Examples;
import com.company.Tests.ChartTests;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Examples example = new Examples();
        //example.localJson(); //works
        //example.localTemplate(); //works
        //example.loopExample(); //works
        //example.chartExample(); //works
        //example.combinedChartExample(); //works

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
    }
}
