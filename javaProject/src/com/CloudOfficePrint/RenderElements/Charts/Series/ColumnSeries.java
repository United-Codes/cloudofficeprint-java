package com.CloudOfficePrint.RenderElements.Charts.Series;


/**
 * Represents series for column charts.
 */
public class ColumnSeries extends XYSeries {

    /**
     * This object represents series for a column chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     */
    public ColumnSeries(String name, String[] x, String[] y){
        setName(name);
        setX(x);
        setY(y);
    }
}
