package com.CloudOfficePrint.RenderElements.Charts.Series;

/**
 * Represents series for radar charts.
 */
public class RadarSeries extends LineSeries {

    /**
     * This object represents series for a radar chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     * @param color Color of the chart.
     * @param smooth Whether the corners of the angels formed in the data-points are smoothened.
     * @param symbol Symbol representing the data-points. Can be square, diamond or triangle.
     * @param symbolSize  Size of the symbol representing the data-points in (in em, pt, px, cm or in) e.g. : 20 pt, by default: automatic.
     * @param lineThickness Thickness of the connecting line in em, pt, px, cm or in. e.g. : 20 pt.
     * @param lineStyle Style of the line. Supported options can be found online on the AOP documentation.
     */
    public RadarSeries(String name, String[] x, String[] y, String color, Boolean smooth, String symbol, String symbolSize,
                       String lineThickness, String lineStyle){
        super(name,x,y,color,smooth,symbol,symbolSize,lineThickness,lineStyle);
    }
}