package com.cloudofficeprint;

import com.cloudofficeprint.Server.Server;

import java.io.IOException;

/**
 * Class for dealing with the Cloud Office Print server's response to a print job
 * request if output polling is set to true.
 * This class will throw an exception when calling a method on the response if the response is not processed yet.
 */
public class ResponsePolling implements IResponse {
    private Response response;
    private Server server;
    private String id;
    private String secretKey;

    /**
     * @return Response of the polled print job.
     * @throws Exception when the Cloud Office Print server can't download the response.
     */
    public Response getResponse() throws Exception{
        if (response == null){
            response = server.download(id, secretKey, null);
        }
        return response;
    }

    /**
     * @param response of the polled print job.
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     * @return Cloud Office Print server that has the response of the polled print job.
     */
    public Server getServer() {
        return server;
    }

    /**
     * @param server Cloud Office Print server that has the response of the polled print job.
     */
    public void setServer(Server server) {
        this.server = server;
    }

    /**
     * @return unique identifier of the polled print job.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id unique identifier of the polled print job.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return secret key used to encrypt the polled print job on the Cloud Office Print server.
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * @param secretKey secret key used to encrypt the polled print job on the Cloud Office Print server.
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * @param server The Cloud Office Print server.
     * @param id unique identifier of the polled print job.
     */
    public ResponsePolling(Server server, String id){
        setServer(server);
        setId(id);
    }

    /**
     * Deletes the polled print job on the Cloud Office Print server.
     */
    public void delete(){
        try{
            server.download(getId(), getSecretKey(), true);
        }
        catch (Exception e){
            // do nothing
        }
    }

    /**
     * @return mimetype of the file in the body.
     */
    @Override
    public String getMimetype() {
        try{
            return getResponse().getMimetype();
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "";
        }
    }

    /**
     * @return body (file base64) of the response.
     */
    @Override
    public byte[] getBody() {
        try{
            return getResponse().getBody();
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new byte[0];
        }
    }

    /**
     * @return extension of the file in the body.
     */
    @Override
    public String getExt() {
        try{
            return getResponse().getExt();
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "";
        }
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
        return getResponse().asString();
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
        try{
            getResponse().downloadLocally(path);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
