package com.cloudofficeprint.RenderElements.Charts.Series;

/**
 * Represents series for stacked bar charts where the x-axis is expressed in
 * percentage.
 */
public class BarStackedPercentSeries extends XYSeries {

    /**
     * This object represents series for a stacked bar chart where the x-axis is
     * expressed in percentage.
     * 
     * @param name Name of the chart.
     * @param x    X-data of the chart.
     * @param y    Y-data of the chart.
     */
    public BarStackedPercentSeries(String name, String[] x, String[] y) {
        setName(name);
        setX(x);
        setY(y);
    }
}