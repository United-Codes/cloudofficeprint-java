package com.cloudofficeprint.RenderElements.PDF;

import com.cloudofficeprint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Group of different PDF images as one RenderElement. There can only be one
 * PDFImages element in the JSON for Cloud Office Print.
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
     * @param images Group of different PDF images as one RenderElement. There can
     *               only be one PDFImage element in the JSON for Cloud Office
     *               Print.
     */
    public PDFImages(PDFImage[] images) {
        super("AOP_PDF_IMAGES");
        setImages(images);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonObject result = new JsonObject();
        for (PDFImage image : getImages()) {
            if (image.getPageNumber() == -1) {
                JsonArray array = new JsonArray();
                array.add(image.getJson());
                result.add("all", array);
            } else if (result.get(image.getPageNumber().toString()) != null) {
                JsonArray array = (JsonArray) result.get(image.getPageNumber().toString());
                array.add(image.getJson());
                // result.add(text.getPageNumber().toString(),array);
            } else {
                JsonArray array = new JsonArray();
                array.add(image.getJson());
                result.add(image.getPageNumber().toString(), array);
            }
        }
        JsonArray array = new JsonArray();
        array.add(result);
        json.add("AOP_PDF_IMAGES", array);
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        return ImmutableSet.copyOf(hash_Set);
    }
}
