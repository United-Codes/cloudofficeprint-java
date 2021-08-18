package com.cloudofficeprint.RenderElements.Charts.Charts;

import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.Series.LineSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * This class represents line charts.
 */
public class LineChart extends Chart {

    ArrayList<LineSeries> lineseries = new ArrayList<LineSeries>();

    /**
     * @return Lineseries with the data for the chart.
     */
    public ArrayList<LineSeries> getLineseries() {
        return lineseries;
    }

    /**
     * @param lineseries Lineseries with the data for the chart.
     */
    public void setLineseries(ArrayList<LineSeries> lineseries) {
        this.lineseries = lineseries;
    }

    /**
     * Represents a line chart.
     * 
     * @param name       Name of the chart (for the tag).
     * @param options    Options of the chart.
     * @param lineseries Series with the data for the chart.
     */
    public LineChart(String name, ChartOptions options, LineSeries... lineseries) {
        setName(name);
        setOptions(options);
        for (LineSeries lineserie : lineseries) {
            getLineseries().add(lineserie);
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
        for (LineSeries lineserie : getLineseries()) {
            lines.add(lineserie.getJSON());
        }
        result.add("lines", lines);
        result.addProperty("type", "line");
        json.add(getName(), result);
        return json;
    }

}
