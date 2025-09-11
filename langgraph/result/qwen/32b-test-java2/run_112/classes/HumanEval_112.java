import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.AbstractMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Simple Pair class implementation
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class HumanEval_112 {

    // Source Code
    static class HumanEval_112_Source {
        public static AbstractMap.SimpleEntry<String, Boolean> reverseDelete(String s, String c) {
            StringBuilder filtered = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (c.indexOf(ch) == -1) {
                    filtered.append(ch);
                }
            }
            String result = filtered.toString();
            String reversed = filtered.reverse().toString();
            return new AbstractMap.SimpleEntry<>(result, result.equals(reversed));
        }
    }

    // Transformed Code
    static class HumanEval_112_Transformed {
        public static Pair<String, Boolean> filterAndCheckPalindrome(String inputString, String charsToRemove) {
            StringBuilder filteredString = new StringBuilder();
            for (char character : inputString.toCharArray()) {
                if (charsToRemove.indexOf(character) == -1) {
                    filteredString.append(character);
                }
            }
            boolean isPalindrome = filteredString.toString().equals(filteredString.reverse().toString());
            return new Pair<>(filteredString.toString(), isPalindrome);
        }
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
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[0][0], (String) testCases[0][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[1][0], (String) testCases[1][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[2][0], (String) testCases[2][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[3][0], (String) testCases[3][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[4][0], (String) testCases[4][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[5][0], (String) testCases[5][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[6][0], (String) testCases[6][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[7][0], (String) testCases[7][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[8][0], (String) testCases[8][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_112_Source.reverseDelete((String) testCases[9][0], (String) testCases[9][1]), 
                     HumanEval_112_Transformed.filterAndCheckPalindrome((String) testCases[9][0], (String) testCases[9][1]));
    }
}