package com.CloudOfficePrint.RenderElements.PDF;

import com.google.gson.JsonObject;

/**
 * Abstract base class for PDF's insertable objects.
 */
public abstract class PDFInsertObject {
    private Integer x;
    private Integer y;
    private Integer pageNumber;

    /**
     * @return X-coordinate of the position of the object in the template starting
     *         from bottom left.
     */
    public Integer getX() {
        return x;
    }

    /**
     * @param x X-coordinate of the position of the object in the template starting
     *          from bottom left.
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * @return Y-coordinate of the position of the object in the template starting
     *         from bottom left.
     */
    public Integer getY() {
        return y;
    }

    /**
     * @param y Y-coordinate of the position of the object in the template starting
     *          from bottom left.
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * @return Page number of the page where the object should be inserted. -1 if
     *         the text should be displayed on all pages.
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber Page number of the page where the object should be
     *                   inserted. -1 if the text should be displayed on all pages.
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Represents an object to insert in a PDF.
     * 
     * @param x          X-coordinate of the position of the object in the template
     *                   starting from bottom left.
     * @param y          Y-coordinate of the position of the object in the template
     *                   starting from bottom left.
     * @param pageNumber Page number of the page where the object should be
     *                   inserted. -1 if the object should be displayed on all
     *                   pages.
     */
    public PDFInsertObject(Integer x, Integer y, Integer pageNumber) {
        setX(x);
        setY(y);
        setPageNumber(pageNumber);
    };

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public abstract JsonObject getJson();

    /**
     * @return Identifier for the JSON.
     */
    public abstract String getIdentifier();
}
