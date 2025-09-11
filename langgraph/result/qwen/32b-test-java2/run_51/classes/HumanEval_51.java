import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
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
    public String stripVowels(String inputString) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < inputString.length()) {
            char ch = inputString.charAt(index);
            if (vowels.indexOf(ch) == -1) {
                result.append(ch);
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
        assertEquals(removeVowels(testCases[0]), new HumanEval_51().stripVowels(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(removeVowels(testCases[1]), new HumanEval_51().stripVowels(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(removeVowels(testCases[2]), new HumanEval_51().stripVowels(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(removeVowels(testCases[3]), new HumanEval_51().stripVowels(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(removeVowels(testCases[4]), new HumanEval_51().stripVowels(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(removeVowels(testCases[5]), new HumanEval_51().stripVowels(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(removeVowels(testCases[6]), new HumanEval_51().stripVowels(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(removeVowels(testCases[7]), new HumanEval_51().stripVowels(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(removeVowels(testCases[8]), new HumanEval_51().stripVowels(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(removeVowels(testCases[9]), new HumanEval_51().stripVowels(testCases[9]));
    }
}