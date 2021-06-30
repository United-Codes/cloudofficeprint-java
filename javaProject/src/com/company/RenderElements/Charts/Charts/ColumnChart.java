package com.company.RenderElements.Charts.Charts;

import com.company.RenderElements.Charts.ChartOptions;
import com.company.RenderElements.Charts.Series.ColumnSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;


/**
 * Represents a column chart.
 */
public class ColumnChart extends Chart{
    ArrayList<ColumnSeries> columnSeries = new ArrayList<>();

    /**
     * @return ColumnSeries with the data for the chart.
     */
    public ArrayList<ColumnSeries> getColumnSeries() {
        return columnSeries;
    }

    /**
     * @param columnSeries ColumnSeries with the data for the chart.
     */
    public void setColumnSeries(ArrayList<ColumnSeries> columnSeries) {
        this.columnSeries = columnSeries;
    }

    /**
     * Represents a column chart.
     * @param name Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param columnSeries Series with the data for the chart.
     */
    public ColumnChart(String name, ChartOptions options, ColumnSeries[] columnSeries){
        setName(name);
        setOptions(options);
        for (ColumnSeries columnSerie: columnSeries){
            getColumnSeries().add(columnSerie);
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
        for (ColumnSeries columnSerie : getColumnSeries()){
            lines.add(columnSerie.getJSON());
        }
        result.add("columns", lines);
        result.addProperty("type","column");
        json.add(getName(),result);
        return json;
    }

}