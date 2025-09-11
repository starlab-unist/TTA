import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_154 {

    // Source Code
    public static boolean cycpattern_check(String a, String b) {
        int l = b.length();
        String pat = b + b;
        for (int i = 0; i <= a.length() - l; i++) {
            for (int j = 0; j <= l; j++) {
                if (a.substring(i, i + l).equals(pat.substring(j, j + l))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Transformed Code
    public static boolean verifyCyclicPattern(String sequence, String pattern) {
        int patternLength = pattern.length();
        String doubledPattern = pattern + pattern;
        int index = 0;

        while (index <= sequence.length() - patternLength) {
            int subIndex = 0;
            while (subIndex <= patternLength) {
                if (sequence.substring(index, index + patternLength).equals(doubledPattern.substring(subIndex, subIndex + patternLength))) {
                    return true;
                }
                subIndex += 1;
            }
            index += 1;
        }

        return false;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"abc", "cab"},       // Should be True (cyclical)
        {"hello", "ell"},     // Should be True (substring match)
        {"abcd", "dabc"},     // Should be True (cyclical)
        {"abcd", "abdc"},     // Should be False (not cyclical)
        {"aaaa", "aa"},       // Should be True (repeated pattern)
        {"abcdefg", "efga"},  // Should be True (cyclical)
        {"abcdefg", "gfedcba"},// Should be False (reverse not same as cyclic shift)
        {"", ""},             // Should be True (both empty strings)
        {"a", "b"},           // Should be False (no match)
        {"pattern", ""},      // Should be True (empty pattern matches everything in sequence)
    };

    @Test
    public void test_0() {
        assertEquals(cycpattern_check((String) testCases[0][0], (String) testCases[0][1]), 
                     verifyCyclicPattern((String) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(cycpattern_check((String) testCases[1][0], (String) testCases[1][1]), 
                     verifyCyclicPattern((String) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(cycpattern_check((String) testCases[2][0], (String) testCases[2][1]), 
                     verifyCyclicPattern((String) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(cycpattern_check((String) testCases[3][0], (String) testCases[3][1]), 
                     verifyCyclicPattern((String) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(cycpattern_check((String) testCases[4][0], (String) testCases[4][1]), 
                     verifyCyclicPattern((String) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(cycpattern_check((String) testCases[5][0], (String) testCases[5][1]), 
                     verifyCyclicPattern((String) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(cycpattern_check((String) testCases[6][0], (String) testCases[6][1]), 
                     verifyCyclicPattern((String) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(cycpattern_check((String) testCases[7][0], (String) testCases[7][1]), 
                     verifyCyclicPattern((String) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(cycpattern_check((String) testCases[8][0], (String) testCases[8][1]), 
                     verifyCyclicPattern((String) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(cycpattern_check((String) testCases[9][0], (String) testCases[9][1]), 
                     verifyCyclicPattern((String) testCases[9][0], (String) testCases[9][1]));
    }
}