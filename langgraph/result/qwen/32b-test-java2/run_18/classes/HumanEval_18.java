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
    static class HumanEval_18_Source {
        public static int howManyTimes(String string, String substring) {
            int times = 0;

            for (int i = 0; i <= string.length() - substring.length(); i++) {
                if (string.substring(i, i + substring.length()).equals(substring)) {
                    times++;
                }
            }

            return times;
        }
    }

    // Transformed Code
    static class HumanEval_18_Transformed {
        public int countOccurrences(String mainStr, String subStr) {
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
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[0][0], (String) testCases[0][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[1][0], (String) testCases[1][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[2][0], (String) testCases[2][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[3][0], (String) testCases[3][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[4][0], (String) testCases[4][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[5][0], (String) testCases[5][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[6][0], (String) testCases[6][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[7][0], (String) testCases[7][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[8][0], (String) testCases[8][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_18_Source.howManyTimes((String) testCases[9][0], (String) testCases[9][1]), 
                     new HumanEval_18_Transformed().countOccurrences((String) testCases[9][0], (String) testCases[9][1]));
    }
}