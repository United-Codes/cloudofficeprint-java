package com.cloudofficeprint.RenderElements.Charts.Charts;

import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.Series.AreaStackedSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents an area stacked chart.
 */
public class AreaStackedChart extends Chart {
    ArrayList<AreaStackedSeries> series = new ArrayList<>();

    /**
     * @return Serie with the data for the chart.
     */
    public ArrayList<AreaStackedSeries> getSeries() {
        return series;
    }

    /**
     * @param series Serie with the data for the chart.
     */
    public void setSeries(ArrayList<AreaStackedSeries> series) {
        this.series = series;
    }

    /**
     * Represents an area chart.
     *
     * @param name    Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param series  Series with the data for the chart.
     */
    public AreaStackedChart(String name, ChartOptions options, AreaStackedSeries... series) {
        setName(name);
        setOptions(options);
        for (AreaStackedSeries serie : series) {
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
        for (AreaStackedSeries serie : getSeries()) {
            lines.add(serie.getJSON());
        }
        result.add("areas", lines);
        result.addProperty("type", "areaStacked");
        json.add(getName(), result);
        return json;
    }

}