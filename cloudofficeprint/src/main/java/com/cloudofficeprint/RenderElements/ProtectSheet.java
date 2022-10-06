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
     *
     * @return autoFilter lock auto filter
     */
    public Boolean getAutoFilter() {
        return AutoFilter;
    }

    /**
     *
     * @param autoFilter lock auto filter.
     */
    public void setAutoFilter(Boolean autoFilter) {
        AutoFilter = autoFilter;
    }

    /**
     *
     * @return lock delete columns
     */
    public Boolean getDeleteColumns() {
        return DeleteColumns;
    }

    /**
     *
     * @param deleteColumns lock delete columns
     */
    public void setDeleteColumns(Boolean deleteColumns) {
        DeleteColumns = deleteColumns;
    }

    /**
     *
     * @return lock delete rows.
     */
    public Boolean getDeleteRows() {
        return DeleteRows;
    }

    /**
     *
     * @param deleteRows lock delete rows.
     */
    public void setDeleteRows(Boolean deleteRows) {
        DeleteRows = deleteRows;
    }

    /**
     *
     * @return lock format cells.
     */
    public Boolean getFormatCells() {
        return FormatCells;
    }

    /**
     *
     * @param formatCells lock format cells.
     */
    public void setFormatCells(Boolean formatCells) {
        FormatCells = formatCells;
    }

    /**
     *
     * @return lock format columns.
     */
    public Boolean getFormatColumns() {
        return FormatColumns;
    }

    /**
     *
     * @param formatColumns lock format columns.
     */
    public void setFormatColumns(Boolean formatColumns) {
        FormatColumns = formatColumns;
    }

    /**
     *
     * @return lock format columns.
     */
    public Boolean getFormatRows() {
        return FormatRows;
    }

    /**
     *
     * @param formatRows lock format rows.
     */
    public void setFormatRows(Boolean formatRows) {
        FormatRows = formatRows;
    }

    /**
     *
     * @return lock insert columns.
     */
    public Boolean getInsertColumns() {
        return InsertColumns;
    }

    /**
     *
     * @param insertColumns lock insert columns.
     */
    public void setInsertColumns(Boolean insertColumns) {
        InsertColumns = insertColumns;
    }

    /**
     *
     * @return lock insert hyperlinks.
     */
    public Boolean getInsertHyperlinks() {
        return InsertHyperlinks;
    }

    /**
     *
     * @param insertHyperlinks lock insert hyperlinks.
     */
    public void setInsertHyperlinks(Boolean insertHyperlinks) {
        InsertHyperlinks = insertHyperlinks;
    }

    /**
     *
     * @return lock insert rows.
     */
    public Boolean getInsertRows() {
        return InsertRows;
    }

    /**
     *
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
     *
     * @param password password to lock with.
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     *
     * @return lock pivot tables.
     */
    public Boolean getPivotTables() {
        return PivotTables;
    }

    /**
     *
     * @param pivotTables lock pivot tables.
     */
    public void setPivotTables(Boolean pivotTables) {
        PivotTables = pivotTables;
    }

    /**
     *
     * @return lock select locked cells.
     */
    public Boolean getSelectLockedCells() {
        return SelectLockedCells;
    }

    /**
     *
     * @param selectLockedCells lock select locked cells.
     */
    public void setSelectLockedCells(Boolean selectLockedCells) {
        SelectLockedCells = selectLockedCells;
    }

    /**
     *
     * @return lock select unlocked cells.
     */
    public Boolean getSelectUnlockedCells() {
        return SelectUnlockedCells;
    }

    /**
     *
     * @param selectUnlockedCells select unlocked cells.
     */
    public void setSelectUnlockedCells(Boolean selectUnlockedCells) {
        SelectUnlockedCells = selectUnlockedCells;
    }

    /**
     *
     * @return lock sort.
     */
    public Boolean getSort() {
        return Sort;
    }

    /**
     *
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
