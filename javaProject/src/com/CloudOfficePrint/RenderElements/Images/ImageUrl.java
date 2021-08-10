package com.CloudOfficePrint.RenderElements.Images;


/**
 * Represents an image to insert in a template with a URL string as source.
 */
public class ImageUrl extends Image{

    /**
     * This object represent an image to insert in the template. The options of the image can be turned on via the setter functions.
     * The source of this image is a URL string.
     * @param name Name of this image for the tag.
     * @param url The source URL for the image.
     */
    public ImageUrl(String name, String url){
        setName(name);
        setValue(url);
    }

}
