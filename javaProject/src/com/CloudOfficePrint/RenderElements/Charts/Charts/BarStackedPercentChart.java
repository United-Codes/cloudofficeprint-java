package com.CloudOfficePrint.RenderElements.Charts.Charts;

import com.CloudOfficePrint.RenderElements.Charts.ChartOptions;
import com.CloudOfficePrint.RenderElements.Charts.Series.BarStackedPercentSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents a stacked bar chart where the x-axis is expressed in percentage.
 */
public class BarStackedPercentChart extends Chart {
    ArrayList<BarStackedPercentSeries> barStackedPercentSeries = new ArrayList<BarStackedPercentSeries>();

    /**
     * @return BarStackedPercentSeries with the data for the chart.
     */
    public ArrayList<BarStackedPercentSeries> getBarStackedPercentSeries() {
        return barStackedPercentSeries;
    }

    /**
     * @param barStackedPercentSeries BarStackedPercentSeries with the data for the
     *                                chart.
     */
    public void setBarStackedPercentSeries(ArrayList<BarStackedPercentSeries> barStackedPercentSeries) {
        this.barStackedPercentSeries = barStackedPercentSeries;
    }

    /**
     * Represents a stacked bar chart.
     * 
     * @param name                    Name of the chart (for the tag).
     * @param options                 Options of the chart.
     * @param barStackedPercentSeries Series with the data for the chart.
     */
    public BarStackedPercentChart(String name, ChartOptions options,
            BarStackedPercentSeries... barStackedPercentSeries) {
        setName(name);
        setOptions(options);
        for (BarStackedPercentSeries barStackedPercentSerie : barStackedPercentSeries) {
            getBarStackedPercentSeries().add(barStackedPercentSerie);
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
        for (BarStackedPercentSeries barStackedPercentSerie : getBarStackedPercentSeries()) {
            lines.add(barStackedPercentSerie.getJSON());
        }
        result.add("bars", lines);
        result.addProperty("type", "barStackedPercent");
        json.add(getName(), result);
        return json;
    }

}