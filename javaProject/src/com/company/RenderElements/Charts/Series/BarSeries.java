package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonArray;

/**
 * Represents series for bar charts.
 */
public class BarSeries extends XYSeries {

    /**
     * This object represents series for a bar chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     */
    public BarSeries(String name, JsonArray x, JsonArray y){
        setName(name);
        setX(x);
        setY(y);
    }
}