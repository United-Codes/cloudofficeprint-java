package com.cloudofficeprint.RenderElements.Form;

import com.google.gson.JsonObject;

public class Checkbox extends FormElement {
    private Boolean checked;
    private String text;

    /**
     * @param name Unique identifier matching template tag
     * @param checked Initial checked state (null for empty)
     * @param text Text label for the checkbox
     */
    public Checkbox(String name, Boolean checked, String text) {
        super(name, "checkbox");
        setChecked(checked);
        setText(text);
        setValue(checked != null ? (checked ? "1" : "0") : null);
    }

    /**
     * @return Current checked state of the checkbox
     */
    public Boolean getChecked() { return checked; }
    /**
     * @param checked Checked state to set for the checkbox
     */
    public void setChecked(Boolean checked) {this.checked = checked;
        setValue(checked != null ? (checked ? "1" : "0") : null);
    }
    /**
     * @return Text label for the checkbox
     */
    public String getText() { return text; }
    /**
     * @param text Text label to set for the checkbox
     */
    public void setText(String text) { this.text = text; }

    @Override
    protected void populateProperties(JsonObject props) {
        if (getChecked() != null)
            props.addProperty("value",
                    getChecked() ? 1 : 0);
        if (getText() != null)
            props.addProperty("text",
                    getText());
    }
}