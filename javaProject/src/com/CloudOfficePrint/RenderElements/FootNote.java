package com.CloudOfficePrint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Word and Excel templates.
 * Element to insert a footnote in a template.
 */
public class FootNote extends RenderElement{

    /**
     * Element to insert a footnote in a template.
     * @param name Name of this footnote for the tag.
     * @param value Value to replace the tag with.
     */
    public FootNote(String name, String value){
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
        hash_Set.add("{+"+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
