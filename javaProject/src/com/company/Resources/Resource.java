package com.company.Resources;

import org.json.JSONObject;

//Maybe this need to be an interface?
public class Resource {
    /**
     * Should not be called.
     * @return
     */
    public JSONObject getJSON() {
        return new JSONObject();
    }

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
            throw new Exception("No extension found");
        }
    }
}
