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

public class HumanEval_155 {

    // Source Code
    static class OriginalImpl {
        public static int[] evenOddCount(int num) {
            int evenCount = 0;
            int oddCount = 0;
            String numStr = Integer.toString(Math.abs(num));
            for (char c : numStr.toCharArray()) {
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

    // Transformed Code
    static class TransformedImpl {
        public static int[] tallyEvenOddDigits(int number) {
            int evenTally = 0;
            int oddTally = 0;
            int index = 0;
            String numStr = Integer.toString(Math.abs(number));
            
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
            Arguments.of(1234567890),
            Arguments.of(-1234567890),
            Arguments.of(24680),
            Arguments.of(13579),
            Arguments.of(0),
            Arguments.of(111222333), // Reduced to fit within int range
            Arguments.of(987654321),
            Arguments.of(-987654321),
            Arguments.of(1000000),
            Arguments.of(1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(int testCase) {
        assertEquals(java.util.Arrays.toString(OriginalImpl.evenOddCount(testCase)), 
                     java.util.Arrays.toString(TransformedImpl.tallyEvenOddDigits(testCase)));
    }
}