package com.CloudOfficePrint.Output;

import com.google.gson.JsonObject;

/**
 * Class for all the optional PDF output options. Only for
 */
public class PDFOptions {

    private String readPassword;
    private String watermark;
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
    private Boolean identifyFormFields;
    private Boolean split;

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
     * Only supported when converting HTML to PDF.
     * 
     * @return pageWidth width followed by unit : px, mm, cm, in (e.g. : 20 px). No
     *         unit means px.
     */
    public String getPageWidth() {
        return pageWidth;
    }

    /**
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
     *         No unit means px.
     */
    public String getPageHeight() {
        return pageHeight;
    }

    /**
     * Only supported when converting HTML to PDF.
     * 
     * @param pageHeight eight followed by unit : px, mm, cm, in (e.g. : 20 px). No
     *                   unit means px.
     */
    public void setPageHeight(String pageHeight) {
        this.pageHeight = pageHeight;
    }

    /**
     * @return true if output will have even pages (blank page added if uneven
     *         amount of pages).
     */
    public Boolean getEvenPage() {
        return evenPage;
    }

    /**
     * @param evenPage Whether output has even pages (blank page added if uneven
     *                 amount of pages).
     */
    public void setEvenPage(Boolean evenPage) {
        this.evenPage = evenPage;
    }

    /**
     * @return If AOP is going to merge all the append/prepend and template files,
     *         making sure the output is even-paged (adding a blank page if the
     *         output is uneven-paged).
     */
    public Boolean getMergeMakingEven() {
        return mergeMakingEven;
    }

    /**
     * @param mergeMakingEven Whether you want to merge all the append/prepend and
     *                        template files, making sure the output is even-paged
     *                        (adding a blank page if the output is uneven-paged).
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
     *         representation of the 12 flag bits)
     */
    public Integer getPasswordProtectionFlag() {
        return passwordProtectionFlag;
    }

    /**
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
     * @param lockForm Set to true if you want the output PDF to be
     *                 locked/flattened.
     */
    public void setLockForm(Boolean lockForm) {
        this.lockForm = lockForm;
    }

    /**
     * @return Number of times the output will be repeated.
     */
    public Integer getCopies() {
        return copies;
    }

    /**
     * @param copies Amount of times the output will be repeated.
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
     * Only supported when converting HTML to PDF.
     * 
     * @param pageMargin Margin (same for all sides).
     */
    public void setPageMargin(int pageMargin) {
        this.pageMargin = new int[] { pageMargin, pageMargin, pageMargin, pageMargin };
    }

    /**
     * Only supported when converting HTML to PDF.
     * 
     * @return True if orientation is landscape, false if orientation is portrait
     *         (default used by server).
     */
    public Boolean getLandscape() {
        return landscape;
    }

    /**
     * Only supported when converting HTML to PDF.
     * 
     * @param landscape Set to true if you want the orientation of the output to be
     *                  landscape, false for portrait (default used by server).
     */
    public void setLandscape(Boolean landscape) {
        this.landscape = landscape;
    }

    /**
     * Only supported when converting HTML to PDF.
     * 
     * @return The page format: "A4" (default used by AOP) or "letter".
     */
    public String getPageFormat() {
        return pageFormat;
    }

    /**
     * Only supported when converting HTML to PDF.
     * 
     * @param pageFormat The page format: "A4" or "letter".
     */
    public void setPageFormat(String pageFormat) {
        this.pageFormat = pageFormat;
    }

    /**
     * @return True if instead of returning back a zip file for multiple outputs,
     *         they will be merged in one output.
     */
    public Boolean getMerge() {
        return merge;
    }

    /**
     * @param merge Set to true if you want to instead of returning back a zip file
     *              for multiple outputs, they will be merged in one output.
     */
    public void setMerge(Boolean merge) {
        this.merge = merge;
    }

    /**
     * It is possible to sign the output PDF if the output pdf has a signature
     * field.
     * 
     * @return The certificate (pkcs #12 .p12/.pfx) in a base64 encoded format (this
     *         can also be a URL, FTP location or a location in the file system of
     *         the server).
     */
    public String getSignCertificate() {
        return signCertificate;
    }

    /**
     * It is possible to sign the output PDF if the output pdf has a signature
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
     * @return If it is set to true AOP tries to identify the form fields and fills
     *         them in.
     */
    public Boolean getIdentifyFormFields() {
        return identifyFormFields;
    }

    /**
     * @param identifyFormFields If it is set to true AOP tries to identify the form
     *                           fields and fills them in.
     */
    public void setIdentifyFormFields(Boolean identifyFormFields) {
        this.identifyFormFields = identifyFormFields;
    }

    /**
     * @return whether or not the output PDF should be split into one file per page
     *         in a zip file
     */
    public Boolean getSplit() {
        return split;
    }

    /**
     * @param split whether or not the output PDF should be split into one file per
     *              page in a zip file
     */
    public void setSplit(Boolean split) {
        this.split = split;
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
            json.add("page_margin", marginDict); // For AOP versions later than 21.1.1, output_page_margin will also be
                                                 // supported as tag name to be consistent with the other namings.
        }
        if (getPageFormat() != null) {
            json.addProperty("output_page_format", getPageFormat());
        }
        if (getMerge() != null) {
            json.addProperty("output_merge", getMerge());
        }
        if (getLandscape() != null && getLandscape() == true) {
            json.addProperty("page_orientation", "landscape"); // For AOP versions later than 21.1.1,
                                                               // output_page_orientation will also be supported as tag
                                                               // name to be consistent with the other namings.
        }
        if (getSignCertificate() != null) {
            json.addProperty("output_sign_certificate", getSignCertificate());
        }
        if (getIdentifyFormFields() != null) {
            json.addProperty("identify_form_fields", getIdentifyFormFields());
        }
        if (getSplit() != null) {
            json.addProperty("output_split", getSplit());
        }
        return json;
    }
}
