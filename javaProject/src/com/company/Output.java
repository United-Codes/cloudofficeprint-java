package com.company;

import org.json.JSONObject;

public class Output {
    private String type;
    private String encoding;

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JSONObject getJSON(){
        JSONObject json = new JSONObject();
        json.put("output_type", type);
        json.put("output_encoding",encoding);
        return json;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getType() {
        return type;
    }
}
