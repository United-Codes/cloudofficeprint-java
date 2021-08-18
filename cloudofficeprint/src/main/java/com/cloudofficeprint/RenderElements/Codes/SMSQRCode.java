package com.cloudofficeprint.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class is a subclass of QRCode and is used to generate an SMS QR-code
 * element.
 */
public class SMSQRCode extends QRCode {

    private String body;

    /**
     * @return Body of the SMS.
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body Body of the SMS.
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * This object represents a SMS QR-code. Styling options can be set with the
     * setter functions of the upper class.
     * 
     * @param name     Name of this code for the tag.
     * @param receiver Phone number of the receiver.
     * @param body     Body of the SMS.
     */
    public SMSQRCode(String name, String receiver, String body) {
        super(name, "qr_sms", receiver);
        setBody(body);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = super.getJSON();
        if (getBody() != null) {
            json.addProperty(getName() + "_sms_body", getBody());
        }
        return json;
    }
}
