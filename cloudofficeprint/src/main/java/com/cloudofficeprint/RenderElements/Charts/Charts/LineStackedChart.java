package com.cloudofficeprint.RenderElements.Charts.Charts;

import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.Series.LineStackedSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * This class represents line charts.
 */
public class LineStackedChart extends Chart {

    ArrayList<LineStackedSeries> lineseries = new ArrayList<LineStackedSeries>();

    /**
     * @return Lineseries with the data for the chart.
     */
    public ArrayList<LineStackedSeries> getLineseries() {
        return lineseries;
    }

    /**
     * @param lineseries Lineseries with the data for the chart.
     */
    public void setLineseries(ArrayList<LineStackedSeries> lineseries) {
        this.lineseries = lineseries;
    }

    /**
     * Represents a line chart.
     *
     * @param name       Name of the chart (for the tag).
     * @param options    Options of the chart.
     * @param lineseries Series with the data for the chart.
     */
    public LineStackedChart(String name, ChartOptions options, LineStackedSeries... lineseries) {
        setName(name);
        setOptions(options);
        for (LineStackedSeries lineserie : lineseries) {
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
        for (LineStackedSeries lineserie : getLineseries()) {
            lines.add(lineserie.getJSON());
        }
        result.add("lines", lines);
        result.addProperty("type", "line");
        json.add(getName(), result);
        return json;
    }

}
