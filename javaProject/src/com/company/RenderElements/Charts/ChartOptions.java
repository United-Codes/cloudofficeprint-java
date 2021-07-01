package com.company.RenderElements.Charts;

import com.google.gson.JsonObject;

/**
 * This class represents the chart options.
 */
public class ChartOptions {
    ChartAxisOptions xAxis;
    ChartAxisOptions yAxis;
    ChartAxisOptions Y2Axis;
    Integer width;
    Integer height;
    Boolean border;
    Boolean roundedCorners;
    String backgroundColor;
    Integer backgroundOpacity;
    String title;
    ChartTextStyle titleStyle;

    Boolean showLegend;
    String legendPosition;
    ChartTextStyle legendStyle;

    Boolean showDataLabels;
    String separator;
    Boolean showSeriesName;
    Boolean showCategoryName;
    Boolean showLegendKey;
    Boolean showValue;
    Boolean showPercentage;
    String position;


    /**
     * @return The options for the x-axis.
     */
    public ChartAxisOptions getXAxis() {
        return xAxis;
    }

    /**
     * @param xAxis The options for the x-axis.
     */
    public void setXAxis(ChartAxisOptions xAxis) {
        this.xAxis = xAxis;
    }

    /**
     * @return The options for the y-axis.
     */
    public ChartAxisOptions getYAxis() {
        return yAxis;
    }

    /**
     * @param yAxis The options for the y-axis.
     */
    public void setYAxis(ChartAxisOptions yAxis) {
        this.yAxis = yAxis;
    }

    /**
     * @return The options for the second y-axis.
     */
    public ChartAxisOptions getY2Axis() {
        return Y2Axis;
    }

    /**
     * @param y2Axis The options for the y2-axis.
     */
    public void setY2Axis(ChartAxisOptions y2Axis) {
        Y2Axis = y2Axis;
    }

    /**
     * @return Width of the chart.
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width Width of the chart.
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return Height of the chart.
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height Height of the chart.
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return Whether the chart should have a border.
     */
    public Boolean getBorder() {
        return border;
    }

    /**
     * @param border Whether the chart should have a border.
     */
    public void setBorder(Boolean border) {
        this.border = border;
    }

    /**
     * @return Whether the chart should have rounded borders.
     */
    public Boolean getRoundedCorners() {
        return roundedCorners;
    }

    /**
     * @param roundedCorners Whether the chart should have rounded borders.
     */
    public void setRoundedCorners(Boolean roundedCorners) {
        this.roundedCorners = roundedCorners;
    }

    /**
     * Note: displaying rounded corners is not supported by LibreOffice.
     * @return Background color of the entire chart.
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Note: displaying rounded corners is not supported by LibreOffice.
     * @param backgroundColor Background color of the entire chart.
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * Note: backgroundOpacity is ignored if backgroundColor is not specified or if backgroundColor is specified in a color
     * space which includes an alpha channel (e.g. rgba(0,191,255,0.5)). In the latter case, the alpha channel in backgroundColor
     * is used.
     * @return The opacity of the entire chart.
     */
    public Integer getBackgroundOpacity() {
        return backgroundOpacity;
    }

    /**
     * Note: backgroundOpacity is ignored if backgroundColor is not specified or if backgroundColor is specified in a color
     * space which includes an alpha channel (e.g. rgba(0,191,255,0.5)). In the latter case, the alpha channel in backgroundColor
     * is used.
     * @param backgroundOpacity The opacity of the entire chart.
     */
    public void setBackgroundOpacity(Integer backgroundOpacity) {
        this.backgroundOpacity = backgroundOpacity;
    }

    /**
     * @return Title of the chart.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title Title of the chart.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Style of the title of the chart.
     */
    public ChartTextStyle getTitleStyle() {
        return titleStyle;
    }

    /**
     * @param titleStyle Style of the title of the chart.
     */
    public void setTitleStyle(ChartTextStyle titleStyle) {
        this.titleStyle = titleStyle;
    }

    /**
     * @return Whether the legend should be shown.
     */
    public Boolean getShowLegend() {
        return showLegend;
    }

    /**
     * @return Position of the legend.  'l' for left, 'r' right, 'b' bottom, 't' top
     */
    public String getLegendPosition() {
        return legendPosition;
    }

    /**
     * @return Style for the legend text.
     */
    public ChartTextStyle getLegendStyle() {
        return legendStyle;
    }

    /**
     * Turns the legend on. Use null for the parameters if you don't want to specify them.
     * @param position Position of the legend. 'l' for left, 'r' right, 'b' bottom, 't' top
     * @param style Style for the legend text.
     */
    public void setLegend(String position, ChartTextStyle style) {
        this.showLegend = true;
        this.legendPosition = position;
        this.legendStyle = style;
    }

    /**
     * Turns the legend of.
     */
    public void removeLegend(){
        this.showLegend = null;
        this.legendPosition = null;
        this.legendStyle = null;
    }

    /**
     * Default true for pie/pie3d and doughnut.
     * @return Whether to show data labels on the chart.
     */
    public Boolean getShowDataLabels() {
        return showDataLabels;
    }

    /**
     * @return Seperator : can be either false or anything else for example \n or \t or ; or (, if false).
     */
    public String getSeparator() {
        return separator;
    }

    /**
     * @return Whether to include the series name in the data label.
     */
    public Boolean getShowSeriesName() {
        return showSeriesName;
    }

    /**
     * @return Whether to include the series category name in the data label.
     */
    public Boolean getShowCategoryName() {
        return showCategoryName;
    }

    /**
     * @return Whether to include the legend key (i.e the color of the series) in the data label.
     */
    public Boolean getShowLegendKey() {
        return showLegendKey;
    }

    /**
     * @return Whether to include the actual value in the data label.
     */
    public Boolean getShowValue() {
        return showValue;
    }

    /**
     * @return Whether to include the percentage, default true for pie/pie3d and doughnut.
     */
    public Boolean getShowPercentage() {
        return showPercentage;
    }

    /**
     * Note that not all options might be available for specific charts.
     * @return Position of the data label , can be 'center', 'left', 'right', 'above', 'below', 'insideBase', 'bestFit',
     * 'outsideEnd', 'insideEnd'.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Turn the data labels on. If you don't want to specify an option use null as argument.
     * @param separator Seperator : can be either false or anything else for example \n or \t or ; or (, if false).
     * @param showSeriesName Whether to include the series name in the data label.
     * @param showCategoryName Whether to include the series category name in the data label.
     * @param showLegendKey Whether to include the legend key (i.e the color of the series) in the data label.
     * @param showValue Whether to include the actual value in the data label.
     * @param showPercentage Whether to include the percentage, default true for pie/pie3d and doughnut.
     * @param position Position of the data label , can be 'center', 'left', 'right', 'above', 'below', 'insideBase', 'bestFit',
     *                 'outsideEnd', 'insideEnd'. Note that not all options might be available for specific charts.
     */
    public void setDataLabels(String separator, Boolean showSeriesName, Boolean showCategoryName, Boolean showLegendKey, Boolean showValue
            , Boolean showPercentage, String position) {
        this.showDataLabels = true;
        this.separator = separator;
        this.showSeriesName = showSeriesName;
        this.showCategoryName = showCategoryName;
        this.showLegendKey = showLegendKey;
        this.showValue = showValue;
        this.showPercentage = showPercentage;
        this.position = position;
    }

    /**
     * Turns the datalabels of.
     */
    public void removeDataLabels(){
        this.showDataLabels = null;
        this.separator = null;
        this.showSeriesName = null;
        this.showCategoryName = null;
        this.showLegendKey = null;
        this.showValue = null;
        this.showPercentage = null;
        this.position = null;
    }

    /**
     * This object represents the options for a chart. You can populate the options with the setter functions.
     */
    public ChartOptions(){};

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        JsonObject axis = new JsonObject();
        axis.add("x", getXAxis().getJSON());
        axis.add("y", getYAxis().getJSON());
        if (getY2Axis()!= null){
            axis.add("y2", getY2Axis().getJSON());
        }
        json.add("axis", axis);
        if (getWidth()!= null){
            json.addProperty("width",getWidth());
        }
        if (getHeight()!= null){
            json.addProperty("height",getHeight());
        }
        if (getBorder()!= null){
            json.addProperty("border",getBorder());
        }
        if (getRoundedCorners()!= null){
            json.addProperty("roundedCorners",getRoundedCorners());
        }
        if (getBackgroundColor()!= null){
            json.addProperty("backgroundColor",getBackgroundColor());
        }
        if (getBackgroundOpacity()!= null){
            json.addProperty("backgroundOpacity",getBackgroundOpacity());
        }
        if (getTitle()!= null){
            json.addProperty("title",getTitle());
        }
        if (getTitleStyle()!= null){
            json.add("title_style",getTitleStyle().getJSON());
        }
        if (getShowDataLabels()== true){
            JsonObject dataLabels = new JsonObject();
            dataLabels.addProperty("showDataLabels", true);
            if (getSeparator()!=null){
                dataLabels.addProperty("separator", getSeparator());
            }
            if (getShowSeriesName()!=null){
                dataLabels.addProperty("showSeriesName", getPosition());
            }
            if (getShowCategoryName()!=null){
                dataLabels.addProperty("showCategoryName", getShowCategoryName());
            }
            if (getShowLegendKey()!=null){
                dataLabels.addProperty("showLegendKey", getShowLegendKey());
            }
            if (getShowValue()!=null){
                dataLabels.addProperty("showValue", getShowValue());
            }
            if (getShowPercentage()!=null){
                dataLabels.addProperty("showPercentage", getShowPercentage());
            }
            if (getPosition()!=null){
                dataLabels.addProperty("position", getPosition());
            }
            json.add("dataLabels",dataLabels);
        }
        if (getShowLegend()== true){
            JsonObject legend = new JsonObject();
            legend.addProperty("showLegend", true);
            legend.addProperty("position", getPosition()); //maybe problem with boolean here
            legend.add("style", getLegendStyle().getJSON());
            json.add("legend",legend);
        }
        return json;
    }
}