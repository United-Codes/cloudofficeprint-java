package com.cloudofficeprint.RenderElements.Form;

import com.google.gson.JsonObject;

/**
 * A value/label pair for choice form elements (Dropdown, ComboBox, ListBox).
 */
public class ChoiceOption {
    private String value;
    private String label;

    /**
     * @param value the option value (required).
     * @param label the label shown for the option; if null, the value is shown.
     */
    public ChoiceOption(String value, String label) {
        this.value = value;
        this.label = label;
    }

    /**
     * @param value the option value (required). The value is also shown as the label.
     */
    public ChoiceOption(String value) {
        this(value, null);
    }

    /**
     * @return the option value.
     */
    public String getValue() { return value; }

    /**
     * @param value the option value.
     */
    public void setValue(String value) { this.value = value; }

    /**
     * @return the label shown for the option.
     */
    public String getLabel() { return label; }

    /**
     * @param label the label shown for the option.
     */
    public void setLabel(String label) { this.label = label; }

    /**
     * @return the JSON representation of this option.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("value", value);
        if (label != null) {
            json.addProperty("label", label);
        }
        return json;
    }
}
