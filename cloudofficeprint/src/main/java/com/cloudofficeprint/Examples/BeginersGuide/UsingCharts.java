package com.cloudofficeprint.Examples.BeginersGuide;

import com.cloudofficeprint.Mimetype;
import com.cloudofficeprint.Output.Output;
import com.cloudofficeprint.PrintJob;
import com.cloudofficeprint.RenderElements.Charts.ChartAxisOptions;
import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.Charts.*;
import com.cloudofficeprint.RenderElements.Charts.Series.*;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.cloudofficeprint.RenderElements.RenderElement;
import com.cloudofficeprint.Resources.Base64Resource;
import com.cloudofficeprint.Response;
import com.cloudofficeprint.Server.Server;

import java.io.InputStream;
import java.util.Base64;
import java.util.Hashtable;

public class UsingCharts {
    public void main() throws Exception {
        System.out.println("Beginner guide for using charts use java SDK");

        // Load template
        Base64Resource template = new Base64Resource();
        InputStream resourceAsStream = getClass().getResourceAsStream("/BeginnerGuide/UsingCharts/template_Charts.docx");
        byte[] targetArray = new byte[resourceAsStream.available()];
        resourceAsStream.read(targetArray);
        String encodedString = Base64.getEncoder().encodeToString(targetArray);
        template.setFileBase64(encodedString);
        template.setFiletype("docx");
        template.setMimeType(Mimetype.getMimeType("docx"));

        //Set up Cloud Office Print Server.
        Server copServer = new Server("http://localhost:8010/");
        copServer.setVerbose(true);
        copServer.setAPIKey("YOUR_API_KEY");

        //Main ElementCollection that includes all the data
        ElementCollection data = new ElementCollection("data");

        //Line-Charts
        LineSeries line1 = new LineSeries("line1", new String[]{"a", "b", "c"}, new String[]{"1", "2", "3"},
                "red", true, "diamond", "10px", "0.2cm", "sysDashDotDot");
        LineSeries line2 = new LineSeries("line2", new String[]{"a", "b", "c"}, new String[]{"4", "5", "6"},
                "blue", true, "square", "12px", "2px", "sysDash");
        LineChart lineChart = new LineChart("line_chart", null, line1, line2);
        data.addElement(lineChart);

        //Bar-chart
        BarSeries bar1 = new BarSeries("bars1", new String[]{"a", "b", "c"}, new String[]{"1", "2", "3"});
        bar1.setColor("red");
        BarSeries bar2 = new BarSeries("bars2", new String[]{"a", "b", "c"}, new String[]{"4", "5", "6"});
        bar2.setColor("blue");
        BarChart barChart = new BarChart("bar_chart", null, bar1, bar2);
        data.addElement(barChart);

        //Pie-Chart
        PieSeries pie1 = new PieSeries("pies1", new String[]{"a", "b", "c"}, new String[]{"1", "2", "3"},
                new String[]{"red", null, "blue"});
        pie1.setColor("red");
        PieSeries pie2 = new PieSeries("pies2", new String[]{"a", "b", "c"}, new String[]{"4", "5", "6"},
                new String[]{"green", "blue", null});
        pie2.setColor("green");
        PieChart pieChart = new PieChart("pie_chart", null, pie1, pie2);
        data.addElement(pieChart);

        //Area-Chart
        AreaSeries serie1 = new AreaSeries("area1", new String[]{"a", "b", "c"}, new String[]{"1", "2", "3"},
                "red", 50F);
        AreaSeries serie2 = new AreaSeries("area2", new String[]{"a", "b", "c"}, new String[]{"4", "5", "6"},
                "blue", 80F);
        AreaChart areaChart = new AreaChart("area_chart", null, serie1, serie2);
        data.addElement(areaChart);

        //Bubble Chart
        BubbleSeries bubble1 = new BubbleSeries("bubble1", new String[]{"a", "b", "c"},
                new String[]{"1", "2", "3"}, new Integer[]{5, 6, 2});
        bubble1.setColor("red");
        BubbleSeries bubble2 = new BubbleSeries("bubble2", new String[]{"a", "b", "c"},
                new String[]{"4", "5", "6"}, new Integer[]{5, 6, 2});
        bubble2.setColor("blue");
        BubbleChart bubbleChart = new BubbleChart("bubble_chart", null, bubble1, bubble2);
        data.addElement(bubbleChart);

        //Combined-chart
        ColumnSeries columnSeries1 = new ColumnSeries("column1", new String[]{"a", "b", "c"},
                new String[]{"1", "2", "3"});
        ColumnSeries columnSeries2 = new ColumnSeries("column2", new String[]{"a", "b", "c"},
                new String[]{"4", "5", "6"});
        ColumnChart columnChart1 = new ColumnChart("column_chart", null, columnSeries1, columnSeries2);
        LineSeries lineSerie1 = new LineSeries("line1", new String[]{"a", "b", "c"}, new String[]{"1", "2", "3"},
                null, null, "square", null, null, null);
        LineSeries lineSerie2 = new LineSeries("line2", new String[]{"a", "b", "c"}, new String[]{"4", "5", "6"},
                null, null, "square", null, null, null);

        LineChart lineChart1 = new LineChart("lines", null, lineSerie1, lineSerie2);

        BarSeries Bar1 = new BarSeries("bar1", new String[]{"a", "b", "c"}, new String[]{"1", "2", "3"});
        BarSeries Bar2 = new BarSeries("bar2", new String[]{"a", "b", "c"}, new String[]{"4", "5", "6"});
        BarChart BarChart = new BarChart("bar_chart", null, Bar1, Bar2);

        CombinedChart combinedChart = new CombinedChart("combined_chart", null,
                new Chart[]{columnChart1, lineChart1}, new Chart[]{BarChart});
        data.addElement(combinedChart);

        //Output configuration
        Output conf = new Output("docx", "raw", "libreoffice", null, null, null, null);

        Hashtable<String, RenderElement> dataTable = new Hashtable<String, RenderElement>();
        dataTable.put("data", data);


        PrintJob printJob = new PrintJob(dataTable, copServer, conf, template, null, null, null, null);

        Response response = printJob.execute();

        response.downloadLocally("./downloads/BeginnerGuide/UsingCharts/output");


    }
}
