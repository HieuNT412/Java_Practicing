package models;

public class Package {
    private String id;
    private String type;
    private double weight;

    public Package(String id, String type, double weight) {
        this.id = id;
        this.type = type;
        this.weight = weight;
    }
    public String getType() { return type; }
    public double getWeight() { return weight; }
}
