package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A collection used to group multiple RenderElements together.
 * It can contain nested `Object`s and should be used to pass multiple `RenderElements` as PrintJob data, as well as to allow for
 * nested elements. Its name is used as a key name when nested, but ignored for all purposes when it's the outer object.
 */
public class ElementCollection extends RenderElement{

    private ArrayList<RenderElement> elements = new ArrayList<RenderElement>();

    /**
     * @return List of nested RenderElements.
     */
    public ArrayList<RenderElement> getElements() {
        return elements;
    }

    /**
     * @param elements List of nested RenderElements.
     */
    public void setElements(ArrayList<RenderElement> elements) {
        this.elements = elements;
    }

    /**
     * @param element Element to add to the list of elements.
     */
    public void addElement(RenderElement element){
        elements.add(element);
    }

    /**
     * @param element Element to remove from the list of elements.
     */
    public void removeElement(RenderElement element){
        elements.remove(element);
    }

    /**
     * A collection used to group multiple RenderElements together.
     * @param name The name is used as a key name when the collection is nested,
     *             but ignored when it's the outer object.
     * @param elements List of nested RenderElements.
     */
    public ElementCollection(String name, ArrayList<RenderElement> elements){
        setName(name);
        setElements(elements);
    }


    /**
     * @return Jsonarray of all the elements.
     */
    public JsonArray getJsonArray(){
        JsonArray array = new JsonArray();
        for( RenderElement element : getElements() ) {
            if (element instanceof ElementCollection){
                JsonObject el = element.getJSON();
                el.add(element.getName(),element.getJSON());
                array.add(el);
            }
            else array.add(element.getJSON());
        }
        return array;
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.add(getName(),getJsonArray());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        for( RenderElement entry : getElements() ) {
            hash_Set.add(entry.getTemplateTags().toString());
        }
        return ImmutableSet.copyOf(hash_Set);
    }
}
