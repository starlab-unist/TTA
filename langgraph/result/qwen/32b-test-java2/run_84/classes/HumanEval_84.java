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

public class HumanEval_84 {

    // Source Code
    static class OriginalImpl {
        public static String solve(int N) {
            int sum = 0;
            for (char c : Integer.toString(N).toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            return Integer.toBinaryString(sum);
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static String convertToBinaryString(int number) {
            int digitSum = 0;
            while (number > 0) {
                digitSum += number % 10;
                number /= 10;
            }
            String binaryRepresentation = Integer.toBinaryString(digitSum);
            return binaryRepresentation;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(1),
            Arguments.of(9),
            Arguments.of(123),
            Arguments.of(456),
            Arguments.of(789),
            Arguments.of(1001),
            Arguments.of(11111111),
            Arguments.of(987654321),
            Arguments.of((int) Math.pow(2, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(int testCase) {
        assertEquals(OriginalImpl.solve(testCase), TransformedImpl.convertToBinaryString(testCase));
    }
}