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
    private int passwordProtectionFlag =-1;
    private Boolean lockForm;
    private int copies =-1;
    private int [] pageMargin;
    private Boolean landscape;
    private String pageFormat;
    private Boolean merge;
    private String signCertificate;

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

    /**
     * @return protection flag for the PDF (in addition to the user password).
     */
    public int getPasswordProtectionFlag() {
        return passwordProtectionFlag;
    }

    /**
     * @param passwordProtectionFlag protection flag for the PDF (in addition to the user password).
     */
    public void setPasswordProtectionFlag(int passwordProtectionFlag) {
        this.passwordProtectionFlag = passwordProtectionFlag;
    }

    /**
     * @return If the output PDF will be locked/flattened.
     */
    public Boolean getLockForm() {
        return lockForm;
    }

    /**
     * @param lockForm Set to true if you want the output PDF to be locked/flattened.
     */
    public void setLockForm(Boolean lockForm) {
        this.lockForm = lockForm;
    }

    /**
     * @return Number of times the output will be repeated.
     */
    public int getCopies() {
        return copies;
    }

    /**
     * @param copies Amount of times the output will be repeated.
     */
    public void setCopies(int copies) {
        this.copies = copies;
    }

    /**
     * @return top bottom left right margin in pixels .
     */
    public int[] getPageMargin() {
        return pageMargin;
    }

    /**
     * @param pageMargin top bottom left right margin in pixels .
     */
    public void setPageMargin(int[] pageMargin) throws Exception {
        if (pageMargin.length!=4){
            throw new Exception("Please specify 4 margins.");
        }
        this.pageMargin = pageMargin;
    }

    /**
     * @return True if orientation is landscape, false if orientation is portrait (default used by server).
     */
    public Boolean getLandscape() {
        return landscape;
    }

    /**
     * @param landscape Set to true if you want the orientation of the output to be landscape, false for portrait (default used by server).
     */
    public void setLandscape(Boolean landscape) {
        this.landscape = landscape;
    }

    /**
     * @return The page format: "A4" (default used by AOP) or "letter".
     */
    public String getPageFormat() {
        return pageFormat;
    }

    /**
     * @param pageFormat The page format: "A4" or "letter".
     */
    public void setPageFormat(String pageFormat) {
        this.pageFormat = pageFormat;
    }

    /**
     * @return True if instead of returning back a zip file for multiple outputs, they will be merged in one output.
     */
    public Boolean getMerge() {
        return merge;
    }

    /**
     * @param merge Set to true if you want to instead of returning back a zip file for multiple outputs, they will be merged in one output.
     */
    public void setMerge(Boolean merge) {
        this.merge = merge;
    }

    /**
     * It is possible to sign the output PDF if the output pdf has a signature field.
     * * @return The certificate (pkcs #12 .p12/.pfx) in a base64 encoded format
     *           (this can also be a URL, FTP location or a location in the file system of the server).
     */
    public String getSignCertificate() {
        return signCertificate;
    }

    /**
     * It is possible to sign the output PDF if the output pdf has a signature field.
     * @param signCertificate The certificate (pkcs #12 .p12/.pfx) in a base64 encoded format
     *                        (this can also be a URL, FTP location or a location in the file system of the server).
     */
    public void setSignCertificate(String signCertificate) {
        this.signCertificate = signCertificate;
    }


    public JsonObject getJSON(){
        JsonObject json = new JsonObject();
        if (getEvenPage()!=null){
            json.addProperty("output_even_page", getEvenPage());
        }
        if (getMergeMakingEven()!=null){
            json.addProperty("output_merge_making_even", getMergeMakingEven());
        }
        if (getModifyPassword()!=null){
            json.addProperty("output_modify_password", getModifyPassword());
        }
        if (getReadPassword()!=null){
            json.addProperty("output_read_password", getReadPassword());
        }
        if (getPasswordProtectionFlag()!=-1){
            json.addProperty("output_password_protection_flag", getPasswordProtectionFlag());
        }
        if (getWatermark()!=null){
            json.addProperty("output_watermark", getWatermark());
        }
        if (getLockForm()!=null){
            json.addProperty("lock_form", getLockForm());
        }
        if (getPageMargin()!=null){
            for (int i =0; i< getPageMargin().length; i++){
                if (i==0){
                    json.addProperty("output_page_margin_top", getPageMargin()[0]);
                }
                if (i==1){
                    json.addProperty("output_page_margin_bottom", getPageMargin()[1]);
                }
                if (i==2){
                    json.addProperty("output_page_margin_left", getPageMargin()[2]);
                }
                if (i==3){
                    json.addProperty("output_page_margin_right", getPageMargin()[3]);
                }
            }
        }
        if (getPageWidth()!=null){
            json.add("output_page_width", getPageWidth().getJSON()); //check this with Sunil
        }
        if (getPageHeight()!=null){
            json.add("output_page_height", getPageHeight().getJSON()); //check this with Sunil
        }
        if (getPageFormat()!=null){
            json.addProperty("output_page_format", getPageFormat());
        }
        if (getMerge()!=null){
            json.addProperty("output_merge", getMerge());
        }
        if (getLandscape()==true){
            json.addProperty("output_page_orientation", "landscape"); //this mises in the python sdk Sunil
        }
        return json;
    }
}
