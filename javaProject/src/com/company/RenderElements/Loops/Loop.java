package com.company.RenderElements.Loops;

import com.company.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents elements to be included in loops in templates.
 */
public class Loop extends RenderElement {

    RenderElement[] elements;

    /**
     * @return All the elements of the loop.
     */
    public RenderElement[] getElements() {
        return elements;
    }

    /**
     * @param elements All the elements of the loop.
     */
    public void setElements(RenderElement[] elements) {
        this.elements = elements;
    }

    /**
     * Loop elements for a template.
     * @param name  Name of this loop for the tag.
     * @param elements Elements to replace the tag with.
     */
    public Loop(String name, RenderElement[] elements) {
        setName(name);
        setElements(elements);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonArray array = new JsonArray();
        for (RenderElement element : getElements()){
            array.add(element.getJSON());
        }
        json.add(getName(), array);
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{#" + getName() + "}");
        hash_Set.add("{/" + getName() + "}");
        for (RenderElement element : getElements()){
            for (String tag : getTemplateTags())
            hash_Set.add(tag);
        }
        return ImmutableSet.copyOf(hash_Set);
    }
}