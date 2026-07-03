package cloudofficeprint;
import com.cloudofficeprint.RenderElements.Form.Textbox;
import com.cloudofficeprint.RenderElements.Form.RadioButton;
import com.cloudofficeprint.RenderElements.Form.Checkbox;
import com.cloudofficeprint.RenderElements.Form.Dropdown;
import com.cloudofficeprint.RenderElements.Form.ComboBox;
import com.cloudofficeprint.RenderElements.Form.ListBox;
import com.cloudofficeprint.RenderElements.Form.PushButton;
import com.cloudofficeprint.RenderElements.Form.Password;
import com.cloudofficeprint.RenderElements.Form.ChoiceOption;
import com.cloudofficeprint.RenderElements.ElementCollection;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FormElementsTest {

    @Test
    public void testTextbox() {
        Textbox tb = new Textbox("last_name", "Apex R&D", 20, 200, true);
        JsonObject json = tb.getJSON();

        String expected = "{'last_name':[{'type':'text','name':'last_name',"
                + "'value':'Apex R&D','height':20,'width':200,'multiline':1}]}";

        assertEquals(
                JsonParser.parseString(expected),
                json
        );
    }

    @Test
    public void testRadioButton() {
        RadioButton rb = new RadioButton("payment", "cc", "Credit Card", true);
        JsonObject json = rb.getJSON();

        String expected = "{'payment':[{'type':'radio','name':'payment',"
                + "'value':'cc','text':'Credit Card','selected':true}]}";

        assertEquals(
                JsonParser.parseString(expected),
                json
        );
    }

    @Test
    public void testCheckbox() {
        Checkbox cb = new Checkbox("terms", true, "I Agree");
        JsonObject json = cb.getJSON();

        String expected = "{'terms':[{'type':'checkbox','name':'terms',"
                + "'value':1,'text':'I Agree'}]}";

        assertEquals(
                JsonParser.parseString(expected),
                json
        );
        assertEquals("1", cb.getValue());
    }

    @Test
    public void testDropdown() {
        Dropdown dd = new Dropdown("country",
                new ChoiceOption[]{ new ChoiceOption("US", "United States"), new ChoiceOption("BE", "Belgium") },
                "BE", 20, 200, null);
        String expected = "{'country':[{'type':'dropdown','name':'country',"
                + "'options':[{'value':'US','label':'United States'},{'value':'BE','label':'Belgium'}],"
                + "'value':'BE','height':20,'width':200}]}";
        assertEquals(JsonParser.parseString(expected), dd.getJSON());
    }

    @Test
    public void testComboBox() {
        ComboBox cb = new ComboBox("color",
                new ChoiceOption[]{ new ChoiceOption("Red"), new ChoiceOption("Green") },
                "Magenta", 20, 200, null);
        String expected = "{'color':[{'type':'combobox','name':'color',"
                + "'options':[{'value':'Red'},{'value':'Green'}],"
                + "'value':'Magenta','height':20,'width':200}]}";
        assertEquals(JsonParser.parseString(expected), cb.getJSON());
    }

    @Test
    public void testListBox() {
        ListBox lb = new ListBox("interests",
                new ChoiceOption[]{ new ChoiceOption("music", "Music"), new ChoiceOption("sports", "Sports") },
                new String[]{ "sports" }, true, 80, 200, null);
        String expected = "{'interests':[{'type':'listbox','name':'interests',"
                + "'options':[{'value':'music','label':'Music'},{'value':'sports','label':'Sports'}],"
                + "'values':['sports'],'multiSelect':true,'height':80,'width':200}]}";
        assertEquals(JsonParser.parseString(expected), lb.getJSON());
    }

    @Test
    public void testPushButton() {
        PushButton pb = new PushButton("submit", "Submit form", 24, 120, null);
        String expected = "{'submit':[{'type':'pushbutton','name':'submit',"
                + "'caption':'Submit form','height':24,'width':120}]}";
        assertEquals(JsonParser.parseString(expected), pb.getJSON());
    }

    @Test
    public void testPassword() {
        Password pw = new Password("pw", "s3cret", 20, 200, null);
        String expected = "{'pw':[{'type':'password','name':'pw',"
                + "'value':'s3cret','height':20,'width':200}]}";
        assertEquals(JsonParser.parseString(expected), pw.getJSON());
    }

    @Test
    public void testRadioGroupMerge() {
        ElementCollection data = new ElementCollection("data");
        data.addElement(new RadioButton("radiolist", "List A", "Option A", false));
        data.addElement(new RadioButton("radiolist", "List B", "Option B", true));
        String expected = "{'radiolist':["
                + "{'type':'radio','name':'radiolist','value':'List A','text':'Option A','selected':0},"
                + "{'type':'radio','name':'radiolist','value':'List B','text':'Option B','selected':1}]}";
        assertEquals(JsonParser.parseString(expected), data.getJSON());
    }
}