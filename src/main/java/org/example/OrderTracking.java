package org.example;

import java.util.HashMap;
import java.util.Map;

class OrderTracking {
    private Map<Integer, String> orderStatuses;

    public OrderTracking() {
        orderStatuses = new HashMap<>();
    }

    public void trackOrder(int orderId) {
        String status = orderStatuses.getOrDefault(orderId, "Заказ не найден.");
        System.out.println("ID заказа: " + orderId + " - Статус: " + status);
    }

    public void updateOrderStatus(int orderId, String status) {
        orderStatuses.put(orderId, status);
    }
}