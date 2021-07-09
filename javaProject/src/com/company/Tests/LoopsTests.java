package com.company.Tests;

import com.company.RenderElements.ElementCollection;
import com.company.RenderElements.Images.ImageBase64;
import com.company.RenderElements.Loops.Loop;
import com.company.RenderElements.Loops.SheetLoop;
import com.company.RenderElements.PDF.PDFFormData;
import com.company.RenderElements.Property;
import com.company.RenderElements.RenderElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Hashtable;

public class LoopsTests {

    public void forEach(){
        ElementCollection element1 = new ElementCollection("element1");
        Hashtable<String, String> orderInfo1 = new Hashtable<String, String>();
        orderInfo1.put("a","1");
        orderInfo1.put("b","2");
        orderInfo1.put("c","3");
        element1.addFromDict(orderInfo1);

        ElementCollection element2 = new ElementCollection("element1");
        Hashtable<String, String> orderInfo2 = new Hashtable<String, String>();
        orderInfo2.put("a","4");
        orderInfo2.put("b","5");
        orderInfo2.put("c","6");
        element2.addFromDict(orderInfo2);

        Loop loop = new Loop("loop_name", new ElementCollection[]{element1, element2});

        String correct= "{'loop_name': [{'a': '1', 'b': '2', 'c': '3'}, {'a': '4', 'b': '5', 'c': '6'}]}";
        //System.out.println(loop.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,loop.getJSON());
    }

    public void testForEachSheet(){

        ElementCollection element1 = new ElementCollection("element1");

        // Customer information
        Hashtable<String, String> customerInfo = new Hashtable<String, String>();
        customerInfo.put("sheet_name","John Dulles");
        customerInfo.put("sheet_dynamic_print_area","true");
        customerInfo.put("cust_first_name","John");
        customerInfo.put("cust_last_name","Dulles");
        customerInfo.put("cust_city","Sterling");
        element1.addFromDict(customerInfo);

        //Order 1_1
        ElementCollection order1_1 = new ElementCollection("order1");
        Hashtable<String, String> orderInfo = new Hashtable<String, String>();
        orderInfo.put("order_name","Order 1");
        orderInfo.put("order_total","2380");
        order1_1.addFromDict(orderInfo);

        //Product 1 for order 1
        ElementCollection product1_1 = new ElementCollection("product1");
        Hashtable<String, String> product1_1Info = new Hashtable<String, String>();
        product1_1Info.put("product_name","Business Shirt");
        product1_1Info.put("quantity","3");
        product1_1Info.put("unit_price","50");
        product1_1.addFromDict(product1_1Info);

        //Product 2 for order 1
        ElementCollection product1_2 = new ElementCollection("product2");
        Hashtable<String, String> product1_2Info = new Hashtable<String, String>();
        product1_2Info.put("product_name","Trousers");
        product1_2Info.put("quantity","3");
        product1_2Info.put("unit_price","80");
        product1_2.addFromDict(product1_2Info);

        //Product 3 for order 1
        ElementCollection product1_3 = new ElementCollection("product3");
        Hashtable<String, String> product1_3Info = new Hashtable<String, String>();
        product1_3Info.put("product_name","Jacket");
        product1_3Info.put("quantity","3");
        product1_3Info.put("unit_price","150");
        product1_3.addFromDict(product1_3Info);

        //Add products to order 1
        Loop products1 = new Loop("product", new ElementCollection[]{product1_1, product1_2, product1_3});
        order1_1.addElement(products1);

        //Add order 1 to element1.
        Loop order1 = new Loop("orders", new ElementCollection[]{order1_1});
        element1.addElement(order1);


        ElementCollection element2 = new ElementCollection("element2");

        // Customer information
        Hashtable<String, String> customerInfo2 = new Hashtable<String, String>();
        customerInfo2.put("sheet_name","William Hartsfield");
        customerInfo2.put("cust_first_name","William");
        customerInfo2.put("cust_last_name","Hartsfield");
        customerInfo2.put("cust_city","Atlanta");
        element2.addFromDict(customerInfo2);

        //Order 1_2
        ElementCollection order1_2 = new ElementCollection("order2");
        Hashtable<String, String> order1_2Info = new Hashtable<String, String>();
        order1_2Info.put("order_name","Order 1");
        order1_2Info.put("order_total","1640");
        order1_2.addFromDict(order1_2Info);

        //Product 1 for order 1_2
        ElementCollection product1_2_1 = new ElementCollection("product1");
        Hashtable<String, String> product1_2_1Info = new Hashtable<String, String>();
        product1_2_1Info.put("product_name","Blouse");
        product1_2_1Info.put("quantity","4");
        product1_2_1Info.put("unit_price","60");
        product1_2_1.addFromDict(product1_2_1Info);

        //Product 2 for order 1_2
        ElementCollection product1_2_2 = new ElementCollection("product2");
        Hashtable<String, String> product1_2_2Info = new Hashtable<String, String>();
        product1_2_2Info.put("product_name","Skirt");
        product1_2_2Info.put("quantity","4");
        product1_2_2Info.put("unit_price","80");
        product1_2_2.addFromDict(product1_2_2Info);

        //Add products to order 1_2
        Loop products1_2 = new Loop("product", new ElementCollection[]{product1_2_1,product1_2_2});
        order1_2.addElement(products1_2);

        //Order 2_2
        ElementCollection order2_2 = new ElementCollection("order3");
        Hashtable<String, String> order2_2Info = new Hashtable<String, String>();
        order2_2Info.put("order_name","Order 2");
        order2_2Info.put("order_total","730");
        order2_2.addFromDict(order2_2Info);

        //Product 1 for order 2_2
        ElementCollection product2_2_1 = new ElementCollection("product1");
        Hashtable<String, String> product2_2_1Info = new Hashtable<String, String>();
        product2_2_1Info.put("product_name","Blouse");
        product2_2_1Info.put("quantity","4");
        product2_2_1Info.put("unit_price","60");
        product2_2_1.addFromDict(product2_2_1Info);

        //Add products to order 2_2
        Loop products2 = new Loop("product", new ElementCollection[]{product2_2_1});
        order2_2.addElement(products2);

        //Add orders to element2
        Loop orders2 = new Loop("orders", new ElementCollection[]{order1_2,order2_2});
        element2.addElement(orders2);

        SheetLoop sheetLoop = new SheetLoop("customers", new ElementCollection[]{element1, element2});

        String correct= "{'customers': [{'sheet_name': 'John Dulles', 'sheet_dynamic_print_area': 'true', 'cust_first_name': 'John', 'cust_last_name': 'Dulles', 'cust_city': 'Sterling', 'orders': [{'order_total': '2380', 'order_name': 'Order 1', 'product': [{'product_name': 'Business Shirt', 'quantity': '3', 'unit_price': '50'}, {'product_name': 'Trousers', 'quantity': '3', 'unit_price': '80'}, {'product_name': 'Jacket', 'quantity': '3', 'unit_price': '150'}]}]}, {'sheet_name': 'William Hartsfield', 'cust_first_name': 'William', 'cust_last_name': 'Hartsfield', 'cust_city': 'Atlanta', 'orders': [{'order_total': '1640', 'order_name': 'Order 1', 'product': [{'product_name': 'Blouse', 'quantity': '4', 'unit_price': '60'}, {'product_name': 'Skirt', 'quantity': '4', 'unit_price': '80'}]}, {'order_total': '730', 'order_name': 'Order 2', 'product': [{'product_name': 'Blouse', 'quantity': '4', 'unit_price': '60'}]}]}]}";
        //System.out.println(sheetLoop.getJSON());
        JsonObject jsonCorrect = new JsonParser().parse(correct).getAsJsonObject();
        //System.out.println(jsonCorrect);
        Assert.assertEquals(jsonCorrect,sheetLoop.getJSON());
    }
}
