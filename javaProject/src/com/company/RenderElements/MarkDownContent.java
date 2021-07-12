package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Word. Represents an MarkDown content to insert in a template.
 */
public class MarkDownContent extends  RenderElement{

    /**
     * Represents an object that indicates to put a break in the template or not.
     * @param name Name of this Markdown content for the tag.
     * @param value The Markdown content
     */
    public MarkDownContent(String name, String value){
        setName(name);
        setValue(String.valueOf(value));
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
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
        hash_Set.add("{_"+getName()+"_}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
