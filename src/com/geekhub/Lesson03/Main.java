package com.geekhub.Lesson03;

import com.geekhub.Lesson03.ProductTypes.*;
import java.io.*;

public class Main {
    private static void initData(ProductManager productManager) {
        productManager.addProduct(ProductType.MILK, new Milk("White Cow", 15.05, 12));
        productManager.addProduct(ProductType.MILK, new Milk("President", 25.00, 5));
        productManager.addProduct(ProductType.MILK, new Milk("Jack Milk", 12.99, 9));

        productManager.addProduct(ProductType.JUICE, new Juice("Rich", 18.10, 30));
        productManager.addProduct(ProductType.JUICE, new Juice("Sadochok", 10.50, 22));
        productManager.addProduct(ProductType.JUICE, new Juice("Sandora", 15.40, 13));

        productManager.addProduct(ProductType.BEAR, new Bear("Obolon", 5.40, 50));
        productManager.addProduct(ProductType.BEAR, new Bear("Tuborg", 8.10, 40));
        productManager.addProduct(ProductType.BEAR, new Bear("Ziberth", 7.90, 35));

        productManager.addProduct(ProductType.TEA, new Tea("Lipton", 21.10, 100));
        productManager.addProduct(ProductType.TEA, new Tea("Karpatskiy", 8.69, 70));
        productManager.addProduct(ProductType.TEA, new Tea("Grinfild", 32.99, 50));

        productManager.addProduct(ProductType.CANDY, new Candy("Sweet Life", 186.30, 200));
        productManager.addProduct(ProductType.CANDY, new Candy("Mars", 90.15, 90));
    }

    public static void main(String[] args) throws Exception{
        ProductManager productManager = new ProductManager();
        initData(productManager);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! I am you product manager. Enter \"help\" to see commands.");
        while (true) {
            String readString = reader.readLine().toLowerCase();
            if (readString.equals("help")) {
                Inventory.help();
            } else if (readString.equals("total")) {
                Inventory.total();
            } else if (readString.equals("total prise")) {
                Inventory.totalPrise();
            } else if (readString.equals("total quantity")) {
                Inventory.totalQuantity();
            } else if (readString.equals("exit") || readString.equals("quit")) {
                break;
            } else {
                System.out.println("Command not found. Enter \"help\" to see commands.");
            }
        }
    }
}
