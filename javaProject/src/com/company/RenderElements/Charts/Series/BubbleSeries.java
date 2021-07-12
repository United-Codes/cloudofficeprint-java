package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Iterator;

/**
 * Represents series for a bubble chart.
 */
public class BubbleSeries extends XYSeries {

    private Integer[] sizes;

    /**
     * @return Sizes of each of the bubbles.
     */
    public Integer[] getSizes() {
        return sizes;
    }

    /**
     * @param sizes Sizes of each of the bubbles.
     */
    public void setSizes(Integer[] sizes) {
        this.sizes = sizes;
    }

    /**
     * This object represents series for a bubble chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     * @param sizes Sizes of each of the bubbles.
     */
    public BubbleSeries(String name, String[] x, String[] y, Integer[] sizes){
        setName(name);
        setX(x);
        setY(y);
        setSizes(sizes);
    }

    /**
     * @return JsonArray of the data of the serie.
     */
    @Override
    public JsonArray getJSONData() {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i <getX().length; i++){
            JsonObject xy = new JsonObject();
            xy.addProperty("x",getX()[i]);
            xy.addProperty("y",getY()[i]);
            if (getSizes()!=null){
                if (getSizes()[i]!=null){
                    xy.addProperty("size",getSizes()[i]);
                }
            }
            jsonArray.add(xy);
        }
        return jsonArray;
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.add("data", getJSONData());
        if (getName()!=null){
            json.addProperty("name",getName());
        }
        return json;
    }
}
