package cloudofficeprint;

import com.cloudofficeprint.RenderElements.*;
import com.cloudofficeprint.RenderElements.Cells.CellStyleDocxPpt;
import com.cloudofficeprint.RenderElements.Cells.CellStyleXlsx;
import com.cloudofficeprint.RenderElements.Cells.TableCell;
import com.cloudofficeprint.RenderElements.Images.ImageUrl;
import com.cloudofficeprint.RenderElements.Loops.Loop;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RenderElementsTests {

    @Test
    public void Property() {
        Property property = new Property("name", "value");
        String correct = "{'name': 'value'}";
        // System.out.println(property.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, property.getJSON());
    }

    @Test
    public void cellStylePropertyDocx() {
        CellStyleDocxPpt cellStyle = new CellStyleDocxPpt("#eb4034", "10");
        TableCell cell = new TableCell("name", "value", cellStyle);
        String correct = "{'name': 'value', 'name_cell_background_color': '#eb4034', 'name_width': '10'}";
        // System.out.println(cell.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, cell.getJSON());
    }

    @Test
    public void cellStylePropertyXlsx() {
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
        TableCell cell = new TableCell("name", "value", cellStyle);
        String correct = "{'name': 'value', 'name_cell_locked': True, 'name_cell_hidden': False, 'name_cell_background': '#ff0000', 'name_font_name': 'Arial', 'name_font_size': '12', 'name_font_color': '#ff0000', 'name_font_italic': True, 'name_font_bold': False, 'name_font_strike': False, 'name_font_underline': True, 'name_font_superscript': False, 'name_font_subscript': True, 'name_border_top': 'medium', 'name_border_top_color': '#ff0000', 'name_border_bottom': 'mediumDashed', 'name_border_bottom_color': '#ff0000', 'name_border_left': 'mediumDashDot', 'name_border_left_color': '#ff0000', 'name_border_right': 'mediumDashDotDot', 'name_border_right_color': '#ff0000', 'name_border_diagonal': 'thick', 'name_border_diagonal_direction': 'up-wards', 'name_border_diagonal_color': '#ff0000', 'name_text_h_alignment': 'center', 'name_text_v_alignment': 'justify', 'name_text_rotation': '45'}";
        // System.out.println(cell.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, cell.getJSON());
    }

    @Test
    public void autoLink() {
        AutoLink cell = new AutoLink("autoLink", "sample text with multiple hyperlinks");
        String correct = "{'autoLink': 'sample text with multiple hyperlinks'}";
        // System.out.println(cell.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, cell.getJSON());
    }

    @Test
    public void hyperLink() {
        HyperLink cell = new HyperLink("hyperlink", "hyperlink_text", "url");
        String correct = "{'hyperlink': 'url', 'hyperlink_text': 'hyperlink_text'}";
        // System.out.println(cell.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, cell.getJSON());
    }

    @Test
    public void tableOfContent() {
        TableOfContents cell = new TableOfContents("table", "contents", 4, "underscore");
        String correct = "{'table_title': 'contents', 'table_show_level': 4, 'table_tab_leader': 'underscore'}";
        // System.out.println(cell.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, cell.getJSON());
    }

    @Test
    public void CellSpan() {
        CellSpan cell = new CellSpan("span_name", "This cell will span 2 rows and 3 columns", 3, 2);
        String correct = "{'span_name': 'This cell will span 2 rows and 3 columns', 'span_name_col_span': 3, 'span_name_row_span': 2}";
        // System.out.println(cell.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, cell.getJSON());
    }

    @Test
    public void styledProp() {
        StyledProperty prop = new StyledProperty("cust_first_name", "DemoCustomerName");
        prop.setFont("NanumMyeongjo");
        prop.setFontSize("25pt");
        prop.setFontColor("#ff00ff");
        prop.setBold(true);
        prop.setItalic(true);
        prop.setUnderline(false);
        prop.setStrikethrough(false);
        prop.setHighlightColor("darkMagenta");

        String correct = "{'cust_first_name': 'DemoCustomerName', 'cust_first_name_font_family': 'NanumMyeongjo', 'cust_first_name_font_size': '25pt', 'cust_first_name_font_color': '#ff00ff', 'cust_first_name_bold': True, 'cust_first_name_italic': True, 'cust_first_name_underline': False, 'cust_first_name_strikethrough': False, 'cust_first_name_highlight': 'darkMagenta'}";
        // System.out.println(cell.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, prop.getJSON());
    }

    @Test
    public void waterMark() {
        Watermark prop = new Watermark("wm_name", "wm_text");
        prop.setFont("Arial");
        prop.setColor("red");
        prop.setWidth("50");
        prop.setHeight("30");
        prop.setOpacity(50F);
        prop.setRotation(-45);

        String correct = "{'wm_name': 'wm_text', 'wm_name_color': 'red', 'wm_name_font': 'Arial', 'wm_name_width': '50', 'wm_name_height': '30', 'wm_name_opacity': 50.0, 'wm_name_rotation': -45}";
        // System.out.println(prop.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, prop.getJSON());
    }

    @Test
    public void D3Code() {
        D3Code prop = new D3Code("d3_code", "test_code", "['a', 1, 2, 3, 'b']");

        String correct = "{'d3_code': 'test_code', 'd3_code_data': \"['a', 1, 2, 3, 'b']\"}";
        // System.out.println(prop.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, prop.getJSON());
    }

    @Test
    public void textBox() {
        TextBox prop = new TextBox("tbox_name", "tbox_value");
        prop.setFont("Arial");
        prop.setFontColor("blue");
        prop.setFontSize(12);
        prop.setTransparency("50%");
        prop.setWidth("30");
        prop.setHeight("25");

        String correct = "{'tbox_name': 'tbox_value', 'tbox_name_font': 'Arial', 'tbox_name_font_color': 'blue', 'tbox_name_font_size': 12, 'tbox_name_transparency': '50%', 'tbox_name_width': '30', 'tbox_name_height': '25'}";
        // System.out.println(prop.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, prop.getJSON());
    }

    @Test
    public void freeze() {
        Freeze prop = new Freeze("name", "C6");
        String correct = "{'name' : 'C6' }";
        Freeze prop1 = new Freeze("name", "true");
        String correct1 = "{'name': 'true' }";
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        JsonObject jsonCorrect1 = JsonParser.parseString((correct1)).getAsJsonObject();
        assertEquals(jsonCorrect, prop.getJSON());
        assertEquals(jsonCorrect1, prop1.getJSON());
    }

    @Test
    public void insert() {
        Insert insert = new Insert("doc", "Base64 encoded file");
        String correct = "{'doc':'Base64 encoded file'}";
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        assertEquals(jsonCorrect, insert.getJSON());
    }

    @Test
    public void elementCollection() {
        ElementCollection data = new ElementCollection("data");
        ImageUrl element1 = new ImageUrl("image1", "url");
        element1.setAltText("alt_text");
        data.addElement(element1);

        Property prop1 = new Property("prop", "value1");
        Property prop2 = new Property("prop", "value2");
        Loop element2 = new Loop("loop", new Property[]{prop1, prop2});

        data.addElement(element2);

        String correct = "{'image1': 'url', 'image1_alt_text': 'alt_text', 'loop': [{'prop': 'value1'}, {'prop': 'value2'}]}";
        // System.out.println(data.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, data.getJSON());

        data.removeElementByName("image1");

        correct = "{'loop': [{'prop': 'value1'}, {'prop': 'value2'}]}";
        // System.out.println(data.getJSON());
        jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, data.getJSON());
    }

    @Test
    public void protectSheet() {
        ProtectSheet prop = new ProtectSheet("sheet1");
        prop.setPassword("password");
        prop.setAutoFilter(true);
        prop.setDeleteColumns(false);
        prop.setDeleteRows(true);
        prop.setFormatCells(false);
        prop.setFormatColumns(true);
        prop.setFormatRows(false);
        prop.setInsertColumns(true);
        prop.setInsertHyperlinks(false);
        prop.setInsertColumns(true);
        prop.setInsertRows(false);
        prop.setPivotTables(true);
        prop.setSelectLockedCells(false);
        prop.setSelectUnlockedCells(true);
        prop.setSort(false);

        String correct = "{ 'sheet1_allow_auto_filter': true,'sheet1_allow_delete_columns': false,'sheet1_allow_delete_rows': true,'sheet1_allow_format_cells': false,'sheet1_allow_format_columns': true,'sheet1_allow_format_rows': false,'sheet1_allow_insert_columns': true,'sheet1_allow_insert_hyperlinks': false,'sheet1_allow_insert_rows': false,'sheet1_password': 'password','sheet1_allow_pivot_tables': true,'sheet1_allow_select_locked_cells': false,'sheet1_allow_select_unlocked_cells': true,'sheet1_allow_sort': false}";
        // System.out.println(prop.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, prop.getJSON());
    }

    @Test
    public void ExcelInsert() {
        ExcelInsert excelInsert = new ExcelInsert("fileToInsert", "base64EncodedValue");
//        excelInsert.setPreview(true);
        excelInsert.setIcon("base64icon");
        excelInsert.setFromRow("2");
        excelInsert.setFromCol("C5");
        excelInsert.setToCol("C5");
        excelInsert.setFromRowOff("2px");
        excelInsert.setFromColOff("2px");
        excelInsert.setToRow("5");
        excelInsert.setToRowOff("2px");
        excelInsert.setToColOff("2px");
        String correct = "{ 'fileToInsert':'base64EncodedValue','fileToInsert_icon':'base64icon','fileToInsert_fromRow':'2','fileToInsert_fromCol':'C5','fileToInsert_fromRowOff':'2px','fileToInsert_fromColOff':'2px','fileToInsert_toRow':'5','fileToInsert_toCol':'C5','fileToInsert_toRowOff':'2px','fileToInsert_toColOff':'2px'}";
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        assertEquals(jsonCorrect, excelInsert.getJSON());
    }

    @Test
    public void Embed() {
        Embed embed = new Embed("fileToInsert", "base64EncodedFile");
        String correct = "{'fileToInsert':'base64EncodedFile'}";
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        assertEquals(jsonCorrect, embed.getJSON());
    }

    @Test
    public void ValidateCell() {
        ValidateCell validate = new ValidateCell("tagName");
        validate.setIgnoreBlank(true);
        validate.setAllow("whole");
        validate.setValue1("0");
        validate.setValue2("100");
        validate.setInCellDropdown(false);
        validate.setData("between");
        validate.setShowInputMessage(true);
        validate.setInputTitle("Instructions");
        validate.setInputMessage("Insert number between 0 and 100");
        validate.setShowErrorAlert(true);
        validate.setErrorStyle("warning");
        validate.setErrorTitle("Error");
        validate.setErrorMessage("Number out of bound.");
        String correct = "{'tagName_ignore_blank':true,'tagName_allow':'whole','tagName_value1':'0','tagName_value2':'100','tagName_in_cell_dropdown':false,'tagName_data':'between','tagName_show_input_message':true,'tagName_input_title':'Instructions','tagName_input_message':'Insert number between 0 and 100','tagName_show_error_alert':true,'tagName_error_style':'warning','tagName_error_title':'Error','tagName_error_message':'Number out of bound.'}";
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        assertEquals(jsonCorrect, validate.getJSON());
    }
}
