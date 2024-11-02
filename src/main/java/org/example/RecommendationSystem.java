package org.example;

import java.util.ArrayList;
import java.util.List;

class RecommendationSystem {
    private RatingSystem ratingSystem;

    public RecommendationSystem(RatingSystem ratingSystem) {
        this.ratingSystem = ratingSystem;
    }

    public List<String> recommendProducts() {
        List<String> recommendations = new ArrayList<>();
        for (String product : ratingSystem.getAllRatings().keySet()) {
            if (ratingSystem.getRating(product) != null && ratingSystem.getRating(product) >= 4.0) {
                recommendations.add(product);
            }
        }
        return recommendations;
    }


}