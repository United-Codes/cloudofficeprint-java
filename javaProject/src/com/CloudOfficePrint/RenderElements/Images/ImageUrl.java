package com.CloudOfficePrint.RenderElements.Images;


/**
 * Represents an image to insert in a template with a URL string as source.
 */
public class ImageUrl extends Image{

    /**
     * This object represent an image to insert in the template. The options of the image can be turned on via the setter functions.
     * The source of this image is a URL string.
     * @param name Name of this image for the tag.
     * @param url Url of the image. Thu url of the image is automatically set as targetUrl (url to jump to when the image is clicked).
     *            If you want to specify another targetUrl you can do this via the setTargetUrl() function. This URL will automatically be
     *            the URL to hyperlink to when clicked on the image (can be changed with the setter function if wanted).
     */
    public ImageUrl(String name, String url){
        setName(name);
        setValue(url);
        setTargetUrl(url);
    }

}
