package com.cloudofficeprint.RenderElements.PDF;

import com.google.gson.JsonObject;

/**
 * Class for a PDF form checkbox element.
 */
public class PDFFormCheckBox extends PDFFormElement {

    private String text;

    /**
     * @return the type of this PDF form element. For this class it is always "checkbox".
     */
    @Override
    public String getType() {
        return "checkbox";
    }

    /**
     * @return whether the checkbox is checked.
     */
    public Boolean getCheck() {
        return getValue() == null ? null :  Boolean.valueOf(getValue());
    }

    /**
     * @param check whether the checkbox is checked.
     */
    public void setCheck(Boolean check) {
        setValue(check == null ? null : String.valueOf(check));
    }

    /**
     * @return text used as a label.
     */
    public String getText() {
        return text;
    }

    /**
     * @param text used as a label.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @param name of this element.
     */
    public PDFFormCheckBox(String name){
        super(name);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON(){
        JsonObject json = super.getJSON();
        JsonObject innerJson = json.getAsJsonObject(getName());

        if (getCheck() != null){
            innerJson.addProperty("value", getCheck());
        }
        if (getText() != null){
            innerJson.addProperty("text", getText());
        }

        return json;
    }
}
