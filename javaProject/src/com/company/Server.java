package com.company;

import com.sun.tools.internal.ws.wsdl.document.Output;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Server {

    int APIKey;
    String loginInfo;
    String url;

    Server(){
    }

    Server(String url){
        url = url;
    }

    boolean isReachable(Server server){
        return false;
    }

    public void sendGETRequest(String urlToJoin) throws IOException {
        String url = urlToJoin;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response.toString());

        //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");
        System.out.println(myResponse);
        System.out.println(myResponse.get("docx"));
    }
    public void sendPOSTRequest(String urlToJoin) throws IOException {
        String post_data = "key1=value1&key2=value2";
        String url = urlToJoin;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        OutputStream outputStream = con.getOutputStream();
        outputStream.write(post_data.getBytes());
        outputStream.flush();
        outputStream.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response.toString());

        //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");
        System.out.println(myResponse.get("args"));
        System.out.println(myResponse);
        //System.out.println("statusCode- "+myResponse.getString("statusCode"));
    }
}
