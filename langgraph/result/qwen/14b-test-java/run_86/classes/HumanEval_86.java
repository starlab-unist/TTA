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
    static class HumanEval_86_Source {
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
    }

    // Transformed Code
    static class HumanEval_86_Transformed {
        public static String orderWordsCharacters(String inputString) {
            StringBuilder result = new StringBuilder();
            String[] words = inputString.split(" ");
            
            for (String word : words) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sortedWord = new String(chars);
                result.append(sortedWord).append(" ");
            }
            
            return result.toString().trim();
        }
    }

    // Test Cases
    private static final String[] testCases = {
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
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[0]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[1]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[2]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[3]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[4]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[5]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[6]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[7]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[8]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_86_Source.antiShuffle(testCases[9]), 
                     HumanEval_86_Transformed.orderWordsCharacters(testCases[9]));
    }
}