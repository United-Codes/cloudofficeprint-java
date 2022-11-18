package com.cloudofficeprint.Output;

import com.cloudofficeprint.Output.CloudAcessToken.CloudAccessToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

/**
 * Class representing the output configuration of a request. The class only has
 * the Output() constructor, you need to use the set functions to populate this
 * object.
 */
public class Output {

    /**
     * This states what kind of output file type is required. It can be either the
     * same as template_type ("docx", "pptx", "xlsx", "html", "md"), "pdf" or any
     * other output file supported by libreoffice/openoffice. Special output type:
     * "onepagepdf", this will cause the output to be converted to pdf and all the
     * pages will be merged into one single page. Default : null (the type of the
     * template will be used).
     */
    private String type;

    /**
     * This states what kind of output encoding is wished for the output file. It
     * must be either "raw" or "base64". Default : raw.
     */
    private String encoding = "raw";

    /**
     * This states which software the server should use to convert the output to
     * pdf. The Cloud Office Print server uses LibreOffice. If you are running the
     * on premise version then the available values are : "officetopdf" (only when
     * server runs on Windows ) or "libreoffice" (Windows, Linux, OSX)
     * "libreoffice-standalone" or any other custom defined converters in the
     * aop_config.json file. Default : libreoffice.
     */
    private String converter = "libreoffice";

    /**
     * If you want to append file after each page of output you can set it to true.
     */
    private Boolean appendPerPage = null;
    /**
     * If you want to prepend file after each page of output you can set it to true.
     */
    private Boolean prependPerPage = null;
    /**
     * If you want to store the output on a cloud based service, a specific
     * CloudAccessToken object needs to be specified. Default : null.
     */
    private CloudAccessToken accessToken = null;

    /**
     * If you want to save the output on the server a directory on the server needs
     * to be specified. Default : null.
     */
    private String serverDirectory = null;

    /**
     * Optional PDF options. They are described in the PDFOptions class. Default :
     * null.
     */
    private PDFOptions PDFOptions = null;

    /**
     * Optional csv options. They are described in the CsvOptions class. Default :
     * null.
     */
    private CsvOptions CsvOptions = null;

    /**
     * a secret key can be specified to encrypt the file stored on the server (ussed with output polling).
     */
    private String SecretKey = null;
    /**
     * If it is set to true a unique link is sent back for each request which can be used later to download the output file.
     */
    private Boolean OutputPolling = null;
    /**
     *  AOP makes a call to the given option with response/output of the current request.
     */
    private RequestOption RequestOption = null;
    /**
     * @return the encoding to use for the output.
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * @return The file type as extension to use for the output.
     */
    public String getType() {
        return type;
    }

    /**
     * @return whether you want to append file after each page of output.
     */
    public Boolean getAppendPerPage() {
        return appendPerPage;
    }

    /**
     * @return whether you want to prepend file after each page of output.
     */
    public Boolean getPrependPerPage() {
        return prependPerPage;
    }
    /**
     * @return the accesstoken object of this output.
     */
    public CloudAccessToken getAccessToken() {
        return accessToken;
    }

    /**
     * @return the PDF converter for this output.
     */
    public String getConverter() {
        return converter;
    }

    /**
     * @return the PDFOptions object for this output.
     */
    public PDFOptions getPDFOptions() {
        return PDFOptions;
    }

    /**
     * @return the directory path on server for the output.
     */
    public String getServerDirectory() {
        return serverDirectory;
    }

    /**
     * @param encoding Encoding of the output. It must be either "raw" or "base64".
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * Sets the file type (extension) of the output to type.
     *
     * @param type extension for the output
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets appendPerPage to true if you want to append file after each page of output and false otherwise.
     *
     * @param appendPerPage whether to append file after each page of output.
     */
    public void setAppendPerPage(Boolean appendPerPage) {
        this.appendPerPage = appendPerPage;
    }

    /**
     * Sets prependPerPage to true if you want to prepend file after each page of output and false otherwise.
     *
     * @param prependPerPage whether to prepend file after each page of output.
     */
    public void setPrependPerPage(Boolean prependPerPage) {
        this.prependPerPage = prependPerPage;
    }
    /**
     * Sets the access token object of the output, if you want to store the output
     * on a cloud based service.
     *
     * @param accessToken for the output
     */
    public void setAccessToken(CloudAccessToken accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @param converter Sets which software the server should use to convert the
     *                  output to pdf. The Cloud Office Print server uses
     *                  LibreOffice. If you are running the on premise version then
     *                  the available values are : "officetopdf" (only when server
     *                  runs on Windows ) or "libreoffice" (Windows, Linux, OSX)
     *                  "libreoffice-standalone" or any other custom defined
     *                  converters in the aop_config.json file.
     */
    public void setConverter(String converter) {
        this.converter = converter;
    }

    /**
     * @param serverDirectory Directory path on server, if you want to save the
     *                        output on the server.
     */
    public void setServerDirectory(String serverDirectory) {
        this.serverDirectory = serverDirectory;
    }

    /**
     * @param PDFOptions PDF options object of this output. All the options are
     *                   described in the PDFOptions class.
     */
    public void setPDFOptions(PDFOptions PDFOptions) {
        this.PDFOptions = PDFOptions;
    }

    /**
     * @return the CsvOptions object for this output.
     */
    public CsvOptions getCsvOptions() {
        return this.CsvOptions;
    }

    /**
     * @param csvOptions Csv options object of this output. All the options are
     *                   described in the CsvOptions class.
     */
    public void setCsvOptions(CsvOptions csvOptions) {
        this.CsvOptions = csvOptions;
    }

    /**
     * Returns a secret key can be specified to encrypt the file stored on the server (used with output polling).
     * @return secretKey as a string.
     */
    public String getSecretKey(){
        return SecretKey;
    }

    /**
     * Sets a secret key can be specified to encrypt the file stored on the server (used with output polling).
     * @param secretKey as string.
     */
    public void setSecretKey(String secretKey){
        this.SecretKey = secretKey;
    }

    /**
     * Returns a unique link for each request is sent back which can be used later to download the output file.
     * @return boolean
     */
    public Boolean getOutputPolling(){
        return OutputPolling;
    }

    /**
     * A unique link for each request is sent back which can be used later to download the output file.
     * @param outputPolling boolean
     */
    public void setOutputPolling(Boolean outputPolling){
        this.OutputPolling = outputPolling;
    }

    /**
     * Returns option to which AOP makes a call to the given option with response/output of the current request.
     * @return requestOption as json object.
     */
    public RequestOption getRequestOption(){
        return RequestOption;
    }

    /**
     * Sets option to which AOP makes a call to the given option with response/output of the current request.
     * @param RequestOption as json object.
     */
    public void setRequestOption(RequestOption RequestOption){
        this.RequestOption = RequestOption;
    }

    /**
     * Constructor to create a populated output object. If you don't need to
     * instantiate some variables, use their default value as argument.
     *
     * @param filetype        This states what kind of output file type is required.
     *                        It can be either the same as template_type ("docx",
     *                        "pptx", "xlsx", "html", "md"), "pdf" or any other
     *                        output file supported by libreoffice/openoffice.
     *                        Special output type: "onepagepdf", this will cause the
     *                        output to be converted to pdf and all the pages will
     *                        be merged into one single page. Default : null (the
     *                        type of the template will be used).
     * @param encoding        This states what kind of output encoding is wished for
     *                        the output file. It must be either "raw" (bytes) or
     *                        "base64". Default : raw.
     * @param converter       This states which software the server should use to
     *                        convert the output to pdf. The Cloud Office Print
     *                        server uses LibreOffice. If you are running the on
     *                        premise version then the available values are :
     *                        "officetopdf" (only when server runs on Windows ) or
     *                        "libreoffice" (Windows, Linux, OSX)
     *                        "libreoffice-standalone" or any other custom defined
     *                        converters in the aop_config.json file. Default :
     *                        libreoffice.
     * @param appendPerPage   if you want to append file after each page of output
     *                        set appendPerPage to true and false otherwise.
     * @param prependPerPage  f you want to prepend file after each page of output
     *                        set prependPerPage to true and false otherwise.
     * @param token           If you want to store the output on a cloud based
     *                        service, a specific CloudAccessToken object needs to
     *                        be specified. Default : null.
     * @param serverDirectory If you want to save the output on the server a
     *                        directory on the server needs to be specified. Default
     *                        : null.
     * @param pdfOptions      Optional PDF options. They are described in the
     *                        PDFOptions class. Default : null.
     * @param csvOptions      Optional CSV options. They are described in the
     *                        CsvOptions class. Default : null.
     */
    public Output(String filetype, String encoding, String converter, Boolean appendPerPage, Boolean prependPerPage, CloudAccessToken token, String serverDirectory,
                  PDFOptions pdfOptions, CsvOptions csvOptions) {
        setType(filetype);
        setEncoding(encoding);
        setConverter(converter);
        setAppendPerPage(appendPerPage);
        setPrependPerPage(prependPerPage);
        setAccessToken(token);
        setServerDirectory(serverDirectory);
        setPDFOptions(pdfOptions);
        setCsvOptions(csvOptions);
    }

    /**
     * Constructor to create a populated output object. If you don't need to
     * instantiate some variables, use their default value as argument.
     *
     * @param filetype        This states what kind of output file type is required.
     *                        It can be either the same as template_type ("docx",
     *                        "pptx", "xlsx", "html", "md"), "pdf" or any other
     *                        output file supported by libreoffice/openoffice.
     *                        Special output type: "onepagepdf", this will cause the
     *                        output to be converted to pdf and all the pages will
     *                        be merged into one single page. Default : null (the
     *                        type of the template will be used).
     * @param encoding        This states what kind of output encoding is wished for
     *                        the output file. It must be either "raw" (bytes) or
     *                        "base64". Default : raw.
     * @param converter       This states which software the server should use to
     *                        convert the output to pdf. The Cloud Office Print
     *                        server uses LibreOffice. If you are running the on
     *                        premise version then the available values are :
     *                        "officetopdf" (only when server runs on Windows ) or
     *                        "libreoffice" (Windows, Linux, OSX)
     *                        "libreoffice-standalone" or any other custom defined
     *                        converters in the aop_config.json file. Default :
     *                        libreoffice.
     * @param token           If you want to store the output on a cloud based
     *                        service, a specific CloudAccessToken object needs to
     *                        be specified. Default : null.
     * @param serverDirectory If you want to save the output on the server a
     *                        directory on the server needs to be specified. Default
     *                        : null.
     * @param pdfOptions      Optional PDF options. They are described in the
     *                        PDFOptions class. Default : null.
     * @param csvOptions      Optional CSV options. They are described in the
     *                        CsvOptions class. Default : null.
     */

    public Output(String filetype, String encoding, String converter, CloudAccessToken token, String serverDirectory,
                  PDFOptions pdfOptions, CsvOptions csvOptions) {
        setType(filetype);
        setEncoding(encoding);
        setConverter(converter);
        setAccessToken(token);
        setServerDirectory(serverDirectory);
        setPDFOptions(pdfOptions);
        setCsvOptions(csvOptions);
    }

    /**
     * Constructor to create a populated output object. If you don't need to
     * instantiate some variables, use their default value as argument.
     *
     * @param filetype        This states what kind of output file type is required.
     *                        It can be either the same as template_type ("docx",
     *                        "pptx", "xlsx", "html", "md"), "pdf" or any other
     *                        output file supported by libreoffice/openoffice.
     *                        Special output type: "onepagepdf", this will cause the
     *                        output to be converted to pdf and all the pages will
     *                        be merged into one single page. Default : null (the
     *                        type of the template will be used).
     * @param encoding        This states what kind of output encoding is wished for
     *                        the output file. It must be either "raw" (bytes) or
     *                        "base64". Default : raw.
     * @param converter       This states which software the server should use to
     *                        convert the output to pdf. The Cloud Office Print
     *                        server uses LibreOffice. If you are running the on
     *                        premise version then the available values are :
     *                        "officetopdf" (only when server runs on Windows ) or
     *                        "libreoffice" (Windows, Linux, OSX)
     *                        "libreoffice-standalone" or any other custom defined
     *                        converters in the aop_config.json file. Default :
     *                        libreoffice.
     * @param token           If you want to store the output on a cloud based
     *                        service, a specific CloudAccessToken object needs to
     *                        be specified. Default : null.
     * @param serverDirectory If you want to save the output on the server a
     *                        directory on the server needs to be specified. Default
     *                        : null.
     * @param pdfOptions      Optional PDF options. They are described in the
     *                        PDFOptions class. Default : null.
     * @param csvOptions      Optional CSV options. They are described in the
     *                        CsvOptions class. Default : null.
     * @param secretKey       a secret key can be specified to encrypt the file
     *                        stored on the server (used with output polling).
     * @param outputPolling   a unique link for each request that is sent back,
     *                        which can be used later to download the output file.
     * @param requestOption    AOP makes a call to the given option with response/output of the current request.
     *
     */

    public Output(String filetype, String encoding, String converter, CloudAccessToken token, String serverDirectory,
                  PDFOptions pdfOptions, CsvOptions csvOptions,String secretKey, Boolean outputPolling, RequestOption requestOption) {
        setType(filetype);
        setEncoding(encoding);
        setConverter(converter);
        setAccessToken(token);
        setServerDirectory(serverDirectory);
        setPDFOptions(pdfOptions);
        setCsvOptions(csvOptions);
        setSecretKey(secretKey);
        setOutputPolling(outputPolling);
        setRequestOption(requestOption);
    }
    /**
     * @return JSONObject with the tags for the output for the Cloud Office Print
     * server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getType() != null) {
            json.addProperty("output_type", getType());
        }
        if (getEncoding() != null) {
            json.addProperty("output_encoding", getEncoding());
        }
        if (getConverter() != null) {
            json.addProperty("output_converter", getConverter());
        }
        if (getAppendPerPage() != null) {
            json.addProperty("output_append_per_page", getAppendPerPage());
        }
        if (getPrependPerPage() != null) {
            json.addProperty("output_prepend_per_page", getPrependPerPage());
        }
        if (getAccessToken() != null) {
            for (Map.Entry<String, JsonElement> tag : getAccessToken().getJSON().entrySet()) {
                json.add(tag.getKey(), tag.getValue()); // these tags need to be at output level
            }
        }
        if (getServerDirectory() != null) {
            json.addProperty("output_directory", getServerDirectory());
        }
        if (getPDFOptions() != null) {
            for (Map.Entry<String, JsonElement> tag : getPDFOptions().getJSON().entrySet()) {
                json.add(tag.getKey(), tag.getValue()); // these tags need to be at output level
            }
        }
        if (getCsvOptions() != null) {
            for (Map.Entry<String, JsonElement> tag : getCsvOptions().getJSON().entrySet()) {
                json.add(tag.getKey(), tag.getValue()); // these tags need to be at output level
            }
        }
        if (getSecretKey() != null){
            json.addProperty("secret_key",getSecretKey());
        }
        if (getOutputPolling() != null){
            json.addProperty("output_polling",getOutputPolling());
        }
        if (getRequestOption() != null) {
            JsonObject reqOption = new JsonObject();
            for (Map.Entry<String, JsonElement> tag : getRequestOption().getJSON().entrySet()){
                reqOption.add(tag.getKey(),tag.getValue());
            }
            json.add("request_option",reqOption);
        }
        return json;
    }
}
