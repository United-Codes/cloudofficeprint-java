package com.company.Resources;


import com.company.Mimetype;
import com.google.gson.JsonObject;
import org.apache.sis.storage.event.WarningEvent;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.mime.MimeTypeException;
import ucar.units.Base;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/**
 * Child class of Resource. A class representing a resource (file) with base64-encoded data for the AOP server.
 */
public class Base64Resource extends Resource{

    /**
     * Data of the resource base64 encoded.
     */
    private String fileBase64; //base64 encoded

    /**
     * Constructor for creating an uninitialised object of this class. Needs to be populated with setFileFromLocalFile.
     */
    public Base64Resource(){
    }

    /**
     * Constructor for creating an object of this class where the database64 can be supplied as a string.
     * @param filetype Type (extension) of the resource e.g. : docx (not docx. !).
     * @param database64 Data of the resource base64 encoded.
     * @throws Exception If the mimetype is not found.
     */
    public Base64Resource(String filetype, String database64) throws Exception {
        setFiletype(filetype);
        setMimeType(Mimetype.getMimeType(filetype));
        setFileBase64(database64);
    }

    /**
     * @return a string of the resource base64 encoded.
     */
    public String getFileBase64() {
        return fileBase64;
    }

    /**
     * Sets the data of the resource to the given parameter.
     * @param fileBase64 base64 encoded version of the file.
     */
    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }

    /**
     * @return JSONObject with the tags for a base64 resource as template for the AOP server ("file","template_type").
     */
    @Override
    public JsonObject getJSONForTemplate(){
        JsonObject jsonResource = new JsonObject();
        //jsonResource.addProperty("filename",getFilename());
        jsonResource.addProperty("file", fileBase64);
        jsonResource.addProperty("template_type",getFiletype());
        return jsonResource;
    }

    /**
     *
     * @return JSONObject with the tags ("mime_type","file_content","file_source") for a base 64 resource as a secondary file
     * (subtemplates, files to prepend, files to append and files to insert) for the AOP server.
     */
    @Override
    public JsonObject getJSONForSecondaryFile()  {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("file_content", getFileBase64());
        jsonResource.addProperty("file_source","base64");
        jsonResource.addProperty("mime_type",getMimeType());
        return jsonResource;
    }

    /**
     * Sets the filetype of this resource to the extension of the file, sets the mimetype as well.
     * Reads all bytes of the file, coverts them to base64 and stores them in this.fileBase64.
     * @param filePath Path of the local file.
     * @throws IOException If file not found.
     * @throws Exception If the extension of the file is not found.
     */
    public void setFileFromLocalFile(String filePath) throws Exception {
        String extension = getExtension(filePath);
        setFiletype(extension);
        File file = new File(filePath);

        //Tika tika = new Tika();
        //setMimeType(tika.detect(file)); // would be a better way to do it but it throws two warnings.
        setMimeType(Mimetype.getMimeType(extension));

        byte[] bytes = Files.readAllBytes(file.toPath());
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        setFileBase64(encodedString);
        //String s = new String(bytes, StandardCharsets.UTF_8);
        //System.out.println(s); //only works for txt or json not office files
    }



}

