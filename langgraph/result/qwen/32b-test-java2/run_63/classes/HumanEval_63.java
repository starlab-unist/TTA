import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;  // Added import for Stream
import java.util.Arrays;        // Added import for Arrays

public class HumanEval_63 {

    // Source Code
    static class SourceCode {
        public static int fibfib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            return fibfib(n - 1) + fibfib(n - 2) + fibfib(n - 3);
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int calculateModifiedFibonacci(int index) {
            if (index == 0) {
                return 0;
            } else if (index == 1) {
                return 0;
            } else if (index == 2) {
                return 1;
            } else {
                return (calculateModifiedFibonacci(index - 1) +
                        calculateModifiedFibonacci(index - 2) +
                        calculateModifiedFibonacci(index - 3));
            }
        }
    }

    private static final int[] testCases = {
        0,  // Base case
        1,  // Base case
        2,  // Base case
        3,  // Simple case
        4,  // Slightly larger input
        5,  // Further recursion
        6,  // Further recursion
        7,  // Further recursion
        8,  // Further recursion
        9   // Larger input to test deeper recursion
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(i -> Arguments.of(i));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void fibfib_vs_calculateModifiedFibonacci(int input) {
        assertEquals(
            SourceCode.fibfib(input),
            new TransformedCode().calculateModifiedFibonacci(input)
        );
    }
}