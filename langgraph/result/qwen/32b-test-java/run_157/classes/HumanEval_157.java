import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class HumanEval_157 {

    // Source Code
    static class SourceCode {
        public boolean rightAngleTriangle(int a, int b, int c) {
            return a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean isRightAngled(int x, int y, int z) {
            int[] sidesSquared = {x * x, y * y, z * z};
            java.util.Arrays.sort(sidesSquared);
            return sidesSquared[0] + sidesSquared[1] == sidesSquared[2];
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {3, 4, 5},   // True: 3^2 + 4^2 = 5^2
        {5, 12, 13}, # True: 5^2 + 12^2 = 13^2
        {1, 1, 1},   // False: not a right triangle
        {6, 8, 10},  // True: 6^2 + 8^2 = 10^2
        {7, 24, 25}, // True: 7^2 + 24^2 = 25^2
        {9, 40, 41}, // True: 9^2 + 40^2 = 41^2
        {2, 2, 3},   // False: not a right triangle
        {8, 15, 17}, // True: 8^2 + 15^2 = 17^2
        {10, 24, 26},# True: 10^2 + 24^2 = 26^2
        {5, 5, 7}    // False: not a right triangle
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "test with input {0}, {1}, {2}")
    @MethodSource("provideTestCases")
    public void rightAngleTriangle_vs_isRightAngled(int a, int b, int c) {
        assertEquals(
            SourceCode.rightAngleTriangle(a, b, c),
            TransformedCode.isRightAngled(a, b, c)
        );
    }
}