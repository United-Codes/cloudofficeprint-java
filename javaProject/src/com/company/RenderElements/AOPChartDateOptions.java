package com.company.RenderElements;

import com.google.gson.JsonObject;

/**
 * Date options for an AOPChart (different from ChartDateOptions for the other Charts).
 */
public class AOPChartDateOptions {

    private String format;
    private String unit;
    private Integer step;

    /**
     * @return Date format e.g. : unix.
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format Date format e.g. : unix.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @return The unit to be used for spacing the axis values e.g. : months.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit The unit to be used for spacing the axis values e.g. : months.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return How many units should be used for spacing the axis values (automatic if undefined).
     *         This option is not supported in LibreOffice.
     */
    public Integer getStep() {
        return step;
    }

    /**
     * @param step How many units should be used for spacing the axis values (automatic if undefined).
     *             This option is not supported in LibreOffice.
     */
    public void setStep(Integer step) {
        this.step = step;
    }

    /**
     * This object represents the date options for a chart.
     * @param format Date format e.g. : unix.
     * @param unit The unit to be used for spacing the axis values e.g. : months.
     * @param step How many units should be used for spacing the axis values (automatic if undefined). This option is not supported in LibreOffice.
     */
    public AOPChartDateOptions(String format, String unit, Integer step){
        setFormat(format);
        setUnit(unit);
        setStep(step);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getFormat()!= null){
            json.addProperty("format",getFormat());
        }
        if (getUnit()!= null){
            json.addProperty("unit",getUnit());
        }
        if (getStep()!= null){
            json.addProperty("step",getStep());
        }
        return json;
    }
}
