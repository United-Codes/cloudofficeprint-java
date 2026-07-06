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
    private Integer watermarkRotation;
    private String imageWatermark;
    private Integer imageWatermarkOpacity;
    private Integer imageWatermarkRotation;
    private Integer imageWatermarkWidth;
    private Integer imageWatermarkHeight;
    private Boolean compressPdf;
    private Integer splitByPage;
    private String splitByString;
    private Boolean splitAfterString;
    private String pdfProducer;
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
    private String signCertificateTxt;
    private String convertToPdfa;
    private String complyPdfaLevel;
    private String validatePdfaLevel;
    private String uaCompliantPdf;
    private String attachmentName;
    private Boolean convertAttachmentToJson;
    private Boolean insertBarcode;
    private String pageNumberStartAt;
    private String batchSelector;
    private Integer batchSize;
    private String batchCondition;

    /**
     * Constructor for the PDFOptions object. Set the options with the setters.
     * Uninitialized options won't be included in the JSON.
     */
    public PDFOptions() {
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
     * Sets the value of password needed to modify the PDF.
     *
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
     * representation of the 12 flag bits)
     */
    public Integer getPasswordProtectionFlag() {
        return passwordProtectionFlag;
    }

    /**
     * Sets the protection flag for the PDF.
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
     * @return The batch selector path as a string.
     */
    public  String getBatchSelector() { return batchSelector;}
    /**
     * @param batchSelector The JSON path to the array (e.g., "orders:products").
     */
    public void setBatchSelector(String batchSelector) {
        this.batchSelector = batchSelector;
    }
    /**
     * @return The batch size as an integer.
     */
    public  Integer getBatchSize() { return batchSize;}
    /**
     * @param batchSize The number per batch
     */
    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }
    /**
     * @return The batch condition as a string
     */
    public  String getBatchCondition() { return batchCondition;}
    /**
     * @param batchCondition The condition (e.g., "unit_price > 100").
     */
    public void setBatchCondition(String batchCondition) {
        this.batchCondition = batchCondition;
    }

    /**
     * Set a diagonal custom watermark on every page in the PDF file with a specific
     * text, color, font, opacity and size. Setting all to null will remove the
     * watermark.
     *
     * @param text     specifies the text of the watermark.
     * @param color    specifies the color of the watermark, with a default of
     *                 "black".
     * @param font     specifies the font of the watermark, with a default of
     *                 "Arial".
     * @param opacity  specifies the opacity of the watermark, should be as a
     *                 percentage, i.e. 45.
     * @param size     specifies the size of the watermark, should be as a number in
     *                 px, i.e. 45.
     */
    public void setWatermark(String text, String color, String font, Integer opacity, Integer size) {
        setWatermark(text, color, font, opacity, size, null);
    }

    /**
     * Set a diagonal custom watermark on every page in the PDF file with a specific
     * text, color, font, opacity and size. Setting all to null will remove the
     * watermark.
     * 
     * @param text     specifies the text of the watermark.
     * @param color    specifies the color of the watermark, with a default of
     *                 "black".
     * @param font     specifies the font of the watermark, with a default of
     *                 "Arial".
     * @param opacity  specifies the opacity of the watermark, should be as a
     *                 percentage, i.e. 45.
     * @param size     specifies the size of the watermark, should be as a number in
     *                 px, i.e. 45.
     * @param rotation specifies the angle to rotate the watermark, should be as a number in
     *                 px i.e. 45.
     */
    public void setWatermark(String text, String color, String font, Integer opacity, Integer size, Integer rotation) {
        this.watermark = text;
        this.watermarkColor = color;
        this.watermarkFont = font;
        this.watermarkOpacity = opacity;
        this.watermarkSize = size;
        this.watermarkRotation = rotation;
    }

    /**
     * @return the image watermark
     */
    public String getImageWatermark() {
        return imageWatermark;
    }

    /**
     * @param imageWatermark the image watermark
     */
    public void setImageWatermark(String imageWatermark) {
        this.imageWatermark = imageWatermark;
    }

    /**
     * @return opacity of the image watermark, as a percentage, i.e. 45.
     */
    public Integer getImageWatermarkOpacity() {
        return imageWatermarkOpacity;
    }

    /**
     * @param imageWatermarkOpacity opacity of the image watermark, as a percentage, i.e. 45.
     */
    public void setImageWatermarkOpacity(Integer imageWatermarkOpacity) {
        this.imageWatermarkOpacity = imageWatermarkOpacity;
    }

    /**
     * @return angle to rotate the image watermark, in degrees.
     */
    public Integer getImageWatermarkRotation() {
        return imageWatermarkRotation;
    }

    /**
     * @param imageWatermarkRotation angle to rotate the image watermark, in degrees.
     */
    public void setImageWatermarkRotation(Integer imageWatermarkRotation) {
        this.imageWatermarkRotation = imageWatermarkRotation;
    }

    /**
     * @return width of the image watermark in px.
     */
    public Integer getImageWatermarkWidth() {
        return imageWatermarkWidth;
    }

    /**
     * @param imageWatermarkWidth width of the image watermark in px.
     */
    public void setImageWatermarkWidth(Integer imageWatermarkWidth) {
        this.imageWatermarkWidth = imageWatermarkWidth;
    }

    /**
     * @return height of the image watermark in px.
     */
    public Integer getImageWatermarkHeight() {
        return imageWatermarkHeight;
    }

    /**
     * @param imageWatermarkHeight height of the image watermark in px.
     */
    public void setImageWatermarkHeight(Integer imageWatermarkHeight) {
        this.imageWatermarkHeight = imageWatermarkHeight;
    }

    /**
     * @return whether the PDF file size is compressed.
     */
    public Boolean getCompressPdf() {
        return compressPdf;
    }

    /**
     * @param compressPdf compresses the file size of the PDF. Only for PDF output.
     */
    public void setCompressPdf(Boolean compressPdf) {
        this.compressPdf = compressPdf;
    }

    /**
     * @return the number of pages per split output file.
     */
    public Integer getSplitByPage() {
        return splitByPage;
    }

    /**
     * @param splitByPage splits the output into a file per given number of pages. Only for PDF output.
     */
    public void setSplitByPage(Integer splitByPage) {
        this.splitByPage = splitByPage;
    }

    /**
     * @return the string that the output is split on.
     */
    public String getSplitByString() {
        return splitByString;
    }

    /**
     * @param splitByString splits the output into a separate file on each page where the given string is found. Only for PDF output.
     */
    public void setSplitByString(String splitByString) {
        this.splitByString = splitByString;
    }

    /**
     * @return whether to split after the matching page instead of before it.
     */
    public Boolean getSplitAfterString() {
        return splitAfterString;
    }

    /**
     * @param splitAfterString when using splitByString, split after the matching page instead of before it.
     */
    public void setSplitAfterString(Boolean splitAfterString) {
        this.splitAfterString = splitAfterString;
    }

    /**
     * @return the producer metadata tag of the PDF.
     */
    public String getPdfProducer() {
        return pdfProducer;
    }

    /**
     * @param pdfProducer sets the producer metadata tag of the PDF. Only for PDF output.
     */
    public void setPdfProducer(String pdfProducer) {
        this.pdfProducer = pdfProducer;
    }

    /**
     * Set an image watermark on every page in the PDF file. Only for PDF output.
     *
     * @param image    the image as a  WaterMark
     * @param opacity  opacity of the image watermark, as a percentage, i.e. 45.
     * @param rotation angle to rotate the image watermark, in degrees.
     * @param width    width of the image watermark in px.
     * @param height   height of the image watermark in px.
     */
    public void setImageWatermark(String image, Integer opacity, Integer rotation, Integer width, Integer height) {
        this.imageWatermark = image;
        this.imageWatermarkOpacity = opacity;
        this.imageWatermarkRotation = rotation;
        this.imageWatermarkWidth = width;
        this.imageWatermarkHeight = height;
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
     *
     * @return angle to rotate the watermark
     */
    public Integer getWatermarkRotation() { return watermarkRotation; }

    /**
     * @param watermarkRotation angle to rotate the watermark, as a number in px, i.e. 45.
     */
    public void setWatermarkRotation(Integer watermarkRotation) {
        this.watermarkRotation = watermarkRotation;
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
     * Useful when user needs multiple number of output copies
     *
     * @return Number of times the output need to be repeated.
     */
    public Integer getCopies() {
        return copies;
    }

    /**
     * Sets the  Number of times the output will be repeated. Useful when user needs multiple number of output copies
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
     * @return Custom text to add in signature field
     */
    public String getSignCertificateTxt() { return  signCertificateTxt; }

    /**
     *
     * @param signCertificateTxt The text to add
     */
    public void setSignCertificateTxt(String signCertificateTxt) {
        this.signCertificateTxt = signCertificateTxt;
    }

    /**
     * @return whether the output pdf should be converted to pdf/a format
     */
    public String getConvertToPdfa() { return convertToPdfa; }

    /**
     * @param convertToPdfa the variants of PDF/A specification (e.g., 1a, 2b).
     */
    public void setConvertToPdfa(String convertToPdfa) {
        this.convertToPdfa = convertToPdfa;
    }
    /**
     * @return the PDF/A compliance level (e.g. pdfa1a, pdfa1b, pdfa2b, ...)
     */
    public String getComplyPdfaLevel() {
        return complyPdfaLevel;
    }

    /**
     * @param complyPdfaLevel the PDF/A standard to comply to (e.g. pdfa1a, pdfa1b, pdfa2a)
     */
    public void setComplyPdfaLevel(String complyPdfaLevel) {
        this.complyPdfaLevel = complyPdfaLevel;
    }

    /**
     * @return the PDF/A level to validate against.
     */
    public String getValidatePdfaLevel() {
        return validatePdfaLevel;
    }

    /**
     * @param validatePdfaLevel the PDF/A standard to validate against (e.g. pdfa1a, pdfa1b, pdfa2a,)
     */
    public void setValidatePdfaLevel(String validatePdfaLevel) {
        this.validatePdfaLevel = validatePdfaLevel;
    }

    /**
     * @return whether the output is generated as a UA compliant PDF.
     */
    public String getUaCompliantPdf() {
        return uaCompliantPdf;
    }

    /**
     * @param uaCompliantPdf generate a UA  compliant PDF.
     */
    public void setUaCompliantPdf(String uaCompliantPdf) {
        this.uaCompliantPdf = uaCompliantPdf;
    }

    /**
     * @return  retrieve specific attachment. output_type must be 'get_attachments'.
     */
    public String getAttachmentName() { return attachmentName; }

    /**
     * @param attachmentName name of attachment
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    /**
     * @return retrieve data of the XML attachment as a JSON. output_type must be 'get_attachments'.
     */
    public Boolean getConvertAttachmentToJson() { return convertAttachmentToJson; }

    /**
     * @param convertAttachmentToJson true or false
     */
    public void setConvertAttachmentToJson(Boolean convertAttachmentToJson) {
        this.convertAttachmentToJson = convertAttachmentToJson;
    }

    /**
     *
     * @return whether to insert barcode in pdf
     */
    public Boolean getInsertBarcode() { return insertBarcode; }

    /**
     *
     * @param insertBarcode true or false
     */
    public void setInsertBarcode(Boolean insertBarcode) { this.insertBarcode = insertBarcode; }

    /**
     * Returns start page number
     * @return String
     */
    public String getPageNumberStartAt() { return pageNumberStartAt; }

    /**
     *
     * @param pageNumberStartAt String
     */
    public void setPageNumberStartAt(String pageNumberStartAt) {
        this.pageNumberStartAt = pageNumberStartAt;
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
        if (getEvenPage() != null) {
            json.addProperty("output_even_page", getEvenPage());
        }
        if (getMergeMakingEven() != null) {
            json.addProperty("output_merge_making_even", getMergeMakingEven());
        }
        if (getRemoveLastPage() != null) {
            json.addProperty("output_remove_last_page", getRemoveLastPage());
        }
        if (getModifyPassword() != null) {
            json.addProperty("output_modify_password", getModifyPassword());
        }
        if (getReadPassword() != null) {
            json.addProperty("output_read_password", getReadPassword());
        }
        if (getPasswordProtectionFlag() != null) {
            json.addProperty("output_password_protection_flag", getPasswordProtectionFlag());
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
        if (getWatermarkRotation() != null) {
            json.addProperty("output_watermark_rotation", getWatermarkRotation());
        }
        if (getImageWatermark() != null) {
            json.addProperty("output_watermark_image", getImageWatermark());
        }
        if (getImageWatermarkOpacity() != null) {
            json.addProperty("output_watermark_image_opacity", getImageWatermarkOpacity());
        }
        if (getImageWatermarkRotation() != null) {
            json.addProperty("output_watermark_image_rotation", getImageWatermarkRotation());
        }
        if (getImageWatermarkWidth() != null) {
            json.addProperty("output_watermark_image_width", getImageWatermarkWidth());
        }
        if (getImageWatermarkHeight() != null) {
            json.addProperty("output_watermark_image_height", getImageWatermarkHeight());
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
        if (getLandscape() != null && getLandscape() == true) {
            // For Cloud Office Print versions later than 21.1.1, output_page_orientation
            // will also be supported as tag name to be consistent with the other namings.
            json.addProperty("page_orientation", "landscape");
        }
        if (getPageWidth() != null) {
            json.addProperty("output_page_width", getPageWidth());
        }
        if (getPageHeight() != null) {
            json.addProperty("output_page_height", getPageHeight());
        }
        if (getPageFormat() != null) {
            json.addProperty("output_page_format", getPageFormat());
        }
        if (getMerge() != null) {
            json.addProperty("output_merge", getMerge());
        }
        if (getSplit() != null) {
            json.addProperty("output_split", getSplit());
        }
        if (getSignCertificatePassword() != null) {
            json.addProperty("output_sign_certificate_password", getSignCertificatePassword());
        }
        if (getIdentifyFormFields() != null) {
            json.addProperty("identify_form_fields", getIdentifyFormFields());
        }
        if (getSignCertificate() != null) {
            json.addProperty("output_sign_certificate", getSignCertificate());
        }
        if (getSignCertificatePassword() != null) {
            json.addProperty("output_sign_certificate_password", getSignCertificatePassword());
        }
        if (getSignCertificateTxt() != null) {
            json.addProperty("output_sign_certificate_txt", getSignCertificateTxt());
        }
        if (getRemoveLastPage() != null) {
            json.addProperty("output_remove_last_page", getRemoveLastPage());
        }
        if (getConvertToPdfa() != null) {
            json.addProperty("output_convert_to_pdfa", getConvertToPdfa());
        }
        if (getComplyPdfaLevel() != null) {
            json.addProperty("output_comply_pdfa_level", getComplyPdfaLevel());
        }
        if (getValidatePdfaLevel() != null) {
            json.addProperty("output_validate_pdfa_level", getValidatePdfaLevel());
        }
        if (getUaCompliantPdf() != null) {
            json.addProperty("output_ua_compliant_pdf", getUaCompliantPdf());
        }
        if (getCompressPdf() != null) {
            json.addProperty("output_compress_pdf", getCompressPdf());
        }
        if (getSplitByPage() != null) {
            json.addProperty("output_split_by_page", getSplitByPage());
        }
        if (getSplitByString() != null) {
            json.addProperty("output_split_by_string", getSplitByString());
        }
        if (getSplitAfterString() != null) {
            json.addProperty("output_split_after_string", getSplitAfterString());
        }
        if (getPdfProducer() != null) {
            json.addProperty("output_pdf_producer", getPdfProducer());
        }
        if (getAttachmentName() != null) {
            json.addProperty("output_attachment_name", getAttachmentName());
        }
        if (getConvertAttachmentToJson() != null) {
            json.addProperty("output_convert_attachment_to_json", getConvertAttachmentToJson());
        }
        if (getInsertBarcode() != null) {
            json.addProperty("output_insert_barcode", getInsertBarcode());
        }
        if (getPageNumberStartAt() != null) {
            json.addProperty("output_page_number_start_at", getPageNumberStartAt());
        }
        if (getBatchSelector() != null){
            json.addProperty("batch_selector",getBatchSelector());
        }
        if (getBatchSize() != null){
            json.addProperty("batch_size",getBatchSize());
        }
        if (getBatchCondition() != null){
            json.addProperty("batch_condition", getBatchCondition());
        }
        return json;
    }
}
