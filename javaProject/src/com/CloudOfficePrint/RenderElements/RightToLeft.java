package com.CloudOfficePrint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Word templates, might work in other templates but behaviour is not predictable.
 * When substituting the content in a language written in right to left, like Arabic, this class can be used
 * to properly format the language. If the substituting content does not contain any right to left language character,
 * then it will behave as a regular substitution tag.
 */
public class RightToLeft extends  RenderElement{

    /**
     * When substituting the content in a language written in right to left, like Arabic, this object can be used
     * to properly format the language. If the substituting content does not contain any right to left language character,
     * then it will behave as a regular substitution tag.
     * @param name Name of this element for the tag.
     * @param value Value to replace the tag with.
     */
    public RightToLeft(String name, String value){
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
        hash_Set.add("{<"+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
