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

    // Transformed Code
    public static int[] countEvenOddPalindromes(int limit) {
        int evenCount = 0;
        int oddCount = 0;

        int currentNumber = 1;
        while (currentNumber <= limit) {
            if (currentNumber % 2 != 0 && isPalindrome(currentNumber)) {
                oddCount++;
            } else if (currentNumber % 2 == 0 && isPalindrome(currentNumber)) {
                evenCount++;
            }
            currentNumber++;
        }

        return new int[]{evenCount, oddCount};
    }

    private static boolean isPalindrome(int number) {
        String numStr = Integer.toString(number);
        String reversedStr = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reversedStr);
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(1)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(1)));
    }

    @Test
    public void test_1() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(10)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(10)));
    }

    @Test
    public void test_2() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(20)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(20)));
    }

    @Test
    public void test_3() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(50)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(50)));
    }

    @Test
    public void test_4() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(100)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(100)));
    }

    @Test
    public void test_5() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(200)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(200)));
    }

    @Test
    public void test_6() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(300)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(300)));
    }

    @Test
    public void test_7() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(400)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(400)));
    }

    @Test
    public void test_8() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(500)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(500)));
    }

    @Test
    public void test_9() {
        assertEquals(java.util.Arrays.toString(evenOddPalindrome(1000)), 
                     java.util.Arrays.toString(countEvenOddPalindromes(1000)));
    }
}