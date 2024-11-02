package org.example;
import java.util.List;
import java.util.ArrayList;
public class ProductCatalog {
    private List<Product> products = new ArrayList<>();

    public ProductCatalog() {
        products.add(new Product("Laptop", 800, "Dell"));
        products.add(new Product("Phone", 600, "Apple"));
        products.add(new Product("Tablet", 300, "Samsung"));
        products.add(new Product("Monitor", 200, "Dell"));
        products.add(new Product("Smartwatch", 250, "Apple"));
        products.add(new Product("Gaming Laptop", 1200, "HP"));
    }

    public void showProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
    // Метод для фильтрации по ключевым словам
    public List<Product> filterByKeyword(String keyword) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.toString().toLowerCase().contains(keyword.toLowerCase())) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public List<Product> filterByManufacturer(String manufacturer) {
        List<Product> filtered = new ArrayList<>();
        for (Product product : products) {
            if (product.toString().equalsIgnoreCase(manufacturer)) {
                filtered.add(product);
            }
        }
        return filtered;
    }
}
