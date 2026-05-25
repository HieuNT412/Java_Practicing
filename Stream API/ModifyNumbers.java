import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyNumbers {
    public static List<Integer> modifyNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }

        List<Integer> result = numbers.stream()
                                        .filter(n -> n > 5)
                                        .map(s -> s*2)
                                        .collect(Collectors.toList());
        return result; 
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 5, 8, 10, 3, 7);
        
        // Kết quả mong đợi: [16, 20, 14]
        // (Vì 8 * 2 = 16, 10 * 2 = 20, 7 * 2 = 14)
        System.out.println("Kết quả: " + modifyNumbers(numbers)); 
    }
}
