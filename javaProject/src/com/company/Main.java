package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import com.company.Examples.Examples;
import com.company.Output.Output;
import com.company.RenderElements.AOPChart;
import com.company.RenderElements.Property;
import com.company.RenderElements.RenderElement;
import com.company.Resources.Base64Resource;
import com.company.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws IOException {
        Examples example = new Examples();
        example.localTemplate();
        example.localJson();
    }
}
