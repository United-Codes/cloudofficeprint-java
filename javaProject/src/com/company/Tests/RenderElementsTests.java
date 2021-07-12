package com.company.Tests;

import com.company.RenderElements.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;

public class RenderElementsTests {

    public void Property(){
        Property property = new Property("name","value");
        String correct= "{'name': 'value'}";
        //System.out.println(property.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,property.getJSON());
    }

    public void cellStyleProperty(){
        TableCell cell = new TableCell("name","value","red", "10");
        String correct= "{'name': 'value', 'name_background_color': 'red', 'name_width': '10'}";
        //System.out.println(cell.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,cell.getJSON());
    }

    public void hyperLink(){
        HyperLink cell = new HyperLink("hyperlink","hyperlink_text","url");
        String correct= "{'hyperlink': 'url', 'hyperlink_text': 'hyperlink_text'}";
        //System.out.println(cell.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,cell.getJSON());
    }

    public void tableOfContent(){
        TableOfContents cell = new TableOfContents("table","contents",4,"underscore");
        String correct= "{'table_title': 'contents', 'table_show_level': 4, 'table_tab_leader': 'underscore'}";
        //System.out.println(cell.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,cell.getJSON());
    }

    public void CellSpan(){
        CellSpan cell = new CellSpan("span_name","This cell will span 2 rows and 3 columns",3,2);
        String correct= "{'span_name': 'This cell will span 2 rows and 3 columns', 'span_name_col_span': 3, 'span_name_row_span': 2}";
        //System.out.println(cell.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,cell.getJSON());
    }

    public void styledProp(){
        StyledProperty prop = new StyledProperty("cust_first_name","DemoCustomerName");
        prop.setFont("NanumMyeongjo");
        prop.setFontSize("25pt");
        prop.setFontColor("#ff00ff");
        prop.setBold(true);
        prop.setItalic(true);
        prop.setUnderline(false);
        prop.setStrikethrough(false);
        prop.setHighlightColor("darkMagenta");

        String correct= "{'cust_first_name': 'DemoCustomerName', 'cust_first_name_font_family': 'NanumMyeongjo', 'cust_first_name_font_size': '25pt', 'cust_first_name_font_color': '#ff00ff', 'cust_first_name_bold': True, 'cust_first_name_italic': True, 'cust_first_name_underline': False, 'cust_first_name_strikethrough': False, 'cust_first_name_highlight': 'darkMagenta'}";
        //System.out.println(cell.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,prop.getJSON());
    }

    public void waterMark(){
        Watermark prop = new Watermark("wm_name","wm_text");
        prop.setFont("Arial");
        prop.setColor("red");
        prop.setWidth("50");
        prop.setHeight("30");
        prop.setOpacity(50F);
        prop.setRotation(-45);

        String correct= "{'wm_name': 'wm_text', 'wm_name_color': 'red', 'wm_name_font': 'Arial', 'wm_name_width': '50', 'wm_name_height': '30', 'wm_name_opacity': 50.0, 'wm_name_rotation': -45}";
        //System.out.println(prop.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,prop.getJSON());
    }

    public void D3Code(){
        D3Code prop = new D3Code("d3_code","test_code","['a', 1, 2, 3, 'b']");

        String correct= "{'d3_code': 'test_code', 'd3_code_data': \"['a', 1, 2, 3, 'b']\"}";
        //System.out.println(prop.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,prop.getJSON());
    }

    public void textBox(){
        D3Code prop = new D3Code("d3_code","test_code","['a', 1, 2, 3, 'b']");

        String correct= "{'d3_code': 'test_code', 'd3_code_data': \"['a', 1, 2, 3, 'b']\"}";
        //System.out.println(prop.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,prop.getJSON());
    }
}
