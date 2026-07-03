package com.cloudofficeprint.RenderElements.Form;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * PDF form dropdown (non-editable combo box) element. The user can only pick from the supplied list.
 */
public class Dropdown extends FormElement {
    private ChoiceOption[] options;
    private String value;
    private Integer height;
    private Integer width;
    private Boolean lock;

    /**
     * @param name    Unique identifier matching template tag
     * @param options The selectable options
     * @param value   The value of the option to pre-select (null for none)
     * @param height  Field height in points (null for auto)
     * @param width   Field width in points (null for auto)
     * @param lock    Lock (make read-only) the field (null for default)
     */
    public Dropdown(String name, ChoiceOption[] options, String value, Integer height, Integer width, Boolean lock) {
        super(name, "dropdown");
        setOptions(options);
        setValue(value);
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
     * @return the pre-selected value.
     */
    public String getValue() { return value; }

    /**
     * @param value the pre-selected value.
     */
    public void setValue(String value) { this.value = value; }

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
        if (getValue() != null)
            props.addProperty("value", getValue());
        if (getHeight() != null)
            props.addProperty("height", getHeight());
        if (getWidth() != null)
            props.addProperty("width", getWidth());
        if (getLock() != null)
            props.addProperty("lock", getLock());
    }
}
