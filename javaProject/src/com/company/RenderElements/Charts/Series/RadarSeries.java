package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonArray;

/**
 * Represents series for radar charts.
 */
public class RadarSeries extends XYSeries {

    /**
     * This object represents series for a radar chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     */
    public RadarSeries(String name, JsonArray x, JsonArray y){
        setName(name);
        setX(x);
        setY(y);
    }
}