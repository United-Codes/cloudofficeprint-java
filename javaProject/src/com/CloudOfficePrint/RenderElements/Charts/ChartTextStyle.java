package com.CloudOfficePrint.RenderElements.Charts;

import com.google.gson.JsonObject;

/**
 * This class represent chart styling.
 */
public class ChartTextStyle {

    private Boolean italic;
    private Boolean bold;
    private String color;
    private String font;

    /**
     * @return Whether the chart text is in italic.
     */
    public Boolean getItalic() {
        return italic;
    }

    /**
     * @param italic Whether the chart text is in italic.
     */
    public void setItalic(Boolean italic) {
        this.italic = italic;
    }

    /**
     * @return Whether the chart text is in bold.
     */
    public Boolean getBold() {
        return bold;
    }

    /**
     * @param bold Whether the chart text is in bold.
     */
    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    /**
     * @return Color of the text.
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color Color of the text.
     */
    public void setColor(String color) {
        this.color = color;
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
     * Contains the styling options for the text of the chart.
     * 
     * @param italic Whether the text is in italic.
     * @param bold   Whether the text is in bold.
     * @param color  Color of the text.
     * @param font   Font of the text.
     */
    public ChartTextStyle(Boolean italic, Boolean bold, String color, String font) {
        setItalic(italic);
        setBold(bold);
        setColor(color);
        setFont(font);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getItalic() != null) {
            json.addProperty("italic", getItalic());
        }
        if (getBold() != null) {
            json.addProperty("bold", getBold());
        }
        if (getColor() != null) {
            json.addProperty("color", getColor());
        }
        if (getFont() != null) {
            json.addProperty("font", getFont());
        }
        return json;
    }

}
