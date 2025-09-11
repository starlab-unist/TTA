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
    public static String encodeShift(String s) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : s.toCharArray()) {
            encoded.append((char) (((ch - 'a' + 5) % 26) + 'a'));
        }
        return encoded.toString();
    }

    public static String decodeShift(String s) {
        StringBuilder decoded = new StringBuilder();
        for (char ch : s.toCharArray()) {
            decoded.append((char) (((ch - 'a' - 5 + 26) % 26) + 'a'));
        }
        return decoded.toString();
    }

    // Transformed Code
    public static String shiftEncode(String inputString) {
        StringBuilder encodedChars = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            char shiftedChar = (char) (((character + 5 - 'a') % 26) + 'a');
            encodedChars.append(shiftedChar);
        }
        return encodedChars.toString();
    }

    public static String shiftDecode(String encodedString) {
        StringBuilder decodedChars = new StringBuilder();
        int index = 0;
        while (index < encodedString.length()) {
            char originalChar = (char) (((encodedString.charAt(index) - 5 - 'a') % 26) + 'a');
            decodedChars.append(originalChar);
            index++;
        }
        return decodedChars.toString();
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
        assertEquals(encodeShift(testCases[0]), shiftEncode(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(encodeShift(testCases[1]), shiftEncode(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(encodeShift(testCases[2]), shiftEncode(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(encodeShift(testCases[3]), shiftEncode(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(encodeShift(testCases[4]), shiftEncode(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(encodeShift(testCases[5]), shiftEncode(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(encodeShift(testCases[6]), shiftEncode(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(encodeShift(testCases[7]), shiftEncode(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(encodeShift(testCases[8]), shiftEncode(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(encodeShift(testCases[9]), shiftEncode(testCases[9]));
    }
}