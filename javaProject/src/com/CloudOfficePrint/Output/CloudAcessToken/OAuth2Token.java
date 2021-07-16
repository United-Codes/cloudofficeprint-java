package com.CloudOfficePrint.Output.CloudAcessToken;

import com.google.gson.JsonObject;

/**
 * Class to use for OAuth 2 tokens. To store output on Dropbox, Google Drive or OneDrive.
 */
public class OAuth2Token extends CloudAccessToken {

    /**
     * OAuth 2 access token.
     */
    private String token;

    /**
     * @return OAuth 2 access token.
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token OAuth 2 access token.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Constructor for an OAuth2Token object. Needs to be used if output wants to be stored on Dropbox, Google Drive or OneDrive.
     * @param service Dropbox, Google Drive or OneDrive
     * @param token OAuth2Token
     */
    public OAuth2Token(String service, String token){
        setService(service);
        setToken(token);
    }

    /**
     * @return JSONObject with the tags for the OAuth2token for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("output_location",getService());
        json.addProperty("cloud_access_token",getToken());
        return json;
    }
}
