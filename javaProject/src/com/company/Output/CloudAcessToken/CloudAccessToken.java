package com.company.Output.CloudAcessToken;

import com.google.gson.JsonObject;

/**
 * CloudAccessToken is an abstract class for all the different cloud access tokens : OAuth tokens, AWS tokens,FTP/SFTP tokens
 */
public abstract class CloudAccessToken {

    /**
     * Which cloud service is used.
     */
    private String service;

    /**
     * @return which cloud service needs to be used for the output.
     */
    public String getService() {
        return service;
    }

    /**
     * Sets which cloud service needs to be used for the output.
     * @param service
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return JSONObject with the tags for the cloudAccesToken for the AOP server.
     */
    abstract public JsonObject getJSON();
}