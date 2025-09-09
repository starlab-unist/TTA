import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_89 {

    // Source Code
    static class SourceCode {
        public String encrypt(String s) {
            String d = "abcdefghijklmnopqrstuvwxyz";
            StringBuilder out = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (d.indexOf(c) != -1) {
                    int index = (d.indexOf(c) + 2 * 2) % 26;
                    out.append(d.charAt(index));
                } else {
                    out.append(c);
                }
            }
            return out.toString();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String cipherText(String inputString) {
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            StringBuilder result = new StringBuilder();
            for (char character : inputString.toCharArray()) {
                if (alphabet.indexOf(character) != -1) {
                    int newIndex = (alphabet.indexOf(character) + 4) % 26;
                    result.append(alphabet.charAt(newIndex));
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "hello",
        "world",
        "abcxyz",   // wraps around the alphabet
        "python",
        "12345",    // non-alphabetic characters
        "!@#$%",
        "encrypt this string",
        "a quick brown fox jumps over the lazy dog",  // includes spaces and a full sentence
        "the quick brown fox jumps over the lazy dog",
        "abcdefghijklmnopqrstuvwxyz",   // all alphabet letters
        "",           // empty string
        "A",          // uppercase letter (should remain unchanged)
        "zZ",         // edge case: last lowercase letter, should wrap around
        "jump",       // simple word to test wrapping
        "zebra",      // includes 'z' for wrap-around check
        "xyzabc",     // checks multiple wrap-arounds
        "mno",        // middle of the alphabet
        "aaa",        // repeated characters
        " ",          // single space character (should remain unchanged)
        "testCASE"    // mixed case to ensure only lowercase changes
    };

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing equivalence of encrypt and cipherText methods")
    void testEncrypt_vs_cipherText(String input) {
        assertEquals(
            SourceCode.encrypt(input),
            TransformedCode.cipherText(input)
        );
    }
}