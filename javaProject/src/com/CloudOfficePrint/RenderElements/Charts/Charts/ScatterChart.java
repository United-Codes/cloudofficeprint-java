package com.CloudOfficePrint.RenderElements.Charts.Charts;

import com.CloudOfficePrint.RenderElements.Charts.ChartOptions;
import com.CloudOfficePrint.RenderElements.Charts.Series.ScatterSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;


/**
 * Represents a scatter chart.
 */
public class ScatterChart extends Chart{
    ArrayList<ScatterSeries> series = new ArrayList<>();

    /**
     * @return Serie with the data for the chart.
     */
    public ArrayList<ScatterSeries> getSeries() {
        return series;
    }

    /**
     * @param series Serie with the data for the chart.
     */
    public void setSeries(ArrayList<ScatterSeries> series) {
        this.series = series;
    }

    /**
     * Represents an area chart.
     * @param name Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param series Series with the data for the chart.
     */
    public ScatterChart(String name, ChartOptions options, ScatterSeries ... series){
        setName(name);
        setOptions(options);
        for (ScatterSeries serie: series){
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
        if(getOptions()!=null){
            result.add("options", getOptions().getJSON());
        }
        JsonArray lines = new JsonArray();
        for (ScatterSeries serie : getSeries()){
            lines.add(serie.getJSON());
        }
        result.add("scatters", lines);
        result.addProperty("type","scatter");
        json.add(getName(),result);
        return json;
    }

}