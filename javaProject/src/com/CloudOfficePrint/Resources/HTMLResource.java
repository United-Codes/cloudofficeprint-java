package com.CloudOfficePrint.Resources;

import com.google.gson.JsonObject;

/**
 * Child class of Resource. A class representing a resource with HTML data for
 * the AOP server.
 */
public class HTMLResource extends Resource {
    /**
     * HTML data in plain text.
     */
    private String HTML;

    /**
     * Whether the HTML should be rendered as landscape-oriented page (default
     * :false). Only supported for templates, will be neglected for secondary files.
     */
    private Boolean landscape = false;

    /**
     * Constructor for this class. Instantiates the HTML data to given argument.
     * 
     * @param HTML data for this resource.
     */
    HTMLResource(String HTML) {
        this.HTML = HTML;
    }

    /**
     * Constructor for this class. Instantiates the HTML data to the HTML argument
     * and the landscape option to landscape. Landscape option will be neglected for
     * secondary files (not templates).
     * 
     * @param HTML      data for this resource.
     * @param landscape Whether the HTML should be rendered as landscape-oriented
     *                  page (default :false)
     */
    public HTMLResource(String HTML, Boolean landscape) {
        this.HTML = HTML;
        this.landscape = landscape;
    }

    /**
     * @return HTML data of this resource.
     */
    public String getHTML() {
        return HTML;
    }

    /**
     * @return Whether the HTML should be rendered as landscape-oriented page.
     */
    public Boolean getLandscape() {
        return landscape;
    }

    /**
     * @return JSONObject with the tags for a HTML resource as template for the AOP
     *         server ("html_template_content","template_type" and "orientation" if
     *         specified).
     */
    @Override
    public JsonObject getJSONForTemplate() {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("template_type", "html");
        if (getLandscape() == true) {
            jsonResource.addProperty("orientation", "landscape");
        }
        jsonResource.addProperty("html_template_content", getHTML());
        return jsonResource;
    }

    /**
     * @return JSONObject with the tags ("mime_type","file_content","file_source")
     *         for an HTML resource as a secondary file (subtemplates, files to
     *         prepend, files to append and files to insert) for the AOP server.
     */
    @Override
    public JsonObject getJSONForSecondaryFile() {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("mime_type", getMimeType()); // changer ca vers mimetype
        jsonResource.addProperty("file_content", getHTML());
        jsonResource.addProperty("file_source", "file");
        return jsonResource;
    }

}
