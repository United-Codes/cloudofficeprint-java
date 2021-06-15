package com.company;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Server {

    int APIKey;
    String loginInfo;
    String url;

    Server(String url){
        url = url;
    }

    boolean isReachable(Server server){
        return false;
    }

    void main() throws IOException {
        String url = "www.example.com";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
    }
}
