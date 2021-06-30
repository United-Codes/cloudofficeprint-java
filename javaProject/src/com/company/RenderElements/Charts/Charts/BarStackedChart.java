package com.company.RenderElements.Charts.Charts;

import com.company.RenderElements.Charts.ChartOptions;
import com.company.RenderElements.Charts.Series.BarStackedSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Represents a stacked bar chart.
 */
public class BarStackedChart extends Chart{
    ArrayList<BarStackedSeries> lineseries = new ArrayList<BarStackedSeries>();

    /**
     * @return BarStackedSeries with the data for the chart.
     */
    public ArrayList<BarStackedSeries> getBarStackedSeries() {
        return lineseries;
    }

    /**
     * @param lineseries BarStackedSeries with the data for the chart.
     */
    public void setBarStackedSeries(ArrayList<BarStackedSeries> lineseries) {
        this.lineseries = lineseries;
    }

    /**
     * Represents a stacked bar chart.
     * @param name Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param barStackedSeries Series with the data for the chart.
     */
    public BarStackedChart(String name, ChartOptions options, BarStackedSeries ... barStackedSeries){
        setName(name);
        setOptions(options);
        for (BarStackedSeries barStackedSerie: lineseries){
            getBarStackedSeries().add(barStackedSerie);
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
        for (BarStackedSeries barStackedSerie : getBarStackedSeries()){
            lines.add(barStackedSerie.getJSON());
        }
        result.add("bars", lines);
        result.addProperty("type","barStacked");
        json.add(getName(),result);
        return json;
    }

}