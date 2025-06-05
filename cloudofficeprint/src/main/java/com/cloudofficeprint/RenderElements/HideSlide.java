package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * HideSlide allows conditional hiding of PowerPoint slides based on a specified condition.
 * It can be used to dynamically show/hide slides in a presentation using tags.
 */
public class HideSlide extends RenderElement {
    /**
     * Creates a new HideSlide element.
     *
     * @param name      The identifier of the slide to hide
     * @param condition String expression that determines when to hide the slide.
     */
    public HideSlide(String name, String condition) {
        setName(name);
        setCondition(condition);
    }

    /**
     * @return JsonObject containing the hide condition.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (Objects.equals(getCondition(), "null")) {
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