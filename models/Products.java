package models;

public class Products {

    String name;     // Tên sản phẩm
    String category; // Danh mục (ví dụ: "Electronics", "Clothing")
    double price;    // Giá tiền

    public Products(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Các hàm getter tương ứng
    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
