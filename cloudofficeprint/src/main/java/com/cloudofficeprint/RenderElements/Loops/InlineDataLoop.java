package com.cloudofficeprint.RenderElements.Loops;

import com.cloudofficeprint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Horizontal table looping for Word, Excel and CSV templates. Note: this tag
 * can be used to repeat only one row in Word. In Excel this works like a normal
 * loop tag and repeats the cells defined by the rectangular boundary of the
 * starting and closing tag.
 */
public class InlineDataLoop extends Loop {

    /**
     * Horizontal table looping for Word, Excel and CSV templates. Note : this tag
     * can be used to repeat only one row (in Word and in Excel this works like
     * normal loop tag and repeats the cells defined by the rectangular boundary of
     * starting and closing tag).
     * 
     * @param name     Name of this loop for the tag.
     * @param elements Elements to replace the tag with.
     */
    public InlineDataLoop(String name, ArrayList<RenderElement> elements) {
        super(name, elements);
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{:" + getName() + "}");
        hash_Set.add("{/" + getName() + "}");
        for (RenderElement element : getElements()) {
            for (String tag : element.getTemplateTags())
                hash_Set.add(tag);
        }
        return ImmutableSet.copyOf(hash_Set);
    }
}
