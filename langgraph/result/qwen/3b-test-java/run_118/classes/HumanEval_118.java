import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_118 {

    // Source Code
    public static String getClosestVowel(String word) {
        if (word.length() < 3) {
            return "";
        }

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        for (int i = word.length() - 2; i > 0; i--) {
            if (vowels.contains(word.charAt(i))) {
                if (!vowels.contains(word.charAt(i + 1)) && !vowels.contains(word.charAt(i - 1))) {
                    return String.valueOf(word.charAt(i));
                }
            }
        }
        return "";
    }

    // Transformed Code
    public static String findNearestIsolatedVowel(String sequence) {
        if (sequence.length() < 3) {
            return "";
        }

        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int index = sequence.length() - 2;

        while (index > 0) {
            char currentChar = sequence.charAt(index);
            if (vowelSet.contains(currentChar)) {
                if (!vowelSet.contains(sequence.charAt(index + 1)) && !vowelSet.contains(sequence.charAt(index - 1))) {
                    return String.valueOf(currentChar);
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
        assertEquals(getClosestVowel(testCases[0]), findNearestIsolatedVowel(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(getClosestVowel(testCases[1]), findNearestIsolatedVowel(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(getClosestVowel(testCases[2]), findNearestIsolatedVowel(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(getClosestVowel(testCases[3]), findNearestIsolatedVowel(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(getClosestVowel(testCases[4]), findNearestIsolatedVowel(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(getClosestVowel(testCases[5]), findNearestIsolatedVowel(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(getClosestVowel(testCases[6]), findNearestIsolatedVowel(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(getClosestVowel(testCases[7]), findNearestIsolatedVowel(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(getClosestVowel(testCases[8]), findNearestIsolatedVowel(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(getClosestVowel(testCases[9]), findNearestIsolatedVowel(testCases[9]));
    }
}