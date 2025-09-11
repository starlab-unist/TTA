import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[0])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[1])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[2])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[3])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[4])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[5])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[6])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[7])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[8])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[8])));
    }

    @Test
    public void test_9() {
        assertEquals(java.util.Arrays.toString(HumanEval_107_Source.evenOddPalindrome(testCases[9])), 
                     java.util.Arrays.toString(new HumanEval_107_Transformed().countEvenOddPalindromes(testCases[9])));
    }
}