import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_50 {

    // Source Code
    static class HumanEval_50_Source {
        public static String encodeShift(String s) {
            StringBuilder encoded = new StringBuilder();
            for (char ch : s.toCharArray()) {
                encoded.append((char)(((ch + 5 - 'a') % 26) + 'a'));
            }
            return encoded.toString();
        }

        public static String decodeShift(String s) {
            StringBuilder decoded = new StringBuilder();
            for (char ch : s.toCharArray()) {
                decoded.append((char)(((ch - 5 - 'a') % 26) + 'a'));
            }
            return decoded.toString();
        }
    }

    // Transformed Code
    static class HumanEval_50_Transformed {
        public static String encodeShift(String inputString) {
            StringBuilder encodedChars = new StringBuilder();
            for (char character : inputString.toCharArray()) {
                char shiftedChar = (char)(((character + 5 - 'a') % 26) + 'a');
                encodedChars.append(shiftedChar);
            }
            return encodedChars.toString();
        }

        public static String decodeShift(String encodedString) {
            StringBuilder decodedChars = new StringBuilder();
            int index = 0;
            while (index < encodedString.length()) {
                char originalChar = (char)(((encodedString.charAt(index) - 5 - 'a') % 26) + 'a');
                decodedChars.append(originalChar);
                index++;
            }
            return decodedChars.toString();
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "abcde",
        "fghij",
        "vwxyz",
        "hello",
        "world",
        "python",
        "unittest",
        "shift",
        "encode",
        "decode"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[0]), HumanEval_50_Transformed.encodeShift(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[1]), HumanEval_50_Transformed.encodeShift(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[2]), HumanEval_50_Transformed.encodeShift(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[3]), HumanEval_50_Transformed.encodeShift(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[4]), HumanEval_50_Transformed.encodeShift(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[5]), HumanEval_50_Transformed.encodeShift(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[6]), HumanEval_50_Transformed.encodeShift(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[7]), HumanEval_50_Transformed.encodeShift(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[8]), HumanEval_50_Transformed.encodeShift(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_50_Source.encodeShift(testCases[9]), HumanEval_50_Transformed.encodeShift(testCases[9]));
    }
}