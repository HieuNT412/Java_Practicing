import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import models.Student;

public class MaxScoreByGrade {
    public static Map<String, Optional<Integer>> maxScoreByGrade(List<Student> students) {
        if (students == null || students.isEmpty()) return new HashMap<>();

        Map<String, Optional<Integer>> result = students.stream()
                                                    .filter(s -> s.getScore() >= 50)
                                                    .collect(Collectors.groupingBy(
                                                        c -> c.getGrade(),
                                                        Collectors.mapping(Student::getScore, 
                                                            Collectors.maxBy(Comparator.naturalOrder()))
                                                    ));
        return result; 
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("An", "10A", 85),
            new Student("Bình", "10B", 90),
            new Student("Cường", "10A", 45), // Bị loại vì < 50
            new Student("Dũng", "10B", 75),
            new Student("Hạnh", "10A", 95)
        );

        Map<String, Optional<Integer>> result = maxScoreByGrade(students);
        
        // Kết quả mong đợi: {10A=Optional[95], 10B=Optional[90]}
        // (Lớp 10A có An 85 và Hạnh 95 -> Max là 95. Cường bị loại từ đầu)
        System.out.println("Điểm cao nhất theo lớp: " + result);
    }
}
