package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Word and Excel. Represents an object that indicates to put
 * a break in the template or not.
 */
public class PageBreak extends RenderElement {

    /**
     * Represents an object that indicates to put a break in the template or not.
     * 
     * @param name  Name of this break for the tag.
     * @param value Value should be set to 'page' or 'pagebreak' for PageBreak,
     *              'column' or 'columnbreak' for column breaks, if set to true it
     *              will create a pagebreak.
     */
    public PageBreak(String name, String value) {
        setName(name);
        setValue(String.valueOf(value));
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{?" + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
