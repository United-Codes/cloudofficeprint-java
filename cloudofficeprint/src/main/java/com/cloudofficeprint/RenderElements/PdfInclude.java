package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Inside Word, PowerPoint, and Excel documents, the tag {?include name} can be used to
 * include documents like Word, Excel, PowerPoint, and PDFs.
 */
public class PdfInclude extends RenderElement {

    private String filename;
    private String mimeType;
    private String fileContent;
    private String fileSource;

    /**
     * Constructor for PdfInclude.
     *
     * @param name         The tag name used in the template.
     * @param value        (Optional) Placeholder value (can be an empty string).
     * @param filename     The name of the file to include.
     * @param mimeType     The MIME type of the file (e.g., "image/png", "application/pdf").
     * @param fileContent  The Base64-encoded file content.
     * @param fileSource   The file source type (e.g., "base64", "local").
     */
    public PdfInclude(String name, String value,
                      String filename, String mimeType,
                      String fileContent, String fileSource) {
        setName(name);
        setValue(value);
        this.filename = filename;
        this.mimeType = mimeType;
        this.fileContent = fileContent;
        this.fileSource = fileSource;
    }

    /**
     * Returns the filename of the included file.
     *
     * @return The filename.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the filename of the included file.
     *
     * @param filename The filename to set.
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Returns the MIME type of the included file.
     *
     * @return The MIME type.
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the MIME type of the included file.
     *
     * @param mimeType The MIME type to set.
     */

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * Returns the Base64-encoded content of the included file.
     *
     * @return The file content.
     */
    public String getFileContent() {
        return fileContent;
    }

    /**
     * Sets the Base64-encoded content of the included file.
     *
     * @param fileContent The file content to set.
     */
    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    /**
     * Returns the source type of the included file.
     *
     * @return The file source type (e.g., "base64", "local").
     */
    public String getFileSource() {
        return fileSource;
    }
    /**
     * Sets the source type of the included file.
     *
     * @param fileSource The file source type to set (e.g., "base64", "local").
     */

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    /**
     * @return A JSON object with the tag and associated value for the Cloud Office Print server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject outer = new JsonObject();
        JsonObject inner = new JsonObject();

        if (filename != null) {
            inner.addProperty("name", filename);
        }
        if (mimeType != null) {
            inner.addProperty("mime_type", mimeType);
        }
        if (fileContent != null) {
            inner.addProperty("file_content", fileContent);
        }
        if (fileSource != null) {
            inner.addProperty("file_source", fileSource);
        }
        outer.add(getName(), inner);
        return outer;
    }

    /**
     * Returns the template tags this element replaces.
     * For example: {?include myFile}
     *
     * @return A set of supported template tags.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<>();
        hash_Set.add("{?include " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
