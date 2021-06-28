package com.company.RenderElements.Charts;

import com.google.gson.JsonObject;

public class ChartAxisOptions {


    private String orientation;
    private Float min;
    private Float max;
    private ChartDateOptions date;
    private String title;
    private Boolean values;
    private ChartTextStyle valuesStyle;
    private ChartTextStyle titleStyle;
    private Integer titleRotation;
    private Boolean majorGridLines;
    private Float majorUnit;
    private Boolean minorGridLines;
    private Float minorUnit;

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public ChartDateOptions getDate() {
        return date;
    }

    public void setDate(ChartDateOptions date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getValues() {
        return values;
    }

    public void setValues(Boolean values) {
        this.values = values;
    }

    public ChartTextStyle getValuesStyle() {
        return valuesStyle;
    }

    public void setValuesStyle(ChartTextStyle valuesStyle) {
        this.valuesStyle = valuesStyle;
    }

    public ChartTextStyle getTitleStyle() {
        return titleStyle;
    }

    public void setTitleStyle(ChartTextStyle titleStyle) {
        this.titleStyle = titleStyle;
    }

    public Integer getTitleRotation() {
        return titleRotation;
    }

    public void setTitleRotation(Integer titleRotation) {
        this.titleRotation = titleRotation;
    }

    public Boolean getMajorGridLines() {
        return majorGridLines;
    }

    public void setMajorGridLines(Boolean majorGridLines) {
        this.majorGridLines = majorGridLines;
    }

    public Float getMajorUnit() {
        return majorUnit;
    }

    public void setMajorUnit(Float majorUnit) {
        this.majorUnit = majorUnit;
    }

    public Boolean getMinorGridLines() {
        return minorGridLines;
    }

    public void setMinorGridLines(Boolean minorGridLines) {
        this.minorGridLines = minorGridLines;
    }

    public Float getMinorUnit() {
        return minorUnit;
    }

    public void setMinorUnit(Float minorUnit) {
        this.minorUnit = minorUnit;
    }

    /**
     * Represents the options for an axis of a chart.
     * Options can be populated with the setter functions.
     */
    public ChartAxisOptions(){};

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getOrientation()!= null){
            json.addProperty("orientation",getOrientation());
        }
        if (getMin()!= null){
            json.addProperty("min",getMin());
        }
        if (getMax()!= null){
            json.addProperty("max",getMax());
        }
        if (getDate()!= null){
            json.addProperty("type","date");
            json.add("date",getDate().getJSON());
        }
        if (getTitle()!= null){
            json.addProperty("title",getTitle());
        }
        if (getValues()!= null){
            json.addProperty("showValues",getValues());
        }
        if (getValuesStyle()!= null){
            json.add("valuesStyle",getValuesStyle().getJSON());
        }
        if (getTitleStyle()!= null){
            json.add("titleStyle",getTitleStyle().getJSON());
        }
        if (getTitleRotation()!= null){
            json.addProperty("titleRotation",getTitleRotation());
        }
        if (getMajorGridLines()!= null){
            json.addProperty("majorGridlines",getMajorGridLines());
        }
        if (getMajorUnit()!= null){
            json.addProperty("majorUnit",getMajorUnit());
        }
        if (getMinorGridLines()!= null){
            json.addProperty("minorGridlines",getMinorGridLines());
        }
        if (getMinorUnit()!= null){
            json.addProperty("minorUnit",getMinorUnit());
        }
        return json;
    }
}
