import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_117 {

    // Source Code
    static class HumanEval_117_Source {
        public List<String> selectWords(String s, int n) {
            List<String> result = new ArrayList<>();
            String[] words = s.split(" ");
            for (String word : words) {
                int nConsonants = 0;
                for (int i = 0; i < word.length(); i++) {
                    char c = Character.toLowerCase(word.charAt(i));
                    if (!"aeiou".contains(String.valueOf(c))) {
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
        public List<String> selectWords(String s, int n) {
            List<String> result = new ArrayList<>();
            String[] words = s.split(" ");

            for (String word : words) {
                int nConsonants = 0;
                int index = 0;
                while (index < word.length()) {
                    if (!"aeiou".contains(Character.toString(word.charAt(index)).toLowerCase())) {
                        nConsonants++;
                    }
                    index++;
                }

                if (nConsonants == n) {
                    result.add(word);
                }
            }

            return result;
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
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[0][0], (int) testCases[0][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[1][0], (int) testCases[1][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[2][0], (int) testCases[2][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[3][0], (int) testCases[3][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[4][0], (int) testCases[4][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[5][0], (int) testCases[5][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[6][0], (int) testCases[6][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[7][0], (int) testCases[7][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[8][0], (int) testCases[8][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_117_Source().selectWords((String) testCases[9][0], (int) testCases[9][1]), 
                     new HumanEval_117_Transformed().selectWords((String) testCases[9][0], (int) testCases[9][1]));
    }
}