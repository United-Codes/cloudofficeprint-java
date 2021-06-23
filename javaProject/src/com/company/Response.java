package com.company;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Response {

    private String ext;
    private  byte[] body;

    public Response(String ext, byte[] body){
        this.ext = ext;
        this.body =body;
    }

    public byte[] getBody() {
        return body;
    }

    public String getExt() {
        return ext;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public void downloadLocally(String path) throws IOException {
        path = "./downloads/"+path  +ext ;
        FileUtils.writeByteArrayToFile(new File(path), body); //creates the file if it doesn't exist yet
    }
}
