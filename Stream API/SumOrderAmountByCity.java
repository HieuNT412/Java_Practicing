import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import models.Order;

public class SumOrderAmountByCity {
    public static Map<String, Double> sumOrderAmountByCity(List<Order> orders) {
        if (orders == null || orders.isEmpty()) return new HashMap<>();
        
        Map<String, Double> result = orders.stream()
                                            .filter(p -> p.getAmount() > 0)
                                            .collect(Collectors.groupingBy(
                                                p -> p.getCity(),
                                                Collectors.summingDouble(a -> a.getAmount())
                                            ));
        return result; 
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("HD01", "Hanoi", 150.0),
            new Order("HD02", "HCM", 200.0),
            new Order("HD03", "Hanoi", 50.0),
            new Order("HD04", "Danang", 100.0),
            new Order("HD05", "HCM", -50.0) // Đơn hàng lỗi, bị loại bỏ
        );

        Map<String, Double> result = sumOrderAmountByCity(orders);
        
        // Kết quả mong đợi: {Danang=100.0, HCM=200.0, Hanoi=200.0}
        System.out.println("Tổng doanh thu theo thành phố: " + result);
    }
}
