package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Used to remove a PowerPoint shape if the tag value is "false" or not defined.
 * Tag format in template: {tagName?}
 */
public class PptxShapeRemove extends RenderElement {
    /**
     * @param name  the name of insert tag
     * @param value (string): 'false' (to remove the shape / text-box) or any other string.
     */
    public PptxShapeRemove(String name, String value) {
        setName(name);
        setValue(value);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     * server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
            if (Objects.equals(getValue(), "null")) {
                json.add(getName(), null);
            } else if (Objects.equals(getValue(), "false")) {
                json.addProperty(getName(), false);
            } else {
                json.addProperty(getName(), getValue());
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
        hash_Set.add("{ " + getName() + "?" + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
