package com.cloudofficeprint.RenderElements.Form;

/**
 * PDF form combobox element. Behaves like a Dropdown but the user can also type a free-text value.
 */
public class ComboBox extends Dropdown {

    /**
     * @param name    Unique identifier matching template tag
     * @param options The selectable options
     * @param value   Pre-fills the editable field; may be an option value or free text (null for none)
     * @param height  Field height in points (null for auto)
     * @param width   Field width in points (null for auto)
     * @param lock    Lock (make read-only) the field (null for default)
     */
    public ComboBox(String name, ChoiceOption[] options, String value, Integer height, Integer width, Boolean lock) {
        super(name, options, value, height, width, lock);
        setType("combobox");
    }
}
