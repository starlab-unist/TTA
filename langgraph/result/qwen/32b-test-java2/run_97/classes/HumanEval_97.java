import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays; // Import for Arrays utility
import java.util.stream.Stream; // Import for Stream API

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_97 {

    // Source Code with static methods
    static class SourceCode {
        public static int multiply(int a, int b) {
            return Math.abs(a % 10) * Math.abs(b % 10);
        }
    }

    // Transformed Code with static methods
    static class TransformedCode {
        public static int calculateUnitDigitProduct(int x, int y) {
            int unitDigitX = Math.abs(x % 10);
            int unitDigitY = Math.abs(y % 10);
            int product = unitDigitX * unitDigitY;
            return product;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {123, 456},
        {-123, 456},
        {123, -456},
        {-123, -456},
        {0, 456},
        {123, 0},
        {0, 0},
        {789, 12345},
        {5, 9},
        {10, 10}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void multiply_vs_calculateUnitDigitProduct(int a, int b) {
        assertEquals(
            SourceCode.multiply(a, b), // Directly call static method from SourceCode
            TransformedCode.calculateUnitDigitProduct(a, b) // Directly call static method from TransformedCode
        );
    }
}