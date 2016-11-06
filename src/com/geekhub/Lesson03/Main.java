package com.geekhub.Lesson03;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Inventory inventory = new Inventory();

        inventory.addProduct(ProductType.MILK, new Product("White Cow", 15.05f, 12));
        inventory.addProduct(ProductType.MILK, new Product("President", 25.00f, 5));
        inventory.addProduct(ProductType.MILK, new Product("Jack Dilk", 12.99f, 9));

        inventory.addProduct(ProductType.JUICE, new Product("Rich", 18.10f, 30));
        inventory.addProduct(ProductType.JUICE, new Product("Sadochok", 10.50f, 22));
        inventory.addProduct(ProductType.JUICE, new Product("Sandora", 15.40f, 13));

        inventory.addProduct(ProductType.BEAR, new Product("Obolon", 5.40f, 50));
        inventory.addProduct(ProductType.BEAR, new Product("Tuborg", 8.10f, 40));
        inventory.addProduct(ProductType.BEAR, new Product("Ziberth", 7.90f, 35));

        inventory.addProduct(ProductType.TEA, new Product("Lipton", 21.10f, 100));
        inventory.addProduct(ProductType.TEA, new Product("Karpatskiy", 8.69f, 70));
        inventory.addProduct(ProductType.TEA, new Product("Grinfild", 32.99f, 50));

        inventory.addProduct(ProductType.CANDY, new Product("Sweet Life", 186.30f, 200));
        inventory.addProduct(ProductType.CANDY, new Product("Mars", 90.15f, 90));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! I am you product manager. Enter \"help\" to see commands.");
        while (true) {
            String readString = reader.readLine().toLowerCase();
            if (readString.equals("help")) {
                inventory.help();
            } else if (readString.equals("showinventory")) {
                inventory.showInventory();
            } else if (readString.equals("addproduct")) {
                inventory.addNewProduct();
            } else if (readString.equals("exit") || readString.equals("quit")) {
                break;
            } else {
                System.out.println("Command not found. Enter \"help\" to see commands.");
            }
        }
    }
}

