package com.company;

import org.json.JSONObject;

import java.util.ArrayList;


public class PrintJob {
    //tout ce qui est JSONObject ici va un peu falloir changer et créer des classes appart
    private Server server;
    private String aop_remote_debug;
    private String apex_version;
    private String APIKey;
    private String version;
    private String tool;
    private ArrayList<String> prepend_files = new ArrayList<String>();
    private ArrayList<String> append_files= new ArrayList<String>();
    private ArrayList<JSONObject> templates = new ArrayList<JSONObject>();
    private Output output;
    private ArrayList<JSONObject> filesToGenerate =new ArrayList<JSONObject>(); //data for output files
    private ArrayList<JSONObject> subtemplates = new ArrayList<JSONObject>();


    public void setServer(Server server){
        this.server = server;
    }

    public boolean checkDebug(String debugmode){
        if (debugmode.equals("Yes")|| debugmode.equals("No")){
            return true;
        }
        else return false;
    }

    public void setAop_remote_debug(String debugmode){
        if (checkDebug(debugmode)){
            aop_remote_debug = debugmode;
        }
        else{
            System.out.println("Debug mode not correctly specified, only Yes or No accepted.");
        }
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

    public void addTemplate(Resource template){
        templates.add(template.getJSON());
    }

    public void addSubTemplate(JSONObject template){
        this.subtemplates.add(template);
    }

    public void setOutput( Output output){
        this.output = output;
    }

    public void addFileToGenerate(JSONObject file){
        this.filesToGenerate.add(file);
    }

    public void addSubTemplates(JSONObject subtemplate){
        this.subtemplates.add(subtemplate);
    }

    public JSONObject createJSON(){
        JSONObject jsonForServer = new JSONObject();
        jsonForServer.put("aop_remote_debug", aop_remote_debug);
        jsonForServer.put("apex_version", apex_version);
        jsonForServer.put("APIKey", APIKey);
        jsonForServer.put("version", version);
        jsonForServer.put("tool", tool);
        jsonForServer.put("prepend_files", prepend_files);
        jsonForServer.put("append_files", append_files);
        jsonForServer.put("template", templates);
        jsonForServer.put("output", output);
        jsonForServer.put("files", filesToGenerate);
        jsonForServer.put("templates", subtemplates);
        return jsonForServer;
    }

    public void printJSON(){
        JSONObject jsonForServer = createJSON();
        System.out.println(jsonForServer.toString());
    }

    public void execute(){
        if (server == null){
            System.out.println("No server specified.");
            return;
        }
        JSONObject JSONForServer = createJSON();
        printJSON();
        if (server.isReachable() == true){
            //server.sendPOSTRequest(JSONForServer);
        }
        else {
            System.out.println("Server is not reachable.");
            return;
        }

    }
}
