package com.company.Server;

import com.company.AOPException;
import com.company.Response;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.Buffer;
import java.util.Base64;
import java.util.Map;
import java.util.Scanner;

/**
 * Class representing the AOP server to interact with.
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
     * @return The value of this key is the API key given by APEXOfficePrint.
     */
    public String getAPIKey() {
        return APIKey;
    }

    /**
     * Only applicable for service users.
     * @param APIKey given by APEXOfficePrint.
     */
    public void setAPIKey(String APIKey) {
        this.APIKey = APIKey;
    }

    /**
     * When the AOP server is started with --enable_printlog, it will create a file on the server called server_printjob.log.
     * @return Jsonobject with the extra information you want to be logged in that file.
     */
    public JsonObject getLoggingInfo() {
        return loggingInfo;
    }

    /**
     * When the AOP server is started with --enable_printlog, it will create a file on the server called server_printjob.log.
     * You can add additional logging information next to the one AOP is logging by default,
     * by adding additional keys and values in the logging object.
     * @param loginInfo Jsonobject with the information you want to be logged.
     */
    public void setLoggingInfo(JsonObject loginInfo) { //Need to change this to appart function maybe but need info : Sunil
        this.loggingInfo = loginInfo;
    }

    /**
     * @return URL of the AOP server.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url of the AOP server.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * AOP supports to print directly to an IP Printer.
     * @return Printer object containing the required info for the AOP server.
     */
    public Printer getPrinter() {
        return printer;
    }

    /**
     * AOP supports to print directly to an IP Printer.
     * @param printer Printer object containing the required info for the AOP server.
     */
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    /**
     * @return Commands object with commands for the AOP server to run before or after the post processing.
     */
    public Commands getCommands() {
        return commands;
    }

    /**
     * @param commands Commands object with commands for the AOP server to run before or after the post processing.
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
     * Most basic constructor of the server. Can be populated more with the set functions.
     * @param url of the AOP server.
     */
    public Server(String url) {
        setUrl(url);
    }

    /**
     * Use default values if you don't want to specify an argument.
     * @param url of the AOP server
     * @param APIKey Only applicable for service users. The value of this key is the API key given by APEXOfficePrint.
     * @param printer AOP supports to print directly to an IP Printer. Printer object containing the required info for the AOP server.
     * @param commands Commands object with commands for the AOP server to run before or after the post processing.
     * @param loggingInfo When the AOP server is started with --enable_printlog, it will create a file on the server called server_printjob.log.
     *                    Jsonobject with the extra information you want to be logged in that file.
     * @param proxyIP IP of the optional proxy. Only HTTP proxies supported.
     * @param proxyPort Port of the optional proxy. Only HTTP proxies supported.
     */
    public Server(String url, String APIKey, Printer printer, Commands commands, JsonObject loggingInfo,
                  String proxyIP, Integer proxyPort) {
        setUrl(url);
        setAPIKey(APIKey);
        setPrinter(printer);
        setCommands(commands);
        setLoggingInfo(loggingInfo);
        setProxyIP(proxyIP);
        setProxyPort(proxyPort);
    }

    /**
     * @return JSONObject with the tags for the output for the AOP server.
     */
    public JsonObject getJSON(){
        JsonObject json =new JsonObject();
        if (getAPIKey()!=null){
            json.addProperty("api_key",getAPIKey());
        }
        if (getLoggingInfo()!= null){
            json.add("logging", getLoggingInfo());
        }
        if (getPrinter() != null){
            json.add("ipp",getPrinter().getJSON());
        }
        if (getCommands()!= null){
            for(Map.Entry<String, JsonElement> tag : getCommands().getJSON().entrySet()){
                json.add(tag.getKey(),tag.getValue()); //these tags need to be at the "highest" level in the JSON
            }
        }
        return json;
    }

    //add other helper functions

    /**
     * Sends a GET request to server-url/marco and checks if the answer is polo.
     * @return true if the server is reachable.
     */
    public boolean isReachable(){
        String response = sendGETRequest(this.url+"/marco");
        return response.equals("polo");
    }

    /**
     * Sends a GET request to server-url/soffice.
     * @return current version of Libreoffice installed on the server.
     */
    public String getSofficeVersionServer(){
        return sendGETRequest(this.url+"/soffice");
    }

    /**
     * Sends a GET request to server-url/officetopdf.
     * @return  current version of OfficeToPdf installed on the server. (Only available if the server runs in Windows environment).
     */
    public String getOfficeToPdfVersion(){
        return sendGETRequest(this.url+"/officetopdf");
    }

    /**
     * Sends a GET request to server-url/supported_template_mimetypes.
     * @return json of the mime types of templates that AOP supports.
     */
    public String getMimeTypesSupported(){
        return sendGETRequest(this.url+"/supported_template_mimetypes");
    }

    /**
     * Sends a GET request to server-url/supported_output_mimetypes?template=extension.
     * Note: You will get empty json if the template extension isn't supported.
     * @param extension Template extension.
     * @return The supported output types for the given template extension.
     */
    public String getOutputMimeTypesSupported(String extension){
        return sendGETRequest(this.url+"/supported_output_mimetypes?template="+extension);
    }

    /**
     * Sends a GET request to server-url/supported_prepend_mimetypes.
     * @return returns the supported prepend file mime types in JSON format.
     */
    public String getPrependMimeTypesSupported(){
        return sendGETRequest(this.url+"/supported_prepend_mimetypes");
    }

    /**
     * Sends a GET request to server-url/version.
     * @return returns the version of AOP that is run on server.
     */
    public String getAOPVersionOnServer(){
        return sendGETRequest(this.url+"/version");
    }

    /**
     * Sends a GET request to the url.
     * @param urlToJoin
     * @return body of the response of the request.
     */
    public String sendGETRequest(String urlToJoin) {
        try {
        String url = urlToJoin;
        URL obj = new URL(url);
        HttpURLConnection con;
        if(getProxyPort()!=null){
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(getProxyIP(), getProxyPort()));
            con = (HttpURLConnection) obj.openConnection(proxy);
        }
        else{
            con = (HttpURLConnection) obj.openConnection();
        }
        if (getUsername()!=null&&getPassword()!=null){
            String uspw = getUsername() + ':' + getPassword();
            String encodedString = Base64.getEncoder().encodeToString(uspw.getBytes());
            con.setRequestProperty("Proxy-Authorization", "Basic " + encodedString);
        }
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println();
        //System.out.println(response + "\n");
        return response.toString();

        }
        catch (Exception e){
            System.out.println(e);
            return e.toString();
        }
    }

    /**
     * Sends a POST request with the given json file as body.
     * @param postData json to send to the server
     * @throws AOPException when server response's code is not equal to 200.
     * @return Response object containing the file extension and body (in bytes)
     */
    public Response sendPOSTRequest(JsonObject postData) throws Exception{
        //System.out.println("Json for server : " + postData.toString());
        System.out.println("Files for server : " + postData.get("files").toString());
        URL obj = new URL(this.url);
        HttpURLConnection con;
        if(getProxyPort()!=null){
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(getProxyIP(), getProxyPort()));
            con = (HttpURLConnection) obj.openConnection(proxy);
        }
        else{
            con = (HttpURLConnection) obj.openConnection();
        }
        if (getUsername()!=null&&getPassword()!=null){
            String uspw = getUsername() + ':' + getPassword();
            String encodedString = Base64.getEncoder().encodeToString(uspw.getBytes());
            con.setRequestProperty("Proxy-Authorization", "Basic " + encodedString);
        }
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "AOPJavaSDK");
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        OutputStream outputStream = con.getOutputStream();
        byte[] bytes = postData.toString().getBytes("UTF-8");
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
        int responseCode = con.getResponseCode();
        System.out.println("Sending 'POST' request to URL : " + url);
        if (responseCode == 200) {
            System.out.println("Response Code : " + responseCode);
            System.out.println("Content-Type : " + con.getHeaderField("Content-Type")+"\n");
            MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
            MimeType type = allTypes.forName(con.getHeaderField("Content-Type"));
            String ext = type.getExtension();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = con.getInputStream().read(buffer)) != -1) { //attempt is made to read as many as len bytes
                baos.write(buffer, 0, length);
            }

            Response response = new Response(ext,type.toString(),baos.toByteArray());
            return response;
            }
        else {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            throw new AOPException(responseCode,response.toString());
        }
    }

    /**
     * Function to read a local JSON file.
     * @param path Local path of the file.
     * @return String of the json.
     * @throws FileNotFoundException
     */
    public String readJson(String path) throws FileNotFoundException {
        StringBuffer dataString = new StringBuffer("");
        try {
            //String currentPath = new java.io.File("./src").getCanonicalPath();
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataString.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataString.toString();
    }
}

