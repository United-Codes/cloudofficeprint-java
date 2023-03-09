package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 *  This tag is used to append the content of docx file to the template by using {?embed fileToEmbed}.
 *     This is only supported in docx, and we can only embed docx file.
 *     The content of document are not rendered.
 */
public class Embed extends RenderElement{
    /**
     * In docx, it is possible to copy the content of one docx file to another.
     * @param name The name of the tag.
     * @param value The docx file to embed. File source could beW base64 encoded, ftp, sftp or url.
     */
    public Embed(String name, String value){
        setName(name);
        setValue(value);
    }
    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     * server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     * can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{?embed " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
