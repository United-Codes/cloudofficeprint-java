package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonObject;

import java.util.Iterator;

/**
 * This class represents series for pie charts.
 */
public class PieSeries extends XYSeries {

    private String[] colors;

    /**
     * Note : If no colors are specified, the document's theme is used.
     * If some colors are specified, but not for all data points, random colors will fill the gaps.
     * @return Individual colors for each pie slice in CSS format.
     */
    public String[] getColors() {
        return colors;
    }

    /**
     * Note : If no colors are specified, the document's theme is used.
     * If some colors are specified, but not for all data points, random colors will fill the gaps.
     * @param colors Individual colors for each pie slice.
     */
    public void setColors(String[] colors) {
        this.colors = colors;
    }

    /**
     * This object represents series for a pie chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     * @param colors Colors for each pie slice. Note : If no colors are specified (null argument), the document's theme is used.
     *               If some colors are specified, but not for all data points, random colors will fill the gaps.
     */
    public PieSeries(String name, String[] x, String[] y, String[] colors){
        setName(name);
        setX(x);
        setY(y);
        setColors(colors);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();

        for (int i = 0; i <getX().length; i++){
            JsonObject xy = new JsonObject();
            xy.addProperty("x",getX()[i]);
            xy.addProperty("y",getY()[i]);
            if (getColors()!=null){
                xy.addProperty("color",getColors()[i]);
            }
        }
        if (getName()!=null){
            json.addProperty("name",getName());
        }
        return json;
    }
}
