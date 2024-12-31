package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing an autoLink for templates.
 */
public class AutoLink extends RenderElement {

    private String fontColor;
    private String underlineColor;
    private Boolean preserveTagStyle;

    /**
     *
     * @return font color of AutoLink
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     *
     * @param fontColor set the value of font color
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     *
     * @return underline color of AutoLink
     */
    public String getUnderlineColor() {
        return underlineColor;
    }

    /**
     *
     * @param underlineColor  set the value of underline color
     */
    public void setUnderlineColor(String underlineColor) {
        this.underlineColor = underlineColor;
    }

    /**
     *
     * @return whether to preserve the styling of hyperlink text defined in the template (blue and underlined by default)
     */
    public Boolean getPreserveTagStyle() {
        return preserveTagStyle;
    }

    /**
     *
     * @param preserveTagStyle true (to preserve) or false
     */
    public void setPreserveTagStyle(Boolean preserveTagStyle) {
        this.preserveTagStyle = preserveTagStyle;
    }

    /**
     * Element to insert a footnote in a template.
     *
     * @param name      Name of this footnote for the tag.
     * @param value     Value for the autoLink (will replace the tag in the template).
     *                  This may or may not have hyperlinks.
     * @param fontColor font color of autolink.
     * @param underlineColor underline color of autolink
     * @param preserveTagStyle whether to preserve the styling of hyperlink text defined in the template (blue and underlined by default)
     */
    public AutoLink(String name, String value, String fontColor, String underlineColor, Boolean preserveTagStyle) {
        setName(name);
        setValue(value);
        setFontColor(fontColor);
        setUnderlineColor(underlineColor);
        setPreserveTagStyle(preserveTagStyle);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     * server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());

        if (getFontColor() != null) {
            json.addProperty(getName() + "_font_color", getFontColor());
        }
        if (getUnderlineColor() != null) {
            json.addProperty(getName() + "_underline_color", getUnderlineColor());
        }
        if (getPreserveTagStyle() != null) {
            json.addProperty(getName() + "_preserve_tag_style", getPreserveTagStyle());
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
