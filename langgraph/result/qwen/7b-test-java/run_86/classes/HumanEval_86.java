import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_86 {

    // Source Code
    public static String antiShuffle(String s) {
        return String.join(" ", 
            java.util.Arrays.stream(s.split(" "))
                .map(str -> new StringBuilder(new String(
                    str.chars().sorted().toArray()))
                .toString())
                .toArray(String[]::new));
    }

    // Transformed Code
    public static String orderWordsCharacters(String inputString) {
        String[] words = inputString.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            result.append(new String(characters)).append(" ");
        }
        
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        
        return result.toString();
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
        assertEquals(antiShuffle(testCases[0]), orderWordsCharacters(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(antiShuffle(testCases[1]), orderWordsCharacters(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(antiShuffle(testCases[2]), orderWordsCharacters(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(antiShuffle(testCases[3]), orderWordsCharacters(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(antiShuffle(testCases[4]), orderWordsCharacters(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(antiShuffle(testCases[5]), orderWordsCharacters(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(antiShuffle(testCases[6]), orderWordsCharacters(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(antiShuffle(testCases[7]), orderWordsCharacters(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(antiShuffle(testCases[8]), orderWordsCharacters(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(antiShuffle(testCases[9]), orderWordsCharacters(testCases[9]));
    }
}