package com.CloudOfficePrint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only available for Excel and HTML templates. This element allows you to
 * specify the columns and rows to span for this cell. The tag in the cell of
 * the template will be replaced by the value.
 */
public class CellSpan extends RenderElement {

    private int columns;
    private int rows;

    /**
     * @return Columns to span by cell.
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param columns Columns to span by cell.
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * @return Rows to span by cell.
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows Rows to span by cell.
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @param name    Name of this property.
     * @param value   Value of this property.
     * @param columns Number of columns to span.
     * @param rows    Number of rows to span.
     */
    public CellSpan(String name, String value, int columns, int rows) {
        setName(name);
        setValue(value);
        setColumns(columns);
        setRows(rows);
    }

    /**
     * @return JSONObject with the tags for this property for the Cloud Office Print
     *         server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        json.addProperty(getName() + "_row_span", getRows());
        json.addProperty(getName() + "_col_span", getColumns());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{" + getName() + "#}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
