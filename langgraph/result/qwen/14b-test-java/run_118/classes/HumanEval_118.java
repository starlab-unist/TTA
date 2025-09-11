import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_118 {

    // Source Code
    public static String getClosestVowel(String word) {
        if (word.length() < 3) {
            return "";
        }

        String vowels = "aeiouAEIOU";
        for (int i = word.length() - 2; i > 0; i--) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                if (vowels.indexOf(word.charAt(i + 1)) == -1 && vowels.indexOf(word.charAt(i - 1)) == -1) {
                    return String.valueOf(word.charAt(i));
                }
            }
        }
        return "";
    }

    // Transformed Code
    public static String find_nearest_isolated_vowel(String sequence) {
        if (sequence.length() < 3) {
            return "";
        }

        String vowels = "aeiouAEIOU";
        int index = sequence.length() - 3;

        while (index > 0) {
            if (vowels.indexOf(sequence.charAt(index)) != -1) {
                if (vowels.indexOf(sequence.charAt(index + 1)) == -1 && vowels.indexOf(sequence.charAt(index - 1)) == -1) {
                    return String.valueOf(sequence.charAt(index));
                }
            }
            index--;
        }

        return "";
    }

    // Test Cases
    private static final String[] testCases = {
        "hello",
        "beautiful",
        "sequence",
        "aeiou",
        "bcdfg",
        "aebcdfg",
        "racecar",
        "xylophone",
        "umbrella",
        "algorithm"
    };

    @Test
    public void test_0() {
        assertEquals(getClosestVowel(testCases[0]), find_nearest_isolated_vowel(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(getClosestVowel(testCases[1]), find_nearest_isolated_vowel(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(getClosestVowel(testCases[2]), find_nearest_isolated_vowel(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(getClosestVowel(testCases[3]), find_nearest_isolated_vowel(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(getClosestVowel(testCases[4]), find_nearest_isolated_vowel(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(getClosestVowel(testCases[5]), find_nearest_isolated_vowel(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(getClosestVowel(testCases[6]), find_nearest_isolated_vowel(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(getClosestVowel(testCases[7]), find_nearest_isolated_vowel(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(getClosestVowel(testCases[8]), find_nearest_isolated_vowel(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(getClosestVowel(testCases[9]), find_nearest_isolated_vowel(testCases[9]));
    }
}