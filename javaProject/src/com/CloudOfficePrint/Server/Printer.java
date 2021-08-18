package com.CloudOfficePrint.Server;

import com.google.gson.JsonObject;

/**
 * Cloud Office Print supports to print directly to an IP Printer. If your IPP
 * printer supports PDF files, your documents will be converter to PDF and sent
 * to IPP printer. If your printer does not support PDF and supports Postscript
 * then the PDF generated is converter to PDF using pdftops. You need download
 * xpdf tools from: https://www.xpdfreader.com/download.html. Make sure that the
 * binary pdftops is on PATH variable. You can download executables from
 * cloudofficeprint.com to check whether or not your IPP printer supports
 * PDF/postscript.
 *
 * This class represents an IP-enabled printer to use with the Cloud Office
 * Print server.
 */
public class Printer {

    private String location;
    private String version;
    private String requester;
    private String jobName;

    /**
     * @return Address where the printer is available.
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location Address where the printer is available.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return IPP version used.
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version IPP version used.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return Name of the requester. (Often just your name).
     */
    public String getRequester() {
        return requester;
    }

    /**
     * @param requester Name of the requester. (Often just your name).
     */
    public void setRequester(String requester) {
        this.requester = requester;
    }

    /**
     * @return Name of the job for the printer.
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName Name of the job for the printer.
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Cloud Office Print supports to print directly to an IP Printer. If your IPP
     * printer supports PDF files, your documents will be converter to PDF and sent
     * to IPP printer. If your printer does not support PDF and supports Postscript
     * then the PDF generated is converter to PDF using pdftops. You need download
     * xpdf tools from: https://www.xpdfreader.com/download.html. Make sure that the
     * binary pdftops is on PATH variable. You can download executables from
     * cloudofficeprint.com to check whether or not your IPP printer supports
     * PDF/postscript. This Pritner object represents an IP-enabled printer to use
     * with the Cloud Office Print server.
     * 
     * @param location  HTTP adress of the printer.
     * @param version   Version of the IPP protocol.
     * @param requester Name of the requester for the printer (often just your
     *                  name).
     * @param jobName   Name of the job for the printer.
     */
    public Printer(String location, String version, String requester, String jobName) {
        setLocation(location);
        setVersion(version);
        setRequester(requester);
        setJobName(jobName);
    }

    /**
     * @return JSONObject with the tags for the printer for the Cloud Office Print
     *         server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("location", getLocation());
        json.addProperty("version", getVersion());
        json.addProperty("requester", getRequester());
        json.addProperty("job_name", getJobName());
        return json;
    }
}
