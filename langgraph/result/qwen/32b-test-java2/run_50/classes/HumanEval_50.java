import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_50 {

    // Source Code as a nested static class
    static class HumanEval_50 {
        public static String encodeShift(String s) {
            StringBuilder encoded = new StringBuilder();
            for (char ch : s.toCharArray()) {
                char shifted = (char) (((ch + 5 - 'a') % 26) + 'a');
                encoded.append(shifted);
            }
            return encoded.toString();
        }

        public static String decodeShift(String s) {
            StringBuilder decoded = new StringBuilder();
            for (char ch : s.toCharArray()) {
                char shifted = (char) (((ch - 5 - 'a') % 26 + 26) % 26 + 'a'); // Ensure non-negative result
                decoded.append(shifted);
            }
            return decoded.toString();
        }
    }

    // Transformed Code as a nested static class
    static class TransformedCode {
        public static String shift_encode(String inputString) {
            StringBuilder encodedChars = new StringBuilder();
            for (char character : inputString.toCharArray()) {
                char shiftedChar = (char) (((character + 5 - 'a') % 26) + 'a');
                encodedChars.append(shiftedChar);
            }
            return encodedChars.toString();
        }

        public static String shift_decode(String encodedString) {
            StringBuilder decodedChars = new StringBuilder();
            int index = 0;
            while (index < encodedString.length()) {
                char originalChar = (char) (((encodedString.charAt(index) - 5 - 'a') % 26 + 26) % 26 + 'a');
                decodedChars.append(originalChar);
                index++;
            }
            return decodedChars.toString();
        }
    }

    // Test Cases
    @ParameterizedTest(name = "{index} => inputText={0}")
    @CsvSource({
        "abcde, fghij",
        "fghij, klmno",
        "vwxyz, acdef",
        "hello, mjqqt",
        "world, btwqi",
        "python, udymts",
        "unittest, zywnxwxy",
        "shift, xlmjw",
        "encode, jshtjx",
        "decode, itbfx",
        "java, ogfy",
        "test, yjwx",
        "code, htfi",
        "unit, ztqz",
        "case, hfxf"
    })
    void encodeShift_vs_shift_encode(String inputText, String expectedEncoded) {
        assertEquals(
            HumanEval_50.encodeShift(inputText),
            TransformedCode.shift_encode(inputText),
            "Encoding mismatch for input: " + inputText
        );
        assertEquals(
            expectedEncoded,
            HumanEval_50.encodeShift(inputText),
            "Expected encoding mismatch for input: " + inputText
        );
    }

    @ParameterizedTest(name = "{index} => encodedText={0}")
    @CsvSource({
        "fghij, abcde",
        "klmno, fghij",
        "acdef, vwxyz",
        "mjqqt, hello",
        "btwqi, world",
        "udymts, python",
        "zywnxwxy, unittest",
        "xlmjw, shift",
        "jshtjx, encode",
        "itbfx, decode",
        "ogfy, java",
        "yjwx, test",
        "htfi, code",
        "ztqz, unit",
        "hfxf, case"
    })
    void decodeShift_vs_shift_decode(String encodedText, String expectedDecoded) {
        assertEquals(
            HumanEval_50.decodeShift(encodedText),
            TransformedCode.shift_decode(encodedText),
            "Decoding mismatch for input: " + encodedText
        );
        assertEquals(
            expectedDecoded,
            HumanEval_50.decodeShift(encodedText),
            "Expected decoding mismatch for input: " + encodedText
        );
    }
}