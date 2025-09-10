import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_18 {

    // Source Code
    public static int howManyTimes(String string, String substring) {
        int times = 0;
        int index = 0;

        while ((index = string.indexOf(substring, index)) != -1) {
            times++;
            index++; // Move one character forward to allow overlapping matches
        }

        return times;
    }

    // Transformed Code
    public static int countOccurrences(String mainStr, String subStr) {
        int occurrenceCount = 0;
        int index = 0;

        while (index <= mainStr.length() - subStr.length()) {
            if (mainStr.substring(index, index + subStr.length()).equals(subStr)) {
                occurrenceCount++;
            }
            index++;
        }

        return occurrenceCount;
    }

    // Test Cases
    private static final String[][] testCases = {
        {"hello", "l"},          // Expected: 2
        {"banana", "na"},        // Expected: 2
        {"aaaa", "aa"},          // Expected: 3
        {"abcde", "f"},          // Expected: 0
        {"mississippi", "issi"}, // Expected: 1
        {"abababa", "aba"},      // Expected: 2
        {"", ""},                // Expected: 1 (empty substring in empty string)
        {"a", ""},               // Expected: 2 (empty substring in non-empty string)
        {"hello world", "o w"},  // Expected: 1
        {"abc", "d"}             // Expected: 0
    };

    @Test
    public void test_0() {
        assertEquals(howManyTimes(testCases[0][0], testCases[0][1]), countOccurrences(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(howManyTimes(testCases[1][0], testCases[1][1]), countOccurrences(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(howManyTimes(testCases[2][0], testCases[2][1]), countOccurrences(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(howManyTimes(testCases[3][0], testCases[3][1]), countOccurrences(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(howManyTimes(testCases[4][0], testCases[4][1]), countOccurrences(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(howManyTimes(testCases[5][0], testCases[5][1]), countOccurrences(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(howManyTimes(testCases[6][0], testCases[6][1]), countOccurrences(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(howManyTimes(testCases[7][0], testCases[7][1]), countOccurrences(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(howManyTimes(testCases[8][0], testCases[8][1]), countOccurrences(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(howManyTimes(testCases[9][0], testCases[9][1]), countOccurrences(testCases[9][0], testCases[9][1]));
    }
}