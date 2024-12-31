package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a hyperlink for templates.
 */
public class HyperLink extends RenderElement {

    private String url;
    private String fontColor;
    private String underlineColor;
    private Boolean preserveTagStyle;

    /**
     * Note : In Excel you can hyperlink to a cell. The URL should then be of
     * structure: "SheetName!Cell".
     *
     * @return URL to hyperlink to.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Note : In Excel you can hyperlink to a cell. The URL should then be of
     * structure: "SheetName!Cell".
     *
     * @param url URL to hyperlink to.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return font color of text for hyperlink
     */
    public String getFontColor() { return fontColor; }

    /**
     *
     * @param fontColor sets the font color of text for hyperlink
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     *
     * @return  underline color of text for hyperlink
     */
    public String getUnderlineColor() {
        return underlineColor;
    }

    /**
     *
     * @param underlineColor  sets the underline color of text for hyperlink
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
     * @param name Name of this footnote for the tag.
     * @param text Text of the hyperlink (will replace the tag in the template).
     *             (Optional: if null the URL will replace the tag)
     * @param url  URL to hyperlink to. Note : In Excel you can hyperlink to a cell.
     *             The URL should then be of structure: "SheetName!Cell".
     * @param fontColor font color of autolink.
     * @param underlineColor underline color of autolink
     * @param preserveTagStyle whether to preserve the styling of hyperlink text defined in the template (blue and underlined by default)
     */
    public HyperLink(String name, String text, String url, String fontColor, String underlineColor, Boolean preserveTagStyle) {
        setName(name);
        setValue(text);
        setUrl(url);
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
        json.addProperty(getName(), getUrl());
        if (getValue() != null) { // getValue() gives back the url in this class.
            json.addProperty(getName() + "_text", getValue());
        }
        if (getValue() != null && getFontColor() != null) {
            json.addProperty(getValue() + "_font_color", getFontColor());
        }
        if (getValue() != null && getUnderlineColor() != null) {
            json.addProperty(getValue() + "_underline_color", getUnderlineColor());
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
        hash_Set.add("{*" + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
