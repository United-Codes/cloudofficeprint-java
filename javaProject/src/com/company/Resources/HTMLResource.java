package com.company.Resources;

import com.google.gson.JsonObject;
import org.apache.tika.mime.MimeTypeException;

public class HTMLResource extends Resource {
    private String html;
    private Boolean landscape = false; //optional false by default

    HTMLResource(String html){
        this.html = html;
    }

    HTMLResource(String html, Boolean landscape){
        this.html = html;
        this.landscape = landscape;
    }

    public String getHtml() {
        return html;
    }

    public Boolean getLandscape() {
        return landscape;
    }

    @Override
    public JsonObject getJSONForTemplate() {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("template_type", "html");
        jsonResource.addProperty("html_template_content",getHtml());
        if (getLandscape() == true){
            jsonResource.addProperty("orientation", "landscape");
        }
        return jsonResource;
    }

    @Override
    public JsonObject getJSONForSecondaryFile() throws MimeTypeException {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("mime_type",getMimeType()); //changer ca vers mimetype
        jsonResource.addProperty("file_content", getHtml());
        jsonResource.addProperty("file_source","file");
        return jsonResource;
    }

}
