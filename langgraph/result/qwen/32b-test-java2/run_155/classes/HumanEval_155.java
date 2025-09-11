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

public class HumanEval_155 {

    // Original Implementation
    static class OriginalImpl {
        public static int[] evenOddCount(long num) {
            int evenCount = 0;
            int oddCount = 0;
            String numberStr = Long.toString(Math.abs(num));
            for (char c : numberStr.toCharArray()) {
                int digit = Character.getNumericValue(c);
                if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
            return new int[]{evenCount, oddCount};
        }
    }

    // Transformed Implementation
    static class TransformedImpl {
        public static int[] tallyEvenOddDigits(long number) {
            int evenTally = 0;
            int oddTally = 0;
            int index = 0;
            String numStr = Long.toString(Math.abs(number));
            
            while (index < numStr.length()) {
                int digit = Character.getNumericValue(numStr.charAt(index));
                if (digit % 2 == 0) {
                    evenTally += 1;
                } else {
                    oddTally += 1;
                }
                index += 1;
            }
            
            return new int[]{evenTally, oddTally};
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(1234567890L),
            Arguments.of(-1234567890L),
            Arguments.of(24680L),
            Arguments.of(13579L),
            Arguments.of(0L),
            Arguments.of(111222333444L),
            Arguments.of(987654321L),
            Arguments.of(-987654321L),
            Arguments.of(1000000L),
            Arguments.of(1L)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testEvenOddCount(long input) {
        int[] originalResult = OriginalImpl.evenOddCount(input);
        int[] transformedResult = TransformedImpl.tallyEvenOddDigits(input);
        assertEquals(java.util.Arrays.toString(originalResult), java.util.Arrays.toString(transformedResult));
    }
}