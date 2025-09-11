import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HumanEval_97 {

    // Source Code wrapped as a nested static class
    public static class OriginalImpl {
        public static int multiply(int a, int b) {
            return Math.abs(a % 10) * Math.abs(b % 10);
        }
    }

    // Transformed Code wrapped as a nested static class
    public static class TransformedImpl {
        public static int calculateUnitDigitProduct(int x, int y) {
            int unitDigitX = Math.abs(x % 10);
            int unitDigitY = Math.abs(y % 10);
            int product = unitDigitX * unitDigitY;
            return product;
        }
    }

    // Test case provider
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments(123, 456),
            Arguments.arguments(-123, 456),
            Arguments.arguments(123, -456),
            Arguments.arguments(-123, -456),
            Arguments.arguments(0, 456),
            Arguments.arguments(123, 0),
            Arguments.arguments(0, 0),
            Arguments.arguments(789, 12345),
            Arguments.arguments(5, 9),
            Arguments.arguments(10, 10)
        );
    }

    // Parameterized Test
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMultiply(int a, int b) {
        assertEquals(OriginalImpl.multiply(a, b), TransformedImpl.calculateUnitDigitProduct(a, b));
    }
}