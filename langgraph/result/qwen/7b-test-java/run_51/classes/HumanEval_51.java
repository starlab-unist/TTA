import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_51 {

    // Source Code
    static class HumanEval_51_Source {
        public static String removeVowels(String text) {
            StringBuilder result = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (!"aeiouAEIOU".contains(String.valueOf(c))) {
                    result.append(c);
                }
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class HumanEval_51_Transformed {
        public static String removeVowels(String inputString) {
            Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            StringBuilder result = new StringBuilder();
            int index = 0;

            while (index < inputString.length()) {
                char ch = inputString.charAt(index);
                if (!vowels.contains(ch)) {
                    result.append(ch);
                }
                index++;
            }

            return result.toString();
        }
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
        assertEquals(HumanEval_51_Source.removeVowels(testCases[0]), HumanEval_51_Transformed.removeVowels(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_51_Source.removeVowels(testCases[1]), HumanEval_51_Transformed.removeVowels(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_51_Source.removeVowels(testCases[2]), HumanEval_51_Transformed.removeVowels(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_51_Source.removeVowels(testCases[3]), HumanEval_51_Transformed.removeVowels(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_51_Source.removeVowels(testCases[4]), HumanEval_51_Transformed.removeVowels(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_51_Source.removeVowels(testCases[5]), HumanEval_51_Transformed.removeVowels(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_51_Source.removeVowels(testCases[6]), HumanEval_51_Transformed.removeVowels(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_51_Source.removeVowels(testCases[7]), HumanEval_51_Transformed.removeVowels(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_51_Source.removeVowels(testCases[8]), HumanEval_51_Transformed.removeVowels(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_51_Source.removeVowels(testCases[9]), HumanEval_51_Transformed.removeVowels(testCases[9]));
    }
}