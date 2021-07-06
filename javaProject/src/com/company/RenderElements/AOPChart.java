package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;

/**
 * Supported in Word, Excel and Powerpoint templates.
 * This class represent AOP charts (including the data and style). The chart in the template can be styled through MS Office or
 * LibreOffice as an alternative to passing the style options as a part of the input data. This allows the use of style options we do not support, but moves the
 * chart styling from the data to the template. This may case some difficulties, e.g. : loops containing a chart with different
 * style on each iteration would not be possible using this tag.
 */
public class AOPChart extends  RenderElement{

    private JsonArray xData = new JsonArray();
    private HashMap<String, JsonArray> yData = new HashMap<>();
    private String  title;
    private String xTitle;
    private String yTitle;
    private String y2Title;
    private String x2Title;

    /**
     * @return JsonArray of the data of the x-axis. Format : ["day 1", "day 2", "day 3", "day 4", "day 5"] or
     * [{"value": "day 1"}, {"value": "day 2"}, {"value": "day 3"}, {"value": "day 4"}, {"value": "day 5"}]
     */
    public JsonArray getXData() {
        return xData;
    }

    /**
     * @param xData JsonArray of the data of the x-axis. Format : ["day 1", "day 2", "day 3", "day 4", "day 5"] or
     *              [{"value": "day 1"}, {"value": "day 2"}, {"value": "day 3"}, {"value": "day 4"}, {"value": "day 5"}]
     */
    public void setXData(JsonArray xData) {
        this.xData = xData;
    }

    /**
     * @return HashMap(Name of the serie, JsonArray of y-data) in the same format as xData.
     */
    public HashMap<String, JsonArray> getYData() {
        return yData;
    }

    /**
     * @param yData HashMap(Name of the serie, JsonArray of y-data) in the same format as xData.
     */
    public void setYData(HashMap<String, JsonArray> yData) {
        this.yData = yData;
    }

    /**
     * @return Title of the chart.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title Title of the chart.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Title of the x-axis.
     */
    public String getXTitle() {
        return xTitle;
    }

    /**
     * @param xTitle Title of the x-axis.
     */
    public void setXTitle(String xTitle) {
        this.xTitle = xTitle;
    }

    /**
     * @return Title of the y-axis.
     */
    public String getYTitle() {
        return yTitle;
    }

    /**
     * @param yTitle Title of the y-axis.
     */
    public void setYTitle(String yTitle) {
        this.yTitle = yTitle;
    }

    /**
     * @return Title of the second y-axis.
     */
    public String getY2Title() {
        return y2Title;
    }

    /**
     * @param y2Title Title of the second y-axis.
     */
    public void setY2Title(String y2Title) {
        this.y2Title = y2Title;
    }

    /**
     * @return Title of the second x-axis.
     */
    public String getX2Title() {
        return x2Title;
    }

    /**
     * @param x2Title Title of the second x-axis.
     */
    public void setX2Title(String x2Title) {
        this.x2Title = x2Title;
    }

    /**
     * Represent an AOP chart (including data and style). If you don't want te specify some parameters, use null as argument.
     * @param name Name of the chart for the tag.
     * @param xData ArrayList(String) of the data of the x-axis. Format : ["day 1", "day 2", "day 3", "day 4", "day 5"] or
     *              [{"value": "day 1"}, {"value": "day 2"}, {"value": "day 3"}, {"value": "day 4"}, {"value": "day 5"}]
     * @param yData HashMap(Name of the serie), ArrayList(y-data) data in the same format as xData.
     * @param title Title of the chart.
     * @param xTitle Title of the x-axis.
     * @param yTitle Title of the y-axis.
     * @param y2Title Title of the second x-axis.
     * @param x2Title Title of the second y-axis.
     */
    public AOPChart(String name, JsonArray xData, HashMap<String, JsonArray> yData, String  title,
                    String xTitle, String yTitle, String y2Title, String x2Title){
        setName(name);
        setXData(xData);
        setYData(yData);
        setTitle(title);
        setXTitle(xTitle);
        setYTitle(yTitle);
        setY2Title(y2Title);
        setX2Title(x2Title);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getTitle()!=null){
            json.addProperty("title", getTitle());
        }

        JsonObject xAxis = new JsonObject();
        xAxis.add("data",getXData());
        if (getXTitle()!=null){
            xAxis.addProperty("title",getXTitle());
        }
        json.add("xAxis", xAxis);

        JsonArray series = new JsonArray();
        for(Map.Entry<String, JsonArray> entry : getYData().entrySet()) {
            JsonObject serie = new JsonObject();
            serie.addProperty("name", entry.getKey());
            serie.add("data", entry.getValue());
            series.add(serie);
        }
        JsonObject yAxis = new JsonObject();
        yAxis.add("series", series);
        yAxis.add("data",getXData());
        if(getYTitle()!=null){
            yAxis.addProperty("title",getYTitle());
        }
        json.add("yAxis", yAxis);

        if (getX2Title()!=null){
            JsonObject x2title = new JsonObject();
            x2title.addProperty("title", getX2Title());
            json.add("x2Axis", x2title);
        }

        if (getY2Title()!=null) {
            JsonObject y2title = new JsonObject();
            y2title.addProperty("title", getY2Title());
            json.add("y2Axis", y2title);
        }

        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{aopchart "+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
