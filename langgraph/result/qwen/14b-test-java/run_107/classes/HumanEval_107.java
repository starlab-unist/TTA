import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        public static int[] countEvenOddPalindromes(int limit) {
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

        private static boolean checkPalindrome(int number) {
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
    private static final int[] testCases = {
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

    @Test
    public void test_0() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[0]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[0]));
    }

    @Test
    public void test_1() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[1]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[1]));
    }

    @Test
    public void test_2() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[2]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[2]));
    }

    @Test
    public void test_3() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[3]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[3]));
    }

    @Test
    public void test_4() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[4]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[4]));
    }

    @Test
    public void test_5() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[5]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[5]));
    }

    @Test
    public void test_6() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[6]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[6]));
    }

    @Test
    public void test_7() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[7]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[7]));
    }

    @Test
    public void test_8() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[8]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[8]));
    }

    @Test
    public void test_9() {
        assertArrayEquals(HumanEval_107_Source.evenOddPalindrome(testCases[9]), 
                          HumanEval_107_Transformed.countEvenOddPalindromes(testCases[9]));
    }
}