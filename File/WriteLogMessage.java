import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class WriteLogMessage {
    public static void writeLogMessage(String filePath, String message) {
        Path path = Paths.get(filePath);

        try {
            // 1. Tự động tạo file nếu chưa tồn tại
            if (!Files.exists(path)) {
                // Bạn có thể tận dụng lại hàm tạo thư mục cha nếu cần,
                // hoặc giả định thư mục cha đã tồn tại để tập trung vào việc ghi file.
                Files.createFile(path);
            }
            List<String> mess = Arrays.asList(message.split("\n"));

            Files.write(path, mess, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String path = "File/logs/app.log";
        writeLogMessage(path, "Hệ thống khởi động thành công.");
        writeLogMessage(path, "Người dùng đăng nhập vào hệ thống.");
    }
}
