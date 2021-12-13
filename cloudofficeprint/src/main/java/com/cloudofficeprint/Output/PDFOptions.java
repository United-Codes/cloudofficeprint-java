package com.cloudofficeprint.Output;

import com.google.gson.JsonObject;

/**
 * Class for all the optional PDF output options. Only for
 */
public class PDFOptions {

    private String readPassword;
    private String watermark;
    private Integer watermarkSize;
    private Integer watermarkOpacity;
    private String watermarkColor;
    private String watermarkFont;
    private String pageWidth;
    private String pageHeight;
    private Boolean evenPage;
    private Boolean mergeMakingEven;
    private String modifyPassword;
    private Integer passwordProtectionFlag;
    private Boolean lockForm;
    private Integer copies;
    private int[] pageMargin;
    private Boolean landscape;
    private String pageFormat;
    private Boolean merge;
    private String signCertificate;
    private String signCertificatePassword;
    private Boolean identifyFormFields;
    private Boolean split;
    private Boolean removeLastPage;

    /**
     * @return the password which is used to read the output.
     */
    public String getReadPassword() {
        return readPassword;
    }

    /**
     * Sets the password for reading the output.
     *
     * @param readPassword password to read the output.
     */
    public void setReadPassword(String readPassword) {
        this.readPassword = readPassword;
    }

    /**
     * @return the watermark which is shown diagonally on every page in output file.
     */
    public String getWatermark() {
        return watermark;
    }

    /**
     * Sets the watermark which is shown diagonally on every page in output file.
     *
     * @param watermark diagonal custom watermark
     */
    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    /**
     * @return opacity of watermark in percentage.
     */
    public Integer getWatermarkOpacity() {
        return watermarkOpacity;
    }

    /**
     * Sets opacity of your watermark in percentage (ex 60).
     *
     * @param watermarkOpacity opacity of watermark.
     */
    public void setWatermarkOpacity(Integer watermarkOpacity) {
        this.watermarkOpacity = watermarkOpacity;
    }

    /**
     * @return the font size of your watermark.
     */
    public Integer getWatermarkFontSize() {
        return watermarkSize;
    }

    /**
     * Sets the font size of your watermark.
     *
     * @param watermarkSize Font size of watermark.
     */
    public void setWatermarkFontSize(Integer watermarkSize) {
        this.watermarkSize = watermarkSize;
    }

    /**
     * Returns the color of your watermark. It accepts css fonts.
     * Default font is "black".
     *
     * @return font color of your watermark.
     */
    public String getWatermarkColor() {
        return watermarkColor;
    }

    /**
     * Sets the color of your watermark. It accepts css fonts.
     * Default font is "black"
     *
     * @param watermarkColor color of watermark.
     */
    public void setWatermarkColor(String watermarkColor) {
        this.watermarkColor = watermarkColor;
    }

    /**
     * @return the font of watermark. Default font is "Aerial".
     */
    public String getWatermarkFont() {
        return watermarkFont;
    }

    /**
     * Sets the font to your watermark. Default is "Aerial".
     *
     * @param watermarkFont font of watermark.
     */
    public void setWatermarkFont(String watermarkFont) {
        this.watermarkFont = watermarkFont;
    }

    /**
     * Only supported when converting HTML to PDF.
     *
     * @return pageWidth width followed by unit : px, mm, cm, in (e.g. : 20 px). No
     * unit means px.
     */
    public String getPageWidth() {
        return pageWidth;
    }

    /**
     * Sets the pageWidth.
     * Only supported when converting HTML to PDF.
     *
     * @param pageWidth width followed by unit : px, mm, cm, in (e.g. : 20 px). No
     *                  unit means px.
     */
    public void setPageWidth(String pageWidth) {
        this.pageWidth = pageWidth;
    }

    /**
     * Only supported when converting HTML to PDF.
     *
     * @return pageHeight height followed by unit : px, mm, cm, in (e.g. : 20 px).
     * No unit means px.
     */
    public String getPageHeight() {
        return pageHeight;
    }

    /**
     * Sets the  pageHeight.
     * Only supported when converting HTML to PDF.
     *
     * @param pageHeight height followed by unit : px, mm, cm, in (e.g. : 20 px). No unit means px.
     */
    public void setPageHeight(String pageHeight) {
        this.pageHeight = pageHeight;
    }

    /**
     * @return true if output will have even pages (blank page added if uneven
     * amount of pages).
     */
    public Boolean getEvenPage() {
        return evenPage;
    }

    /**
     * Sets whether the output will have even pages.(blank page added if uneven amount of pages).
     *
     * @param evenPage ture if the output should have even page.
     */
    public void setEvenPage(Boolean evenPage) {
        this.evenPage = evenPage;
    }

    /**
     * @return whether Cloud Office Print is going to merge all the append/prepend and
     * template files, making sure the output is even-paged (adding a blank page if the output is uneven-paged).
     */
    public Boolean getMergeMakingEven() {
        return mergeMakingEven;
    }

    /**
     * Sets whether Cloud Office Print is going to merge all the append/prepend and
     * template files, making sure the output is even-paged (adding a blank page if the output is uneven-paged).
     *
     * @param mergeMakingEven true if you want to merge.
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
     * Sets the value of password needed to modify the PDF.
     *
     * @param modifyPassword Password needed to modify the PDF.
     */
    public void setModifyPassword(String modifyPassword) {
        this.modifyPassword = modifyPassword;
    }

    /**
     * More info on the flag bits on
     * https://pdfhummus.com/post/147451287581/hummus-1058-and-pdf-writer-updates-encryption.
     *
     * @return protection flag for the PDF (in addition to the user password). (int
     * representation of the 12 flag bits)
     */
    public Integer getPasswordProtectionFlag() {
        return passwordProtectionFlag;
    }

    /**
     * Sets the protection flag for the PDF.
     * <p>
     * More info on the flag bits on
     * https://pdfhummus.com/post/147451287581/hummus-1058-and-pdf-writer-updates-encryption.
     *
     * @param passwordProtectionFlag protection flag for the PDF (in addition to the
     *                               user password). (int representation of the 12
     *                               flag bits)
     */
    public void setPasswordProtectionFlag(Integer passwordProtectionFlag) {
        this.passwordProtectionFlag = passwordProtectionFlag;
    }

    /**
     * @return If the output PDF will be locked/flattened.
     */
    public Boolean getLockForm() {
        return lockForm;
    }

    /**
     * Sets if the  output PDF will be locked/flattened.
     *
     * @param lockForm Set to true if you want the output PDF to be
     *                 locked/flattened.
     */
    public void setLockForm(Boolean lockForm) {
        this.lockForm = lockForm;
    }

    /**
     * Useful when user need multiple number of output copies
     *
     * @return Number of times the output need to be repeated.
     */
    public Integer getCopies() {
        return copies;
    }

    /**
     * Sets the  Number of times the output will be repeated. Useful when user need multiple number of output copies
     *
     * @param copies Number of times the output need to be repeated.
     */
    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    /**
     * Only supported when converting HTML to PDF.
     *
     * @return top bottom left right margin in pixels .
     */
    public int[] getPageMargin() {
        return pageMargin;
    }

    /**
     * Sets top bottom left right margin in pixels.
     * <p>
     * Only supported when converting HTML to PDF.
     *
     * @param pageMargins top bottom left right margin in pixels .
     * @throws Exception If not exact 4 margins are given.
     */
    public void setPageMargin(int[] pageMargins) throws Exception {
        if (pageMargins.length != 4) {
            throw new Exception("Please specify 4 margins.");
        }
        this.pageMargin = pageMargins;
    }

    /**
     * Sets same pageMargin for top, bottom, left and right.
     * <p>
     * Only supported when converting HTML to PDF.
     *
     * @param pageMargin Margin (same for all sides).
     */
    public void setPageMargin(int pageMargin) {
        this.pageMargin = new int[]{pageMargin, pageMargin, pageMargin, pageMargin};
    }

    /**
     * Returns whether to output PDF will have landscape orientation or not.
     * Only supported when converting HTML to PDF.
     *
     * @return True if orientation is landscape, false if orientation is portrait
     * (default used by server).
     */
    public Boolean getLandscape() {
        return landscape;
    }

    /**
     * Sets whether to output PDF will have landscape orientation or not.
     * Only supported when converting HTML to PDF.
     *
     * @param landscape Set to true if you want the orientation of the output to be
     *                  landscape, false for portrait (default used by server).
     */
    public void setLandscape(Boolean landscape) {
        this.landscape = landscape;
    }

    /**
     * @return The page format: "A4" (default used by Cloud Office Print) or
     * "letter".
     */
    public String getPageFormat() {
        return pageFormat;
    }

    /**
     * Sets the output(PDF) page format. ex "A4".
     * Only supported when converting HTML to PDF.
     *
     * @param pageFormat The page format: "A4" or "letter".
     */
    public void setPageFormat(String pageFormat) {
        this.pageFormat = pageFormat;
    }

    /**
     * @return True if instead of returning a zip file for multiple outputs,
     * they will be merged in one output.
     */
    public Boolean getMerge() {
        return merge;
    }

    /**
     * Sets whether to return a zip file of multiple output.
     *
     * @param merge Set to true if you want to instead of returning a zip file
     *              for multiple outputs, they will be merged in one output.
     */
    public void setMerge(Boolean merge) {
        this.merge = merge;
    }

    /**
     * @return The certificate (pkcs #12 .p12/.pfx) in a base64 encoded format (this
     * can also be a URL, FTP location or a location in the file system of
     * the server). If the output pdf has a signature.
     */
    public String getSignCertificate() {
        return signCertificate;
    }

    /**
     * Sets the signature value of output PDF if the output pdf has a signature
     * field.
     *
     * @param signCertificate The certificate (pkcs #12 .p12/.pfx) in a base64
     *                        encoded format (this can also be a URL, FTP location
     *                        or a location in the file system of the server).
     */
    public void setSignCertificate(String signCertificate) {
        this.signCertificate = signCertificate;
    }

    /**
     * @return password of certificate.
     */
    public String getSignCertificatePassword() {
        return signCertificatePassword;
    }

    /**
     * Sets the password for certificate.
     *
     * @param signCertificatePassword password of signature.
     */
    public void setSignCertificatePassword(String signCertificatePassword) {
        this.signCertificatePassword = signCertificatePassword;
    }

    /**
     * @return whether to get identityFormFields. If it is set to true Cloud Office
     * Print tries to identify the for fields and fills them in.
     */
    public Boolean getIdentifyFormFields() {
        return identifyFormFields;
    }

    /**
     * Sets whether to get identityFormFields. If it is set to true Cloud Office.
     * Print tries to identify the for fields and fills them in.
     *
     * @param identifyFormFields value for identify form fields.If it is set to true
     *                           Cloud Office Print tries to identify the form
     *                           fields and fills them in.
     */
    public void setIdentifyFormFields(Boolean identifyFormFields) {
        this.identifyFormFields = identifyFormFields;
    }

    /**
     * Returns whether to split or not. The output PDF should be split into one file per page in a zip file.
     *
     * @return whether to split or not. The output PDF should be split into one file
     * per page in a zip file.
     */
    public Boolean getSplit() {
        return split;
    }

    /**
     * Sets whether to split or not. The output PDF should be split into one file per page in a zip file.
     *
     * @param split whether to split or not. The output PDF should be split into one
     *              file per page in a zip file.
     */
    public void setSplit(Boolean split) {
        this.split = split;
    }

    /**
     * Returns whether to remove last page from output. It is useful when the last
     * page of output is blank.
     *
     * @return whether to remove last page or not
     */
    public Boolean getRemoveLastPage() {
        return removeLastPage;
    }

    /**
     * Sets whether to remove last page from output. It is useful when the last
     * page of output is blank.
     *
     * @param removeLastPage whether to remove last page
     */
    public void setRemoveLastPage(Boolean removeLastPage) {
        this.removeLastPage = removeLastPage;
    }

    /**
     * Constructor for the PDFOptions object. Set the options with the setters.
     * Uninitialized options won't be included in the JSON.
     */
    public PDFOptions() {
    }

    /**
     * @return JSON-representation of this object
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getReadPassword() != null) {
            json.addProperty("output_read_password", getReadPassword());
        }
        if (getWatermark() != null) {
            json.addProperty("output_watermark", getWatermark());
        }
        if (getWatermarkColor() != null) {
            json.addProperty("output_watermark_color", getWatermarkColor());
        }
        if (getWatermarkFontSize() != null) {
            json.addProperty("output_watermark_size", getWatermarkFontSize());
        }
        if (getWatermarkFont() != null) {
            json.addProperty("output_watermark_font", getWatermarkFont());
        }
        if (getWatermarkOpacity() != null) {
            json.addProperty("output_watermark_opacity", getWatermarkOpacity());
        }
        if (getPageWidth() != null) {
            json.addProperty("output_page_width", getPageWidth());
        }
        if (getPageHeight() != null) {
            json.addProperty("output_page_height", getPageHeight());
        }
        if (getEvenPage() != null) {
            json.addProperty("output_even_page", getEvenPage());
        }
        if (getMergeMakingEven() != null) {
            json.addProperty("output_merge_making_even", getMergeMakingEven());
        }
        if (getModifyPassword() != null) {
            json.addProperty("output_modify_password", getModifyPassword());
        }
        if (getPasswordProtectionFlag() != null) {
            json.addProperty("output_password_protection_flag", getPasswordProtectionFlag());
        }
        if (getLockForm() != null) {
            json.addProperty("lock_form", getLockForm());
        }
        if (getCopies() != null) {
            json.addProperty("output_copies", getCopies());
        }
        if (getPageMargin() != null) {
            JsonObject marginDict = new JsonObject();
            for (int i = 0; i < getPageMargin().length; i++) {
                if (i == 0) {
                    marginDict.addProperty("top", getPageMargin()[0]);
                }
                if (i == 1) {
                    marginDict.addProperty("bottom", getPageMargin()[1]);
                }
                if (i == 2) {
                    marginDict.addProperty("left", getPageMargin()[2]);
                }
                if (i == 3) {
                    marginDict.addProperty("right", getPageMargin()[3]);
                }
            }
            json.add("page_margin", marginDict); // For Cloud Office Print versions later than 21.1.1,
            // output_page_margin will also be
            // supported as tag name to be consistent with the other namings.
        }
        if (getPageFormat() != null) {
            json.addProperty("output_page_format", getPageFormat());
        }
        if (getMerge() != null) {
            json.addProperty("output_merge", getMerge());
        }
        if (getLandscape() != null && getLandscape()) {
            json.addProperty("page_orientation", "landscape"); // For Cloud Office Print versions later than 21.1.1,
            // output_page_orientation will also be supported as tag
            // name to be consistent with the other namings.
        }
        if (getSignCertificate() != null) {
            json.addProperty("output_sign_certificate", getSignCertificate());
        }
        if (getSignCertificatePassword() != null) {
            json.addProperty("output_sign_certificate_password", getSignCertificatePassword());
        }
        if (getIdentifyFormFields() != null) {
            json.addProperty("identify_form_fields", getIdentifyFormFields());
        }
        if (getSplit() != null) {
            json.addProperty("output_split", getSplit());
        }
        if (getRemoveLastPage() != null) {
            json.addProperty("output_remove_last_page", getRemoveLastPage());
        }
        return json;
    }
}
