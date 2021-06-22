package com.company.Output.PDFOptions;

import com.google.gson.JsonObject;

public class pageDimension {

    String unit;
    String dimension;

    /**
     * @return unit of the dimension : px, mm, cm or in. Default : null (server will use px).
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit of the dimension : px, mm, cm or in.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return dimension of the page.
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * @param dimension of the page.
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    /**
     * @return JSONObject with the tags for the pageDimension for the AOP server.
     */
    public JsonObject getJSON(){
        JsonObject json = new JsonObject();
        json.addProperty("dimension",getDimension());
        json.addProperty("unit",getUnit());
        return json;
    }
}
