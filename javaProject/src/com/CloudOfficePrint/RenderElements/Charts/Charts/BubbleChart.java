package com.CloudOfficePrint.RenderElements.Charts.Charts;

import com.CloudOfficePrint.RenderElements.Charts.ChartOptions;
import com.CloudOfficePrint.RenderElements.Charts.Series.BubbleSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents a bubble chart.
 */
public class BubbleChart extends Chart {
    ArrayList<BubbleSeries> series = new ArrayList<>();

    /**
     * @return Serie with the data for the chart.
     */
    public ArrayList<BubbleSeries> getSeries() {
        return series;
    }

    /**
     * @param series Serie with the data for the chart.
     */
    public void setSeries(ArrayList<BubbleSeries> series) {
        this.series = series;
    }

    /**
     * Represents a bubble chart.
     * 
     * @param name    Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param series  Series with the data for the chart.
     */
    public BubbleChart(String name, ChartOptions options, BubbleSeries... series) {
        setName(name);
        setOptions(options);
        for (BubbleSeries serie : series) {
            getSeries().add(serie);
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
        for (BubbleSeries serie : getSeries()) {
            lines.add(serie.getJSON());
        }
        result.add("bubbles", lines);
        result.addProperty("type", "bubble");
        json.add(getName(), result);
        return json;
    }

}
