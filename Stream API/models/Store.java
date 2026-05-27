package models;

import java.util.List;

public class Store {
    private String country; // Quốc gia: "Vietnam", "USA", v.v.
    private List<Products> productList;

    public Store(String country, List<Products> productList) {
        this.country = country;
        this.productList = productList;
    }
    public String getCountry() { return country; }
    public List<Products> getProductList() { return productList; }
}
