import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtractErrorLogs {
    public static void extractErrorLogs(String sourcePath, String targetPath) {
        // 🛠️ Bọc trong try-with-resources để Stream tự động đóng file nguồn sau khi đọc xong

        try (Stream<String> lines = Files.lines(Paths.get(sourcePath))) {
            Path target = Paths.get(targetPath);
            if (!Files.exists(target)) {
                Files.createFile(target);
            }
            List<String> record = lines.filter(line -> line.contains("ERROR"))
                    .collect(Collectors.toList());
            Files.write(target, record, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Lỗi xử lý file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Hàm test: Trích xuất các lỗi từ app.log sang error.log
        extractErrorLogs("File/logs/app.log", "File/logs/error.log");
    }
}
