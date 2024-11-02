package org.example;
import java.util.Scanner;
import java.util.List;
public class Shop {
    private static final int EXIT_OPTION = 8;
    private static Scanner scanner = new Scanner(System.in);
    private static ProductCatalog catalog = new ProductCatalog();
    private static Cart cart = new Cart();
    private static OrderTracking orderTracking = new OrderTracking();
    private static RatingSystem ratingSystem = new RatingSystem();
    private static RecommendationSystem recommendationSystem = new RecommendationSystem(ratingSystem);

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
                case 1:catalog.showProducts();
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
                    System.out.print("Введите трэк ID : ");
                    returnProduct(scanner);
                    break;
                case 6:
                    System.out.print("Система рейтинга: ");
                    break;
                case 7:
                    System.out.print("Рекомендации: ");
                    break;
                case EXIT_OPTION:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
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
    private static void returnProduct(Scanner scanner) {
        System.out.println("оиск товара для возврата:");
        String productName = scanner.nextLine();
        Product productToReturn = filterProduct(productName);
        // Здесь вы можете добавить логику для поиска продукта в корзине

        if (productToReturn != null) {
            //cart.returnProduct(productToReturn);
            // Логика добавления продукта обратно в каталог (если необходимо)
            //catalog.addProduct(productToReturn); // Добавьте метод addProduct в ProductCatalog
        } else {
            System.out.println("Product not found in cart.");
        }
    }
}
}

