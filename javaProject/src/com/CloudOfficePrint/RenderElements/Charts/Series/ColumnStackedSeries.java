package com.CloudOfficePrint.RenderElements.Charts.Series;

/**
 * Represents series for stacked column charts.
 */
public class ColumnStackedSeries extends XYSeries {

    /**
     * This object represents series for a stacked column chart.
     * 
     * @param name Name of the chart.
     * @param x    X-data of the chart.
     * @param y    Y-data of the chart.
     */
    public ColumnStackedSeries(String name, String[] x, String[] y) {
        setName(name);
        setX(x);
        setY(y);
    }
}
