package com.company.Output.PDFOptions;

import com.google.gson.JsonObject;

/**
 * Class for all the optional PDF output options.
 */
public class PDFOptions {

    private String readPassword;
    private String watermark;
    private pageDimension pageWidth;
    private pageDimension pageHeight;
    private Boolean evenPage;
    private Boolean mergeMakingEven;
    private String modifyPassword;
    private int passwordProtectionFlag;
    private Boolean lockForm;
    private int copies;
    private int [] pageMargin; // a voir que format
    private Boolean landscape;

    /**
     * @return password to read the output.
     */
    public String getReadPassword() {
        return readPassword;
    }

    /**
     * @param readPassword password to read the output.
     */
    public void setReadPassword(String readPassword) {
        this.readPassword = readPassword;
    }

    /**
     * @return diagonal custom watermark on every page in the output file.
     */
    public String getWatermark() {
        return watermark;
    }

    /**
     * @param watermark diagonal custom watermark on every page in the output file.
     */
    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    /**
     * @return pageDimension with width and unit.
     */
    public pageDimension getPageWidth() {
        return pageWidth;
    }

    /**
     * @param pageWidth pageDimension object
     */
    public void setPageWidth(pageDimension pageWidth) {
        this.pageWidth = pageWidth;
    }

    /**
     * @return pageDimension with height and unit.
     */
    public pageDimension getPageHeight() {
        return pageHeight;
    }

    /**
     * @param pageHeight pageDimension object
     */
    public void setPageHeight(pageDimension pageHeight) {
        this.pageHeight = pageHeight;
    }

    /**
     * @return true if output will have even pages (blank page added if uneven amount of pages).
     */
    public Boolean getEvenPage() {
        return evenPage;
    }

    /**
     * If you want your output to have even pages (blank page added if uneven amount of pages), set this to true.
     * @param evenPage
     */
    public void setEvenPage(Boolean evenPage) {
        this.evenPage = evenPage;
    }

    /**
     * @return If AOP is going to merge all the append/prepend and template files, making sure the output is even-paged
     * (adding a blank page if the output is uneven-paged).
     */
    public Boolean getMergeMakingEven() {
        return mergeMakingEven;
    }

    /**
     * If you want to merge all the append/prepend and template files, making sure the output is even-paged
     * (adding a blank page if the output is uneven-paged) set this to true.
     * @param mergeMakingEven
     */
    public void setMergeMakingEven(Boolean mergeMakingEven) {
        this.mergeMakingEven = mergeMakingEven;
    }

    /**
     * @return The password needed to modify the PDF.
     */
    public String getModifyPassword() {
        return modifyPassword;
    }

    /**
     * Sets the password needed to modify the PDF.
     * @param modifyPassword
     */
    public void setModifyPassword(String modifyPassword) {
        this.modifyPassword = modifyPassword;
    }

    public int getPasswordProtectionFlag() {
        return passwordProtectionFlag;
    }

    public void setPasswordProtectionFlag(int passwordProtectionFlag) {
        this.passwordProtectionFlag = passwordProtectionFlag;
    }

    public Boolean getLockForm() {
        return lockForm;
    }

    public void setLockForm(Boolean lockForm) {
        this.lockForm = lockForm;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int[] getPageMargin() {
        return pageMargin;
    }

    public void setPageMargin(int[] pageMargin) {
        this.pageMargin = pageMargin;
    }

    public Boolean getLandscape() {
        return landscape;
    }

    public void setLandscape(Boolean landscape) {
        this.landscape = landscape;
    }

    public String getPageFormat() {
        return pageFormat;
    }

    public void setPageFormat(String pageFormat) {
        this.pageFormat = pageFormat;
    }

    public Boolean getMerge() {
        return merge;
    }

    public void setMerge(Boolean merge) {
        this.merge = merge;
    }

    public String getSignCertificate() {
        return signCertificate;
    }

    public void setSignCertificate(String signCertificate) {
        this.signCertificate = signCertificate;
    }

    String pageFormat;
    Boolean merge;
    String signCertificate;

    public JsonObject getJSON(){
        JsonObject json = new JsonObject();
        return json;
    }
}
