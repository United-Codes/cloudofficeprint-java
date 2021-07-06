package com.company.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class is a subclass of QRCode and is used to generate a WiFi QR-code element.
 */
public class WifiQRCode extends QRCode{

    private String password;
    private String encryption;
    private Boolean wifiHidden;

    /**
     * @return Password of the WiFi.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password Password of the WiFi.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Encryption type of the WiFi e.g. WPA, WEP, WEP2 etc.
     */
    public String getEncryption() {
        return encryption;
    }

    /**
     * @param encryption Encryption type of the WiFi e.g. WPA, WEP, WEP2 etc.
     */
    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    /**
     * @return Whether WiFi is hidden or not.
     */
    public Boolean getWifiHidden() {
        return wifiHidden;
    }

    /**
     * @param wifiHidden Whether WiFi is hidden or not.
     */
    public void setWifiHidden(Boolean wifiHidden) {
        this.wifiHidden = wifiHidden;
    }

    /**
     * This class is a subclass of QRCode and is used to generate a WiFi QR-code element.
     * Styling options can be set with the setter functions of the upper class.
     * @param name  Name of this code for the tag.
     * @param SSID SSID of the Wifi.
     */
    public WifiQRCode(String name, String SSID, String password, String encryption, Boolean wifiHidden) {
        super(name, "qr_wifi", SSID);
        setPassword(password);
        setEncryption(encryption);
        setWifiHidden(wifiHidden);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON(){
        JsonObject json = super.getJSON();
        if (getPassword()!= null){
            json.addProperty(getName()+"_wifi_password",getPassword());
        }
        if (getEncryption()!= null){
            json.addProperty(getName()+"_wifi_encryption",getEncryption());
        }
        if (getWifiHidden()!= null){
            json.addProperty(getName()+"_wifi_hidden",getWifiHidden());
        }
        return json;
    }
}
