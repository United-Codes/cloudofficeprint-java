package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing an AutoLink element for templates.
 * This element can replace a tag in a template with a hyperlink or plain text.
 */
public class PptxAutoLink extends RenderElement {

    private String fontColor;
    private String underlineColor;
    private Boolean preserveTagStyle;

    /**
     *
     * @param name  The name of the tag in the template.
     * @param value The text (which may contain hyperlinks) to replace the tag.
     */
    public PptxAutoLink(String name, String value) {
        setName(name);
        setValue(value);
    }

    /**
     * Gets the font color for the hyperlink text.
     *
     * @return The font color as a hex string (e.g., "#FF0000") or null if not set.
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * Sets the font color for the hyperlink text.
     *
     * @param fontColor A hex string representing the desired font color (e.g., "#0000FF").
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * Gets the underline color for the hyperlink text.
     *
     * @return The underline color as a hex string (e.g., "#00FF00") or null if not set.
     */
    public String getUnderlineColor() {
        return underlineColor;
    }

    /**
     * Sets the underline color for the hyperlink text.
     *
     * @param underlineColor A hex string representing the underline color (e.g., "#00FF00").
     */
    public void setUnderlineColor(String underlineColor) {
        this.underlineColor = underlineColor;
    }

    /**
     * Gets whether to preserve the default tag style.
     *
     * @return true to preserve default styling; false or null to override it.
     */
    public Boolean getPreserveTagStyle() {
        return preserveTagStyle;
    }

    /**
     * Sets whether to preserve the tag's original style from the template.
     *
     * @param preserveTagStyle true to preserve styling; false to override it.
     */
    public void setPreserveTagStyle(Boolean preserveTagStyle) {
        this.preserveTagStyle = preserveTagStyle;
    }

    /**
     *
     * @return A {@link JsonObject} containing tag name, value, and any optional styling if set.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());

        if (fontColor != null) {
            json.addProperty(getName() + "_font_color", fontColor);
        }
        if (underlineColor != null) {
            json.addProperty(getName() + "_underline_color", underlineColor);
        }
        if (preserveTagStyle != null) {
            json.addProperty(getName() + "_preserve_tag_style", preserveTagStyle);
        }

        return json;
    }

    /**
     * Returns the template tag(s) this element can replace.
     *
     * @return A set of template tags this AutoLink can match.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> tags = new HashSet<>();
        tags.add("{*auto " + getName() + "}");
        return ImmutableSet.copyOf(tags);
    }
}
