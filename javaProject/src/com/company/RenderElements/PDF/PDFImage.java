package com.company.RenderElements.PDF;

import com.google.gson.JsonObject;



public class PDFImage extends PDFInsertObject{

    private String image;
    private Integer rotation;
    private Integer width;
    private Integer height;
    private Integer maxWidth;

    /**
     * @return Image base64-encoded or URL.
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image Image base64-encoded or URL.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return Rotation in degrees.
     */
    public Integer getRotation() {
        return rotation;
    }

    /**
     * @param rotation Rotation in degrees.
     */
    public void setRotation(Integer rotation) {
        this.rotation = rotation;
    }

    /**
     * @return Image width in px.
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width Image width in px.
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return Image height in px.
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height Image height in px.
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return Max width for proportionally scaling.
     */
    public Integer getMaxWidth() {
        return maxWidth;
    }

    /**
     * @param maxWidth Max width for proportionally scaling.
     */
    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * Represents an image to insert in a PDF. The image options can be set with the setter functions.
     * @param x X-coordinate of the position of the text in the template starting from bottom left.
     * @param y Y-coordinate of the position of the text in the template starting from bottom left.
     * @param pageNumber Page number of the page where the text should be inserted. -1 if the text should be displayed on all pages.
     * @param image Image base64 or URL.
     */
    public PDFImage(Integer x, Integer y, Integer pageNumber, String image){
        super(x,y,pageNumber);
        setImage(image);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.addProperty("image", getImage());
        json.addProperty("x", getX());
        json.addProperty("y", getY());
        if (getRotation()!=null){
            json.addProperty("rotation", getRotation());
        }
        if (getWidth()!=null){
            json.addProperty("image_width", getWidth());
        }
        if (getHeight()!=null){
            json.addProperty("image_height", getHeight());
        }
        if (getMaxWidth()!=null){
            json.addProperty("image_max_width", getMaxWidth());
        }
        return json;
    }

    /**
     * @return Identifier for the JSON.
     */
    @Override
    public String getIdentifier() {
        return "AOP_PDF_IMAGES";
    }
}
