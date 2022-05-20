package com.cloudofficeprint.RenderElements.Cells;

import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Only supported in Word, Excel, Powerpoint templates (they all have tables
 * with cells). Represents a cell element. It includes the name for the tag, the
 * value and optionally the cell background color and width.
 */
public class TableCell extends Property {

    private CellStyle cellStyle;

    /**
     * @return Style of the cell.
     */
    public CellStyle getCellStyle() {
        return cellStyle;
    }

    /**
     * @param cellStyle Style of the cell.
     */
    public void setCellStyle(CellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    /**
     * Represents a cell element. It includes the name for the tag, the value and
     * optionally the cell style.
     *
     * @param name      Name of this element (for the tempalteTag).
     * @param value     Value that will replace the tag.
     * @param cellStyle The style of the cell. (optional)
     */
    public TableCell(String name, String value, CellStyle cellStyle) {
        super(name, value);
        setCellStyle(cellStyle);
    }

    /**
     * @return JSONObject with the tags for this tableCell for the Cloud Office
     *         Print server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());
        for (Map.Entry<String, JsonElement> entry : getCellStyle().getJSON().entrySet()) {
            if (entry.getValue().getAsString() == "null") {
                json.add(getName() + entry.getKey(), null);
            } else if (entry.getValue().getAsString() == "false") {
                json.addProperty(getName() + entry.getKey(), false);
            } else if (entry.getValue().getAsString() == "true") {
                json.addProperty(getName() + entry.getKey(), true);
            } else {
                json.addProperty(getName() + entry.getKey(), entry.getValue().getAsString());
            }
        }
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{" + getName() + "$}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
