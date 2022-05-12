package com.cloudofficeprint.RenderElements.PDF;

import com.google.gson.JsonObject;

public class PDFFormTextBox extends PDFFormElement {

    @Override
    public String getType() {
        return "text";
    }

    public PDFFormTextBox(String name){
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

        if (getValue() != null){
            innerJson.addProperty("value", getValue());
        }

        return json;
    }
}
