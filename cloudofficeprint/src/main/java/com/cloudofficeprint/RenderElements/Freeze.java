package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;


/**
 * This tag will allow you to utilize freeze pane property of the Excel.Three options are available.
 * First option, we can directly place the pane where the tag located. For this option we should provide true parameter.
 * Second option, we can provide the location where we want to place the pane such as "C5".
 * Finally, the third option is false which doesn't place a pane.
 */
public class Freeze extends RenderElement{
    /**
     * This tag will allow you to use freeze pane property of Excel.
     * @param name {string} tag name of freeze element
     * @param value {string} freezeValue .
     */
    public Freeze(String name, String value){
        setName(name);
        setValue(value);
    };

    /**
     * This tag will allow you to use freeze pane property of Excel.
     * @param name {string} tag name of freeze element
     * @param value {boolean} freeze value.
     */
    public Freeze(String name, boolean value){
        setName(name);
        setBooleanValue(value);
    };

    private boolean freezeValue;

    /**
     *
     * @return freezeValue value for the freeze element tag.
     */
    public boolean getBooleanValue(){
        return freezeValue;
    }

    /**
     *
     * @param freezeValue value for the freeze element.
     */
    public void setBooleanValue(boolean freezeValue){
        this.freezeValue = freezeValue;
    }
    /**
     * @return JSONObject with the tags for this property for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        if (getBooleanValue()){
            json.addProperty(getName(),getBooleanValue());
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
        hash_Set.add("freeze " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
