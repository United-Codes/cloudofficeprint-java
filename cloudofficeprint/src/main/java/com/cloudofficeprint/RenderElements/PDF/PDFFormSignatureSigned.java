package com.cloudofficeprint.RenderElements.PDF;

import com.google.gson.JsonObject;

/**
 * Class for a signed PDF signature field element.
 */
public class PDFFormSignatureSigned extends PDFFormSignature {

    private String password;
    private String size;
    private String backgroundImage;

    /**
     * @return the type of this PDF form element. For this class it is always "signaturefieldsigned".
     */
    @Override
    public String getType() {
        return "signaturefieldsigned";
    }

    /**
     * @return password for if the certificate is encrypted
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password for if the certificate is encrypted
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return size of the signature field, must be either "sm" for small, "md" for medium or "lg" for large.
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size of the signature field, must be either "sm" for small, "md" for medium or "lg" for large.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return background image as a base64 string, URL, FTP location or a server path.
     */
    public String getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * @param backgroundImage as a base64 string, URL, FTP location or a server path.
     */
    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    /**
     * @param name of this element.
     * @param value signing certificate as a base64 string, URL, FTP location or a server path.
     */
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
