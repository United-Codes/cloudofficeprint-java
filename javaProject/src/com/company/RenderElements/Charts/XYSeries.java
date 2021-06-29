package com.company.RenderElements.Charts;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;

public class XYSeries extends Series{
    JsonArray x;
    JsonArray y;

    /**
     * @return X-data of the serie.
     */
    public JsonArray getX() {
        return x;
    }

    /**
     * @param x X-data of the serie.
     */
    public void setX(JsonArray x) {
        this.x = x;
    }

    /**
     * @return Y-data of the serie.
     */
    public JsonArray getY() {
        return y;
    }

    /**
     * @param y Y-data of the serie.
     */
    public void setY(JsonArray y) {
        this.y = y;
    }

    /**
     * @param x X-data of the serie.
     * @param y Y-data of the serie.
     */
    public XYSeries(JsonArray x, JsonArray y){
        setX(x);
        setY(y);
    }

    /**
     * @return Json of the data of the serie.
     */
    public JsonObject getJSONData() {
        JsonObject json = new JsonObject();
        Iterator itrX = x.iterator();
        Iterator itrY = y.iterator();
        while(itrX.hasNext()) {
            JsonObject xy = new JsonObject();
            String x = (String) itrX.next();
            String y = (String) itrY.next();
            xy.addProperty("x",x);
            xy.addProperty("y",y);
        }
        return json;
    }
}
