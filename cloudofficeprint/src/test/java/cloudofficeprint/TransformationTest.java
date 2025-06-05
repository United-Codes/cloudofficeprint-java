package cloudofficeprint;

import com.cloudofficeprint.TransformationFunction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransformationTest {

    @Test
    public void testInitializationWithJsCode() {
        TransformationFunction tf = new TransformationFunction("function() {}", null);
        assertEquals("function() {}", tf.getJsCode());
        assertNull(tf.getFilename());
    }

    @Test
    public void testInitializationWithFilename() {
        TransformationFunction tf = new TransformationFunction(null, "test.js");
        assertNull(tf.getJsCode());
        assertEquals("test.js", tf.getFilename());
    }

    @Test
    public void testInitializationWithBoth() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TransformationFunction("code", "test.js");
        });
        assertTrue(exception.getMessage().contains("Cannot set both jsCode and filename"));
    }

    @Test
    public void testFilenamePathValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TransformationFunction(null, "invalid/path/test.js");
        });
        assertTrue(exception.getMessage().contains("Filename must not contain path separators"));
    }

    @Test
    public void testMutually() {
        TransformationFunction tf = new TransformationFunction("code", null);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            tf.setFilename("new.js");
        });
        assertTrue(exception.getMessage().contains("Cannot set filename when jsCode is already set"));
    }

    @Test
    public void testEmptyInitialization() {
        TransformationFunction tf = new TransformationFunction();
        assertNull(tf.getJsCode());
        assertNull(tf.getFilename());
    }

    @Test
    public void testGetJSONWithJsCode() {
        TransformationFunction tf = new TransformationFunction("function() {}", null);
        assertEquals("function() {}", tf.getJSON().getAsString());
    }

    @Test
    public void testGetJSONWithNull() {
        TransformationFunction tf = new TransformationFunction();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            tf.getJSON();
        });
        assertTrue(exception.getMessage().contains("No transformation defined"));
    }
}