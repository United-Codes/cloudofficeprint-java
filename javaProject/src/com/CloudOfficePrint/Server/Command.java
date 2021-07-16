package com.CloudOfficePrint.Server;

import com.google.gson.JsonObject;

/**
 * Command object with a single command for the AOP server.
 * The command should be present in the aop_config.json file on the AOP server.
 */
public class Command {

    private String command;
    private JsonObject args;

    /**
     * @return command to execute.
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command to execute.
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * @return JsonObject with the parameters for the command.
     *         E.g.: { "p1":"Parameter 1", "p2": "Parameter 2" , "p3" : "Parameter 3"}
     *         The parameter tags need to be defined in the aop_config.json file on the AOP server.
     */
    public JsonObject getArgs() {
        return args;
    }

    /**
     * @param args JsonObject with the parameters for the command.
     *             E.g.: { "p1":"Parameter 1", "p2": "Parameter 2" , "p3" : "Parameter 3"}
     *             The parameter tags need to be defined in the aop_config.json file on the AOP server.
     */
    public void setArgs(JsonObject args) {
        this.args = args;
    }

    /**-
     * @param command Command to execute.
     * @param args JsonObject with the parameters for the command. E.g.: { "p1":"Parameter 1", "p2": "Parameter 2" , "p3" : "Parameter 3"}
     *             The parameter tags need to be defined in the aop_config.json file on the AOP server.
     */
    public Command(String command, JsonObject args){
        setCommand(command);
        setArgs(args);
    }

    /**
     * @return JSONObject with the tags for the postprocess-command for the AOP server.
     */
    public JsonObject getJSON(){
        JsonObject json =new JsonObject();
        json.addProperty("command",getCommand());
        json.add("command_parameters",getArgs());
        return json;
    }

    /**
     * @return JSONObject with the tags for the pre-command for the AOP server.
     */
    public JsonObject getJSONForPre(){
        JsonObject json =new JsonObject();
        json.addProperty("pre_command",getCommand());
        json.add("pre_command_parameters",getArgs());
        return json;
    }

    /**
     * @return JSONObject with the tags for the post-command for the AOP server.
     */
    public JsonObject getJSONForPost(){
        JsonObject json =new JsonObject();
        json.addProperty("post_command",getCommand());
        json.add("post_command_parameters",getArgs());
        return json;
    }
}
