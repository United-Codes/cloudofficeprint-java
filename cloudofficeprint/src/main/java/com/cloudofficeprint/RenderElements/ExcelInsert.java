package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Inside Excel, it is possible to insert word, PowerPoint, excel and pdf file using AOP tag {?insert fileToInsert}.
 * Options available are:  you can provide dynamic icon and icon position.
 *                         you can preview the document in Excel.
 */
public class ExcelInsert extends RenderElement{
    private Boolean isPreview;
    private String icon;
    private String fromRow;
    private String fromCol;
    private String fromRowOff;
    private String fromColOff;
    private String toRow;
    private String toCol;
    private String toRowOff;
    private String toColOff;

    /**
     *  Allows you to see the preview of the document.
     *  Set it to true for preview. Defaults to false.
     * @return value for isPreview.
     */
    public Boolean getPreview() {
        return isPreview;
    }

    /**
     * Allows you to see the preview of the document.
     * Set it to true for preview. Defaults to false.
     * @param preview value for isPreview
     */
    public void setPreview(Boolean preview) {
        isPreview = preview;
    }

    /**
     * Icon to be showed as the document, when clicked on it, redirects it to file. Default icon is taken if not provided.
     * @return value for the icon. Source can be FTP, SFTP, URL or base64 encoded string.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Icon to be showed as the document, when clicked on it, redirects it to file. Default icon is taken if not provided.
     * @param icon value for the icon. Source can be FTP, SFTP, URL or base64 encoded string.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Position for top of icon. Defaults to row of the tag.
     * @return value for fromRow.
     */
    public String getFromRow() {
        return fromRow;
    }

    /**
     * Position for top of icon. Defaults to row of the tag.
     * @param fromRow value for fromRow.
     */
    public void setFromRow(String fromRow) {
        this.fromRow = fromRow;
    }

    /**
     * Position for left of icon. Defaults to column of the tag.
     * @return value for fromCol.
     */
    public String getFromCol() {
        return fromCol;
    }

    /**
     * Position for left of icon. Defaults to column of the tag.
     * @param fromCol value for fromCol.
     */
    public void setFromCol(String fromCol) {
        this.fromCol = fromCol;
    }

    /**
     * Space after the value of from Row. Defaults to 0. Values can be in cm, px, inch or points.
     * @return value for fromRow.
     */
    public String getFromRowOff() {
        return fromRowOff;
    }

    /**
     * Space after the value of from Row. Defaults to 0. Values can be in cm, px, inch or points.
     * @param fromRowOff value for fromRow.
     */
    public void setFromRowOff(String fromRowOff) {
        this.fromRowOff = fromRowOff;
    }

    /**
     * Space after the value of fromCol. Defaults to 0. Values can be in cm, px, inch or points.
     * @return value for fromColOff.
     */
    public String getFromColOff() {
        return fromColOff;
    }

    /**
     * Space after the value of fromCol. Defaults to 0. Values can be in cm, px, inch or points.
     * @param fromColOff value for fromColOff.
     */
    public void setFromColOff(String fromColOff) {
        this.fromColOff = fromColOff;
    }

    /**
     * Position for bottom of icon. Defaults to row of the tag + 3.
     * @return value for toRow.
     */
    public String getToRow() {
        return toRow;
    }

    /**
     * Position for bottom of icon. Defaults to row of the tag + 3.
     * @param toRow value for toRow.
     */
    public void setToRow(String toRow) {
        this.toRow = toRow;
    }

    /**
     * Position for right side of icon. Defaults to column of the tag.
     * @return value for toCol.
     */
    public String getToCol() {
        return toCol;
    }

    /**
     * Position for right side of icon. Defaults to column of the tag.
     * @param toCol value for toCol.
     */
    public void setToCol(String toCol) {
        this.toCol = toCol;
    }

    /**
     * Space after toRow value. Defaults to 20px. Values can be in cm, px, inch or points.
     * @return value for toRowOff.
     */
    public String getToRowOff() {
        return toRowOff;
    }

    /**
     * Space after toRow value. Defaults to 20px. Values can be in cm, px, inch or points.
     * @param toRowOff value for toRowOff.
     */
    public void setToRowOff(String toRowOff) {
        this.toRowOff = toRowOff;
    }

    /**
     * Space after toCol value. Defaults to 50px. Values can be in cm, px, inch or points.
     * @return value for toColOff.
     */
    public String getToColOff() {
        return toColOff;
    }

    /**
     * Space after toCol value. Defaults to 50px. Values can be in cm, px, inch or points.
     * @param toColOff value for toColOff.
     */
    public void setToColOff(String toColOff) {
        this.toColOff = toColOff;
    }

    /**
     *
     * @param name Name of insert tag. Ex(fileToInsert)
     * @param value File to insert of path to file. (Source can be FTP, SFTP, URL or base64encoded file.)
     */
    public ExcelInsert(String name, String value){
        setName(name);
        setValue(value);
    }


    /**
     *
     * @return JSONObject with the tags for this element for the Cloud Office Print
     * server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(),getValue());
        if (getPreview() != null){
            json.addProperty(getName() + "_isPreview",getPreview());
        }
        if (getIcon() != null){
            json.addProperty(getName()+"_icon",getIcon());
        }
        if (getFromRow() != null){
            json.addProperty(getName()+"_fromRow",getFromRow());
        }
        if (getFromCol() != null){
            json.addProperty(getName()+"_fromCol",getFromCol());
        }
        if (getFromRowOff() != null){
            json.addProperty(getName()+"_fromRowOff",getFromRowOff());
        }
        if (getFromColOff() != null){
            json.addProperty(getName()+"_fromColOff",getFromColOff());
        }
        if (getToRow() != null){
            json.addProperty(getName()+"_toRow",getToRow());
        }
        if (getToCol() != null){
            json.addProperty(getName()+"_toCol",getToCol());
        }
        if (getToRowOff() != null){
            json.addProperty(getName()+"_toRowOff",getToRowOff());
        }
        if (getToColOff() != null){
            json.addProperty(getName()+"_toColOff",getToColOff());
        }
        return json;
    }


    /**
     *
     * @return An immutable set containing all available template tags this element
     * can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{?insert " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);    }
}
