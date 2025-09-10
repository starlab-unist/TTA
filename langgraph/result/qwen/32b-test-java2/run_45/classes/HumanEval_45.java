import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.Arrays;

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
    private static final Object[][] testCases = {
        {10.0, 5.0},
        {7.0, 3.0},
        {0.0, 5.0},
        {5.0, 0.0},
        {0.0, 0.0},
        {2.5, 4.0},
        {100.0, 200.0},
        {1.0, 1.0},
        {3.14, 2.71},
        {12345.0, 6789.0}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void triangleArea_vs_calculateTriangleArea(double a, double h) {
        assertEquals(
            SourceCode.triangleArea(a, h),
            new TransformedCode().calculateTriangleArea(a, h)
        );
    }
}