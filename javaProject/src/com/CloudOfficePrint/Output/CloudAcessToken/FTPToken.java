package com.CloudOfficePrint.Output.CloudAcessToken;

import com.google.gson.JsonObject;

/**
 * Class to use for FTP/SFTP tokens to store output on a FTP/SFTP server.
 */
public class FTPToken extends CloudAccessToken {

    /**
     * Host name or IP address of the FTP/SFTP server.
     */
    private String host;

    /**
     * Port number of the FTP/SFTP server. Default : 0 (The Cloud Office Print
     * server will then use port 21).
     */
    private int port = 0;

    /**
     * User name for the FTP/SFTP server. Default : null (The Cloud Office Print
     * server will then use anonymous as user).
     */
    private String username = null;

    /**
     * Password of the user for the FTP/SFTP server. Default : null (The Cloud
     * Office Print server will then use anonymous@ as password).
     */
    private String password = null;

    /**
     * @return Host name or IP address of the FTP/SFTP server.
     */
    public String getHost() {
        return host;
    }

    /**
     * @return Port number of the FTP/SFTP server.
     */
    public int getPort() {
        return port;
    }

    /**
     * @return User name for the FTP/SFTP server.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return Password of the user for the FTP/SFTP server.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param host Host name or IP address of the FTP/SFTP server.
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @param port Port number of the FTP/SFTP server.
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @param username User name for the FTP/SFTP server.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password Password of the user for the FTP/SFTP server.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Constructor for an FTPToken object. Needs to be used if output wants to be
     * stored on a FTP/SFTP server. If you don't need to instantiate some variables,
     * use their default value as argument. If no default value is specified this
     * argument is compulsory.
     * 
     * @param host     Host name or IP address of the FTP/SFTP server.
     * @param SFTP     True if server uses SFTP, false if server uses FTP.
     * @param port     Port number of the FTP/SFTP server. Default : 0 (The Cloud
     *                 Office Print server will then use port 21).
     * @param username User name for the FTP/SFTP server. Default : null (The Cloud
     *                 Office Print server will then use anonymous as user).
     * @param password Password of the user for the FTP/SFTP server. Default : null
     *                 (The Cloud Office Print server will then use anonymous@ as
     *                 password).
     */
    public FTPToken(String host, Boolean SFTP, int port, String username, String password) {
        setHost(host);
        if (SFTP == true) {
            setService("sftp");
        } else
            setService("ftp");
        setPort(port);
        setUsername(username);
        setPassword(password);
    }

    /**
     * @return JSONObject with the tags for the FTPToken for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("output_location", getService());
        JsonObject token = new JsonObject();
        token.addProperty("host", getHost());
        if (getPort() != 0) {
            token.addProperty("port", getPort());
        }
        if (getUsername() != null) {
            token.addProperty("user", getUsername());
        }
        if (getPassword() != null) {
            token.addProperty("password", getPassword());
        }
        json.add("cloud_access_token", token);
        return json;
    }
}
