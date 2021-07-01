package com.company.RenderElements.PDF;

import com.company.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Group of different PDF texts as one RenderElement. There can only be one PDFTexts element in the JSON for AOP.
 */
public class PDFTexts extends RenderElement {

    private PDFText[] texts;

    /**
     * @return The texts to add to the PDF.
     */
    public PDFText[] getTexts() {
        return texts;
    }

    /**
     * @param texts The texts to add to the PDF.
     */
    public void setTexts(PDFText[] texts) {
        this.texts = texts;
    }

    /**
     * @param texts Group of different PDF texts as one RenderElement. There can only be one PDFTexts element in the JSON for AOP.
     */
    PDFTexts(PDFText[] texts){
        setName("AOP_PDF_TEXTS");
        setTexts(texts);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        for (PDFText text : getTexts()){
            JsonArray array = new JsonArray();
            array.add(text.getJson());
            json.add(text.getPageNumber().toString(),array);
        }
        json.addProperty(getName(),getValue());
        return json;
    }

    /**
     * @return  An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        return ImmutableSet.copyOf(hash_Set);
    }
}
