import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_50 {

    // Source Code
    static class SourceCode {
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

    // Transformed Code
    static class TransformedCode {
        public String shift_encode(String inputString) {
            StringBuilder encodedChars = new StringBuilder();
            for (char character : inputString.toCharArray()) {
                char shiftedChar = (char) (((character + 5 - 'a') % 26) + 'a');
                encodedChars.append(shiftedChar);
            }
            return encodedChars.toString();
        }

        public String shift_decode(String encodedString) {
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
    private static final String[][] testCases = {
        {"abcde"},
        {"fghij"},
        {"vwxyz"},
        {"hello"},
        {"world"},
        {"python"},
        {"unittest"},
        {"shift"},
        {"encode"},
        {"decode"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Source Code encodeShift vs Transformed Code shift_encode")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testEncodeShift_vs_shift_encode(String inputText) {
        assertEquals(
            SourceCode.encodeShift(inputText),
            new TransformedCode().shift_encode(inputText)
        );
    }

    @DisplayName("Source Code decodeShift vs Transformed Code shift_decode")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testDecodeShift_vs_shift_decode(String inputText) {
        assertEquals(
            SourceCode.decodeShift(inputText),
            new TransformedCode().shift_decode(inputText)
        );
    }
}