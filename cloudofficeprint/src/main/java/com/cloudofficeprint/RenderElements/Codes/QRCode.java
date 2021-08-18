package com.cloudofficeprint.RenderElements.Codes;

import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * This class is a subclass of Code and serves as a superclass for the different
 * types of QR-codes. It contains all the styling options of the QR codes.
 */
public class QRCode extends Code {

    private Integer dotScale;
    private String logo;
    private String backGroundImage;
    private String colorDark;
    private String colorLight;
    private Integer WidthLogo;
    private Integer HeightLogo;
    private String logoBackGroundColor;
    private Integer quietZone;
    private String quietZoneColor;
    private Double backgroundImageAlpha;
    private String poColor;
    private String piColor;
    private String poTLColor;
    private String piTLColor;
    private String poTRColor;
    private String piTRColor;
    private String poBLColor;
    private String piBLColor;
    private String timingVColor;
    private String timingHColor;
    private String timingColor;
    private Boolean autoColor;
    private String autoColorDark;
    private String autoColorLight;

    /**
     * @return For body block, must be greater than 0, less than or equal to 1.
     *         default is 1.
     */
    public Integer getDotScale() {
        return dotScale;
    }

    /**
     * @param dotScale For body block, must be greater than 0, less than or equal to
     *                 1. default is 1
     */
    public void setDotScale(Integer dotScale) {
        this.dotScale = dotScale;
    }

    /**
     * @return Logo image of the QR code base64 or URL.
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo Logo image of the QR code, base64 or URL.
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * Sets the logo to the given image from the path.
     * 
     * @param filePath Path of the local file.
     * @throws IOException If file not found.
     */
    public void setLogoFromLocalFile(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] bytes = Files.readAllBytes(file.toPath());
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        setLogo(encodedString);
    }

    /**
     * @return Background image of the QR code, base64 or URL.
     */
    public String getBackGroundImage() {
        return backGroundImage;
    }

    /**
     * @param backGroundImage Background image of the QR code, base64 or URL.
     */
    public void setBackGroundImage(String backGroundImage) {
        this.backGroundImage = backGroundImage;
    }

    /**
     * Sets the background image of the QR code to the given image from the path.
     * 
     * @param filePath Path of the local file.
     * @throws IOException If file not found.
     */
    public void setBackGroundImageFromLocalFile(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] bytes = Files.readAllBytes(file.toPath());
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        setBackGroundImage(encodedString);
    }

    /**
     * @return Dark color of the QR code.
     */
    public String getColorDark() {
        return colorDark;
    }

    /**
     * @param colorDark Dark color of the QR code.
     */
    public void setColorDark(String colorDark) {
        this.colorDark = colorDark;
    }

    /**
     * @return Light color of the QR code.
     */
    public String getColorLight() {
        return colorLight;
    }

    /**
     * @param colorLight Light color of the QR code.
     */
    public void setColorLight(String colorLight) {
        this.colorLight = colorLight;
    }

    /**
     * @return Width of the logo in px.
     */
    public Integer getWidthLogo() {
        return WidthLogo;
    }

    /**
     * @param widthLogo Width of the logo in px.
     */
    public void setWidthLogo(Integer widthLogo) {
        WidthLogo = widthLogo;
    }

    /**
     * @return Height of the logo in px.
     */
    public Integer getHeightLogo() {
        return HeightLogo;
    }

    /**
     * @param heightLogo Height of the logo in px.
     */
    public void setHeightLogo(Integer heightLogo) {
        HeightLogo = heightLogo;
    }

    /**
     * @return Background color of the QR code.
     */
    public String getLogoBackGroundColor() {
        return logoBackGroundColor;
    }

    /**
     * @param logoBackGroundColor Background color of the QR code.
     */
    public void setLogoBackGroundColor(String logoBackGroundColor) {
        this.logoBackGroundColor = logoBackGroundColor;
    }

    /**
     * @return Padding around the QR code.
     */
    public Integer getQuietZone() {
        return quietZone;
    }

    /**
     * @param quietZone Padding around the QR code.
     */
    public void setQuietZone(Integer quietZone) {
        this.quietZone = quietZone;
    }

    /**
     * @return Color of the padding area.
     */
    public String getQuietZoneColor() {
        return quietZoneColor;
    }

    /**
     * @param quietZoneColor Color of the padding area.
     */
    public void setQuietZoneColor(String quietZoneColor) {
        this.quietZoneColor = quietZoneColor;
    }

    /**
     * @return Background image transparency, value between 0 and 1. default is 1
     */
    public Double getBackgroundImageAlpha() {
        return backgroundImageAlpha;
    }

    /**
     * @param backgroundImageAlpha Background image transparency, value between 0
     *                             and 1. default is 1
     */
    public void setBackgroundImageAlpha(Double backgroundImageAlpha) {
        this.backgroundImageAlpha = backgroundImageAlpha;
    }

    /**
     * @return Global Position Outer color. If not set, the defaut is `colorDark`.
     */
    public String getPoColor() {
        return poColor;
    }

    /**
     * @param poColor Global Position Inner color. If not set, the defaut is
     *                `colorDark`.
     */
    public void setPoColor(String poColor) {
        this.poColor = poColor;
    }

    /**
     * @return Position Inner color - Top Left.
     */
    public String getPiColor() {
        return piColor;
    }

    /**
     * @param piColor Position Inner color - Top Left.
     */
    public void setPiColor(String piColor) {
        this.piColor = piColor;
    }

    /**
     * @return Position Outer color - Top Left.
     */
    public String getPoTLColor() {
        return poTLColor;
    }

    /**
     * @param poTLColor Position Outer color - Top Left.
     */
    public void setPoTLColor(String poTLColor) {
        this.poTLColor = poTLColor;
    }

    /**
     * @return Position Inner color - Top Left.
     */
    public String getPiTLColor() {
        return piTLColor;
    }

    /**
     * @param piTLColor Position Inner color - Top Left.
     */
    public void setPiTLColor(String piTLColor) {
        this.piTLColor = piTLColor;
    }

    /**
     * @return Position Outer color - Top Right.
     */
    public String getPoTRColor() {
        return poTRColor;
    }

    /**
     * @param poTRColor Position Outer color - Top Right.
     */
    public void setPoTRColor(String poTRColor) {
        this.poTRColor = poTRColor;
    }

    /**
     * @return Position Inner color - Top Right.
     */
    public String getPiTRColor() {
        return piTRColor;
    }

    /**
     * @param piTRColor Position Inner color - Top Right.
     */
    public void setPiTRColor(String piTRColor) {
        this.piTRColor = piTRColor;
    }

    /**
     * @return Position Outer color - Bottom Left.
     */
    public String getPoBLColor() {
        return poBLColor;
    }

    /**
     * @param poBLColor Position Outer color - Bottom Left.
     */
    public void setPoBLColor(String poBLColor) {
        this.poBLColor = poBLColor;
    }

    /**
     * @return Position Inner color - Bottom Left.
     */
    public String getPiBLColor() {
        return piBLColor;
    }

    /**
     * @param piBLColor Position Inner color - Bottom Left.
     */
    public void setPiBLColor(String piBLColor) {
        this.piBLColor = piBLColor;
    }

    /**
     * @return Vertical timing color.
     */
    public String getTimingVColor() {
        return timingVColor;
    }

    /**
     * @param timingVColor Vertical timing color.
     */
    public void setTimingVColor(String timingVColor) {
        this.timingVColor = timingVColor;
    }

    /**
     * @return Horizontal timing color.
     */
    public String getTimingHColor() {
        return timingHColor;
    }

    /**
     * @param timingHColor Horizontal timing color.
     */
    public void setTimingHColor(String timingHColor) {
        this.timingHColor = timingHColor;
    }

    /**
     * @return Global timing color.
     */
    public String getTimingColor() {
        return timingColor;
    }

    /**
     * @param timingColor Global timing color.
     */
    public void setTimingColor(String timingColor) {
        this.timingColor = timingColor;
    }

    /**
     * @return Automatic color adjustment(for data block) (default is false) (set to
     *         false if using background images).
     */
    public Boolean getAutoColor() {
        return autoColor;
    }

    /**
     * @param autoColor Automatic color adjustment(for data block) (default is
     *                  false) (set to false if using background images).
     */
    public void setAutoColor(Boolean autoColor) {
        this.autoColor = autoColor;
    }

    /**
     * @return Automatic color: dark CSS color (only required when qr_auto_color is
     *         set true) (dark color preferred, otherwise may lead to undetectable
     *         QR).
     */
    public String getAutoColorDark() {
        return autoColorDark;
    }

    /**
     * @param autoColorDark Automatic color: dark CSS color (only required when
     *                      qr_auto_color is set true) (dark color preferred,
     *                      otherwise may lead to undetectable QR).
     */
    public void setAutoColorDark(String autoColorDark) {
        this.autoColorDark = autoColorDark;
    }

    /**
     * @return Automatic color: light CSS color (only required when qr_auto_color is
     *         set true).
     */
    public String getAutoColorLight() {
        return autoColorLight;
    }

    /**
     * @param autoColorLight Automatic color: light CSS color (only required when
     *                       qr_auto_color is set true).
     */
    public void setAutoColorLight(String autoColorLight) {
        this.autoColorLight = autoColorLight;
    }

    /**
     * This class is a subclass of Code and serves as a superclass for the different
     * types of QR-codes. It contains all the styling options of the QR codes.
     * 
     * @param name  Name of this code for the tag.
     * @param type  Type of code required. The options can be found on:
     *              http://www.cloudofficeprint.com/docs/#barcode-qrcode-tags
     * @param value Data to create the code from.
     */
    public QRCode(String name, String type, String value) {
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
        if (getDotScale() != null) {
            json.addProperty(getName() + "_qr_dotscale", getDotScale());
        }
        if (getLogo() != null) {
            json.addProperty(getName() + "_qr_logo", getLogo());
        }
        if (getBackGroundImage() != null) {
            json.addProperty(getName() + "_qr_background_image", getBackGroundImage());
        }
        if (getColorDark() != null) {
            json.addProperty(getName() + "_qr_color_dark", getColorDark());
        }
        if (getColorLight() != null) {
            json.addProperty(getName() + "_qr_color_light", getColorLight());
        }
        if (getWidthLogo() != null) {
            json.addProperty(getName() + "_qr_logo_width", getWidthLogo());
        }
        if (getHeightLogo() != null) {
            json.addProperty(getName() + "_qr_logo_height", getHeightLogo());
        }
        if (getLogoBackGroundColor() != null) {
            json.addProperty(getName() + "_qr_logo_background_color", getLogoBackGroundColor());
        }
        if (getQuietZone() != null) {
            json.addProperty(getName() + "_qr_quiet_zone", getQuietZone());
        }
        if (getQuietZoneColor() != null) {
            json.addProperty(getName() + "_qr_quiet_zone_color", getQuietZoneColor());
        }
        if (getBackgroundImageAlpha() != null) {
            json.addProperty(getName() + "_qr_background_image_alpha", getBackgroundImageAlpha());
        }
        if (getPoColor() != null) {
            json.addProperty(getName() + "_qr_po_color", getPoColor());
        }
        if (getPiColor() != null) {
            json.addProperty(getName() + "_qr_pi_color", getPiColor());
        }
        if (getPoTLColor() != null) {
            json.addProperty(getName() + "_qr_po_tl_color", getPoTLColor());
        }
        if (getPiTLColor() != null) {
            json.addProperty(getName() + "_qr_pi_tl_color", getPiTLColor());
        }
        if (getPoTRColor() != null) {
            json.addProperty(getName() + "_qr_po_tr_color", getPoTRColor());
        }
        if (getPiTRColor() != null) {
            json.addProperty(getName() + "_qr_pi_tr_color", getPiTRColor());
        }
        if (getPoBLColor() != null) {
            json.addProperty(getName() + "_qr_po_bl_color", getPoBLColor());
        }
        if (getPiBLColor() != null) {
            json.addProperty(getName() + "_qr_pi_bl_color", getPiBLColor());
        }
        if (getTimingVColor() != null) {
            json.addProperty(getName() + "_qr_timing_v_color", getTimingVColor());
        }
        if (getTimingHColor() != null) {
            json.addProperty(getName() + "_qr_timing_h_color", getTimingHColor());
        }
        if (getTimingColor() != null) {
            json.addProperty(getName() + "_qr_timing_color", getTimingColor());
        }
        if (getAutoColor() != null) {
            json.addProperty(getName() + "_qr_auto_color", getAutoColor());
        }
        if (getAutoColorDark() != null) {
            json.addProperty(getName() + "_qr_auto_color_dark", getAutoColorDark());
        }
        if (getAutoColorLight() != null) {
            json.addProperty(getName() + "_qr_auto_color_light", getAutoColorLight());
        }
        return json;
    }
}
