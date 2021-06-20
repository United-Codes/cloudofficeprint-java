package com.company;


import com.google.gson.JsonObject;

public class Output {
    private String type;
    private String encoding;

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonObject getJSON(){
        JsonObject json = new JsonObject();
        json.addProperty("output_type", type);
        json.addProperty("output_encoding",encoding);
        return json;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getType() {
        return type;
    }
}
