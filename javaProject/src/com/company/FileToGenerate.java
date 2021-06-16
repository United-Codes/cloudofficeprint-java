package com.company;

import org.json.JSONObject;

public class FileToGenerate {
    String name;
    JSONObject data;

    public void setData(JSONObject data) {
        this.data = data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject getData() {
        return data;
    }

    public String getName() {
        return name;
    }
}
