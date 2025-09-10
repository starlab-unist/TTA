import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;  // Added this import statement
import java.util.Arrays;       // Added this import statement

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_76 {

    // Source Code
    static class SourceCode {
        public static boolean isSimplePower(int x, int n) {
            if (n == 1) {
                return (x == 1);
            }
            int power = 1;
            while (power < x) {
                power = power * n;
            }
            return (power == x);
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static boolean checkPowerRelation(int base, int exponent) {
            if (exponent == 1) {
                return base == 1;
            }
            
            int currentValue = 1;
            while (currentValue < base) {
                currentValue *= exponent;
            }
            
            return currentValue == base;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 1},     // True: 1^1 = 1
        {8, 2},     // False: No power of 2 equals 8 exactly within the loop (should be false)
        {9, 3},     // True: 3^2 = 9
        {27, 3},    // True: 3^3 = 27
        {16, 4},    // True: 4^2 = 16
        {10, 10},   // True: 10^1 = 10
        {256, 2},   // True: 2^8 = 256
        {1, 5},     // False: 5^0 = 1, but loop condition fails for x > 1 when n > 1 (should be false)
        {0, 2},     // False: No power of 2 equals 0 (should be false)
        {7, 3}      // False: No power of 3 equals 7 exactly within the loop (should be false)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isSimplePower_vs_checkPowerRelation(int x, int n) {
        assertEquals(
            SourceCode.isSimplePower(x, n),
            TransformedCode.checkPowerRelation(x, n)
        );
    }
}