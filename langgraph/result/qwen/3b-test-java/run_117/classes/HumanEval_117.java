import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_117 {

    // Source Code
    static class HumanEval_117_Source {
        public static List<String> selectWords(String s, int n) {
            List<String> result = new ArrayList<>();
            String[] words = s.split("\\s+");

            for (String word : words) {
                int nConsonants = 0;
                for (int i = 0; i < word.length(); i++) {
                    char c = Character.toLowerCase(word.charAt(i));
                    if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                        nConsonants++;
                    }
                }
                if (nConsonants == n) {
                    result.add(word);
                }
            }

            return result;
        }
    }

    // Transformed Code
    static class HumanEval_117_Transformed {
        public static List<String> filterWordsByConsonantCount(String inputString, int targetConsonantCount) {
            List<String> selectedWords = new ArrayList<>();
            String[] words = inputString.split("\\s+");

            for (String word : words) {
                int consonantCounter = 0;
                int index = 0;
                while (index < word.length()) {
                    char c = Character.toLowerCase(word.charAt(index));
                    if ("aeiou".indexOf(c) == -1) {
                        consonantCounter++;
                    }
                    index++;
                }

                if (consonantCounter == targetConsonantCount) {
                    selectedWords.add(word);
                }
            }

            return selectedWords;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"hello world", 3},
        {"this is a test", 2},
        {"consonants and vowels", 4},
        {"python programming", 5},
        {"simple words", 1},
        {"", 0},
        {"a e i o u", 0},
        {"bcd fgh jkl", 3},
        {"same same same", 3},
        {"different words here", 4}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[0][0], (int) testCases[0][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[1][0], (int) testCases[1][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[2][0], (int) testCases[2][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[3][0], (int) testCases[3][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[4][0], (int) testCases[4][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[5][0], (int) testCases[5][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[6][0], (int) testCases[6][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[7][0], (int) testCases[7][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[8][0], (int) testCases[8][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_117_Source.selectWords((String) testCases[9][0], (int) testCases[9][1]), 
                     HumanEval_117_Transformed.filterWordsByConsonantCount((String) testCases[9][0], (int) testCases[9][1]));
    }
}