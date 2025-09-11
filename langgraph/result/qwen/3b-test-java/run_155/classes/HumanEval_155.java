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

public class HumanEval_155 {

    // Source Code
    public static int[] evenOddCount(int num) {
        int evenCount = 0;
        int oddCount = 0;
        String absNumStr = Integer.toString(Math.abs(num));

        for (int i = 0; i < absNumStr.length(); i++) {
            int digit = Character.getNumericValue(absNumStr.charAt(i));
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return new int[]{evenCount, oddCount};
    }

    // Transformed Code
    public static int[] tallyEvenOddDigits(int number) {
        int evenTally = 0;
        int oddTally = 0;
        String numStr = Math.abs(number) + ""; // Convert to string

        int index = 0;
        while (index < numStr.length()) {
            char digitChar = numStr.charAt(index);
            int digit = Character.getNumericValue(digitChar);
            if (digit % 2 == 0) {
                evenTally++;
            } else {
                oddTally++;
            }
            index++;
        }

        return new int[]{evenTally, oddTally};
    }

    // Nested static classes for testing
    public static class OriginalImpl {
        public static int[] evenOddCount(int num) {
            return HumanEval_155.evenOddCount(num);
        }
    }

    public static class TransformedImpl {
        public static int[] tallyEvenOddDigits(int number) {
            return HumanEval_155.tallyEvenOddDigits(number);
        }
    }

    // Test cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(1234567890),
                Arguments.arguments(-1234567890),
                Arguments.arguments(24680),
                Arguments.arguments(13579),
                Arguments.arguments(0),
                Arguments.arguments(111222333),  // Replaced with a smaller number
                Arguments.arguments(987654321),
                Arguments.arguments(-987654321),
                Arguments.arguments(1000000),
                Arguments.arguments(1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testEvenOddCount(int input) {
        int[] originalResult = OriginalImpl.evenOddCount(input);
        int[] transformedResult = TransformedImpl.tallyEvenOddDigits(input);
        assertEquals(java.util.Arrays.toString(originalResult), java.util.Arrays.toString(transformedResult));
    }
}