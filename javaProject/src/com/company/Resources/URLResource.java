package com.company.Resources;

import org.json.JSONObject;

public class URLResource {
    private String url;
    private String filetype;

    public String getUrl() {
        return url;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONObject getJSON(){
        JSONObject json = new JSONObject();
        json.put("url", url);
        json.put("template_type", url);
        return json;
    }
}
