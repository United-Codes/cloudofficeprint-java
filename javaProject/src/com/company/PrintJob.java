package com.company;

import com.company.Output.Output;
import com.company.RenderElements.RenderElement;
import com.company.Resources.Resource;
import com.company.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.tika.mime.MimeTypeException;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * A print job for the AOP server containing all the necessary information to generate the adequate JSON for the AOP server.
 */
public class PrintJob {
    private Server server;
    private Output output;
    private Resource template;
    private Resource[] prependFiles;
    private Resource[] appendFiles;
    private Hashtable<String, Resource> subTemplates = new Hashtable<String, Resource>();
    private Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();

    /**
     * @return Server to user for this printjob.
     */
    public Server getServer() {
        return server;
    }

    /**
     * @param server to use for this printjob.
     */
    public void setServer(Server server) {
        this.server = server;
    }

    /**
     * @return Output object containing output configuration for this printjob.
     */
    public Output getOutput() {
        return output;
    }

    /**
     * @param output object containing the output configuration for this printjob.
     */
    public void setOutput(Output output) {
        this.output = output;
    }

    /**
     * @return Template for this print job.
     */
    public Resource getTemplate() {
        return template;
    }

    /**
     * @param template for this printjob.
     */
    public void setTemplate(Resource template) {
        this.template = template;
    }

    /**
     * @return Files to prepend to the output.
     */
    public Resource[] getPrependFiles() {
        return prependFiles;
    }

    /**
     * @param prependFiles Files to prepend to the output.
     */
    public void setPrependFiles(Resource[] prependFiles) {
        this.prependFiles = prependFiles;
    }

    /**
     * @return Files to append to the output.
     */
    public Resource[] getAppendFiles() {
        return appendFiles;
    }

    /**
     * @param appendFiles Files to append to the output.
     */
    public void setAppendFiles(Resource[] appendFiles) {
        this.appendFiles = appendFiles;
    }

    /**
     * Subtemplates are only accessible (in docx).
     * They will replace the `{?include subtemplate_dict_key}` tag in the docx.
     * @return Subtemplates for this print job. Hashtable<key, subTemplate>
     */
    public Hashtable<String, Resource> getSubTemplates() {
        return subTemplates;
    }

    /**
     * Subtemplates are only accessible (in docx).
     * They will replace the `{?include subtemplate_dict_key}` tag in the docx.
     * @param subTemplates for this print job. Hashtable<key, subTemplate>
     */
    public void setSubTemplates(Hashtable<String, Resource> subTemplates) {
        this.subTemplates = subTemplates;
    }

    /**
     * Renderelements will replace their corresponding tag in the template.
     * Multiple output files will be produced if the hashtable has more then one element, the AOP server will return
     * a zip file containing all of them.
     * @return Hashtable<filename, RenderElement>
     */
    public Hashtable<String, RenderElement> getData() {
        return data;
    }

    /**
     * Renderelements will replace their corresponding tag in the template.
     * Multiple output files will be produced if the hashtable has more then one element, the AOP server will return
     * a zip file containing all of them.
     * @param data Hashtable<filename, RenderElement>
     */
    public void setData(Hashtable<String, RenderElement> data) {
        this.data = data;
    }

    /**
     * A print job for the AOP server containing all the necessary information to generate the adequate JSON for the AOP server.
     * If you don't want to instantiate a variable, use null for this argument.
     * @param data data Hashtable<filename, RenderElement>
     *             Renderelements will replace their corresponding tag in the template.
     *             Multiple output files will be produced if the hashtable has more then one element, the AOP server will return
     *             a zip file containing all of them.
     * @param server Server to user for this printjob.
     * @param output object containing the output configuration for this printjob.
     * @param template for this printjob.
     * @param subTemplates  for this print job. Hashtable<key, subTemplate>
     *                      Subtemplates are only accessible (in docx).
     *                      They will replace the `{?include subtemplate_dict_key}` tag in the docx.
     * @param prependFiles Files to prepend to the output.
     * @param appendFiles Files to append to the output.
     */
    public PrintJob(Hashtable<String, RenderElement> data,Server server,Output output, Resource template,Hashtable<String,
            Resource> subTemplates, Resource[] prependFiles, Resource[] appendFiles){
        setData(data);
        setServer(server);
        setOutput(output);
        setTemplate(template);
        setSubTemplates(subTemplates);
        setPrependFiles(prependFiles);
        setAppendFiles(appendFiles);
    }

    /**
     * @return Jsonobject containing all the info about the printjob, for the POST request to the AOP server.
     */
    public JsonObject getJSON() throws MimeTypeException {
        JsonObject jsonForServer = new JsonObject();
        for(Map.Entry<String, JsonElement> tag : getServer().getJSON().entrySet()){
            jsonForServer.add(tag.getKey(),tag.getValue()); //these tags for the server need to be at the upper level in the JSON
        }
        jsonForServer.add("output", getOutput().getJSON());
        jsonForServer.add("template", getTemplate().getJSONForTemplate());
        //ArrayList<String> files = new ArrayList<String>();
        JsonArray files = new JsonArray();
        for(Map.Entry<String, RenderElement> data : getData().entrySet()){
            JsonObject file = new JsonObject();
            file.addProperty("filename",data.getKey());

            //this need to change for final version
            JsonArray testttt = new JsonArray();
            String ret = "{\"first_name\":\"DemoName\",\"last_name\":\"DemoLastName\",\"city\":\"DemoCity\"}";
            JsonObject testj = new JsonParser().parse(ret).getAsJsonObject();
            testttt.add(testj);
            file.add("data",testttt);
            //this need to change for final version
            
            //file.add("data",data.getValue().getJSON()); // pour plus tard mtn
            files.add(file);
        }
        jsonForServer.add("files", files);
        if (getPrependFiles() != null && getPrependFiles().length>0){
            JsonArray prependFiles = new JsonArray();
            for(Resource prependFile : getPrependFiles()){
                prependFiles.add(prependFile.getJSONForSecondaryFile()); //check je pense que malheureusement il manque les [] pour [files].
            }
            jsonForServer.add("prepend_files",prependFiles);
        }
        if (getAppendFiles() != null && getAppendFiles().length>0){
            JsonArray appendFiles = new JsonArray();
            for(Resource appendFile : getAppendFiles()){
                appendFiles.add(appendFile.getJSONForSecondaryFile()); //check je pense que malheureusement il manque les [] pour [files].
            }
            jsonForServer.add("append_files",appendFiles);
        }
        if (getSubTemplates()!=null){
            JsonArray subTemplates = new JsonArray();
            for(Map.Entry<String, Resource> subtemplate : getSubTemplates().entrySet()){
                JsonObject sub = subtemplate.getValue().getJSONForSecondaryFile();
                sub.addProperty("name",subtemplate.getKey());
                subTemplates.add(sub);
            }
            jsonForServer.add("templates",subTemplates);
        }

        return jsonForServer;
    }


    //add async version
    public Response execute() throws Exception {
        if (server == null){
            throw new Exception("No server specified.");
        }
        JsonObject JSONForServer = getJSON();
        System.out.println(JSONForServer.toString());

        if (server.isReachable() == true){
            return server.sendPOSTRequest(JSONForServer);
        }
        else {
            throw new Exception("Server is not reachable.");
        }

    }
}
