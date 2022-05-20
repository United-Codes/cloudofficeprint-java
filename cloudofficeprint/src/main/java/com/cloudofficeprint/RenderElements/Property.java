package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * The most basic RenderElement. It simply consists of a name and a value. In a
 * template the tag '{name}' will be replaced by 'value'.
 */
public class Property extends RenderElement {

    private String value;

    /**
     * @return Value of this element.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value Value of this property.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * The most basic RenderElement. It simply consists of a name and a value. In a
     * template the tag '{name}' will be replaced by 'value'.
     *
     * @param name  Name of this property for the tag.
     * @param value Value of this element to replace the tag with.
     */
    public Property(String name, String value) {
        super(name);
        setValue(String.valueOf(value));
    }

    /**
     * The most basic RenderElement. It simply consists of a name and a value. In a
     * template the tag '{name}' will be replaced by 'value'.
     *
     * @param name  Name of this property for the tag.
     * @param value Value of this property to replace the tag with.
     */
    public Property(String name, int value) {
        super(name);
        setValue(String.valueOf(value));
    }

    /**
     * @return JSONObject with the tags for this property for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        // System.out.println(getValue());
        // System.out.println(getValue()!=null);
        if (getValue() != null) {
            if (getValue().equals("false")) {
                json.addProperty(getName(), false);
            } else if (getValue().equals("true")) {
                json.addProperty(getName(), true);
            } else {
                json.addProperty(getName(), getValue());
            }
        } else {
            json.add(getName(), null);
        }
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{" + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
