package com.cloudofficeprint.RenderElements.Images;

import com.cloudofficeprint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

public abstract class Image extends RenderElement {

    private Integer width;
    private Integer height;
    private boolean maintainAspectRatio;
    private Integer maxWidth;
    private Integer maxHeight;
    private String altText;
    private String wrapText;
    private String Transparency;
    private Integer rotation;
    private String TargetUrl;

    /**
     * @return Width of the image (for non-proportionally scaling).
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width Width of the image (for non-proportionally scaling).
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return Height of the image (for non-proportionally scaling).
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height Height of the image (for non-proportionally scaling).
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return Whether the aspect ratio is maintained.
     */
    public boolean getMaintainAspectRatio() {
        return maintainAspectRatio;
    }

    /**
     * @param maintainAspectRatio whether to maintain the aspect ratio, the width has be set for this option to work.
     */
    public void setMaintainAspectRatio(boolean maintainAspectRatio) {
        this.maintainAspectRatio = maintainAspectRatio;
    }

    /**
     * @return Maximum width of the image (for proportionally scaling).
     */
    public Integer getMaxWidth() {
        return maxWidth;
    }

    /**
     * @param maxWidth Maximum width of the image (for proportionally scaling).
     */
    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * @return Maximum height of the image (for proportionally scaling).
     */
    public Integer getMaxHeight() {
        return maxHeight;
    }

    /**
     * @param maxHeight Maximum height of the image (for proportionally scaling).
     */
    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * @return Text displayed when the image can't be downloaded.
     */
    public String getAltText() {
        return altText;
    }

    /**
     * @param altText Text displayed when the image can't be downloaded.
     */
    public void setAltText(String altText) {
        this.altText = altText;
    }

    /**
     * Note : only supports 5 of the Microsoft Word Text Wrapping options. In line
     * with text : This option is default. If no wrap option specified images will
     * wrapped in line with text. Square : In order to use this property, wrap
     * option should be "square". Top and Bottom : In order to use this property,
     * wrap option should be "top-bottom". Behind Text : In order to use this
     * property, wrap option should be "behind". In Front of Text : In order to use
     * this property, wrap option should be "front".
     *
     * @return The wrapping mode of the text around the image.
     */
    public String getWrapText() {
        return wrapText;
    }

    /**
     * Note : only supports 5 of the Microsoft Word Text Wrapping options. In line
     * with text : This option is default. If no wrap option specified images will
     * wrapped in line with text. Square : In order to use this property, wrap
     * option should be "square". Top and Bottom : In order to use this property,
     * wrap option should be "top-bottom". Behind Text : In order to use this
     * property, wrap option should be "behind". In Front of Text : In order to use
     * this property, wrap option should be "front".
     *
     * @param wrapText The wrapping mode of the text around the image.
     */
    public void setWrapText(String wrapText) {
        this.wrapText = wrapText;
    }

    /**
     * @return Transparency of the image followed by % e.g. : 80%.
     */
    public String getTransparency() {
        return Transparency;
    }

    /**
     * @param transparency Transparency of the image followed by % e.g. : 80%.
     */
    public void setTransparency(String transparency) {
        Transparency = transparency;
    }

    /**
     * @return Rotation of the image in degrees.
     */
    public Integer getRotation() {
        return rotation;
    }

    /**
     * @param rotation Rotation of the image in degrees.
     */
    public void setRotation(Integer rotation) {
        this.rotation = rotation;
    }

    /**
     * @return URL to jump to if the image is clicked.
     */
    public String getTargetUrl() {
        return TargetUrl;
    }

    /**
     * @param targetUrl URL to jump to if the image is clicked.
     */
    public void setTargetUrl(String targetUrl) {
        TargetUrl = targetUrl;
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        if (getMaxWidth() != null) {
            json.addProperty(getName() + "_max_width", getMaxWidth());
        }
        if (getMaxHeight() != null) {
            json.addProperty(getName() + "_max_height", getMaxHeight());
        }
        if (getAltText() != null) {
            json.addProperty(getName() + "_alt_text", getAltText());
        }
        if (getWidth() != null) {
            json.addProperty(getName() + "_width", getWidth());
        }
        if (getHeight() != null) {
            json.addProperty(getName() + "_height", getHeight());
        }
        if (getMaintainAspectRatio()) {
            json.addProperty(getName() + "_maintain_aspect_ratio", getMaintainAspectRatio());
        }
        if (getWrapText() != null) {
            json.addProperty(getName() + "_wrap_text", getWrapText());
        }
        if (getRotation() != null) {
            json.addProperty(getName() + "_rotation", getRotation());
        }
        if (getTargetUrl() != null) {
            json.addProperty(getName() + "_url", getTargetUrl());
        }
        if (getTransparency() != null) {
            json.addProperty(getName() + "_transparency", getTransparency());
        }
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{%" + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
