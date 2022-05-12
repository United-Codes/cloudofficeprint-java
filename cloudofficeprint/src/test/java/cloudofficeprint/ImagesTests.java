package cloudofficeprint;

import com.cloudofficeprint.RenderElements.Images.ImageBase64;
import com.cloudofficeprint.RenderElements.Images.ImageUrl;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImagesTests {

    @Test
    public void imageBase64() {

        ImageBase64 imageBase64 = new ImageBase64("image1", "base64str");
        imageBase64.setMaxWidth(50);
        imageBase64.setMaxHeight(45);
        imageBase64.setAltText("alt_text");
        imageBase64.setWrapText("wrap_text");
        imageBase64.setRotation(45);
        imageBase64.setTransparency("50%");
        imageBase64.setTargetUrl("url");
        imageBase64.setWidth(30);
        imageBase64.setHeight(25);
        imageBase64.setMaintainAspectRatio(true);

        String correct = "{'image1': 'base64str', 'image1_max_width': 50, 'image1_max_height': 45, 'image1_alt_text': 'alt_text', 'image1_wrap_text': 'wrap_text', 'image1_rotation': 45, 'image1_transparency': '50%', 'image1_url': 'url', 'image1_width': 30, 'image1_height': 25, 'image1_maintain_aspect_ratio': true}";
        // System.out.println(imageBase64.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, imageBase64.getJSON());
    }

    @Test
    public void imageURL() {

        ImageUrl imageUrl = new ImageUrl("image1", "url");
        imageUrl.setMaxWidth(50);
        imageUrl.setMaxHeight(45);
        imageUrl.setAltText("alt_text");
        imageUrl.setWrapText("wrap_text");
        imageUrl.setRotation(45);
        imageUrl.setTransparency("50%");
        imageUrl.setTargetUrl("url");
        imageUrl.setWidth(30);
        imageUrl.setHeight(25);
        imageUrl.setMaintainAspectRatio(false);

        String correct = "{'image1': 'url', 'image1_max_width': 50, 'image1_max_height': 45, 'image1_alt_text': 'alt_text', 'image1_wrap_text': 'wrap_text', 'image1_rotation': 45, 'image1_transparency': '50%', 'image1_url': 'url', 'image1_width': 30, 'image1_height': 25}";
        // System.out.println(imageUrl.getJSON());
        JsonObject jsonCorrect = JsonParser.parseString(correct).getAsJsonObject();
        // System.out.println(jsonCorrect);
        assertEquals(jsonCorrect, imageUrl.getJSON());
    }
}
