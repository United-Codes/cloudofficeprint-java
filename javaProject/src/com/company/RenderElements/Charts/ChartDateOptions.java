package com.company.RenderElements.Charts;


import com.google.gson.JsonObject;

/**
 * This class represents date options, only applicable for stock charts.
 */
public class ChartDateOptions {
    private String format;
    private String code;
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
     * @return Code format of the date. e.g. : mm/yy
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code Code format of the date. e.g. : mm/yy
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return Unit of the date e.g. : months.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit Unit of the date e.g. : months.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return Unit steps.
     */
    public Integer getStep() {
        return step;
    }

    /**
     * @param step Unit steps.
     */
    public void setStep(Integer step) {
        this.step = step;
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getFormat()!= null){
            json.addProperty("format",getFormat());
        }
        if (getCode()!= null){
            json.addProperty("code",getCode());
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
