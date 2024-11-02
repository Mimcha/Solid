package org.example;
import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void showCart() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}