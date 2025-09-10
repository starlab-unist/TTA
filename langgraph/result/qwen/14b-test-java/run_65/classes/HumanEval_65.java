import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays; // Add this import statement
import java.util.stream.Stream; // Add this import statement

public class HumanEval_65 {

    // Source Code
    static class SourceCode {
        public static String circularShift(int x, int shift) {
            String s = Integer.toString(x);
            if (shift > s.length()) {
                return new StringBuilder(s).reverse().toString();
            } else {
                return s.substring(s.length() - shift) + s.substring(0, s.length() - shift);
            }
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static String rotateString(int number, int offset) {
            String numStr = Integer.toString(number);
            int length = numStr.length();
            
            if (offset >= length) {
                return new StringBuilder(numStr).reverse().toString();
            } else {
                int splitPoint = length - offset;
                String rotatedPart = numStr.substring(splitPoint);
                String remainingPart = numStr.substring(0, splitPoint);
                return rotatedPart + remainingPart;
            }
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(12345, 2)},       // Normal circular shift
        {Arguments.of(12345, 5)},       // Full rotation, should return the same number
        {Arguments.of(12345, 6)},       // Shift greater than length, should reverse
        {Arguments.of(987654321, 3)},    // Normal circular shift with a larger number
        {Arguments.of(987654321, 9)},    // Full rotation, should return the same number
        {Arguments.of(987654321, 10)},   // Shift greater than length, should reverse
        {Arguments.of(11111, 2)},       // All digits same, shift within bounds
        {Arguments.of(11111, 6)},       // All digits same, shift out of bounds
        {Arguments.of(0, 1)},           // Single digit number, shift within bounds
        {Arguments.of(0, 0)},           // Single digit number, no shift
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @ParameterizedTest(name = "Test with input: {arguments}")
    @MethodSource("provideTestCases")
    void circularShift_vs_rotateString(int number, int shift) {
        assertEquals(
            SourceCode.circularShift(number, shift),
            TransformedCode.rotateString(number, shift)
        );
    }
}