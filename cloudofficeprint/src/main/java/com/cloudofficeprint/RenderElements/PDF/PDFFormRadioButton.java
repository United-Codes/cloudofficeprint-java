package com.cloudofficeprint.RenderElements.PDF;

import com.google.gson.JsonObject;

/**
 * Class for a PDF form radio button element.
 */
public class PDFFormRadioButton extends PDFFormElement {

    private String group;
    private String text;
    private Boolean selected;

    /**
     * @return the type of this PDF form element. For this class it is always "radio".
     */
    @Override
    public String getType() {
        return "radio";
    }

    /**
     * @return group name of radio buttons that are interconnected.
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group name of radio buttons that are interconnected.
     */
    public void setGroup(String group) {
        this.group = group;
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
     * @return whether the radio button is selected.
     */
    public Boolean getSelected() {
        return selected;
    }

    /**
     * @param selected whether the radio button is selected.
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    /**
     * @param name of this element.
     */
    public PDFFormRadioButton(String name){
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

        innerJson.remove("name");
        if (getGroup() != null){
            innerJson.addProperty("name", getGroup());
        }
        else innerJson.addProperty("name", getName());

        if (getValue() != null){
            innerJson.addProperty("value", getValue());
        }
        if (getText() != null){
            innerJson.addProperty("text", getText());
        }
        if (getSelected() != null){
            innerJson.addProperty("selected", getSelected());
        }

        return json;
    }
}
