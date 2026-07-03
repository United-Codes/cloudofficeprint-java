package com.cloudofficeprint.RenderElements.Form;

import com.google.gson.JsonObject;

public class RadioButton extends FormElement {
    private String text;
    private Boolean selected;

    /**
     * @param name Unique identifier matching template tag
     * @param value Initial value of the radio button (null for empty)
     * @param text Text label for the radio button
     * @param selected Initial selected state (true/false)
     */
    public RadioButton(String name, String value, String text, Boolean selected) {
        super(name, "radio");
        setValue(value);
        setText(text);
        setSelected(selected);
    }

    /**
     * @return Current value of the radio button
     */
    public String getText() { return text; }
    /**
     * @param text Text label to set for the radio button
     */
    public void setText(String text) { this.text = text; }
    /**
     * @return Current selected state of the radio button
     */
    public Boolean getSelected() { return selected; }
    /**
     * @param selected Selected state to set for the radio button
     */
    public void setSelected(Boolean selected)
    { this.selected = selected; }


    @Override
    protected void populateProperties(JsonObject props) {
        if (getValue() != null)
            props.addProperty("value", getValue());
        if (getText() != null)
            props.addProperty("text", getText());
        if (getSelected() != null)
            props.addProperty("selected", getSelected());
    }
}