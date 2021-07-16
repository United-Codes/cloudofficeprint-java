package com.CloudOfficePrint;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Class for dealing with the AOP server's response to a printjob request.
 */
public class Response {

    private String ext;
    private String mimetype;
    private  byte[] body;

    /**
     * @return mimetype of the file in the body.
     */
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
     * @param ext Extension of the file in the body.
     * @param body (file base64) of the response.
     * @param mimetype Mimetype of the file in the body.
     */
    public Response(String ext,String mimetype, byte[] body){
        setExt(ext);
        setMimetype(mimetype);
        setBody(body);
    }

    /**
     * Downloads the file locally to the given path, filename needs to be specified at the end of the path, not the extension.
     * Creates the file at given path if it doesn't exist yet, overwrites it otherwise.
     * @param path local path ending
     * @throws IOException If the file is not found.
     */
    public void downloadLocally(String path) throws IOException {
        path = path +ext ;
        FileUtils.writeByteArrayToFile(new File(path), getBody());
    }
}
