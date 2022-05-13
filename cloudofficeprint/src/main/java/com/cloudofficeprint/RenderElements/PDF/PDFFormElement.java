package com.cloudofficeprint.RenderElements.PDF;

import com.cloudofficeprint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract super class for PDF form elements.
 */
public abstract class PDFFormElement extends RenderElement {

    private Integer width;
    private Integer height;

    /**
     * @return the type of this PDF form element.
     */
    public abstract String getType();

    /**
     * @return width of this PDF form element.
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width of this PDF form element
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return height of this PDF form element.
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height of this PDF form element
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @param name of this element.
     */
    public PDFFormElement(String name) {
        setName(name);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON(){
        JsonObject innerJson = new JsonObject();

        innerJson.addProperty("name", getName());
        innerJson.addProperty("type", getType());

        if (getWidth() != null){
            innerJson.addProperty("width", getWidth());
        }
        if (getHeight() != null){
            innerJson.addProperty("height", getHeight());
        }

        JsonObject json = new JsonObject();
        json.add(getName(), innerJson);
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags(){
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{?form " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
