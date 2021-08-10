package com.CloudOfficePrint.Output;

import com.google.gson.JsonObject;

/**
 * Class for all the optional PDF output options. Only for
 */
public class CsvOptions {

    private String textDelimiter;
    private String fieldSeparator;
    private Integer characterSet;


    /**
     * @return The text delimiter. Can be " or ' (default ").
     */
    public String getTextDelimiter() {
		return textDelimiter;
	}


    /**
     * @param textDelimiter The text delimiter. Can be " or ' (default ").
     */
	public void setTextDelimiter(String textDelimiter) {
		this.textDelimiter = textDelimiter;
	}


	/**
	 * @return The field separator. Default ,.
	 */
	public String getFieldSeparator() {
		return fieldSeparator;
	}


	/**
	 * @param fieldSeparator The field separator. Default ,.
	 */
	public void setFieldSeparator(String fieldSeparator) {
		this.fieldSeparator = fieldSeparator;
	}


	/**
	 * @return The character set. Should be an integer.
	 * See: https://wiki.openoffice.org/wiki/Documentation/DevGuide/Spreadsheets/Filter_Options#Filter_Options_for_Lotus.2C_dBase_and_DIF_Filters
     * for possible values. Default 0 or system encoding.
	 */
	public Integer getCharacterSet() {
		return characterSet;
	}


	/**
	 * @param characterSet The character set. Should be an integer.
	 * See: https://wiki.openoffice.org/wiki/Documentation/DevGuide/Spreadsheets/Filter_Options#Filter_Options_for_Lotus.2C_dBase_and_DIF_Filters
     * for possible values. Default 0 or system encoding.
	 */
	public void setCharacterSet(Integer characterSet) {
		this.characterSet = characterSet;
	}


	/**
     * Constructor for the CsvOptions object. Set the options with the setters. Uninitialized options won't be included in the JSON.
     */
    public CsvOptions(){
    }


    /**
     * @return JSON-representation of this object
     */
    public JsonObject getJSON(){
        JsonObject json = new JsonObject();
        if (getTextDelimiter() != null) {
        	json.addProperty("output_text_delimiter", getTextDelimiter());
        }
        if (getFieldSeparator() != null) {
        	json.addProperty("output_field_separator", getFieldSeparator());
        }
        if (getCharacterSet() != null) {
        	json.addProperty("output_character_set", getCharacterSet());
        }
        return json;
    }
}
