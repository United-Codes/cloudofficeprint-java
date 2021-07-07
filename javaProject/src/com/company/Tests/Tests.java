package com.company.Tests;

import com.company.Output.CloudAcessToken.AWSToken;
import com.company.Output.CloudAcessToken.OAuth2Token;
import com.company.RenderElements.Charts.ChartOptions;
import com.company.RenderElements.Charts.Charts.*;
import com.company.RenderElements.Charts.Series.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;


public class Tests {

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
        options.setTitle("false");
        options.setWidth(500);
        options.setHeight(700);
        CombinedChart combinedChart = new CombinedChart("combinedChart",options, new ColumnChart[]{columnChart}, new LineChart[]{lineChart});
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
                "        \"title\": false,\n" +
                "        \"width\": 500\n" +
                "    },\n" +
                "    \"type\": \"multiple\"\n" +
                "}";
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        System.out.println("My JSON : " + combinedChart.getJSON());
        System.out.println("Correct JSON : " + jsonCorrect);
        Assert.assertEquals(jsonCorrect,combinedChart.getJSON());
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
