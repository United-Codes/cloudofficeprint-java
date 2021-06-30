package com.company.RenderElements.Images;

import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/**
 * Represents an image to insert in a template with a base64-encoded string as source.
 */
public class ImageBase64 extends Image{

    /**
     * This object represent an image to insert in the template. The options of the image can be turned on via the setter functions.
     * The source of this image is a base64-encoded string.
     * @param name Name of this image for the tag.
     * @param base64 Base64 string of the  image.
     */
    public ImageBase64(String name, String base64){
        setName(name);
        setValue(base64);
    }

    /**
     * Reads all bytes of the file, converts them to base64 and stores them in this.value.
     * @param filePath Path of the local file.
     * @throws IOException If file not found.
     */
    public void setFileFromLocalFile(String name, String filePath) throws IOException {
        File file = new File(filePath);
        byte[] bytes = Files.readAllBytes(file.toPath());
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        setValue(encodedString);
    }
}
