package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;


/**
 * The most basic RenderElement. It simply consists of a name and a value.
 * In a template the tag '{name}' will be replaced by 'value'.
 */
public class Property extends RenderElement{

    /**
     * The most basic RenderElement. It simply consists of a name and a value.
     * In a template the tag '{name}' will be replaced by 'value'.
     * @param name Name of this property for the tag.
     * @param value Value of this element to replace the tag with.
     */
    public Property(String name, String value){
        setName(name);
        //setValue(value.replace("\"",""));
        setValue(value);
    }

    /**
     * The most basic RenderElement. It simply consists of a name and a value.
     * In a template the tag '{name}' will be replaced by 'value'.
     * @param name Name of this property for the tag.
     * @param value Value of this property to replace the tag with.
     */
    public Property(String name, int value){
        setName(name);
        setValue(String.valueOf(value));
    }

    /**
     * @return JSONObject with the tags for this property for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(),getValue());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{"+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
