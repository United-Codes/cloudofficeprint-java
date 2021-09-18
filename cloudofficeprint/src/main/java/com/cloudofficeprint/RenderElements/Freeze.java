package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Excel. Represents an object that indicates to put a freeze
 * pane in the excel template.
 */
public class Freeze extends RenderElement {

    /**
     * Represents an object that indicates to put a freeze pane in the excel
     * template.
     * 
     * @param name  Name of this property.
     * @param value Three options are available. First option, place the pane where
     *              the tag is located, using a value of **true**. Second option,
     *              provide the location to place the pane, e.g. **"C5"**, in the
     *              format of excel cell and row. Third option, dont place a pane,
     *              using a value of **false**.
     */
    public Freeze(String name, String value) {
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
        hash_Set.add("{freeze " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }

}
