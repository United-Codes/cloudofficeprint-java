package com.CloudOfficePrint.RenderElements.Charts.Charts;

import com.CloudOfficePrint.RenderElements.Charts.ChartOptions;
import com.CloudOfficePrint.RenderElements.Charts.Series.ColumnStackedPercentSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents a stacked column chart.
 */
public class ColumnStackedPercentChart extends Chart {
    ArrayList<ColumnStackedPercentSeries> columnStackedPercentageSeries = new ArrayList<>();

    /**
     * @return ColumnStackedPercentSeries with the data for the chart.
     */
    public ArrayList<ColumnStackedPercentSeries> getColumnStackedPercentageSeries() {
        return columnStackedPercentageSeries;
    }

    /**
     * @param columnStackedPercentageSeries ColumnStackedPercentSeries with the data
     *                                      for the chart.
     */
    public void setColumnStackedPercentageSeries(ArrayList<ColumnStackedPercentSeries> columnStackedPercentageSeries) {
        this.columnStackedPercentageSeries = columnStackedPercentageSeries;
    }

    /**
     * Represents a stacked column chart where the y-axis is expressed in
     * percentage.
     * 
     * @param name                          Name of the chart (for the tag).
     * @param options                       Options of the chart.
     * @param columnStackedPercentageSeries Series with the data for the chart.
     */
    public ColumnStackedPercentChart(String name, ChartOptions options,
            ColumnStackedPercentSeries... columnStackedPercentageSeries) {
        setName(name);
        setOptions(options);
        for (ColumnStackedPercentSeries columnStackedPercentSerie : columnStackedPercentageSeries) {
            getColumnStackedPercentageSeries().add(columnStackedPercentSerie);
        }
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonObject result = new JsonObject();
        if (getOptions() != null) {
            result.add("options", getOptions().getJSON());
        }
        JsonArray lines = new JsonArray();
        for (ColumnStackedPercentSeries columnStackedPercentSerie : getColumnStackedPercentageSeries()) {
            lines.add(columnStackedPercentSerie.getJSON());
        }
        result.add("columns", lines);
        result.addProperty("type", "columnStackedPercent");
        json.add(getName(), result);
        return json;
    }

}