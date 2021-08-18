package com.cloudofficeprint.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class is a subclass of QRCode and is used to generate an email QR-code
 * element
 */
public class EmailQRCode extends QRCode {

    private String cc;
    private String bcc;
    private String subject;
    private String body;

    /**
     * @return Extra receiver (cc).
     */
    public String getCc() {
        return cc;
    }

    /**
     * @param cc Extra receiver (cc).
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * @return Blind receiver (bcc).
     */
    public String getBcc() {
        return bcc;
    }

    /**
     * @param bcc Blind receiver (bcc).
     */
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    /**
     * @return Subject of the e-mail.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject Subject of the e-mail.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return Body of the e-mail.
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body Body of the e-mail.
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * This object represents a mail QR-code. Use null if you don't want to specify
     * some options. Styling options can be set with the setter functions of the
     * upper class.
     * 
     * @param name     Name of this code for the tag.
     * @param receiver Mail address of the receiver.
     * @param cc       Extra receivers (cc).
     * @param bcc      Extra blind receivers (bcc).
     * @param subject  Subject of the e-mail.
     * @param body     Body of the e-mail.
     */
    public EmailQRCode(String name, String receiver, String cc, String bcc, String subject, String body) {
        super(name, "qr_email", receiver);
        setCc(cc);
        setBcc(bcc);
        setSubject(subject);
        setBody(body);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = super.getJSON();
        if (getCc() != null) {
            json.addProperty(getName() + "_email_cc", getCc());
        }
        if (getBcc() != null) {
            json.addProperty(getName() + "_email_bcc", getBcc());
        }
        if (getSubject() != null) {
            json.addProperty(getName() + "_email_subject", getSubject());
        }
        if (getBody() != null) {
            json.addProperty(getName() + "_email_body", getBody());
        }
        return json;
    }
}
