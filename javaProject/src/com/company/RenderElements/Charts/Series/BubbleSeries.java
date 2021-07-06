package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Iterator;

/**
 * Represents series for a bubble chart.
 */
public class BubbleSeries extends XYSeries {

    private JsonArray sizes = new JsonArray();

    /**
     * @return Sizes of each of the bubbles.
     */
    public JsonArray getSizes() {
        return sizes;
    }

    /**
     * @param sizes Sizes of each of the bubbles.
     */
    public void setSizes(JsonArray sizes) {
        this.sizes = sizes;
    }

    /**
     * This object represents series for a bubble chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     * @param sizes Sizes of each of the bubbles.
     */
    public BubbleSeries(String name, String[] x, String[] y, JsonArray sizes){
        setName(name);
        setX(x);
        setY(y);
        setSizes(sizes);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        Iterator itrX = getX().iterator();
        Iterator itrY = getY().iterator();
        Iterator itrS = getSizes().iterator();
        while(itrX.hasNext()) {
            JsonObject xy = new JsonObject();
            String x = (String) itrX.next();
            String y = (String) itrY.next();
            xy.addProperty("x",x);
            xy.addProperty("y",y);
            if (getSizes()!=null){
                String color = (String) itrS.next();
                xy.addProperty("size",color);
            }
        }
        if (getName()!=null){
            json.addProperty("name",getName());
        }
        return json;
    }
}
