import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        public String rotateString(int number, int offset) {
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
    @ParameterizedTest(name = "test case {index}: circularShift({0}, {1}) == rotateString({0}, {1})")
    @CsvSource({
        "12345, 2",       // Normal circular shift
        "12345, 5",       // Full rotation, should return the same number
        "12345, 6",       // Shift greater than length, should reverse
        "987654321, 3",    // Normal circular shift with a larger number
        "987654321, 9",    // Full rotation, should return the same number
        "987654321, 10",   // Shift greater than length, should reverse
        "11111, 2",       // All digits same, shift within bounds
        "11111, 6",       // All digits same, shift out of bounds
        "0, 1",           // Single digit number, shift within bounds
        "0, 0"            // Single digit number, no shift
    })
    void circularShift_vs_rotateString(int inputNumber, int inputOffset) {
        assertEquals(
            SourceCode.circularShift(inputNumber, inputOffset),
            new TransformedCode().rotateString(inputNumber, inputOffset)
        );
    }
}