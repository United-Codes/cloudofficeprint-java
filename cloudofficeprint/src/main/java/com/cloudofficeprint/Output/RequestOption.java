package com.cloudofficeprint.Output;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for a request option of the output configuration.
 */
public class RequestOption {

    private String url;
    private Map<String, String> extraHeader = new HashMap<>();

    /**
     * @return url to which the response will be posted.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url to which the response will be posted.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return any additional information to be included for the header.
     */
    public Map<String, String> getExtraHeader() {
        return extraHeader;
    }

    /**
     * @param extraHeader any additional information to be included for the header.
     */
    public void setExtraHeader(Map<String, String> extraHeader) {
        this.extraHeader = extraHeader;
    }

    /**
     * @param url to which the response will be posted.
     */
    public RequestOption(String url){
        setUrl(url);
    }

    /**
     * @return JSONObject representing the request option. To be send to the Cloud Office Print server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("url", getUrl());

        if (getExtraHeader().size() != 0){
            JsonObject headers = new JsonObject();
            for (Map.Entry<String, String> header : getExtraHeader().entrySet()){
                headers.addProperty(header.getKey(), header.getValue());
            }
            json.add("extra_headers", headers);
        }

        return json;
    }
}
