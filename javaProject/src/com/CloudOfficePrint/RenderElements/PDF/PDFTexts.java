package com.CloudOfficePrint.RenderElements.PDF;

import com.CloudOfficePrint.RenderElements.RenderElement;
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
    public PDFTexts(PDFText[] texts){
        setTexts(texts);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonObject result = new JsonObject();
        for (PDFText text : getTexts()){

            if (text.getPageNumber() == -1){
                JsonArray array = new JsonArray();
                array.add(text.getJson());
                result.add("all",array);
            }
            else if (result.get(text.getPageNumber().toString())!=null){
                JsonArray array = (JsonArray) result.get(text.getPageNumber().toString());
                array.add(text.getJson());
                //result.add(text.getPageNumber().toString(),array);
            }
            else {
                JsonArray array = new JsonArray();
                array.add(text.getJson());
                result.add(text.getPageNumber().toString(),array);
            }
        }
        JsonArray array = new JsonArray();
        array.add(result);
        json.add("AOP_PDF_TEXTS", array);
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
