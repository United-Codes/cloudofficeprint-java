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

    public String getPreserveTotalWidthOfTable() {
        return preserveTotalWidthOfTable;
    }

    public void setPreserveTotalWidthOfTable(String preserveTotalWidthOfTable) {
        this.preserveTotalWidthOfTable = preserveTotalWidthOfTable;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getBorderTop() {
        return borderTop;
    }

    public void setBorderTop(String borderTop) {
        this.borderTop = borderTop;
    }

    public String getBorderBottom() {
        return borderBottom;
    }

    public void setBorderBottom(String borderBottom) {
        this.borderBottom = borderBottom;
    }

    public String getBorderLeft() {
        return borderLeft;
    }

    public void setBorderLeft(String borderLeft) {
        this.borderLeft = borderLeft;
    }

    public String getBorderRight() {
        return borderRight;
    }

    public void setBorderRight(String borderRight) {
        this.borderRight = borderRight;
    }

    public String getBorderDiagonalDown() {
        return borderDiagonalDown;
    }

    public void setBorderDiagonalDown(String borderDiagonalDown) {
        this.borderDiagonalDown = borderDiagonalDown;
    }

    public String getBorderDiagonalUp() {
        return borderDiagonalUp;
    }

    public void setBorderDiagonalUp(String borderDiagonalUp) {
        this.borderDiagonalUp = borderDiagonalUp;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBorderTopColor() {
        return borderTopColor;
    }

    public void setBorderTopColor(String borderTopColor) {
        this.borderTopColor = borderTopColor;
    }

    public String getBorderBottomColor() {
        return borderBottomColor;
    }

    public void setBorderBottomColor(String borderBottomColor) {
        this.borderBottomColor = borderBottomColor;
    }

    public String getBorderLeftColor() {
        return borderLeftColor;
    }

    public void setBorderLeftColor(String borderLeftColor) {
        this.borderLeftColor = borderLeftColor;
    }

    public String getBorderRightColor() {
        return borderRightColor;
    }

    public void setBorderRightColor(String borderRightColor) {
        this.borderRightColor = borderRightColor;
    }

    public String getBorderDiagonalUpColor() {
        return borderDiagonalUpColor;
    }

    public void setBorderDiagonalUpColor(String borderDiagonalUpColor) {
        this.borderDiagonalUpColor = borderDiagonalUpColor;
    }

    public String getBorderDiagonalDownColor() {
        return borderDiagonalDownColor;
    }

    public void setBorderDiagonalDownColor(String borderDiagonalDownColor) {
        this.borderDiagonalDownColor = borderDiagonalDownColor;
    }

    public String getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(String borderSize) {
        this.borderSize = borderSize;
    }

    public String getBorderTopSize() {
        return borderTopSize;
    }

    public void setBorderTopSize(String borderTopSize) {
        this.borderTopSize = borderTopSize;
    }

    public String getBorderBottomSize() {
        return borderBottomSize;
    }

    public void setBorderBottomSize(String borderBottomSize) {
        this.borderBottomSize = borderBottomSize;
    }

    public String getBorderLeftSize() {
        return borderLeftSize;
    }

    public void setBorderLeftSize(String borderLeftSize) {
        this.borderLeftSize = borderLeftSize;
    }

    public String getBorderRightSize() {
        return borderRightSize;
    }

    public void setBorderRightSize(String borderRightSize) {
        this.borderRightSize = borderRightSize;
    }

    public String getBorderDiagonalUpSize() {
        return borderDiagonalUpSize;
    }

    public void setBorderDiagonalUpSize(String borderDiagonalUpSize) {
        this.borderDiagonalUpSize = borderDiagonalUpSize;
    }

    public String getBorderDiagonalDownSize() {
        return borderDiagonalDownSize;
    }

    public void setBorderDiagonalDownSize(String borderDiagonalDownSize) {
        this.borderDiagonalDownSize = borderDiagonalDownSize;
    }

    public String getBorderSpace() {
        return borderSpace;
    }

    public void setBorderSpace(String borderSpace) {
        this.borderSpace = borderSpace;
    }

    public String getBorderTopSpace() {
        return borderTopSpace;
    }

    public void setBorderTopSpace(String borderTopSpace) {
        this.borderTopSpace = borderTopSpace;
    }

    public String getBorderBottomSpace() {
        return borderBottomSpace;
    }

    public void setBorderBottomSpace(String borderBottomSpace) {
        this.borderBottomSpace = borderBottomSpace;
    }

    public String getBorderLeftSpace() {
        return borderLeftSpace;
    }

    public void setBorderLeftSpace(String borderLeftSpace) {
        this.borderLeftSpace = borderLeftSpace;
    }

    public String getBorderRightSpace() {
        return borderRightSpace;
    }

    public void setBorderRightSpace(String borderRightSpace) {
        this.borderRightSpace = borderRightSpace;
    }

    public String getBorderDiagonalUpSpace() {
        return borderDiagonalUpSpace;
    }

    public void setBorderDiagonalUpSpace(String borderDiagonalUpSpace) {
        this.borderDiagonalUpSpace = borderDiagonalUpSpace;
    }

    public String getBorderDiagonalDownSpace() {
        return borderDiagonalDownSpace;
    }

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
