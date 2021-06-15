package com.company;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class printJob {
    JSONObject jsonForServer = new JSONObject("");

    public void addToJSON(String key, String value) {
        jsonForServer.put(key,value);
    }
}
