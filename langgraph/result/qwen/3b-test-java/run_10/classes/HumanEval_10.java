import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_10 {

    // Source Code
    public static boolean isPalindrome(String string) {
        // Test if given string is a palindrome
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    public static String makePalindrome(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }

        int beginningOfSuffix = 0;

        while (!isPalindrome(string.substring(beginningOfSuffix))) {
            beginningOfSuffix++;
        }

        return string + new StringBuilder(string.substring(0, beginningOfSuffix)).reverse().toString();
    }

    // Transformed Code
    public static boolean checkPalindrome(String sequence) {
        // Determine if the provided sequence is a palindrome
        return sequence.equals(new StringBuilder(sequence).reverse().toString());
    }

    public static String constructPalindrome(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return "";
        }

        int suffixStartIndex = 0;

        while (!checkPalindrome(inputStr.substring(suffixStartIndex))) {
            suffixStartIndex++;
        }

        return inputStr + new StringBuilder(inputStr.substring(0, suffixStartIndex)).reverse().toString();
    }

    // Test Cases
    private static final String[] testCases = {
        "racecar",
        "hello",
        "",
        "a",
        "abba",
        "abcba",
        "abc",
        "noon",
        "level",
        "deified"
    };

    @Test
    public void test_0() {
        assertEquals(isPalindrome(testCases[0]), checkPalindrome(testCases[0]));
        assertEquals(makePalindrome(testCases[0]), constructPalindrome(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(isPalindrome(testCases[1]), checkPalindrome(testCases[1]));
        assertEquals(makePalindrome(testCases[1]), constructPalindrome(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(isPalindrome(testCases[2]), checkPalindrome(testCases[2]));
        assertEquals(makePalindrome(testCases[2]), constructPalindrome(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(isPalindrome(testCases[3]), checkPalindrome(testCases[3]));
        assertEquals(makePalindrome(testCases[3]), constructPalindrome(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(isPalindrome(testCases[4]), checkPalindrome(testCases[4]));
        assertEquals(makePalindrome(testCases[4]), constructPalindrome(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(isPalindrome(testCases[5]), checkPalindrome(testCases[5]));
        assertEquals(makePalindrome(testCases[5]), constructPalindrome(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(isPalindrome(testCases[6]), checkPalindrome(testCases[6]));
        assertEquals(makePalindrome(testCases[6]), constructPalindrome(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(isPalindrome(testCases[7]), checkPalindrome(testCases[7]));
        assertEquals(makePalindrome(testCases[7]), constructPalindrome(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(isPalindrome(testCases[8]), checkPalindrome(testCases[8]));
        assertEquals(makePalindrome(testCases[8]), constructPalindrome(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(isPalindrome(testCases[9]), checkPalindrome(testCases[9]));
        assertEquals(makePalindrome(testCases[9]), constructPalindrome(testCases[9]));
    }
}