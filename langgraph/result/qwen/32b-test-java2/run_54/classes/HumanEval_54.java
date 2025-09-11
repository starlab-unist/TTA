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
            Set<Character> set1 = new HashSet<>();
            
            for (char c : s0.toCharArray()) {
                set0.add(c);
            }
            
            for (char c : s1.toCharArray()) {
                set1.add(c);
            }
            
            return set0.equals(set1);
        }
    }

    // Transformed Code
    static class HumanEval_54_Transformed {
        public boolean compareCharacterSets(String stringOne, String stringTwo) {
            Set<Character> setOfCharsOne = new HashSet<>();
            Set<Character> setOfCharsTwo = new HashSet<>();
            
            for (char c : stringOne.toCharArray()) {
                setOfCharsOne.add(c);
            }
            
            for (char c : stringTwo.toCharArray()) {
                setOfCharsTwo.add(c);
            }
            
            return setOfCharsOne.equals(setOfCharsTwo);
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
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
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[0][0], (String) testCases[0][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[1][0], (String) testCases[1][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[2][0], (String) testCases[2][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[3][0], (String) testCases[3][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[4][0], (String) testCases[4][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[5][0], (String) testCases[5][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[6][0], (String) testCases[6][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[7][0], (String) testCases[7][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[8][0], (String) testCases[8][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_54_Source.sameChars((String) testCases[9][0], (String) testCases[9][1]), 
                     new HumanEval_54_Transformed().compareCharacterSets((String) testCases[9][0], (String) testCases[9][1]));
    }
}