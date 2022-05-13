package com.cloudofficeprint.RenderElements.PDF;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Class for an unsigned PDF signature field element.
 */
public class PDFFormSignature extends PDFFormElement {

    /**
     * @return the type of this PDF form element. For this class it is always "signaturefieldunsigned".
     */
    @Override
    public String getType() {
        return "signaturefieldunsigned";
    }

    /**
     * @param name of this element.
     */
    public PDFFormSignature(String name){
        super(name);
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags(){
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{?sign " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
