package com.company;

public class Resource {

    String data;
    String filetype;

    public  Resource(){
        data = "false";
        filetype = "false";
    }
    public Resource(String data, String filetype){
        data = data;
        filetype = filetype;
    }
    public static void main(String test) {
        Resource myObj = new Resource(); // Create an object of class Main (This will call the constructor)
        System.out.println(myObj.data); // Print the value of x
    }
}
