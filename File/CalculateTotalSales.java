import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculateTotalSales {
    public static void calculateTotalSales(String sourcePath, String targetPath) {

        try (Stream<String> lines = Files.lines(Paths.get(sourcePath))) {
            if (!Files.exists(Paths.get(targetPath))) {
                Files.createFile(Paths.get(targetPath));
            }
            // 📝 BƯỚC 1: Bạn sẽ dùng Stream API để biến đổi luồng dữ liệu
            // và gom nhóm thành Map<String, Integer> như thế nào?
            // Gợi ý: Cần cắt chuỗi bằng .split(",") để lấy tên, số lượng, đơn giá.
            Map<String, Integer> process = lines.collect(
                    Collectors.groupingBy(
                            line -> line.split(",")[0],
                            Collectors.summingInt(
                                    line -> {
                                        String[] split = line.split(",");
                                        return Integer.parseInt(split[1]) * Integer.parseInt(split[2]);
                                    }
                            )
                    )
            );
            // 📝 BƯỚC 2: Chuyển dữ liệu từ Map thành List<String> dạng "Key: Value"
            // và ghi vào file đích bằng Files.write.
            List<String> reportLines = process.entrySet().stream()
                    .map(
                            entry -> entry.getKey() + ": " + entry.getValue()
                    ).collect(Collectors.toList());
            Files.write(Paths.get(targetPath), reportLines);
        } catch (IOException e) {
            System.err.println("Lỗi xử lý file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        calculateTotalSales("File/logs/sales.txt", "File/logs/report.txt");
    }
}
