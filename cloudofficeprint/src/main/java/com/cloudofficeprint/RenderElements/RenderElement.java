package com.cloudofficeprint.RenderElements;

import com.google.gson.JsonObject;

import java.util.Set;

/**
 * Abstract class for renderElements. RenderElements will replace their
 * corresponding tag based on their name in the template(s).
 */
public abstract class RenderElement {

    private String name;

    /**
     * @return Name of this element for the tag.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name of this element for the tag.
     */
    public void setName(String name) {
        this.name = name;
    }

    public RenderElement(){}

    /**
     * @param name Name of this element for the tag.
     */
    public RenderElement(String name){
        setName(name);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    abstract public JsonObject getJSON();

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    abstract public Set<String> getTemplateTags();
}
