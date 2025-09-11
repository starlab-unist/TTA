import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_112 {

    // Source Code
    public static String[] reverseDelete(String s, String c) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (c.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        String result = sb.toString();
        boolean isPalindrome = result.equals(new StringBuilder(result).reverse().toString());
        return new String[]{result, Boolean.toString(isPalindrome)};
    }

    // Transformed Code
    public static String[] filterAndCheckPalindrome(String inputString, String charsToRemove) {
        StringBuilder filteredStringBuilder = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (!charsToRemove.contains(String.valueOf(c))) {
                filteredStringBuilder.append(c);
            }
        }
        String filteredString = filteredStringBuilder.toString();
        boolean isPalindrome = filteredString.equals(new StringBuilder(filteredString).reverse().toString());
        return new String[]{filteredString, Boolean.toString(isPalindrome)};
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"abcba", "x"},
        {"abccba", "x"},
        {"hello", "aeiou"},
        {"racecar", ""},
        {"palindrome", "xyz"},
        {"", "a"},
        {"aabbcc", "abc"},
        {"rotor", "r"},
        {"deified", "d"},
        {"noon", "n"}
    };

    @Test
    public void test_0() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[0][0], (String) testCases[0][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[0][0], (String) testCases[0][1])));
    }

    @Test
    public void test_1() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[1][0], (String) testCases[1][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[1][0], (String) testCases[1][1])));
    }

    @Test
    public void test_2() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[2][0], (String) testCases[2][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[2][0], (String) testCases[2][1])));
    }

    @Test
    public void test_3() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[3][0], (String) testCases[3][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[3][0], (String) testCases[3][1])));
    }

    @Test
    public void test_4() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[4][0], (String) testCases[4][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[4][0], (String) testCases[4][1])));
    }

    @Test
    public void test_5() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[5][0], (String) testCases[5][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[5][0], (String) testCases[5][1])));
    }

    @Test
    public void test_6() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[6][0], (String) testCases[6][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[6][0], (String) testCases[6][1])));
    }

    @Test
    public void test_7() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[7][0], (String) testCases[7][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[7][0], (String) testCases[7][1])));
    }

    @Test
    public void test_8() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[8][0], (String) testCases[8][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[8][0], (String) testCases[8][1])));
    }

    @Test
    public void test_9() {
        assertEquals(java.util.Arrays.toString(reverseDelete((String) testCases[9][0], (String) testCases[9][1])), 
                     java.util.Arrays.toString(filterAndCheckPalindrome((String) testCases[9][0], (String) testCases[9][1])));
    }
}