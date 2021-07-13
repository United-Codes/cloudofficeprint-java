package com.company.Tests;

import com.company.RenderElements.*;
import com.company.RenderElements.Images.Image;
import com.company.RenderElements.Images.ImageUrl;
import com.company.RenderElements.Loops.Loop;
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
        TextBox prop = new TextBox("tbox_name","tbox_value");
        prop.setFont("Arial");
        prop.setFontColor("blue");
        prop.setFontSize(12);
        prop.setTransparency("50%");
        prop.setWidth("30");
        prop.setHeight("25");

        String correct= "{'tbox_name': 'tbox_value', 'tbox_name_font': 'Arial', 'tbox_name_font_color': 'blue', 'tbox_name_font_size': 12, 'tbox_name_transparency': '50%', 'tbox_name_width': '30', 'tbox_name_height': '25'}";
        //System.out.println(prop.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,prop.getJSON());
    }

    public void elementCollection(){
        ElementCollection data= new ElementCollection("data");
        ImageUrl element1 = new ImageUrl("image1","url");
        element1.setAltText("alt_text");
        data.addElement(element1);

        Property prop1 = new Property("prop","value1");
        Property prop2 = new Property("prop","value2");
        Loop element2 = new Loop("loop", new Property[]{prop1, prop2});

        data.addElement(element2);

        String correct= "{'image1': 'url', 'image1_alt_text': 'alt_text', 'image1_url': 'url', 'loop': [{'prop': 'value1'}, {'prop': 'value2'}]}";
        //System.out.println(data.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,data.getJSON());

        data.removeElementByName("image1");

        correct= "{'loop': [{'prop': 'value1'}, {'prop': 'value2'}]}";
        //System.out.println(data.getJSON());
        jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,data.getJSON());
    }

}
