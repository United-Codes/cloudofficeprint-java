package com.CloudOfficePrint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * With Word/Excel/PowerPoint documents, it's possible to let AOP execute some JavaScript code to generate a D3 image (Data Driven Documents).
 */
public class D3Code extends RenderElement{

    private String data;

    /**
     * @return Global data the code has access to. You can access it in the JS code through with global.data or just data.
     */
    public String getData() {
        return data;
    }

    /**
     * @param data Global data the code has access to. You can access it in the JS code through with global.data or just data.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Represents an D3 image.
     * @param name Name of the D3 for the tag.
     * @param code Code to generate the image.
     * @param data Global data the code has access to. Optional : use null if you don't want to specify it.
     */
    public D3Code(String name, String code, String data){
        setName(name);
        setValue(code);
        setData(data);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(),getValue());
        json.addProperty(getName()+"_data",getData());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{$d3 "+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
