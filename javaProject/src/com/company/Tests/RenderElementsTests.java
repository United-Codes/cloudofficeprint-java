package com.company.Tests;

import com.company.RenderElements.*;
import com.company.RenderElements.Cells.CellStyleDocxPpt;
import com.company.RenderElements.Cells.CellStyleXlsx;
import com.company.RenderElements.Cells.TableCell;
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

    public void cellStylePropertyDocx(){
        CellStyleDocxPpt cellStyle = new CellStyleDocxPpt("#eb4034","10");
        TableCell cell = new TableCell("name","value",cellStyle);
        String correct= "{'name': 'value', 'name_background_color': '#eb4034', 'name_width': '10'}";
        //System.out.println(cell.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,cell.getJSON());
    }

    public void cellStylePropertyXlsx(){
        CellStyleXlsx cellStyle = new CellStyleXlsx();
        cellStyle.setCellLocked(true);
        cellStyle.setCellHidden(false);
        cellStyle.setCellBackground("#ff0000");
        cellStyle.setFont("Arial");
        cellStyle.setFontSize(12);
        cellStyle.setFontColor("#ff0000");
        cellStyle.setFontItalic(true);
        cellStyle.setFontBold(false);
        cellStyle.setFontStrike(false);
        cellStyle.setFontUnderline(true);
        cellStyle.setFontSuperscript(false);
        cellStyle.setFontSubscript(true);
        cellStyle.setBorderTop("medium");
        cellStyle.setBorderTopColor("#ff0000");
        cellStyle.setBorderBottom("mediumDashed");
        cellStyle.setBorderBottomColor("#ff0000");
        cellStyle.setBorderLeft("mediumDashDot");
        cellStyle.setBorderLeftColor("#ff0000");
        cellStyle.setBorderRight("mediumDashDotDot");
        cellStyle.setBorderRightColor("#ff0000");
        cellStyle.setBorderDiagonal("thick");
        cellStyle.setBorderDiagonalDirection("up-wards");
        cellStyle.setBorderDiagonalColor("#ff0000");
        cellStyle.setTextHAlignment("center");
        cellStyle.setTextVAlignment("justify");
        cellStyle.setTextRotation(45);
        TableCell cell = new TableCell("name","value",cellStyle);
        String correct= "{'name': 'value', 'name_cell_locked': True, 'name_cell_hidden': False, 'name_cell_background': '#ff0000', 'name_font_name': 'Arial', 'name_font_size': '12', 'name_font_color': '#ff0000', 'name_font_italic': True, 'name_font_bold': False, 'name_font_strike': False, 'name_font_underline': True, 'name_font_superscript': False, 'name_font_subscript': True, 'name_border_top': 'medium', 'name_border_top_color': '#ff0000', 'name_border_bottom': 'mediumDashed', 'name_border_bottom_color': '#ff0000', 'name_border_left': 'mediumDashDot', 'name_border_left_color': '#ff0000', 'name_border_right': 'mediumDashDotDot', 'name_border_right_color': '#ff0000', 'name_border_diagonal': 'thick', 'name_border_diagonal_direction': 'up-wards', 'name_border_diagonal_color': '#ff0000', 'name_text_h_alignment': 'center', 'name_text_v_alignment': 'justify', 'name_text_rotation': '45'}";
        //System.out.println(cell.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
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
