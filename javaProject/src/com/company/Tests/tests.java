package com.company.Tests;

import com.company.Output.CloudAcessToken.AWSToken;
import com.company.Output.CloudAcessToken.OAuth2Token;
import com.company.RenderElements.Charts.Charts.AreaChart;
import com.company.RenderElements.Charts.Charts.LineChart;
import com.company.RenderElements.Charts.Series.AreaSeries;
import com.company.RenderElements.Charts.Series.LineSeries;
import com.company.RenderElements.Charts.Series.XYSeries;
import com.google.gson.JsonArray;

public class tests {

    public void testChart(){
        LineSeries lineserie1 = new LineSeries("lineserie1",new String[]{"1", "2", "3", "4"} ,new String[]{"1", "2", "3", "4"},"green",
                null,null,null,null,null);
        LineSeries lineserie2 = new LineSeries("lineserie2",new String[]{"1", "2", "3", "4"} ,new String[]{"a", "b", "c", "d"},null,
                null,null,null,null,null);
        LineChart lineChart = new LineChart("linechart",null,lineserie1,lineserie2);

        AreaSeries areaserie1 = new AreaSeries("areaserie1",new String[]{"1", "2", "3", "4"},new String[]{"4", "5", "6", "7"},
                null,null);
        AreaChart areaChart = new AreaChart("areachart",null,areaserie1);

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
