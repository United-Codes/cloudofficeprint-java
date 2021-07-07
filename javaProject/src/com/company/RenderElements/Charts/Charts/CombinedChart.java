package com.company.RenderElements.Charts.Charts;

import com.company.RenderElements.Charts.ChartOptions;
import com.company.RenderElements.Charts.Series.StockSeries;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Represents a combined chart. Multiple chart types can be combined (but there can be maximum 2 y-axis).
 */
public class CombinedChart extends Chart{
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
     * Represents a combined chart. Multiple chart types can be combined (but there can be maximum 2 y-axis).
     * @param name Name of the chart (for the tag).
     * @param options Options of the chart.
     * @param charts Charts for the first y-axis.
     * @param secondaryCharts Charts for the second y-axis.
     */
    public CombinedChart(String name, ChartOptions options, Chart[] charts, Chart[] secondaryCharts){
        setName(name);
        setOptions(options);
        for (Chart chart: charts){
            getCharts().add(chart);
        }
        for (Chart chart: secondaryCharts){
            getSecondaryCharts().add(chart);
        }
    }

    /**
     * Replaces all the occurrences of oldKey in the json with the newKey.
     * @param json Json to be modified.
     * @param oldKey Old keys to be replaced.
     * @param newKey New key to replace the old key.
     * @return Json with the old key replaced by the new key.
     */
    public JsonObject replaceKeyRecursive(JsonObject json, String oldKey, String newKey){
        System.out.println(json);
        for (Map.Entry entry : json.entrySet()){
            if (entry.getKey().toString() == oldKey){
                json.remove((String) entry.getKey());
                json.add(newKey, (JsonElement) entry.getValue());
            }
            if (entry.getValue()instanceof JsonObject ){
                json.remove((String) entry.getKey());
                json.add((String) entry.getKey(), replaceKeyRecursive((JsonObject) entry.getValue(),oldKey,newKey));
            }
            else if (entry.getValue()instanceof JsonArray ){
                JsonArray newarray = new JsonArray();
                Iterator iterator = ((JsonArray) entry.getValue()).iterator();
                while (iterator.hasNext()){
                    JsonObject next = (JsonObject) iterator.next();
                    newarray.add(replaceKeyRecursive(next,oldKey,newKey));
                }
                for (int i =0; i< newarray.size();i++){
                    ((JsonArray) entry.getValue()).remove(0);
                    ((JsonArray) entry.getValue()).add(newarray.get(i));
                }
            }
        }
        System.out.println(json);
        return json;
    }

    /**
     * @return An array of the JSONs of the charts but adapted to a multiple chart.
     */
    public JsonArray getModifiedChartDicts(){
        JsonArray array = new JsonArray();
        for (Chart chart : getCharts()){
            JsonObject dict = chart.getJSON();
            dict = dict.getAsJsonObject(chart.getName());
            dict.remove("options");
            array.add(dict);
        }
        //System.out.println(array);
        for (Chart chart : getSecondaryCharts()){
            JsonObject dict = chart.getJSON();
            dict = dict.getAsJsonObject(chart.getName());
            dict.remove("options");
            //System.out.println(dict);
            replaceKeyRecursive(dict,"y","y2"); //check ici
            //System.out.println(dict);
            //System.out.println(chart.getJSON());
            array.add(dict);
        }
        System.out.println(array);
        return array;
    }
    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonObject result = new JsonObject();
        result.addProperty("type","multiple");
        if(getOptions()!=null){
            result.add("options",getOptions().getJSON());
        }
        result.add("multiples",getModifiedChartDicts());
        json.add(getName(),result);
        return json;
    }

}
