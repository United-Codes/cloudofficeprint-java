package com.CloudOfficePrint.RenderElements.Charts.Charts;

import com.CloudOfficePrint.RenderElements.Charts.ChartOptions;
import com.CloudOfficePrint.RenderElements.Charts.Series.BarSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents a bar chart.
 */
public class BarChart extends Chart{
    ArrayList<BarSeries> barSeries = new ArrayList<BarSeries>();

    /**
     * @return BarSeries with the data for the chart.
     */
    public ArrayList<BarSeries> getBarSeries() {
        return barSeries;
    }

    /**
     * @param barSeries BarSeries with the data for the chart.
     */
    public void setBarSeries(ArrayList<BarSeries> barSeries) {
        this.barSeries = barSeries;
    }

    /**
     * Represents a bar chart.
     * @param name Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param barSeries Series with the data for the chart.
     */
    public BarChart(String name, ChartOptions options, BarSeries ... barSeries){
        setName(name);
        setOptions(options);
        for (BarSeries barSerie: barSeries){
            getBarSeries().add(barSerie);
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
        for (BarSeries barSerie : getBarSeries()){
            lines.add(barSerie.getJSON());
        }
        result.add("bars", lines);
        result.addProperty("type","bar");
        json.add(getName(),result);
        return json;
    }

}