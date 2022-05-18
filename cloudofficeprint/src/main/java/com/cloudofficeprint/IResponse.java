package com.cloudofficeprint;

import java.io.IOException;

/**
 * Interface for dealing with the Cloud Office Print server's response to a printjob request.
 */
public interface IResponse {
    /**
     * @return mimetype of the file in the body.
     */
    String getMimetype();

    /**
     * @return body (file base64) of the response.
     */
    byte[] getBody();

    /**
     * @return extension of the file in the body.
     */
    String getExt();

    /**
     * Return the string representation of this Response. Useful if the server
     * returns a JSON (e.g. for output_type 'count_tags').
     *
     * @return string representation of this Response
     * @throws Exception if the byte-array cannot be decoded
     */
    String asString() throws Exception;

    /**
     * Downloads the file locally to the given path, filename needs to be specified
     * at the end of the path, not the extension. Creates the file at given path if
     * it doesn't exist yet, overwrites it otherwise.
     *
     * @param path local path ending
     * @throws IOException If the file is not found.
     */
    void downloadLocally(String path) throws IOException;
}
