package com.geekhub.Lesson03;

import java.io.*;
import java.util.*;

public class Inventory {
    private static final Map<ProductType, List<? super Product>> productsMap = new HashMap<>();

    public Inventory()
    {
        productsMap.put(ProductType.MILK, new ArrayList<Product>());
        productsMap.put(ProductType.JUICE, new ArrayList<Product>());
        productsMap.put(ProductType.BEAR, new ArrayList<Product>());
        productsMap.put(ProductType.BREAD, new ArrayList<Product>());
        productsMap.put(ProductType.CANDY, new ArrayList<Product>());
        productsMap.put(ProductType.TEA, new ArrayList<Product>());
    }

    public boolean addProduct(ProductType productType, Product product) {
        List<? super Product> products = productsMap.get(productType);
        return products.add(product);
    }

    public void showInventory() {
        Iterator<Map.Entry<ProductType, List<? super Product>>> iterator = productsMap.entrySet().iterator();

        boolean x = false;
        float   totalProductCost, totalAllProductCost = 0;
        int     totalQuantityProduct, totalQuantityAll = 0;

        while (iterator.hasNext()) {
            Map.Entry<ProductType, List<? super Product>> pair = iterator.next();
            ProductType key = pair.getKey();
            List value = pair.getValue();
            if (!value.isEmpty()) {
                Iterator<List> iteratorProduct = value.iterator();
                totalProductCost = 0;
                totalQuantityProduct = 0;
                System.out.println("---------------------------------------------------------");
                while (iteratorProduct.hasNext()) {
                    Product text = (Product) iteratorProduct.next();

                    System.out.format("Product type: " + key + ", name: " + text.getName() + ", price: %.2f", text.getPrice());
                    System.out.format(", quantity: " + text.getQuantity() + ". Total cost: %.2f%n", text.getPrice()*text.getQuantity());
                    totalProductCost += text.getPrice()*text.getQuantity();
                    totalQuantityProduct += text.getQuantity();

                    totalQuantityAll += totalQuantityProduct;
                    totalAllProductCost += totalProductCost;
                }
                System.out.format("Product type total cost: %.2f%n", totalProductCost);
            }
        }
        System.out.println("=====================================================");
        System.out.println("All products total cost: " + totalAllProductCost);
    }

    public void help() {
        System.out.println("   showinventory - show all products and parameters");
        System.out.println("   add           - to create a new product");
        System.out.println("   exit or quit  - escape the program");
    }
    public void addNewProduct() {
        String name;
        float price;
        int quantity;
        ProductType readType;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter product type: ");
        while (true) {
            try {
                readType = ProductType.valueOf(reader.readLine().toUpperCase());
                break;
            } catch (Exception e) {
                System.out.println("Please, enter one of the available types:");
                System.out.println(Arrays.toString(ProductType.values()));
            }
        }
        while (true) {
            try {
                System.out.print("Enter product name: ");
                name = reader.readLine();
                System.out.print("Enter product price: ");
                price = Float.parseFloat(reader.readLine());
                System.out.print("Enter product quantity: ");
                quantity = Integer.parseInt(reader.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Incorrect input. Please, try again!");
            }
        }
        addProduct(readType, new Product(name, price, quantity));
        System.out.println("You product is correctly added.");
    }

    public void removeProduct()
    {
    }
}
