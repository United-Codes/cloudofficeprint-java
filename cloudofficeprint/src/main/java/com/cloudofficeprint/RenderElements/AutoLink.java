package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Class for an auto link element. Only supported in Word, Excel and PowerPoint.
 */
public class AutoLink extends Property {

    /**
     * Element for an auto link tag.
     * @param name Name of this auto link for the tag.
     * @param text Text to replace the tag and to automatically detect links in it.
     */
    public AutoLink(String name, String text){
        super(name,text);
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{*auto " + getName() + "}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
