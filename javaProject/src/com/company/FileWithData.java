package com.company;

import org.json.JSONObject;

import java.util.ArrayList;

public class FileWithData {
    String name;
    ArrayList<JSONObject> dataList = new ArrayList<JSONObject>();

    public void addData(String [] [] key_values) {
        JSONObject jsonObject = new JSONObject();
        for (String[] str :  key_values){
            jsonObject.put(str[0],str[1]);
        }
        dataList.add(jsonObject);
    }

    public JSONObject getJSON(){
        JSONObject json =new JSONObject();
        json.put("filename",name);
        json.put("data",dataList);
        return json;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<JSONObject> getDataList() {
        return dataList;
    }

    public String getName() {
        return name;
    }
}
