package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * This tag will allow you to insert a text box starting in the cell containing the tag in Excel.
 */
public class TextBox extends RenderElement{

    private String font;
    private String fontColor;
    private Integer fontSize;
    private String transparency;
    private String width;
    private String height;

    /**
     * @return Font of the text, default Calibri.
     */
    public String getFont() {
        return font;
    }

    /**
     * @param font Font of the text, default Calibri.
     */
    public void setFont(String font) {
        this.font = font;
    }

    /**
     * @return Color of the text, default black.
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * @param fontColor Color of the text, default black.
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * @return Size of the text, default 60.
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize Size of the text, default 60.
     */
    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * @return Transparency of the text in percent, optional default: 0%.
     */
    public String getTransparency() {
        return transparency;
    }

    /**
     * @param transparency Transparency of the text in percent, optional default: 0%.
     */
    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    /**
     * @return Width of the textbox, default 11.22 inch.
     */
    public String getWidth() {
        return width;
    }

    /**
     * @param width Width of the textbox, default 11.22 in.
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * @return Height of the textbox, default 3.1 in.
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height Height of the textbox, default 3.1 in.
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * This object represents a text box starting in the cell containing the tag in Excel. Options of the text can be set with the
     * setter functions.
     * @param name Name for the tag.
     * @param text Text of the textbox.
     */
    public TextBox(String name, String text){
        setName(name);
        setValue(text);
    }

    /**
     * @return JSONObject with the tags for this property for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(),getValue());
        if(getFont()!=null){
            json.addProperty(getName()+"_font",getFont());
        }
        if(getFontColor()!=null){
            json.addProperty(getName()+"_font_color",getFontColor());
        }
        if(getFontSize()!=null){
            json.addProperty(getName()+"_font_size",getFontSize());
        }
        if(getTransparency()!=null){
            json.addProperty(getName()+"_transparency",getTransparency());
        }
        if(getWidth()!=null){
            json.addProperty(getName()+"_width",getWidth());
        }
        if(getHeight()!=null){
            json.addProperty(getName()+"_height",getHeight());
        }
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("tbox "+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
