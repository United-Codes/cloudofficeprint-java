package com.CloudOfficePrint.Output.CloudAcessToken;

import com.google.gson.JsonObject;

/**
 * Class to use for AWS tokens to store output on AWS.
 */
public class AWSToken extends CloudAccessToken {

    /**
     * AWS access key ID.
     */
    private String keyID;

    /**
     * AWS secret key.
     */
    private String secretKey;

    /**
     * @return AWS secret key.
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * @return AWS key ID.
     */
    public String getKeyID() {
        return keyID;
    }

    /**
     * @param keyID AWS keyID.
     */
    public void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    /**
     * @param secretKey AWS secret key.
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Constructor for an AWSToken object. Needs to be used if output wants to be
     * stored on AWS.
     * 
     * @param keyID     AWS access key ID.
     * @param secretKey AWS secret key.
     */
    public AWSToken(String keyID, String secretKey) {
        setService("aws_s3");
        setKeyID(keyID);
        setSecretKey(secretKey);
    }

    /**
     * @return JSONObject with the tags for the AWSToken for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("output_location", getService());
        JsonObject token = new JsonObject();
        token.addProperty("access_key", getKeyID());
        token.addProperty("secret_access_key", getSecretKey());
        json.add("cloud_access_token", token);
        return json;
    }
}
