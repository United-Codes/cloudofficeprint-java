package com.CloudOfficePrint.RenderElements.Charts.Series;


/**
 * Represents series for scatter charts. Note: x-axis should only contain numbers.
 */
public class ScatterSeries extends XYSeries {

    /**
     * This object represents series for a scatter charts. Note: x-axis should only contain numbers.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     */
    public ScatterSeries(String name, String[] x, String[] y){
        setName(name);
        setX(x);
        setY(y);
    }
}
