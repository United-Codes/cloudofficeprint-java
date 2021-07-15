package com.company.RenderElements.Cells;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class for cellstyles.
 */
public abstract class CellStyle {

    /**
     * @return JSONObject with the tags for this tableCell for the AOP server.
     */
    public abstract JsonObject getJSON();

}
