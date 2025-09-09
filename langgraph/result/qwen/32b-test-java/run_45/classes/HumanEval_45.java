import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_45 {

    // Source Code
    static class SourceCode {
        public static double triangleArea(double a, double h) {
            return a * h / 2.0;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public double calculateTriangleArea(double base, double height) {
            double area = (base * height) / 2.0;
            return area;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(new Arguments[]{
            Arguments.of(10.0, 5.0),
            Arguments.of(7, 3),       // Using integer values
            Arguments.of(0, 5),        // Base is zero
            Arguments.of(5, 0),        // Height is zero
            Arguments.of(0, 0),        // Both base and height are zero
            Arguments.of(2.5, 4.0),
            Arguments.of(100, 200),    // Large integer values
            Arguments.of(1, 1),         // Smallest non-zero integer values
            Arguments.of(3.14, 2.71),
            Arguments.of(12345, 6789)   // Very large integer values
        });
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Triangle Area Calculation Equivalence Test")
    void triangleArea_vs_calculateTriangleArea(double base, double height) {
        assertEquals(
            SourceCode.triangleArea(base, height),
            TransformedCode.calculateTriangleArea(base, height),
            0.001 // Delta for floating-point comparison
        );
    }
}