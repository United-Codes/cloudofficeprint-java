package com.company.Tests;

import com.company.RenderElements.Property;
import com.company.RenderElements.TableCell;
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
}
