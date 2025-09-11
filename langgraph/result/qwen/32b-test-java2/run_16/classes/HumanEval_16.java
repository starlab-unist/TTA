import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_16 {

    // Source Code
    static class HumanEval_16_Source {
        public static int countDistinctCharacters(String string) {
            Set<Character> distinctChars = new HashSet<>();
            for (char c : string.toLowerCase().toCharArray()) {
                distinctChars.add(c);
            }
            return distinctChars.size();
        }
    }

    // Transformed Code
    static class HumanEval_16_Transformed {
        public int determineUniqueCharCount(String inputText) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : inputText.toLowerCase().toCharArray()) {
                uniqueChars.add(c);
            }
            return uniqueChars.size();
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello",
        "Python",
        "OpenAI",
        "AaBbCc",
        "1234567890",
        "!@#$%^&*()",
        "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz",
        "The quick brown fox jumps over the lazy dog",
        "",
        " ",
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[0]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[1]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[2]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[3]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[4]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[5]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[6]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[7]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[8]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_16_Source.countDistinctCharacters(testCases[9]), 
                     new HumanEval_16_Transformed().determineUniqueCharCount(testCases[9]));
    }
}