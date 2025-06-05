package com.cloudofficeprint.Resources;

import com.google.gson.JsonObject;

public class Template {

    private Resource resource;
    private String startDelimiter;
    private String endDelimiter;
    private Boolean shouldHash;
    private String templateHash;

    /**
     * Create a new Template.
     * 
     * @param resource the resource of this template.
     */
    public Template(Resource resource) {
        this(resource, null, null);
    }

    /**
     * Create a new Template.
     * 
     * @param resource       the resource of this template.
     * @param startDelimiter the starting delimiter used in the template.
     * @param endDelimiter   the ending delimiter used in the template.
     */
    public Template(Resource resource, String startDelimiter, String endDelimiter) {
        this(resource, startDelimiter, endDelimiter, null, null);
    }

    /**
     * Create a new Template.
     * 
     * @param resource       the resource of this template.
     * @param startDelimiter the starting delimiter used in the template.
     * @param endDelimiter   the ending delimiter used in the template.
     * @param shouldHash     whether the template should be hashed on the server.
     * @param templateHash   the hash of the template.
     */
    public Template(Resource resource, String startDelimiter, String endDelimiter, Boolean shouldHash,
            String templateHash) {
        this.resource = resource;
        this.startDelimiter = startDelimiter;
        this.endDelimiter = endDelimiter;
        this.shouldHash = shouldHash;
        this.templateHash = templateHash;
    }

    /**
     * Get the Resource of the Template.
     * 
     * @return the Resource of the Template.
     */
    public Resource getResource() {
        return this.resource;
    }

    /**
     * Set the Resource of the Template.
     * 
     * @param resource the Resource of the Template.
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * Get the starting delimiter of the Template.
     * 
     * @return the starting delimiter used in the template.
     */
    public String getStartDelimiter() {
        return this.startDelimiter;
    }

    /**
     * Set the starting delimiter of the Template.
     * 
     * @param startDelimiter the starting delimiter used in the template.
     */
    public void setStartDelimiter(String startDelimiter) {
        this.startDelimiter = startDelimiter;
    }

    /**
     * Get the ending delimiter of the Template.
     * 
     * @return the ending delimiter used in the template.
     */
    public String getEndDelimiter() {
        return this.endDelimiter;
    }

    /**
     * Set the ending delimiter of the Template.
     * 
     * @param endDelimiter the ending delimiter used in the template.
     */
    public void setEndDelimiter(String endDelimiter) {
        this.endDelimiter = endDelimiter;
    }

    /**
     * Set both starting and ending delimiters.
     * 
     * @param startDelimiter the starting delimiter used in the template.
     * @param endDelimiter   the ending delimiter used in the template.
     */
    public void setDelimiter(String startDelimiter, String endDelimiter) {
        this.startDelimiter = startDelimiter;
        this.endDelimiter = endDelimiter;
    }

    /**
     * Get the shouldHash value of the Template.
     * 
     * @return whether the template should be hashed on the server.
     */
    public Boolean getShouldHash() {
        return this.shouldHash;
    }

    /**
     * Set the shouldHash value of the Template.
     * 
     * @param shouldHash whether the template should be hashed on the server.
     */
    public void setShouldHash(Boolean shouldHash) {
        this.shouldHash = shouldHash;
    }

    /**
     * Get the hash of the template.
     * 
     * @return the hash of the template.
     */
    public String getTemplateHash() {
        return this.templateHash;
    }

    /**
     * Set the hash of the template.
     * 
     * @param templateHash the hash of the template.
     */
    public void setTemplateHash(String templateHash) {
        this.templateHash = templateHash;
    }

    /**
     * Update the Template to store a hash. On the next request to the server, the
     * file data will not be sent, only the hash of the template.
     * 
     * @param templateHash the hash of the template.
     */
    public void updateHash(String templateHash) {
        this.templateHash = templateHash;
        this.shouldHash = false;
    }

    /**
     * Reset the stored hash of the template.
     */
    public void resetHash() {
        this.resetHash(true);
    }

    /**
     * Reset the stored hash of the template.
     * 
     * @param shouldHash whether the template should be hashed on the server,
     *                   defaults to true.
     */
    public void resetHash(Boolean shouldHash) {
        this.templateHash = null;
        this.shouldHash = shouldHash;
    }

    /**
     * Get the JSON object for the Template.
     * 
     * @return the JSON representation of the Template.
     */
    public JsonObject getJSONForTemplate() {
        if (this.templateHash != null && this.shouldHash) {
            JsonObject jsonTemplate = new JsonObject();
            jsonTemplate.addProperty("template_type", this.resource.getFiletype());
            jsonTemplate.addProperty("template_hash", this.templateHash);
            if (this.startDelimiter != null)
                jsonTemplate.addProperty("start_delimiter", this.startDelimiter);
            if (this.endDelimiter != null)
                jsonTemplate.addProperty("end_delimiter", this.endDelimiter);
            return jsonTemplate;
        }
        JsonObject jsonTemplate = resource.getJSONForTemplate();
        if (this.startDelimiter != null)
            jsonTemplate.addProperty("start_delimiter", this.startDelimiter);
        if (this.endDelimiter != null)
            jsonTemplate.addProperty("end_delimiter", this.endDelimiter);
        if (this.shouldHash != null)
            jsonTemplate.addProperty("should_hash", this.shouldHash);
        if (this.templateHash != null)
            jsonTemplate.addProperty("template_hash", this.templateHash);
        return jsonTemplate;
    }

}
