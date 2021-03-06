package cloudofficeprint;

import com.cloudofficeprint.RenderElements.COPChart;
import com.cloudofficeprint.RenderElements.COPChartDateOptions;
import com.cloudofficeprint.RenderElements.Charts.ChartAxisOptions;
import com.cloudofficeprint.RenderElements.Charts.ChartDateOptions;
import com.cloudofficeprint.RenderElements.Charts.ChartOptions;
import com.cloudofficeprint.RenderElements.Charts.ChartTextStyle;
import com.cloudofficeprint.RenderElements.Charts.Charts.*;
import com.cloudofficeprint.RenderElements.Charts.Series.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

/**
 * Class containing tests for all the charts (also Cloud Office Print chart from
 * RenderElements).
 */
public class ChartTests {

	@Test
	public void testChartOptions() {

		// x-axis options
		ChartAxisOptions xAxisOptions = new ChartAxisOptions();
		xAxisOptions.setOrientation("minMax");
		xAxisOptions.setMin(5F);
		xAxisOptions.setMax(10F);

		ChartDateOptions chartDateOptions = new ChartDateOptions("unix", "mm/yy", "months", 1);
		xAxisOptions.setDateOptions(chartDateOptions);

		xAxisOptions.setTitle("title_x");
		xAxisOptions.setValues(true);

		ChartTextStyle valueStyle = new ChartTextStyle(true, true, "red", "Arial");
		xAxisOptions.setValuesStyle(valueStyle);

		ChartTextStyle titleStyle = new ChartTextStyle(true, false, "blue", "Arial");
		xAxisOptions.setTitleStyle(titleStyle);
		xAxisOptions.setTitleRotation(45);

		xAxisOptions.setMajorGridLines(true);
		xAxisOptions.setMajorUnit(2F);
		xAxisOptions.setMinorGridLines(true);
		xAxisOptions.setMinorUnit(1F);
		xAxisOptions.setFormatCode("General");

		// y-axis options
		ChartAxisOptions yAxisOptions = new ChartAxisOptions();
		yAxisOptions.setOrientation("minMax");
		yAxisOptions.setMin(5F);
		yAxisOptions.setMax(10F);

		yAxisOptions.setTitle("title_y");
		yAxisOptions.setValues(true);

		ChartTextStyle valueStyleY = new ChartTextStyle(true, true, "red", "Arial");
		yAxisOptions.setValuesStyle(valueStyleY);

		ChartTextStyle titleStyleY = new ChartTextStyle(true, false, "blue", "Arial");
		yAxisOptions.setTitleStyle(titleStyleY);
		yAxisOptions.setTitleRotation(45);

		yAxisOptions.setMajorGridLines(true);
		yAxisOptions.setMajorUnit(2F);
		yAxisOptions.setMinorGridLines(true);
		yAxisOptions.setMinorUnit(1F);
		yAxisOptions.setFormatCode("General");

		// y2-axis options same as y
		ChartAxisOptions y2AxisOptions = new ChartAxisOptions();
		y2AxisOptions.setOrientation("minMax");
		y2AxisOptions.setMin(5F);
		y2AxisOptions.setMax(10F);

		y2AxisOptions.setTitle("title_y");
		y2AxisOptions.setValues(true);

		ChartTextStyle valueStyleY2 = new ChartTextStyle(true, true, "red", "Arial");
		y2AxisOptions.setValuesStyle(valueStyleY2);

		ChartTextStyle titleStyleY2 = new ChartTextStyle(true, false, "blue", "Arial");
		y2AxisOptions.setTitleStyle(titleStyleY2);
		y2AxisOptions.setTitleRotation(45);

		y2AxisOptions.setMajorGridLines(true);
		y2AxisOptions.setMajorUnit(2F);
		y2AxisOptions.setMinorGridLines(true);
		y2AxisOptions.setMinorUnit(1F);
		y2AxisOptions.setFormatCode("General");

		// ChartOptions
		ChartOptions options = new ChartOptions();
		options.setXAxisOptions(xAxisOptions);
		options.setYAxisOptions(yAxisOptions);
		options.setY2AxisOptions(y2AxisOptions);
		options.setWidth(500);
		options.setHeight(500);
		options.setBorder(true);
		options.setRoundedCorners(false);
		options.setBackgroundColor("green");
		options.setBackgroundOpacity(50);
		options.setTitle("title_chart");
		ChartTextStyle generalTitleStyle = new ChartTextStyle(false, true, "red", "Arial");
		options.setTitleStyle(generalTitleStyle);
		options.setGrid(true);

		ChartTextStyle legendStyle = new ChartTextStyle(true, true, "blue", "Arial");
		options.setLegend("l", legendStyle);

		options.setDataLabels(";", false, false, true, false, true, "r");

		String optionsExpected = "{'axis': {'x': {'orientation': 'minMax', 'min': 5.0, 'max': 10.0, 'type': 'date', 'date': {'format': 'unix', 'code': 'mm/yy', 'unit': 'months', 'step': 1}, 'title': 'title_x', 'showValues': True, 'valuesStyle': {'italic': True, 'bold': True, 'color': 'red', 'font': 'Arial'}, 'titleStyle': {'italic': True, 'bold': False, 'color': 'blue', 'font': 'Arial'}, 'titleRotation': 45, 'majorGridlines': True, 'majorUnit': 2.0, 'minorGridlines': True, 'minorUnit': 1.0, 'formatCode': 'General'}, 'y': {'orientation': 'minMax', 'min': 5.0, 'max': 10.0, 'title': 'title_y', 'showValues': True, 'valuesStyle': {'italic': True, 'bold': True, 'color': 'red', 'font': 'Arial'}, 'titleStyle': {'italic': True, 'bold': False, 'color': 'blue', 'font': 'Arial'}, 'titleRotation': 45, 'majorGridlines': True, 'majorUnit': 2.0, 'minorGridlines': True, 'minorUnit': 1.0, 'formatCode': 'General'}, 'y2': {'orientation': 'minMax', 'min': 5.0, 'max': 10.0, 'title': 'title_y', 'showValues': True, 'valuesStyle': {'italic': True, 'bold': True, 'color': 'red', 'font': 'Arial'}, 'titleStyle': {'italic': True, 'bold': False, 'color': 'blue', 'font': 'Arial'}, 'titleRotation': 45, 'majorGridlines': True, 'majorUnit': 2.0, 'minorGridlines': True, 'minorUnit': 1.0, 'formatCode': 'General'}}, 'width': 500, 'height': 500, 'border': True, 'roundedCorners': False, 'backgroundColor': 'green', 'backgroundOpacity': 50, 'title': 'title_chart', 'titleStyle': {'italic': False, 'bold': True, 'color': 'red', 'font': 'Arial'}, 'grid': True, 'legend': {'showLegend': True, 'position': 'l', 'style': {'italic': True, 'bold': True, 'color': 'blue', 'font': 'Arial'}}, 'dataLabels': {'showDataLabels': True, 'separator': ';', 'showSeriesName': False, 'showCategoryName': False, 'showLegendKey': True, 'showValue': False, 'showPercentage': True, 'position': 'r'}}";
		// System.out.println(options.getJSON());
		JsonObject jsonCorrect = JsonParser.parseString(optionsExpected).getAsJsonObject();
		// System.out.println(jsonCorrect);
		assertEquals(jsonCorrect, options.getJSON());
	}

	@Test
	public void testChartLine() {
		LineSeries line1 = new LineSeries("line1", new String[] { "a", "b", "c" }, new String[] { "1", "2", "3" },
				"red", true, "diamond", "10px", "0.2cm", "sysDashDotDot");
		LineSeries line2 = new LineSeries("line2", new String[] { "a", "b", "c" }, new String[] { "4", "5", "6" },
				"blue", true, "square", "12px", "2px", "sysDash");
		LineChart lineChart = new LineChart("test_name", null, line1, line2);
		String correct = "{'test_name': {'lines': [{'data': [{'x': 'a', 'y': '1'}, {'x': 'b', 'y': '2'}, {'x': 'c', 'y': '3'}], 'name': 'line1', 'smooth': True, 'symbol': 'diamond', 'symbolSize': '10px', 'color': 'red', 'lineWidth': '0.2cm', 'lineStyle': 'sysDashDotDot'}, {'data': [{'x': 'a', 'y': '4'}, {'x': 'b', 'y': '5'}, {'x': 'c', 'y': '6'}], 'name': 'line2', 'smooth': True, 'symbol': 'square', 'symbolSize': '12px', 'color': 'blue', 'lineWidth': '2px', 'lineStyle': 'sysDash'}], 'type': 'line'}}";
		// System.out.println(lineChart.getJSON());
		JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
		// System.out.println(jsonCorrect);
		assertEquals(jsonCorrect, lineChart.getJSON());
	}

	@Test
	public void testChartBar() {
		BarSeries bar1 = new BarSeries("bars1", new String[] { "a", "b", "c" }, new String[] { "1", "2", "3" });
		bar1.setColor("red");
		BarSeries bar2 = new BarSeries("bars2", new String[] { "a", "b", "c" }, new String[] { "4", "5", "6" });
		bar2.setColor("blue");
		BarChart barChart = new BarChart("bar_chart", null, bar1, bar2);
		String correct = "{'bar_chart': {'bars': [{'data': [{'x': 'a', 'y': '1'}, {'x': 'b', 'y': '2'}, {'x': 'c', 'y': '3'}], 'name': 'bars1','color':'red'}, {'data': [{'x': 'a', 'y': '4'}, {'x': 'b', 'y': '5'}, {'x': 'c', 'y': '6'}], 'name': 'bars2','color':'blue'}], 'type': 'bar'}}\n";
		// System.out.println(barChart.getJSON());
		JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
		// System.out.println(jsonCorrect);
		assertEquals(jsonCorrect, barChart.getJSON());
	}

	@Test
	public void testChartPie() {
		PieSeries pie1 = new PieSeries("pies1", new String[] { "a", "b", "c" }, new String[] { "1", "2", "3" },
				new String[] { "red", null, "blue" });
		pie1.setColor("red");
		PieSeries pie2 = new PieSeries("pies2", new String[] { "a", "b", "c" }, new String[] { "4", "5", "6" },
				new String[] { "green", "blue", null });
		pie2.setColor("green");
		PieChart pieChart = new PieChart("pie_chart", null, pie1, pie2);
		String correct = "{'pie_chart': {'pies': [{'data': [{'x': 'a', 'y': '1', 'color': 'red'}, {'x': 'b', 'y': '2'}, {'x': 'c', 'y': '3', 'color': 'blue'}], 'name': 'pies1', 'color': 'red'}, {'data': [{'x': 'a', 'y': '4', 'color': 'green'}, {'x': 'b', 'y': '5', 'color': 'blue'}, {'x': 'c', 'y': '6'}], 'name': 'pies2', 'color': 'green'}], 'type': 'pie'}}";
		// System.out.println(pieChart.getJSON());
		JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
		// System.out.println(jsonCorrect);
		assertEquals(jsonCorrect, pieChart.getJSON());
	}

	@Test
	public void testChartArea() {
		AreaSeries serie1 = new AreaSeries("area1", new String[] { "a", "b", "c" }, new String[] { "1", "2", "3" },
				"red", 50F);
		AreaSeries serie2 = new AreaSeries("area2", new String[] { "a", "b", "c" }, new String[] { "4", "5", "6" },
				"blue", 80F);
		AreaChart areaChart = new AreaChart("area_chart", null, serie1, serie2);
		String correct = "{'area_chart': {'areas': [{'data': [{'x': 'a', 'y': '1'}, {'x': 'b', 'y': '2'}, {'x': 'c', 'y': '3'}], 'name': 'area1', 'color': 'red', 'opacity': 50.0}, {'data': [{'x': 'a', 'y': '4'}, {'x': 'b', 'y': '5'}, {'x': 'c', 'y': '6'}], 'name': 'area2', 'color': 'blue', 'opacity': 80.0}], 'type': 'area'}}";
		// System.out.println(areaChart.getJSON());
		JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
		// System.out.println(jsonCorrect);
		assertEquals(jsonCorrect, areaChart.getJSON());
	}

	@Test
	public void testChartBubble() {
		BubbleSeries bubble1 = new BubbleSeries("bubble1", new String[] { "a", "b", "c" },
				new String[] { "1", "2", "3" }, new Integer[] { 5, 6, 2 });
		bubble1.setColor("red");
		BubbleSeries bubble2 = new BubbleSeries("bubble2", new String[] { "a", "b", "c" },
				new String[] { "4", "5", "6" }, new Integer[] { 5, 6, 2 });
		bubble2.setColor("blue");
		BubbleChart bubbleChart = new BubbleChart("bubble_chart", null, bubble1, bubble2);
		String correct = "{'bubble_chart': {'bubbles': [{'data': [{'x': 'a', 'y': '1', 'size': 5}, {'x': 'b', 'y': '2', 'size': 6}, {'x': 'c', 'y': '3', 'size': 2}], 'name': 'bubble1', 'color': 'red'}, {'data': [{'x': 'a', 'y': '4', 'size': 5}, {'x': 'b', 'y': '5', 'size': 6}, {'x': 'c', 'y': '6', 'size': 2}], 'name': 'bubble2', 'color': 'blue'}], 'type': 'bubble'}}";
		// System.out.println(bubbleChart.getJSON());
		JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
		// System.out.println(jsonCorrect);
		assertEquals(jsonCorrect, bubbleChart.getJSON());
	}

	@Test
	public void testChartStock() {
		StockSeries serie1 = new StockSeries("stock1", new String[] { "1", "2", "3" }, new Integer[] { 4, 5, 6 },
				new Integer[] { 7, 8, 9 }, new Integer[] { 10, 11, 12 }, new Integer[] { 13, 14, 15 },
				new Integer[] { 16, 17, 18 });
		StockSeries serie2 = new StockSeries("stock2", new String[] { "1", "2", "3" }, new Integer[] { 4, 5, 6 },
				new Integer[] { 7, 8, 9 }, new Integer[] { 10, 11, 12 }, new Integer[] { 13, 14, 15 },
				new Integer[] { 16, 17, 18 });
		StockChart chart = new StockChart("stock_chart", null, serie1, serie2);
		String correct = "{'stock_chart': {'stocks': [{'data': [{'x': '1', 'high': 4, 'low': 7, 'close': 10, 'open': 13, 'volume': 16}, {'x': '2', 'high': 5, 'low': 8, 'close': 11, 'open': 14, 'volume': 17}, {'x': '3', 'high': 6, 'low': 9, 'close': 12, 'open': 15, 'volume': 18}], 'name': 'stock1'}, {'data': [{'x': '1', 'high': 4, 'low': 7, 'close': 10, 'open': 13, 'volume': 16}, {'x': '2', 'high': 5, 'low': 8, 'close': 11, 'open': 14, 'volume': 17}, {'x': '3', 'high': 6, 'low': 9, 'close': 12, 'open': 15, 'volume': 18}], 'name': 'stock2'}], 'type': 'stock'}}";
		// System.out.println(chart.getJSON());
		JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
		// System.out.println(jsonCorrect);
		assertEquals(jsonCorrect, chart.getJSON());
	}

	@Test
	public void testCombinedChart() {
		ColumnSeries columnSeries1 = new ColumnSeries("column1", new String[] { "a", "b", "c" },
				new String[] { "1", "2", "3" });
		ColumnSeries columnSeries2 = new ColumnSeries("column2", new String[] { "a", "b", "c" },
				new String[] { "4", "5", "6" });
		ColumnChart columnChart = new ColumnChart("column_chart", null, columnSeries1, columnSeries2);

		LineSeries lineSerie1 = new LineSeries("line1", new String[] { "a", "b", "c" }, new String[] { "1", "2", "3" },
				null, null, "square", null, null, null);
		LineSeries lineSerie2 = new LineSeries("line2", new String[] { "a", "b", "c" }, new String[] { "4", "5", "6" },
				null, null, "square", null, null, null);
		ChartOptions chartOptions = new ChartOptions();
		ChartAxisOptions axisOptions = new ChartAxisOptions();
		chartOptions.setXAxisOptions(axisOptions);
		chartOptions.setYAxisOptions(axisOptions);
		chartOptions.setWidth(50);
		chartOptions.setBackgroundColor("gray");
		chartOptions.setBackgroundOpacity(50);
		LineChart lineChart = new LineChart("lines", chartOptions, lineSerie1, lineSerie2);

		BarSeries bar1 = new BarSeries("bar1", new String[] { "a", "b", "c" }, new String[] { "1", "2", "3" });
		BarSeries bar2 = new BarSeries("bar2", new String[] { "a", "b", "c" }, new String[] { "4", "5", "6" });
		ChartOptions barChartOptions = new ChartOptions();
		barChartOptions.setXAxisOptions(axisOptions);
		barChartOptions.setYAxisOptions(axisOptions);
		barChartOptions.setWidth(100);
		barChartOptions.setHeight(100);
		barChartOptions.setRoundedCorners(false);
		BarChart barChart = new BarChart("bar_chart", barChartOptions, bar1, bar2);

		CombinedChart combinedChart = new CombinedChart("combined_chart", chartOptions,
				new Chart[] { columnChart, lineChart }, new Chart[] { barChart });

		String correct = "{\"combined_chart\":{\"multiples\":[{\"columns\":[{\"data\":[{\"x\":\"a\",\"y\":\"1\"},{\"x\":\"b\",\"y\":\"2\"},{\"x\":\"c\",\"y\":\"3\"}],\"name\":\"column1\"},{\"data\":[{\"x\":\"a\",\"y\":\"4\"},{\"x\":\"b\",\"y\":\"5\"},{\"x\":\"c\",\"y\":\"6\"}],\"name\":\"column2\"}],\"type\":\"column\"},{\"options\":{\"axis\":{\"x\":{},\"y\":{}},\"width\":50,\"backgroundColor\":\"gray\",\"backgroundOpacity\":50},\"lines\":[{\"data\":[{\"x\":\"a\",\"y\":\"1\"},{\"x\":\"b\",\"y\":\"2\"},{\"x\":\"c\",\"y\":\"3\"}],\"name\":\"line1\",\"symbol\":\"square\"},{\"data\":[{\"x\":\"a\",\"y\":\"4\"},{\"x\":\"b\",\"y\":\"5\"},{\"x\":\"c\",\"y\":\"6\"}],\"name\":\"line2\",\"symbol\":\"square\"}],\"type\":\"line\"},{\"options\":{\"axis\":{\"x\":{},\"y\":{}},\"width\":100,\"height\":100,\"roundedCorners\":false},\"bars\":[{\"data\":[{\"x\":\"a\",\"y2\":\"1\"},{\"x\":\"b\",\"y2\":\"2\"},{\"x\":\"c\",\"y2\":\"3\"}],\"name\":\"bar1\"},{\"data\":[{\"x\":\"a\",\"y2\":\"4\"},{\"x\":\"b\",\"y2\":\"5\"},{\"x\":\"c\",\"y2\":\"6\"}],\"name\":\"bar2\"}],\"type\":\"bar\"}],\"options\":{\"axis\":{\"x\":{},\"y\":{}},\"width\":50,\"backgroundColor\":\"gray\",\"backgroundOpacity\":50},\"type\":\"multiple\"}}";
		JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
		// System.out.println(combinedChart.getJSON());
		// System.out.println(jsonCorrect);
		assertEquals(jsonCorrect, combinedChart.getJSON());
	}

	@Test
	public void testChartCOP() {
		JsonArray xdata = new JsonArray();
		xdata.add("a");
		xdata.add("b");
		xdata.add("c");

		JsonArray ydata1 = new JsonArray();
		ydata1.add("1");
		ydata1.add("2");
		ydata1.add("3");

		JsonArray ydata2 = new JsonArray();
		ydata2.add("4");
		ydata2.add("5");
		ydata2.add("6");

		HashMap<String, JsonArray> yDatas = new HashMap<>();
		yDatas.put("series 1", ydata1);
		yDatas.put("series 2", ydata2);
		COPChartDateOptions copChartDateOptions = new COPChartDateOptions("d/m/yyyy", "days", 1);

		COPChart chart = new COPChart("cop_chart", xdata, yDatas, "cop_chart_title", "x-axis", "y-axis", "y2-axis",
				"x2-axis", copChartDateOptions);

		String correct = "{'cop_chart': {'xAxis': {'data': ['a', 'b', 'c'], 'title': 'x-axis', 'date': {'format': 'd/m/yyyy', 'unit': 'days', 'step': 1}}, 'yAxis': {'series': [{'name': 'series 1', 'data': ['1', '2', '3']}, {'name': 'series 2', 'data': ['4', '5', '6']}], 'title': 'y-axis'}, 'title': 'cop_chart_title', 'x2Axis': {'title': 'x2-axis'}, 'y2Axis': {'title': 'y2-axis'}}}\n";
		JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
		// System.out.println(chart.getJSON());
		// System.out.println(jsonCorrect);
		assertEquals(jsonCorrect, chart.getJSON());
	}

}
