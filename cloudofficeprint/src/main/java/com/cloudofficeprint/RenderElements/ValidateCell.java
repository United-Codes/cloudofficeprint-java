package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * It is possible to insert cell validation in excel using validate tag as {validate validateTag} (validate keyword followed by tagName)
 */
public class ValidateCell extends RenderElement {
    private Boolean ignoreBlank;
    private String allow;
    private String value1;
    private String value2;
    private Boolean inCellDropdown;
    private String data;
    private Boolean showInputMessage;
    private String inputTitle;
    private String inputMessage;
    private Boolean showErrorAlert;
    private String errorStyle;
    private String errorTitle;
    private String errorMessage;

    /**
     * Set it to false for not allowing empty values in cell. The value is true by default.
     * @return the value for ignore blank.
     */
    public Boolean getIgnoreBlank() {
        return ignoreBlank;
    }

    /**
     * Set it to false for not allowing empty values in cell. The value is true by default.
     * @param ignoreBlank the value of ignore blank
     */
    public void setIgnoreBlank(Boolean ignoreBlank) {
        this.ignoreBlank = ignoreBlank;
    }

    /**
     * Type of data used for validation. Available options are (anyValue, whole,
     * @return the value for allow attribute.
     */
    public String getAllow() {
        return allow;
    }

    /**
     * Type of data used for validation. Available options are (anyValue, whole,
     * @param allow the value for allow attribute.
     */
    public void setAllow(String allow) {
        this.allow = allow;
    }

    /**
     * Value to compare with.
     * @return the value of this attribute.
     */
    public String getValue1() {
        return value1;
    }

    /**
     * Value to compare with.
     * @param value1 the value of this attribute.<br><br>
     * Note:<br>
     *             These two options <strong>(_value1, _value2)</strong> can be used for any allow/type of validation that require values for comparison, in such case use <strong>"_value1"</strong> attribute as the first value to be passed and <strong>"_value2"</strong> attribute as the 2nd value.<br><br>
     *             Some allow type of validation require only one value to compare; in such case use <strong>"_value1"</strong> attribute.<br><br>
     *             For ex :<br>
     *             If allow type of validation is date and you have to check in between two dates.<br>
     *             Then you could use <strong>"_value1"</strong> attribute as start date and <strong>"_value2"</strong> attribute as end date.<br><br>
     *             If allow type of validation is whole and you have to check for value less than 100.<br>
     *             Then you could use <strong>"_value1"</strong> for that value and do not use "<strong>_value2".</strong><br><br>
     *             While using time and date as allow type validation, please provide date/time with correct formatting.<br>
     *             for time: <strong>hours:minutes:seconds</strong> i.e hours , minutes, seconds separated by colon (:)<br>
     *                 ex : 14:30:00 for 2:30 pm<br><br>
     *             for date: <strong>month/day/year</strong> i.e day, month , year separated by forward slash(/)<br>
     *                 ex : 02/07/2023 for Feb 7 2023.<br><br>
     *             for list: you could use normal string with elements separated by comma(,).<br>
     *                 ex : "first, second, third" for list of three elements.<br>
     */
    public void setValue1(String value1) {
        this.value1 = value1;
    }

    /**
     * Value to compare with.
     * @return the value of this attribute.
     *
     */
    public String getValue2() {
        return value2;
    }

    /**
     * Value to compare with.
     * @param value2 the value of this attribute.<br><br>
     * Note:<br>
     *             These two options <strong>(_value1, _value2)</strong> can be used for any allow/type of validation that require values for comparison, in such case use <strong>"_value1"</strong> attribute as the first value to be passed and <strong>"_value2"</strong> attribute as the 2nd value.<br><br>
     *             Some allow type of validation require only one value to compare; in such case use <strong>"_value1"</strong> attribute.<br><br>
     *             For ex :<br>
     *             If allow type of validation is date and you have to check in between two dates.<br>
     *             Then you could use <strong>"_value1"</strong> attribute as start date and <strong>"_value2"</strong> attribute as end date.<br><br>
     *             If allow type of validation is whole and you have to check for value less than 100.<br>
     *             Then you could use <strong>"_value1"</strong> for that value and do not use "<strong>_value2".</strong><br><br>
     *             While using time and date as allow type validation, please provide date/time with correct formatting.<br>
     *             for time: <strong>hours:minutes:seconds</strong> i.e hours , minutes, seconds separated by colon (:)<br>
     *                 ex : 14:30:00 for 2:30 pm<br><br>
     *             for date: <strong>month/day/year</strong> i.e day, month , year separated by forward slash(/)<br>
     *                 ex : 02/07/2023 for Feb 7 2023.<br><br>
     *             for list: you could use normal string with elements separated by comma(,).<br>
     *                 ex : "first, second, third" for list of three elements.<br>
     */
    public void setValue2(String value2) {
        this.value2 = value2;
    }

    /**
     * Set it to false for not showing dropdown button while validation allow type is list. It is true by default for list allow type.
     * @return value for cell drop down.
     */
    public Boolean getInCellDropdown() {
        return inCellDropdown;
    }

    /**
     * Set it to false for not showing dropdown button while validation allow type is list. It is true by default for list allow type.
     * @param inCellDropdown value for cell drop down.
     */
    public void setInCellDropdown(Boolean inCellDropdown) {
        this.inCellDropdown = inCellDropdown;
    }

    /**
     * Type of comparison to be done for the cell value. Available values are (lessThanOrEqual, notBetween, equal, notEqual, greaterThan, greaterThan, lessThan, greaterThanOrEqual, lessThanOrEqual). Default value is "between". Please use camelCase for the value as shown in examples.
     * @return value for data attribute.
     */
    public String getData() {
        return data;
    }

    /**
     * Type of comparison to be done for the cell value. Available values are (lessThanOrEqual, notBetween, equal, notEqual, greaterThan, greaterThan, lessThan, greaterThanOrEqual, lessThanOrEqual). Default value is "between". Please use camelCase for the value as shown in examples.
     * @param data value for data attribute.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Set it to false to hide message shown when the cell to validate is being selected. The value for it is true by default.
     * @return value for show input message.
     */
    public Boolean getShowInputMessage() {
        return showInputMessage;
    }

    /**
     * Set it to false to hide message shown when the cell to validate is being selected. The value for it is true by default.
     * @param showInputMessage value for show input message.
     */
    public void setShowInputMessage(Boolean showInputMessage) {
        this.showInputMessage = showInputMessage;
    }

    /**
     * Title of message to be shown when cell to validate is selected.
     * @return value for input title.
     */
    public String getInputTitle() {
        return inputTitle;
    }

    /**
     * Title of message to be shown when cell to validate is selected.
     * @param inputTitle value for input title.
     */
    public void setInputTitle(String inputTitle) {
        this.inputTitle = inputTitle;
    }

    /**
     * Message to be shown when cell to validate is selected.
     * @return value for input message.
     */
    public String getInputMessage() {
        return inputMessage;
    }

    /**
     * Message to be shown when cell to validate is selected.
     * @param inputMessage value for input message.
     */
    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    /**
     * Set it to false, if you want to hide error alert once cell validation fails. The value is true by default.
     * @return value for show error alert.
     */
    public Boolean getShowErrorAlert() {
        return showErrorAlert;
    }

    /**
     * Set it to false, if you want to hide error alert once cell validation fails. The value is true by default.
     * @param showErrorAlert value for show error alert.
     */
    public void setShowErrorAlert(Boolean showErrorAlert) {
        this.showErrorAlert = showErrorAlert;
    }

    /**
     * Type of error style when cell validation fails. The value is stop by default. Available options are(stop,waring, Information).
     * @return value for error style.
     */
    public String getErrorStyle() {
        return errorStyle;
    }

    /**
     * Type of error style when cell validation fails. The value is stop by default. Available options are(stop,waring, Information).
     * @param errorStyle value for error style.
     */
    public void setErrorStyle(String errorStyle) {
        this.errorStyle = errorStyle;
    }

    /**
     * Title of error to be shown when cell validation fails.
     * @return value for error title.
     */
    public String getErrorTitle() {
        return errorTitle;
    }

    /**
     * Title of error to be shown when cell validation fails.
     * @param errorTitle value for error title.
     */
    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }

    /**
     * Message of error to be shown when cell validation fails.
     * @return value for error message.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Message of error to be shown when cell validation fails.
     * @param errorMessage value for error message.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * It is possible to insert cell validation in Excel using validate tag as {validate validateTag} (validate keyword followed by tagName)
     * @param name Name of the validate tag. For {validate tagName}, tagName is name for this element.
     */
    public ValidateCell(String name) {
        setName(name);
    }

    /**
     * @return JSONObject with the tags for this element for the Cloud Office Print
     * server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if (getIgnoreBlank() != null) {
            json.addProperty(getName() + "_ignore_blank", getIgnoreBlank());
        }
        if (getAllow() != null) {
            json.addProperty(getName() + "_allow", getAllow());

        }
        if (getValue1() != null) {
            json.addProperty(getName() + "_value1", getValue1());

        }
        if (getValue2() != null) {
            json.addProperty(getName() + "_value2", getValue2());

        }
        if (getInCellDropdown() != null) {
            json.addProperty(getName() + "_in_cell_dropdown", getInCellDropdown());

        }
        if (getData() != null) {
            json.addProperty(getName() + "_data", getData());

        }
        if (getShowInputMessage() != null) {
            json.addProperty(getName() + "_show_input_message", getShowInputMessage());

        }
        if (getInputTitle() != null) {
            json.addProperty(getName() + "_input_title", getInputTitle());

        }
        if (getInputMessage() != null) {
            json.addProperty(getName() + "_input_message", getInputMessage());

        }
        if (getShowErrorAlert() != null) {
            json.addProperty(getName() + "_show_error_alert", getShowErrorAlert());

        }
        if (getErrorStyle() != null) {
            json.addProperty(getName() + "_error_style", getErrorStyle());

        }
        if (getErrorTitle() != null) {
            json.addProperty(getName() + "_error_title", getErrorTitle());

        }
        if (getErrorMessage() != null) {
            json.addProperty(getName() + "_error_message", getErrorMessage());
        }
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     * can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{validate " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
