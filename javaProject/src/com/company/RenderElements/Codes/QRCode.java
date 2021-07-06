package com.company.RenderElements.Codes;

import com.company.Resources.Base64Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/**
 * This class is a subclass of Code and serves as a superclass for the different types of QR-codes. It contains all the styling
 * options of the QR codes.
 */
public abstract class QRCode extends Code {

    private Integer dotScale;
    private String logo;
    private String backGroundImage;
    private Integer colorDark;
    private String colorLight;
    private Integer WidthLogo;
    private Integer HeightLogo;
    private String logoBackGroundColor;
    private String quietZone;
    private String quietZoneColor;
    private Integer backgroundImageAlpha;
    private Integer poColor;
    private String piColor;
    private Integer poTLColor;
    private String piTLColor;
    private Integer poTRColor;
    private String piTRColor;
    private Integer poBLColor;
    private String piBLColor;
    private String timingVColor;
    private String timingHColor;
    private String timingColor;
    private String autoColor;
    private String autoColorDark;
    private String autoColorLight;

    /**
     * @return For body block, must be greater than 0, less than or equal to 1. default is 1.
     */
    public Integer getDotScale() {
        return dotScale;
    }

    /**
     * @param dotScale For body block, must be greater than 0, less than or equal to 1. default is 1
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
     * Sets the to the given image from the path.
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

    public void setBackGroundImage(String backGroundImage) {
        this.backGroundImage = backGroundImage;
    }

    public Integer getColorDark() {
        return colorDark;
    }

    public void setColorDark(Integer colorDark) {
        this.colorDark = colorDark;
    }

    public String getColorLight() {
        return colorLight;
    }

    public void setColorLight(String colorLight) {
        this.colorLight = colorLight;
    }

    public Integer getWidthLogo() {
        return WidthLogo;
    }

    public void setWidthLogo(Integer widthLogo) {
        WidthLogo = widthLogo;
    }

    public Integer getHeightLogo() {
        return HeightLogo;
    }

    public void setHeightLogo(Integer heightLogo) {
        HeightLogo = heightLogo;
    }

    public String getLogoBackGroundColor() {
        return logoBackGroundColor;
    }

    public void setLogoBackGroundColor(String logoBackGroundColor) {
        this.logoBackGroundColor = logoBackGroundColor;
    }

    public String getQuietZone() {
        return quietZone;
    }

    public void setQuietZone(String quietZone) {
        this.quietZone = quietZone;
    }

    public String getQuietZoneColor() {
        return quietZoneColor;
    }

    public void setQuietZoneColor(String quietZoneColor) {
        this.quietZoneColor = quietZoneColor;
    }

    public Integer getBackgroundImageAlpha() {
        return backgroundImageAlpha;
    }

    public void setBackgroundImageAlpha(Integer backgroundImageAlpha) {
        this.backgroundImageAlpha = backgroundImageAlpha;
    }

    public Integer getPoColor() {
        return poColor;
    }

    public void setPoColor(Integer poColor) {
        this.poColor = poColor;
    }

    public String getPiColor() {
        return piColor;
    }

    public void setPiColor(String piColor) {
        this.piColor = piColor;
    }

    public Integer getPoTLColor() {
        return poTLColor;
    }

    public void setPoTLColor(Integer poTLColor) {
        this.poTLColor = poTLColor;
    }

    public String getPiTLColor() {
        return piTLColor;
    }

    public void setPiTLColor(String piTLColor) {
        this.piTLColor = piTLColor;
    }

    public Integer getPoTRColor() {
        return poTRColor;
    }

    public void setPoTRColor(Integer poTRColor) {
        this.poTRColor = poTRColor;
    }

    public String getPiTRColor() {
        return piTRColor;
    }

    public void setPiTRColor(String piTRColor) {
        this.piTRColor = piTRColor;
    }

    public Integer getPoBLColor() {
        return poBLColor;
    }

    public void setPoBLColor(Integer poBLColor) {
        this.poBLColor = poBLColor;
    }

    public String getPiBLColor() {
        return piBLColor;
    }

    public void setPiBLColor(String piBLColor) {
        this.piBLColor = piBLColor;
    }

    public String getTimingVColor() {
        return timingVColor;
    }

    public void setTimingVColor(String timingVColor) {
        this.timingVColor = timingVColor;
    }

    public String getTimingHColor() {
        return timingHColor;
    }

    public void setTimingHColor(String timingHColor) {
        this.timingHColor = timingHColor;
    }

    public String getTimingColor() {
        return timingColor;
    }

    public void setTimingColor(String timingColor) {
        this.timingColor = timingColor;
    }

    public String getAutoColor() {
        return autoColor;
    }

    public void setAutoColor(String autoColor) {
        this.autoColor = autoColor;
    }

    public String getAutoColorDark() {
        return autoColorDark;
    }

    public void setAutoColorDark(String autoColorDark) {
        this.autoColorDark = autoColorDark;
    }

    public String getAutoColorLight() {
        return autoColorLight;
    }

    public void setAutoColorLight(String autoColorLight) {
        this.autoColorLight = autoColorLight;
    }

    /**
     * This class represents codes (barcode or QR codes) (created using the data of the key) for a template.
     *
     * @param name  Name of this code for the tag.
     * @param type  Type of code required. The options can be found on:
     *              http://www.apexofficeprint.com/docs/#615-barcode-qrcode-tags
     * @param value Data to create the code from.
     */
    public QRCode(String name, String type, String value) {
        super(name, type, value);
    }
}
