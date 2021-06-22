package com.company.Output.CloudAcessToken;

import com.google.gson.JsonObject;

/**
 * Class to use for OAuth tokens. For Dropbox, Google Drive and OneDrive.
 */
public class OAuthToken extends CloudAccessToken {

    /**
     * OAuth 2 access token
     */
    private String token;

    /**
     * @return OAuth 2 access token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the OAuth 2 access token.
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Constructor for an OAuthToken object. Needs to be used if output wants to be stored on Dropbox, Google Drive or OneDrive.
     * @param service Dropbox, Google Drive or OneDrive
     * @param token OAuthToken 
     */
    public OAuthToken(String service, String token){
        setService(service);
        setToken(token);
    }

    /**
     * @return JSONObject with the tags for the OAuthtoken for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("output_location",getService());
        json.addProperty("cloud_access_token",getToken());
        return json;
    }
}
