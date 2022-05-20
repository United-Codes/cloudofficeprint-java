package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Word and Powerpoint templates. This {style } tag allows
 * user to style their text.
 */
public class StyledProperty extends Property {

    private String font;
    private String fontSize;
    private String fontColor;
    private Boolean bold;
    private Boolean italic;
    private Boolean underline;
    private Boolean strikethrough;
    private String highlightColor;

    /**
     * @return Font of the text.
     */
    public String getFont() {
        return font;
    }

    /**
     * @param font Font of the text.
     */
    public void setFont(String font) {
        this.font = font;
    }

    /**
     * @return Size of the text.
     */
    public String getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize Size of the text.
     */
    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * @return Color of the text, in CSS format.
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * @param fontColor Color of the text, in CSS format.
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * @return Whether text is marked in bold.
     */
    public Boolean getBold() {
        return bold;
    }

    /**
     * @param bold Whether text is marked in bold.
     */
    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    /**
     * @return Whether text is in italic.
     */
    public Boolean getItalic() {
        return italic;
    }

    /**
     * @param italic Whether text is in italic.
     */
    public void setItalic(Boolean italic) {
        this.italic = italic;
    }

    /**
     * @return Whether text is underlind.
     */
    public Boolean getUnderline() {
        return underline;
    }

    /**
     * @param underline Whether text is underlind.
     */
    public void setUnderline(Boolean underline) {
        this.underline = underline;
    }

    /**
     * @return Whether text is strikethroughed.
     */
    public Boolean getStrikethrough() {
        return strikethrough;
    }

    /**
     * @param strikethrough Whether text is strikethroughed.
     */
    public void setStrikethrough(Boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    /**
     * @return Color to highlight the text with in CSS format.
     */
    public String getHighlightColor() {
        return highlightColor;
    }

    /**
     * @param highlightColor Color to highlight the text with in CSS format.
     */
    public void setHighlightColor(String highlightColor) {
        this.highlightColor = highlightColor;
    }

    /**
     * Represents styled text. Set the style with the set functions.
     *
     * @param name  Name of the property for the tag.
     * @param value Value to replace the tag with.
     */
    public StyledProperty(String name, String value) {
        super(name, value);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        if (getFont() != null) {
            json.addProperty(getName() + "_font_family", getFont());
        }
        if (getFontSize() != null) {
            json.addProperty(getName() + "_font_size", getFontSize());
        }
        if (getFontColor() != null) {
            json.addProperty(getName() + "_font_color", getFontColor());
        }
        if (getBold() != null) {
            json.addProperty(getName() + "_bold", getBold());
        }
        if (getItalic() != null) {
            json.addProperty(getName() + "_italic", getItalic());
        }
        if (getUnderline() != null) {
            json.addProperty(getName() + "_underline", getUnderline());
        }
        if (getStrikethrough() != null) {
            json.addProperty(getName() + "_strikethrough", getStrikethrough());
        }
        if (getHighlightColor() != null) {
            json.addProperty(getName() + "_highlight", getHighlightColor());
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
        hash_Set.add("{style " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
