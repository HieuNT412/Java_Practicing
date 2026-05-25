import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class GetWordLengths {
    public static List<Integer> getWordLengths(List<String> words) {
        // WRITE YOUR LOGIC HERE
        if (words == null || words.isEmpty()) {
            return null;
        }
        
        List<Integer> result = words.stream()
                                    .filter(w -> !w.startsWith("x"))
                                    .map(s -> s.length())
                                    .collect(Collectors.toList());

        return result; 
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "xyz", "cherry", "xbox");
        
        // Kết quả mong đợi: [5, 6, 6]
        // (Vì "xyz" và "xbox" bắt đầu bằng 'x' nên bị loại bỏ. 
        // "apple" dài 5, "banana" dài 6, "cherry" dài 6)
        System.out.println("Độ dài các từ hợp lệ: " + getWordLengths(words)); 
    }
}
