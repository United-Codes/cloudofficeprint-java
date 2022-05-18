package com.cloudofficeprint.Resources;

import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * Class for a template resource. A template has extra optional options, like delimiters and template hash.
 * To create a Template, use the static from methods.
 */
public class Template extends Resource{
    private Resource resource;
    private String startDelimiter;
    private String endDelimiter;
    private Boolean shouldHash;
    private String hash;

    /**
     * @return resource of this template.
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * @param resource of this template.
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * @return the starting delimiter used in the template.
     */
    public String getStartDelimiter() {
        return startDelimiter;
    }

    /**
     * @param startDelimiter the starting delimiter used in the template.
     */
    public void setStartDelimiter(String startDelimiter) {
        this.startDelimiter = startDelimiter;
    }

    /**
     * @return the ending delimiter used in the template.
     */
    public String getEndDelimiter() {
        return endDelimiter;
    }

    /**
     * @param endDelimiter the ending delimiter used in the template.
     */
    public void setEndDelimiter(String endDelimiter) {
        this.endDelimiter = endDelimiter;
    }

    /**
     * @return whether the template should be hashed on the Cloud Office Print server.
     */
    public Boolean getShouldHash() {
        return shouldHash;
    }

    /**
     * @param shouldHash whether the template should be hashed on the Cloud Office Print server.
     */
    public void setShouldHash(Boolean shouldHash) {
        this.shouldHash = shouldHash;
    }

    /**
     * @return hash of the template.
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash of the template.
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * @return The mimetype of the template.
     */
    @Override
    public String getMimeType() {
        return resource.getMimeType();
    }

    /**
     * @return The template type as extension e.g. : docx.
     */
    @Override
    public String getFiletype() {
        return resource.getFiletype();
    }

    /**
     * Sets the mimetype of the template to the given mimetype.
     *
     * @param mimeType The template's mimetype.
     */
    @Override
    public void setMimeType(String mimeType) {
        resource.setMimeType(mimeType);
    }

    /**
     * Sets the filetype (extension) of the template to the given filetype.
     *
     * @param filetype extension of the template.
     */
    @Override
    public void setFiletype(String filetype) {
        resource.setFiletype(filetype);
    }

    /**
     *
     * @param resource of this template.
     * @param startDelimiter the starting delimiter used in the template.
     * @param endDelimiter the ending delimiter used in the template.
     * @param shouldHash whether the template should be hashed on the Cloud Office Print server.
     * @param hash of the template.
     */
    public Template(Resource resource, String startDelimiter, String endDelimiter, Boolean shouldHash, String hash) {
        setResource(resource);
        setStartDelimiter(startDelimiter);
        setEndDelimiter(endDelimiter);
        setShouldHash(shouldHash);
        setHash(hash);
    }

    /**
     * Sets template hash to null and shouldHash to null
     */
    public void resetHash(){
        resetHash(null);
    }

    /**
     * Sets template hash to null and shouldHash to the given boolean
     * @param shouldHash value that will be assigned to shouldHash.
     */
    public void resetHash(Boolean shouldHash){
        if (shouldHash != null){
            this.shouldHash = null;
        }
        hash = null;
    }

    /**
     * Updates template hash with the given hash and sets shouldHash to false.
     * @param hash which is assigned to template hash.
     */
    public void updateHash(String hash){
        setShouldHash(false);
        setHash(hash);
    }

    /**
     * Needs to be called to get the JSON of a resource for a template.
     *
     * @return JsonObject to add in the JSON for the server.
     */
    @Override
    public JsonObject getJSONForTemplate() {
        return resource.getJSONForTemplate();
    }

    /**
     * Needs to be used to get the JSON of a resource for a secondary file (file to
     * prepend, to append, to insert or subtemplate), because their JSON has a
     * different format then for a template.
     *
     * @return JsonObject to add in the JSON for the server.
     */
    @Override
    public JsonObject getJSONForSecondaryFile() {
        return resource.getJSONForSecondaryFile();
    }

    /**
     * Create a new instance of a Template from base64.
     * @param filetype Type (extension) of the template e.g. : docx (not docx. !).
     * @param database64 Data of the template base64 encoded.
     * @param startDelimiter the starting delimiter used in the template.
     * @param endDelimiter the ending delimiter used in the template.
     * @param shouldHash whether the template should be hashed on the Cloud Office Print server.
     * @param hash of the template.
     * @return Template created from base64.
     * @throws Exception If the mimetype is not found.
     */
    public static Template fromBase64(String filetype, String database64, String startDelimiter, String endDelimiter, Boolean shouldHash, String hash) throws Exception {
        return new Template(new Base64Resource(filetype, database64), startDelimiter, endDelimiter, shouldHash, hash);
    }

    /**
     * Create a new instance of a Template from a local file.
     * @param filePath Path of the local file.
     * @param startDelimiter the starting delimiter used in the template.
     * @param endDelimiter the ending delimiter used in the template.
     * @param shouldHash whether the template should be hashed on the Cloud Office Print server.
     * @param hash of the template.
     * @return Template created from a local file
     * @throws IOException If file not found.
     * @throws Exception If the extension of the file is not found.
     * @throws Exception If the mimetype is not found.
     */
    public static Template fromLocalFile(String filePath, String startDelimiter, String endDelimiter, Boolean shouldHash, String hash) throws Exception {
        Base64Resource resource = new Base64Resource();
        resource.setFileFromLocalFile(filePath);
        return new Template(resource, startDelimiter, endDelimiter, shouldHash, hash);
    }

    /**
     * Create a new instance of a Template from HTML.
     * @param HTML data for this template.
     * @param landscape Whether the HTML should be rendered as landscape-oriented page (default :false)
     * @param startDelimiter the starting delimiter used in the template.
     * @param endDelimiter the ending delimiter used in the template.
     * @param shouldHash whether the template should be hashed on the Cloud Office Print server.
     * @param hash of the template.
     * @return Template created from HTML.
     */
    public static Template fromHTML(String HTML, Boolean landscape, String startDelimiter, String endDelimiter, Boolean shouldHash, String hash) {
        return new Template(new HTMLResource(HTML, landscape), startDelimiter, endDelimiter, shouldHash, hash);
    }

    /**
     * Create a new instance of a Template from a path on the Cloud Office Print server.
     * @param path Path of the file on the Cloud Office Print server.
     * @param mimeType Mimetype of the file on the Cloud Office Print server.
     * @param startDelimiter the starting delimiter used in the template.
     * @param endDelimiter the ending delimiter used in the template.
     * @param shouldHash whether the template should be hashed on the Cloud Office Print server.
     * @param hash of the template.
     * @return Template created from a path on the Cloud Office Print server.
     * @throws IOException if mimetype can't be deduced.
     * @throws Exception if extension can't be deduced.
     */
    public static Template fromServerPath(String path, String mimeType, String startDelimiter, String endDelimiter, Boolean shouldHash, String hash) throws Exception {
        return new Template(new ServerResource(path, mimeType), startDelimiter, endDelimiter, shouldHash, hash);
    }

    /**
     * Create a new instance of a Template from a URL.
     * @param URL of the template.
     * @param filetype extension of the template.
     * @param mimeType of the template.
     * @param startDelimiter the starting delimiter used in the template.
     * @param endDelimiter the ending delimiter used in the template.
     * @param shouldHash whether the template should be hashed on the Cloud Office Print server.
     * @param hash of the template.
     * @return Template created from a URL.
     */
    public static Template fromURL(String URL, String filetype, String mimeType, String startDelimiter, String endDelimiter, Boolean shouldHash, String hash) {
        return new Template(new URLResource(URL, filetype, mimeType), startDelimiter, endDelimiter, shouldHash, hash);
    }
}
