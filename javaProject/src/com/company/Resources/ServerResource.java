package com.company.Resources;


import com.google.gson.JsonObject;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServerResource extends Resource{
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ServerResource(String path) throws Exception {
        this.path = path;
        Path temp = new File(path).toPath();
        setMimeType(Files.probeContentType(temp));
        setFiletype(getExtension(path));
    }

    @Override
    public JsonObject getJSONForTemplate() {
        JsonObject json = new JsonObject();
        json.addProperty("template_type", getFiletype());
        json.addProperty("filename",path);
        return json;
    }

    @Override
    public JsonObject getJSONForSecondaryFile() throws MimeTypeException {
        JsonObject jsonResource = new JsonObject();
        jsonResource.addProperty("mime_type",getMimeType()); //changer ca vers mimetype
        jsonResource.addProperty("file", path);
        jsonResource.addProperty("file_source","file");
        return jsonResource;
    }
}
