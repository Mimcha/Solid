package org.example;

import java.util.HashMap;
import java.util.Map;

class OrderTracking {
    private Map<Integer, String> orderStatuses;

    public OrderTracking() {
        orderStatuses = new HashMap<>();
    }

    public void trackOrder(int orderId) {
        String status = orderStatuses.getOrDefault(orderId, "Order not found.");
        System.out.println("Order ID: " + orderId + " - Status: " + status);
    }

    public void updateOrderStatus(int orderId, String status) {
        orderStatuses.put(orderId, status);
    }
}