package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonObject;

import java.util.Iterator;

public abstract class XYSeries extends Series {
    String[] x;
    String[] y;

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
     * @return Json of the data of the serie.
     */
    public JsonObject getJSONData() {
        JsonObject json = new JsonObject();
        Iterator itrX = getX().iterator();
        Iterator itrY = getY().iterator();
        for ()
        while(itrX.hasNext()) {
            JsonObject xy = new JsonObject();
            String x = (String) itrX.next();
            String y = (String) itrY.next();
            xy.addProperty("x",x);
            xy.addProperty("y",y);
        }
        return json;
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
