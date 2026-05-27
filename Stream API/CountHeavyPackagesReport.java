import models.Hub;
import models.LogisticsNetwork;
import models.Package;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountHeavyPackagesReport {
    public static Map<String, Map<String, Long>> countHeavyPackagesReport(LogisticsNetwork network) {
        if (network == null || network.getHubs() == null) return new HashMap<>();

        Map<String, Map<String, Long>> result = network.getHubs().stream()
                .flatMap(pl -> pl.getPackageList().stream()
                        .filter(w -> w.getWeight() > 5.0)
                        .map(w -> new AbstractMap.SimpleEntry<>(pl.getRegion(), w) {}))
                .collect(
                        Collectors.groupingBy(
                                entry -> entry.getKey(),
                                Collectors.groupingBy(
                                    entry -> entry.getValue().getType(),
                                        Collectors.counting()
                                )
                        )
                );
        return result;
    }

    public static void main(String[] args) {
        // 1. Tạo các kiện hàng mẫu
        Package p1 = new Package("PKG01", "Electronics", 12.5);
        Package p2 = new Package("PKG02", "Electronics", 2.0);  // Bị loại vì <= 5.0
        Package p3 = new Package("PKG03", "Food", 8.0);
        Package p4 = new Package("PKG04", "Food", 6.5);

        // 2. Tạo các trung tâm điều phối
        Hub hubNorth = new Hub("North", Arrays.asList(p1, p2));
        Hub hubSouth = new Hub("South", Arrays.asList(p3, p4));

        // 3. Tạo mạng lưới logistics
        LogisticsNetwork network = new LogisticsNetwork(Arrays.asList(hubNorth, hubSouth));

        // 4. Chạy hàm test
        Map<String, Map<String, Long>> report = countHeavyPackagesReport(network);

        // Kết quả mong đợi:
        // {North={Electronics=1}, South={Food=2}}
        System.out.println("Báo cáo hệ thống Logistics: " + report);
    }
}
