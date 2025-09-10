import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Test Cases
public class HumanEval_85 {

    private static final Arguments[] testCases = {
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 6),       // Expected output: 6 (2 + 4)
        Arguments.of(new int[]{10, 15, 20, 25, 30, 35}, 0), // Expected output: 0 (no even numbers at odd indices)
        Arguments.of(new int[]{2, 4, 6, 8, 10, 12}, 20),     // Expected output: 20 (4 + 8 + 12)
        Arguments.of(new int[]{1, 3, 5, 7, 9}, 0),          // Expected output: 0 (no even numbers at odd indices)
        Arguments.of(new int[]{}, 0),                        // Expected output: 0 (empty list)
        Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, 0),       // Expected output: 0 (all zeros)
        Arguments.of(new int[]{1, 2}, 2),                    // Expected output: 2
        Arguments.of(new int[]{1, 2, 3}, 2),                 // Expected output: 2
        Arguments.of(new int[]{1, 2, 3, 4}, 6),              // Expected output: 6 (2 + 4)
        Arguments.of(new int[]{1, 2, 3, 4, 5}, 6)            // Expected output: 6 (2 + 4)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if source and transformed functions produce the same output")
    void add_vs_calculateEvenSumAtOddIndices(int[] input, int expectedOutput) {
        assertEquals(
            new SourceCode().add(input), // Create an instance of SourceCode to call non-static method
            new TransformedCode().calculateEvenSumAtOddIndices(input), // Create an instance of TransformedCode to call non-static method
            "Failed for input: " + Arrays.toString(input)
        );
    }

    // Source Code
    class SourceCode {
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
    class TransformedCode {
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
}