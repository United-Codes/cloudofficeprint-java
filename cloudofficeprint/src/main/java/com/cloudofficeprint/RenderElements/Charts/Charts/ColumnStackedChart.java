package com.cloudofficeprint.RenderElements.Charts.Charts;

import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.Series.ColumnStackedSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents a stacked column chart.
 */
public class ColumnStackedChart extends Chart {
    ArrayList<ColumnStackedSeries> stackedColumnSeries = new ArrayList<>();

    /**
     * @return ColumnStackedSeries with the data for the chart.
     */
    public ArrayList<ColumnStackedSeries> getStackedColumnSeries() {
        return stackedColumnSeries;
    }

    /**
     * @param stackedColumnSeries ColumnStackedSeries with the data for the chart.
     */
    public void setStackedColumnSeries(ArrayList<ColumnStackedSeries> stackedColumnSeries) {
        this.stackedColumnSeries = stackedColumnSeries;
    }

    /**
     * Represents a stacked column chart.
     * 
     * @param name                Name of the chart (for the tag).
     * @param options             Options of the chart.
     * @param stackedColumnSeries Series with the data for the chart.
     */
    public ColumnStackedChart(String name, ChartOptions options, ColumnStackedSeries... stackedColumnSeries) {
        setName(name);
        setOptions(options);
        for (ColumnStackedSeries columnSerie : stackedColumnSeries) {
            getStackedColumnSeries().add(columnSerie);
        }
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonObject result = new JsonObject();
        if (getOptions() != null) {
            result.add("options", getOptions().getJSON());
        }
        JsonArray lines = new JsonArray();
        for (ColumnStackedSeries columnStackedSerie : getStackedColumnSeries()) {
            lines.add(columnStackedSerie.getJSON());
        }
        result.add("columns", lines);
        result.addProperty("type", "columnStacked");
        json.add(getName(), result);
        return json;
    }

}