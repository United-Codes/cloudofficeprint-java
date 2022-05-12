package com.cloudofficeprint.RenderElements;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

public class AutoLink extends Property {

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
