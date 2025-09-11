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
    static class HumanEval_10_Source {
        /**
         * Test if given string is a palindrome
         */
        public static boolean isPalindrome(String string) {
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
    }

    // Transformed Code
    static class HumanEval_10_Transformed {
        /** Determine if the provided sequence is a palindrome */
        public boolean checkPalindrome(String sequence) {
            return sequence.equals(new StringBuilder(sequence).reverse().toString());
        }

        public String constructPalindrome(String inputStr) {
            if (inputStr == null || inputStr.isEmpty()) {
                return "";
            }

            int suffixStartIndex = 0;

            while (!checkPalindrome(inputStr.substring(suffixStartIndex))) {
                suffixStartIndex++;
            }

            return inputStr + new StringBuilder(inputStr.substring(0, suffixStartIndex)).reverse().toString();
        }
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
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[0]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[0]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[0]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[1]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[1]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[1]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[2]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[2]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[2]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[3]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[3]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[3]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[4]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[4]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[4]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[5]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[5]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[5]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[6]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[6]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[6]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[7]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[7]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[7]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[8]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[8]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[8]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_10_Source.isPalindrome(testCases[9]), 
                     new HumanEval_10_Transformed().checkPalindrome(testCases[9]));
        assertEquals(HumanEval_10_Source.makePalindrome(testCases[9]), 
                     new HumanEval_10_Transformed().constructPalindrome(testCases[9]));
    }
}