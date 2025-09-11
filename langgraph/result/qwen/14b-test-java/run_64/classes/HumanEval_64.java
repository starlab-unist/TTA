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
    static class HumanEval_64_Source {
        public static int vowelsCount(String s) {
            String vowels = "aeiouAEIOU";
            int nVowels = 0;
            for (char c : s.toCharArray()) {
                if (vowels.indexOf(c) != -1) {
                    nVowels++;
                }
            }
            if (s.charAt(s.length() - 1) == 'y' || s.charAt(s.length() - 1) == 'Y') {
                nVowels++;
            }
            return nVowels;
        }
    }

    // Transformed Code
    static class HumanEval_64_Transformed {
        public static int tallyVowels(String inputString) {
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
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[0]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[0]));
    }

    @Test
    public void test_hello_upper() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[1]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[1]));
    }

    @Test
    public void test_sky() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[2]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[2]));
    }

    @Test
    public void test_syzygy() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[3]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[3]));
    }

    @Test
    public void test_rhythm() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[4]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[4]));
    }

    @Test
    public void test_aeiouy_upper() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[5]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[5]));
    }

    @Test
    public void test_alphabet_lowercase() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[6]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[6]));
    }

    @Test
    public void test_alphabet_uppercase() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[7]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[7]));
    }

    @Test
    public void test_python() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[8]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[8]));
    }

    @Test
    public void test_empty_string() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[9]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[9]));
        assertEquals(HumanEval_64_Source.vowelsCount(""), 0);  // Expected number of vowels in an empty string is 0.
    }

    @Test
    public void test_single_a() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[10]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[10]));
    }

    @Test
    public void test_single_Y_upper() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[11]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[11]));
        assertEquals(HumanEval_64_Source.vowelsCount("Y"), 1);  // 'Y' is a vowel and the last character.
    }

    @Test
    public void test_single_y_lower() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[12]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[12]));
        assertEquals(HumanEval_64_Source.vowelsCount("y"), 1);  // 'y' is a vowel and the last character.
    }

    @Test
    public void test_bcd() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[13]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[13]));
    }

    @Test
    public void test_aeiou() {
        assertEquals(HumanEval_64_Source.vowelsCount(testCases[14]), 
                     HumanEval_64_Transformed.tallyVowels(testCases[14]));
    }
}