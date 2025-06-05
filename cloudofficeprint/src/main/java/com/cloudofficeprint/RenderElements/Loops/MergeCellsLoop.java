package com.cloudofficeprint.RenderElements.Loops;

import com.cloudofficeprint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.*;

/**
 * Loop where table cells are vertically merged across rows during looping.
 * Only supported in Word templates with {##...} {/…} syntax.
 */
public class MergeCellsLoop extends Loop {

    /**
     * @param name     Name of this loop for the tag (will use {##name} and {/name}).
     * @param elements Elements to repeat and merge cells over.
     */
    public MergeCellsLoop(String name, ArrayList<RenderElement> elements) {
        super(name, elements);
    }

    /**
     * @param name     Name of this loop for the tag (will use {##name} and {/name}).
     * @param elements Elements to repeat and merge cells over.
     */
    public MergeCellsLoop(String name, RenderElement[] elements) {
        super(name, elements);
    }

    /**
     * @return JSONObject with the array of element-objects under the loop name.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonArray array = new JsonArray();
        for (RenderElement element : getElements()) {
            array.add(element.getJSON());
        }
        json.add(getName(), array);
        return json;
    }

    /**
     * @return An immutable set containing the merge‐cell loop tags
     *         plus all child element tags.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<>();
        hash_Set.add("{##" + getName() + "}");
        hash_Set.add("{/"   + getName() + "}");
        for (RenderElement element : getElements()) {
            for (String tag : element.getTemplateTags()) {
                hash_Set.add(tag);
            }
        }
        return ImmutableSet.copyOf(hash_Set);
    }

}
