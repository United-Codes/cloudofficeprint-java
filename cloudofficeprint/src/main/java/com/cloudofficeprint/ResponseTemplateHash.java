package com.cloudofficeprint;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class ResponseTemplateHash {
    private Boolean valid;
    private String status;
    private String hash;
    private String expiryDateTime;
    private String expiryTimeRemaining;
    private LocalDateTime isoExpiryDateTime;
    private Integer msExpiryTimeRemaining;

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getExpiryDateTime() {
        return expiryDateTime;
    }

    public void setExpiryDateTime(String expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
    }

    public String getExpiryTimeRemaining() {
        return expiryTimeRemaining;
    }

    public void setExpiryTimeRemaining(String expiryTimeRemaining) {
        this.expiryTimeRemaining = expiryTimeRemaining;
    }

    public LocalDateTime getIsoExpiryDateTime() {
        return isoExpiryDateTime;
    }

    public void setIsoExpiryDateTime(LocalDateTime isoExpiryDateTime) {
        this.isoExpiryDateTime = isoExpiryDateTime;
    }

    public Integer getMsExpiryTimeRemaining() {
        return msExpiryTimeRemaining;
    }

    public void setMsExpiryTimeRemaining(Integer msExpiryTimeRemaining) {
        this.msExpiryTimeRemaining = msExpiryTimeRemaining;
    }

    public ResponseTemplateHash(Boolean valid, String status, String hash, String expiryDateTime, String expiryTimeRemaining, LocalDateTime isoExpiryDateTime, Integer msExpiryTimeRemaining) {
        setValid(valid);
        setStatus(status);
        setHash(hash);
        setExpiryDateTime(expiryDateTime);
        setExpiryTimeRemaining(expiryTimeRemaining);
        setIsoExpiryDateTime(isoExpiryDateTime);
        setMsExpiryTimeRemaining(msExpiryTimeRemaining);
    }

    public ResponseTemplateHash(String response){
        JsonObject json = JsonParser.parseString(response).getAsJsonObject();
        setValid(json.get("valid").getAsBoolean());
        setStatus(json.get("status").getAsString());
        setHash(json.get("hash").getAsString());
        if (json.has("expiry_date_time")){
            setExpiryDateTime(json.get("expiry_date_time").getAsString());
        }
        if (json.has("new_expiry_date_time")){
            setExpiryDateTime(json.get("new_expiry_date_time").getAsString());
        }
        if (json.has("expiry_time_remaining")){
            setExpiryTimeRemaining(json.get("expiry_time_remaining").getAsString());
        }
        if (json.has("iso_expiry_date_time")){
            String datetime = json.get("iso_expiry_date_time").getAsString();
            setIsoExpiryDateTime(LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));

        }
        if (json.has("ms_expiry_time_remaining")){
            setMsExpiryTimeRemaining(json.get("ms_expiry_time_remaining").getAsInt());
        }
    }

    @Override
    public String toString() {
        return "status: " + getStatus() +
                "\nvalid: " + getValid() +
                "\nhash: " + getHash() +
                "\nexpiry date ime: " + getExpiryDateTime() +
                "\nexpiry time remaining: " + getExpiryTimeRemaining() +
                "\niso expiry date time: " + getIsoExpiryDateTime() +
                "\nms expiry time remaining: " + getMsExpiryTimeRemaining();
    }
}
