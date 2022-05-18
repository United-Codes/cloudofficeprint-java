package com.cloudofficeprint.Output;

import com.google.gson.JsonObject;

/**
 * Class for optional globalization options. Used in PrintJob.
 */
public class Globalization {
    private String dateFormat;
    private String dateTimeFormat;
    private String timestampFormat;
    private String timestampTzFormat;
    private String nlsSort;
    private String nlsComp;
    private String nlsNumericCharactersDecGrp;
    private String nlsCurrency;
    private String nlsTerritory;
    private String nlsLanguage;
    private String direction;
    private String appPrimaryLanguage;

    /**
     * @return the date format. Default used by COP is "DD-MON-YYYY".
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * @param dateFormat the date format. Default used by COP is "DD-MON-YYYY".
     */
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * @return the date time format. Default used by COP is "DD-MON-YYYY HH24:MI".
     */
    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    /**
     * @param dateTimeFormat the date time format. Default used by COP is "DD-MON-YYYY HH24:MI".
     */
    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    /**
     * @return the timestamp format. Default used by COP is "DD-MON-YYYY".
     */
    public String getTimestampFormat() {
        return timestampFormat;
    }

    /**
     * @param timestampFormat the timestamp format. Default used by COP is "DD-MON-YYYY".
     */
    public void setTimestampFormat(String timestampFormat) {
        this.timestampFormat = timestampFormat;
    }

    /**
     * @return the timestamp tz format. Default used by COP is "DD-MON-YYYY".
     */
    public String getTimestampTzFormat() {
        return timestampTzFormat;
    }

    /**
     * @param timestampTzFormat the timestamp tz format. Default used by COP is "DD-MON-YYYY".
     */
    public void setTimestampTzFormat(String timestampTzFormat) {
        this.timestampTzFormat = timestampTzFormat;
    }

    /**
     * @return the native language support sort. Default used by COP is "BINARY".
     */
    public String getNlsSort() {
        return nlsSort;
    }

    /**
     * @param nlsSort the native language support sort. Default used by COP is "BINARY".
     */
    public void setNlsSort(String nlsSort) {
        this.nlsSort = nlsSort;
    }

    /**
     * @return the native language support. Default used by COP is "BINARY".
     */
    public String getNlsComp() {
        return nlsComp;
    }

    /**
     * @param nlsComp the native language support. Default used by COP is "BINARY".
     */
    public void setNlsComp(String nlsComp) {
        this.nlsComp = nlsComp;
    }

    /**
     * @return the native language support. Default used by COP is ".,".
     */
    public String getNlsNumericCharactersDecGrp() {
        return nlsNumericCharactersDecGrp;
    }

    /**
     * @param nlsNumericCharactersDecGrp the native language support. Default used by COP is ".,".
     */
    public void setNlsNumericCharactersDecGrp(String nlsNumericCharactersDecGrp) {
        this.nlsNumericCharactersDecGrp = nlsNumericCharactersDecGrp;
    }

    /**
     * @return the native language support. Default used by COP is "$".
     */
    public String getNlsCurrency() {
        return nlsCurrency;
    }

    /**
     * @param nlsCurrency the native language support. Default used by COP is "$".
     */
    public void setNlsCurrency(String nlsCurrency) {
        this.nlsCurrency = nlsCurrency;
    }

    /**
     * @return the native language support. Default used by COP is "AMERICA".
     */
    public String getNlsTerritory() {
        return nlsTerritory;
    }

    /**
     * @param nlsTerritory the native language support. Default used by COP is "AMERICA".
     */
    public void setNlsTerritory(String nlsTerritory) {
        this.nlsTerritory = nlsTerritory;
    }

    /**
     * @return the native language support language. Default used by COP is "AMERICAN".
     */
    public String getNlsLanguage() {
        return nlsLanguage;
    }

    /**
     * @param nlsLanguage the native language support language. Default used by COP is "AMERICAN".
     */
    public void setNlsLanguage(String nlsLanguage) {
        this.nlsLanguage = nlsLanguage;
    }

    /**
     * @return the reading direction. Default used by COP is "ltr".
     */
    public String getDirection() {
        return direction;
    }

    /**
     * @param direction the reading direction. Default used by COP is "ltr".
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * @return the application primary language. Default used by COP is "en".
     */
    public String getAppPrimaryLanguage() {
        return appPrimaryLanguage;
    }

    /**
     * @param appPrimaryLanguage the application primary language. Default used by COP is "en".
     */
    public void setAppPrimaryLanguage(String appPrimaryLanguage) {
        this.appPrimaryLanguage = appPrimaryLanguage;
    }

    /**
     * Creates an instance of Globalization with all variables equal to null.
     */
    public Globalization(){

    }

    /**
     * @param dateFormat the date format. Default used by COP is "DD-MON-YYYY".
     * @param dateTimeFormat the date time format. Default used by COP is "DD-MON-YYYY HH24:MI".
     * @param timestampFormat the timestamp format. Default used by COP is "DD-MON-YYYY".
     * @param timestampTzFormat the timestamp tz format. Default used by COP is "DD-MON-YYYY".
     * @param nlsSort the native language support sort. Default used by COP is "BINARY".
     * @param nlsComp the native language support. Default used by COP is "BINARY".
     * @param nlsNumericCharactersDecGrp the native language support. Default used by COP is ".,".
     * @param nlsCurrency the native language support. Default used by COP is "$".
     * @param nlsTerritory the native language support. Default used by COP is "AMERICA".
     * @param nlsLanguage the native language support language. Default used by COP is "AMERICAN".
     * @param direction the reading direction. Default used by COP is "ltr".
     * @param appPrimaryLanguage the application primary language. Default used by COP is "en".
     */
    public Globalization(String dateFormat, String dateTimeFormat, String timestampFormat, String timestampTzFormat, String nlsSort, String nlsComp, String nlsNumericCharactersDecGrp, String nlsCurrency, String nlsTerritory, String nlsLanguage, String direction, String appPrimaryLanguage) {
        setDateFormat(dateFormat);
        setDateTimeFormat(dateTimeFormat);
        setTimestampFormat(timestampFormat);
        setTimestampTzFormat(timestampTzFormat);
        setNlsSort(nlsSort);
        setNlsComp(nlsComp);
        setNlsNumericCharactersDecGrp(nlsNumericCharactersDecGrp);
        setNlsCurrency(nlsCurrency);
        setNlsTerritory(nlsTerritory);
        setNlsLanguage(nlsLanguage);
        setDirection(direction);
        setAppPrimaryLanguage(appPrimaryLanguage);
    }

    /**
     * @return JSONObject with the tags for the globalization for the Cloud Office Print server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();

        if (getDateFormat() != null) {
            json.addProperty("date_format", getDateFormat());
        }
        if (getDateTimeFormat() != null) {
            json.addProperty("date_time_format", getDateTimeFormat());
        }
        if (getTimestampFormat() != null) {
            json.addProperty("timestamp_format", getTimestampFormat());
        }
        if (getTimestampTzFormat() != null) {
            json.addProperty("timestamp_tz_format", getTimestampTzFormat());
        }
        if (getNlsSort() != null) {
            json.addProperty("nls_sort", getNlsSort());
        }
        if (getNlsComp() != null) {
            json.addProperty("nls_comp", getNlsComp());
        }
        if (getNlsNumericCharactersDecGrp() != null) {
            json.addProperty("nls_numeric_characters_dec_grp", getNlsNumericCharactersDecGrp());
        }
        if (getNlsCurrency() != null) {
            json.addProperty("nls_currency", getNlsCurrency());
        }
        if (getNlsTerritory() != null) {
            json.addProperty("nls_territory", getNlsTerritory());
        }
        if (getNlsLanguage() != null) {
            json.addProperty("nls_language", getNlsLanguage());
        }
        if (getDirection() != null) {
            json.addProperty("direction", getDirection());
        }
        if (getAppPrimaryLanguage() != null) {
            json.addProperty("application_primary_language", getAppPrimaryLanguage());
        }

        return json;
    }
}
