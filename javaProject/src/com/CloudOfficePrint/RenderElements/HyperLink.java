package com.CloudOfficePrint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a hyperlink for templates.
 */
public class HyperLink extends RenderElement {

    private String url;

    /**
     * Note : In Excel you can hyperlink to a cell. The URLshould then be of
     * structure: "SheetName!Cell".
     * 
     * @return URL to hyperlink to.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Note : In Excel you can hyperlink to a cell. The URLshould then be of
     * structure: "SheetName!Cell".
     * 
     * @param url URL to hyperlink to.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Element to insert a footnote in a template.
     * 
     * @param name Name of this footnote for the tag.
     * @param text Text of the hyperlink (will replace the tag in the template).
     *             (Optional: if null the URL will replace the tag)
     * @param url  URL to hyperlink to. Note : In Excel you can hyperlink to a cell.
     *             The URLshould then be of structure: "SheetName!Cell".
     */
    public HyperLink(String name, String text, String url) {
        setName(name);
        setValue(text);
        setUrl(url);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getUrl());
        if (getValue() != null) { // getValue() gives back the url in this class.
            json.addProperty(getName() + "_text", getValue());
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
        hash_Set.add("{*" + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
