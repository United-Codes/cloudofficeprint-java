package com.company;

//https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#run_jar_artifact will be usefull to build the JAR

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("hello world");
        Server server = new Server();
        server.sendGETRequest("http://localhost:8010/supported_template_mimetypes"); // /marco for polo
        //server.sendPOSTRequest("http://localhost:8010");
    }
}
