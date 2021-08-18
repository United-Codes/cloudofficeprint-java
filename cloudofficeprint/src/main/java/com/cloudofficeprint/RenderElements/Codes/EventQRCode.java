package com.cloudofficeprint.RenderElements.Codes;

import com.google.gson.JsonObject;

/**
 * This class is a subclass of QRCode and is used to generate an event QR-code
 * element
 */
public class EventQRCode extends QRCode {

    private String startDate;
    private String endDate;

    /**
     * @return Starting date of the event.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate Starting date of the event.
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return Ending date of the event.
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate Ending date of the event.
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * This object represents a Event QR Code. Use null if you don't want to specify
     * an option. Styling options can be set with the setter functions of the upper
     * class.
     * 
     * @param name      Name of this code for the tag.
     * @param summary   Summary of the event.
     * @param startdate Latitude.
     * @param enddate   Altitude.
     */
    public EventQRCode(String name, String summary, String startdate, String enddate) {
        super(name, "qr_event", summary);
        setStartDate(startdate);
        setEndDate(enddate);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = super.getJSON();
        if (getStartDate() != null) {
            json.addProperty(getName() + "_event_startdate", getStartDate());
        }
        if (getEndDate() != null) {
            json.addProperty(getName() + "_event_enddate", getEndDate());
        }
        return json;
    }
}
