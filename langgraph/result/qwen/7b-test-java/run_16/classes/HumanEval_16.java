import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_16 {

    // Source Code
    public static int countDistinctCharacters_Source(String string) {
        return new HashSet<>(Set.of(string.toLowerCase().split(""))).size();
    }

    // Transformed Code
    public static int countDistinctCharacters_Transformed(String inputText) {
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
        assertEquals(countDistinctCharacters_Source(testCases[0]), countDistinctCharacters_Transformed(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(countDistinctCharacters_Source(testCases[1]), countDistinctCharacters_Transformed(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(countDistinctCharacters_Source(testCases[2]), countDistinctCharacters_Transformed(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(countDistinctCharacters_Source(testCases[3]), countDistinctCharacters_Transformed(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(countDistinctCharacters_Source(testCases[4]), countDistinctCharacters_Transformed(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(countDistinctCharacters_Source(testCases[5]), countDistinctCharacters_Transformed(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(countDistinctCharacters_Source(testCases[6]), countDistinctCharacters_Transformed(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(countDistinctCharacters_Source(testCases[7]), countDistinctCharacters_Transformed(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(countDistinctCharacters_Source(testCases[8]), countDistinctCharacters_Transformed(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(countDistinctCharacters_Source(testCases[9]), countDistinctCharacters_Transformed(testCases[9]));
    }
}