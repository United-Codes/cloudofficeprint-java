package com.CloudOfficePrint.Server;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

/**
 * Commands object with commands for the AOP server to run before or after the post processing.
 * The commands should be present in the aop_config.json file on the AOP server.
 */
public class Commands {

    private Command postProcess;
    private Boolean postProcessReturn;
    private int postProcessDeleteDelay =-1;
    private Command preConversion;
    private Command postConversion;
    private Command postMerge;

    /**
     * @return Command to run on the AOP server after the POST request is processed.
     */
    public Command getPostProcess() {
        return postProcess;
    }

    /**
     * @param postProcess Command to run on the AOP server after the POST request is processed.
     */
    public void setPostProcess(Command postProcess) {
        this.postProcess = postProcess;
    }

    /**
     * If you are already doing something with the file and don't want it to be returned in the response set this to true.
     * @return Whether to return the output file or not. Note this output is AOP's output and not the post process command output.
     */
    public Boolean getPostProcessReturn() {
        return postProcessReturn;
    }

    /**
     * @param postProcessReturn Whether to return the output file or not. Note this output is AOP's output and not the post process command output.
     */
    public void setPostProcessReturn(Boolean postProcessReturn) {
        this.postProcessReturn = postProcessReturn;
    }

    /**
     * AOP deletes the file provided to the command directly after executing it. This can be delayed with this option.
     * If you have a postcommand to execute on this file and it takes some time to execute, add a postProcessDeleteDelay.
     * @return delay in ms.
     */
    public int getPostProcessDeleteDelay() {
        return postProcessDeleteDelay;
    }

    /**
     * AOP deletes the file provided to the command directly after executing it. This can be delayed with this option.
     * If you have a postcommand to execute on this file and it takes some time to execute, add a postProcessDeleteDelay.
     * @param postProcessDeleteDelay delay in ms.
     */
    public void setPostProcessDeleteDelay(int postProcessDeleteDelay) {
        this.postProcessDeleteDelay = postProcessDeleteDelay;
    }

    /**
     * @return Command to run before conversion.
     */
    public Command getPreConversion() {
        return preConversion;
    }

    /**
     * @param preConversion Command to run before conversion.
     */
    public void setPreConversion(Command preConversion) {
        this.preConversion = preConversion;
    }

    /**
     * @return Command to run after conversion.
     */
    public Command getPostConversion() {
        return postConversion;
    }

    /**
     * @param postConversion Command to run after conversion.
     */
    public void setPostConversion(Command postConversion) {
        this.postConversion = postConversion;
    }

    /**
     * @return Command to run after merging has happened.
     */
    public Command getPostMerge() {
        return postMerge;
    }

    /**
     * @param postMerge Command to run after merging has happened
     */
    public void setPostMerge(Command postMerge) {
        this.postMerge = postMerge;
    }

    /**
     * @return JSONObject with the tags for the commands for the AOP server.
     */
    public JsonObject getJSON(){
        JsonObject json =new JsonObject();
        if(getPostProcess()!=null){
            JsonObject postProcess = new JsonObject();
            for(Map.Entry<String, JsonElement> tag : getPostProcess().getJSON().entrySet()){
                postProcess.add(tag.getKey(),tag.getValue());
            }
            if (getPostProcessReturn()== false){
                postProcess.addProperty("return_output", getPostProcessReturn());
            }
            if (getPostProcessDeleteDelay()!= -1){
                postProcess.addProperty("delete_delay", getPostProcessDeleteDelay());
            }
            json.add("post_process",postProcess);
        }
        if(getPreConversion()!=null|| getPostConversion()!=null){
            JsonObject conversion = new JsonObject();
            if (getPreConversion()!=null){
                for(Map.Entry<String, JsonElement> tag : getPreConversion().getJSONForPre().entrySet()){
                    conversion.add(tag.getKey(),tag.getValue());
                }
            }
            if (getPostConversion()!=null){
                for(Map.Entry<String, JsonElement> tag : getPostConversion().getJSONForPost().entrySet()){
                    conversion.add(tag.getKey(),tag.getValue());
                }
            }
            json.add("conversion",conversion);
        }
        if (getPostMerge()!=null){
            json.add("merge",getPostMerge().getJSONForPost());
        }
        return json;
    }
}
