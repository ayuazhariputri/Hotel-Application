package com.example.hotelapp;

public class Hotel {
    private int id;
    private String name, shortDesc, price;
    private int image;

    public Hotel(int id, String name, String shortDesc, String price, int image) {
        this.id = id;
        this.name = name;
        this.shortDesc = shortDesc;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
