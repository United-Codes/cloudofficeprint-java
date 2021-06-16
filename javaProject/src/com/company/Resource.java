package com.company;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

public class Resource {
    private String filename;
    private String file; //base64 encoded
    private String filetype;

    public String getFile() {
        return file;
    }

    public String getFilename() {
        return filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public JSONObject getJSON(){
        JSONObject jsonResource = new JSONObject();
        jsonResource.put("filename",filename);
        jsonResource.put("file", file);
        jsonResource.put("template_type",filetype);
        return jsonResource;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public void setFileFromLocalFile(String filePath) {
        String file = readFile(filePath);
        String encodedString = Base64.getEncoder().encodeToString(file.getBytes());
        this.file = encodedString;
        System.out.println(this.file);
    }

    public String readFile(String path)  {
        StringBuffer dataString = new StringBuffer("");
        try {
            //String currentPath = new java.io.File("./src").getCanonicalPath();
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataString.append(data);
                //System.out.println(data);
            }
            myReader.close();
            return dataString.toString();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "error";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}

