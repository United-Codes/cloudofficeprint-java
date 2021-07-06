package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonObject;

import java.util.Iterator;

/**
 * This class represents series for stock charts.
 */
public class StockSeries extends XYSeries {

    private Integer[] high;
    private Integer[] low;
    private Integer[] close;
    private Integer[] open;
    private Integer[] volume;

    /**
     * @return High values for the open-high-low-close chart.
     */
    public Integer[] getHigh() {
        return high;
    }

    /**
     * @param high High values for the open-high-low-close chart.
     */
    public void setHigh(Integer[] high) {
        this.high = high;
    }

    /**
     * @return Low values for the open-high-low-close chart.
     */
    public Integer[] getLow() {
        return low;
    }

    /**
     * @param low Low values for the open-high-low-close chart.
     */
    public void setLow(Integer[] low) {
        this.low = low;
    }

    /**
     * @return Close values for the open-high-low-close chart.
     */
    public Integer[] getClose() {
        return close;
    }

    /**
     * @param close Close values for the open-high-low-close chart.
     */
    public void setClose(Integer[] close) {
        this.close = close;
    }

    /**
     * @return Open values for the open-high-low-close chart.
     */
    public Integer[] getOpen() {
        return open;
    }

    /**
     * @param open Open values for the open-high-low-close chart.
     */
    public void setOpen(Integer[] open) {
        this.open = open;
    }

    /**
     * @return Volume values for the open-high-low-close chart.
     */
    public Integer[] getVolume() {
        return volume;
    }

    /**
     * @param volume Volume values for the open-high-low-close chart.
     */
    public void setVolume(Integer[] volume) {
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
    public StockSeries(String name, String[] x, Integer[] high, Integer[] low, Integer[] close, Integer[] open, Integer[] volume){
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

        for (int i = 0; i <getX().length; i++){
            JsonObject xy = new JsonObject();
            xy.addProperty("x",getX()[i]);
            xy.addProperty("y",getY()[i]);

            xy.addProperty("high",getHigh()[i]);
            xy.addProperty("low",getLow()[i]);
            xy.addProperty("close",getClose()[i]);

            if (getVolume()!=null){
                xy.addProperty("volume",getVolume()[i]);
            }
            if (getOpen()!=null){
                xy.addProperty("open",getOpen()[i]);
            }
        }
        if (getName()!=null){
            json.addProperty("name",getName());
        }
        return json;
    }
}
