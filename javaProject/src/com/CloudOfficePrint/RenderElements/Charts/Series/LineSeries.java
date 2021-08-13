package com.CloudOfficePrint.RenderElements.Charts.Series;

import com.google.gson.JsonObject;

/**
 * Represents series for a chart where the data-points are connected with lines.
 */
public class LineSeries extends XYSeries {

    private Boolean smooth;
    private String symbol;
    private String symbolSize;
    private String lineThickness;
    private String lineStyle;

    /**
     * @return Whether the corners of the angels formed in the data-points are
     *         smoothened.
     */
    public Boolean getSmooth() {
        return smooth;
    }

    /**
     * -
     * 
     * @param smooth Whether the corners of the angels formed in the data-points are
     *               smoothened.
     */
    public void setSmooth(Boolean smooth) {
        this.smooth = smooth;
    }

    /**
     * @return Symbol representing the datapoints. Can be square, diamond or
     *         triangle.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol Symbol representing the data-points. Can be square, diamond or
     *               triangle.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return Size of the symbol representing the data-points in (in em, pt, px, cm
     *         or in), by default: automatic.
     */
    public String getSymbolSize() {
        return symbolSize;
    }

    /**
     * @param symbolSize Size of the symbol representing the data-points in (in em,
     *                   pt, px, cm or in) e.g. : 20 pt, by default: automatic.
     */
    public void setSymbolSize(String symbolSize) {
        this.symbolSize = symbolSize;
    }

    /**
     * @return Thickness of the connecting line in em, pt, px, cm or in. e.g. : 20
     *         pt.
     */
    public String getLineThickness() {
        return lineThickness;
    }

    /**
     * @param lineThickness Thickness of the connecting line in em, pt, px, cm or
     *                      in. e.g. : 20 pt.
     */
    public void setLineThickness(String lineThickness) {
        this.lineThickness = lineThickness;
    }

    /**
     * @return Style of the line. Supported options can be found online on the AOP
     *         documentation.
     */
    public String getLineStyle() {
        return lineStyle;
    }

    /**
     * @param lineStyle Style of the line. Supported options can be found online on
     *                  the AOP documentation.
     */
    public void setLineStyle(String lineStyle) {
        this.lineStyle = lineStyle;
    }

    /**
     * This object represents series for a line chart (where data-points are
     * connected with lines).
     * 
     * @param name          Name of the chart.
     * @param x             X-data of the chart.
     * @param y             Y-data of the chart.
     * @param color         Color of the chart.
     * @param smooth        Whether the corners of the angels formed in the
     *                      data-points are smoothened.
     * @param symbol        Symbol representing the data-points. Can be square,
     *                      diamond or triangle.
     * @param symbolSize    Size of the symbol representing the data-points in (in
     *                      em, pt, px, cm or in) e.g. : 20 pt, by default:
     *                      automatic.
     * @param lineThickness Thickness of the connecting line in em, pt, px, cm or
     *                      in. e.g. : 20 pt.
     * @param lineStyle     Style of the line. Supported options can be found online
     *                      on the AOP documentation.
     */
    public LineSeries(String name, String[] x, String[] y, String color, Boolean smooth, String symbol,
            String symbolSize, String lineThickness, String lineStyle) {
        setName(name);
        setX(x);
        setY(y);
        setColor(color);
        setSmooth(smooth);
        setSymbol(symbol);
        setSymbolSize(symbolSize);
        setLineThickness(lineThickness);
        setLineStyle(lineStyle);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = super.getJSON();
        if (getSmooth() != null) {
            json.addProperty("smooth", getSmooth());
        }
        if (getSymbol() != null) {
            json.addProperty("symbol", getSymbol());
        }
        if (getSymbolSize() != null) {
            json.addProperty("symbolSize", getSymbolSize());
        }
        if (getLineThickness() != null) {
            json.addProperty("lineWidth", getLineThickness());
        }
        if (getLineStyle() != null) {
            json.addProperty("lineStyle", getLineStyle());
        }
        return json;
    }
}
