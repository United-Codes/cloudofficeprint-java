package com.cloudofficeprint.RenderElements.PDF;

import com.google.gson.JsonObject;

public class PDFFormRadioButton extends PDFFormElement {

    private String group;
    private String text;
    private Boolean selected;

    @Override
    public String getType() {
        return "radio";
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

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
