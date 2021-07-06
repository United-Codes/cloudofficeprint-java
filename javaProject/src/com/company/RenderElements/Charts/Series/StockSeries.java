package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Iterator;

/**
 * This class represents series for stock charts.
 */
public class StockSeries extends XYSeries {

    private JsonArray high = new JsonArray();
    private JsonArray low = new JsonArray();
    private JsonArray close = new JsonArray();
    private JsonArray open = new JsonArray();
    private JsonArray volume = new JsonArray();

    /**
     * @return High values for the open-high-low-close chart.
     */
    public JsonArray getHigh() {
        return high;
    }

    /**
     * @param high High values for the open-high-low-close chart.
     */
    public void setHigh(JsonArray high) {
        this.high = high;
    }

    /**
     * @return Low values for the open-high-low-close chart.
     */
    public JsonArray getLow() {
        return low;
    }

    /**
     * @param low Low values for the open-high-low-close chart.
     */
    public void setLow(JsonArray low) {
        this.low = low;
    }

    /**
     * @return Close values for the open-high-low-close chart.
     */
    public JsonArray getClose() {
        return close;
    }

    /**
     * @param close Close values for the open-high-low-close chart.
     */
    public void setClose(JsonArray close) {
        this.close = close;
    }

    /**
     * @return Open values for the open-high-low-close chart.
     */
    public JsonArray getOpen() {
        return open;
    }

    /**
     * @param open Open values for the open-high-low-close chart.
     */
    public void setOpen(JsonArray open) {
        this.open = open;
    }

    /**
     * @return Volume values for the open-high-low-close chart.
     */
    public JsonArray getVolume() {
        return volume;
    }

    /**
     * @param volume Volume values for the open-high-low-close chart.
     */
    public void setVolume(JsonArray volume) {
        this.volume = volume;
    }

    /**
     * This object represents series for a stock chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param high High values for the open-high-low-close chart.
     * @param low Low values for the open-high-low-close chart.
     * @param close Close values for the open-high-low-close chart.
     * @param open Open values for the open-high-low-close chart.
     * @param volume Volume values for the open-high-low-close chart.
     */
    public StockSeries(String name, String[] x, JsonArray high, JsonArray low, JsonArray close, JsonArray open, JsonArray volume){
        setName(name);
        setX(x);
        setHigh(high);
        setLow(low);
        setClose(close);
        setOpen(open);
        setVolume(volume);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        Iterator itrX = getX().iterator();
        Iterator itrY = getY().iterator();
        Iterator itrH = getHigh().iterator();
        Iterator itrL = getLow().iterator();
        Iterator itrC = getClose().iterator();
        Iterator itrV = getVolume().iterator();
        Iterator itrO = getOpen().iterator();
        while(itrX.hasNext()) {
            JsonObject xy = new JsonObject();
            String x = (String) itrX.next();
            String y = (String) itrY.next();
            xy.addProperty("x",x);
            xy.addProperty("y",y);

            String high = (String) itrH.next();
            xy.addProperty("high",high);
            String low = (String) itrL.next();
            xy.addProperty("low",low);
            String close = (String) itrC.next();
            xy.addProperty("close",close);

            if (getVolume()!=null){
                String volume = (String) itrV.next();
                xy.addProperty("volume",volume);
            }
            if (getOpen()!=null){
                String open = (String) itrO.next();
                xy.addProperty("volume",open);
            }
        }
        if (getName()!=null){
            json.addProperty("name",getName());
        }
        return json;
    }
}
