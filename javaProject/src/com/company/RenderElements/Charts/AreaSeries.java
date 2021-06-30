package com.company.RenderElements.Charts;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Iterator;

/**
 * This class represents an area chart.
 */
public class AreaSeries extends XYSeries{

    private String color;
    private Float opacity;

    /**
     * Note: Decimal value between 0 and 1. It will only work when a color is manually specified, otherwise it is silently ignored.
     * The opacity can also be set by using a scheme for the color option which includes an alpha value in the color field
     * (rgba, hsla and hwba are supported). The opacity field is also ignored in that case.
     * @return Opacity of the chart.
     */
    public Float getOpacity() {
        return opacity;
    }

    /**
     * Note: Decimal value between 0 and 1. It will only work when a color is manually specified, otherwise it is silently ignored.
     * The opacity can also be set by using a scheme for the color option which includes an alpha value in the color field
     * (rgba, hsla and hwba are supported). The opacity field is also ignored in that case.
     * @param opacity Opacity of the chart.
     */
    public void setOpacity(Float opacity) {
        this.opacity = opacity;
    }

    /**
     * @return Chart color in CSS format.
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color Chart color in CSS format.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * This object represents a pie chart.
     * @param name Name of the chart.
     * @param x X-data of the chart.
     * @param y Y-data of the chart.
     * @param color Color of the chart.
     * @param opacity Opacity of the chart. Note: Decimal value between 0 and 1. It will only work when a color is manually specified,
     *                otherwise it is silently ignored. The opacity can also be set by using a scheme for the color option which
     *                includes an alpha value in the color field (rgba, hsla and hwba are supported). The opacity field is also
     *                ignored in that case.
     */
    public AreaSeries(String name, JsonArray x, JsonArray y, String color, Float opacity){
        setName(name);
        setX(x);
        setY(y);
        setColor(color);
        setOpacity(opacity);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.add("data", getJSONData());
        if (getName()!=null){
            json.addProperty("name",getName());
        }
        if (getColor()!=null){
            json.addProperty("color",getColor());
        }
        if (getOpacity()!=null){
            json.addProperty("opacity",getOpacity());
        }
        return json;
    }
}
