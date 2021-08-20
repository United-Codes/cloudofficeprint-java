# About
There is a limit on how much data can be sent to a cloud Office Print server at once. Let's say you have a template for product specifications and you want to generate one merged PDF file for 50.000 different products. It is possible that you cannot send all the data for all the products at once to the Cloud Office Print server. In this example we will show you how you can split one big merge request into multiple smaller merge requests.

# Template
A simple template will be used since the goal of this example is to show how you can split one big merge request into a few smaller ones. The template will contain one simple tag {test}. Tags are used in a template as placeholders to let the Cloud Office Print server know what needs to be replaced by data. In this case, the simple tag {test} will be replaced by whatever value is given to the Cloud Office Print server for the tag with key 'test'. In this example we use a template with filetype docx, but this can be any of the allowed template types (see [here](https://www.cloudofficeprint.com/docs/#tag-overview)).

<img src="https://raw.githubusercontent.com/United-Codes/cloudofficeprint-java/main/cloudofficeprint/src/main/java/com/cloudofficeprint/Examples/MultipleRequestMerge/template.png" width="600" />

# Code (SDK)
NOTE: For an overview of all the possibilities of this SDK, we refer to the documentation on our [website](https://cloudofficeprint.com/docs).
First we create a new file and import the Cloud Office Print library:
```java
import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.Arrays;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.Output.PDFOptions;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Server.Server;
import com.google.common.collect.Iterables;
```

Then we need to set up the Cloud Office Print server where we will send our template and data to:
```java
Server copServer = new Server("https://api.cloudofficeprint.com/");
copServer.setVerbose(true);
copServer.setAPIKey(APIKey);
```
If you have a cloud Office Print server running on localhost (e.g. on-premise version), replace the server url by the localhost url: http://localhost:8010

We also need to create the main element-collection object that contains all our data. Let's say we have 100 different customers for who we need to fill in the template and we want to merge the resulting files into a PDF. In this example, we are just going to repeat the property 'test' with value 'test' 100 times, but normally you would have different data for each customer.
```java
Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
for (int i = 0; i < 100; i += 1) {
    String key = "file" + i;
    data.put(key, new Property("test", "test"));
}
```


We want the output PDF files to be merged, so we create an output configuration:
```java
PDFOptions pdfOpts = new PDFOptions();
pdfOpts.setMerge(true);
Output conf = new Output("pdf", "raw", "libreoffice", null, null, pdfOpts, null);
```


Let's assume that the Cloud Office Print server can't handle all the data at once, so we need to split our data into multiple requests. Let's use 10 requests with each 10 elements in the data (a total of 100 data elements).
```java
Response[] outputFiles = new Response[10];
Set<Map.Entry<String, RenderElement>> dataEntries = data.entrySet();
Iterable<List<Map.Entry<String, RenderElement>>> slicedDataEntries = Iterables.partition(dataEntries, 10);
int index = 0;
for (List<Map.Entry<String, RenderElement>> i : slicedDataEntries) {
    Hashtable<String, RenderElement> d = new Hashtable<String, RenderElement>();
    for (Map.Entry<String, RenderElement> el : i) {
        d.put(el.getKey(), el.getValue());
    }
    PrintJob printjob = new PrintJob(d, copServer, conf, template, null, null, null, null);
    outputFiles[index] = printjob.execute();
    index++;
}
```


Now that we saved the server response for all the smaller tasks, we create the final request to merge all the received (merged) PDFs. Therefore we create Resource-objects from the Response-objects.
```java
Base64Resource[] resources = new Base64Resource[outputFiles.length];
for (int i = 0; i < outputFiles.length; i++) {
    String resourceBase64String = new String(Base64.getEncoder().encode(outputFiles[i].getBody()));
    resources[i] = new Base64Resource();
    resources[i].setFileBase64(resourceBase64String);
    resources[i].setFiletype("pdf");
    resources[i].setMimeType(Mimetype.getMimeType("pdf"));
}
```

Finally, we create the print job for the last request that merges the 10 merged PDF's. As the template we pick the first PDF in the resources-list and the other 9 PDFs from the resources-list can be added as files that need to be appended to the template file.
```java
Base64Resource[] splitResources = Arrays.copyOfRange(resources, 1, resources.length);
data = new Hashtable<String, RenderElement>();
data.put("not_used", new Property("not", "used"));
Output conf2 = new Output("pdf", "raw", "libreoffice", null, null, null, null);
PrintJob printjob = new PrintJob(data, copServer, conf2, resources[0], null, null, splitResources, null);
printjob.execute().downloadLocally("./downloads/multiple_request_merge");
```
