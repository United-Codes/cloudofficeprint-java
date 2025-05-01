package cloudofficeprint;
import com.cloudofficeprint.RenderElements.Form.Textbox;
import com.cloudofficeprint.RenderElements.Form.RadioButton;
import com.cloudofficeprint.RenderElements.Form.Checkbox;
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
                + "'value':'cc','text':'Credit Card','selected':1}]}";

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
}