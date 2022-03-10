package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing an autoLink for templates.
 */
public class AutoLink extends RenderElement {

    /**
     * Element to insert a footnote in a template.
     *
     * @param name  Name of this footnote for the tag.
     * @param value Value for the autoLink (will replace the tag in the template).
     *              This may or may not have hyperlinks.
     */
    public AutoLink(String name, String value) {
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
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     * can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{*auto " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
