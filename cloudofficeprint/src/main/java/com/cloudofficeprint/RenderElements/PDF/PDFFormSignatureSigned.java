package com.cloudofficeprint.RenderElements.PDF;

import com.google.gson.JsonObject;

public class PDFFormSignatureSigned extends PDFFormSignature {

    private String password;
    private String size;
    private String backgroundImage;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    public String getType() {
        return "signaturefieldsigned";
    }

    public PDFFormSignatureSigned(String name, String value){
        super(name);
        setValue(value);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON(){
        JsonObject json = super.getJSON();
        JsonObject innerJson = json.getAsJsonObject(getName());

        innerJson.addProperty("value", getValue());

        if (getPassword() != null){
            innerJson.addProperty("password", getPassword());
        }
        if (getSize() != null){
            innerJson.addProperty("size", getSize());
        }
        if (getBackgroundImage() != null){
            innerJson.addProperty("background_image", getBackgroundImage());
        }

        return json;
    }
}
