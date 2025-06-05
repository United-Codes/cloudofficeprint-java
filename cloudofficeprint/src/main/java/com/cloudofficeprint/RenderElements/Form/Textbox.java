package com.cloudofficeprint.RenderElements.Form;

import com.google.gson.JsonObject;

public class Textbox extends FormElement {
    private String value;
    private Integer height;
    private Integer width;
    private Boolean multiline;
    /**
     * @param name Unique identifier matching template tag
     * @param value Initial text content (null for empty)
     * @param height Field height in points (null for auto)
     * @param width Field width in points (null for auto)
     * @param multiline Enable multi-line input (true/false)
     */
    public Textbox(String name, String value, Integer height, Integer width, Boolean multiline) {
        super(name, "text");
        setValue(value);
        setHeight(height);
        setWidth(width);
        setMultiline(multiline);
    }
    /**
     * @return Current text content of the field
     */
    public String getValue() { return value; }
    /**
     * @param value Text content to set in the field
     */
    public void setValue(String value) { this.value = value; }
    /**
     * @return Height of the field in points
     */
    public Integer getHeight() { return height; }
    /**
     * @param height Height of the field in points
     */
    public void setHeight(Integer height) { this.height = height; }
    /**
     * @return Width of the field in points
     */
    public Integer getWidth() { return width; }
    /**
     * @param width Width of the field in points
     */
    public void setWidth(Integer width) { this.width = width; }
    /**
     * @return Whether multi-line input is enabled
     */
    public Boolean getMultiline() { return multiline; }
    /**
     * @param multiline Enable or disable multi-line input
     */
    public void setMultiline(Boolean multiline) { this.multiline = multiline; }
    /**
     * Populates the properties of the Textbox element in JSON format.
     * @param props JSON object to populate with properties
     */

    @Override
    protected void populateProperties(JsonObject props) {
        if (getValue() != null)
            props.addProperty("value", getValue());
        if (getHeight() != null)
            props.addProperty("height", getHeight());
        if (getWidth() != null)
            props.addProperty("width", getWidth());
        if (getMultiline() != null)
            props.addProperty("multiline", getMultiline() ? 1 : 0);
    }
}