package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Excel.
 * This class represents an Excel formula.
 * Note that no validation is performed on this formula.
 */
public class Formula extends RenderElement{

    /**
     * Represents an Excel formula.
     * Note that no validation is performed on this formula.
     * @param name Name of the formula for the tag.
     * @param formula Excel formula to replace the tag with.
     */
    public Formula(String name, String formula){
        setName(name);
        setValue(formula);
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
        hash_Set.add("{>"+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
