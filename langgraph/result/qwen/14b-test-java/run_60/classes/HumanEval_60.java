import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_60 {

    // Source Code
    static class HumanEval_60_Source {
        public static int sumToN(int n) {
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += i;
            }
            return sum;
        }
    }

    // Transformed Code
    static class HumanEval_60_Transformed {
        public static int calculateTotalUpTo(int number) {
            int totalSum = 0;
            int current = 0;
            
            while (current <= number) {
                totalSum += current;
                current += 1;
            }
            
            return totalSum;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,      // Edge case: smallest possible input
        1,      // Simple case
        5,      // Small positive integer
        10,     // Medium positive integer
        20,     // Larger positive integer
        100,    // Large positive integer
        -1,     // Negative number (edge case)
        -5,     // Another negative number
        1000,   // Very large positive integer
        1       // Repeated simple case
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).boxed().map(Arguments::of);
    }

    @DisplayName("Test sumToN and calculateTotalUpTo for equivalence")
    @ParameterizedTest(name = "Input: {0}")
    @MethodSource("provideTestCases")
    void sumToN_vs_calculateTotalUpTo(int input) {
        assertEquals(
            HumanEval_60_Source.sumToN(input),
            HumanEval_60_Transformed.calculateTotalUpTo(input)
        );
    }
}