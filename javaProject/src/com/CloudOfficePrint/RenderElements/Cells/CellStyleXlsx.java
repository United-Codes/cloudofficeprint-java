package com.CloudOfficePrint.RenderElements.Cells;

import com.google.gson.JsonObject;

/**
 * Represents the style of Excel cells.
 */
public class CellStyleXlsx extends CellStyle {

    private Boolean cellLocked;
    private Boolean cellHidden;
    private String cellBackground;
    private String font;
    private Integer fontSize;
    private String fontColor;
    private Boolean fontItalic;
    private Boolean fontBold;
    private Boolean fontStrike;
    private Boolean fontUnderline;
    private Boolean fontSuperscript;
    private Boolean fontSubscript;
    private String borderTop;
    private String borderTopColor;
    private String borderBottom;
    private String borderBottomColor;
    private String borderLeft;
    private String borderLeftColor;
    private String borderRight;
    private String borderRightColor;
    private String borderDiagonal;
    private String borderDiagonalDirection;
    private String borderDiagonalColor;
    private String textHAlignment;
    private String textVAlignment;
    private Integer textRotation;

    /**
     * @return Whether the cell is locked.
     */
    public Boolean getCellLocked() {
        return cellLocked;
    }

    /**
     * @param cellLocked Whether the cell is locked.
     */
    public void setCellLocked(Boolean cellLocked) {
        this.cellLocked = cellLocked;
    }

    /**
     * @return Whether the cell is hidden.
     */
    public Boolean getCellHidden() {
        return cellHidden;
    }

    /**
     * @param cellHidden Whether the cell is hidden.
     */
    public void setCellHidden(Boolean cellHidden) {
        this.cellHidden = cellHidden;
    }

    /**
     * @return Background color of the cell in hex format.
     */
    public String getCellBackground() {
        return cellBackground;
    }

    /**
     * @param cellBackground Background color of the cell in hex format.
     */
    public void setCellBackground(String cellBackground) {
        this.cellBackground = cellBackground;
    }

    /**
     * @return Font of the text in the cell.
     */
    public String getFont() {
        return font;
    }

    /**
     * @param font Font of the text in the cell.
     */
    public void setFont(String font) {
        this.font = font;
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
     * @return Color of the font.
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * @param fontColor Color of the font.
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * @return Whether the text is in italic.
     */
    public Boolean getFontItalic() {
        return fontItalic;
    }

    /**
     * @param fontItalic Whether the text is in italic.
     */
    public void setFontItalic(Boolean fontItalic) {
        this.fontItalic = fontItalic;
    }

    /**
     * @return Whether the text is in bold.
     */
    public Boolean getFontBold() {
        return fontBold;
    }

    /**
     * @param fontBold Whether the text is in bold.
     */
    public void setFontBold(Boolean fontBold) {
        this.fontBold = fontBold;
    }

    /**
     * @return Whether the text is striked.
     */
    public Boolean getFontStrike() {
        return fontStrike;
    }

    /**
     * @param fontStrike Whether the text is striked.
     */
    public void setFontStrike(Boolean fontStrike) {
        this.fontStrike = fontStrike;
    }

    /**
     * @return Whether the text is underlined.
     */
    public Boolean getFontUnderline() {
        return fontUnderline;
    }

    /**
     * @param fontUnderline Whether the text is underlined.
     */
    public void setFontUnderline(Boolean fontUnderline) {
        this.fontUnderline = fontUnderline;
    }

    /**
     * @return Whether the text is a superscript.
     */
    public Boolean getFontSuperscript() {
        return fontSuperscript;
    }

    /**
     * @param fontSuperscript Whether the text is a superscript.
     */
    public void setFontSuperscript(Boolean fontSuperscript) {
        this.fontSuperscript = fontSuperscript;
    }

    /**
     * @return Whether the text is a subscript.
     */
    public Boolean getFontSubscript() {
        return fontSubscript;
    }

    /**
     * @param fontSubscript Whether the text is a subscript.
     */
    public void setFontSubscript(Boolean fontSubscript) {
        this.fontSubscript = fontSubscript;
    }

    /**
     * @return Top border style : dashed / dashDot / hair / dashDotDot / dotted /
     *         mediumDashDot / mediumDashed / mediumDashDotDot / slantDashDot /
     *         medium / double / thick ]
     */
    public String getBorderTop() {
        return borderTop;
    }

    /**
     * @param borderTop Top border style : dashed / dashDot / hair / dashDotDot /
     *                  dotted / mediumDashDot / mediumDashed / mediumDashDotDot /
     *                  slantDashDot / medium / double / thick ]
     */
    public void setBorderTop(String borderTop) {
        this.borderTop = borderTop;
    }

    /**
     * @return Top border color.
     */
    public String getBorderTopColor() {
        return borderTopColor;
    }

    /**
     * @param borderTopColor Top border color.
     */
    public void setBorderTopColor(String borderTopColor) {
        this.borderTopColor = borderTopColor;
    }

    /**
     * @return Bottom border style : dashed / dashDot / hair / dashDotDot / dotted /
     *         mediumDashDot / mediumDashed / mediumDashDotDot / slantDashDot /
     *         medium / double / thick ]
     */
    public String getBorderBottom() {
        return borderBottom;
    }

    /**
     * @param borderBottom Bottom border style : dashed / dashDot / hair /
     *                     dashDotDot / dotted / mediumDashDot / mediumDashed /
     *                     mediumDashDotDot / slantDashDot / medium / double / thick
     *                     ]
     */
    public void setBorderBottom(String borderBottom) {
        this.borderBottom = borderBottom;
    }

    /**
     * @return Bottom border color.
     */
    public String getBorderBottomColor() {
        return borderBottomColor;
    }

    /**
     * @param borderBottomColor Bottom border color.
     */
    public void setBorderBottomColor(String borderBottomColor) {
        this.borderBottomColor = borderBottomColor;
    }

    /**
     * @return Left border style : dashed / dashDot / hair / dashDotDot / dotted /
     *         mediumDashDot / mediumDashed / mediumDashDotDot / slantDashDot /
     *         medium / double / thick ]
     */
    public String getBorderLeft() {
        return borderLeft;
    }

    /**
     * @param borderLeft Left border style : dashed / dashDot / hair / dashDotDot /
     *                   dotted / mediumDashDot / mediumDashed / mediumDashDotDot /
     *                   slantDashDot / medium / double / thick ]
     */
    public void setBorderLeft(String borderLeft) {
        this.borderLeft = borderLeft;
    }

    /**
     * @return Left border color.
     */
    public String getBorderLeftColor() {
        return borderLeftColor;
    }

    /**
     * @param borderLeftColor Left border color.
     */
    public void setBorderLeftColor(String borderLeftColor) {
        this.borderLeftColor = borderLeftColor;
    }

    /**
     * @return Right border style : dashed / dashDot / hair / dashDotDot / dotted /
     *         mediumDashDot / mediumDashed / mediumDashDotDot / slantDashDot /
     *         medium / double / thick ]
     */
    public String getBorderRight() {
        return borderRight;
    }

    /**
     * @param borderRight Right border style : dashed / dashDot / hair / dashDotDot
     *                    / dotted / mediumDashDot / mediumDashed / mediumDashDotDot
     *                    / slantDashDot / medium / double / thick ]
     */
    public void setBorderRight(String borderRight) {
        this.borderRight = borderRight;
    }

    /**
     * @return Right border color.
     */
    public String getBorderRightColor() {
        return borderRightColor;
    }

    /**
     * @param borderRightColor Right border color.
     */
    public void setBorderRightColor(String borderRightColor) {
        this.borderRightColor = borderRightColor;
    }

    /**
     * @return Diagonal border style : dashed / dashDot / hair / dashDotDot / dotted
     *         / mediumDashDot / mediumDashed / mediumDashDotDot / slantDashDot /
     *         medium / double / thick ]
     */
    public String getBorderDiagonal() {
        return borderDiagonal;
    }

    /**
     * @param borderDiagonal Diagonal border style : dashed / dashDot / hair /
     *                       dashDotDot / dotted / mediumDashDot / mediumDashed /
     *                       mediumDashDotDot / slantDashDot / medium / double /
     *                       thick ]
     */
    public void setBorderDiagonal(String borderDiagonal) {
        this.borderDiagonal = borderDiagonal;
    }

    /**
     * @return Direction of the diagonal border : [up-wards|down-wards| both]
     */
    public String getBorderDiagonalDirection() {
        return borderDiagonalDirection;
    }

    /**
     * @param borderDiagonalDirection Direction of the diagonal border :
     *                                [up-wards|down-wards| both]
     */
    public void setBorderDiagonalDirection(String borderDiagonalDirection) {
        this.borderDiagonalDirection = borderDiagonalDirection;
    }

    /**
     * @return Color of the diagonal border.
     */
    public String getBorderDiagonalColor() {
        return borderDiagonalColor;
    }

    /**
     * @param borderDiagonalColor Color of the diagonal border.
     */
    public void setBorderDiagonalColor(String borderDiagonalColor) {
        this.borderDiagonalColor = borderDiagonalColor;
    }

    /**
     * @return Horizontal text alignment : [top|bottom|center|justify]
     */
    public String getTextHAlignment() {
        return textHAlignment;
    }

    /**
     * @param textHAlignment Horizontal text alignment : [top|bottom|center|justify]
     */
    public void setTextHAlignment(String textHAlignment) {
        this.textHAlignment = textHAlignment;
    }

    /**
     * @return Vertical text alignment.
     */
    public String getTextVAlignment() {
        return textVAlignment;
    }

    /**
     * @param textVAlignment Vertical text alignment.
     */
    public void setTextVAlignment(String textVAlignment) {
        this.textVAlignment = textVAlignment;
    }

    /**
     * @return Rotation of the text.
     */
    public Integer getTextRotation() {
        return textRotation;
    }

    /**
     * @param textRotation Rotation of the text.
     */
    public void setTextRotation(Integer textRotation) {
        this.textRotation = textRotation;
    }

    /**
     * Represents the style of an Excell cell element. The options can be set with
     * the setter functions.
     */
    public CellStyleXlsx() {
    }

    /**
     * @return JSONObject with the tags for this tableCell for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getCellLocked() != null) {
            json.addProperty("_cell_locked", getCellLocked());
        }
        if (getCellHidden() != null) {
            json.addProperty("_cell_hidden", getCellHidden());
        }
        if (getCellBackground() != null) {
            json.addProperty("_cell_background", getCellBackground());
        }
        if (getFont() != null) {
            json.addProperty("_font_name", getFont());
        }
        if (getFontSize() != null) {
            json.addProperty("_font_size", getFontSize());
        }
        if (getFontColor() != null) {
            json.addProperty("_font_color", getFontColor());
        }
        if (getFontItalic() != null) {
            json.addProperty("_font_italic", getFontItalic());
        }
        if (getFontBold() != null) {
            json.addProperty("_font_bold", getFontBold());
        }
        if (getFontStrike() != null) {
            json.addProperty("_font_strike", getFontStrike());
        }
        if (getFontUnderline() != null) {
            json.addProperty("_font_underline", getFontUnderline());
        }
        if (getFontSuperscript() != null) {
            json.addProperty("_font_superscript", getFontSuperscript());
        }
        if (getFontSubscript() != null) {
            json.addProperty("_font_subscript", getFontSubscript());
        }
        if (getBorderTop() != null) {
            json.addProperty("_border_top", getBorderTop());
        }
        if (getBorderTopColor() != null) {
            json.addProperty("_border_top_color", getBorderTopColor());
        }
        if (getBorderBottom() != null) {
            json.addProperty("_border_bottom", getBorderBottom());
        }
        if (getBorderBottomColor() != null) {
            json.addProperty("_border_bottom_color", getBorderBottomColor());
        }
        if (getBorderLeft() != null) {
            json.addProperty("_border_left", getBorderLeft());
        }
        if (getBorderLeftColor() != null) {
            json.addProperty("_border_left_color", getBorderLeftColor());
        }
        if (getBorderRight() != null) {
            json.addProperty("_border_right", getBorderRight());
        }
        if (getBorderRightColor() != null) {
            json.addProperty("_border_right_color", getBorderRightColor());
        }
        if (getBorderDiagonal() != null) {
            json.addProperty("_border_diagonal", getBorderDiagonal());
        }
        if (getBorderDiagonalDirection() != null) {
            json.addProperty("_border_diagonal_direction", getBorderDiagonalDirection());
        }
        if (getBorderDiagonalColor() != null) {
            json.addProperty("_border_diagonal_color", getBorderDiagonalColor());
        }
        if (getTextHAlignment() != null) {
            json.addProperty("_text_h_alignment", getTextHAlignment());
        }
        if (getTextVAlignment() != null) {
            json.addProperty("_text_v_alignment", getTextVAlignment());
        }
        if (getTextRotation() != null) {
            json.addProperty("_text_rotation", getTextRotation());
        }
        return json;
    }
}
