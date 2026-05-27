import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InitializeStorage {
    public static void initializeStorage(String folderPath, String fileName) {
        // 1. Tạo đối tượng Path cho thư mục và file
        Path dirPath = Paths.get(folderPath);
        // Mẹo: Dùng dirPath.resolve(fileName) để kết hợp thư mục và tên file thành đường dẫn đầy đủ
        Path filePath = dirPath.resolve(fileName);

        try {
            // 📝 BẠN SẼ VIẾT CODE XỬ LÝ KIỂM TRA VÀ TẠO Ở ĐÂY
            // Các hàm cần dùng: Files.exists(), Files.createDirectories(), Files.createFile()
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
                System.out.println("Tạo folder thành công");
            } else {
                System.out.println("Tạo folder thất bại");
            }
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                System.out.println("Tạo file thành công");
            } else {
                System.out.println("Tạo file thất bại");
            }
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi hệ thống: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Chạy thử nghiệm: Tạo thư mục "logs" và file "app.log" bên trong
        initializeStorage("File/logs", "app.log");
    }
}