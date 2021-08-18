package com.cloudofficeprint.Examples.SpaceX;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.Charts.ChartAxisOptions;
import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.ChartTextStyle;
import com.cloudofficeprint.RenderElements.Charts.Charts.ColumnChart;
import com.cloudofficeprint.RenderElements.Charts.Series.ColumnSeries;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.HyperLink;
import com.cloudofficeprint.RenderElements.Images.ImageUrl;
import com.cloudofficeprint.RenderElements.Loops.Loop;
import com.cloudofficeprint.RenderElements.Property;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;

/**
 * This example is fully explained in the spacex_example.md file.
 */
public class SpaceXExample {

    /**
     * @param description Text to shorten.
     * @return Only the first phrase of the description.
     */
    public String shortenDescription(String description) {
        return description.split("[.]")[0] + ".";
    }

    /**
     * @param template Should be docx, pptx or xlsx.
     * @param APIKey   Your APIKey.
     * @throws Exception Exceptions.
     */
    public void main(String APIKey, String template) throws Exception {

        int IMAGE_MAX_HEIGHT = 250;
        int IMAGE_MAX_WIDTH = 400;
        int CHART_WIDTH = 800;

        if (template.equals("docx")) {
            IMAGE_MAX_HEIGHT = 500;
            IMAGE_MAX_WIDTH = 640;
            CHART_WIDTH = 650;
        }

        // Get SpaceX data from https://docs.spacexdata.com
        Server server = new Server("https://api.spacexdata.com/v3/info");
        String response = server.sendGETRequest(server.getUrl());
        JsonObject info = JsonParser.parseString(response).getAsJsonObject();

        server = new Server("https://api.spacexdata.com/v4/rockets");
        response = server.sendGETRequest(server.getUrl());
        JsonArray rockets = JsonParser.parseString(response).getAsJsonArray();

        server = new Server("https://api.spacexdata.com/v4/dragons");
        response = server.sendGETRequest(server.getUrl());
        JsonArray dragons = JsonParser.parseString(response).getAsJsonArray();

        server = new Server("https://api.spacexdata.com/v4/launchpads");
        response = server.sendGETRequest(server.getUrl());
        JsonArray launchPads = JsonParser.parseString(response).getAsJsonArray();

        server = new Server("https://api.spacexdata.com/v4/landpads");
        response = server.sendGETRequest(server.getUrl());
        JsonArray landingPads = JsonParser.parseString(response).getAsJsonArray();

        server = new Server("https://api.spacexdata.com/v4/ships");
        response = server.sendGETRequest(server.getUrl());
        JsonArray ships = JsonParser.parseString(response).getAsJsonArray();

        ElementCollection spaceXData = new ElementCollection("data");

        spaceXData.addAllRenderElements(ElementCollection.makeCollectionFromJson("info", info));

        spaceXData.addElement(new HyperLink("spacex_website", "Website",
                info.get("links").getAsJsonObject().get("website").getAsString()));
        spaceXData.addElement(new HyperLink("data_source", "Data source", "https://docs.spacexdata.com"));
        spaceXData.addElement(new Property("rockets_description", "Data about the rockets built by SpaceX"));
        spaceXData.addElement(new Property("dragons_description", "Data about the dragon capsules of SpaceX"));
        spaceXData.addElement(new Property("launch_pads_description", "Data about SpaceX's launch pads"));
        spaceXData.addElement(new Property("landing_pads_description", "Data about SpaceX's landing pads"));
        spaceXData.addElement(new Property("ships_description",
                "Data about the ships that assist SpaceX launches, including ASDS drone ships, tugs, fairing recovery ships, and various support ships"));

        // Add rocket data
        Loop rocketLoop = new Loop("rockets");
        for (JsonElement json : rockets) {
            JsonObject rocket = (JsonObject) json;
            ImageUrl img = new ImageUrl("image", rocket.get("flickr_images").getAsJsonArray().get(0).getAsString());
            img.setMaxHeight(IMAGE_MAX_HEIGHT);
            img.setMaxWidth(IMAGE_MAX_WIDTH);
            rocket.remove("flickr_images");// we don't need this anymore
            ElementCollection coll = ElementCollection.makeCollectionFromJson("rocket", rocket);
            coll.addElement(img);
            coll.addElement(new Property("description", shortenDescription(rocket.get("description").getAsString()))); // should
                                                                                                                       // overwrite
                                                                                                                       // the
                                                                                                                       // older
                                                                                                                       // one
            coll.addElement(new HyperLink("wikipedia", "Wikipedia", rocket.get("wikipedia").getAsString()));
            rocketLoop.addElement(coll);
        }
        spaceXData.addElement(rocketLoop);

        // Add Rocket Chart
        ArrayList<String> x = new ArrayList<String>();
        ArrayList<String> costY = new ArrayList<String>();
        for (int i = 0; i < rockets.size(); i++) {
            JsonObject rocket = (JsonObject) rockets.get(i);
            x.add(rocket.get("name").getAsString());
            costY.add(rocket.get("cost_per_launch").getAsString());
        }
        ColumnSeries cost_series = new ColumnSeries("Cost per launch", x.toArray(new String[0]),
                costY.toArray(new String[0]));
        cost_series.setColor("#087c6c");

        ChartOptions rocketChartOptions = new ChartOptions();
        ChartAxisOptions xAxisOptions = new ChartAxisOptions();
        xAxisOptions.setTitle("Rocket");
        xAxisOptions.setTitleStyle(new ChartTextStyle(null, null, "black", null));
        rocketChartOptions.setXAxisOptions(xAxisOptions);

        ChartAxisOptions yAxisOptions = new ChartAxisOptions();
        yAxisOptions.setTitle("Cost ($)");
        yAxisOptions.setTitleStyle(new ChartTextStyle(null, null, "black", null));
        yAxisOptions.setTitleRotation(-90);
        yAxisOptions.setMajorGridLines(true);
        rocketChartOptions.setYAxisOptions(yAxisOptions);

        rocketChartOptions.setWidth(CHART_WIDTH);
        rocketChartOptions.setRoundedCorners(true);
        rocketChartOptions.setBorder(false);
        rocketChartOptions.setBackgroundColor("#c8a45c");
        rocketChartOptions.setBackgroundOpacity(50);
        rocketChartOptions.setLegend(null, new ChartTextStyle(null, null, "black", null));

        ColumnChart rocketChart = new ColumnChart("rockets_chart", rocketChartOptions, cost_series);

        spaceXData.addElement(rocketChart);

        // Add dragon data
        Loop dragonLoop = new Loop("dragons");
        for (JsonElement json : dragons) {
            JsonObject dragon = (JsonObject) json;
            ImageUrl img = new ImageUrl("image", dragon.get("flickr_images").getAsJsonArray().get(0).getAsString());
            img.setMaxHeight(IMAGE_MAX_HEIGHT);
            img.setMaxWidth(IMAGE_MAX_WIDTH);
            ElementCollection coll = ElementCollection.makeCollectionFromJson("dragon", dragon);
            coll.addElement(img);
            coll.addElement(new Property("description", shortenDescription(dragon.get("description").getAsString())));
            coll.addElement(new HyperLink("wikipedia", "Wikipedia", dragon.get("wikipedia").getAsString()));
            dragonLoop.addElement(coll);
        }
        spaceXData.addElement(dragonLoop);

        // Add launchpad data
        Loop launchpadLoop = new Loop("launch_pads");
        for (JsonElement json : launchPads) {
            JsonObject launchpad = (JsonObject) json;
            ImageUrl img = new ImageUrl("image",
                    launchpad.get("images").getAsJsonObject().get("large").getAsJsonArray().get(0).getAsString());
            img.setMaxHeight(IMAGE_MAX_HEIGHT);
            img.setMaxWidth(IMAGE_MAX_WIDTH);
            ElementCollection coll = ElementCollection.makeCollectionFromJson("launchpad", launchpad);
            coll.addElement(img);
            coll.addElement(new Property("details", shortenDescription(launchpad.get("details").getAsString())));
            launchpadLoop.addElement(coll);
        }
        spaceXData.addElement(launchpadLoop);

        // Add landingpad data
        Loop landingpadLoop = new Loop("landing_pads");
        for (JsonElement json : landingPads) {
            JsonObject landingpad = (JsonObject) json;
            ImageUrl img = new ImageUrl("image",
                    landingpad.get("images").getAsJsonObject().get("large").getAsJsonArray().get(0).getAsString());
            img.setMaxHeight(IMAGE_MAX_HEIGHT);
            img.setMaxWidth(IMAGE_MAX_WIDTH);
            ElementCollection coll = ElementCollection.makeCollectionFromJson("landingpad", landingpad);
            coll.addElement(img);
            coll.addElement(new Property("details", shortenDescription(landingpad.get("details").getAsString())));
            coll.addElement(new HyperLink("wikipedia", "Wikipedia", landingpad.get("wikipedia").getAsString()));
            landingpadLoop.addElement(coll);
        }
        spaceXData.addElement(landingpadLoop);

        // Add ship data
        Loop shipLoop = new Loop("ships");
        for (JsonElement json : ships) {
            JsonObject ship = (JsonObject) json;
            ImageUrl img;
            if (ship.get("image").isJsonNull() == false) {
                img = new ImageUrl("image", ship.get("image").getAsString());
                img.setMaxHeight(IMAGE_MAX_HEIGHT);
                img.setMaxWidth(IMAGE_MAX_WIDTH);
            } else {
                img = new ImageUrl("image", null);
            }
            ElementCollection coll = ElementCollection.makeCollectionFromJson("ship", ship);
            coll.addElement(img);
            if (ship.get("link").isJsonNull() == false) {
                coll.addElement(new HyperLink("website", "Website", ship.get("link").getAsString()));
            } else {
                coll.addElement(new HyperLink("website", "Website", null));
            }
            shipLoop.addElement(coll);
        }
        spaceXData.addElement(shipLoop);

        Hashtable<String, RenderElement> data = new Hashtable<String, RenderElement>();
        data.put("spaceXData", spaceXData);

        // Set-Up Cloud Office Print server
        Server copServer = new Server("https://api.cloudofficeprint.com/");
        copServer.setVerbose(true);
        copServer.setAPIKey(APIKey);

        Base64Resource base64Resource = new Base64Resource();
        if (template.equals("docx")) {
            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/SpaceX/spacex_template.docx");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("spacex_template.docx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("docx");
            base64Resource.setMimeType(Mimetype.getMimeType("docx"));
            // End replacement code.
        } else if (template.equals("pptx")) {
            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/SpaceX/spacex_template.pptx");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("spacex_template.pptx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("pptx");
            base64Resource.setMimeType(Mimetype.getMimeType("pptx"));
            // End replacement code.
        } else if (template.equals("xlsx")) {
            // The next line should normally be used by the user in his project but when the
            // jar is exported the reference to the files doesn't work anymore, so there is
            // a replacement code to make it work.
            // base64Resource.setFileFromLocalFile("./src/com/CloudOfficePrint/Examples/SpaceX/spacex_template.xlsx");
            // Begin replacement code:
            InputStream resourceAsStream = getClass().getResourceAsStream("spacex_template.xlsx");
            byte[] targetArray = new byte[resourceAsStream.available()];
            resourceAsStream.read(targetArray);
            String encodedString = Base64.getEncoder().encodeToString(targetArray);
            base64Resource.setFileBase64(encodedString);
            base64Resource.setFiletype("xlsx");
            base64Resource.setMimeType(Mimetype.getMimeType("xlsx"));
            // End replacement code.
        }

        Output output = new Output(null, "raw", "libreoffice", null, null, null, null);
        PrintJob printJob = new PrintJob(data, copServer, output, base64Resource, null, null, null, null);

        Response res = printJob.execute();
        res.downloadLocally("./downloads/spaceX");
    }
}
