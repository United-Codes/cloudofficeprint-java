package com.company;

import org.apache.commons.io.FileUtils;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {

    int APIKey;
    String loginInfo;
    String url;

    Server(String url){
        this.url = url;
    }

    public boolean isReachable(){
        String response = sendGETRequest(this.url+"/marco");
        return response.equals("polo");
    }

    public String sendGETRequest(String urlToJoin) {
        try {
        String url = urlToJoin;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
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
        //print in String
        System.out.println(response.toString());
        return response.toString();

        //Parsing Response as JSON
        //JSONObject myResponse = new JSONObject(response.toString());
        //System.out.println("result after Reading JSON Response");
        //System.out.println(myResponse);
        //System.out.println(myResponse.get("docx"));
        }
        catch (Exception e){
            System.out.println(e);
            return e.toString();
        }
    }

    /**
     * Sends a POST request with the given json file as body.
     * Gets back the response and stores the body locally.
     * @param postData json to send to the server
     * @throws AOPException when server response's code is not equal to 200.
     * @return Response object containing the file extension and body (in bytes)
     */
    public Response sendPOSTRequest( JSONObject postData) throws Exception{
        URL obj = new URL(this.url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        OutputStream outputStream = con.getOutputStream();
        byte[] bytes = postData.toString().getBytes("UTF-8");
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        if (responseCode == 200) {
            System.out.println("Response Code : " + responseCode);
            System.out.println("Content-Type : " + con.getHeaderField("Content-Type"));
            MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
            MimeType type = allTypes.forName(con.getHeaderField("Content-Type"));
            String ext = type.getExtension();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = con.getInputStream().read(buffer)) != -1) { //attempt is made to read as many as len bytes
                baos.write(buffer, 0, length);
            }

            Response response = new Response(ext,baos.toByteArray());
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
            //System.out.println(response.toString());
            throw new AOPException(responseCode,response.toString());
        }
    }


    public String readJson(String path) throws FileNotFoundException {
        StringBuffer dataString = new StringBuffer("");
        try {
            //String currentPath = new java.io.File("./src").getCanonicalPath();
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataString.append(data);
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataString.toString();
    }
}

