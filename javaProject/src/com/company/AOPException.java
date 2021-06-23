package com.company;

/**
 * Class for handling a HTTP response of the AOP server when the responseCode is /= 200.
 * Has 4 variables responseCode, URID, userMessage and messageForSupport.
 */
public class AOPException extends Exception {

    /**
     * Response code of the HTPP response.
     */
    private int responseCode;

    /**
     * URID (unique request ID) of the HTTP request.
     */
    private String URID;

    /**
     * Message for the user explaining where the errors does come form.
     */
    private String userMessage;

    /**
     * Encrypted message to give to the AOP support for help.
     */
    private String messageForSupport;

    /**
     * Sets this.responseCode to responseCode.
     * Parses the given response error to get URID, userMessage, messageForSupport.
     * @param responseCode responseCode of the HTTP response of the AOP server.
     * @param error text of the HTTP response (error) of the AOP server.
     */
    public AOPException(int responseCode, String error) {
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

    /**
     * @return The response code of the HTTP response.
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * @return URID of the error.
     */
    public String getURID() {
        return URID;
    }

    /**
     * @return Encrypted message to give to the AOP support for help.
     */
    public String getMessageForSupport() {
        return messageForSupport;
    }

    /**
     * @return Message for the user explaining where the errors does come form.
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * @return A string representation of the error containing the response code and a message for the user.
     */
    public String toString(){
        return ("AOP server raised an error code: " + getResponseCode() + "\n" +
                "Usermessage : " + getUserMessage() + "\n" +
                "You can access the URID and the messageForAOPSupport in the error with their getter."
        ) ;
    }

}
