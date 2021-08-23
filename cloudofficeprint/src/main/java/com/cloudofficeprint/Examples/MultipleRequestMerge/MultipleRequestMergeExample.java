package com.cloudofficeprint.Examples.MultipleRequestMerge;

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

public class MultipleRequestMergeExample {
	/**
	 * This is an example of how you can merge the output files generated from a
	 * single template using multiple requests. This approach is useful if you are
	 * dealing with a lot of output files that need to be merged. There is a limit
	 * on how much data can be sent to a Cloud Office Print server, so this is
	 * useful to split one big request into multiple smaller ones. This example will
	 * take a minute to run.
	 */

	public void main(String APIKey) throws Exception {

		// Setup Cloud Office Print server
		Server copServer = new Server("https://api.cloudofficeprint.com/");
		copServer.setVerbose(true);
		copServer.setAPIKey(APIKey);

		// Load template
		Base64Resource template = new Base64Resource();
		InputStream resourceAsStream = getClass().getResourceAsStream("/MultipleRequestMerge/template.docx");
		byte[] targetArray = new byte[resourceAsStream.available()];
		resourceAsStream.read(targetArray);
		String encodedString = Base64.getEncoder().encodeToString(targetArray);
		template.setFileBase64(encodedString);
		template.setFiletype("docx");
		template.setMimeType(Mimetype.getMimeType("docx"));

		// Let's say we have 100 different customers for who we need to fill in the
		// template
		// and we want to merge the resulting files into a PDF.
		// In this example, we are just going to repeat the property 'test' with value
		// 'test' 100 times,
		// but normally you would have different data for each customer.
		Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
		for (int i = 0; i < 100; i += 1) {
			String key = "file" + i;
			data.put(key, new Property("test", "test"));
		}

		// Create output configuration: merge PDF
		PDFOptions pdfOpts = new PDFOptions();
		pdfOpts.setMerge(true);
		Output conf = new Output("pdf", "raw", "libreoffice", null, null, pdfOpts, null);

		// Let's assume that the Cloud Office Print server can't handle all the data at
		// once,
		// so we need to split our data into multiple requests.
		// Let's use 10 requests with each 10 elements in the data (a total of 100 data
		// elements).
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

		// Create the final request to merge all the received (merged) PDFs
		// Create Resource-objects from the Response-objects in output_files
		Base64Resource[] resources = new Base64Resource[outputFiles.length];
		for (int i = 0; i < outputFiles.length; i++) {
			String resourceBase64String = new String(Base64.getEncoder().encode(outputFiles[i].getBody()));
			resources[i] = new Base64Resource();
			resources[i].setFileBase64(resourceBase64String);
			resources[i].setFiletype("pdf");
			resources[i].setMimeType(Mimetype.getMimeType("pdf"));
		}

		// Create the print job for the last request that merges the 10 merged PDF's
		// As the template we pick the first PDF in the resources-list
		// The other 9 PDFs from the resources-list can be added to append_files (or
		// prepend_files)
		Base64Resource[] splitResources = Arrays.copyOfRange(resources, 1, resources.length);
		data = new Hashtable<String, RenderElement>();
		data.put("not_used", new Property("not", "used"));
		Output conf2 = new Output("pdf", "raw", "libreoffice", null, null, null, null);
		PrintJob printjob = new PrintJob(data, copServer, conf2, resources[0], null, null, splitResources, null);

		printjob.execute().downloadLocally("./downloads/multiple_request_merge");
	}
}
