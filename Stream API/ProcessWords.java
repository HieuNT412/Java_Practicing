import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class ProcessWords {
    public static List<String> processWords(List<String> words) {
        if (words == null || words.isEmpty()) {
            return null;
        }
        // WRITE YOUR LOGIC HERE
        List<String> result = words.stream()
                                    .filter(w -> w.length() > 3)
                                    .map(s -> s.toUpperCase())
                                    .collect(Collectors.toList());
        return result;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "java", "dog", "stream", "api", "code");
        
        // Kết quả mong đợi: ["JAVA", "STREAM", "CODE"]
        // (Vì "cat", "dog", "api" có độ dài bằng 3 nên bị loại bỏ)
        System.out.println("Kết quả sau xử lý: " + processWords(words)); 
    }
}
