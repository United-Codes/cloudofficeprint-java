package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

public class ProtectSheet extends RenderElement{
    private Boolean AutoFilter;
    private Boolean DeleteColumns;
    private Boolean DeleteRows;
    private Boolean FormatCells;
    private Boolean FormatColumns;
    private Boolean FormatRows;
    private Boolean InsertColumns;
    private Boolean InsertHyperlinks;
    private Boolean InsertRows;
    private String Password;
    private Boolean PivotTables;
    private Boolean SelectLockedCells;
    private Boolean SelectUnlockedCells;
    private Boolean Sort;

    /**
     * Value to determine whether to lock AutoFilter or not.
     * @return autoFilter lock auto filter
     */
    public Boolean getAutoFilter() {
        return AutoFilter;
    }

    /**
     * Sets value for AutoFilter
     * @param autoFilter lock auto filter.
     */
    public void setAutoFilter(Boolean autoFilter) {
        AutoFilter = autoFilter;
    }

    /**
     * Value to determine whether to lock DeleteColumns or not.
     * @return lock delete columns
     */
    public Boolean getDeleteColumns() {
        return DeleteColumns;
    }

    /**
     * Sets value for DeleteColumns
     * @param deleteColumns lock delete columns
     */
    public void setDeleteColumns(Boolean deleteColumns) {
        DeleteColumns = deleteColumns;
    }

    /**
     * Value to determine whether to lock DeleteRows or not.
     * @return lock delete rows.
     */
    public Boolean getDeleteRows() {
        return DeleteRows;
    }

    /**
     * Sets value for DeleteRows
     * @param deleteRows lock delete rows.
     */
    public void setDeleteRows(Boolean deleteRows) {
        DeleteRows = deleteRows;
    }

    /**
     * Value to determine whether to lock FormatCells or not.
     * @return lock format cells.
     */
    public Boolean getFormatCells() {
        return FormatCells;
    }

    /**
     * Sets value for FormatCells
     * @param formatCells lock format cells.
     */
    public void setFormatCells(Boolean formatCells) {
        FormatCells = formatCells;
    }

    /**
     * Value to determine whether to lock FormatColumns or not.
     * @return lock format columns.
     */
    public Boolean getFormatColumns() {
        return FormatColumns;
    }

    /**
     * Sets value for FormatColumns
     * @param formatColumns lock format columns.
     */
    public void setFormatColumns(Boolean formatColumns) {
        FormatColumns = formatColumns;
    }

    /**
     * Value to determine whether to lock FormatRows or not.
     * @return lock format columns.
     */
    public Boolean getFormatRows() {
        return FormatRows;
    }

    /**
     * Sets value for FormatRows
     * @param formatRows lock format rows.
     */
    public void setFormatRows(Boolean formatRows) {
        FormatRows = formatRows;
    }

    /**
     * Value to determine whether to lock InsertColumns or not.
     * @return lock insert columns.
     */
    public Boolean getInsertColumns() {
        return InsertColumns;
    }

    /**
     * Sets value for InsertColumns
     * @param insertColumns lock insert columns.
     */
    public void setInsertColumns(Boolean insertColumns) {
        InsertColumns = insertColumns;
    }

    /**
     * Value to determine whether to lock InsertHyperlinks or not.
     * @return lock insert hyperlinks.
     */
    public Boolean getInsertHyperlinks() {
        return InsertHyperlinks;
    }

    /**
     * Sets value for InsertHyperlinks
     * @param insertHyperlinks lock insert hyperlinks.
     */
    public void setInsertHyperlinks(Boolean insertHyperlinks) {
        InsertHyperlinks = insertHyperlinks;
    }

    /**
     * Value to determine whether to lock InsertRows or not.
     * @return lock insert rows.
     */
    public Boolean getInsertRows() {
        return InsertRows;
    }

    /**
     * Sets value for InsertRows
     * @param insertRows lock insert rows.
     */
    public void setInsertRows(Boolean insertRows) {
        InsertRows = insertRows;
    }

    /**
     *
     * @return password to lock with.
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Sets value for Password
     * @param password password to lock with.
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     * Value to determine whether to lock PivotTables or not.
     * @return lock pivot tables.
     */
    public Boolean getPivotTables() {
        return PivotTables;
    }

    /**
     * Sets value for PivotTables
     * @param pivotTables lock pivot tables.
     */
    public void setPivotTables(Boolean pivotTables) {
        PivotTables = pivotTables;
    }

    /**
     * Value to determine whether to lock SelectLockedCells or not.
     * @return lock select locked cells.
     */
    public Boolean getSelectLockedCells() {
        return SelectLockedCells;
    }

    /**
     * Sets value for SelectLockedCells
     * @param selectLockedCells lock select locked cells.
     */
    public void setSelectLockedCells(Boolean selectLockedCells) {
        SelectLockedCells = selectLockedCells;
    }

    /**
     * Value to determine whether to lock SelectUnlockedCells or not.
     * @return lock select unlocked cells.
     */
    public Boolean getSelectUnlockedCells() {
        return SelectUnlockedCells;
    }

    /**
     * Sets value for SelectUnlockedCells
     * @param selectUnlockedCells select unlocked cells.
     */
    public void setSelectUnlockedCells(Boolean selectUnlockedCells) {
        SelectUnlockedCells = selectUnlockedCells;
    }

    /**
     * Value to determine whether to lock Sort or not.
     * @return lock sort.
     */
    public Boolean getSort() {
        return Sort;
    }

    /**
     * Sets value for Sort
     * @param sort lock sort.
     */
    public void setSort(Boolean sort) {
        Sort = sort;
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
