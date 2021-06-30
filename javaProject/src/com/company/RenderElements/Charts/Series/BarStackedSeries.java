package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonArray;

/**
 * Represents series for stacked bar charts.
 */
public class BarStackedSeries extends XYSeries {

    /**
     * This object series for represents a stacked bar chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     */
    public BarStackedSeries(String name, JsonArray x, JsonArray y){
        setName(name);
        setX(x);
        setY(y);
    }
}
