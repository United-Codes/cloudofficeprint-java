package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing an autoLink for templates.
 * Properties like font color and underline color only apply when used in PPTX templates.
 */
public class AutoLink extends RenderElement {
    private String fontColor;
    private String underlineColor;
    private Boolean preserveTagStyle;

    /**
     * Element to insert a footnote in a template.
     *
     * @param name      Name of this footnote for the tag.
     * @param value     Value for the autoLink (will replace the tag in the template).
     *                  This may or may not have hyperlinks.
  */
    public AutoLink(String name, String value) {
        setName(name);
        setValue(value);
    }
    /**
     * Gets the font color for hyperlinks (PPTX only).
     *
     * @return Font color as a hex string (e.g., "#FF0000"), or null if unset.
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * Sets the font color for hyperlink text (PPTX only).
     *
     * @param fontColor Hex color code (e.g., "#0000FF").
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * Gets the underline color for hyperlinks (PPTX only).
     *
     * @return Underline color as a hex string, or null if unset.
     */
    public String getUnderlineColor() {
        return underlineColor;
    }

    /**
     * Sets the underline color for hyperlinks (PPTX only).
     *
     * @param underlineColor Hex color code (e.g., "#00FF00").
     */
    public void setUnderlineColor(String underlineColor) {
        this.underlineColor = underlineColor;
    }

    /**
     * Checks if tag style preservation is enabled (PPTX only).
     *
     * @return true preserves original template styling, false/null uses hyperlink formatting.
     */
    public Boolean getPreserveTagStyle() {
        return preserveTagStyle;
    }

    /**
     * Sets whether to preserve template styling (PPTX only).
     *
     * @param preserveTagStyle true keeps template styling, false applies hyperlink formatting.
     */
    public void setPreserveTagStyle(Boolean preserveTagStyle) {
        this.preserveTagStyle = preserveTagStyle;
    }
    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     * server.
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
     * @return An immutable set containing all available template tags this element
     * can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{*auto " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
