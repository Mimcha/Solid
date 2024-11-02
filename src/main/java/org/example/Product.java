package org.example;


// Класс, представляющий товар
class Product {
    private String name;
    private double price;
    private String manufacturer;

    public Product(String name, double price, String manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return name + " - " + price + " (by " + manufacturer + ")";
    }
}
