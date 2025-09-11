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
        int n = s.length();

        for (int i = 0; i < n; i += 3) {
            String group = s.substring(i, Math.min(i + 3, n));
            if (group.length() == 3) {
                result.append(group.charAt(1)).append(group.charAt(2)).append(group.charAt(0));
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
    /**
     * Returns encoded string by cycling groups of three characters.
     */
    public static String transformCyclicString(String inputString) {
        // Divide the string into chunks of three characters
        int length = inputString.length();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < length; i += 3) {
            String chunk = inputString.substring(i, Math.min(length, i + 3));
            
            // Rotate each chunk if it contains exactly three characters
            if (chunk.length() == 3) {
                result.append(chunk.substring(1)).append(chunk.charAt(0));
            } else {
                result.append(chunk);
            }
        }
        
        return result.toString();
    }

    /**
     * Decodes the string that was encoded using the transformCyclicString method.
     */
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