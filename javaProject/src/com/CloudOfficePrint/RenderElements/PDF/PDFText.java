package com.CloudOfficePrint.RenderElements.PDF;

import com.google.gson.JsonObject;

public class PDFText extends PDFInsertObject {

    private String text;
    private Integer rotation;
    private Boolean bold;
    private Boolean italic;
    private String font;
    private String fontColor;
    private Integer fontSize;

    /**
     * @return Text to be inserted in the PDF.
     */
    public String getText() {
        return text;
    }

    /**
     * @param text Text to be inserted in the PDF.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return Rotation of the text in degrees.
     */
    public Integer getRotation() {
        return rotation;
    }

    /**
     * @param rotation Rotation of the text in degrees.
     */
    public void setRotation(Integer rotation) {
        this.rotation = rotation;
    }

    /**
     * @return Whether the text should be in bold.
     */
    public Boolean getBold() {
        return bold;
    }

    /**
     * @param bold Whether the text should be in bold.
     */
    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    /**
     * @return Whether the text shoud be in italic.
     */
    public Boolean getItalic() {
        return italic;
    }

    /**
     * @param italic Whether the text should be in italic.
     */
    public void setItalic(Boolean italic) {
        this.italic = italic;
    }

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
     * @return Color of the text in CSS format.
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * @param fontColor Color of the text in CSS format.
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * @return Size of the font.
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize Size of the font.
     */
    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Represents text to insert in a PDF. The text options can be set with the
     * setter functions.
     * 
     * @param x          X-coordinate of the position of the text in the template
     *                   starting from bottom left.
     * @param y          Y-coordinate of the position of the text in the template
     *                   starting from bottom left.
     * @param pageNumber Page number of the page where the text should be inserted.
     *                   -1 if the text should be displayed on all pages.
     * @param text       Text that should be inserted.
     */
    public PDFText(Integer x, Integer y, Integer pageNumber, String text) {
        super(x, y, pageNumber);
        setText(text);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.addProperty("text", getText());
        json.addProperty("x", getX());
        json.addProperty("y", getY());
        if (getRotation() != null) {
            json.addProperty("rotation", getRotation());
        }
        if (getBold() != null) {
            json.addProperty("bold", getBold());
        }
        if (getItalic() != null) {
            json.addProperty("italic", getItalic());
        }
        if (getFont() != null) {
            json.addProperty("font", getFont());
        }
        if (getFontColor() != null) {
            json.addProperty("font_color", getFontColor());
        }
        if (getFontSize() != null) {
            json.addProperty("font_size", getFontSize());
        }
        return json;
    }

    /**
     * @return Identifier for the JSON.
     */
    @Override
    public String getIdentifier() {
        return "AOP_PDF_TEXTS";
    }
}
