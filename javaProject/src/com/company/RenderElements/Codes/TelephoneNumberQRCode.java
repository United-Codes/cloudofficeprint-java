package com.company.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class is a subclass of QRCode and is used to generate a telephone number QR-code element.
 */
public class TelephoneNumberQRCode extends QRCode{
    /**
     * This object represents a telephone number QR-code. Styling options can be set with the setter functions of the upper class.
     * @param name  Name of this code for the tag.
     * @param number Phone number to create the code from.
     */
    public TelephoneNumberQRCode(String name, String number) {
        super(name, "qr_telephone", number);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON(){
        return super.getJSON();
    }
}
