package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

public class ProtectSheet extends RenderElement{
    private Boolean autoFilter;
    private Boolean deleteColumns;
    private Boolean deleteRows;
    private Boolean formatCells;
    private Boolean formatColumns;
    private Boolean formatRows;
    private Boolean insertColumns;
    private Boolean insertHyperlinks;
    private Boolean insertRows;
    private String password;
    private Boolean pivotTables;
    private Boolean selectLockedCells;
    private Boolean selectUnlockedCells;
    private Boolean sort;

    /**
     * Returns value to determine whether to lock autoFilter or not.
     */
    public Boolean getAutoFilter() {
        return this.autoFilter;
    }

    /**
     * Sets value for autoFilter
     * @param autoFilter lock auto filter.
     */
    public void setAutoFilter(Boolean autoFilter) {
        this.autoFilter = autoFilter;
    }

    /**
     * Returns value to determine whether to lock deleteColumns or not.
     */
    public Boolean getDeleteColumns() {
        return this.deleteColumns;
    }

    /**
     * Sets value for deleteColumns
     * @param deleteColumns lock delete columns
     */
    public void setDeleteColumns(Boolean deleteColumns) {
        this.deleteColumns = deleteColumns;
    }

    /**
     * Returns value to determine whether to lock deleteRows or not.

     */
    public Boolean getDeleteRows() {
        return this.deleteRows;
    }

    /**
     * Sets value for deleteRows
     * @param deleteRows lock delete rows.
     */
    public void setDeleteRows(Boolean deleteRows) {
        this.deleteRows = deleteRows;
    }

    /**
     * Returns value to determine whether to lock formatCells or not.

     */
    public Boolean getFormatCells() {
        return this.formatCells;
    }

    /**
     * Sets value for formatCells
     * @param formatCells lock format cells.
     */
    public void setFormatCells(Boolean formatCells) {
        this.formatCells = formatCells;
    }

    /**
     * Returns value to determine whether to lock formatColumns or not.

     */
    public Boolean getFormatColumns() {
        return this.formatColumns;
    }

    /**
     * Sets value for formatColumns
     * @param formatColumns lock format columns.
     */
    public void setFormatColumns(Boolean formatColumns) {
        this.formatColumns = formatColumns;
    }

    /**
     * Returns value to determine whether to lock formatRows or not.

     */
    public Boolean getFormatRows() {
        return this.formatRows;
    }

    /**
     * Sets value for formatRows
     * @param formatRows lock format rows.
     */
    public void setFormatRows(Boolean formatRows) {
        this.formatRows = formatRows;
    }

    /**
     * Returns value to determine whether to lock insertColumns or not.

     */
    public Boolean getInsertColumns() {
        return this.insertColumns;
    }

    /**
     * Sets value for insertColumns
     * @param insertColumns lock insert columns.
     */
    public void setInsertColumns(Boolean insertColumns) {
        this.insertColumns = insertColumns;
    }

    /**
     * Returns value to determine whether to lock insertHyperlinks or not.

     */
    public Boolean getInsertHyperlinks() {
        return this.insertHyperlinks;
    }

    /**
     * Sets value for insertHyperlinks
     * @param insertHyperlinks lock insert hyperlinks.
     */
    public void setInsertHyperlinks(Boolean insertHyperlinks) {
        this.insertHyperlinks = insertHyperlinks;
    }

    /**
     * Returns value to determine whether to lock insertRows or not.

     */
    public Boolean getInsertRows() {
        return this.insertRows;
    }

    /**
     * Sets value for insertRows
     * @param insertRows lock insert rows.
     */
    public void setInsertRows(Boolean insertRows) {
        this.insertRows = insertRows;
    }

    /**
     * Returns value to protect sheet with.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets value for password
     * @param password password to lock with.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns value to determine whether to lock pivotTables or not.

     */
    public Boolean getPivotTables() {
        return this.pivotTables;
    }

    /**
     * Sets value for pivotTables
     * @param pivotTables lock pivot tables.
     */
    public void setPivotTables(Boolean pivotTables) {
        this.pivotTables = pivotTables;
    }

    /**
     * Returns value to determine whether to lock selectLockedCells or not.

     */
    public Boolean getSelectLockedCells() {
        return this.selectLockedCells;
    }

    /**
     * Sets value for selectLockedCells
     * @param selectLockedCells lock select locked cells.
     */
    public void setSelectLockedCells(Boolean selectLockedCells) {
        this.selectLockedCells = selectLockedCells;
    }

    /**
     * Returns value to determine whether to lock selectUnlockedCells or not.

     */
    public Boolean getSelectUnlockedCells() {
        return this.selectUnlockedCells;
    }

    /**
     * Sets value for selectUnlockedCells
     * @param selectUnlockedCells select unlocked cells.
     */
    public void setSelectUnlockedCells(Boolean selectUnlockedCells) {
        this.selectUnlockedCells = selectUnlockedCells;
    }

    /**
     * Returns value to determine whether to lock sort or not.

     */
    public Boolean getSort() {
        return this.sort;
    }

    /**
     * Sets value for sort
     * @param sort lock sort.
     */
    public void setSort(Boolean sort) {
        sort = this.sort;
    }

    /**
     * You can protect sheet just by introducing protect tag in template and name for that tag can be provided from here.
     * @param name Name of the protect tag.
     */
    public ProtectSheet(String name){
        setName(name);
    }
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        if(getValue() != null){
            json.addProperty(getValue(),getValue());
        }
        if (getAutoFilter() != null) {
            json.addProperty(getName()+"_allow_auto_filter",getAutoFilter());
        }
        if (getDeleteColumns() != null){
            json.addProperty(getName()+"_allow_delete_columns",getDeleteColumns());
        }
        if (getDeleteRows() != null){
            json.addProperty(getName()+"_allow_delete_rows",getDeleteRows());

        }        if (getFormatCells() != null){
            json.addProperty(getName()+"_allow_format_cells",getFormatCells());

        }        if (getFormatColumns() != null){
            json.addProperty(getName()+"_allow_format_columns",getFormatColumns());

        }        if (getFormatRows() != null){
            json.addProperty(getName()+"_allow_format_rows",getFormatRows());

        }        if (getInsertColumns() != null){
            json.addProperty(getName()+"_allow_insert_columns",getInsertColumns());

        }        if (getInsertHyperlinks() != null){
            json.addProperty(getName()+"_allow_insert_hyperlinks",getInsertHyperlinks());

        }        if (getInsertRows() != null){
            json.addProperty(getName()+"_allow_insert_rows",getInsertRows());

        }        if (getPassword() != null){
            json.addProperty(getName()+"_password",getPassword());

        }        if (getPivotTables() != null){
            json.addProperty(getName()+"_allow_pivot_tables",getPivotTables());

        }        if (getSelectLockedCells() != null){
            json.addProperty(getName()+"_allow_select_locked_cells",getSelectLockedCells());

        }        if (getSelectUnlockedCells() != null){
            json.addProperty(getName()+"_allow_select_unlocked_cells",getSelectUnlockedCells());

        }        if (getSort() != null){
            json.addProperty(getName()+"_allow_sort",getSort());
        }
        return json;
    }

    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{protect " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
