package com.cloudofficeprint.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class is a subclass of QRCode and is used to generate a MeCard QR-code
 * element
 */
public class MECardQRCode extends QRCode {

    private String lastName;
    private String nickname;
    private String email;
    private String contactPrimary;
    private String contactSecondary;
    private String contactTertiary;
    private String website;
    private String birthday;
    private String notes;

    /**
     * @return Last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName Last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Nickname.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname Nickname.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return Email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email Email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Phone number.
     */
    public String getContactPrimary() {
        return contactPrimary;
    }

    /**
     * @param contactPrimary Phone number.
     */
    public void setContactPrimary(String contactPrimary) {
        this.contactPrimary = contactPrimary;
    }

    /**
     * @return Second phone number.
     */
    public String getContactSecondary() {
        return contactSecondary;
    }

    /**
     * @param contactSecondary Second phone number.
     */
    public void setContactSecondary(String contactSecondary) {
        this.contactSecondary = contactSecondary;
    }

    /**
     * @return Third phone number.
     */
    public String getContactTertiary() {
        return contactTertiary;
    }

    /**
     * @param contactTertiary Third phone number.
     */
    public void setContactTertiary(String contactTertiary) {
        this.contactTertiary = contactTertiary;
    }

    /**
     * @return Website.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website Website.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return Birthday.
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday Birthday.
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return Notes.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes Notes.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * This object represents a VCF or vCard QR Code. Use null if you don't want to
     * specify an option. Styling options can be set with the setter functions of
     * the upper class.
     * 
     * @param name             Name of this code for the tag.
     * @param firstName        First name.
     * @param lastName         Last name.
     * @param nickname         Nickname.
     * @param email            Email.
     * @param contactPrimary   First phone number.
     * @param contactSecondary Second phone number.
     * @param contactTertiary  Third phone number.
     * @param website          Website.
     * @param birthday         Birthday.
     * @param notes            Notes.
     */
    public MECardQRCode(String name, String firstName, String lastName, String nickname, String email,
            String contactPrimary, String contactSecondary, String contactTertiary, String website, String birthday,
            String notes) {
        super(name, "qr_me_card", firstName);
        setLastName(lastName);
        setNickname(nickname);
        setEmail(email);
        setContactPrimary(contactPrimary);
        setContactSecondary(contactSecondary);
        setContactTertiary(contactTertiary);
        setWebsite(website);
        setBirthday(birthday);
        setNotes(notes);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = super.getJSON();
        if (getLastName() != null) {
            json.addProperty(getName() + "_me_card_last_name", getLastName());
        }
        if (getNickname() != null) {
            json.addProperty(getName() + "_me_card_nickname", getNickname());
        }
        if (getEmail() != null) {
            json.addProperty(getName() + "_me_card_email", getEmail());
        }
        if (getContactPrimary() != null) {
            json.addProperty(getName() + "_me_card_contact_primary", getContactPrimary());
        }
        if (getContactSecondary() != null) {
            json.addProperty(getName() + "_me_card_contact_secondary", getContactSecondary());
        }
        if (getContactTertiary() != null) {
            json.addProperty(getName() + "_me_card_contact_tertiary", getContactTertiary());
        }
        if (getWebsite() != null) {
            json.addProperty(getName() + "_me_card_website", getWebsite());
        }
        if (getBirthday() != null) {
            json.addProperty(getName() + "_me_card_birthday", getBirthday());
        }
        if (getNotes() != null) {
            json.addProperty(getName() + "_me_card_notes", getNotes());
        }
        return json;
    }
}
