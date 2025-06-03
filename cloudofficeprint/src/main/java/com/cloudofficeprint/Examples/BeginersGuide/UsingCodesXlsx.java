package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.Codes.*;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingCodesXlsx {
    public void main() throws Exception {
        System.out.println("I am in codes example");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingCodes/codes_Xlsx_temp.xlsx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("xlsx");
        template.setMimeType(Mimetype.getMimeType("xlsx"));


        //Set Cloud office Print server
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        //Main elementCollection that includes all the data
        ElementCollection data = new ElementCollection("data");

        //bar code
        BarCode barCode = new BarCode("barcode_name", "code128", "978020137962");
        barCode.setWidth(50);
        barCode.setHeight(50);
        barCode.setQrErrorCorrectionLevel("L");
        barCode.setLinkUrl("https://www.cloudofficeprint.com/");
        barCode.setRotation(45);
        barCode.setBackgroundColor("orange");
        barCode.setPaddingWidth(25);
        barCode.setPaddingHeight(25);
        barCode.setExtraOptions("includetext guardwhitespace");
        data.addElement(barCode);

        //QR code
        QRCode qrCode = new QRCode("qrcode_name", "qrcode", "https://www.cloudofficeprint.com/index.html");
        data.addElement(qrCode);

        //wifi Qr code
        WifiQRCode wifiQRCode = new WifiQRCode(
                "wifi_code_name", "ssid", "password", "WPA", false);

        //telephone QR code
        TelephoneNumberQRCode telephoneQRCode = new TelephoneNumberQRCode(
                "telephone_number_name", "9823038377");

        //email QR code
        EmailQRCode emailQRCode = new EmailQRCode(
                "email_name", "info@cloudofficeprint.com","cc", "bcc", "Test subject", "This is the body");
        //sms QR code
        SMSQRCode smsQRCode = new SMSQRCode(
                "sms_qr_code", "9823038377", "this is test message body");
        //url QR code
        URLQRCode urlQRCode = new URLQRCode(
                "urlQr_code", "https://www.cloudofficeprint.com/");
        //vCard QR code
        VCardQRCode vCardQRCode = new VCardQRCode(
                "vcard_name", "John ", "Doe","email","www.cloudofficeprint.com");
        //meCard QR code
        MECardQRCode meCardQRCode = new MECardQRCode(
                "me_card_name", "John", "Doe", "Example", "email","primary","secondary","teritary", "www.cloudofficeprint.com","bday","note");

        //geo location QR code
        GeolocationQRCode  geoLocationQRCode = new GeolocationQRCode(
                "geolocatin_qr_code_name", "37.7749", "1400", "360287");
        //event QR code
        EventQRCode eventQRCode = new EventQRCode(
                "event_qr_code_name", "Event Name", "2023-10-01T10:00:00", "2023-10-01T12:00:00");
        //add all the QR codes to the data collection
        data.addElement(wifiQRCode);
        data.addElement(telephoneQRCode);
        data.addElement(emailQRCode);
        data.addElement(smsQRCode);
        data.addElement(urlQRCode);
        data.addElement(vCardQRCode);
        data.addElement(meCardQRCode);
        data.addElement(geoLocationQRCode);
        data.addElement(eventQRCode);



        Output conf = new Output("xlsx", "raw", "libreoffice", null, null, null, null);
        Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
        dataTable.put("data", data);
        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);
        Response response = printJob.execute();

        //Save response to file.
        response.downloadLocally("./downloads/BeginnerGuide/usingCodes/output");
    }
}
