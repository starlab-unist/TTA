import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream; // Add import for Stream and Arrays

public class HumanEval_76 {

    // Source Code
    static class HumanEval_76_Source {
        public static boolean isSimplePower(int x, int n) { // Method is static
            if (n == 1) {
                return x == 1;
            }
            int power = 1;
            while (power < x) {
                power *= n;
            }
            return power == x;
        }
    }

    // Transformed Code
    static class HumanEval_76_Transformed {
        public static boolean checkPowerRelation(int base, int exponent) { // Method is static
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
    private static final Arguments[][] testCases = {
        {Arguments.of(1, 1)},     // True: 1^1 = 1
        {Arguments.of(8, 2)},     // False: No power of 2 equals 8 exactly within the loop
        {Arguments.of(9, 3)},     // True: 3^2 = 9
        {Arguments.of(27, 3)},    // True: 3^3 = 27
        {Arguments.of(16, 4)},    // True: 4^2 = 16
        {Arguments.of(10, 10)},   // False: The test case comment is incorrect. Should be false because 10^1 = 10 but the function checks if any power of 10 equals 10 which is true.
        {Arguments.of(256, 2)},   // True: 2^8 = 256
        {Arguments.of(1, 5)},     // False: 5^0 = 1, but loop condition fails for x > 1 when n > 1
        {Arguments.of(0, 2)},     // False: No power of 2 equals 0
        {Arguments.of(7, 3)}      // False: No power of 3 equals 7 exactly within the loop
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @ParameterizedTest(name = "{index}: isSimplePower({0}, {1}) == checkPowerRelation({0}, {1})")
    @MethodSource("provideTestCases")
    void testIsSimplePower_vs_CheckPowerRelation(int x, int n) {
        assertEquals(
            HumanEval_76_Source.isSimplePower(x, n), // Static method call
            HumanEval_76_Transformed.checkPowerRelation(x, n) // Static method call
        );
    }
}