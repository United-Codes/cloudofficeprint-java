package com.CloudOfficePrint.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class is a subclass of QRCode and is used to generate a geolocation QR-code element
 */
public class GeolocationQRCode extends QRCode{

    private String altitude;
    private String longitude;

    /**
     * @return Altitude.
     */
    public String getAltitude() {
        return altitude;
    }

    /**
     * @param altitude Altitude.
     */
    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    /**
     * @return Longitude.
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude Longitude.
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * This object represents a VCF or vCard QR Code.
     * Use null if you don't want to specify an option.
     * Styling options can be set with the setter functions of the upper class.
     * @param name  Name of this code for the tag.
     * @param latitude Latitude.
     * @param altitude Altitude.
     * @param longitude Longitude.
     */
    public GeolocationQRCode(String name, String latitude, String altitude,String longitude) {
        super(name, "qr_geolocation", latitude);
        setAltitude(altitude);
        setLongitude(longitude);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON(){
        JsonObject json = super.getJSON();
        if (getLongitude()!= null){
            json.addProperty(getName()+"_geolocation_longitude",getLongitude());
        }
        if (getAltitude()!= null){
            json.addProperty(getName()+"_geolocation_altitude",getAltitude());
        }
        return json;
    }
}
