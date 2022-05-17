package com.cloudofficeprint;

import com.cloudofficeprint.Server.Server;

import java.io.IOException;

public class ResponsePolling implements IResponse {
    private Response response;
    private Server server;
    private String id;
    private String secretKey;

    public Response getResponse() throws Exception{
        if (response == null){
            response = server.download(id, secretKey, null);
        }
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public ResponsePolling(Server server, String id){
        setServer(server);
        setId(id);
    }

    public void delete(){
        try{
            server.download(getId(), getSecretKey(), true);
        }
        catch (Exception e){
            // do nothing
        }
    }

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

    @Override
    public String asString() throws Exception {
        return getResponse().asString();
    }

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
