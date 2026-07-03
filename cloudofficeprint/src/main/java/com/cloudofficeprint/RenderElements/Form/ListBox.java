package com.cloudofficeprint.RenderElements.Form;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * PDF form listbox element. An always-visible scrollable list that supports multi-selection.
 */
public class ListBox extends FormElement {
    private ChoiceOption[] options;
    private String[] values;
    private Boolean multiSelect;
    private Integer height;
    private Integer width;
    private Boolean lock;

    /**
     * @param name        Unique identifier matching template tag
     * @param options     The selectable options
     * @param values      The option values to pre-select (null for none)
     * @param multiSelect Allow selecting multiple rows (null for default)
     * @param height      Field height in points; a taller height shows more rows (null for auto)
     * @param width       Field width in points (null for auto)
     * @param lock        Lock (make read-only) the field (null for default)
     */
    public ListBox(String name, ChoiceOption[] options, String[] values, Boolean multiSelect, Integer height, Integer width, Boolean lock) {
        super(name, "listbox");
        setOptions(options);
        setValues(values);
        setMultiSelect(multiSelect);
        setHeight(height);
        setWidth(width);
        setLock(lock);
    }

    /**
     * @return the selectable options.
     */
    public ChoiceOption[] getOptions() { return options; }

    /**
     * @param options the selectable options.
     */
    public void setOptions(ChoiceOption[] options) { this.options = options; }

    /**
     * @return the pre-selected option values.
     */
    public String[] getValues() { return values; }

    /**
     * @param values the pre-selected option values.
     */
    public void setValues(String[] values) { this.values = values; }

    /**
     * @return whether multiple rows can be selected.
     */
    public Boolean getMultiSelect() { return multiSelect; }

    /**
     * @param multiSelect whether multiple rows can be selected.
     */
    public void setMultiSelect(Boolean multiSelect) { this.multiSelect = multiSelect; }

    /**
     * @return the field height in points.
     */
    public Integer getHeight() { return height; }

    /**
     * @param height the field height in points.
     */
    public void setHeight(Integer height) { this.height = height; }

    /**
     * @return the field width in points.
     */
    public Integer getWidth() { return width; }

    /**
     * @param width the field width in points.
     */
    public void setWidth(Integer width) { this.width = width; }

    /**
     * @return whether the field is locked (read-only).
     */
    public Boolean getLock() { return lock; }

    /**
     * @param lock whether the field is locked (read-only).
     */
    public void setLock(Boolean lock) { this.lock = lock; }

    @Override
    protected void populateProperties(JsonObject props) {
        JsonArray opts = new JsonArray();
        if (getOptions() != null) {
            for (ChoiceOption option : getOptions()) {
                opts.add(option.getJSON());
            }
        }
        props.add("options", opts);
        if (getValues() != null) {
            JsonArray vals = new JsonArray();
            for (String v : getValues()) {
                vals.add(v);
            }
            props.add("values", vals);
        }
        if (getMultiSelect() != null)
            props.addProperty("multiSelect", getMultiSelect());
        if (getHeight() != null)
            props.addProperty("height", getHeight());
        if (getWidth() != null)
            props.addProperty("width", getWidth());
        if (getLock() != null)
            props.addProperty("lock", getLock());
    }
}
