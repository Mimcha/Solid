package org.example;
import java.util.List;
import java.util.ArrayList;


public class ProductCatalog {
    private List<Product> products = new ArrayList<>();
    private RatingSystem ratingSystem;
    private RecommendationSystem recommendationSystem;

    public ProductCatalog() {
        products.add(new Product("Laptop", 800, "Dell"));
        products.add(new Product("Phone", 600, "Apple"));
        products.add(new Product("Tablet", 300, "Samsung"));
        products.add(new Product("Monitor", 200, "Dell"));
        products.add(new Product("Smartwatch", 250, "Apple"));
        products.add(new Product("Gaming Laptop", 1200, "HP"));
        // Инициализация системы рейтингов
        ratingSystem = new RatingSystem();
        ratingSystem.addRating("Laptop", 4.5);
        ratingSystem.addRating("Phone", 4.7);
        ratingSystem.addRating("Tablet", 3.8);
        ratingSystem.addRating("Monitor", 4.8);
        recommendationSystem = new RecommendationSystem(ratingSystem);
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

    // Метод для добавления рейтинга к продукту
    public void addRating(String productName, double rating) {
        ratingSystem.addRating(productName, rating);
    }

    // Метод для получения рейтинга продукта
    public Double getRating(String productName) {
        return ratingSystem.getRating(productName);
    }

    // Метод для отображения всех продуктов с их рейтингами
    public void displayProductsWithRatings() {
        for (Product product : products) {
            String productName = product.getName();
            Double rating = getRating(productName);
            System.out.println(productName + " - Цена: $" + product.getPrice() + ", Бренд: " + product.getManufacturer() +
                    (rating != null ? ", Рейтинг: " + rating : ""));
        }
    }
    // Метод для отображения рекомендуемых продуктов
    public void displayRecommendedProducts() {
        List<String> recommendations = recommendationSystem.recommendProducts();
        System.out.println("\nРекомендуемый продукт, с рейтингом более 4.0):");
        if (recommendations.isEmpty()) {
            System.out.println("Нет рекомендация");
        } else {
            for (String productName : recommendations) {
                System.out.println(productName);
            }
        }
    }
}
