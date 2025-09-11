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
import java.util.AbstractMap.SimpleEntry; // Use SimpleEntry as an alternative to Pair

public class HumanEval_155 {

    // Source Code wrapped in a nested static class
    public static class OriginalImpl {
        public static SimpleEntry<Integer, Integer> evenOddCount(long num) {
            int evenCount = 0;
            int oddCount = 0;
            for (char c : String.valueOf(Math.abs(num)).toCharArray()) {
                if ((c - '0') % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
            return new SimpleEntry<>(evenCount, oddCount);
        }
    }

    // Transformed Code wrapped in a nested static class
    public static class TransformedImpl {
        public static int[] tallyEvenOddDigits(long number) {
            int evenCount = 0;
            int oddCount = 0;
            int index = 0;
            String numStr = Long.toString(Math.abs(number));
            
            while (index < numStr.length()) {
                int digit = Character.digit(numStr.charAt(index), 10);
                if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
                index++;
            }
            
            return new int[]{evenCount, oddCount};
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
            Arguments.of(111222333444L), // Larger number now using long
            Arguments.of(987654321L),
            Arguments.of(-987654321L),
            Arguments.of(1000000L),
            Arguments.of(1L)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testEvenOddCount(long input) {
        SimpleEntry<Integer, Integer> resultOriginal = OriginalImpl.evenOddCount(input);
        int[] resultTransformed = TransformedImpl.tallyEvenOddDigits(input);

        assertEquals(resultOriginal.getKey(), (Integer) resultTransformed[0]);
        assertEquals(resultOriginal.getValue(), (Integer) resultTransformed[1]);
    }
}