package com.company.RenderElements.Charts.Series;

/**
 * Represents series for stacked column charts where the y-axis is expressed in percentage.
 */
public class ColumnStackedPercentSeries extends XYSeries {

    /**
     * This object represents series for a stacked column chart where the y-axis is expressed in percentage.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     */
    public ColumnStackedPercentSeries(String name, String[] x, String[] y){
        setName(name);
        setX(x);
        setY(y);
    }
}
