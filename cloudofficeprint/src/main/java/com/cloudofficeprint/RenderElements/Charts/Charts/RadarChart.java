package com.cloudofficeprint.RenderElements.Charts.Charts;

import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.Series.RadarSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents a radar chart.
 */
public class RadarChart extends Chart {
    ArrayList<RadarSeries> series = new ArrayList<>();

    /**
     * @return Serie with the data for the chart.
     */
    public ArrayList<RadarSeries> getSeries() {
        return series;
    }

    /**
     * @param series Serie with the data for the chart.
     */
    public void setSeries(ArrayList<RadarSeries> series) {
        this.series = series;
    }

    /**
     * Represents a radar chart.
     * 
     * @param name    Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param series  Series with the data for the chart.
     */
    public RadarChart(String name, ChartOptions options, RadarSeries... series) {
        setName(name);
        setOptions(options);
        for (RadarSeries serie : series) {
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
        for (RadarSeries serie : getSeries()) {
            lines.add(serie.getJSON());
        }
        result.add("radars", lines);
        result.addProperty("type", "radar");
        json.add(getName(), result);
        return json;
    }

}