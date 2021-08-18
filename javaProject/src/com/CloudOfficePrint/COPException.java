package com.CloudOfficePrint;

import java.util.Arrays;

/**
 * Class for handling a HTTP response of the Cloud Office Print server when the
 * responseCode is /= 200. Has 4 variables responseCode, URID, userMessage and
 * messageForSupport.
 */
public class COPException extends Exception {

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
     * Encrypted message to give to the Cloud Office Print support for help.
     */
    private String messageForSupport;

    /**
     * Sets this.responseCode to responseCode. Parses the given response error to
     * get URID, userMessage, messageForSupport.
     * 
     * @param responseCode responseCode of the HTTP response of the Cloud Office
     *                     Print server.
     * @param error        text of the HTTP response (error) of the Cloud Office
     *                     Print server.
     */
    public COPException(int responseCode, String error) {
        this.responseCode = responseCode;
        System.out.println(error);
        String[] errorSplit = error.split("URID:");
        String[] splitForUrid = errorSplit[1].split(" ");
        URID = splitForUrid[0];
        errorSplit = error.split(URID);
        String[] splitForUserM = errorSplit[1]
                .split("If you are contacting AOP support please make sure you include the following.");
        // TODO: in the future change 'AOP support' to 'Cloud Office Print support'
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
     * @return Encrypted message to give to the Cloud Office Print support for help.
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
     * @return A string representation of the error containing the response code and
     *         a message for the user.
     */
    public String toString() {
        return ("Cloud Office Print server raised an error code: " + getResponseCode() + "\n" + "Usermessage : "
                + getUserMessage() + "\n"
                + "You can access the URID and the messageForSupport in the error with their getter.");
    }

}
