import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_150 {

    // Source Code
    static class SourceCode {
        public static int xOrY(int n, int x, int y) {
            if (n == 1) {
                return y;
            }
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return y;
                }
            }
            return x;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static Object determineValueBasedOnDivisibility(int number, Object valueIfNotPrime, Object valueIfPrime) {
            if (number == 1) {
                return valueIfPrime;
            }

            int divisor = 2;
            while (divisor < number) {
                if (number % divisor == 0) {
                    return valueIfPrime;
                }
                divisor += 1;
            }
            return valueIfNotPrime;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {1, 2, 3},
        {2, 4, 5},
        {3, 6, 7},
        {4, 8, 9},
        {5, 10, 11},
        {6, 12, 13},
        {7, 14, 15},
        {8, 16, 17},
        {9, 18, 19},
        {10, 20, 21}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if both functions produce the same output for given inputs")
    void xOrY_vs_determineValueBasedOnDivisibility(int n, int x, int y) {
        assertEquals(
            SourceCode.xOrY(n, x, y),
            TransformedCode.determineValueBasedOnDivisibility(n, x, y)
        );
    }
}