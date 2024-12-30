package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Inside PowerPoint, the tag {name?} can be used
 * to remove an entire shape if the associated tag evaluates to false.
 For example, if a template slide includes a text box with the tag {toShow?}
 and the value of toShow is false or undefined, the entire shape will be removed from the slide.
 */
public class Distribute extends RenderElement {
    /**
     * @param name  The name of slide to hide.
     * @param value (String): 'true' (to hide) or 'false'
     *
     */
    public Distribute(String name, String value) {
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
        if (Objects.equals(getValue(), "null")) {
            json.add(getName() + "_distribute", null);
        } else if (Objects.equals(getValue(), "false")) {
            json.addProperty(getName() + "_distribute", false);
        } else if (Objects.equals(getValue(), "true")) {
            json.addProperty(getName()+ "_distribute", true);
        } else {
            json.addProperty(getName() + "_distribute", getValue());
        }
        return json;
    }

    @Override
    public Set<String> getTemplateTags() {
        return Set.of();
    }

}
