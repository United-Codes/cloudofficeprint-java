package com.cloudofficeprint.RenderElements.Cells;

import com.google.gson.JsonObject;

/**
 * Represent the style of Word and PowerPoint cells.
 */
public class CellStyleDocxPpt extends CellStyle {

    private String backgroundColor;
    private String width;
    private String preserveTotalWidthOfTable;
    private String border;
    private String borderTop;
    private String borderBottom;
    private String borderLeft;
    private String borderRight;
    private String borderDiagonalDown;
    private String borderDiagonalUp;
    private String borderColor;
    private String borderTopColor;
    private String borderBottomColor;
    private String borderLeftColor;
    private String borderRightColor;
    private String borderDiagonalUpColor;
    private String borderDiagonalDownColor;
    private String borderSize;
    private String borderTopSize;
    private String borderBottomSize;
    private String borderLeftSize;
    private String borderRightSize;
    private String borderDiagonalUpSize;
    private String borderDiagonalDownSize;
    private String borderSpace;
    private String borderTopSpace;
    private String borderBottomSpace;
    private String borderLeftSpace;
    private String borderRightSpace;
    private String borderDiagonalUpSpace;
    private String borderDiagonalDownSpace;

    /**
     * @return The background color of the cell (hex format).
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor The background color of the cell (hex format).
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * The width manipulation is available from Cloud Office Print 20.2. Giving a
     * width of 0 will remove the whole column.
     *
     * @return width The width + unit ( in, cm, px, pt, em and % (% is in respect to
     * the initial width of the table)).
     */
    public String getWidth() {
        return width;
    }

    /**
     * The width manipulation is available from Cloud Office Print 20.2. Giving a
     * width of 0 will remove the whole column.
     *
     * @param width The width +unit ( in, cm, px, pt, em and % (% is in respect to
     *              the initial width of the table)).
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * @return preserveTotalWidthOfTable The value determining if total table width should be preserved.
     */
    public String getPreserveTotalWidthOfTable() {
        return preserveTotalWidthOfTable;
    }

    /**
     * @param preserveTotalWidthOfTable The value to set whether total table width is preserved.
     */
    public void setPreserveTotalWidthOfTable(String preserveTotalWidthOfTable) {
        this.preserveTotalWidthOfTable = preserveTotalWidthOfTable;
    }

    /**
     * @return border The border style applied to all edges.
     */
    public String getBorder() {
        return border;
    }

    /**
     * @param border The border style applied to all edges.
     */
    public void setBorder(String border) {
        this.border = border;
    }

    /**
     * @return borderTop The border style applied to the top edge.
     */
    public String getBorderTop() {
        return borderTop;
    }

    /**
     * @param borderTop The border style applied to the top edge.
     */
    public void setBorderTop(String borderTop) {
        this.borderTop = borderTop;
    }

    /**
     * @return borderBottom The border style applied to the bottom edge.
     */
    public String getBorderBottom() {
        return borderBottom;
    }

    /**
     * @param borderBottom The border style applied to the bottom edge.
     */
    public void setBorderBottom(String borderBottom) {
        this.borderBottom = borderBottom;
    }

    /**
     * @return borderLeft The border style applied to the left edge.
     */
    public String getBorderLeft() {
        return borderLeft;
    }

    /**
     * @param borderLeft The border style applied to the left edge.
     */
    public void setBorderLeft(String borderLeft) {
        this.borderLeft = borderLeft;
    }

    /**
     * @return borderRight The border style applied to the right edge.
     */
    public String getBorderRight() {
        return borderRight;
    }

    /**
     * @param borderRight The border style applied to the right edge.
     */
    public void setBorderRight(String borderRight) {
        this.borderRight = borderRight;
    }

    /**
     * @return borderDiagonalDown The border style applied to the diagonal line (top-left to bottom-right).
     */
    public String getBorderDiagonalDown() {
        return borderDiagonalDown;
    }

    /**
     * @param borderDiagonalDown The border style applied to the diagonal line (top-left to bottom-right).
     */
    public void setBorderDiagonalDown(String borderDiagonalDown) {
        this.borderDiagonalDown = borderDiagonalDown;
    }

    /**
     * @return borderDiagonalUp The border style applied to the diagonal line (bottom-left to top-right).
     */
    public String getBorderDiagonalUp() {
        return borderDiagonalUp;
    }

    /**
     * @param borderDiagonalUp The border style applied to the diagonal line (bottom-left to top-right).
     */
    public void setBorderDiagonalUp(String borderDiagonalUp) {
        this.borderDiagonalUp = borderDiagonalUp;
    }

    /**
     * @return borderColor The color of the borders (top, bottom, left, right).
     */
    public String getBorderColor() {
        return borderColor;
    }

    /**
     * @param borderColor The color of the borders (top, bottom, left, right).
     */
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    /**
     * @return borderTopColor The color of the top border.
     */
    public String getBorderTopColor() {
        return borderTopColor;
    }

    /**
     * @param borderTopColor The color of the top border.
     */
    public void setBorderTopColor(String borderTopColor) {
        this.borderTopColor = borderTopColor;
    }

    /**
     * @return borderBottomColor The color of the bottom border.
     */
    public String getBorderBottomColor() {
        return borderBottomColor;
    }

    /**
     * @param borderBottomColor The color of the bottom border.
     */
    public void setBorderBottomColor(String borderBottomColor) {
        this.borderBottomColor = borderBottomColor;
    }

    /**
     * @return borderLeftColor The color of the left border.
     */
    public String getBorderLeftColor() {
        return borderLeftColor;
    }

    /**
     * @param borderLeftColor The color of the left border.
     */
    public void setBorderLeftColor(String borderLeftColor) {
        this.borderLeftColor = borderLeftColor;
    }

    /**
     * @return borderRightColor The color of the right border.
     */
    public String getBorderRightColor() {
        return borderRightColor;
    }

    /**
     * @param borderRightColor The color of the right border.
     */
    public void setBorderRightColor(String borderRightColor) {
        this.borderRightColor = borderRightColor;
    }

    /**
     * @return borderDiagonalUpColor The color of the diagonal up border.
     */
    public String getBorderDiagonalUpColor() {
        return borderDiagonalUpColor;
    }

    /**
     * @param borderDiagonalUpColor The color of the diagonal up border.
     */
    public void setBorderDiagonalUpColor(String borderDiagonalUpColor) {
        this.borderDiagonalUpColor = borderDiagonalUpColor;
    }

    /**
     * @return borderDiagonalDownColor The color of the diagonal down border.
     */
    public String getBorderDiagonalDownColor() {
        return borderDiagonalDownColor;
    }

    /**
     * @param borderDiagonalDownColor The color of the diagonal down border.
     */
    public void setBorderDiagonalDownColor(String borderDiagonalDownColor) {
        this.borderDiagonalDownColor = borderDiagonalDownColor;
    }

    /**
     * @return borderSize The width of the borders (top, bottom, left, right) in points.
     */
    public String getBorderSize() {
        return borderSize;
    }

    /**
     * @param borderSize The width of the borders (top, bottom, left, right) in points.
     */
    public void setBorderSize(String borderSize) {
        this.borderSize = borderSize;
    }

    /**
     * @return borderTopSize The width of the top border in points.
     */
    public String getBorderTopSize() {
        return borderTopSize;
    }

    /**
     * @param borderTopSize The width of the top border in points.
     */
    public void setBorderTopSize(String borderTopSize) {
        this.borderTopSize = borderTopSize;
    }

    /**
     * @return borderBottomSize The width of the bottom border in points.
     */
    public String getBorderBottomSize() {
        return borderBottomSize;
    }

    /**
     * @param borderBottomSize The width of the bottom border in points.
     */
    public void setBorderBottomSize(String borderBottomSize) {
        this.borderBottomSize = borderBottomSize;
    }

    /**
     * @return borderLeftSize The width of the left border in points.
     */
    public String getBorderLeftSize() {
        return borderLeftSize;
    }

    /**
     * @param borderLeftSize The width of the left border in points.
     */
    public void setBorderLeftSize(String borderLeftSize) {
        this.borderLeftSize = borderLeftSize;
    }

    /**
     * @return borderRightSize The width of the right border in points.
     */
    public String getBorderRightSize() {
        return borderRightSize;
    }

    /**
     * @param borderRightSize The width of the right border in points.
     */
    public void setBorderRightSize(String borderRightSize) {
        this.borderRightSize = borderRightSize;
    }

    /**
     * @return borderDiagonalUpSize The width of the diagonal up border in points.
     */
    public String getBorderDiagonalUpSize() {
        return borderDiagonalUpSize;
    }

    /**
     * @param borderDiagonalUpSize The width of the diagonal up border in points.
     */
    public void setBorderDiagonalUpSize(String borderDiagonalUpSize) {
        this.borderDiagonalUpSize = borderDiagonalUpSize;
    }

    /**
     * @return borderDiagonalDownSize The width of the diagonal down border in points.
     */
    public String getBorderDiagonalDownSize() {
        return borderDiagonalDownSize;
    }

    /**
     * @param borderDiagonalDownSize The width of the diagonal down border in points.
     */
    public void setBorderDiagonalDownSize(String borderDiagonalDownSize) {
        this.borderDiagonalDownSize = borderDiagonalDownSize;
    }

    /**
     * @return borderSpace The spacing between the content and borders in points.
     */
    public String getBorderSpace() {
        return borderSpace;
    }

    /**
     * @param borderSpace The spacing between the content and borders in points.
     */
    public void setBorderSpace(String borderSpace) {
        this.borderSpace = borderSpace;
    }

    /**
     * @return borderTopSpace The spacing between the content and the top border in points.
     */
    public String getBorderTopSpace() {
        return borderTopSpace;
    }

    /**
     * @param borderTopSpace The spacing between the content and the top border in points.
     */
    public void setBorderTopSpace(String borderTopSpace) {
        this.borderTopSpace = borderTopSpace;
    }

    /**
     * @return borderBottomSpace The spacing between the content and the bottom border in points.
     */
    public String getBorderBottomSpace() {
        return borderBottomSpace;
    }

    /**
     * @param borderBottomSpace The spacing between the content and the bottom border in points.
     */
    public void setBorderBottomSpace(String borderBottomSpace) {
        this.borderBottomSpace = borderBottomSpace;
    }

    /**
     * @return borderLeftSpace The spacing between the content and the left border in points.
     */
    public String getBorderLeftSpace() {
        return borderLeftSpace;
    }

    /**
     * @param borderLeftSpace The spacing between the content and the left border in points.
     */
    public void setBorderLeftSpace(String borderLeftSpace) {
        this.borderLeftSpace = borderLeftSpace;
    }

    /**
     * @return borderRightSpace The spacing between the content and the right border in points.
     */
    public String getBorderRightSpace() {
        return borderRightSpace;
    }

    /**
     * @param borderRightSpace The spacing between the content and the right border in points.
     */
    public void setBorderRightSpace(String borderRightSpace) {
        this.borderRightSpace = borderRightSpace;
    }

    /**
     * @return borderDiagonalUpSpace The spacing between the content and the diagonal up border in points.
     */
    public String getBorderDiagonalUpSpace() {
        return borderDiagonalUpSpace;
    }

    /**
     * @param borderDiagonalUpSpace The spacing between the content and the diagonal up border in points.
     */
    public void setBorderDiagonalUpSpace(String borderDiagonalUpSpace) {
        this.borderDiagonalUpSpace = borderDiagonalUpSpace;
    }

    /**
     * @return borderDiagonalDownSpace The spacing between the content and the diagonal down border in points.
     */
    public String getBorderDiagonalDownSpace() {
        return borderDiagonalDownSpace;
    }

    /**
     * @param borderDiagonalDownSpace The spacing between the content and the diagonal down border in points.
     */
    public void setBorderDiagonalDownSpace(String borderDiagonalDownSpace) {
        this.borderDiagonalDownSpace = borderDiagonalDownSpace;
    }
    /**
     * Represents the style of a Word/PowerPoint cell element. Use default value if
     * you don't want to specify an optional argument.
     *
     * @param backgroundColor The background color of the cell (hex format).
     *                        (Optional)
     * @param width           The width of the cell + unit ( in, cm, px, pt, em and
     *                        % (% is in respect to the initial width of the
     *                        table)). Giving a width of 0 will remove the whole
     *                        column.
     * @param preserveTotalWidthOfTable Keeps table width constant by redistributing removed column's width to others..
     * @param border The border style applied to all edges (top, bottom, left, right) of the table. Optional.
     * @param borderTop The border style applied to the top edge of the table. Optional.
     * @param borderBottom The border style applied to the bottom edge of the table. Optional.
     * @param borderLeft The border style applied to the left edge of the table. Optional.
     * @param borderRight The border style applied to the right edge of the table. Optional.
     * @param borderDiagonalDown Applies the specified border style to the diagonal line going from the top-left to the bottom-right corner. Optional.
     * @param borderDiagonalUp  Applies the specified border style to the diagonal line going from the bottom-left to the top-right corner. Optional.
     * @param borderColor The color of the borders (top, bottom, left, right). Optional.
     * @param borderTopColor  The color of the top border. Optional.
     * @param borderBottomColor  The color of the bottom border. Optional.
     * @param borderLeftColor  The color of the left border. Optional.
     * @param borderRightColor  The color of the right border. Optional.
     * @param borderDiagonalUpColor  The color of the diagonal up border. Optional.
     * @param borderDiagonalDownColor The color of the diagonal down border. Optional.
     * @param borderSize The width of the borders (top, bottom, left, right) in points. Optional.
     * @param borderTopSize  The width of the top border in points. Optional.
     * @param borderBottomSize  The width of the bottom border in points. Optional.
     * @param borderLeftSize  The width of the left border in points. Optional.
     * @param borderRightSize  The width of the right border in points. Optional.
     * @param borderDiagonalUpSize  The width of the diagonal up border in points. Optional.
     * @param borderDiagonalDownSize  The width of the diagonal down border in points. Optional.
     * @param borderSpace The spacing between the content and borders in points. Optional.
     * @param borderTopSpace  The spacing between the content and the top border. Optional.
     * @param borderBottomSpace The spacing between the content and the bottom border. Optional.
     * @param borderLeftSpace The spacing between the content and the left border. Optional.
     * @param borderRightSpace The spacing between the content and the right border in points Optional.
     * @param borderDiagonalUpSpace The spacing between the content and the diagonal up border in points. Optional.
     * @param borderDiagonalDownSpace The spacing between the content and the diagonal down border in points. Optional.
     */
    public CellStyleDocxPpt(String backgroundColor, String width,
                            String preserveTotalWidthOfTable, String border,
                            String borderTop, String borderBottom,
                            String borderLeft, String borderRight, String borderDiagonalDown,
                            String borderDiagonalUp, String borderColor, String borderTopColor,
                            String borderBottomColor, String borderLeftColor, String borderRightColor,
                            String borderDiagonalUpColor, String borderDiagonalDownColor,
                            String borderSize, String borderTopSize, String borderBottomSize,
                            String borderLeftSize, String borderRightSize, String borderDiagonalUpSize,
                            String borderDiagonalDownSize, String borderSpace, String borderTopSpace,
                            String borderBottomSpace, String borderLeftSpace, String borderRightSpace,
                            String borderDiagonalUpSpace, String borderDiagonalDownSpace)
    {
        setBackgroundColor(backgroundColor);
        setWidth(width);
        setPreserveTotalWidthOfTable(preserveTotalWidthOfTable);
        setBorder(border);
        setBorderTop(borderTop);
        setBorderBottom(borderBottom);
        setBorderLeft(borderLeft);
        setBorderRight(borderRight);
        setBorderDiagonalDown(borderDiagonalDown);
        setBorderDiagonalUp(borderDiagonalUp);
        setBorderColor(borderColor);
        setBorderTopColor(borderTopColor);
        setBorderBottomColor(borderBottomColor);
        setBorderLeftColor(borderLeftColor);
        setBorderRightColor(borderRightColor);
        setBorderDiagonalUpColor(borderDiagonalUpColor);
        setBorderDiagonalDownColor(borderDiagonalDownColor);
        setBorderSize(borderSize);
        setBorderTopSize(borderTopSize);
        setBorderBottomSize(borderBottomSize);
        setBorderLeftSize(borderLeftSize);
        setBorderRightSize(borderRightSize);
        setBorderDiagonalUpSize(borderDiagonalUpSize);
        setBorderDiagonalDownSize(borderDiagonalDownSize);
        setBorderSpace(borderSpace);
        setBorderTopSpace(borderTopSpace);
        setBorderBottomSpace(borderBottomSpace);
        setBorderLeftSpace(borderLeftSpace);
        setBorderRightSpace(borderRightSpace);
        setBorderDiagonalUpSpace(borderDiagonalUpSpace);
        setBorderDiagonalDownSpace(borderDiagonalDownSpace);
    }

    /**
     * @return JSONObject with the tags for this tableCell for the Cloud Office
     * Print server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getBackgroundColor() != null) {
            json.addProperty("_cell_background_color", getBackgroundColor());
        }
        if (getWidth() != null) {
            json.addProperty("_width", getWidth());
        }
        if (getPreserveTotalWidthOfTable() != null){
            json.addProperty("_preserve_total_width_of_table", getPreserveTotalWidthOfTable());
        }
        if (getBorder() != null) {
            json.addProperty("_border", getBorder());
        }
        if (getBorderTop() != null) {
            json.addProperty("_border_top", getBorderTop());
        }
        if (getBorderBottom() != null) {
            json.addProperty("_border_bottom", getBorderBottom());
        }
        if (getBorderLeft() != null) {
            json.addProperty("_border_left", getBorderLeft());
        }
        if (getBorderRight() != null) {
            json.addProperty("_border_right", getBorderRight());
        }
        if (getBorderDiagonalDown() != null) {
            json.addProperty("_border_diagonal_down", getBorderDiagonalDown());
        }
        if (getBorderDiagonalUp() != null) {
            json.addProperty("_border_diagonal_up", getBorderDiagonalUp());
        }
        if (getBorderColor() != null) {
            json.addProperty("_border_color", getBorderColor());
        }
        if (getBorderTopColor() != null) {
            json.addProperty("_border_top_color", getBorderTopColor());
        }
        if (getBorderBottomColor() != null) {
            json.addProperty("_border_bottom_color", getBorderBottomColor());
        }
        if (getBorderLeftColor() != null) {
            json.addProperty("_border_left_color", getBorderLeftColor());
        }
        if (getBorderRightColor() != null) {
            json.addProperty("_border_right_color", getBorderRightColor());
        }
        if (getBorderDiagonalUpColor() != null) {
            json.addProperty("_border_diagonal_up_color", getBorderDiagonalUpColor());
        }
        if (getBorderDiagonalDownColor() != null) {
            json.addProperty("_border_diagonal_down_color", getBorderDiagonalDownColor());
        }
        if (getBorderSize() != null) {
            json.addProperty("_border_size", getBorderSize());
        }
        if (getBorderTopSize() != null) {
            json.addProperty("_border_top_size", getBorderTopSize());
        }
        if (getBorderBottomSize() != null) {
            json.addProperty("_border_bottom_size", getBorderBottomSize());
        }
        if (getBorderLeftSize() != null) {
            json.addProperty("_border_left_size", getBorderLeftSize());
        }
        if (getBorderRightSize() != null) {
            json.addProperty("_border_right_size", getBorderRightSize());
        }
        if (getBorderDiagonalUpSize() != null) {
            json.addProperty("_border_diagonal_up_size", getBorderDiagonalUpSize());
        }
        if (getBorderDiagonalDownSize() != null) {
            json.addProperty("_border_diagonal_down_size", getBorderDiagonalDownSize());
        }
        if (getBorderSpace() != null) {
            json.addProperty("_border_space", getBorderSpace());
        }
        if (getBorderTopSpace() != null) {
            json.addProperty("_border_top_space", getBorderTopSpace());
        }
        if (getBorderBottomSpace() != null) {
            json.addProperty("_border_bottom_space", getBorderBottomSpace());
        }
        if (getBorderLeftSpace() != null) {
            json.addProperty("_border_left_space", getBorderLeftSpace());
        }
        if (getBorderRightSpace() != null) {
            json.addProperty("_border_right_space", getBorderRightSpace());
        }
        if (getBorderDiagonalUpSpace() != null) {
            json.addProperty("_border_diagonal_up_space", getBorderDiagonalUpSpace());
        }
        if (getBorderDiagonalDownSpace() != null) {
            json.addProperty("_border_diagonal_down_space", getBorderDiagonalDownSpace());
        }
        return json;
    }

}
