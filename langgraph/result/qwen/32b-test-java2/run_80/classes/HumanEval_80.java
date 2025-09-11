import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_80 {

    // Source Code
    static class HumanEval_80_Source {
        public static boolean isHappy(String s) {
            if (s.length() < 3) {
                return false;
            }

            for (int i = 0; i < s.length() - 2; i++) {
                if (s.charAt(i) == s.charAt(i + 1) || 
                    s.charAt(i + 1) == s.charAt(i + 2) || 
                    s.charAt(i) == s.charAt(i + 2)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_80_Transformed {
        public boolean checkHappiness(String sequence) {
            if (sequence.length() < 3) {
                return false;
            }

            int index = 0;
            while (index < sequence.length() - 2) {
                if (sequence.charAt(index) == sequence.charAt(index + 1) ||
                    sequence.charAt(index + 1) == sequence.charAt(index + 2) ||
                    sequence.charAt(index) == sequence.charAt(index + 2)) {
                    return false;
                }
                index++;
            }

            return true;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "abc",       // happy
        "aabbcc",    // not happy
        "abac",      // happy
        "aaa",       // not happy
        "abcdefg",   // happy
        "a",         // not happy (less than 3 characters)
        "ab",        // not happy (less than 3 characters)
        "aab",       // not happy
        "abcabc",    // happy
        "aabbba"     // not happy
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[0]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[1]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[2]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[3]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[4]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[5]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[6]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[7]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[8]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_80_Source.isHappy(testCases[9]), 
                     new HumanEval_80_Transformed().checkHappiness(testCases[9]));
    }
}