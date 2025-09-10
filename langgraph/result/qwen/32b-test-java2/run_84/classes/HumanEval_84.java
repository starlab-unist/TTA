import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_84 {

    // Source Code
    static class SourceCode {
        public static String solve(int N) {
            int sum = 0;
            for (char c : Integer.toString(N).toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            return Integer.toBinaryString(sum);
        }
    }

    // Transformed Code
    static class TransformedCode {
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
    private static final int[] testCases = {
        0,
        1,
        9,
        123,
        456,
        789,
        1001,
        11111111,
        987654321,
        (int) Math.pow(2, 10)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).boxed().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test solve vs convertToBinaryString")
    void testSolve_vs_convertToBinaryString(int inputNumber) {
        assertEquals(
            SourceCode.solve(inputNumber),
            TransformedCode.convertToBinaryString(inputNumber)
        );
    }
}