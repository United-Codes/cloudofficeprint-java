package com.company;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class FileWithData {
    String name;
    JsonArray dataList = new JsonArray();

    public void addData(String [] [] key_values) {
        JsonObject jsonObject = new JsonObject();
        for (String[] str :  key_values){
            jsonObject.addProperty(str[0],str[1]);
        }
        dataList.add(jsonObject);
    }

    public JsonObject getJSON(){
        JsonObject json =new JsonObject();
        json.addProperty("filename",name);
        json.add("data",dataList); //check ca ici
        System.out.println(json);
        return json;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonArray getDataList() {
        return dataList;
    }

    public String getName() {
        return name;
    }
}
