package com.geekhub.Lesson03;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        ProductManager productManager = new ProductManager();
        initData(productManager);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! I am you product manager. Enter \"help\" to see commands.");
        while (true) {
            String readString = reader.readLine().toLowerCase();
            if (readString.equals("help")) {
                ProductManager.help();
            } else if (readString.equals("total")) {
                ProductManager.total();
            } else if (readString.equals("total prise")) {
                ProductManager.totalPrise();
            } else if (readString.equals("total quantity")) {
                ProductManager.totalQuantity();
            } else if (readString.equals("add")) {
                productManager.addNewProduct();
            } else if (readString.equals("exit") || readString.equals("quit")) {
                break;
            } else {
                System.out.println("Command not found. Enter \"help\" to see commands.");
            }
        }
    }

    private static void initData(ProductManager productManager) {
        productManager.addProduct(ProductType.MILK, new Product("White Cow", 15.05, 12));
        productManager.addProduct(ProductType.MILK, new Product("President", 25.00, 5));
        productManager.addProduct(ProductType.MILK, new Product("Jack Dilk", 12.99, 9));

        productManager.addProduct(ProductType.JUICE, new Product("Rich", 18.10, 30));
        productManager.addProduct(ProductType.JUICE, new Product("Sadochok", 10.50, 22));
        productManager.addProduct(ProductType.JUICE, new Product("Sandora", 15.40, 13));

        productManager.addProduct(ProductType.BEAR, new Product("Obolon", 5.40, 50));
        productManager.addProduct(ProductType.BEAR, new Product("Tuborg", 8.10, 40));
        productManager.addProduct(ProductType.BEAR, new Product("Ziberth", 7.90, 35));

        productManager.addProduct(ProductType.TEA, new Product("Lipton", 21.10, 100));
        productManager.addProduct(ProductType.TEA, new Product("Karpatskiy", 8.69, 70));
        productManager.addProduct(ProductType.TEA, new Product("Grinfild", 32.99, 50));

        productManager.addProduct(ProductType.CANDY, new Product("Sweet Life", 186.30, 200));
        productManager.addProduct(ProductType.CANDY, new Product("Mars", 90.15, 90));
    }
}
