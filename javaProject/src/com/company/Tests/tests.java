package com.company.Tests;

import com.company.Output.CloudAcessToken.AWSToken;
import com.company.Output.CloudAcessToken.OAuth2Token;
import com.company.RenderElements.Charts.Series.LineSeries;
import com.google.gson.JsonArray;

public class tests {

    public void testChart(){
        LineSeries lineserie = new LineSeries("lineserie",new String[]{"1", "2", "3", "4"} ,new String[]{"1", "2", "3", "4"},"green",
                null,null,null,null,null);

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
