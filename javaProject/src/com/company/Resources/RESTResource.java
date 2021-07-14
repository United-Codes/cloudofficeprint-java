package com.company.Resources;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Set;

/**
 * Class for working with a REST endpoint as Resource.
 */
public class RESTResource extends ExternalResource{

    private String method = "GET";
    private String body;

    /**
     * @return HTTP method of the request.
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method  HTTP method of the request. "GET" by default.
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return Body of HTTP request (can be left empty for GET requests).
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body Body of HTTP request (can be left empty for GET requests).
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Resource from an REST endpoint.
     * @param endpoint   URL of the data source from where the JSON needs to be read.
     * @param method  HTTP method of the request. "GET" by default.
     * @param body Body of HTTP request (can be left empty for GET requests)
     * @param fileName   Name of the output file.
     * @param headers    HTTP headers, e.g. [{"Content-Type":"application/json"},{"Custom-Auth-Token":"xysazxklj4568asdf46a5sd4f"}]
     * @param auth       Basic authentication i.e. 'user:password' to compute an Authorization header.
     */
    public RESTResource(String endpoint, String method, String body, String fileName, JsonArray headers, String auth) {
        super("rest", endpoint, fileName, headers, auth);
        setMethod(method);
        setBody(body);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = super.getJSON();
        if (getMethod()!=null){
            json.addProperty("method",getMethod());
        }
        if (getBody()!=null){
            json.addProperty("body",getBody());
        }
        return json;
    }

    /**
     * Cannot be used for a resource.
     * @return null
     */
    @Override
    public Set<String> getTemplateTags() {
        return null;
    }
}
