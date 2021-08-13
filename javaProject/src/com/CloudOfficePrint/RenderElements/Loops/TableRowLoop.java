package com.CloudOfficePrint.RenderElements.Loops;

import com.CloudOfficePrint.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Only supported in PowerPoint templates. This tag will merge the cells of the
 * loop defined by the tag over the amount of elements rows.
 */
public class TableRowLoop extends Loop {

    /**
     * Only supported in PowerPoint templates. This tag will merge the cells of the
     * loop defined by the tag over the amount of elements rows.
     * 
     * @param name     Name of this loop for the tag.
     * @param elements Elements to replace the tag with.
     */
    public TableRowLoop(String name, ArrayList<RenderElement> elements) {
        super(name, elements);
    }

    /**
     * @return An immutable set containing all available template tags this element
     *         can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{=" + getName() + "}");
        hash_Set.add("{/" + getName() + "}");
        for (RenderElement element : getElements()) {
            for (String tag : element.getTemplateTags())
                hash_Set.add(tag);
        }
        return ImmutableSet.copyOf(hash_Set);
    }
}
