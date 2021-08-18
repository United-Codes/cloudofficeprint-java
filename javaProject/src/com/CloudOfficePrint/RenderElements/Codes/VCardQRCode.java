package com.CloudOfficePrint.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class is a subclass of QRCode and is used to generate a vCard QR-code
 * element
 */
public class VCardQRCode extends QRCode {

    private String firstName;
    private String lastName;
    private String email;
    private String website;

    /**
     * @return First name for the card.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName First name for the card.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Last name for the card.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName Last name for the card.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Email for the card.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email Email for the card.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Website for the card.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website Website for the card.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * This object represents a VCF or vCard QR Code. Styling options can be set
     * with the setter functions of the upper class.
     * 
     * @param name      Name of this code for the tag.
     * @param firstName First name for the card.
     * @param lastName  Last name for the card.
     * @param email     Email for the card.
     * @param website   Website for the card.
     */
    public VCardQRCode(String name, String firstName, String lastName, String email, String website) {
        super(name, "qr_vcard", firstName);
        setLastName(lastName);
        setEmail(email);
        setWebsite(website);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = super.getJSON();
        if (getLastName() != null) {
            json.addProperty(getName() + "_vcard_last_name", getLastName());
        }
        if (getEmail() != null) {
            json.addProperty(getName() + "_vcard_email", getEmail());
        }
        if (getWebsite() != null) {
            json.addProperty(getName() + "_vcard_website", getWebsite());
        }
        return json;
    }
}
