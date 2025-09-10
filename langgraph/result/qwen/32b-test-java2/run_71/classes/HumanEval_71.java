import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;  // Added import for Arrays
import java.util.stream.Stream;  // Added import for Stream

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_71 {

    // Source Code
    public static class HumanEval_71_Source {
        public static double triangleArea(double a, double b, double c) {
            if (a + b <= c || a + c <= b || b + c <= a) {
                return -1;
            }
            double s = (a + b + c) / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            area = Math.round(area * 100.0) / 100.0;
            return area;
        }
    }

    // Transformed Code
    public static class HumanEval_71_Transformed {
        public static double computeTriangleArea(double side1, double side2, double side3) {  
            if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
                return -1;
            }
            
            double semiPerimeter = (side1 + side2 + side3) / 2;
            double computedArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
            double roundedArea = Math.round(computedArea * 100.0) / 100.0;
            
            return roundedArea;
        }
    }

    // Test Cases
    private static final double[][] testCases = {
        {3, 4, 5},      // valid triangle (right)
        {10, 6, 8},     // valid triangle
        {7, 10, 5},     // valid triangle
        {1, 1, 2},      // invalid triangle (fails triangle inequality)
        {5, 5, 5},      // equilateral triangle
        {0, 4, 5},      // invalid triangle with zero side
        {-3, 4, 5},     // invalid triangle with negative side
        {6, 8, 10},     // valid right triangle
        {2, 2, 3.464},  // valid isosceles triangle (approximate)
        {12, 5, 13}     // valid triangle
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "triangleArea({0}, {1}, {2}) == computeTriangleArea({0}, {1}, {2})")
    @MethodSource("provideTestCases")
    void triangleArea_vs_computeTriangleArea(double a, double b, double c) {
        assertEquals(
            HumanEval_71_Source.triangleArea(a, b, c),
            HumanEval_71_Transformed.computeTriangleArea(a, b, c)
        );
    }
}