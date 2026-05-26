package models;

public class Car {
    private String model; // Tên dòng xe
    private String brand; // Thương hiệu (Ví dụ: "Toyota", "Honda")
    private int price;    // Giá tiền (triệu VND)

    public Car(String model, String brand, int price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() { return brand; }
    public int getPrice() { return price; }
}
