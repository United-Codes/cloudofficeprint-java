package com.company.Resources;

import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.util.Base64;

public class Base64Resource extends Resource{
    private String filename;
    private String fileBase64; //base64 encoded
    private String filetype;

    /**
     * @return a string of the file base64 encoded
     */
    public String getFileBase64() {
        return fileBase64;
    }

    /**
     * @return name of the file
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @return the type of the file
     */
    public String getFiletype() {
        return filetype;
    }

    /**
     * @return JSONObject with the tags for the AOP server ("filename","file","template_type").
     */
    @Override
    public JSONObject getJSON(){
        JSONObject jsonResource = new JSONObject();
        jsonResource.put("filename",filename);
        jsonResource.put("file", fileBase64);
        jsonResource.put("template_type",filetype);
        return jsonResource;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    /**
     * Sets the filetype of this resource to the extension of the file.
     * Reads all bytes of the file, coverts them to base64 and stores them in this.fileBase64.
     * @param filePath Path of the local file.
     * @throws IOException If file not found or other error.
     */
    public void setFileFromLocalFile(String filePath) throws Exception {
        String extension = getExtension(filePath);
        this.filetype = extension;
        File file = new File(filePath);
        byte[] bytes = Files.readAllBytes(file.toPath());
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        this.fileBase64 = encodedString;
        //String s = new String(bytes, StandardCharsets.UTF_8);
        //System.out.println(s); //only works for txt or json not office files
    }


}

