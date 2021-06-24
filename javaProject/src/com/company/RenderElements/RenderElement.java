package com.company.RenderElements;


import com.google.gson.JsonObject;

import java.util.Set;


/**
 * Abstract class for renderElements. RenderElements will replace their corresponding tag based on their name in the template(s).
 */
public abstract class RenderElement {

    private String name;
    private String value;

    /**
     * @return Name of this element.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name of this element.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Value of this property.
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
     * @return JSONObject with the tags for this element for the AOP server.
     */
    abstract public JsonObject getJSON();

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    abstract public Set<String> getTemplateTags();
}
