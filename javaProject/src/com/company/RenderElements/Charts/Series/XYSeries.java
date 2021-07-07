package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Iterator;

public abstract class XYSeries {
    String[] x;
    String[] y;
    private String name;

    /**
     * @return Name of the serie.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name of the serie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return X-data of the serie.
     */
    public String[] getX() {
        return x;
    }

    /**
     * @param x X-data of the serie.
     */
    public void setX(String[] x) {
        this.x = x;
    }

    /**
     * @return Y-data of the serie.
     */
    public String[] getY() {
        return y;
    }

    /**
     * @param y Y-data of the serie.
     */
    public void setY(String[] y) {
        this.y = y;
    }


    /**
     * @return JsonArray of the data of the serie.
     */
    public JsonArray getJSONData() {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i <getX().length; i++){
            JsonObject xy = new JsonObject();
            xy.addProperty("x",getX()[i]);
            xy.addProperty("y",getY()[i]);
            jsonArray.add(xy);
        }
        return jsonArray;
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON(){
        JsonObject json = new JsonObject();
        json.add("data", getJSONData());
        if (getName()!=null){
            json.addProperty("name",getName());
        }
        return json;
    }
}
