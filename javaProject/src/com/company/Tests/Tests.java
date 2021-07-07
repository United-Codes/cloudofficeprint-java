package com.company.Tests;

import com.company.Output.CloudAcessToken.AWSToken;
import com.company.Output.CloudAcessToken.OAuth2Token;
import com.company.RenderElements.Charts.ChartAxisOptions;
import com.company.RenderElements.Charts.ChartDateOptions;
import com.company.RenderElements.Charts.ChartOptions;
import com.company.RenderElements.Charts.ChartTextStyle;
import com.company.RenderElements.Charts.Charts.*;
import com.company.RenderElements.Charts.Series.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;


public class Tests {

    public void testChartOptions(){

        //x-axis options
        ChartAxisOptions xAxisOptions = new ChartAxisOptions();
        xAxisOptions.setOrientation("minMax");
        xAxisOptions.setMin(5F);
        xAxisOptions.setMax(10F);

        ChartDateOptions chartDateOptions = new ChartDateOptions();
        chartDateOptions.setFormat("unix");
        chartDateOptions.setCode("mm/yy");
        chartDateOptions.setUnit("months");
        chartDateOptions.setStep(1);
        xAxisOptions.setDateOptions(chartDateOptions);

        xAxisOptions.setTitle("title_x");
        xAxisOptions.setValues(true);

        ChartTextStyle valueStyle = new ChartTextStyle(true,true,"red","Arial");
        xAxisOptions.setValuesStyle(valueStyle);

        ChartTextStyle titleStyle = new ChartTextStyle(true,false,"blue","Arial");
        xAxisOptions.setTitleStyle(titleStyle);
        xAxisOptions.setTitleRotation(45);

        xAxisOptions.setMajorGridLines(true);
        xAxisOptions.setMajorUnit(2F);
        xAxisOptions.setMinorGridLines(true);
        xAxisOptions.setMinorUnit(1F);
        xAxisOptions.setFormatCode("General");

        //y-axis options
        ChartAxisOptions yAxisOptions = new ChartAxisOptions();
        yAxisOptions.setOrientation("minMax");
        yAxisOptions.setMin(5F);
        yAxisOptions.setMax(10F);

        yAxisOptions.setTitle("title_y");
        yAxisOptions.setValues(true);

        ChartTextStyle valueStyleY = new ChartTextStyle(true,true,"red","Arial");
        yAxisOptions.setValuesStyle(valueStyleY);

        ChartTextStyle titleStyleY = new ChartTextStyle(true,false,"blue","Arial");
        yAxisOptions.setTitleStyle(titleStyleY);
        yAxisOptions.setTitleRotation(45);

        yAxisOptions.setMajorGridLines(true);
        yAxisOptions.setMajorUnit(2F);
        yAxisOptions.setMinorGridLines(true);
        yAxisOptions.setMinorUnit(1F);
        yAxisOptions.setFormatCode("General");

        //y2-axis options same as y
        ChartAxisOptions y2AxisOptions = new ChartAxisOptions();
        y2AxisOptions.setOrientation("minMax");
        y2AxisOptions.setMin(5F);
        y2AxisOptions.setMax(10F);

        y2AxisOptions.setTitle("title_y");
        y2AxisOptions.setValues(true);

        ChartTextStyle valueStyleY2 = new ChartTextStyle(true,true,"red","Arial");
        y2AxisOptions.setValuesStyle(valueStyleY2);

        ChartTextStyle titleStyleY2 = new ChartTextStyle(true,false,"blue","Arial");
        y2AxisOptions.setTitleStyle(titleStyleY2);
        y2AxisOptions.setTitleRotation(45);

        y2AxisOptions.setMajorGridLines(true);
        y2AxisOptions.setMajorUnit(2F);
        y2AxisOptions.setMinorGridLines(true);
        y2AxisOptions.setMinorUnit(1F);
        y2AxisOptions.setFormatCode("General");

        //ChartOptions
        ChartOptions options = new ChartOptions();
        options.setXAxisOptions(xAxisOptions);
        options.setYAxisOptions(yAxisOptions);
        options.setY2AxisOptions(y2AxisOptions);
        options.setWidth(500);
        options.setHeight(500);
        options.setBorder(true);
        options.setRoundedCorners(false);
        options.setBackgroundColor("green");
        options.setBackgroundOpacity(50);
        options.setTitle("title_chart");
        ChartTextStyle generalTitleStyle = new ChartTextStyle(false,true,"red","Arial");
        options.setTitleStyle(generalTitleStyle);
        options.setGrid(true);

        ChartTextStyle legendStyle = new ChartTextStyle(true,true,"blue","Arial");
        options.setLegend("l",legendStyle);

        options.setDataLabels(";",false,false,true,false,true,"r");

        String optionsExpected = "{'axis': {'x': {'orientation': 'minMax', 'min': 5.0, 'max': 10.0, 'type': 'date', 'date': {'format': 'unix', 'code': 'mm/yy', 'unit': 'months', 'step': 1}, 'title': 'title_x', 'showValues': True, 'valuesStyle': {'italic': True, 'bold': True, 'color': 'red', 'font': 'Arial'}, 'titleStyle': {'italic': True, 'bold': False, 'color': 'blue', 'font': 'Arial'}, 'titleRotation': 45, 'majorGridlines': True, 'majorUnit': 2.0, 'minorGridlines': True, 'minorUnit': 1.0, 'formatCode': 'General'}, 'y': {'orientation': 'minMax', 'min': 5.0, 'max': 10.0, 'title': 'title_y', 'showValues': True, 'valuesStyle': {'italic': True, 'bold': True, 'color': 'red', 'font': 'Arial'}, 'titleStyle': {'italic': True, 'bold': False, 'color': 'blue', 'font': 'Arial'}, 'titleRotation': 45, 'majorGridlines': True, 'majorUnit': 2.0, 'minorGridlines': True, 'minorUnit': 1.0, 'formatCode': 'General'}, 'y2': {'orientation': 'minMax', 'min': 5.0, 'max': 10.0, 'title': 'title_y', 'showValues': True, 'valuesStyle': {'italic': True, 'bold': True, 'color': 'red', 'font': 'Arial'}, 'titleStyle': {'italic': True, 'bold': False, 'color': 'blue', 'font': 'Arial'}, 'titleRotation': 45, 'majorGridlines': True, 'majorUnit': 2.0, 'minorGridlines': True, 'minorUnit': 1.0, 'formatCode': 'General'}}, 'width': 500, 'height': 500, 'border': True, 'roundedCorners': False, 'backgroundColor': 'green', 'backgroundOpacity': 50, 'title': 'title_chart', 'titleStyle': {'italic': False, 'bold': True, 'color': 'red', 'font': 'Arial'}, 'grid': True, 'legend': {'showLegend': True, 'position': 'l', 'style': {'italic': True, 'bold': True, 'color': 'blue', 'font': 'Arial'}}, 'dataLabels': {'showDataLabels': True, 'separator': ';', 'showSeriesName': False, 'showCategoryName': False, 'showLegendKey': True, 'showValue': False, 'showPercentage': True, 'position': 'r'}}";
        //System.out.println(options.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(optionsExpected).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,options.getJSON());
    }

    public void testCombinedChart(){
        ColumnSeries columnSeries1 = new ColumnSeries("bar 1",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"4.3", "2.5", "3.5"});
        ColumnSeries columnSeries2 = new ColumnSeries("bar 2",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"2.4", "4.4", "1.8"});
        ColumnChart columnChart = new ColumnChart("columns",null,columnSeries1,columnSeries2);

        LineSeries lineSerie1 = new LineSeries("line 1",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"43", "25", "35"},
                null,null,null,null,null,null);
        LineSeries lineSerie2 = new LineSeries("line 2",new String[]{"day 1", "day 2", "day 3"} ,new String[]{"24", "44", "18"},
                null,null,null,null,null,null);
        LineChart lineChart = new LineChart("lines",null,lineSerie1,lineSerie2);
        ChartOptions options = new ChartOptions();
        options.setBorder(true);
        options.setGrid(true);
        options.setLegend("r",null);
        //options.setTitle("false");
        options.setWidth(500);
        options.setHeight(700);
        CombinedChart combinedChart = new CombinedChart("multiples",options, new ColumnChart[]{columnChart}, new LineChart[]{lineChart});


        String correct = "{\n" +
                "    \"multiples\": [\n" +
                "        {\n" +
                "            \"columns\": [\n" +
                "                {\n" +
                "                    \"data\": [\n" +
                "                        {\n" +
                "                            \"x\": \"day 1\",\n" +
                "                            \"y\": \"4.3\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": \"day 2\",\n" +
                "                            \"y\": \"2.5\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": \"day 3\",\n" +
                "                            \"y\": \"3.5\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"bar 1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"data\": [\n" +
                "                        {\n" +
                "                            \"x\": \"day 1\",\n" +
                "                            \"y\": \"2.4\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": \"day 2\",\n" +
                "                            \"y\": \"4.4\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": \"day 3\",\n" +
                "                            \"y\": \"1.8\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"bar 2\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"type\": \"column\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"lines\": [\n" +
                "                {\n" +
                "                    \"data\": [\n" +
                "                        {\n" +
                "                            \"x\": \"day 1\",\n" +
                "                            \"y2\": \"43\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": \"day 2\",\n" +
                "                            \"y2\": \"25\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": \"day 3\",\n" +
                "                            \"y2\": \"35\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"line 1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"data\": [\n" +
                "                        {\n" +
                "                            \"x\": \"day 1\",\n" +
                "                            \"y2\": \"24\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": \"day 2\",\n" +
                "                            \"y2\": \"44\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": \"day 3\",\n" +
                "                            \"y2\": \"18\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"name\": \"line 2\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"type\": \"line\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"options\": {\n" +
                "        \"border\": true,\n" +
                "        \"grid\": true,\n" +
                "        \"height\": 700,\n" +
                "        \"legend\": {\n" +
                "            \"position\": \"r\",\n" +
                "            \"showLegend\": true\n" +
                "        },\n" +
                "        \"width\": 500\n" +
                "    },\n" +
                "    \"type\": \"multiple\"\n" +
                "}";
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println("My JSON : " + combinedChart.getJSON().getAsJsonObject("multiples"));
        //System.out.println("Correct JSON : " + jsonCorrect);
        Assert.assertEquals(jsonCorrect,combinedChart.getJSON().getAsJsonObject("multiples"));
    }

    /**
     * This checks the json of the Googletoken and Amazontoken.
     */
    public void testCloudAccessToken(String OAUTH2token){
        OAuth2Token googleToken = new OAuth2Token("Google Drive",OAUTH2token);
        AWSToken amazonToken = new AWSToken("AWS_access_key_id","AWS_secret_access_key");
        System.out.println(googleToken.getJSON());
        System.out.println(amazonToken.getJSON());
    }
}
