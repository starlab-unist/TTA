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
    public static Object[] reverseDelete(String s, String c) {
        StringBuilder filtered = new StringBuilder();
        for (char charInS : s.toCharArray()) {
            if (c.indexOf(charInS) == -1) {
                filtered.append(charInS);
            }
        }
        String result = filtered.toString();
        boolean isPalindrome = result.equals(filtered.reverse().toString());
        return new Object[]{result, isPalindrome};
    }

    // Transformed Code
    public static String[] filterAndCheckPalindrome(String inputString, String charsToRemove) {
        StringBuilder filteredString = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            if (charsToRemove.indexOf(character) == -1) {
                filteredString.append(character);
            }
        }
        
        String s = filteredString.toString();
        boolean isPalindrome = s.equals(new StringBuilder(s).reverse().toString());
        
        return new String[]{s, Boolean.toString(isPalindrome)};
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