import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_38 {

    // Source Code
    public static String encodeCyclic(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 3) {
            String group = s.substring(i, Math.min(i + 3, s.length()));
            if (group.length() == 3) {
                result.append(group.charAt(1)).append(group.charAt(0));
            } else {
                result.append(group);
            }
        }
        return result.toString();
    }

    public static String decodeCyclic(String s) {
        return encodeCyclic(encodeCyclic(s));
    }

    // Transformed Code
    public static String transformCyclicString(String inputString) {
        StringBuilder chunks = new StringBuilder();
        for (int i = 0; i < inputString.length(); i += 3) {
            chunks.append(inputString.substring(i, Math.min(i + 3, inputString.length())));
        }
        
        // Rotate each chunk if it contains exactly three characters
        StringBuilder rotatedChunks = new StringBuilder();
        for (int i = 0; i < chunks.length(); i += 3) {
            if (i + 2 < chunks.length()) { // Ensure there are at least 3 chars left to rotate
                char firstChar = chunks.charAt(i);
                char secondChar = chunks.charAt(i + 1);
                rotatedChunks.append(secondChar).append(firstChar).append(chunks.charAt(i + 2));
            } else {
                rotatedChunks.append(chunks.substring(i));
            }
        }
        
        return rotatedChunks.toString();
    }

    public static String reverseCyclicTransformation(String encodedString) {
        // Apply the transformation twice to decode the string
        return transformCyclicString(transformCyclicString(encodedString));
    }

    // Test Cases
    private static final String[] testCases = {
        "abcdef",
        "hello world",
        "abcde",
        "a",
        "",
        "python",
        "123456789",
        "transform",
        "cyclic",
        "unittest"
    };

    @Test
    public void test_0() {
        assertEquals(encodeCyclic(testCases[0]), transformCyclicString(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(encodeCyclic(testCases[1]), transformCyclicString(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(encodeCyclic(testCases[2]), transformCyclicString(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(encodeCyclic(testCases[3]), transformCyclicString(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(encodeCyclic(testCases[4]), transformCyclicString(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(encodeCyclic(testCases[5]), transformCyclicString(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(encodeCyclic(testCases[6]), transformCyclicString(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(encodeCyclic(testCases[7]), transformCyclicString(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(encodeCyclic(testCases[8]), transformCyclicString(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(encodeCyclic(testCases[9]), transformCyclicString(testCases[9]));
    }
}