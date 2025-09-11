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

public class HumanEval_16 {

    // Source Code
    public static int countDistinctCharacters(String string) {
        return (int) string.toLowerCase().chars().distinct().count();
    }

    // Transformed Code
    public static int determineUniqueCharCount(String inputText) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : inputText.toLowerCase().toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
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
        assertEquals(countDistinctCharacters(testCases[0]), determineUniqueCharCount(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(countDistinctCharacters(testCases[1]), determineUniqueCharCount(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(countDistinctCharacters(testCases[2]), determineUniqueCharCount(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(countDistinctCharacters(testCases[3]), determineUniqueCharCount(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(countDistinctCharacters(testCases[4]), determineUniqueCharCount(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(countDistinctCharacters(testCases[5]), determineUniqueCharCount(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(countDistinctCharacters(testCases[6]), determineUniqueCharCount(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(countDistinctCharacters(testCases[7]), determineUniqueCharCount(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(countDistinctCharacters(testCases[8]), determineUniqueCharCount(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(countDistinctCharacters(testCases[9]), determineUniqueCharCount(testCases[9]));
    }
}