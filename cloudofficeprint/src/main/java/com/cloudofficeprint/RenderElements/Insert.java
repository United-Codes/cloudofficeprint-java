package com.cloudofficeprint.RenderElements;

import com.cloudofficeprint.Resources.Resource;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Inside Word and PowerPoint documents, the tag {?insert fileToInsert} can be used to
 * insert files like Word, Excel, PowerPoint and PDF documents.
 */
public class Insert extends Property {
    /**
     * @param name  the name of insert tag
     * @param value base64 encoded file(docx, pptx, xlsx, pdf etc) to be added in output file.
     */
    public Insert(String name, String value) {
        super(name, value);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     * server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue().toString());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     * can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<>();
        hash_Set.add("?insert " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
