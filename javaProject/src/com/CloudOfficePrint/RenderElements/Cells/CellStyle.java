package com.CloudOfficePrint.RenderElements.Cells;

import com.google.gson.JsonObject;

/**
 * Abstract class for cellstyles.
 */
public abstract class CellStyle {

    /**
     * @return JSONObject with the tags for this tableCell for the Cloud Office
     *         Print server.
     */
    public abstract JsonObject getJSON();

}
