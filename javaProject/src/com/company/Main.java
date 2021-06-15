package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import org.json.JSONObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("hello world");
        Server server = new Server("http://localhost:8010");

        String ret = server.readJson("./src/test.json");
        JSONObject jsonObject=new JSONObject(ret);
        Boolean isReachable = server.isReachable();
        if (isReachable==true){
            server.sendPOSTRequest("http://localhost:8010", jsonObject);
        }
    }
}
