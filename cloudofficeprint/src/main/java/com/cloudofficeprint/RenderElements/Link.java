package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * The class for the link/target tags. This tags allows you to place a link to a
 * target in the same document. If the uid is not provided, a new uid will be
 * generated uniquely for every link and target pair.
 */
public class Link extends RenderElement {

    String uidName;
    String uidValue;

    /**
     * Create a new link/target tag pair.
     * 
     * @param name  the name of the link/target tags.
     * @param value the value of the link/target tags.
     */
    public Link(String name, String value) {
        setName(name);
        setValue(String.valueOf(value));
    }

    /**
     * Create a new link/target tag pair.
     * 
     * @param name     the name of the link/target tags.
     * @param value    the value of the link/target tags.
     * @param uidName  the name of the uid of the link/target pair.
     * @param uidValue the value of the uid of the link/target pair.
     */
    public Link(String name, String value, String uidName, String uidValue) {
        setName(name);
        setValue(String.valueOf(value));
        setUidName(uidName);
        setUidValue(uidValue);
    }

    /**
     * @return name of the link/target tags.
     */
    public String getUidName() {
        return uidName;
    }

    /**
     * @param uidName name of the link/target tags.
     */
    public void setUidName(String uidName) {
        this.uidName = uidName;
    }

    /**
     * @return the value of the uid of the link/target tags.
     */
    public String getUidValue() {
        return uidValue;
    }

    /**
     * @param uidValue the value of the uid of the link/target tags.
     */
    public void setUidValue(String uidValue) {
        this.uidValue = uidValue;
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        if (this.uidName != null && this.uidValue != null)
            json.addProperty(getUidName(), getUidValue());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        if (this.uidName != null && this.uidValue != null) {
            hash_Set.add("{link " + getName() + ":" + getUidName() + "}");
            hash_Set.add("{target " + getName() + ":" + getUidName() + "}");
        } else {
            hash_Set.add("{link " + getName() + "}");
            hash_Set.add("{target " + getName() + "}");
        }
        return ImmutableSet.copyOf(hash_Set);
    }

}
