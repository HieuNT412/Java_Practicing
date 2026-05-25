package models;

public class Order {

    private String id;
    private String city;
    private double amount;

    public Order(String id, String city, double amount) {
        this.id = id;
        this.city = city;
        this.amount = amount;
    }

    public String getCity() {
        return city;
    }

    public double getAmount() {
        return amount;
    }
}
