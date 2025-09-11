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
    static class HumanEval_38_Source {
        public static String encodeCyclic(String s) {
            StringBuilder encoded = new StringBuilder();
            int length = s.length();

            for (int i = 0; i < length; i += 3) {
                String group = s.substring(i, Math.min(i + 3, length));
                if (group.length() == 3) {
                    group = group.substring(1) + group.charAt(0);
                }
                encoded.append(group);
            }

            return encoded.toString();
        }

        public static String decodeCyclic(String s) {
            return encodeCyclic(encodeCyclic(s));
        }
    }

    // Transformed Code
    static class HumanEval_38_Transformed {
        /**
         * Returns encoded string by cycling groups of three characters.
         */
        public static String transformCyclicString(String inputString) {
            // Divide the string into chunks of three characters
            StringBuilder[] chunks = new StringBuilder[(inputString.length() + 2) / 3];
            for (int i = 0; i < inputString.length(); i += 3) {
                chunks[i / 3] = new StringBuilder(inputString.substring(i, Math.min(i + 3, inputString.length())));
            }

            // Rotate each chunk if it contains exactly three characters
            for (int i = 0; i < chunks.length; i++) {
                if (chunks[i].length() == 3) {
                    char firstChar = chunks[i].charAt(0);
                    chunks[i].deleteCharAt(0);
                    chunks[i].append(firstChar);
                }
            }

            // Join all chunks back into a single string
            StringBuilder result = new StringBuilder();
            for (StringBuilder chunk : chunks) {
                result.append(chunk);
            }
            return result.toString();
        }

        public static String reverseCyclicTransformation(String encodedString) {
            // Apply the transformation twice to decode the string
            return transformCyclicString(transformCyclicString(encodedString));
        }
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
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[0]), HumanEval_38_Transformed.transformCyclicString(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[1]), HumanEval_38_Transformed.transformCyclicString(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[2]), HumanEval_38_Transformed.transformCyclicString(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[3]), HumanEval_38_Transformed.transformCyclicString(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[4]), HumanEval_38_Transformed.transformCyclicString(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[5]), HumanEval_38_Transformed.transformCyclicString(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[6]), HumanEval_38_Transformed.transformCyclicString(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[7]), HumanEval_38_Transformed.transformCyclicString(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[8]), HumanEval_38_Transformed.transformCyclicString(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_38_Source.encodeCyclic(testCases[9]), HumanEval_38_Transformed.transformCyclicString(testCases[9]));
    }
}