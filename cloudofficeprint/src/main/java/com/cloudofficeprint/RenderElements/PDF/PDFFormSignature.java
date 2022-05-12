package com.cloudofficeprint.RenderElements.PDF;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

public class PDFFormSignature extends PDFFormElement {

    @Override
    public String getType() {
        return "signaturefieldunsigned";
    }

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
