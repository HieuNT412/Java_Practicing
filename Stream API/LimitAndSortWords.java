
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitAndSortWords {

    public static List<String> limitAndSortWords(List<String> words) {
        if (words == null || words.isEmpty()) return null;

        List<String> result = words.stream().filter(w -> w.length() >= 4)
                                            .sorted()
                                            .limit(2)
                                            .collect(Collectors.toList());

        return result;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("elephant", "cat", "dog", "bear", "ant", "zebra");

        // Kết quả mong đợi: ["bear", "elephant"]
        // (Các từ hợp lệ dài >= 4 là: "elephant", "bear", "zebra".
        // Sắp xếp A-Z sẽ thành: "bear", "elephant", "zebra".
        // Giới hạn lấy 2 phần tử đầu tiên nên kết quả là "bear" và "elephant")
        System.out.println("Kết quả: " + limitAndSortWords(words));
    }
}
