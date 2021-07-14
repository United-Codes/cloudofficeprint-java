package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.*;

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
     * @param elementName Name of the element to remove from the list of elements.
     */
    public void removeElementByName(String elementName){
        for (RenderElement element : getElements()){
            if (element.getName() == elementName){
                getElements().remove(element);
            }
        }
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
     * A collection used to group multiple RenderElements together.
     * The arrayList of elements isn't initialised in this constructor so setFromDict should be called.
     * @param name The name is used as a key name when the collection is nested,
     *             but ignored when it's the outer object.
     */
    public ElementCollection(String name){
        setName(name);
        setElements(elements);
    }

    /**
     * Adds the list of properties from a mapping.
     * @param properties Hashtable of (propertyName,propertyValue).
     */
    public void addFromDict(Hashtable<String,String> properties){
        for (Map.Entry<String,String> entry : properties.entrySet()){
            Property property = new Property(entry.getKey(),entry.getValue());
            getElements().add(property);
        }
    }

    /**
     * Parses a JsonArray to an elementcollection.
     * @param name Name of the elementcollection.
     * @param json Json to parse.
     * @return Elementcollection of the parsed json.
     */
    public static ElementCollection makeCollectionFromJson(String name,JsonObject json){
        ElementCollection col = new ElementCollection(name);
        for (Map.Entry entry : json.entrySet()){
            if (entry.getValue().toString().startsWith("{\"")){
                JsonObject value = (JsonObject) entry.getValue();
                col.addElement(makeCollectionFromJson(entry.getKey().toString(),value));
            }
            else if (entry.getValue().toString().startsWith("[{\"")){
                JsonArray array = (JsonArray) entry.getValue();
                for (JsonElement element : array){
                    col.addElement(makeCollectionFromJson(entry.getKey().toString(), (JsonObject) element));
                }
            }
            else if (entry.getValue().toString().startsWith("[\"")){
                JsonArray array = (JsonArray) entry.getValue();
                col.addElement(new RawJsonArray(entry.getKey().toString(),array));
            }
            else {
                //System.out.println(entry.getValue().toString());
                //System.out.println(entry.getValue().toString().equals("null"));
                if (entry.getValue().toString().equals("\"null\"")){
                    Property property = new Property(entry.getKey().toString(),null);
                    col.addElement(property);
                }
                /*else if (entry.getValue().toString().equals("null")){
                    Property property = new Property(entry.getKey().toString(),null);
                    col.addElement(property);
                }*/
                else {
                    Property property = new Property(entry.getKey().toString(),entry.getValue().toString().replace("\"",""));
                    col.addElement(property);
                }
            }
        }
        return col;
    }

    /**
     * Adds all the elements from the elementcollection to the elements of this collection.
     * @param collection Elementcollection.
     */
    public void addAllRenderElements( ElementCollection collection){
        for (RenderElement element: collection.getElements()){
            getElements().add(element);
        }
    }

    /**
     * @param json1 Json to add the data from json2 to.
     * @param json2 Json to take the data from. Cannot have nested JSON's/JsonArrays.
     */
    public static void updateJson1WithJson2(JsonObject json1, JsonObject json2 ){
        for (Map.Entry entry : json2.entrySet()){
                json1.addProperty(entry.getKey().toString(),entry.getValue().toString().replace("\"",""));
        }
    }


    /**
     * @return JSONObject with the tags for this property for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        for( RenderElement element : getElements() ) {
            if (element instanceof RawJsonArray){
                json.add(element.getName(),((RawJsonArray) element).getJsonArray());
            }
            else if (element instanceof ElementCollection){
                json.add(element.getName(),element.getJSON());
            }
            else {
                for (Map.Entry<String,JsonElement> entry : element.getJSON().entrySet()){
                    json.add(entry.getKey(),entry.getValue());
                }
            }
        }
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
