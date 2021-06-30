package com.company.RenderElements.Loops;

import com.company.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * AOP also provides a way to print labels Word documents. To do so you can create a document with labels by going to
 * Mailings options and then to Labels. Fill in the tags in the address field and choose the type of label by clicking the Label option.
 * A document can then be generated by clicking New document. Currently when labels are getting printed, AOP expects the
 * document to only contain labels and no other text. The tag keys cannot be used more than once.
 */
public class Labels extends Loop {

    /**
     * AOP also provides a way to print labels Word documents. To do so you can create a document with labels by going to
     * Mailings options and then to Labels. Fill in the tags in the address field and choose the type of label by clicking the Label option.
     * A document can then be generated by clicking New document. Currently when labels are getting printed, AOP expects the
     * document to only contain labels and no other text. The tag keys cannot be used more than once.
     * @param name Name of these labels for the tag.
     * @param labels Data for the labels.
     */
    public Labels(String name, RenderElement[] labels) {
        super(name, labels);
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{-" + getName() + "}");
        for (RenderElement element : getElements()){
            for (String tag : getTemplateTags())
                hash_Set.add(tag);
        }
        return ImmutableSet.copyOf(hash_Set);
    }
}
