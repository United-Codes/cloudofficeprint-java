package com.company;

import com.company.Resources.Template;
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
    private JSONObject template; //maybe Arraylist if we want several
    private JSONObject output;
    private ArrayList<JSONObject> fileWithData =new ArrayList<JSONObject>(); //data for output files
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

    public void setTemplate(Template base64Ressource){
        this.template = base64Ressource.getJSON();
    }

    public void addSubTemplate(JSONObject template){
        this.subtemplates.add(template);
    }

    public void setOutput( Output output){
        this.output = output.getJSON();
    }

    public void addFileToGenerate(FileWithData file){
        this.fileWithData.add(file.getJSON());
    }


    public JSONObject createJSON(){
        JSONObject jsonForServer = new JSONObject();
        jsonForServer.put("aop_remote_debug", aop_remote_debug);
        jsonForServer.put("apex_version", apex_version);
        jsonForServer.put("api_key", APIKey);
        jsonForServer.put("version", version);
        jsonForServer.put("tool", tool);
        jsonForServer.put("prepend_files", prepend_files);
        jsonForServer.put("append_files", append_files);
        jsonForServer.put("template", template);
        jsonForServer.put("output", output);
        jsonForServer.put("files", fileWithData);
        jsonForServer.put("templates", subtemplates);
        return jsonForServer;
    }


    public Response execute() throws Exception {
        if (server == null){
            throw new Exception("No server specified.");
        }
        JSONObject JSONForServer = createJSON();
        System.out.println(JSONForServer.toString());

        if (server.isReachable() == true){
            return server.sendPOSTRequest(JSONForServer);
        }
        else {
            throw new Exception("Server is not reachable.");
        }

    }
}
