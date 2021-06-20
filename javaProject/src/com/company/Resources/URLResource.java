package com.company.Resources;


import com.google.gson.JsonObject;
import org.apache.tika.mime.MimeTypeException;

import java.net.URL;

public class URLResource extends Resource{
    private String url;

    public URLResource(String url, String filetype, String mimeType){
        setUrl(url);
        setFiletype(filetype);
        setMimeType(mimeType);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public JsonObject getJSONForSecondaryFile() throws MimeTypeException {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("mime_type",getMimeType()); //changer ca vers mimetype
        jsonResource.addProperty("file_url", getUrl());
        jsonResource.addProperty("file_source","file");
        return jsonResource;
    }

    @Override
    public JsonObject getJSONForTemplate() {
        JsonObject json = new JsonObject();
        json.addProperty("url", url);
        json.addProperty("template_type", url);
        return json;
    }

}
