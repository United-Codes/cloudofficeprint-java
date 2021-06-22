package com.company.Resources;


import com.google.gson.JsonObject;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Child class of Resource. A class representing a resource (file) on the AOP server.
 */
public class ServerResource extends Resource{

    /**
     * Path to the resource on the AOP server.
     */
    private String path;

    /**
     * @return Path of the resource on the AOP server.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path of the resource.
     * @param path path of the resource on the AOP server.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Creates a resource with given path. Mimetype and filetype (extension) are deduced from the path.
     * @param path Path of the file on the AOP server.
     * @throws IOException if mimetype can't be deduced.
     * @throws Exception if extension can't be deduced.
     */
    public ServerResource(String path) throws Exception {
        this.path = path;
        Path temp = new File(path).toPath();
        setMimeType(Files.probeContentType(temp));
        setFiletype(getExtension(path));
    }

    /**
     * @return JSONObject with the tags for a resource on server as template for the AOP server ("template_type","filename").
     */
    @Override
    public JsonObject getJSONForTemplate() {
        JsonObject json = new JsonObject();
        json.addProperty("template_type", getFiletype());
        json.addProperty("filename",path);
        return json;
    }

    /**
     * @return JSONObject with the tags ("mime_type","file","file_source") for a server resource as a secondary file
     * (subtemplates, files to prepend, files to append and files to insert) for the AOP server.
     */
    @Override
    public JsonObject getJSONForSecondaryFile() throws MimeTypeException {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("mime_type",getMimeType()); //changer ca vers mimetype
        jsonResource.addProperty("file", path);
        jsonResource.addProperty("file_source","file");
        return jsonResource;
    }
}