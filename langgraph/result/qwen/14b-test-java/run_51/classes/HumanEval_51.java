import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_51 {

    // Source Code
    public static String removeVowels(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (!"aeiouAEIOU".contains(String.valueOf(c))) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Transformed Code
    public static String strip_vowels(String input_string) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < input_string.length()) {
            char charAt = input_string.charAt(index);
            if (!vowels.contains(charAt)) {
                result.append(charAt);
            }
            index++;
        }

        return result.toString();
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello, World!",
        "Python Programming",
        "AEIOUaeiou",
        "abcdefghijklmnopqrstuvwxyz",
        "THE quick brown fox JUMPS over the LAZY dog",
        "1234567890",
        "!@#$%^&*()_+",
        "OpenAI",
        "a b c d e f g h i j",
        "This is a simple test case."
    };

    @Test
    public void test_0() {
        assertEquals(removeVowels(testCases[0]), strip_vowels(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(removeVowels(testCases[1]), strip_vowels(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(removeVowels(testCases[2]), strip_vowels(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(removeVowels(testCases[3]), strip_vowels(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(removeVowels(testCases[4]), strip_vowels(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(removeVowels(testCases[5]), strip_vowels(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(removeVowels(testCases[6]), strip_vowels(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(removeVowels(testCases[7]), strip_vowels(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(removeVowels(testCases[8]), strip_vowels(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(removeVowels(testCases[9]), strip_vowels(testCases[9]));
    }
}