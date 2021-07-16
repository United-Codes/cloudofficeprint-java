package com.CloudOfficePrint.RenderElements.Charts.Series;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * This class represents series for pie charts.
 */
public class PieSeries extends XYSeries {

    private String[] colors = {};

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
     *               (setColor() doesn't have an impact on pieseries.)
     */
    public PieSeries(String name, String[] x, String[] y, String[] colors){
        setName(name);
        setX(x);
        setY(y);
        setColors(colors);
    }

    /**
     * @return JsonArray of the data of the serie.
     */
    @Override
    public JsonArray getJSONData() {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i <getX().length; i++){
            JsonObject xy = new JsonObject();
            xy.addProperty("x",getX()[i]);
            xy.addProperty("y",getY()[i]);
            if (getColors()!=null){
                if (getColors()[i]!=null){
                    xy.addProperty("color",getColors()[i]);
                }
            }
            jsonArray.add(xy);
        }
        return jsonArray;
    }


}
