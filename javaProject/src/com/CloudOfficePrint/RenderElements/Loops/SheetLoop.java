package com.CloudOfficePrint.RenderElements.Loops;

import com.CloudOfficePrint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.*;

/**
 * Loop where a sheet will be repeated for each element of the loop. Only
 * supported in Excel templates.
 */
public class SheetLoop extends Loop {

    private ArrayList<String> sheetNames;

    /**
     * @return Arraylist of the names of the repeated sheets.
     */
    public ArrayList<String> getSheetNames() {
        return sheetNames;
    }

    /**
     * @param sheetNames Arraylist of the repeated sheets.
     */
    public void setSheetNames(ArrayList<String> sheetNames) {
        this.sheetNames = sheetNames;
    }

    /**
     * To repeat a sheet for each element of elements.
     * 
     * @param name     Name of this loop for the tag.
     * @param elements Value to replace the tag with.
     */
    public SheetLoop(String name, ArrayList<RenderElement> elements) {
        super(name, elements);
    }

    /**
     * To repeat a sheet for each element of elements.
     * 
     * @param name     Name of this loop for the tag.
     * @param elements Value to replace the tag with.
     */
    public SheetLoop(String name, RenderElement[] elements) {
        super(name, elements);
    }

    /**
     * To repeat a sheet for each element of elements.
     * 
     * @param name     Name of this loop for the tag.
     * @param elements HashMap(name, elements), elements to replace the tag with.
     */
    public SheetLoop(String name, HashMap<String, RenderElement> elements) {
        super(name, new RenderElement[] {});
        ArrayList<RenderElement> elementList = new ArrayList<>();
        for (Map.Entry<String, RenderElement> entry : elements.entrySet()) {
            sheetNames.add(entry.getKey());
            elementList.add(entry.getValue());
        }
        setElements(elementList);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonArray array = new JsonArray();
        int i = 0;
        for (RenderElement element : getElements()) {
            if (getSheetNames() != null) {
                element.getJSON().addProperty("sheetname", getSheetNames().get(i));
            }
            array.add(element.getJSON());
            i++;
        }
        json.add(getName(), array);
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{!" + getName() + "}");
        for (RenderElement element : getElements()) {
            for (String tag : getTemplateTags())
                hash_Set.add(tag);
        }
        return ImmutableSet.copyOf(hash_Set);
    }
}
