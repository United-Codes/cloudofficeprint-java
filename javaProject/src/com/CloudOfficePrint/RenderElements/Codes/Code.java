package com.CloudOfficePrint.RenderElements.Codes;

import com.CloudOfficePrint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Superclass for QR and BarCodes.
 */
public abstract class Code extends RenderElement {

    private String type;

    /**
     * @return Type of code required. The options can be found on:
     * http://www.apexofficeprint.com/docs/#615-barcode-qrcode-tags
     */
    public String getType() {
        return type;
    }

    /**
     * @param type Type of code required. The options can be found on:
     *                 http://www.apexofficeprint.com/docs/#615-barcode-qrcode-tags
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This class represents codes (barcode or QR codes) (created using the data of the key) for a template.
     * @param name Name of this code for the tag.
     * @param type Type of code required. The options can be found on:
     *             http://www.apexofficeprint.com/docs/#615-barcode-qrcode-tags
     * @param value Data to create the code from.
     */
    public Code(String name, String type, String value){
        setName(name);
        setType(type);
        setValue(String.valueOf(value));
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{|"+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
