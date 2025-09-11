import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_157 {

    // Source Code
    static class OriginalImpl {
        public static boolean rightAngleTriangle(int a, int b, int c) {
            return a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static boolean is_right_angled(double x, double y, double z) {
            double[] sidesSquared = {x * x, y * y, z * z};
            java.util.Arrays.sort(sidesSquared);
            return sidesSquared[0] + sidesSquared[1] == sidesSquared[2];
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(3, 4, 5),   // True: 3^2 + 4^2 = 5^2
                Arguments.of(5, 12, 13), // True: 5^2 + 12^2 = 13^2
                Arguments.of(1, 1, 1),   // False: not a right triangle
                Arguments.of(6, 8, 10),  // True: 6^2 + 8^2 = 10^2
                Arguments.of(7, 24, 25), // True: 7^2 + 24^2 = 25^2
                Arguments.of(9, 40, 41), // True: 9^2 + 40^2 = 41^2
                Arguments.of(2, 2, 3),   // False: not a right triangle
                Arguments.of(8, 15, 17), // True: 8^2 + 15^2 = 17^2
                Arguments.of(10, 24, 26),// True: 10^2 + 24^2 = 26^2
                Arguments.of(5, 5, 7)    // False: not a right triangle
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testRightAngleTriangle(int a, int b, int c) {
        assertEquals(
                OriginalImpl.rightAngleTriangle(a, b, c),
                TransformedImpl.is_right_angled(a, b, c)
        );
    }
}