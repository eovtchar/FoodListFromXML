package com.example.lorik.foodlistfromxml;

/**
 * Created by Lorik on 13.05.2015.
 */
public class Food {
    private String name; // название
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Food(String id, String name, String price){

        this.id=id;
        this.name=name;
        this.price=price;
    }






}
