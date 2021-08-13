package com.CloudOfficePrint.RenderElements.Charts.Charts;

import com.CloudOfficePrint.RenderElements.Charts.ChartOptions;
import com.CloudOfficePrint.RenderElements.Charts.Series.StockSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents a stock chart.
 */
public class StockChart extends Chart {
    ArrayList<StockSeries> series = new ArrayList<>();

    /**
     * @return Serie with the data for the chart.
     */
    public ArrayList<StockSeries> getSeries() {
        return series;
    }

    /**
     * @param series Serie with the data for the chart.
     */
    public void setSeries(ArrayList<StockSeries> series) {
        this.series = series;
    }

    /**
     * Represents a stock chart.
     * 
     * @param name    Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param series  Series with the data for the chart.
     */
    public StockChart(String name, ChartOptions options, StockSeries... series) {
        setName(name);
        setOptions(options);
        for (StockSeries serie : series) {
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
        for (StockSeries serie : getSeries()) {
            lines.add(serie.getJSON());
        }
        result.add("stocks", lines);
        result.addProperty("type", "stock");
        json.add(getName(), result);
        return json;
    }

}
