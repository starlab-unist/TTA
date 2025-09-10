import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_13 {

    // Source Code
    static class SourceCode {
        public static int greatestCommonDivisor(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int find_highest_common_factor(int num1, int num2) {
            while (num2 != 0) {
                int remainder = num1 % num2;
                num1 = num2;
                num2 = remainder;
            }
            return num1;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {48, 18},   // GCD is 6
        {56, 98},   // GCD is 14
        {101, 103}, // GCD is 1 (prime numbers)
        {270, 192}, // GCD is 6
        {0, 5},     // GCD is 5
        {5, 0},     // GCD is 5
        {0, 0},     // GCD is 0 (common edge case)
        {20, 30},   // GCD is 10
        {7, 3},     // GCD is 1
        {100, 10}   // GCD is 10
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Compare greatestCommonDivisor and find_highest_common_factor")
    void test_greatestCommonDivisor_vs_findHighestCommonFactor(int a, int b) {
        assertEquals(
            SourceCode.greatestCommonDivisor(a, b),
            TransformedCode.find_highest_common_factor(a, b)
        );
    }
}