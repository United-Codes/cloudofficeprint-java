package com.cloudofficeprint.RenderElements.PDF;

import com.google.gson.JsonObject;

/**
 * Represents a comment to be inserted into a PDF file.
 * Supports customization options like font style, size, and color.
 */
public class PDFComment extends PDFInsertObject {

    private String comment;
    private Integer height;
    private Integer width;
    private String font;
    private String fontColor;
    private Integer fontSize;

    /**
     * Gets the comment text to be inserted in the PDF.
     *
     * @return The comment text.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment text to be inserted in the PDF.
     *
     * @param comment The comment text.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the height of the comment’s bounding box.
     *
     * @return The height in PDF-units, or null if auto-height.
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets the height of the comment’s bounding box.
     *
     * @param height The height in PDF-units, or null to auto-size.
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Gets the width of the comment’s bounding box.
     *
     * @return The width in PDF-units, or null if auto-width.
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the width of the comment’s bounding box.
     *
     * @param width The width in PDF-units, or null to auto-size.
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Gets the font of the comment text.
     *
     * @return The font name.
     */
    public String getFont() {
        return font;
    }

    /**
     * Sets the font of the comment text.
     *
     * @param font The font name.
     */
    public void setFont(String font) {
        this.font = font;
    }

    /**
     * Gets the color of the comment text in CSS format.
     *
     * @return The font color (e.g., "#000000").
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * Sets the color of the comment text in CSS format.
     *
     * @param fontColor The font color (e.g., "#000000").
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * Gets the size of the font.
     *
     * @return The font size.
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * Sets the size of the font.
     *
     * @param fontSize The font size.
     */
    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Constructs a new PDFComment object.
     *
     * @param x          X-coordinate of the position of the comment in the template,
     *                   starting from the bottom left.
     * @param y          Y-coordinate of the position of the comment in the template,
     *                   starting from the bottom left.
     * @param pageNumber Page number where the comment should be inserted.
     *                   Use -1 to display on all pages.
     * @param comment    The comment text to insert.
     */
    public PDFComment(Integer x, Integer y, Integer pageNumber, String comment) {
        super(x, y, pageNumber);
        setComment(comment);
    }

    /**
     * Converts this comment object into a JSON representation for the
     * Cloud Office Print server.
     *
     * @return A JsonObject with all the set properties.
     */
    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.addProperty("text", getComment());
        json.addProperty("x", getX());
        json.addProperty("y", getY());
        if (getHeight() != null) {
            json.addProperty("height", getHeight());
        }
        if (getWidth() != null) {
            json.addProperty("width", getWidth());
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
     * Returns the identifier used in the JSON payload for this comment object.
     *
     * @return Identifier string for PDF comment elements.
     */
    @Override
    public String getIdentifier() {
        return "AOP_PDF_COMMENTS";
    }
}
