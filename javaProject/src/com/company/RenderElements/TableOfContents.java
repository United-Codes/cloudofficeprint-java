package com.company.RenderElements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a table of content for templates.
 */
public class TableOfContents extends RenderElement{

    private int depth =3 ;
    private String tabLeader = "dot";

    /**
     * @return The depth of heading to be shown. Default : 3.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param depth The depth of heading to be shown. Default : 3.
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * @return How the space between title and page number should be filled. Can be "hyphen", "underscore", or "dot" (default).
     */
    public String getTabLeader() {
        return tabLeader;
    }

    /**
     * @param tabLeader How the space between title and page number should be filled. Can be "hyphen", "underscore", or "dot" (default).
     */
    public void setTabLeader(String tabLeader) {
        this.tabLeader = tabLeader;
    }

    /**
     * The most basic RenderElement. It simply consists of a name and a value.
     * In a template the tag '{name}' will be replaced by 'value'.
     * If you don't want to mention an optional parameter and use the default value, put null (or O for an int) as argument.
     * @param name Name of this property.
     * @param title Title of the table of content.
     * @param depth The depth of heading to be shown. (Optional, default : 3)
     * @param tabLeader How the space between title and page number should be filled. Can be "hyphen", "underscore", or "dot".
     *                  (Optional, default : "dot")
     */
    public TableOfContents(String name, String title, int depth, String tabLeader){
        setName(name);
        setValue(title);
        setDepth(depth);
        setTabLeader(tabLeader);
    }

    /**
     * @return JSONObject with the tags for this property for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(getName()+"_title",getValue());
        json.addProperty(getName()+"_show_level",getDepth());
        json.addProperty(getName()+"_tab_leader",getTabLeader());
        return json;
    }

    /**
     * @return An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("{~"+getName()+"}");
        return ImmutableSet.copyOf(hash_Set);
    }
}
