package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in Word, Excel, HTML and Md templates. HTML text can be
 * rendered and put in templates.
 */
public class HTML extends RenderElement {

    private String customTableStyle;
    private String unorderedListStyle;
    private String orderedListStyle;
    private Boolean useTagStyle;
    private Boolean ignoreCellMargin;
    private Boolean ignoreEmptyP;

    private String getCustomTableStyle() {
        return customTableStyle;
    }

    private void setCustomTableStyle(String customTableStyle) {
        this.customTableStyle = customTableStyle;
    }

    private String getUnorderedListStyle() {
        return unorderedListStyle;
    }

    private void setUnorderedListStyle(String unorderedListStyle) {
        this.unorderedListStyle = unorderedListStyle;
    }

    private String getOrderedListStyle() {
        return orderedListStyle;
    }

    private void setOrderedListStyle(String orderedListStyle) {
        this.orderedListStyle = orderedListStyle;
    }

    private Boolean getUseTagStyle() {
        return useTagStyle;
    }

    private void setUseTagStyle(Boolean useTagStyle) {
        this.useTagStyle = useTagStyle;
    }

    private Boolean getIgnoreCellMargin() {
        return ignoreCellMargin;
    }

    private void setIgnoreCellMargin(Boolean ignoreCellMargin) {
        this.ignoreCellMargin = ignoreCellMargin;
    }

    private Boolean getIgnoreEmptyP() {
        return ignoreEmptyP;
    }

    private void setIgnoreEmptyP(Boolean ignoreEmptyP) {
        this.ignoreEmptyP = ignoreEmptyP;
    }

    /**
     * HTML text can be rendered and put in templates.
     * 
     * @param name     Name of this html element for the tag.
     * @param HTMLText HTML text.
     */
    public HTML(String name, String HTMLText) {
        setName(name);
        setValue(String.valueOf(HTMLText));
    }

    /**
     *
     * @param name  Name of this html element for the tag.
     * @param HTMLText HTML text.
     * @param customTableStyle
     * @param unorderedListStyle
     * @param orderedListStyle
     * @param useTagStyle
     * @param ignoreCellMargin
     * @param ignoreEmptyP
     */
    public HTML(String name, String HTMLText, String customTableStyle, String unorderedListStyle, String orderedListStyle, Boolean useTagStyle, Boolean ignoreCellMargin, Boolean ignoreEmptyP) {
        setName(name);
        setValue(String.valueOf(HTMLText));
        setCustomTableStyle(customTableStyle);
        setUnorderedListStyle(unorderedListStyle);
        setOrderedListStyle(orderedListStyle);
        setUseTagStyle(useTagStyle);
        setIgnoreCellMargin(ignoreCellMargin);
        setIgnoreEmptyP(ignoreEmptyP);
    }

    /**
     * @return JSONObject with the tags for this HTML element for the Cloud Office
     *         Print server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName(), getValue());

        if (getCustomTableStyle() != null) {
            json.addProperty(getName() + "_custom_table_style", getCustomTableStyle());
        }if (getUnorderedListStyle() != null) {
            json.addProperty(getName() + "_unordered_list_style", getUnorderedListStyle());
        }if (getOrderedListStyle() != null) {
            json.addProperty(getName() + "_ordered_list_style", getOrderedListStyle());
        }if (getUseTagStyle() != null) {
            json.addProperty(getName() + "_use_tag_style", getUseTagStyle());
        }if (getIgnoreCellMargin() != null) {
            json.addProperty(getName() + "_ignore_cell_margin", getIgnoreCellMargin());
        }if (getIgnoreEmptyP() != null) {
            json.addProperty(getName() + "_ignore_empty_p", getIgnoreEmptyP());
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
        hash_Set.add("{_" + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
