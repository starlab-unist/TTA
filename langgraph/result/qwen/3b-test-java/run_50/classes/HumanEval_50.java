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
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                encoded.append((char) ((ch + 5 - base) % 26 + base));
            } else {
                encoded.append(ch);
            }
        }
        return encoded.toString();
    }

    public static String decodeShift(String s) {
        StringBuilder decoded = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                decoded.append((char) ((ch - 5 - base) % 26 + base));
            } else {
                decoded.append(ch);
            }
        }
        return decoded.toString();
    }

    // Transformed Code
    public static String shiftEncode(String inputString) {
        StringBuilder encodedChars = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            char shiftedChar;
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                shiftedChar = (char) ((character + 5 - base) % 26 + base);
            } else {
                shiftedChar = character;
            }
            encodedChars.append(shiftedChar);
        }
        return encodedChars.toString();
    }

    public static String shiftDecode(String encodedString) {
        StringBuilder decodedChars = new StringBuilder();
        for (char originalChar : encodedString.toCharArray()) {
            char decodedChar;
            if (Character.isLetter(originalChar)) {
                char base = Character.isUpperCase(originalChar) ? 'A' : 'a';
                decodedChar = (char) ((originalChar - 5 - base + 26) % 26 + base);
            } else {
                decodedChar = originalChar;
            }
            decodedChars.append(decodedChar);
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