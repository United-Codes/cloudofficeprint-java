package com.cloudofficeprint.Output;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

/**
 * Class of optional request option.
 * It holds the information that is used to send request.
 */
public class RequestOption {
    private String url;
    private JsonObject extraHeaders;

    /**
     * Returns valid url to which the output will be posted. It should start with http:// or https://
     * @return url as string
     */
    public String getUrl(){
        return url;
    }

    /**
     * Sets valid url to which the output will be posted. It should start with http:// or https://
     * @param url valid url as string
     */
    public void setUrl(String url){
        this.url = url;
    }

    /**
     * Returns any additional information to be included for the header, like authentication token, file id , access token etc. For this you can create an object array holding information and then assign it to extraHeaders.
     * @return jsonObject extraHeaders
     */
    public JsonObject getExtraHeaders(){
        return extraHeaders;
    }

    /**
     * Sets any additional information to be included for the header, like authentication token, file id , access token etc. For this you can create an object array holding information and then assign it to extraHeaders.
     * @param extraHeaders as jsonObject
     */
    public void setExtraHeaders(JsonObject extraHeaders){
        this.extraHeaders = extraHeaders;
    }

    /**
     *
     * 	 Constructor for the requestOption object. Set the options with the setters.
     * 	 Uninitialized options won't be included in the JSON.
     */
    public RequestOption(){
    }

    /**
     * Returns JSON-representation of request options
     * @return jsonObject
     */
    public JsonObject getJSON() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("url",getUrl());
        JsonObject test = new JsonObject();
        for (Map.Entry<String, JsonElement> tag : getExtraHeaders().entrySet()){
            test.add(tag.getKey(),tag.getValue());
        }
        System.out.println(test);
        jsonObject.add("extra_headers", test);

        return jsonObject;
    }
}
