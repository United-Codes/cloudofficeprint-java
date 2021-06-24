package com.company.RenderElements;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class Element extends RenderElement{
    String name;
    String data ;

    public Element(String name, String data){
        setData(data);
        setName(name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public JsonObject getJSON(){
        JsonObject json =new JsonObject();
        json.addProperty("data",getData());
        return json;
    }
}
