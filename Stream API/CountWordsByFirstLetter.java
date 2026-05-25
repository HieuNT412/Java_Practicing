import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountWordsByFirstLetter {
    public static Map<Character, Long> countWordsByFirstLetter(List<String> words) {
        // WRITE YOUR LOGIC HERE
        if (words == null || words.isEmpty()) return null;

        Map<Character, Long> result = words.stream().filter(h -> Character.isLowerCase(h.charAt(0)))
                                                    .collect(Collectors.groupingBy(
                                                        head -> head.charAt(0),
                                                        Collectors.counting()
                                                    ));

        return result; 
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "Banana", "apricot", "cherry", "Berry");
        
        // Kết quả mong đợi: {a=2, c=1}
        // ("Banana" và "Berry" bị loại vì bắt đầu bằng chữ in hoa.
        // Nhóm 'a' có: "apple", "apricot" -> 2 từ. Nhóm 'c' có: "cherry" -> 1 từ)
        System.out.println("Kết quả gom nhóm: " + countWordsByFirstLetter(words)); 
    }
}
