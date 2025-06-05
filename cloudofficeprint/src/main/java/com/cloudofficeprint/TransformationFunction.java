package com.cloudofficeprint;

import com.google.gson.JsonPrimitive;

public class TransformationFunction {
    private String jsCode;
    private String filename;

    /**
     * Constructs an empty TransformationFunction.
     */
    public TransformationFunction() {}

    /**
     * Constructs a TransformationFunction with either JS code or a filename.
     * @param jsCode Inline JavaScript code for transformation.
     * @param filename Filename from assets/transformation_function/ directory.
     */
    public TransformationFunction(String jsCode, String filename) {
        if (jsCode != null && filename != null) {
            throw new IllegalArgumentException("Cannot set both jsCode and filename");
        }
        if (jsCode != null) {
            setJsCode(jsCode);
        }
        if (filename != null) {
            setFilename(filename);
        }
    }

    /**
     * @return The inline JavaScript code
     */
    public String getJsCode() {
        return jsCode;
    }

    /**
     * Sets the inline JavaScript code.
     * @param jsCode Non-empty JavaScript code string.
     */
    public void setJsCode(String jsCode) {
        if (filename != null) {
            throw new IllegalStateException("Cannot set jsCode when filename is already set");
        }
        if (jsCode == null || jsCode.trim().isEmpty()) {
            throw new IllegalArgumentException("jsCode must be a non-empty string");
        }
        this.jsCode = jsCode;
    }

    /**
     * @return The transformation filename, or null if not set.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the transformation filename.
     * @param filename Filename ending with .js without path separators.
     */
    public void setFilename(String filename) {
        if (jsCode != null) {
            throw new IllegalStateException("Cannot set filename when jsCode is already set");
        }
        if (filename == null) {
            throw new IllegalArgumentException("filename must not be null");
        }
        if (!filename.toLowerCase().endsWith(".js")) {
            throw new IllegalArgumentException("Filename must end with .js");
        }
        if (filename.contains("/") || filename.contains("\\")) {
            throw new IllegalArgumentException("Filename must not contain path separators");
        }
        this.filename = filename;
    }

    /**
     * @return The JS code or filename as a JSON primitive.
     */
    public JsonPrimitive getJSON() {
        if (jsCode != null) {
            return new JsonPrimitive(jsCode);
        } else if (filename != null) {
            return new JsonPrimitive(filename);
        } else {
            throw new IllegalStateException("No transformation defined");
        }
    }
}