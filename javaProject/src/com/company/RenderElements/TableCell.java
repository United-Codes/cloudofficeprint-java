package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Word, Excel, Powerpoint templates (they all have tables with cells).
 * Represents a cell element. It includes the name for the tag, the value and
 * optionally the cell background color and width.
 */
public class TableCell extends RenderElement{

    private String backgroundColor;
    private String width;

    /**
     * @return The background color of the cell (hex format).
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor The background color of the cell (hex format).
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * The width manipulation is available from AOP 20.2. Giving a width of 0 will remove the whole column.
     * @return width The width + unit ( in, cm, px, pt, em and % (% is in respect to the initial width of the table)).
     */
    public String getWidth() {
        return width;
    }

    /**
     * The width manipulation is available from AOP 20.2. Giving a width of 0 will remove the whole column.
     * @param width The width +unit ( in, cm, px, pt, em and % (% is in respect to the initial width of the table)).
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * Represents a cell element. It includes the name for the tag, the value and
     * optionally the cell background color and width. Use default value if you don't want to specify an optional argument.
     * @param name Name of this element (for the tempalteTag).
     * @param value Value that will replace the tag.
     * @param backgroundColor The background color of the cell (hex format). (Optional)
     * @param width  The width of the cell + unit ( in, cm, px, pt, em and % (% is in respect to the initial width of the table)).
     *               Giving a width of 0 will remove the whole column.
     */
    public TableCell(String name, String value, String backgroundColor, String width){
        setName(name);
        setValue(value);
        setBackgroundColor(backgroundColor);
        setWidth(width);
    }

    /**
     * @return JSONObject with the tags for this tableCell for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(),getValue());
        json.addProperty(getName()+"_cell_background_color",getBackgroundColor());
        json.addProperty(getName()+"_width",getWidth());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{"+getName()+"$}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
