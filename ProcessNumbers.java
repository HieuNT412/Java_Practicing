import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class ProcessNumbers {
    public static List<Integer> processNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return null;

        List<Integer> result = numbers.stream()
                                        .filter(n -> n > 0)
                                        .distinct()
                                        .sorted(Comparator.reverseOrder())
                                        .collect(Collectors.toList());
        return result; 
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -2, 5, 3, 8, 5, 0, 1);
        
        // Kết quả mong đợi: [8, 5, 3, 1]
        // (-2 và 0 bị loại vì không > 0; các số 3 và 5 trùng lặp bị loại bỏ; sắp xếp giảm dần)
        System.out.println("Kết quả: " + processNumbers(numbers)); 
    }
}
