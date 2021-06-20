package com.company.Resources;

import com.google.gson.JsonObject;
import org.apache.tika.mime.MimeTypeException;


/**
 * Resource is an abstract for all the different resource types for the templates and "secondary files" : subtemplates,
 * files to prepend, files to append and files to insert (in the template).
 */
public abstract class Resource {
    /**
     * The resource type as extension e.g : docx.
     */
    private String filetype;

    /**
     * The resource's mimetype.
     */
    private String mimeType;

    /**
     * Array of the supported resourcetypes (extensions).
     */
    private final String [] supportedResourceExtensions = { "txt","md", "html", "docx", "xlsx", "pptx"};

    /**
     * @return The mimetype of the resource.
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @return The resource type as extension e.g. : docx.
     */
    public String getFiletype()  {
        return filetype;
    }

    /**
     * Sets the mimetype of the resource to the given mimetype.
     * @param mimeType The resource's mimetype.
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * Sets the filetype (extension) of the resource to the given filetype.
     * @param filetype extension of the resource.
     */
    public void setFiletype(String filetype)  {
        this.filetype = filetype;
    }

    /**
     * Needs to be called to get the JSON of a resource for a template.
     * @return JsonObject to add in the JSON for the server.
     */
    public abstract JsonObject getJSONForTemplate();

    /**
     * Needs to be used to get the JSON of a resource for a secondary file (file to prepend, to append, to insert or subtemplate),
     * because their JSON has a different format then for a template.
     * @return JsonObject to add in the JSON for the server.
     */
    public abstract JsonObject getJSONForSecondaryFile() throws MimeTypeException;

    /**
     * @param filePath path of the file
     * @return File extension of the file
     */
    public String getExtension(String filePath) throws Exception {
        int index = filePath.lastIndexOf('.');
        if(index > 0) {
            String extension = filePath.substring(index + 1);
            //System.out.println("File extension is " + extension);
            return extension;
        }
        else {
            throw new Exception("No extension found.");
        }
    }
}
