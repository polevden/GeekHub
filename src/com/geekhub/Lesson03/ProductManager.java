package com.geekhub.Lesson03;

import com.geekhub.Lesson03.ProductTypes.*;

import java.util.*;

public class ProductManager {
    private static final Map<ProductType, List<? super Product>> productsMap = new HashMap<>();
    static {
        ProductManager.productsMap.put(ProductType.MILK, new ArrayList<Product>());
        ProductManager.productsMap.put(ProductType.JUICE, new ArrayList<Product>());
        ProductManager.productsMap.put(ProductType.BEAR, new ArrayList<Product>());
        ProductManager.productsMap.put(ProductType.BREAD, new ArrayList<Product>());
        ProductManager.productsMap.put(ProductType.CANDY, new ArrayList<Product>());
        ProductManager.productsMap.put(ProductType.TEA, new ArrayList<Product>());
    }

    public boolean addProduct(ProductType productType, Product product) {
        List<? super Product> products = productsMap.get(productType);
        return products.add(product);
    }

    public static void help() {
        System.out.println("help////");
    }

    private static Iterator<Map.Entry<ProductType, List<? super Product>>> iterator = productsMap.entrySet().iterator();

    public static void total() {
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
        System.out.println("All Products total cost: " + totalPriseAll);
        System.out.println("All Products total quantity:          " + totalQuantityAll);
    }

    public static void totalPrise() {
        System.out.println("totalprise///");
    }

    public static void totalQuantity() {
        System.out.println("totalquantity////");
    }


}

