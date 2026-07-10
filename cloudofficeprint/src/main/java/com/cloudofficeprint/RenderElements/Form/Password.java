package com.cloudofficeprint.RenderElements.Form;

import com.google.gson.JsonObject;

/**
 * PDF form password element. A single-line text input that masks the entered characters.
 */
public class Password extends FormElement {
    private String value;
    private Integer height;
    private Integer width;
    private Boolean lock;

    /**
     * @param name   Unique identifier matching template tag
     * @param value  Pre-fills the field; displayed as masked characters (null for empty)
     * @param height Field height in points (null for auto)
     * @param width  Field width in points (null for auto)
     * @param lock   Lock (make read-only) the field (null for default)
     */
    public Password(String name, String value, Integer height, Integer width, Boolean lock) {
        super(name, "password");
        setValue(value);
        setHeight(height);
        setWidth(width);
        setLock(lock);
    }

    /**
     * @return the field value.
     */
    public String getValue() { return value; }

    /**
     * @param value the field value.
     */
    public void setValue(String value) { this.value = value; }

    /**
     * @return the field height in points.
     */
    public Integer getHeight() { return height; }

    /**
     * @param height the field height in points.
     */
    public void setHeight(Integer height) { this.height = height; }

    /**
     * @return the field width in points.
     */
    public Integer getWidth() { return width; }

    /**
     * @param width the field width in points.
     */
    public void setWidth(Integer width) { this.width = width; }

    /**
     * @return whether the field is locked (read-only).
     */
    public Boolean getLock() { return lock; }

    /**
     * @param lock whether the field is locked (read-only).
     */
    public void setLock(Boolean lock) { this.lock = lock; }

    @Override
    protected void populateProperties(JsonObject props) {
        if (getValue() != null)
            props.addProperty("value", getValue());
        if (getHeight() != null)
            props.addProperty("height", getHeight());
        if (getWidth() != null)
            props.addProperty("width", getWidth());
        if (getLock() != null)
            props.addProperty("lock", getLock());
    }
}
