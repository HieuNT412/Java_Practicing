import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import models.*;

public class GroupExpensiveProductsByCategory {
    public static Map<String, List<Products>> groupExpensiveProductsByCategory(List<Products> products) {
        if (products == null || products.isEmpty()) return new HashMap<>();

        
        Map<String, List<Products>> result = products.stream().filter(p -> p.getPrice() > 10.0)
                                                                .collect(Collectors.groupingBy(p -> p.getCategory()));
        return result; 
    }

    public static void main(String[] args) {
        // Tạo danh sách sản phẩm mẫu
        List<Products> products = Arrays.asList(
            new Products("Laptop", "Electronics", 999.9),
            new Products("Chuột máy tính", "Electronics", 8.5),
            new Products("Áo thun", "Clothing", 15.0),
            new Products("Mũ lưỡi trai", "Clothing", 9.9),
            new Products("Điện thoại", "Electronics", 499.0)
        );

        // Gọi hàm xử lý
        Map<String, List<Products>> result = groupExpensiveProductsByCategory(products);
        
        // Kết quả mong đợi sau khi bạn hoàn thành hàm:
        // {Clothing=[Áo thun ($15.0)], Electronics=[Laptop ($999.9), Điện thoại ($499.0)]}
        // (Chuột và Mũ bị loại vì giá không lớn hơn 10.0)
        System.out.println("Kết quả gom nhóm: " + result);
    }
}
