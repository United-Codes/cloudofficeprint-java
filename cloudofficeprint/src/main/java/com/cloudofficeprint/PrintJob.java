package com.cloudofficeprint;

import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.ExternalResource;
import com.cloudofficeprint.Resources.Resource;
import com.cloudofficeprint.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Hashtable;
import java.util.Map;

/**
 * A print job for the Cloud Office Print server containing all the necessary
 * information to generate the adequate JSON for the Cloud Office Print server.
 */
public class PrintJob implements Runnable {
    private Server server;
    private Output output;
    private Resource template;
    private Resource[] prependFiles;
    private Resource[] appendFiles;
    private Hashtable<String, Resource> subTemplates = new Hashtable<String, Resource>();
    private Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
    private ExternalResource externalResource;
    private Boolean copRemoteDebug;

    private volatile IResponse response; // for asynchronous calls

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
     * Subtemplates are only accessible (in docx). They will replace the `{?include
     * subtemplate_dict_key}` tag in the docx.
     *
     * @return Subtemplates for this print job. Hashtable(key, subTemplate).
     */
    public Hashtable<String, Resource> getSubTemplates() {
        return subTemplates;
    }

    /**
     * Subtemplates are only accessible (in docx). They will replace the `{?include
     * subtemplate_dict_key}` tag in the docx.
     *
     * @param subTemplates for this print job. Hashtable(key, subTemplate).
     */
    public void setSubTemplates(Hashtable<String, Resource> subTemplates) {
        this.subTemplates = subTemplates;
    }

    /**
     * Renderelements will replace their corresponding tag in the template. Multiple
     * output files will be produced if the hashtable has more then one element, the
     * Cloud Office Print server will return a zip file containing all of them.
     *
     * @return Hashtable(filename, RenderElement)
     */
    public Hashtable<String, RenderElement> getData() {
        return data;
    }

    /**
     * Renderelements will replace their corresponding tag in the template. Multiple
     * output files will be produced if the hashtable has more then one element, the
     * Cloud Office Print server will return a zip file containing all of them.
     *
     * @param data Hashtable(filename, RenderElement)
     */
    public void setData(Hashtable<String, RenderElement> data) {
        this.data = data;
    }

    /**
     * @return If set to true the Cloud Office Print server will log your JSON into
     *         out database and you can see it when you log into
     *         cloudofficeprint.com.
     */
    public Boolean getCopRemoteDebug() {
        return copRemoteDebug;
    }

    /**
     * @param copRemoteDebug If set to true the Cloud Office Print server will log
     *                       your JSON into out database and you can see it when you
     *                       log into cloudofficeprint.com.
     */
    public void setCopRemoteDebug(Boolean copRemoteDebug) {
        this.copRemoteDebug = copRemoteDebug;
    }

    /**
     * @return External resource for the data (REST or graphQL).
     */
    public ExternalResource getExternalResource() {
        return externalResource;
    }

    /**
     * @param externalResource External resource for the data (REST or graphQL).
     */
    public void setExternalResource(ExternalResource externalResource) {
        this.externalResource = externalResource;
    }

    /**
     * For getting to response after asynchronous execution. To used after run() has
     * been called and the thread joined.
     *
     * @return Response of the request to Cloud Office Print.
     */
    public IResponse getResponse() {
        return response;
    }

    /**
     * For setting to response after asynchronous execution. Call getResponse()
     * after run() has been called and the thread joined to get the response.
     *
     * @param response Response of the request to Cloud Office Print.
     */
    public void setResponse(IResponse response) {
        this.response = response;
    }

    /**
     * A print job for the Cloud Office Print server containing all the necessary
     * information to generate the adequate JSON for the Cloud Office Print server.
     * If you don't want to instantiate a variable, use null for this argument.
     *
     * @param data           Hashtable of (filename, RenderElement) elements.
     *                       Multiple output files will be produced if the hashtable
     *                       has more then one element, the Cloud Office Print
     *                       server will return a zip file containing all of them.
     * @param server         Server to user for this printjob.
     * @param output         object containing the output configuration for this
     *                       printjob.
     * @param template       for this printjob.
     * @param subTemplates   for this print job. Hashtable(key, subTemplate)
     *                       Subtemplates are only accessible (in docx). They will
     *                       replace the `{?include subtemplate_dict_key}` tag in
     *                       the docx.
     * @param prependFiles   Files to prepend to the output.
     * @param appendFiles    Files to append to the output.
     * @param copRemoteDebug If set to true the Cloud Office Print server will log
     *                       your JSON into out database and you can see it when you
     *                       log into cloudofficeprint.com.
     */
    public PrintJob(Hashtable<String, RenderElement> data, Server server, Output output, Resource template,
            Hashtable<String, Resource> subTemplates, Resource[] prependFiles, Resource[] appendFiles,
            Boolean copRemoteDebug) {
        setData(data);
        setServer(server);
        setOutput(output);
        setTemplate(template);
        setSubTemplates(subTemplates);
        setPrependFiles(prependFiles);
        setAppendFiles(appendFiles);
        setCopRemoteDebug(copRemoteDebug);
    }

    /**
     * A print job for the Cloud Office Print server containing all the necessary
     * information to generate the adequate JSON for the Cloud Office Print server.
     * If you don't want to instantiate a variable, use null for this argument.
     *
     * @param externalResource External resource for the data (REST or graphQL).
     * @param server           Server to user for this printjob.
     * @param output           object containing the output configuration for this
     *                         printjob.
     * @param template         Template for this printjob. If no template is
     *                         specified Cloud Office Print will generate a template
     *                         based on the data. Output type determines the
     *                         template type generated. Cannot be PDF in this case.
     * @param subTemplates     for this print job. Hashtable(key, subTemplate)
     *                         Subtemplates are only accessible (in docx). They will
     *                         replace the `{?include subtemplate_dict_key}` tag in
     *                         the docx.
     * @param prependFiles     Files to prepend to the output.
     * @param appendFiles      Files to append to the output.
     * @param copRemoteDebug   If set to true the Cloud Office Print server will log
     *                         your JSON into out database and you can see it when
     *                         you log into cloudofficeprint.com.
     */
    public PrintJob(ExternalResource externalResource, Server server, Output output, Resource template,
            Hashtable<String, Resource> subTemplates, Resource[] prependFiles, Resource[] appendFiles,
            Boolean copRemoteDebug) {
        setExternalResource(externalResource);
        setServer(server);
        setOutput(output);
        setTemplate(template);
        setSubTemplates(subTemplates);
        setPrependFiles(prependFiles);
        setAppendFiles(appendFiles);
        setCopRemoteDebug(copRemoteDebug);
    }

    /**
     * @return Jsonobject containing all the info about the printjob, for the POST
     *         request to the Cloud Office Print server.
     */
    public JsonObject getJSON() {
        JsonObject jsonForServer = new JsonObject();

        jsonForServer.addProperty("tool", "java_sdk");
        jsonForServer.addProperty("java_sdk_version", "21.2.0");

        for (Map.Entry<String, JsonElement> tag : getServer().getJSON().entrySet()) {
            jsonForServer.add(tag.getKey(), tag.getValue()); // these tags for the server need to be at the upper level
                                                             // in the JSON
        }

        if (getOutput() != null) {
            jsonForServer.add("output", getOutput().getJSON());
        }
        if (getTemplate() != null) {
            jsonForServer.add("template", getTemplate().getJSONForTemplate());
        }

        if (!(((JsonObject) jsonForServer.get("output")).has("output_type"))) {
            if (getTemplate() != null) {
                ((JsonObject) jsonForServer.get("output")).addProperty("output_type", getTemplate().getFiletype());
            } else {
                ((JsonObject) jsonForServer.get("output")).addProperty("output_type", "docx");

            }
        }

        if (getSubTemplates() != null) {
            JsonArray subTemplates = new JsonArray();
            for (Map.Entry<String, Resource> subtemplate : getSubTemplates().entrySet()) {
                JsonObject sub = subtemplate.getValue().getJSONForSecondaryFile();
                sub.addProperty("name", subtemplate.getKey());
                subTemplates.add(sub);
            }
            jsonForServer.add("templates", subTemplates);
        }

        if (getAppendFiles() != null && getAppendFiles().length > 0) {
            JsonArray appendFiles = new JsonArray();
            for (Resource appendFile : getAppendFiles()) {
                appendFiles.add(appendFile.getJSONForSecondaryFile());
            }
            jsonForServer.add("append_files", appendFiles);
        }

        JsonArray files = new JsonArray();
        if (getExternalResource() == null) {
            for (Map.Entry<String, RenderElement> data : getData().entrySet()) {
                JsonObject file = new JsonObject();
                file.addProperty("filename", data.getKey());
                file.add("data", data.getValue().getJSON());

                files.add(file);
            }
        } else {
            files.add(getExternalResource().getJSON()); // external resource was specified for the data
        }
        jsonForServer.add("files", files);
        if (getCopRemoteDebug() != null) {
            jsonForServer.addProperty("aop_remote_debug", getCopRemoteDebug());
        }
        if (getPrependFiles() != null && getPrependFiles().length > 0) {
            JsonArray prependFiles = new JsonArray();
            for (Resource prependFile : getPrependFiles()) {
                prependFiles.add(prependFile.getJSONForSecondaryFile());
            }
            jsonForServer.add("prepend_files", prependFiles);
        }

        return jsonForServer;
    }

    /**
     * Creates the adequate JSON and sends it to the Cloud Office Print server.
     *
     * @return The response of the Cloud Office Print server.
     * @throws Exception    If the server is not reachable.
     * @throws COPException If the server response doesn't have a 200 code.
     */
    public IResponse execute() throws Exception {
        JsonObject JSONForServer = getJSON();
        return server.sendPOSTRequest(JSONForServer);
    }

    /**
     * Asynchronous version of execute(). The response can be obtained with the
     * getResponse() function. Creates the adequate JSON and sends it to the Cloud
     * Office Print server.
     */
    public void run() {
        JsonObject JSONForServer = null;
        JSONForServer = getJSON();
        if (getServer().isReachable() == true) {
            try {
                setResponse(getServer().sendPOSTRequest(JSONForServer));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Server is not reachable.");
        }
    }

}
