import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_64 {

    // Source Code
    public static int vowelsCount(String s) {
        String vowels = "aeiouAEIOU";
        int nVowels = 0;
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                nVowels++;
            }
        }
        if (s.endsWith("y") || s.endsWith("Y")) {
            nVowels++;
        }
        return nVowels;
    }

    // Transformed Code
    public int tallyVowels(String inputString) {
        String vowelSet = "aeiouAEIOU";
        int vowelCounter = 0;

        for (char character : inputString.toCharArray()) {
            if (vowelSet.indexOf(character) != -1) {
                vowelCounter++;
            }
        }

        if (inputString.endsWith("y") || inputString.endsWith("Y")) {
            vowelCounter++;
        }

        return vowelCounter;
    }

    // Test Cases
    private static final String[] testCases = {
        "hello",
        "HELLO",
        "sky",
        "SYZYGY",
        "rhythm",
        "AEIOUY",
        "abcdefghijklmnopqrstuvwxyz",
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
        "Python",
        "",
        "a",
        "Y",
        "y",
        "bcd",
        "aeiou"
    };

    @Test
    public void test_hello() {
        assertEquals(vowelsCount(testCases[0]), new HumanEval_64().tallyVowels(testCases[0]));
    }

    @Test
    public void test_hello_upper() {
        assertEquals(vowelsCount(testCases[1]), new HumanEval_64().tallyVowels(testCases[1]));
    }

    @Test
    public void test_sky() {
        assertEquals(vowelsCount(testCases[2]), new HumanEval_64().tallyVowels(testCases[2]));
    }

    @Test
    public void test_syzygy() {
        assertEquals(vowelsCount(testCases[3]), new HumanEval_64().tallyVowels(testCases[3]));
    }

    @Test
    public void test_rhythm() {
        assertEquals(vowelsCount(testCases[4]), new HumanEval_64().tallyVowels(testCases[4]));
    }

    @Test
    public void test_aeiouy_upper() {
        assertEquals(vowelsCount(testCases[5]), new HumanEval_64().tallyVowels(testCases[5]));
    }

    @Test
    public void test_alphabet_lowercase() {
        assertEquals(vowelsCount(testCases[6]), new HumanEval_64().tallyVowels(testCases[6]));
    }

    @Test
    public void test_alphabet_uppercase() {
        assertEquals(vowelsCount(testCases[7]), new HumanEval_64().tallyVowels(testCases[7]));
    }

    @Test
    public void test_python() {
        assertEquals(vowelsCount(testCases[8]), new HumanEval_64().tallyVowels(testCases[8]));
    }

    @Test
    public void test_empty_string() {
        assertEquals(vowelsCount(testCases[9]), new HumanEval_64().tallyVowels(testCases[9]));
        assertEquals(vowelsCount(""), 0); // Expected number of vowels in an empty string is 0.
    }

    @Test
    public void test_single_a() {
        assertEquals(vowelsCount(testCases[10]), new HumanEval_64().tallyVowels(testCases[10]));
    }

    @Test
    public void test_single_Y_upper() {
        assertEquals(vowelsCount(testCases[11]), new HumanEval_64().tallyVowels(testCases[11]));
        assertEquals(vowelsCount("Y"), 1); // 'Y' is a vowel and the last character.
    }

    @Test
    public void test_single_y_lower() {
        assertEquals(vowelsCount(testCases[12]), new HumanEval_64().tallyVowels(testCases[12]));
        assertEquals(vowelsCount("y"), 1); // 'y' is a vowel and the last character.
    }

    @Test
    public void test_bcd() {
        assertEquals(vowelsCount(testCases[13]), new HumanEval_64().tallyVowels(testCases[13]));
    }

    @Test
    public void test_aeiou() {
        assertEquals(vowelsCount(testCases[14]), new HumanEval_64().tallyVowels(testCases[14]));
    }
}