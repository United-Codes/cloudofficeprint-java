package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.company.Examples.Examples;
import com.company.Tests.Tests;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Examples example = new Examples();
        //example.localJson(); //works
        //example.localTemplate(); //works
        //example.loopExample(); //works
        //example.chartExample(); works

        Tests tests = new Tests();
        tests.testCombinedChart();
    }
}
