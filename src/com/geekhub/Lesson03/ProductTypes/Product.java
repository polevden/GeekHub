package com.geekhub.Lesson03.ProductTypes;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private int vendorCode;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getVendorCode() {
        return vendorCode;
    }
}