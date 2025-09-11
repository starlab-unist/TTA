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

        for (int i = 0; i <= string.length() - substring.length(); i++) {
            if (string.substring(i, i + substring.length()).equals(substring)) {
                times++;
            }
        }

        return times;
    }

    // Transformed Code
    public static int count_occurrences(String main_str, String sub_str) {
        int occurrence_count = 0;
        int index = 0;

        while (index <= main_str.length() - sub_str.length()) {
            if (main_str.substring(index, index + sub_str.length()).equals(sub_str)) {
                occurrence_count += 1;
            }
            index += 1;
        }

        return occurrence_count;
    }

    // Test Cases
    private static final Object[][] testCases = {
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
        assertEquals(howManyTimes((String) testCases[0][0], (String) testCases[0][1]), 
                     count_occurrences((String) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(howManyTimes((String) testCases[1][0], (String) testCases[1][1]), 
                     count_occurrences((String) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(howManyTimes((String) testCases[2][0], (String) testCases[2][1]), 
                     count_occurrences((String) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(howManyTimes((String) testCases[3][0], (String) testCases[3][1]), 
                     count_occurrences((String) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(howManyTimes((String) testCases[4][0], (String) testCases[4][1]), 
                     count_occurrences((String) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(howManyTimes((String) testCases[5][0], (String) testCases[5][1]), 
                     count_occurrences((String) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(howManyTimes((String) testCases[6][0], (String) testCases[6][1]), 
                     count_occurrences((String) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(howManyTimes((String) testCases[7][0], (String) testCases[7][1]), 
                     count_occurrences((String) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(howManyTimes((String) testCases[8][0], (String) testCases[8][1]), 
                     count_occurrences((String) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(howManyTimes((String) testCases[9][0], (String) testCases[9][1]), 
                     count_occurrences((String) testCases[9][0], (String) testCases[9][1]));
    }
}