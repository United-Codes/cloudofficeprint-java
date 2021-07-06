package com.company.RenderElements.Charts.Charts;

import com.company.RenderElements.Charts.ChartOptions;
import com.company.RenderElements.Charts.Series.PieSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;


/**
 * Represents a doughnut chart.
 */
public class DoughnutChart extends Chart{
    ArrayList<PieSeries> pieSeries = new ArrayList<>();

    /**
     * @return PieSeries with the data for the chart.
     */
    public ArrayList<PieSeries> getPieSeries() {
        return pieSeries;
    }

    /**
     * @param pieSeries PieSeries with the data for the chart.
     */
    public void setPieSeries(ArrayList<PieSeries> pieSeries) {
        this.pieSeries = pieSeries;
    }

    /**
     * Represents a doughnut chart.
     * @param name Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param pieSeries Series with the data for the chart.
     */
    public DoughnutChart(String name, ChartOptions options, PieSeries ... pieSeries){
        setName(name);
        setOptions(options);
        for (PieSeries serie: pieSeries){
            getPieSeries().add(serie);
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
        for (PieSeries serie : getPieSeries()){
            lines.add(serie.getJSON());
        }
        result.add("doughnuts", lines);
        result.addProperty("type","doughnut");
        json.add(getName(),result);
        return json;
    }

}