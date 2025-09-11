import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Set;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_54 {

    // Source Code
    static class HumanEval_54_Source {
        public static boolean sameChars(String s0, String s1) {
            Set<Character> set0 = new HashSet<>();
            for (char c : s0.toCharArray()) {
                set0.add(c);
            }
            
            Set<Character> set1 = new HashSet<>();
            for (char c : s1.toCharArray()) {
                set1.add(c);
            }
            
            return set0.equals(set1);
        }
    }

    // Transformed Code
    static class HumanEval_54_Transformed {
        public boolean sameChars(String s0, String s1) {
            Set<Character> setOfCharsOne = new HashSet<>();
            Set<Character> setOfCharsTwo = new HashSet<>();

            for (char c : s0.toCharArray()) {
                setOfCharsOne.add(c);
            }

            for (char c : s1.toCharArray()) {
                setOfCharsTwo.add(c);
            }

            return setOfCharsOne.equals(setOfCharsTwo);
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"hello", "olleh"},
        {"world", "dlrow"},
        {"python", "nothyp"},
        {"openai", "ipaneo"},
        {"", ""},
        {"a", "a"},
        {"ab", "ba"},
        {"abc", "cba"},
        {"abcd", "dcba"},
        {"xyz", "zyx"}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[0][0], testCases[0][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[1][0], testCases[1][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[2][0], testCases[2][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[3][0], testCases[3][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[4][0], testCases[4][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[5][0], testCases[5][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[6][0], testCases[6][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[7][0], testCases[7][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[8][0], testCases[8][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_54_Source.sameChars(testCases[9][0], testCases[9][1]), 
                     new HumanEval_54_Transformed().sameChars(testCases[9][0], testCases[9][1]));
    }
}