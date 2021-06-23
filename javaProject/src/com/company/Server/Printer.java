package com.company.Server;

import com.google.gson.JsonObject;

/**
 * AOP supports to print directly to an IP Printer. If your IPP printer supports PDF files, your documents will be converter to PDF
 * and sent to IPP printer. If your printer does not support PDF and supports Postscript then the PDF generated is converter to PDF
 * using pdftops. You need download xpdf tools from: https://www.xpdfreader.com/download.html. Make sure that the binary pdftops is
 * on PATH variable. You can download executables from apexofficeprint.com to check whether or not your IPP printer supports PDF/postscript.
 *
 * This class represents an IP-enabled printer to use with the AOP server.
 */
public class Printer {

    private String location;
    private String version;
    private String requester;
    private String jobName;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Printer(String location, String version, String requester, String jobName){
        setLocation(location);
        setVersion(version);
        setRequester(requester);
        setJobName(jobName);
    }

    public JsonObject getJSON(){
        JsonObject json =new JsonObject();
        json.addProperty("location",getLocation());
        json.addProperty("version",getVersion());
        json.addProperty("requester",getRequester());
        json.addProperty("job_name",getJobName());
        return json;
    }
}
