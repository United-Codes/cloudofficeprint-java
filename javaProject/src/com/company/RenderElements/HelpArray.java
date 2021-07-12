package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;


public class HelpArray extends RenderElement{

    JsonArray jsonArray =new JsonArray();

    public JsonArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JsonArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    /**
     * Element to insert a footnote in a template.
     * @param name Name for the tag.
     * @param array JsonArray containing the data.
     */
    public HelpArray(String name, JsonArray array){
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
