package com.geekhub.Lesson03;

import java.io.*;
import java.util.*;

public class Main {
    private static final Map<ProductType, List<? super Product>> productsMap = new HashMap<>();
    static {
        productsMap.put(ProductType.MILK, new ArrayList<Product>());
        productsMap.put(ProductType.JUICE, new ArrayList<Product>());
        productsMap.put(ProductType.BEAR, new ArrayList<Product>());
        productsMap.put(ProductType.BREAD, new ArrayList<Product>());
        productsMap.put(ProductType.CANDY, new ArrayList<Product>());
        productsMap.put(ProductType.TEA, new ArrayList<Product>());
    }

    public static class ProductManager {

        public boolean addProduct(ProductType productType, Product product) {
            List<? super Product> products = productsMap.get(productType);
            return products.add(product);
        }
    }

    public static void main(String[] args) throws Exception{
        ProductManager productManager = new ProductManager();
        initData(productManager);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! I am you product manager. Enter \"help\" to see commands.");
        while (true) {
            String readString = reader.readLine().toLowerCase();
            if (readString.equals("help")) {
                Main.help();
            } else if (readString.equals("total")) {
                Main.total();
            } else if (readString.equals("total prise")) {
                Main.totalPrise();
            } else if (readString.equals("total quantity")) {
                Main.totalQuantity();
            } else if (readString.equals("add")) {
                Main.addNewProduct(productManager);
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



    public static void help() {
            System.out.println("help////");
        }


    public static void total() {
        Iterator<Map.Entry<ProductType, List<? super Product>>> iterator = productsMap.entrySet().iterator();
        boolean x = false;
        double  totalPriseProduct, totalPriseAll = 0;
        int     totalQuantityProduct, totalQuantityAll = 0;

        while (iterator.hasNext()) {
            Map.Entry<ProductType, List<? super Product>> pair = iterator.next();
            ProductType key = pair.getKey();
            List value = pair.getValue();
            if (!value.isEmpty()) {
                if (!x) {
                    System.out.println("Product:    Name     | Prize | Quantity");
                    x = true;
                }
                System.out.println("----------------------------------------------------");
                System.out.println(key + ":");
                Iterator<List> iteratorProduct = value.iterator();
                totalPriseProduct = 0;
                totalQuantityProduct = 0;
                while (iteratorProduct.hasNext()) {
                    Product text = (Product) iteratorProduct.next();

                    System.out.print("          \"" + text.getName() + "\"");
                    for (int i = 0; i < 12 - text.getName().length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.println(text.getPrice() + "     " + text.getQuantity());
                    totalPriseProduct += text.getPrice();
                    totalQuantityProduct += text.getQuantity();
                    totalPriseAll += totalPriseProduct;
                    totalQuantityAll += totalQuantityAll;
                }
                System.out.println("        All " + key + " cost: " + totalPriseProduct);
                System.out.println("        All " + key + " quantity:        " + totalQuantityProduct);
            }
        }
        System.out.println("================================================");
        System.out.println("All Products total cost: " + totalPriseAll);
        System.out.println("All Products total quantity:        " + totalQuantityAll);
    }

    public static void totalPrise() {
        System.out.println("totalprise///");
    }

    public static void totalQuantity() {
        System.out.println("totalquantity////");
    }

    public static void addNewProduct(ProductManager productManager) {
        String name;
        double price;
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
                price = Double.parseDouble(reader.readLine());
                System.out.print("Enter product quantity: ");
                quantity = Integer.parseInt(reader.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Incorrect input. Please, try again!");
            }
        }
        productManager.addProduct(readType, new Product(name, price, quantity));
        System.out.println("You product is correctly added.");
    }

}

