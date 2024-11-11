package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<String> items;
    private double totalAmount;
    private boolean isReturned;

    public Order(String orderId, List<String> items, double totalAmount) {
        this.orderId = orderId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.isReturned = false;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void returnOrder() {
        this.isReturned = true;
    }

    @Override
    public String toString() {
        return "ID заказа: " + orderId + ", Позиция : " + items + ", Общая сумма: " + totalAmount + ", Возврат: " + isReturned;
    }
}

class OrderManager {
    private List<Order> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public void returnOrder(String orderId) {
        Order order = getOrder(orderId);
        if (order != null && !order.isReturned()) {
            order.returnOrder();
            System.out.println("Заказ " + orderId + " возвращен.");
        } else {
            System.out.println("Закза не найден.");
        }
    }

    public Order repeatOrder(String orderId) {
        Order originalOrder = getOrder(orderId);
        if (originalOrder != null && !originalOrder.isReturned()) {
            Order newOrder = new Order("Новый-" + orderId, new ArrayList<>(originalOrder.getItems()), originalOrder.getTotalAmount());
            addOrder(newOrder);
            return newOrder;
        } else {
            System.out.println("Заказ не найден");
            return null;
        }
    }

    public void printOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
