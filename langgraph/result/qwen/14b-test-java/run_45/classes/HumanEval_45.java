import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;  // Added import for Stream
import java.util.Arrays;       // Added import for Arrays

public class HumanEval_45 {

    // Source Code
    static class SourceCode {
        public static double triangleArea(double a, double h) {
            return a * h / 2.0;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static double calculateTriangleArea(double base, double height) {
            double area = (base * height) / 2.0;
            return area;
        }
    }

    // Test Cases
    private static final double[][] testCases = {
        {10, 5},
        {7, 3},
        {0, 5},
        {5, 0},
        {0, 0},
        {2.5, 4.0},
        {100, 200},
        {1, 1},
        {3.14, 2.71},
        {12345, 6789}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing triangleArea vs calculateTriangleArea equivalence")
    void triangleArea_vs_calculateTriangleArea(double base, double height) {
        assertEquals(
            SourceCode.triangleArea(base, height),
            TransformedCode.calculateTriangleArea(base, height),
            0.0001 // Delta for floating-point comparison
        );
    }
}