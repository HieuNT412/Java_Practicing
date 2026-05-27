import models.Company;
import models.Products;
import models.Store;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountPremiumProductsReport {
    public static Map<String, Map<String, Long>> countPremiumProductsReport(Company company) {
        if (company == null || company.getStores() == null) return new HashMap<>();

        return company.getStores().stream() // Stream<Store>
                .flatMap(store -> store.getProductList().stream()
                        // Lọc sản phẩm đắt ngay từ trong Store để giảm tải dữ liệu
                        .filter(product -> product.getPrice() > 10.0)
                        // 🔑 BƯỚC CHỐT: Biến đổi mỗi Product thành một cặp (Country, Product)
                        .map(product -> new AbstractMap.SimpleEntry<>(store.getCountry(), product))
                ) // Sau flatMap, ta có: Stream<SimpleEntry<String, Products>>

                // Bây giờ ta tiến hành gom nhóm 2 tầng dựa trên cặp Entry này
                .collect(Collectors.groupingBy(
                        AbstractMap.SimpleEntry::getKey, // Tầng 1: Gom theo Quốc gia (Key của Entry)
                        Collectors.groupingBy(
                                entry -> entry.getValue().getCategory(), // Tầng 2: Gom theo Danh mục của Sản phẩm (Value của Entry)
                                Collectors.counting() // Tầng cuối: Đếm số lượng
                        )
                ));
    }

    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu
        Products phone = new Products("iPhone", "Electronics", 1200.0);
        Products case1 = new Products("Case", "Electronics", 5.0); // Bị loại vì <= 10
        Products shirt = new Products("T-Shirt", "Fashion", 25.0);
        Products shoes = new Products("Sneaker", "Fashion", 80.0);

        Store storeVN = new Store("Vietnam", Arrays.asList(phone, case1));
        Store storeUS = new Store("USA", Arrays.asList(shirt, shoes));

        Company company = new Company(Arrays.asList(storeVN, storeUS));

        Map<String, Map<String, Long>> report = countPremiumProductsReport(company);

        // Kết quả mong đợi:
        // {Vietnam={Electronics=1}, USA={Fashion=2}}
        System.out.println("Báo cáo toàn cầu: " + report);
    }
}
