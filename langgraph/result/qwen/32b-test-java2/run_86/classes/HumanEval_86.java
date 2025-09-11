import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_86 {

    // Source Code
    public static String antiShuffle(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            result.append(new String(chars)).append(" ");
        }
        
        return result.toString().trim();
    }

    // Transformed Code
    public String orderWordsCharacters(String inputString) {
        StringBuilder result = new StringBuilder();
        String[] words = inputString.split(" ");
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(sortedWord);
        }
        
        return result.toString();
    }

    // Test Cases
    private static final Object[] testCases = {
        "hello world",
        "python is fun",
        "openai gpt",
        "shuffle this string",
        "keep it sorted",
        "characters in words",
        "simple test case",
        "another example here",
        "singleword",
        ""
    };

    @Test
    public void test_0() {
        assertEquals(antiShuffle((String) testCases[0]), new HumanEval_86().orderWordsCharacters((String) testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(antiShuffle((String) testCases[1]), new HumanEval_86().orderWordsCharacters((String) testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(antiShuffle((String) testCases[2]), new HumanEval_86().orderWordsCharacters((String) testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(antiShuffle((String) testCases[3]), new HumanEval_86().orderWordsCharacters((String) testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(antiShuffle((String) testCases[4]), new HumanEval_86().orderWordsCharacters((String) testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(antiShuffle((String) testCases[5]), new HumanEval_86().orderWordsCharacters((String) testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(antiShuffle((String) testCases[6]), new HumanEval_86().orderWordsCharacters((String) testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(antiShuffle((String) testCases[7]), new HumanEval_86().orderWordsCharacters((String) testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(antiShuffle((String) testCases[8]), new HumanEval_86().orderWordsCharacters((String) testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(antiShuffle((String) testCases[9]), new HumanEval_86().orderWordsCharacters((String) testCases[9]));
    }
}