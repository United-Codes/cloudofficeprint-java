package com.CloudOfficePrint.RenderElements;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Set;

/**
 * Represents a raw JsonArray to include in the data.
 */
public class RawJsonArray extends RenderElement {

    JsonArray jsonArray = new JsonArray();

    public JsonArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JsonArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    /**
     * Element to insert a footnote in a template.
     * 
     * @param name  Name for the tag.
     * @param array JsonArray containing the data.
     */
    public RawJsonArray(String name, JsonArray array) {
        setName(name);
        setJsonArray(array);
    }

    /**
     * Don't use.
     */
    @Override
    public JsonObject getJSON() {
        return null;
    }

    /**
     * Don't use.
     */
    @Override
    public Set<String> getTemplateTags() {
        return null;
    }
}
