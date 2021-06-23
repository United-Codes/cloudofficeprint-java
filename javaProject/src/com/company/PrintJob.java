package com.company;

import com.company.Output.Output;
import com.company.RenderElements.FileWithData;
import com.company.Resources.Resource;
import com.company.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class PrintJob {
    //tout ce qui est JSONObject ici va un peu falloir changer et créer des classes appart
    private Server server;
    private String aop_remote_debug;
    private String apex_version;
    private String APIKey;
    private String version;
    private String tool;
    private JsonArray prepend_files = new JsonArray();
    //private ArrayList<String> append_files= new ArrayList<String>();
    private JsonArray append_files= new JsonArray();
    private JsonObject template; //maybe Arraylist if we want several
    private JsonObject output;
    private JsonArray fileWithData =new JsonArray(); //data for output files
    private JsonArray subtemplates = new JsonArray();


    public void setServer(Server server){
        this.server = server;
    }

    public boolean checkDebug(String debugmode){
        if (debugmode.equals("Yes")|| debugmode.equals("No")){
            return true;
        }
        else return false;
    }

    public void setAOP_remote_debug(String debugmode){
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

    public void setTemplate(Resource template){
        this.template = template.getJSONForTemplate();
    }

    public void addSubTemplate(JsonObject template){
        this.subtemplates.add(template);
    }

    public void setOutput( Output output){
        this.output = output.getJSON();
    }

    public void addFileToGenerate(FileWithData file){
        this.fileWithData.add(file.getJSON());
    }


    public JsonObject createJSON(){
        JsonObject jsonForServer = new JsonObject();
        jsonForServer.addProperty("aop_remote_debug", aop_remote_debug);
        jsonForServer.addProperty("apex_version", apex_version);
        jsonForServer.addProperty("api_key", APIKey);
        jsonForServer.addProperty("version", version);
        jsonForServer.addProperty("tool", tool);
        jsonForServer.add("prepend_files", prepend_files);
        jsonForServer.add("append_files", append_files);
        jsonForServer.add("template", template);
        jsonForServer.add("output", output);
        jsonForServer.add("files", fileWithData);
        jsonForServer.add("templates", subtemplates);
        return jsonForServer;
    }


    public Response execute() throws Exception {
        if (server == null){
            throw new Exception("No server specified.");
        }
        JsonObject JSONForServer = createJSON();
        System.out.println(JSONForServer.toString());

        if (server.isReachable() == true){
            return server.sendPOSTRequest(JSONForServer);
        }
        else {
            throw new Exception("Server is not reachable.");
        }

    }
}
