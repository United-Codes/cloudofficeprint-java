package com.cloudofficeprint.RenderElements.Cells;

import com.google.gson.JsonObject;

/**
 * Represent the style of Word and PowerPoint cells.
 */
public class CellStyleDocxPpt extends CellStyle {

    private String backgroundColor;
    private String width;

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
     *         the initial width of the table)).
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
    public CellStyleDocxPpt(String backgroundColor, String width) {
        setBackgroundColor(backgroundColor);
        setWidth(width);
    }

    /**
     * @return JSONObject with the tags for this tableCell for the Cloud Office
     *         Print server.
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
        return json;
    }

}
