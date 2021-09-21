package com.cloudofficeprint.Output;

import com.google.gson.JsonObject;

import java.io.*;
import java.nio.file.Files;
import java.util.Base64;

/**
 * Class for all the optional PDF output options. Only for
 */
public class PDFOptions {

    private Boolean evenPage;
    private Boolean mergeMakingEven;
    private Boolean removeLastPage;
    private String modifyPassword;
    private String readPassword;
    private Integer passwordProtectionFlag;
    private String watermark;
    private String watermarkColor;
    private String watermarkFont;
    private Integer watermarkOpacity;
    private Integer watermarkSize;
    private Boolean lockForm;
    private Integer copies;
    private int[] pageMargin;
    private Boolean landscape;
    private String pageWidth;
    private String pageHeight;
    private String pageFormat;
    private Boolean merge;
    private Boolean split;
    private Boolean identifyFormFields;
    private String signCertificate;
    private String signCertificatePassword;

    /**
     * Constructor for the PDFOptions object. Set the options with the setters.
     * Uninitialized options won't be included in the JSON.
     */
    public PDFOptions() {
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
     * @return If Cloud Office Print is going to merge all the append/prepend and
     *         template files, making sure the output is even-paged (adding a blank
     *         page if the output is uneven-paged).
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
     * @return Remove the last page from the given PDF document.
     */
    public Boolean getRemoveLastPage() {
        return removeLastPage;
    }

    /**
     * @param removeLastPage Remove the last page from the given PDF document
     */
    public void setRemoveLastPage(Boolean removeLastPage) {
        this.removeLastPage = removeLastPage;
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
     * Set a diagonal custom watermark on every page in the PDF file with a specific
     * text, color, font, opacity and size. Setting all to null will remove the
     * watermark.
     * 
     * @param text    specifies the text of the watermark.
     * @param color   specifies the color of the watermark, with a default of
     *                "black".
     * @param font    specifies the font of the watermark, with a default of
     *                "Arial".
     * @param opacity specifies the opacity of the watermark, should be as a
     *                percentage, i.e. 45.
     * @param size    specifies the size of the watermark, should be as a number in
     *                px, i.e. 45.
     */
    public void setWatermark(String text, String color, String font, Integer opacity, Integer size) {
        this.watermark = text;
        this.watermarkColor = color;
        this.watermarkFont = font;
        this.watermarkOpacity = opacity;
        this.watermarkSize = size;
    }

    /**
     * @return color of the watermark, defaults to "black".
     */
    public String getWatermarkColor() {
        return watermarkColor;
    }

    /**
     * @param watermarkColor color of the watermark, defaults to "black".
     */
    public void setWatermarkColor(String watermarkColor) {
        this.watermarkColor = watermarkColor;
    }

    /**
     * @return font of the watermark, defaults to "Arial".
     */
    public String getWatermarkFont() {
        return watermarkFont;
    }

    /**
     * @param watermarkFont font of the watermark, defaults to "Arial".
     */
    public void setWatermarkFont(String watermarkFont) {
        this.watermarkFont = watermarkFont;
    }

    /**
     * @return opacity of the watermark, as a percentage, i.e. 45.
     */
    public Integer getWatermarkOpacity() {
        return watermarkOpacity;
    }

    /**
     * @param watermarkOpacity opacity of the watermark, as a percentage, i.e. 45.
     */
    public void setWatermarkOpacity(Integer watermarkOpacity) {
        this.watermarkOpacity = watermarkOpacity;
    }

    /**
     * @return size of the watermark, as a number in px, i.e. 45.
     */
    public Integer getWatermarkSize() {
        return watermarkSize;
    }

    /**
     * @param watermarkSize size of the watermark, as a number in px, i.e. 45.
     */
    public void setWatermarkSize(Integer watermarkSize) {
        this.watermarkSize = watermarkSize;
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
     * The page orientation, portrait or landscape.
     * 
     * @return The page orientation, portrait or landscape.
     */
    public String getPageOrientation() {
        return landscape ? "landscape" : "portrait";
    }

    /**
     * The page orientation, portrait or landscape,
     * 
     * @param orientation The page orientation, portrait or landscape.
     */
    public void setPageOrientation(String orientation) {
        this.landscape = orientation == "landscape";
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
     * Only supported when converting HTML to PDF.
     * 
     * @return The page format: "A4" (default used by Cloud Office Print) or
     *         "letter".
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
     * @return If it is set to true Cloud Office Print tries to identify the form
     *         fields and fills them in.
     */
    public Boolean getIdentifyFormFields() {
        return identifyFormFields;
    }

    /**
     * @param identifyFormFields If it is set to true Cloud Office Print tries to
     *                           identify the form fields and fills them in.
     */
    public void setIdentifyFormFields(Boolean identifyFormFields) {
        this.identifyFormFields = identifyFormFields;
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
     * @return The password of the certificate file as a plain string.
     */
    public String getSignCertificatePassword() {
        return signCertificatePassword;
    }

    /**
     * @param signCertificatePassword The password of the certificate file as a
     *                                plain string.
     */
    public void setSignCertificatePassword(String signCertificatePassword) {
        this.signCertificatePassword = signCertificatePassword;
    }

    /**
     * Sign the output PDF with a local certificate file.
     * 
     * @param localCertificatePath path to the local certificate file.
     * @throws IOException
     */
    public void sign(String localCertificatePath) throws IOException {
        File file = new File(localCertificatePath);
        byte[] bytes = Files.readAllBytes(file.toPath());
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        this.signCertificate = encodedString;
    }

    /**
     * Sign the output PDF with a local certificate file.
     * 
     * @param localCertificatePath path to the local certificate file.
     * @param password             password of the certificate.
     * @throws IOException
     */
    public void sign(String localCertificatePath, String password) throws IOException {
        sign(localCertificatePath);
        this.signCertificatePassword = password;
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
        if (getWatermarkFont() != null) {
            json.addProperty("output_watermark_font", getWatermarkFont());
        }
        if (getWatermarkOpacity() != null) {
            json.addProperty("output_watermark_opacity", getWatermarkOpacity());
        }
        if (getWatermarkSize() != null) {
            json.addProperty("output_watermark_size", getWatermarkSize());
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
            // For Cloud Office Print versions later than 21.1.1, output_page_margin will
            // also be supported as tag name to be consistent with the other namings.
            json.add("page_margin", marginDict);
        }
        if (getPageFormat() != null) {
            json.addProperty("output_page_format", getPageFormat());
        }
        if (getMerge() != null) {
            json.addProperty("output_merge", getMerge());
        }
        if (getLandscape() != null && getLandscape() == true) {
            // For Cloud Office Print versions later than 21.1.1, output_page_orientation
            // will also be supported as tag name to be consistent with the other namings.
            json.addProperty("page_orientation", "landscape");
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
