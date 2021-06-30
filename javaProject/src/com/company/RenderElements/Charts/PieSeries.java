package com.company.RenderElements.Charts;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Iterator;

/**
 * This class represents pie charts.
 */
public class PieSeries extends  XYSeries{

    private JsonArray colors;

    /**
     * Note : If no colors are specified, the document's theme is used.
     * If some colors are specified, but not for all data points, random colors will fill the gaps.
     * @return Individual colors for each pie slice in CSS format.
     */
    public JsonArray getColors() {
        return colors;
    }

    /**
     * Note : If no colors are specified, the document's theme is used.
     * If some colors are specified, but not for all data points, random colors will fill the gaps.
     * @param colors Individual colors for each pie slice.
     */
    public void setColors(JsonArray colors) {
        this.colors = colors;
    }

    /**
     * This object represents a pie chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     * @param colors Colors for each pie slice. Note : If no colors are specified (null argument), the document's theme is used.
     *               If some colors are specified, but not for all data points, random colors will fill the gaps.
     */
    public PieSeries(String name, JsonArray x, JsonArray y, JsonArray colors){
        setName(name);
        setX(x);
        setY(y);
        setColors(colors);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        Iterator itrX = x.iterator();
        Iterator itrY = y.iterator();
        Iterator itrC = colors.iterator();
        while(itrX.hasNext()) {
            JsonObject xy = new JsonObject();
            String x = (String) itrX.next();
            String y = (String) itrY.next();
            xy.addProperty("x",x);
            xy.addProperty("y",y);
            if (getColors()!=null){
                String color = (String) itrC.next();
                xy.addProperty("color",color);
            }
        }
        if (getName()!=null){
            json.addProperty("name",getName());
        }
        return json;
    }
}
