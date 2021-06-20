package com.company.Resources;


import com.google.gson.JsonObject;
import org.apache.tika.mime.MimeTypeException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Base64Resource extends Resource{

    private String fileBase64; //base64 encoded

    /**
     * @return a string of the file base64 encoded
     */
    public String getFileBase64() {
        return fileBase64;
    }

    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }

    /**
     * @return JSONObject with the tags for the AOP server ("filename","file","template_type").
     */
    @Override
    public JsonObject getJSONForTemplate(){
        JsonObject jsonResource = new JsonObject();
        //jsonResource.addProperty("filename",getFilename());
        jsonResource.addProperty("file", fileBase64);
        jsonResource.addProperty("template_type",getFiletype());
        return jsonResource;
    }

    @Override
    public JsonObject getJSONForSecondaryFile() throws MimeTypeException {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("mime_type",getMimeType()); //changer ca vers mimetype
        jsonResource.addProperty("file_content", getFileBase64());
        jsonResource.addProperty("file_source","base64");
        return jsonResource;
    }

    /**
     * Sets the filetype of this resource to the extension of the file.
     * Reads all bytes of the file, coverts them to base64 and stores them in this.fileBase64.
     * @param filePath Path of the local file.
     * @throws IOException If file not found or other error.
     */
    public void setFileFromLocalFile(String filePath) throws Exception {
        String extension = getExtension(filePath);
        setFiletype(extension);
        File file = new File(filePath);
        Path path = file.toPath();
        setMimeType(Files.probeContentType(path));
        byte[] bytes = Files.readAllBytes(file.toPath());
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        setFileBase64(encodedString);
        //String s = new String(bytes, StandardCharsets.UTF_8);
        //System.out.println(s); //only works for txt or json not office files
    }


}

