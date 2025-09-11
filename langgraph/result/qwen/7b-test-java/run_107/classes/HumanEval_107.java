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
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Original Implementation
public class HumanEval_107 {

    public static class OriginalImpl {
        public static int[] evenOddPalindrome(int n) {
            int evenPalindromeCount = 0;
            int oddPalindromeCount = 0;

            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1 && isPalindrome(i)) {
                    oddPalindromeCount++;
                } else if (i % 2 == 0 && isPalindrome(i)) {
                    evenPalindromeCount++;
                }
            }

            return new int[]{evenPalindromeCount, oddPalindromeCount};
        }

        private static boolean isPalindrome(int n) {
            String numStr = Integer.toString(n);
            String reversedStr = new StringBuilder(numStr).reverse().toString();
            return numStr.equals(reversedStr);
        }
    }

    // Transformed Implementation
    public static class TransformedImpl {
        public static Entry<Integer, Integer> countEvenOddPalindromes(int limit) {
            boolean[] isPalindrome = new boolean[limit + 1];
            
            for (int i = 1; i <= limit; i++) {
                String numStr = Integer.toString(i);
                int len = numStr.length();
                isPalindrome[i] = true;
                for (int j = 0; j < len / 2; j++) {
                    if (numStr.charAt(j) != numStr.charAt(len - j - 1)) {
                        isPalindrome[i] = false;
                        break;
                    }
                }
            }

            int evenCount = 0;
            int oddCount = 0;

            for (int i = 1; i <= limit; i++) {
                if (i % 2 == 1 && isPalindrome[i]) {
                    oddCount++;
                } else if (i % 2 == 0 && isPalindrome[i]) {
                    evenCount++;
                }
            }

            return new SimpleEntry<>(evenCount, oddCount);
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(1),
            Arguments.of(10),
            Arguments.of(20),
            Arguments.of(50),
            Arguments.of(100),
            Arguments.of(200),
            Arguments.of(300),
            Arguments.of(400),
            Arguments.of(500),
            Arguments.of(1000)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testEvenOddPalindrome(int n) {
        int[] originalResult = OriginalImpl.evenOddPalindrome(n);
        Entry<Integer, Integer> transformedResult = TransformedImpl.countEvenOddPalindromes(n);

        assertEquals(originalResult[0], (int) transformedResult.getKey());
        assertEquals(originalResult[1], (int) transformedResult.getValue());
    }
}