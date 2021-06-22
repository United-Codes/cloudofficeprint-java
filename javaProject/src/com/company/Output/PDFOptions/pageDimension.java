package com.company.Output.PDFOptions;

public class pageDimension {

    String unit;
    String dimension;

    /**
     * @return unit of the dimension : px, mm, cm or in. Default : null (server will use px).
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit of the dimension : px, mm, cm or in.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return dimension of the page.
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * @param dimension of the page.
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
