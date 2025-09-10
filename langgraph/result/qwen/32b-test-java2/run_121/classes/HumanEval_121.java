import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays; // Added import for Arrays

public class HumanEval_121 {

    // Source Code
    static class HumanEval_121_Source {
        public int solution(int[] lst) {
            int sum = 0;
            for (int idx = 0; idx < lst.length; idx++) {
                if (idx % 2 == 0 && lst[idx] % 2 == 1) {
                    sum += lst[idx];
                }
            }
            return sum;
        }
    }

    // Transformed Code
    static class HumanEval_121_Transformed {
        public int calculate_odd_sum_at_even_indices(int[] numbers) {
            int total = 0;
            int index = 0;
            while (index < numbers.length) {
                if (index % 2 == 0 && numbers[index] % 2 == 1) {
                    total += numbers[index];
                }
                index++;
            }
            return total;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 4, 5},          // Expected output: 9 (1 + 3 + 5)
        {2, 4, 6, 8, 10},         // Expected output: 0
        {1, 3, 5, 7, 9},          // Expected output: 15 (1 + 5 + 9)
        {},                       // Expected output: 0
        {1},                      // Expected output: 1
        {2, 2, 2, 2, 2, 2},       // Expected output: 0
        {1, 1, 1, 1, 1, 1},       // Expected output: 3 (1 + 1 + 1)
        {0, 1, 2, 3, 4, 5, 6},    // Expected output: 9 (1 + 3 + 5)
        {7, 8, 9, 10, 11, 12},    // Expected output: 18 (7 + 9 + 11)
        {13, 14, 15, 16, 17, 18}  // Expected output: 45 (13 + 15 + 17)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solution_vs_calculate_odd_sum_at_even_indices(int[] inputArray) {
        assertEquals(
            sourceInstance.solution(inputArray),
            transformedInstance.calculate_odd_sum_at_even_indices(inputArray)
        );
    }

    // Singleton instances for static methods
    private static final HumanEval_121_Source sourceInstance = new HumanEval_121_Source();
    private static final HumanEval_121_Transformed transformedInstance = new HumanEval_121_Transformed();

}