package com.company.RenderElements.Charts.Charts;

import com.company.RenderElements.Charts.ChartOptions;
import com.company.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

public abstract class Chart extends RenderElement {

    private ChartOptions options;

    /**
     * @return Options of the chart.
     */
    public ChartOptions getOptions() {
        return options;
    }

    /**
     * @param options Options of the chart.
     */
    public void setOptions(ChartOptions options) {
        this.options = options;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{$"+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
