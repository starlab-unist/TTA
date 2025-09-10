import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Necessary import statements for Stream and Arguments
import java.util.stream.Stream;

public class HumanEval_107 {

    // Source Code
    static class HumanEval_107_Source {
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
            String str = Integer.toString(n);
            int len = str.length();
            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_107_Transformed {
        public int[] countEvenOddPalindromes(int limit) {
            int evenCount = 0;
            int oddCount = 0;

            int currentNumber = 1;
            while (currentNumber <= limit) {
                if (currentNumber % 2 == 1 && checkPalindrome(currentNumber)) {
                    oddCount++;
                } else if (currentNumber % 2 == 0 && checkPalindrome(currentNumber)) {
                    evenCount++;
                }
                currentNumber++;
            }

            return new int[]{evenCount, oddCount};
        }

        private boolean checkPalindrome(int number) {
            String str = Integer.toString(number);
            int len = str.length();
            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
        1,
        10,
        20,
        50,
        100,
        200,
        300,
        400,
        500,
        1000
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void evenOddPalindrome_vs_countEvenOddPalindromes(Integer input) {
        int[] resultSource = HumanEval_107_Source.evenOddPalindrome(input);
        int[] resultTransformed = new HumanEval_107_Transformed().countEvenOddPalindromes(input);

        assertEquals(
            resultSource[0],
            resultTransformed[0]
        );
        assertEquals(
            resultSource[1],
            resultTransformed[1]
        );
    }
}