package com.cloudofficeprint.RenderElements.Form;

import com.google.gson.JsonObject;

/**
 * PDF form push button element. A clickable button widget that carries no value.
 */
public class PushButton extends FormElement {
    private String caption;
    private Integer height;
    private Integer width;
    private Boolean lock;

    /**
     * @param name    Unique identifier matching template tag
     * @param caption Text shown on the button face (null for none)
     * @param height  Field height in points (null for auto)
     * @param width   Field width in points (null for auto)
     * @param lock    Lock (make read-only) the field (null for default)
     */
    public PushButton(String name, String caption, Integer height, Integer width, Boolean lock) {
        super(name, "pushbutton");
        setCaption(caption);
        setHeight(height);
        setWidth(width);
        setLock(lock);
    }

    /**
     * @return the text shown on the button face.
     */
    public String getCaption() { return caption; }

    /**
     * @param caption the text shown on the button face.
     */
    public void setCaption(String caption) { this.caption = caption; }

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
        if (getCaption() != null)
            props.addProperty("caption", getCaption());
        if (getHeight() != null)
            props.addProperty("height", getHeight());
        if (getWidth() != null)
            props.addProperty("width", getWidth());
        if (getLock() != null)
            props.addProperty("lock", getLock());
    }
}
