package com.cloudofficeprint;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Class for dealing with the Cloud Office Print server's response to a printjob
 * request.
 */
public class Response implements IResponse{

    private String ext;
    private String mimetype;
    private byte[] body;

    /**
     * @return mimetype of the file in the body.
     */
    @Override
    public String getMimetype() {
        return mimetype;
    }

    /**
     * @param mimetype of the file in the body.
     */
    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    /**
     * @return body (file base64) of the response.
     */
    @Override
    public byte[] getBody() {
        return body;
    }

    /**
     * @param body (file base64) of the response.
     */
    public void setBody(byte[] body) {
        this.body = body;
    }

    /**
     * @return extension of the file in the body.
     */
    @Override
    public String getExt() {
        return ext;
    }

    /**
     * @param ext Extension of the file in the body.
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * @param ext      Extension of the file in the body.
     * @param body     (file base64) of the response.
     * @param mimetype Mimetype of the file in the body.
     */
    public Response(String ext, String mimetype, byte[] body) {
        setExt(ext);
        setMimetype(mimetype);
        setBody(body);
    }

    /**
     * Return the string representation of this Response. Useful if the server
     * returns a JSON (e.g. for output_type 'count_tags').
     *
     * @return string representation of this Response
     * @throws Exception if the byte-array cannot be decoded
     */
    @Override
    public String asString() throws Exception {
        try {
            return new String(this.body, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    /**
     * Downloads the file locally to the given path, filename needs to be specified
     * at the end of the path, not the extension. Creates the file at given path if
     * it doesn't exist yet, overwrites it otherwise.
     *
     * @param path local path ending
     * @throws IOException If the file is not found.
     */
    @Override
    public void downloadLocally(String path) throws IOException {
        path = path + ext;
        FileUtils.writeByteArrayToFile(new File(path), getBody());
    }
}
