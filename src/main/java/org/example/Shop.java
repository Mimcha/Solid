package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Shop {
    private static final int EXIT_OPTION = 8;
    private static Scanner scanner = new Scanner(System.in);
    static ProductCatalog catalog = new ProductCatalog();
    private static Cart cart = new Cart();
    private static OrderTracking orderTracking = new OrderTracking();
    private static RatingSystem ratingSystem = new RatingSystem();
    private static RecommendationSystem recommendationSystem = new RecommendationSystem(ratingSystem);
    private static OrderManager orderManager = new OrderManager();

    public static void main(String[] args) {


        while (true) {
            System.out.println("1. Товары");
            System.out.println("2. Фильтрация товаров");
            System.out.println("3. Продуктовая корзина");
            System.out.println("4. Трекинг заказа");
            System.out.println("5. Возврат заказа, повтороение заказа");
            System.out.println("6. Система рейтинга");
            System.out.println("7. Рекомендации");
            System.out.println("8. Выход");
            System.out.print("Выбери опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    catalog.showProducts();
                    break;
                case 2:
                    filterProduct();
                    break;
                case 3:
                    workingWithCart();
                    break;
                case 4:
                    System.out.println("Введите трэк ID : ");
                    int orderId = scanner.nextInt();
                    orderTracking.trackOrder(orderId);
                    break;
                case 5:
                    //Возврат заказа, повтороение заказа
                    refundRepeatOrder();
                    break;
                case 6:
                    //Система рейтинга
                    System.out.print("Система рейтинга: ");
                    ratingSystem();
                    break;
                case 7:
                    //Рекомендации
                    System.out.print("Рекомендации: ");
                    catalog.displayRecommendedProducts();
                    break;
                case EXIT_OPTION:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверная опция.");
            }
        }
    }

    private static void ratingSystem() {

        // Отображаем продукты с рейтингами
        System.out.println("Product Catalog:");
        catalog.displayProductsWithRatings();

    }

    private static void refundRepeatOrder() {
        // Создание заказа
        List<String> items = new ArrayList<>();
        items.add("Позиция 1");
        items.add("Позиция 2");
        Order order1 = new Order("123", items, 900);
        orderManager.addOrder(order1);

        System.out.println("Работа с заказом: ");
        System.out.println("1. Печать всех заказов: ");
        System.out.println("2. Повтор заказа: ");
        System.out.println("3. Возврат заказа: ");
        while (true) {
            int workOrder = scanner.nextInt();
            scanner.nextLine();
            switch (workOrder) {
                case 1:
                    // Печать всех заказов
                    orderManager.printOrders();
                    break;
                case 2:
                    // Повторение заказа
                    Order newOrder = orderManager.repeatOrder("123");
                    if (newOrder != null) {
                        System.out.println("Создан новый заказ: " + newOrder);
                    }
                    break;
                case 3:
                    // Возврат заказа
                    orderManager.returnOrder("123");
                    break;
                default:
                    System.out.println("Неверный вариант. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void filterProduct() {
        System.out.print("Поиск: ");
        String keyword = scanner.nextLine();
        List<Product> filteredProducts = catalog.filterByKeyword(keyword);
        for (Product product : filteredProducts) {
            System.out.println(product);
        }
    }

    private static Product filterProduct(String keyword) {
        List<Product> filteredProducts = catalog.filterByKeyword(keyword);
        for (Product product : filteredProducts) {
            System.out.println(product);
            return product;
        }
        return null;
    }

    private static void workingWithCart() {
        while (true) {
            System.out.println("Корзина:");
            System.out.println("1. Добавить товар:");
            System.out.println("2. Удалить товар:");
            System.out.println("3. Показать товар в корзине:");
            System.out.println("4. Выход в предыдущее меню.");
            int workCart = scanner.nextInt();
            scanner.nextLine();
            switch (workCart) {
                case 1:
                    handleAddProduct();
                    break;
                case 2:
                    handleRemoveProduct();
                    break;
                case 3:
                    cart.showCart();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Неверный вариант. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void handleAddProduct() {
        System.out.print("Поиск товара для добавления: ");
        String filterProduct = scanner.nextLine();
        Product productToAdd = filterProduct(filterProduct);
        if (productToAdd != null) {
            cart.addProduct(productToAdd);
        } else {
            System.out.println("Товар не найден.");
        }
    }

    private static void handleRemoveProduct() {
        System.out.print("Поиск товара для удаления: ");
        String filterProduct = scanner.nextLine();
        Product productToRemove = filterProduct(filterProduct);
        if (productToRemove != null) {
            cart.removeProduct(productToRemove);
        } else {
            System.out.println("Товар не найден.");
        }
    }

}


