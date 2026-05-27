import models.Book;
import models.Classroom;
import models.School;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountThickBooksReport {
    public static Map<String, Map<String, Long>> countThickBooksReport(School school) {
        if (school == null || school.getClassrooms() == null) return new HashMap<>();

        Map<String, Map<String, Long>> result = school.getClassrooms().stream()
                .flatMap(c -> c.getBorrowedBooks().stream()
                        .filter(p -> p.getPages() > 100)
                        .map(p -> new AbstractMap.SimpleEntry<>(c.getGrade(), p)))
                .collect(
                        Collectors.groupingBy(
                                AbstractMap.SimpleEntry::getKey,
                                Collectors.groupingBy(
                                        entry -> entry.getValue().getCategory(),
                                        Collectors.counting()
                                )
                        )
                );
        return result;
    }

    public static void main(String[] args) {
        // 1. Tạo các cuốn sách mẫu
        Book math = new Book("Toán Cao Cấp", "Science", 150);
        Book physics = new Book("Vật Lý Đại Cương", "Science", 80); // Bị loại vì <= 100 trang
        Book novel1 = new Book("Đắc Nhân Tâm", "Novel", 200);
        Book novel2 = new Book("Nhà Giả Kim", "Novel", 120);

        // 2. Tạo các lớp học và gán sách mượn
        Classroom grade10 = new Classroom("Grade 10", Arrays.asList(math, physics));
        Classroom grade11 = new Classroom("Grade 11", Arrays.asList(novel1, novel2));

        // 3. Tạo trường học
        School school = new School(Arrays.asList(grade10, grade11));

        // 4. Chạy hàm test
        Map<String, Map<String, Long>> report = countThickBooksReport(school);

        // Kết quả mong đợi:
        // {Grade 10={Science=1}, Grade 11={Novel=2}}
        System.out.println("Báo cáo thư viện trường học: " + report);
    }
}
