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
     * Optional request option. If specified then the Cloud Office Print server makes a call to the given option
     * with response of the current print job.
     */
    private RequestOption requestOption;

    /**
     * If true, the Cloud Office Print server will generate a unique link for each request which can be used later to
     * download the output file.
     */
    private Boolean polling;

    /**
     * Used when polling is true. An optional secret key to encrypt the file stored on the server.
     */
    private String secretKey;

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
     * @return request option object for this output.
     */
    public RequestOption getRequestOption() {
        return requestOption;
    }

    /**
     * @param requestOption request option object for this output.
     */
    public void setRequestOption(RequestOption requestOption) {
        this.requestOption = requestOption;
    }

    /**
     * @return whether polling is enabled.
     */
    public Boolean getPolling() {
        return polling;
    }

    /**
     * @param polling whether polling is enabled.
     */
    public void setPolling(Boolean polling) {
        this.polling = polling;
    }

    /**
     * @return secret key used to encrypt the polled print job.
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * @param secretKey secret key used to encrypt the polled print job.
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Output(){

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
     * @return JSONObject with the tags for the output for the Cloud Office Print
     *         server.
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
        if (getRequestOption() != null) {
            json.add("request_option", getRequestOption().getJSON());
        }
        if (getPolling() != null) {
            json.addProperty("output_polling", getPolling());
        }
        if (getSecretKey() != null) {
            json.addProperty("secret_key", getSecretKey());
        }

        return json;
    }

}
