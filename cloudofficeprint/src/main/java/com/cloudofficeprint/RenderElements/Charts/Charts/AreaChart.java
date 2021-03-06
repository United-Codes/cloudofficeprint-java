package com.cloudofficeprint.RenderElements.Charts.Charts;

import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.Series.AreaSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents an area chart.
 */
public class AreaChart extends Chart {
    ArrayList<AreaSeries> series = new ArrayList<>();

    /**
     * @return Serie with the data for the chart.
     */
    public ArrayList<AreaSeries> getSeries() {
        return series;
    }

    /**
     * @param series Serie with the data for the chart.
     */
    public void setSeries(ArrayList<AreaSeries> series) {
        this.series = series;
    }

    /**
     * Represents an area chart.
     * 
     * @param name    Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param series  Series with the data for the chart.
     */
    public AreaChart(String name, ChartOptions options, AreaSeries... series) {
        setName(name);
        setOptions(options);
        for (AreaSeries serie : series) {
            getSeries().add(serie);
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
        for (AreaSeries serie : getSeries()) {
            lines.add(serie.getJSON());
        }
        result.add("areas", lines);
        result.addProperty("type", "area");
        json.add(getName(), result);
        return json;
    }

}