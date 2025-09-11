import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_98 {

    // Source Code
    static class HumanEval_98_Source {
        public static int countUpper(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i += 2) {
                if ("AEIOU".indexOf(s.charAt(i)) != -1) {
                    count++;
                }
            }
            return count;
        }
    }

    // Transformed Code
    static class HumanEval_98_Transformed {
        public static int tallyEvenIndexVowels(String inputString) {
            int vowelCount = 0;
            int index = 0;
            while (index < inputString.length()) {
                if (index % 2 == 0 && "AEIOU".indexOf(inputString.charAt(index)) != -1) {
                    vowelCount++;
                }
                index++;
            }
            return vowelCount;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"", 0},
        {"A", 1},
        {"B", 0},
        {"AEIOU", 3},
        {"aeiou", 0},
        {"AbEcIdOfUg", 2},
        {"abcdefgHIJKL", 0},
        {"HELLOworld", 1},
        {"Python", 0},
        {"UPPERlower", 1},
        {"AEIOU" + "AEIOU" + "AEIOU" + "AEIOU" + "AEIOU", 8}, // "AEIOUAEIOUAEIOUAEIOUAEIOU"
        {"AxBxCxDxExF", 3}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[0][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[1][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[2][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[3][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[4][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[5][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[6][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[7][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[8][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[9][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[9][0]));
    }

    @Test
    public void test_10() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[10][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[10][0]));
    }

    @Test
    public void test_11() {
        assertEquals(HumanEval_98_Source.countUpper((String) testCases[11][0]), 
                     HumanEval_98_Transformed.tallyEvenIndexVowels((String) testCases[11][0]));
    }
}