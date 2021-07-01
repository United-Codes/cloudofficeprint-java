package com.company.RenderElements.PDF;

import com.company.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Group of different PDF images as one RenderElement. There can only be one PDFImages element in the JSON for AOP.
 */
public class PDFImages extends RenderElement {

    private PDFImage[] images;

    /**
     * @return The images to add to the PDF.
     */
    public PDFImage[] getImages() {
        return images;
    }

    /**
     * @param images The images to add to the PDF.
     */
    public void setImages(PDFImage[] images) {
        this.images = images;
    }

    /**
     * @param images Group of different PDF images as one RenderElement. There can only be one PDFImage element in the JSON for AOP.
     */
    PDFImages(PDFImage[] images){
        setName("AOP_PDF_IMAGES");
        setImages(images);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        for (PDFImage image : getImages()){
            JsonArray array = new JsonArray();
            array.add(image.getJson());
            json.add(image.getPageNumber().toString(),array);
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
