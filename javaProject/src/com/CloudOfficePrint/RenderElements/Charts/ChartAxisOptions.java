package com.CloudOfficePrint.RenderElements.Charts;

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
    private String formatCode;

    /**
     * @return Orientation of the axis : minMax or maxMin.
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * @param orientation  Orientation of the axis : minMax or maxMin.
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    /**
     * @return Minimum of the axis.
     */
    public Float getMin() {
        return min;
    }

    /**
     * @param min Minimum of the axis.
     */
    public void setMin(Float min) {
        this.min = min;
    }

    /**
     * @return Maximum of the axis.
     */
    public Float getMax() {
        return max;
    }

    /**
     * @param max Maximum of the axis.
     */
    public void setMax(Float max) {
        this.max = max;
    }

    /**
     * @return Date options, only for stock charts.
     */
    public ChartDateOptions getDate() {
        return date;
    }

    /**
     * @param date Date options, only for stock charts.
     */
    public void setDateOptions(ChartDateOptions date) {
        this.date = date;
    }

    /**
     * @return Tittle of the axis.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title Tittle of the axis.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Whether to show or not the values of the axis.
     */
    public Boolean getValues() {
        return values;
    }

    /**
     * @param values Whether to show or not the values of the axis.
     */
    public void setValues(Boolean values) {
        this.values = values;
    }

    /**
     * @return Axis value styles.
     */
    public ChartTextStyle getValuesStyle() {
        return valuesStyle;
    }

    /**
     * @param valuesStyle Axis value styles.
     */
    public void setValuesStyle(ChartTextStyle valuesStyle) {
        this.valuesStyle = valuesStyle;
    }

    /**
     * @return Style options of the title.
     */
    public ChartTextStyle getTitleStyle() {
        return titleStyle;
    }

    /**
     * @param titleStyle Style options of the title.
     */
    public void setTitleStyle(ChartTextStyle titleStyle) {
        this.titleStyle = titleStyle;
    }

    /**
     * @return Title rotation in degrees, clockwise from horizontal axis.
     */
    public Integer getTitleRotation() {
        return titleRotation;
    }

    /**
     * @param titleRotation Title rotation in degrees, clockwise from horizontal axis.
     */
    public void setTitleRotation(Integer titleRotation) {
        this.titleRotation = titleRotation;
    }

    /**
     * @return Whether to show major grid lines or not.
     */
    public Boolean getMajorGridLines() {
        return majorGridLines;
    }

    /**
     * @param majorGridLines Whether to show major grid lines or not.
     */
    public void setMajorGridLines(Boolean majorGridLines) {
        this.majorGridLines = majorGridLines;
    }

    /**
     * @return Automatic when undefined, spacing between major grid lines and axis values.
     */
    public Float getMajorUnit() {
        return majorUnit;
    }

    /**
     * @param majorUnit Automatic when undefined, spacing between major grid lines and axis values.
     */
    public void setMajorUnit(Float majorUnit) {
        this.majorUnit = majorUnit;
    }

    /**
     * @return Whether to show minor grid lines or not.
     */
    public Boolean getMinorGridLines() {
        return minorGridLines;
    }

    /**
     * @param minorGridLines  Whether to show minor grid lines or not.
     */
    public void setMinorGridLines(Boolean minorGridLines) {
        this.minorGridLines = minorGridLines;
    }

    /**
     * @return Automatic when undefined, spacing between minor grid lines.
     */
    public Float getMinorUnit() {
        return minorUnit;
    }

    /**
     * @param minorUnit Automatic when undefined, spacing between minor grid lines.
     */
    public void setMinorUnit(Float minorUnit) {
        this.minorUnit = minorUnit;
    }

    /**
     * @return Format code for axis data, "General", "Number" ...
     */
    public String getFormatCode() {
        return formatCode;
    }

    /**
     * @param formatCode Format code for axis data, "General", "Number" ...
     */
    public void setFormatCode(String formatCode) {
        this.formatCode = formatCode;
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
        if (getFormatCode()!= null){
            json.addProperty("formatCode",getFormatCode());
        }
        return json;
    }
}
