package com.cloudofficeprint.RenderElements.PDF;

import com.google.gson.JsonObject;

/**
 * Class for a PDF form text box element.
 */
public class PDFFormTextBox extends PDFFormElement {

    /**
     * @return the type of this PDF form element. For this class it is always "text".
     */
    @Override
    public String getType() {
        return "text";
    }

    /**
     * @param name of this element.
     */
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
