package com.CloudOfficePrint.Resources;

import com.google.gson.JsonObject;

/**
 * Child class of Resource. A class representing a resource (file) located on a
 * URL.
 */
public class URLResource extends Resource {

    /**
     * URL of the resource.
     */
    private String URL;

    /**
     * Constructor for this class. For a URL resource you have to specify the
     * filetype (extension) and mimetype because it can't be deduced.
     * 
     * @param URL      of the resource
     * @param filetype extension of the resource
     * @param mimeType of the resource
     */
    public URLResource(String URL, String filetype, String mimeType) {
        setURL(URL);
        setFiletype(filetype);
        setMimeType(mimeType);
    }

    /**
     * @return URL of the resource.
     */
    public String getURL() {
        return URL;
    }

    /**
     * Sets the URL of the resource to given URL.
     * 
     * @param URL of the resource.
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * @return JSONObject with the tags for a URL resource as template for the AOP
     *         server ("url","template_type").
     */
    @Override
    public JsonObject getJSONForTemplate() {
        JsonObject json = new JsonObject();
        json.addProperty("url", getURL());
        json.addProperty("template_type", getFiletype());
        return json;
    }

    /**
     * @return JSONObject with the tags ("mime_type","file_url","file_source") for a
     *         URL resource as a secondary file (subtemplates, files to prepend,
     *         files to append and files to insert) for the AOP server.
     */
    @Override
    public JsonObject getJSONForSecondaryFile() {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("mime_type", getMimeType()); // changer ca vers mimetype
        jsonResource.addProperty("file_url", getURL());
        jsonResource.addProperty("file_source", "file");
        return jsonResource;
    }

}
