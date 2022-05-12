package com.cloudofficeprint.RenderElements.PDF;

import com.google.gson.JsonObject;

public class PDFFormCheckBox extends PDFFormElement {

    private String text;

    @Override
    public String getType() {
        return "checkbox";
    }

    public Boolean getCheck() {
        return getValue() == null ? null :  Boolean.valueOf(getValue());
    }

    public void setCheck(Boolean check) {
        setValue(check == null ? null : String.valueOf(check));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

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
