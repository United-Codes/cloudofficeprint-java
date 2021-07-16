package com.CloudOfficePrint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only available for HTML and Markdown templates.
 * When you use the Property Renderelement in HTML or in MD, it will escape any special characters like "_".
 * By using the Raw Renderelement, nothing will be escaped.
 */
public class Raw extends RenderElement{

    /**
     * @param name Name of this element for the tag.
     * @param value Value of this element to replace the tag with.
     */
    public Raw(String name, String value){
        setName(name);
        setValue(value);
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
        hash_Set.add("{@"+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
