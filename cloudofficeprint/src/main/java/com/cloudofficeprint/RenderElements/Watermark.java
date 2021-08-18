package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

public class Watermark extends RenderElement {

    private String font;
    private String color;
    private String width;
    private String height;
    private Float opacity;
    private Integer rotation;

    /**
     * @return Font of the text.
     */
    public String getFont() {
        return font;
    }

    /**
     * Default : Calibri.
     * 
     * @param font Font of the text.
     */
    public void setFont(String font) {
        this.font = font;
    }

    /**
     * @return Color of the text, in CSS format.
     */
    public String getColor() {
        return color;
    }

    /**
     * Default :"silver".
     * 
     * @param color Color of the text, in CSS format.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return Width to scale the watermark text to.
     */
    public String getWidth() {
        return width;
    }

    /**
     * Default : automatically determined by Cloud Office Print.
     * 
     * @param width Width + unit (px, pt, in, cm or em) e.g. : 10 cm.
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * @return Height to scale the watermark text to.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Default : automatically determined by Cloud Office Print.
     * 
     * @param height Height + unit (px, pt, in, cm or em) e.g. : 10 cm.
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return Opacity of the watermark text.
     */
    public Float getOpacity() {
        return opacity;
    }

    /**
     * Default: 1.
     * 
     * @param opacity Opacity of the watermark text. Decimal between 0 and 1.
     */
    public void setOpacity(Float opacity) {
        this.opacity = opacity;
    }

    /**
     * @return Rotation of the watermark text (integer to be interpreted in
     *         degrees).
     */
    public Integer getRotation() {
        return rotation;
    }

    /**
     * Default : calculated to lie along the bottom-left to top-right diagonal.
     * 
     * @param rotation Rotation of the watermark text (integer to be interpreted in
     *                 degrees).
     */
    public void setRotation(Integer rotation) {
        this.rotation = rotation;
    }

    /**
     * Represents a watermark. Set the style and options of the watermark with the
     * set functions.
     * 
     * @param name Name of the watermark for the tag.
     * @param text Text of the watermark.
     */
    public Watermark(String name, String text) {
        setName(name);
        setValue(text);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        if (getColor() != null) {
            json.addProperty(getName() + "_color", getColor());
        }
        if (getFont() != null) {
            json.addProperty(getName() + "_font", getFont());
        }
        if (getWidth() != null) {
            json.addProperty(getName() + "_width", getWidth());
        }
        if (getHeight() != null) {
            json.addProperty(getName() + "_height", getHeight());
        }
        if (getOpacity() != null) {
            json.addProperty(getName() + "_opacity", getOpacity());
        }
        if (getRotation() != null) {
            json.addProperty(getName() + "_rotation", getRotation());
        }
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{watermark " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
