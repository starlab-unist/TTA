import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_85 {

    // Source Code
    static class SourceCode {
        public int add(int[] lst) {
            int sum = 0;
            for (int i = 1; i < lst.length; i += 2) {
                if (lst[i] % 2 == 0) {
                    sum += lst[i];
                }
            }
            return sum;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int calculateEvenSumAtOddIndices(int[] numbers) {
            int total = 0;
            int index = 1;
            while (index < numbers.length) {
                if (numbers[index] % 2 == 0) {
                    total += numbers[index];
                }
                index += 2;
            }
            return total;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 4, 5, 6},       // Expected output: 6 (2 + 4)
        {10, 15, 20, 25, 30, 35}, // Expected output: 20 (only 20 is even at odd index)
        {2, 4, 6, 8, 10, 12},     // Expected output: 20 (4 + 8 + 12)
        {1, 3, 5, 7, 9},          // Expected output: 0 (no even numbers at odd indices)
        {},                       // Expected output: 0 (empty list)
        {0, 0, 0, 0, 0, 0},       // Expected output: 0 (all zeros)
        {1, 2},                   // Expected output: 2
        {1, 2, 3},                // Expected output: 2
        {1, 2, 3, 4},             // Expected output: 6 (2 + 4)
        {1, 2, 3, 4, 5}           // Expected output: 6 (2 + 4)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Source Code vs Transformed Code")
    @ParameterizedTest(name = "Test Case {index}")
    @MethodSource("provideTestCases")
    void add_vs_calculateEvenSumAtOddIndices(int[] inputArray) {
        assertEquals(
            SourceCode.add(inputArray),
            TransformedCode.calculateEvenSumAtOddIndices(inputArray)
        );
    }
}