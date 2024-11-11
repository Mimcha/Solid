package org.example;

import java.util.HashMap;
import java.util.Map;


public class RatingSystem {
    // Хранит рейтинги продуктов
    private Map<String, Double> ratings;

    public RatingSystem() {
        ratings = new HashMap<>();
    }

    // Метод для добавления или обновления рейтинга продукта
    public void addRating(String productName, double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Рейтинг должен быть от 0 до 5.");
        }
        ratings.put(productName, rating);
    }

    // Метод для получения рейтинга продукта
    public Double getRating(String productName) {
        return ratings.get(productName);
    }

    // Метод для отображения всех рейтингов
    public void displayRatings() {
        if (ratings.isEmpty()) {
            System.out.println("No ratings available.");
        } else {
            for (Map.Entry<String, Double> entry : ratings.entrySet()) {
                System.out.println(entry.getKey() + " - Рейтинг: " + entry.getValue());
            }
        }
    }

    // Метод для получения всех рейтингов (может быть полезен для рекомендаций)
    public Map<String, Double> getAllRatings() {
        return ratings;
    }
}