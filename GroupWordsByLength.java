
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsByLength {

    public static Map<Integer, List<String>> groupWordsByLength(List<String> words) {
        // WRITE YOUR LOGIC HERE
        if (words == null || words.isEmpty()) return null;

        Map<Integer, List<String>> result = words.stream()
                                                .filter(l -> l.length() > 2)
                                                .collect(Collectors.groupingBy(w -> w.length()));

        return result;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("am", "apple", "bat", "car", "banana", "cat+");

        // Kết quả mong đợi: {3=[bat, car], 4=[cat+], 5=[apple], 6=[banana]}
        // ("am" bị loại vì độ dài là 2)
        System.out.println("Kết quả gom nhóm: " + groupWordsByLength(words));
    }
}
