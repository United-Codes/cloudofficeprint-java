package com.CloudOfficePrint.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class is a subclass of QRCode and is used to generate an URL QR-code element.
 */
public class URLQRCode extends QRCode{
    /**
     * This object represents a URL QR-code.
     * Styling options can be set with the setter functions of the upper class.
     * @param name  Name of this code for the tag.
     * @param url Data to create the code from.
     */
    public URLQRCode(String name, String url) {
        super(name, "qr_url", url);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON(){
        return super.getJSON();
    }
}
