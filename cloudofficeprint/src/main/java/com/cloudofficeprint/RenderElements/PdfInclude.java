package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Inside Word, PowerPoint, and Excel documents, the tag {?include name} can be used to
 * include documents like Word, Excel, PowerPoint, and PDFs.
 */
public class PdfInclude extends RenderElement {

    /**
     * Constructor for PdfInclude.
     *
     * @param name  The name of the include tag.
     * @param value Base64 encoded document to be included in the output (docx, pptx, pdf).
     */
    public PdfInclude(String name, String value) {
        setName(name);
        setValue(value);
    }

    /**
     * @return A JSON object with the tag and associated value for the Cloud Office Print server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        return json;
    }

    /**
     * Returns the template tags this element replaces.
     * For example: {?include myFile}
     *
     * @return A set of supported template tags.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<>();
        hash_Set.add("{?include " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
