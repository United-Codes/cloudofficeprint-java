package com.CloudOfficePrint.Resources;

import com.CloudOfficePrint.RenderElements.RenderElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Abstract base class for external resources.
 */
public abstract class ExternalResource extends RenderElement {

    private String dataSource;
    private String endpoint;
    private String fileName;
    private JsonArray headers;
    private String auth;

    /**
     * @return Type of request: graphql or rest.
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource Type of request: graphql or rest
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return URL of the data source from where the JSON needs to be read.
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * @param endpoint URL of the data source from where the JSON needs to be read.
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * @return Name of the output file.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName Name of the output file.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return JsonArray of the HTTP headers, e.g. [{"Content-Type":"application/json"},{"Custom-Auth-Token":"xysazxklj4568asdf46a5sd4f"}]
     */
    public JsonArray getHeaders() {
        return headers;
    }

    /**
     * @param headers JsonArray of the HTTP headers, e.g. [{"Content-Type":"application/json"},{"Custom-Auth-Token":"xysazxklj4568asdf46a5sd4f"}]
     */
    public void setHeaders(JsonArray headers) {
        this.headers = headers;
    }

    /**
     * @return Basic authentication i.e. 'user:password' to compute an Authorization header.
     */
    public String getAuth() {
        return auth;
    }

    /**
     * @param auth Basic authentication i.e. 'user:password' to compute an Authorization header.
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * Abstract base class for external resources.
     * @param dataSource  Type of request: graphql or rest.
     * @param endpoint URL of the data source from where the JSON needs to be read.
     * @param fileName Name of the output file.
     * @param headers JsonArray of the HTTP headers, e.g. [{"Content-Type":"application/json"},{"Custom-Auth-Token":"xysazxklj4568asdf46a5sd4f"}]
     * @param auth Basic authentication i.e. 'user:password' to compute an Authorization header.
     */
    public ExternalResource(String dataSource, String endpoint, String fileName, JsonArray headers, String auth){
        setDataSource(dataSource);
        setEndpoint(endpoint);
        setFileName(fileName);
        setHeaders(headers);
        setAuth(auth);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("datasource", getDataSource());
        json.addProperty("endpoint", getEndpoint());
        if (getFileName()!=null){
            json.addProperty("filename",getFileName());
        }
        if (getHeaders()!=null){
            json.add("headers",getHeaders());
        }
        if (getAuth()!=null){
            json.addProperty("auth",getAuth());
        }
        return json;
    }
}
