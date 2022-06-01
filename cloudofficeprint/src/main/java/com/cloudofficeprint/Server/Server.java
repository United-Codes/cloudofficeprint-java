package com.cloudofficeprint.Server;

import com.cloudofficeprint.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing the Cloud Office Print server to interact with. This class
 * has a verbose mode.
 */
public class Server {

    private String APIKey;
    private JsonObject loggingInfo;
    private String url;
    private Printer printer;
    private Commands commands;
    private String proxyIP;
    private Integer proxyPort;
    private String username;
    private String password;

    private boolean verbose = false;

    /**
     * @return Whether to include debug prints or not.
     */
    public boolean isVerbose() {
        return verbose;
    }

    /**
     * @param verbose Whether to include debug prints or not.
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    /**
     * @return IP address of the proxy used, null if not used.
     */
    public String getProxyIP() {
        return proxyIP;
    }

    /**
     * @param proxyIP IP address of the proxy used, null if not used.
     */
    public void setProxyIP(String proxyIP) {
        this.proxyIP = proxyIP;
    }

    /**
     * @return Port of the proxy used, null if not used.
     */
    public Integer getProxyPort() {
        return proxyPort;
    }

    /**
     * @param proxyPort Port of the proxy used, null if not used.
     */
    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    /**
     * Only applicable for service users.
     *
     * @return The value of this key is the API key given by Cloud Office Print.
     */
    public String getAPIKey() {
        return APIKey;
    }

    /**
     * Only applicable for service users.
     *
     * @param APIKey given by Cloud Office Print.
     */
    public void setAPIKey(String APIKey) {
        this.APIKey = APIKey;
    }

    /**
     * When the Cloud Office Print server is started with --enable_printlog, it will
     * create a file on the server called server_printjob.log.
     *
     * @return Jsonobject with the extra information you want to be logged in that
     *         file.
     */
    public JsonObject getLoggingInfo() {
        return loggingInfo;
    }

    /**
     * When the Cloud Office Print server is started with --enable_printlog, it will
     * create a file on the server called server_printjob.log. You can add
     * additional logging information next to the one Cloud Office Print is logging
     * by default, by adding additional keys and values in the logging object.
     *
     * @param loginInfo Jsonobject with the information you want to be logged.
     */
    public void setLoggingInfo(JsonObject loginInfo) { // Need to change this to appart function maybe but need info :
                                                       // Sunil
        this.loggingInfo = loginInfo;
    }

    /**
     * @return URL of the Cloud Office Print server.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url of the Cloud Office Print server.
     */
    public void setUrl(String url) {
        if (!url.endsWith("/")){
            url += "/";
        }
        this.url = url;
    }

    /**
     * Cloud Office Print supports to print directly to an IP Printer.
     *
     * @return Printer object containing the required info for the Cloud Office
     *         Print server.
     */
    public Printer getPrinter() {
        return printer;
    }

    /**
     * Cloud Office Print supports to print directly to an IP Printer.
     *
     * @param printer Printer object containing the required info for the Cloud
     *                Office Print server.
     */
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    /**
     * @return Commands object with commands for the Cloud Office Print server to
     *         run before or after the post processing.
     */
    public Commands getCommands() {
        return commands;
    }

    /**
     * @param commands Commands object with commands for the Cloud Office Print
     *                 server to run before or after the post processing.
     */
    public void setCommands(Commands commands) {
        this.commands = commands;
    }

    /**
     * @return Username for the proxy authentication.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username Username for the proxy authentication.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Password for the proxy authentication.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password Password for the proxy authentication.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Most basic constructor of the server. Can be populated more with the set
     * functions.
     *
     * @param url of the Cloud Office Print server.
     */
    public Server(String url) {
        setUrl(url);
    }

    /**
     * Use default values if you don't want to specify an argument.
     *
     * @param url         of the Cloud Office Print server
     * @param APIKey      Only applicable for service users. The value of this key
     *                    is the API key given by Cloud Office Print.
     * @param printer     Cloud Office Print supports to print directly to an IP
     *                    Printer. Printer object containing the required info for
     *                    the Cloud Office Print server.
     * @param commands    Commands object with commands for the Cloud Office Print
     *                    server to run before or after the post processing.
     * @param loggingInfo When the Cloud Office Print server is started with
     *                    --enable_printlog, it will create a file on the server
     *                    called server_printjob.log. Jsonobject with the extra
     *                    information you want to be logged in that file.
     * @param proxyIP     IP of the optional proxy. Only HTTP proxies supported.
     * @param proxyPort   Port of the optional proxy. Only HTTP proxies supported.
     */
    public Server(String url, String APIKey, Printer printer, Commands commands, JsonObject loggingInfo, String proxyIP,
            Integer proxyPort) {
        setUrl(url);
        setAPIKey(APIKey);
        setPrinter(printer);
        setCommands(commands);
        setLoggingInfo(loggingInfo);
        setProxyIP(proxyIP);
        setProxyPort(proxyPort);
    }

    /**
     * @return JSONObject with the tags for the output for the Cloud Office Print
     *         server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getAPIKey() != null) {
            json.addProperty("api_key", getAPIKey());
        }
        if (getLoggingInfo() != null) {
            json.add("logging", getLoggingInfo());
        }
        if (getPrinter() != null) {
            json.add("ipp", getPrinter().getJSON());
        }
        if (getCommands() != null) {
            for (Map.Entry<String, JsonElement> tag : getCommands().getJSON().entrySet()) {
                json.add(tag.getKey(), tag.getValue()); // these tags need to be at the "highest" level in the JSON
            }
        }
        return json;
    }

    // add other helper functions

    /**
     * Sends a GET request to server-url/marco and checks if the answer is polo.
     *
     * @return true if the server is reachable.
     */
    public boolean isReachable() {
        String response = sendGETRequest(this.url + "marco");
        return response.equals("polo");
    }

    /**
     * Sends a GET request to server-url/soffice.
     *
     * @return current version of Libreoffice installed on the server.
     */
    public String getSofficeVersionServer() {
        return sendGETRequest(this.url + "soffice");
    }

    /**
     * Sends a GET request to server-url/officetopdf.
     *
     * @return current version of OfficeToPdf installed on the server. (Only
     *         available if the server runs in Windows environment).
     */
    public String getOfficeToPdfVersion() {
        return sendGETRequest(this.url + "officetopdf");
    }

    /**
     * Sends a GET request to server-url/supported_template_mimetypes.
     *
     * @return json of the mime types of templates that Cloud Office Print supports.
     */
    public String getMimeTypesSupported() {
        return sendGETRequest(this.url + "supported_template_mimetypes");
    }

    /**
     * Sends a GET request to
     * server-url/supported_output_mimetypes?template=extension. Note: You will get
     * empty json if the template extension isn't supported.
     *
     * @param extension Template extension.
     * @return The supported output types for the given template extension.
     */
    public String getOutputMimeTypesSupported(String extension) {
        return sendGETRequest(this.url + "supported_output_mimetypes?template=" + extension);
    }

    /**
     * Sends a GET request to server-url/supported_prepend_mimetypes.
     *
     * @return returns the supported prepend file mime types in JSON format.
     */
    public String getPrependMimeTypesSupported() {
        return sendGETRequest(this.url + "supported_prepend_mimetypes");
    }

    /**
     * Sends a GET request to server-url/version.
     *
     * @return returns the version of Cloud Office Print that is run on server.
     */
    public String getCOPVersionOnServer() {
        return sendGETRequest(this.url + "version");
    }

    /**
     * Sends a GET request to server-url/ipp_check?ipp_url=location&amp;version=version.
     * @param location url of the ipp printer.
     * @param version of the ipp printer.
     * @return the status of the ipp printer.
     */
    public String checkIPP(String location, String version){
        return sendGETRequest(this.url + String.format("ipp_check?ipp_url=%s&version=%s", location, version));
    }

    /**
     * Sends a GET request to server-url/verify_template_hash?hash=hash.
     * @param hash hashcode of a template.
     * @return status of the hashed template with the given hashcode.
     */
    public ResponseTemplateHash verifyTemplateHash(String hash){
        return new ResponseTemplateHash(sendGETRequest(this.url + String.format("verify_template_hash?hash=%s", hash)));
    }

    /**
     * Sends a GET request to server-url/renew_template_hash?hash=hash.
     * @param hash hashcode of a template.
     * @return status of the renewed hashed template with the given hashcode.
     */
    public ResponseTemplateHash renewTemplateHash(String hash){
        return new ResponseTemplateHash(sendGETRequest(this.url + String.format("renew_template_hash?hash=%s", hash)));
    }

    /**
     * Sends a GET request to server-url/invalidate_template_hash?hash=hash.
     * @param hash hashcode of a template.
     * @return status of the invalidated hashed template with the given hashcode.
     */
    public ResponseTemplateHash invalidateTemplateHash(String hash){
        return new ResponseTemplateHash(sendGETRequest(this.url + String.format("invalidate_template_hash?hash=%s", hash)));
    }

    /**
     * Sends a GET request to server-url/stats.
     * @param accessToken access token. If not used, give null.
     * @return json of the current statistics of the Cloud Office Print server.
     * @throws URISyntaxException when the server url has a syntax error.
     */
    public String getStatistics(String accessToken) throws URISyntaxException {
        URI uri = new URI(this.url + "stats");

        if (accessToken != null){
            uri = appendUri(uri.toString(), "access_token=" + accessToken);
        }

        return sendGETRequest(uri.toString());
    }

    /**
     * Sends a GET request to server-url/server_errors.
     * @param accessToken access token. If not used, give null.
     * @param latest the number of the latest lines of the log file you want. If not used, give null.
     * @return errors of the Cloud Office Print server in log file format.
     * @throws URISyntaxException when the server url has a syntax error.
     */
    public String getErrors(String accessToken, Integer latest) throws URISyntaxException {
        URI uri = new URI(this.url + "server_errors");

        if (accessToken != null){
            uri = appendUri(uri.toString(), "access_token=" + accessToken);
        }
        if (latest != null){
            uri = appendUri(uri.toString(), "latest=" + latest);
        }

        return sendGETRequest(uri.toString());
    }

    /**
     * Sends a GET request to server-url/server_printjobs.
     * @param accessToken access token. If not used, give null.
     * @param date the date of the print jobs you want. If not used, give null.
     * @return print jobs of the Cloud Office Print server in log file format.
     * @throws URISyntaxException when the server url has a syntax error.
     */
    public String getPrintJobs(String accessToken, String date) throws URISyntaxException {
        URI uri = new URI(this.url + "server_printjobs");

        if (accessToken != null){
            uri = appendUri(uri.toString(), "access_token=" + accessToken);
        }
        if (date != null){
            uri = appendUri(uri.toString(), "date=" + date);
        }

        return sendGETRequest(uri.toString());
    }

    /**
     * Sends a GET request to server-url/network_logs.
     * @param accessToken access token. If not used, give null.
     * @param date the date of the network logs you want. If not used, give null.
     * @return network logs of the Cloud Office Print server in log file format.
     * @throws URISyntaxException when the server url has a syntax error.
     */
    public String getNetworkLogs(String accessToken, String date) throws URISyntaxException {
        URI uri = new URI(this.url + "network_logs");

        if (accessToken != null){
            uri = appendUri(uri.toString(), "access_token=" + accessToken);
        }
        if (date != null){
            uri = appendUri(uri.toString(), "date=" + date);
        }

        return sendGETRequest(uri.toString());
    }

    /**
     * Sends a GET request to server-url/download/id.
     * @param id unique identifier of the polled print job.
     * @param secretKey used to encrypt the polled print job.
     * @param delete whether to delete the polled print job after download.
     * @return The Response of the polled print job with id.
     * @throws Exception when something goes wrong trying to download a response. This can be a connection error, file is not processed yet, incorrect parameters, ...
     */
    public Response download(String id, String secretKey, Boolean delete) throws Exception {
        URI uri = new URI(this.url + "download/" + id);

        if (secretKey != null){
            uri = appendUri(uri.toString(), "secretkey=" + secretKey);
        }
        if (delete != null){
            uri = appendUri(uri.toString(), "delete_after_download=" + delete);
        }

        URL obj = new URL(uri.toString());
        HttpURLConnection con;
        if (getProxyPort() != null) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(getProxyIP(), getProxyPort()));
            con = (HttpURLConnection) obj.openConnection(proxy);
        } else {
            con = (HttpURLConnection) obj.openConnection();
        }
        if (getUsername() != null && getPassword() != null) {
            String uspw = getUsername() + ':' + getPassword();
            String encodedString = Base64.getEncoder().encodeToString(uspw.getBytes());
            con.setRequestProperty("Proxy-Authorization", "Basic " + encodedString);
        }
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            String mime = Mimetype.getMimetypeFromContentType(con.getHeaderField("Content-Type"));
            String ext = Mimetype.getExtension(mime);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = con.getInputStream().read(buffer)) != -1) { // attempt is made to read as many as len bytes
                baos.write(buffer, 0, length);
            }

            if (ext.equals("json")){
                String responseString = baos.toString(String.valueOf(StandardCharsets.UTF_8));
                throw new RuntimeException("The Cloud Office Print server responded with the following json:\n" + responseString);
            }

            String templateHash = con.getHeaderField("Template-Hash");
            return new Response("." + ext, mime, baos.toByteArray(), templateHash);
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            throw new COPException(responseCode, response.toString());
        }
    }

    /**
     * Sends a GET request to the url.
     *
     * @param urlToJoin URL to send the GET request to.
     * @return body of the response of the request.
     */
    public String sendGETRequest(String urlToJoin) {
        try {
            String url = urlToJoin;
            URL obj = new URL(url);
            HttpURLConnection con;
            if (getProxyPort() != null) {
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(getProxyIP(), getProxyPort()));
                con = (HttpURLConnection) obj.openConnection(proxy);
            } else {
                con = (HttpURLConnection) obj.openConnection();
            }
            if (getUsername() != null && getPassword() != null) {
                String uspw = getUsername() + ':' + getPassword();
                String encodedString = Base64.getEncoder().encodeToString(uspw.getBytes());
                con.setRequestProperty("Proxy-Authorization", "Basic " + encodedString);
            }
            con.setRequestMethod("GET");
            if (isVerbose() == true) {
                System.out.println("Server.java : " + "Sending 'GET' request to URL : " + url);
            }
            int responseCode = con.getResponseCode();
            if (isVerbose() == true) {
                System.out.println("Server.java : " + "Response Code : " + responseCode);
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            if (isVerbose() == true) {
                System.out.println("Server.java : " + "server's response is : " + response);
                System.out.println();
            }
            // System.out.println(response + "\n");
            return response.toString();

        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }

    /**
     * Sends a POST request with the given json file as body.
     *
     * @param postData json to send to the server
     * @throws COPException when server response's code is not equal to 200.
     * @return Response object containing the file extension and body (in bytes)
     */
    public IResponse sendPOSTRequest(JsonObject postData) throws Exception {

        if (isVerbose() == true) {
            System.out.println("Server.java : " + "Json for server : " + postData.toString() + "\n");
        }
        URL obj = new URL(this.url);
        HttpURLConnection con;
        if (getProxyPort() != null) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(getProxyIP(), getProxyPort()));
            con = (HttpURLConnection) obj.openConnection(proxy);
        } else {
            con = (HttpURLConnection) obj.openConnection();
        }
        if (getUsername() != null && getPassword() != null) {
            String uspw = getUsername() + ':' + getPassword();
            String encodedString = Base64.getEncoder().encodeToString(uspw.getBytes());
            con.setRequestProperty("Proxy-Authorization", "Basic " + encodedString);
        }
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "JavaSDK");
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        OutputStream outputStream = con.getOutputStream();
        byte[] bytes = postData.toString().getBytes("UTF-8");
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
        if (isVerbose() == true) {
            System.out.println("Server.java : " + "Sending 'POST' request to URL : " + url);
        }
        int responseCode = con.getResponseCode();
        if (isVerbose() == true) {
            System.out.println("Server.java : " + "Response Code : " + responseCode);
        }
        if (responseCode == 200) {
            if (isVerbose() == true) {
                System.out.println("Server.java : " + "Content-Type : " + con.getHeaderField("Content-Type") + "\n");
            }
            String mime = Mimetype.getMimetypeFromContentType(con.getHeaderField("Content-Type"));
            String ext = Mimetype.getExtension(mime);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = con.getInputStream().read(buffer)) != -1) { // attempt is made to read as many as len bytes
                baos.write(buffer, 0, length);
            }

            String templateHash = con.getHeaderField("Template-Hash");

            JsonObject output = postData.getAsJsonObject("output");
            if (output.has("output_polling") && output.get("output_polling").getAsBoolean()){
                String responseString = baos.toString(String.valueOf(StandardCharsets.UTF_8));
                String url = JsonParser.parseString(responseString).getAsJsonObject().get("url").getAsString();

                Pattern pattern = Pattern.compile("/download/([a-zA-Z0-9]*)");
                Matcher matcher = pattern.matcher(url);

                String id;
                if (matcher.find()){
                    id = matcher.group(1);
                }
                else throw new Exception("Id was not found in the response json of the Cloud Office Print server.");

                String secretKey = null;
                if (output.has("secret_key")){
                    secretKey = output.get("secret_key").getAsString();
                }

                ResponsePolling response = new ResponsePolling(this, id, templateHash);
                response.setSecretKey(secretKey);
                return response;
            }
            return new Response("." + ext, mime, baos.toByteArray(), templateHash);
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            throw new COPException(responseCode, response.toString());
        }
    }

    /**
     * Function to read a local JSON file.
     *
     * @param path Local path of the file.
     * @return String of the json.
     * @throws FileNotFoundException If the file is not found.
     */
    public String readJson(String path) throws FileNotFoundException {
        StringBuffer dataString = new StringBuffer("");
        try {
            // String currentPath = new java.io.File("./src").getCanonicalPath();
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataString.append(data);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return dataString.toString();
    }

    private static URI appendUri(String uri, String appendQuery) throws URISyntaxException {
        URI oldUri = new URI(uri);

        String newQuery = oldUri.getQuery();
        if (newQuery == null) {
            newQuery = appendQuery;
        }
        else {
            newQuery += "&" + appendQuery;
        }

        return new URI(oldUri.getScheme(), oldUri.getAuthority(), oldUri.getPath(), newQuery, oldUri.getFragment());
    }
}
