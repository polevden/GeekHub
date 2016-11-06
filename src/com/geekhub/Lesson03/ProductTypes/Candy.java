package com.geekhub.Lesson03.ProductTypes;

public class Candy extends Product {
    private String name;
    private double price;
    private int quantity;
    private int vendorCode;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getVendorCode() {
        return vendorCode;
    }

    public Candy(String name) {
        this.name = name;
    }
    public Candy(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Candy(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
