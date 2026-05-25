
import java.util.Arrays;
import java.util.List;

public class SumOfEven {

    public static int sumOfEven(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        
        // Use Java Streams to filter even numbers and sum them up
        int result = numbers.stream()
                //filter out null values to avoid NullPointerException
                .filter(n -> n % 2 == 0)
                // Convert Integer to int
                .mapToInt(n -> n)
                //sum the even numbers
                .sum();
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(sumOfEven(numbers)); // Output: 12
    }
}