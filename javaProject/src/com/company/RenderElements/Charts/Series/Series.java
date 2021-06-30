package com.company.RenderElements.Charts.Series;

import com.google.gson.JsonObject;


public abstract class Series {
    private String name;
    private String data;

    /**
     * @return Name of the serie.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name of the serie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Data of the serie.
     */
    public String getData() {
        return data;
    }

    /**
     * @param data Data of the serie.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("data",getData());
        if (getName()!=null){
            json.addProperty("name",getName());
        }
        return json;
    }
}
