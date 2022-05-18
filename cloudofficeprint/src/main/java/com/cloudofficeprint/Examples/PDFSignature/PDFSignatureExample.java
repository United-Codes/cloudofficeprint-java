package com.cloudofficeprint.Examples.PDFSignature;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

import com.cloudofficeprint.*;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.Output.PDFOptions;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Server.Server;

public class PDFSignatureExample {
    public void main(String APIKey) {
        try {
            Server server = new Server("https://api.cloudofficeprint.com", APIKey, null, null, null, null, null);
            server.setVerbose(true);

            // Set the sign certificate of the pdf options of the output.
            PDFOptions pdfOptions = new PDFOptions();
            pdfOptions.setSignCertificate(
                    "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\r\ntgICCAA=");

            Output output = new Output("pdf", "raw", null, null, null, pdfOptions, null);
            Base64Resource base64Resource = new Base64Resource();

            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./javaProject/src/com/CloudOfficePrint/Examples/GeneralExamples/pdfsignature_template.pdf");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("/PDFSignature/pdfsignature_template.pdf");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("pdf");
            base64Resource.setMimeType(Mimetype.getMimeType("pdf"));
            // End replacement code.

            // create empty collection, always need a data collection
            ElementCollection collection = new ElementCollection("collection");
            Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
            data.put("output1", collection);

            PrintJob printJob = new PrintJob(data, server, output, base64Resource, null, null, null, null, null);

            IResponse response = printJob.execute();
            response.downloadLocally("./downloads/pdfSigned");

        } catch (COPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
