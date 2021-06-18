package com.company.Resources;

import org.json.JSONObject;

public class ServerResource extends Resource{
    private String path;
    private String ext;

    ServerResource(String path) throws Exception {
        this.path = path;
        this.ext = getExtension(path);
    }

    @Override
    public JSONObject getJSON() {
        JSONObject json = new JSONObject();
        json.put("template_type", ext);
        json.put("filename",path);
        return json;
    }
}
