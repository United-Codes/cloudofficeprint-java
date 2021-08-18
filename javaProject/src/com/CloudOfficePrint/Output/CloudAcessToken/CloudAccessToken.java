package com.CloudOfficePrint.Output.CloudAcessToken;

import com.google.gson.JsonObject;

/**
 * CloudAccessToken is an abstract class for all the different cloud access
 * tokens : OAuth tokens, AWS tokens,FTP/SFTP tokens
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
     * @param service Cloud service needs to be used for the output.
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return JSONObject with the tags for the cloudAccesToken for the Cloud Office
     *         Print server.
     */
    abstract public JsonObject getJSON();
}
