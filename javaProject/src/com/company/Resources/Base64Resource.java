package com.company.Resources;


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
     * @param filetype Type (extension) of the resource.
     * @param mimetype Mimetype of the resource.
     * @param database64 Data of the resource base64 encoded.
     */
    public Base64Resource(String filetype, String mimetype, String database64){
        setFiletype(filetype);
        setMimeType(mimetype);
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
        setMimeType(getMimeType(extension));

        byte[] bytes = Files.readAllBytes(file.toPath());
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        setFileBase64(encodedString);
        //String s = new String(bytes, StandardCharsets.UTF_8);
        //System.out.println(s); //only works for txt or json not office files
    }

    /**
     * As the tika library gives two warnings I decided to implement if manually for all the supported document formats (not a lot). I didn't find any better option for the moment.
     * @param extension Extension of the file to find the mimetype.
     * @return Mimetype of the file.
     * @throws Exception If the file type is not supported (cannot find the mimetype).
     */
    public String getMimeType(String extension) throws Exception {
        if (extension.equals("txt")){
            return "text/plain";
        }
        if (extension.equals("md")){
            return "text/markdown";
        }
        if (extension.equals("html")){
            return "text/html";
        }
        if (extension.equals("docx")){
            return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        }
        if (extension.equals("xlsx")){
            return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        }
        if (extension.equals("pptx")){
            return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
        }
        if (extension.equals("csv")){
            return "text/csv";
        }
        else throw new Exception("File type not supported, so cannot find the mimetype");
    }


}

