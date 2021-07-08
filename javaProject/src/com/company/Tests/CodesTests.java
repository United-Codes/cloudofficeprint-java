package com.company.Tests;

import com.company.Output.CloudAcessToken.OAuth2Token;
import com.company.RenderElements.Codes.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;

public class CodesTests {


    public void barCodeTest(){
        BarCode barCode =new BarCode("name","ean13","data");
        barCode.setWidth(50);
        barCode.setHeight(50);
        barCode.setQrErrorCorrectionLevel("L");
        barCode.setLinkUrl("url");
        barCode.setRotation(45);
        barCode.setBackgroundColor("red");
        barCode.setPaddingWidth(25);
        barCode.setPaddingHeight(25);
        barCode.setExtraOptions("includetext guardwhitespace");

        String correct= "{'name': 'data', 'name_type': 'ean13', 'name_height': 50, 'name_width': 50, 'name_errorcorrectlevel': 'L', 'name_url': 'url', 'name_rotation': 45, 'name_background_color': 'red', 'name_padding_width': 25, 'name_padding_height': 25, 'name_extra_options': 'includetext guardwhitespace'}";
        //System.out.println(barCode.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,barCode.getJSON());
    }

    public void QRWifiTest(){
        WifiQRCode code =new WifiQRCode("name","ssid","password","WPA",false);

        String correct= "{'name': 'ssid', 'name_type': 'qr_wifi', 'name_wifi_password': 'password', 'name_wifi_encryption': 'WPA', 'name_wifi_hidden': False}";
        //System.out.println(code.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,code.getJSON());
    }

    public void QRTelephoneTest(){
        TelephoneNumberQRCode code =new TelephoneNumberQRCode("name","+32_test_number");

        String correct= "{'name': '+32_test_number', 'name_type': 'qr_telephone'}";
        //System.out.println(code.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,code.getJSON());
    }

    public void QREmailTest(){
        EmailQRCode code =new EmailQRCode("name","receiver","cc","bcc","subject","body");

        String correct= "{'name': 'receiver', 'name_type': 'qr_email', 'name_email_cc': 'cc', 'name_email_bcc': 'bcc', 'name_email_subject': 'subject', 'name_email_body': 'body'}";
        //System.out.println(code.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,code.getJSON());
    }


    public void QRSMSTest(){
        SMSQRCode code =new SMSQRCode("name","receiver","sms_body");
        String correct= "{'name': 'receiver', 'name_type': 'qr_sms', 'name_sms_body': 'sms_body'}";
        //System.out.println(code.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,code.getJSON());
    }


    public void QRURLTest(){
        URLQRCode code =new URLQRCode("name","url");
        String correct= "{'name': 'url', 'name_type': 'qr_url'}";
        //System.out.println(code.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,code.getJSON());
    }

    public void QRVCardTest(){
        VCardQRCode code =new VCardQRCode("name","first_name","last_name","email","website");
        String correct= "{'name': 'first_name', 'name_type': 'qr_vcard', 'name_vcard_last_name': 'last_name', 'name_vcard_email': 'email', 'name_vcard_website': 'website'}";
        //System.out.println(code.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,code.getJSON());
    }

    public void QRMeCardTest(){
        MECardQRCode code =new MECardQRCode("name","first_name","last_name","nickname","email","contact_primary",
                "contact_secondary","contact_tertiary","website","birthday","notes");
        String correct= "{'name': 'first_name', 'name_type': 'qr_me_card', 'name_me_card_last_name': 'last_name', 'name_me_card_nickname': 'nickname', 'name_me_card_email': 'email', 'name_me_card_contact_primary': 'contact_primary', 'name_me_card_contact_secondary': 'contact_secondary', 'name_me_card_contact_tertiary': 'contact_tertiary', 'name_me_card_website': 'website', 'name_me_card_birthday': 'birthday', 'name_me_card_notes': 'notes'}";
        //System.out.println(code.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,code.getJSON());
    }

    public void QRGeoTest(){
        GeolocationQRCode code =new GeolocationQRCode("name","latitude","altitude","longitude");
        String correct= "{'name': 'latitude', 'name_type': 'qr_geolocation', 'name_geolocation_longitude': 'longitude', 'name_geolocation_altitude': 'altitude'}";
        //System.out.println(code.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,code.getJSON());
    }

    public void QREventTest(){
        EventQRCode code =new EventQRCode("name","summary","startdate","enddate");
        String correct= "{'name': 'summary', 'name_type': 'qr_event', 'name_event_startdate': 'startdate', 'name_event_enddate': 'enddate'}";
        //System.out.println(code.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,code.getJSON());
    }


}
