package com.cloudofficeprint.RenderElements.PDF;

import com.cloudofficeprint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a group of PDFComment elements to be rendered together.
 * Only one instance of this RenderElement should be added in the Cloud Office Print template.
 */
public class PDFComments extends RenderElement {

    private PDFComment[] comments;

    /**
     * Gets the array of PDFComment objects to be rendered.
     *
     * @return An array of PDFComment objects.
     */
    public PDFComment[] getComments() {
        return comments;
    }

    /**
     * Sets the array of PDFComment objects to be rendered.
     *
     * @param comments The array of PDFComment objects.
     */
    public void setComments(PDFComment[] comments) {
        this.comments = comments;
    }

    /**
     * Constructs a new PDFComments object, containing multiple PDFComment elements.
     *
     * @param comments Array of PDFComment objects to be rendered in the PDF output.
     */
    public PDFComments(PDFComment[] comments) {
        setName("AOP_PDF_COMMENTS");
        setComments(comments);
    }

    /**
     * Converts this PDFComments object into a JSON structure compatible with
     * the Cloud Office Print server.
     * Each comment is grouped by page number. If page number is -1, it's added under the "all" key.
     *
     * @return A JsonObject representing this element.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonObject result = new JsonObject();
        for (PDFComment comment : getComments()) {
            String key = comment.getPageNumber() == -1
                    ? "all"
                    : comment.getPageNumber().toString();
            JsonArray pageArray;
            if (result.has(key)) {
                pageArray = result.getAsJsonArray(key);
            } else {
                pageArray = new JsonArray();
                result.add(key, pageArray);
            }
            pageArray.add(comment.getJson());
        }
        JsonArray wrapper = new JsonArray();
        wrapper.add(result);
        json.add("AOP_PDF_COMMENTS", wrapper);
        return json;
    }
    /**
     * Returns an immutable set of all template tags this element can replace.
     * Currently empty as PDF comments are purely visual and not template-bound.
     *
     * @return An immutable empty set.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<>();
        return ImmutableSet.copyOf(hash_Set);
    }
}
