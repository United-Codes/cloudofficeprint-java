package com.cloudofficeprint.RenderElements.Form;

import com.cloudofficeprint.RenderElements.RenderElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.util.Set;
import java.util.HashSet;

/**
 * Base class for PDF form elements
 */
public abstract class FormElement extends RenderElement {
    private String type;
    public FormElement(String name, String type) {
        this.setName(name);
        this.type = type;
    }
    public String getType() { return type; }
    protected void setType(String type) { this.type = type; }

    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonArray elements = new JsonArray();
        JsonObject props = new JsonObject();

        props.addProperty("type", getType());
        props.addProperty("name", getName());
        populateProperties(props);

        elements.add(props);
        json.add(getName(), elements);
        return json;
    }

    protected abstract void populateProperties(JsonObject props);

    @Override
    public Set<String> getTemplateTags() {
        Set<String> tags = new HashSet<>();
        tags.add("{?form " + getName() + "}");
        return tags;
    }
}