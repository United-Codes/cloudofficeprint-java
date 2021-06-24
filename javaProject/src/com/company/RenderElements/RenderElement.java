package com.company.RenderElements;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public abstract class RenderElement {


    abstract public String getData(); //temp

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON(){
        JsonObject json =new JsonObject();
        /*if (getCommands()!= null){
            for(Map.Entry<String, JsonElement> tag : getCommands().getJSON().entrySet()){
                json.add(tag.getKey(),tag.getValue()); //these tags need to be at the "highest" level in the JSON
            }
        }*/
        return json;
    }
}
