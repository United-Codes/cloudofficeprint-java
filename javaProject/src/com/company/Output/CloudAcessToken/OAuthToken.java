package com.company.Output.CloudAcessToken;

import com.google.gson.JsonObject;

/**
 * Class to use for OAuth 2 tokens. For Dropbox, Google Drive and OneDrive.
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
