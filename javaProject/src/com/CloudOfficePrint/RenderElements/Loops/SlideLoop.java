package com.CloudOfficePrint.RenderElements.Loops;

import com.CloudOfficePrint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Loop where a slide will be repeated for each element of the loop. Only
 * supported in PowerPoint templates.
 */
public class SlideLoop extends Loop {

    /**
     * To repeat a slide for each element of elements.
     * 
     * @param name     Name of this loop for the tag.
     * @param elements Elements to replace the tag with.
     */
    public SlideLoop(String name, ArrayList<RenderElement> elements) {
        super(name, elements);
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{!" + getName() + "}");
        for (RenderElement element : getElements()) {
            for (String tag : getTemplateTags())
                hash_Set.add(tag);
        }
        return ImmutableSet.copyOf(hash_Set);
    }
}
