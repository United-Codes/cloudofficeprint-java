package com.company.Resources;

import org.json.JSONObject;

//Maybe this need to be an interface?
public class Resource {
    /**
     * Should not be called.
     * @return
     */
    public JSONObject getJSON() {
        return new JSONObject();
    }
}
