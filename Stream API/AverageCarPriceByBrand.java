import models.Car;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageCarPriceByBrand {
    public static Map<String, Double> averagePriceByBrand(List<Car> cars) {
        if (cars == null || cars.isEmpty()) return new HashMap<>();

        Map<String, Double> result = cars.stream()
                .filter(p -> p.getPrice() > 500)
                .collect(Collectors.groupingBy(
                        b -> b.getBrand(),
                        Collectors.averagingInt(cp -> cp.getPrice())
                ));
        return result;
    }

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Vios", "Toyota", 600),
                new Car("Civic", "Honda", 800),
                new Car("Wigo", "Toyota", 400), // Bị loại vì giá <= 500
                new Car("Camry", "Toyota", 1000),
                new Car("City", "Honda", 600)
        );

        Map<String, Double> result = averagePriceByBrand(cars);

        // Kết quả mong đợi: {Honda=700.0, Toyota=800.0}
        // (Toyota còn Vios 600 và Camry 1000 -> Trung bình là 800.0)
        System.out.println("Giá trung bình theo hãng: " + result);
    }
}
