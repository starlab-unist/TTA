import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HumanEval_122 {

    // Source Code
    private static int addElements(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k && i < arr.length; i++) {
            if (String.valueOf(arr[i]).length() <= 2) {
                sum += arr[i];
            }
        }
        return sum;
    }

    // Transformed Code
    private static int calculateSumOfSmallNumbers(int[] numbers, int count) {
        int total = 0;
        int index = 0;
        
        while (index < count && index < numbers.length) {
            if (String.valueOf(numbers[index]).length() <= 2) {
                total += numbers[index];
            }
            index++;
        }
        
        return total;
    }

    // Test Cases
    @ParameterizedTest(name = "Test case {index}")
    @CsvSource({
        "1, 10, 100, 1000, 3",
        "5, 23, 456, 7890, 4",
        "99, 100, 101, 102, 2",
        "1, 2, 3, 4, 5, 5",
        "123, 45, 67, 89, 10, 5",
        "111, 222, 333, 44, 55, 3",
        "1, 1, 1, 1, 1, 1",
        ", 1", // This is a special case for empty array
        "10, 20, 30, 40, 50, 0",
        "9, 8, 7, 6, 5, 5"
    })
    @DisplayName("Test if source and transformed methods produce the same output")
    void testAddElements_vs_calculateSumOfSmallNumbers(String inputArrayStr, int k) {
        // Convert input string to array
        int[] arr = {};
        if (!inputArrayStr.trim().isEmpty()) {
            String[] parts = inputArrayStr.split(",\\s*");
            arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        }

        assertEquals(
            addElements(arr, k),
            calculateSumOfSmallNumbers(arr, k)
        );
    }
}