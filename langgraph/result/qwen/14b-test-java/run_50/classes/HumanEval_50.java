import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;  // Added import for Stream

public class HumanEval_50 {

    // Source Code
    static class SourceCode {
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
    }

    // Transformed Code
    static class TransformedCode {
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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if encodeShift and shiftEncode produce the same output")
    void encodeShift_vs_shiftEncode(String inputText) {
        assertEquals(
            SourceCode.encodeShift(inputText),
            TransformedCode.shiftEncode(inputText)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if decodeShift and shiftDecode produce the same output")
    void decodeShift_vs_shiftDecode(String inputText) {
        assertEquals(
            SourceCode.decodeShift(inputText),
            TransformedCode.shiftDecode(inputText)
        );
    }
}