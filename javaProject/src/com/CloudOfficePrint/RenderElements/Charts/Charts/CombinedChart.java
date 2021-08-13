package com.CloudOfficePrint.RenderElements.Charts.Charts;

import com.CloudOfficePrint.RenderElements.Charts.ChartOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Represents a combined chart. Multiple chart types can be combined (but there
 * can be maximum 2 y-axis).
 */
public class CombinedChart extends Chart {
    ArrayList<Chart> charts = new ArrayList<>();
    ArrayList<Chart> secondaryCharts = new ArrayList<>();

    /**
     * @return Charts for the first y-axis.
     */
    public ArrayList<Chart> getCharts() {
        return charts;
    }

    /**
     * @param charts Charts for the first y-axis.
     */
    public void setCharts(ArrayList<Chart> charts) {
        this.charts = charts;
    }

    /**
     * @return Charts for the second y-axis.
     */
    public ArrayList<Chart> getSecondaryCharts() {
        return secondaryCharts;
    }

    /**
     * @param secondaryCharts Charts for the second y-axis.
     */
    public void setSecondaryCharts(ArrayList<Chart> secondaryCharts) {
        this.secondaryCharts = secondaryCharts;
    }

    /**
     * Represents a combined chart. Multiple chart types can be combined (but there
     * can be maximum 2 y-axis).
     * 
     * @param name            Name of the chart (for the tag).
     * @param options         Options of the chart.
     * @param charts          Charts for the first y-axis.
     * @param secondaryCharts Charts for the second y-axis.
     */
    public CombinedChart(String name, ChartOptions options, Chart[] charts, Chart[] secondaryCharts) {
        setName(name);
        setOptions(options);
        for (Chart chart : charts) {
            getCharts().add(chart);
        }
        for (Chart chart : secondaryCharts) {
            getSecondaryCharts().add(chart);
        }
    }

    /**
     * Replaces all the occurrences of oldKey in the json with the newKey. Objects
     * with key "options" will not be modified (y-axis stays y-axis).
     * 
     * @param jsonOld Json to be modified.
     * @param oldKey  Old keys to be replaced.
     * @param newKey  New key to replace the old key.
     * @return Json with the old key replaced by the new key.
     */
    public JsonObject replaceKeyRecursive(JsonObject jsonOld, String oldKey, String newKey) {
        JsonObject json = jsonOld.deepCopy();

        for (Map.Entry<String, JsonElement> entry : jsonOld.entrySet()) {
            if (entry.getValue() instanceof JsonObject) {
                if (entry.getKey() != "options") {
                    json.remove((String) entry.getKey());
                    json.add((String) entry.getKey(),
                            replaceKeyRecursive((JsonObject) entry.getValue(), oldKey, newKey));
                }
            } else if (entry.getValue() instanceof JsonArray) {
                JsonArray newArray = new JsonArray();
                Iterator<JsonElement> iterator = ((JsonArray) entry.getValue()).iterator();
                while (iterator.hasNext()) {
                    JsonObject next = (JsonObject) iterator.next();
                    newArray.add(replaceKeyRecursive(next, oldKey, newKey));
                }
                json.add((String) entry.getKey(), newArray);
            }
        }

        if (json.has(oldKey)) {
            JsonElement value = json.get(oldKey);
            json.remove(oldKey);
            json.add(newKey, value);
        }

        return json;

    }

    /**
     * @return An array of the JSONs of the charts but adapted to a multiple chart.
     */
    public JsonArray getModifiedChartDicts() {
        JsonArray array = new JsonArray();
        for (Chart chart : getCharts()) {
            JsonObject dict = chart.getJSON();
            dict = dict.getAsJsonObject(chart.getName());
            array.add(dict);
        }
        for (Chart chart : getSecondaryCharts()) {
            JsonObject dict = chart.getJSON();
            dict = dict.getAsJsonObject(chart.getName());
            dict = replaceKeyRecursive(dict, "y", "y2");
            array.add(dict);
        }
        return array;
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonObject result = new JsonObject();
        result.add("multiples", getModifiedChartDicts());
        if (getOptions() != null) {
            result.add("options", getOptions().getJSON());
        }
        result.addProperty("type", "multiple");
        json.add(getName(), result);
        return json;
    }

}
