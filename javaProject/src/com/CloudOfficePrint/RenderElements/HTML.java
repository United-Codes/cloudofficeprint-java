package com.CloudOfficePrint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Word, Excel, HTML and Md templates. HTML text can be
 * rendered and put in templates.
 */
public class HTML extends RenderElement {

    /**
     * HTML text can be rendered and put in templates.
     * 
     * @param name     Name of this html element for the tag.
     * @param HTMLText HTML text.
     */
    public HTML(String name, String HTMLText) {
        setName(name);
        setValue(String.valueOf(HTMLText));
    }

    /**
     * @return JSONObject with the tags for this HTML element for the Cloud Office
     *         Print server.
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
        hash_Set.add("{_" + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
