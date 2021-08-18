package com.CloudOfficePrint.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class represents a barcode or a QR code (created using the data of the
 * key) for a template.
 */
public class BarCode extends Code {

    private Integer height;
    private Integer width;
    private String linkUrl;
    private Integer rotation;
    private String backgroundColor;
    private Integer paddingWidth;
    private Integer paddingHeight;
    private String qrErrorCorrectionLevel;
    private String extraOptions;

    /**
     * @return Height for the generated code.
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height Height for the generated code. Default is 200 for QR, 50 for
     *               the rest.
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return Width for the generated code.
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width Width for the generated code. Default is 200.
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return URL to hyperlink to when the code is clicked.
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * @param linkUrl URL to hyperlink to when the code is clicked.
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * @return Angle on which the inserted code should be rotated (in degrees,
     *         counterclockwise).
     */
    public Integer getRotation() {
        return rotation;
    }

    /**
     * @param rotation Angle on which the inserted code should be rotated (in
     *                 degrees, counterclockwise).
     */
    public void setRotation(Integer rotation) {
        this.rotation = rotation;
    }

    /**
     * @return The background color for the code.
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor The background color for the code. Default:
     *                        white/ffffff.
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return The padding width on the inserted code in pixels.
     */
    public Integer getPaddingWidth() {
        return paddingWidth;
    }

    /**
     * @param paddingWidth The padding width on the inserted code in pixels. Default
     *                     10 px.
     */
    public void setPaddingWidth(Integer paddingWidth) {
        this.paddingWidth = paddingWidth;
    }

    /**
     * @return The padding height on the inserted code in pixels.
     */
    public Integer getPaddingHeight() {
        return paddingHeight;
    }

    /**
     * @param paddingHeight The padding height on the inserted code in pixels.
     *                      Default 10 px.
     */
    public void setPaddingHeight(Integer paddingHeight) {
        this.paddingHeight = paddingHeight;
    }

    /**
     * Only for QR codes.
     * 
     * @return Level at which the QR code should be recoverable. The options are:
     *         "L" (up to 7% damage) "M" (up to 15% damage) "Q" (up to 25% damage)
     *         "H" (up to 30% damage)
     */
    public String getQrErrorCorrectionLevel() {
        return qrErrorCorrectionLevel;
    }

    /**
     * Only for QR codes.
     * 
     * @param qrErrorCorrectionLevel Level at which the QR code should be
     *                               recoverable. The options are: "L" (up to 7%
     *                               damage) "M" (up to 15% damage) "Q" (up to 25%
     *                               damage) "H" (up to 30% damage)
     */
    public void setQrErrorCorrectionLevel(String qrErrorCorrectionLevel) {
        this.qrErrorCorrectionLevel = qrErrorCorrectionLevel;
    }

    /**
     * If you want to include extra options like including barcode text on the botto
     * The options should be space separated and should be followed by a "=" and
     * their value. E.g.: "includetext guardwhitespace guardwidth=3 guardheight=3".
     * Please visit:
     * https://github.com/bwipp/postscriptbarcode/wiki/Symbologies-Reference for all
     * option availability.
     * 
     * @return These extra options.
     */
    public String getExtraOptions() {
        return extraOptions;
    }

    /**
     * If you want to include extra options like including barcode text on the botto
     * The options should be space separated and should be followed by a "=" and
     * their value. E.g.: "includetext guardwhitespace guardwidth=3 guardheight=3".
     * Please visit:
     * https://github.com/bwipp/postscriptbarcode/wiki/Symbologies-Reference for all
     * option availability.
     * 
     * @param extraOptions These extra options.
     */
    public void setExtraOptions(String extraOptions) {
        this.extraOptions = extraOptions;
    }

    /**
     * This class represents a barcode (created using the data of the key) for a
     * template. All the options can be set with the setter functions.
     * 
     * @param name  Name of this code for the tag.
     * @param type  Type of barcode required. The options can be found on:
     *              http://www.cloudofficeprint.com/docs/#barcode-qrcode-tags
     * @param value Data to create the code from.
     */
    public BarCode(String name, String type, String value) {
        super(name, type, value);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        json.addProperty(getName() + "_type", getType());
        if (getHeight() != null) {
            json.addProperty(getName() + "_height", getHeight());
        }
        if (getWidth() != null) {
            json.addProperty(getName() + "_width", getWidth());
        }
        if (getQrErrorCorrectionLevel() != null) {
            json.addProperty(getName() + "_errorcorrectlevel", getQrErrorCorrectionLevel());
        }
        if (getLinkUrl() != null) {
            json.addProperty(getName() + "_url", getLinkUrl());
        }
        if (getRotation() != null) {
            json.addProperty(getName() + "_rotation", getRotation());
        }
        if (getBackgroundColor() != null) {
            json.addProperty(getName() + "_background_color", getBackgroundColor());
        }
        if (getPaddingWidth() != null) {
            json.addProperty(getName() + "_padding_width", getPaddingWidth());
        }
        if (getPaddingHeight() != null) {
            json.addProperty(getName() + "_padding_height", getPaddingHeight());
        }
        if (getExtraOptions() != null) {
            json.addProperty(getName() + "_extra_options", getExtraOptions());
        }
        return json;
    }

}
