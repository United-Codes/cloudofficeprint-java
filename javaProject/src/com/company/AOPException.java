package com.company;

/**
 * Class for handling http responses of the AOP server when the respondeCode is /= 200.
 * Has 4 variables responseCode,URID,userMessage,messageForSupport.
 */
public class AOPException extends Exception {

    private int responseCode;
    private String URID;
    private String userMessage;
    private String messageForSupport;

    /**
     * Sets this.responseCode to responseCode.
     * Parses the given response error to get URID, userMessage, messageForSupport.
     * @param responseCode responseCode of the HTTP response of the AOP server.
     * @param error text of the HTTP response (error) of the AOP server.
     */
    AOPException(int responseCode, String error) {
        this.responseCode = responseCode;
        System.out.println(error);
        String [] errorSplited = error.split("URID:");
        String [] splitForUrid = errorSplited[1].split(" ");
        URID = splitForUrid[0];

        errorSplited = error.split(URID);
        String [] splitForUserM = errorSplited[1].split("If you are contacting AOP support please make sure you include the following.");
        userMessage = splitForUserM[0];
        messageForSupport = splitForUserM[1];
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getURID() {
        return URID;
    }

    public String getMessageForSupport() {
        return messageForSupport;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String toString(){
        return ("AOP server raised an error code: " + getResponseCode() + "\n" +
                "Usermessage : " + getUserMessage() + "\n" +
                "You can access the URID and the messageForAOPSupport in the error with their getter."
        ) ;
    }

}
