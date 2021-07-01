package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.*;

/**
 * List of properties' name and value.
 * In a template the tags '{name}' will be replaced by 'value'.
 */
public class PropertyList extends RenderElement{

    Property[] properties;

    /**
     * @return Array of properties.
     */
    public Property[] getProperties() {
        return properties;
    }

    /**
     * @param properties Array of properties.
     */
    public void setProperties(Property[] properties) {
        this.properties = properties;
    }

    /**
     * List of properties' name and value.
     * In a template the tags '{name}' will be replaced by 'value'.
     * @param properties Mapping of names to values of the different properties.
     */
    public PropertyList(Hashtable<String,String> properties){
        setFromDict(properties);
    }

    /**
     * List of properties' name and value.
     * In a template the tags '{name}' will be replaced by 'value'.
     * @param properties Array of properties.
     */
    public PropertyList(Property[] properties){
        setProperties(properties);
    }


    /**
     * Sets the list of properties from a mapping.
     * @param properties Hashtable of (propertyName,propertyValue).
     */
    public void setFromDict(Hashtable<String,String> properties){
        ArrayList<Property> propertyList = new ArrayList<Property>();
        for (Map.Entry<String,String> entry : properties.entrySet()){
            Property property = new Property(entry.getKey(),entry.getValue());
            propertyList.add(property);
        }
        setProperties( propertyList.toArray(new Property[0]));
    }

    /**
     * @return JSONObject with the tags for this property for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        for (Property property : getProperties()){
            json.addProperty(property.getName(),property.getValue());
        }
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{"+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
