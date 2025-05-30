package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * HideSheet allows conditional hiding of sheets based on a specified condition.
 * It can be used to dynamically show/hide sheets in a presentation using tags.
 */
public class HideSheet extends RenderElement {
    /**
     * Creates a new HideSheet element.
     *
     * @param name      The identifier of the sheet to hide
     * @param condition String expression that determines when to hide the sheet.
     */
    public HideSheet(String name, String condition) {
        setName(name);
        setCondition(condition);
    }

    /**
     * @return JsonObject containing the hide condition.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getCondition() == null) {
            json.add(getName(), null);
        } else {
            json.addProperty(getName(), getCondition());
        }
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     * can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<>();
        hash_Set.add("{hide " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}