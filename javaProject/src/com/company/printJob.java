package com.company;

import org.json.JSONObject;

import java.util.ArrayList;


public class printJob {
    private JSONObject jsonForServer ; //tout ce qui est JSONObject ici va un peu falloir changer et créer des classes appart
    private Server server;
    private String aop_remote_debug;
    private String apex_version;
    private String APIKey;
    private String version;
    private String tool;
    private ArrayList<String> prepend_files = new ArrayList<String>();
    private ArrayList<String> append_files= new ArrayList<String>();
    private ArrayList<JSONObject> template = new ArrayList<JSONObject>();
    private JSONObject output;
    private ArrayList<JSONObject> dataForTemplates =new ArrayList<JSONObject>(); //data for output files
    private ArrayList<JSONObject> subtemplates = new ArrayList<JSONObject>();

    public void setJsonForServer(JSONObject json){
        this.jsonForServer = json;
    }
    public void setServer(Server server){
        this.server = server;
    }

    public void setAop_remote_debug(String debugmode){
        aop_remote_debug = debugmode;
    }

    public void setApex_version(String version){
        apex_version = version;
    }

    public void setAPIKey(String APIKey){
        this.APIKey = APIKey;
    }

    public void setVersion(String version){
        this.version = version;
    }

    public void setTool (String tool){
        this.tool = tool;
    }

    public void addPrepend_file(String file){
        prepend_files.add(file);
    }

    public void addAppend_file(String file){
        append_files.add(file);
    }

    public void addSubTemplate(JSONObject template){
        this.subtemplates.add(template);
    }

    public void setOutput( JSONObject output){
        this.output = output;
    }

    public void addDataForTemplate(JSONObject data){
        this.dataForTemplates.add(data);
    }

    public void addSubTemplates(JSONObject subtemplate){
        this.subtemplates.add(subtemplate);
    }

    public void createJSON(){
        jsonForServer.put("aop_remote_debug", aop_remote_debug);
        jsonForServer.put("apex_version", apex_version);
        jsonForServer.put("APIKey", APIKey);
        jsonForServer.put("version", version);
        jsonForServer.put("tool", tool);
        jsonForServer.put("prepend_files", prepend_files);
        jsonForServer.put("append_files", append_files);
        jsonForServer.put("template", template);
        jsonForServer.put("output", output);
        jsonForServer.put("files", dataForTemplates);
        jsonForServer.put("templates", subtemplates);
    }

    public void printJSON(){
        System.out.println(jsonForServer.toString());
    }

    public void execute(){
        if (server == null){
            System.out.println("No server specified.");
            return;
        }
        createJSON();
        printJSON();
        if (server.isReachable() == true){
            //server.sendPOSTRequest(jsonForServer);
        }
        else {
            System.out.println("Server is not reachable.");
            return;
        }

    }
}
