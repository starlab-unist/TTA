import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_89 {

    // Source Code
    static class HumanEval_89_Source {
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
    static class HumanEval_89_Transformed {
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
    private static final String[][] testCases = {
        {"hello"},
        {"world"},
        {"abcxyz"},
        {"python"},
        {"12345"},
        {"!@#$%"},
        {"encrypt this string"},
        {"a quick brown fox jumps over the lazy dog"},
        {"the quick brown fox jumps over the lazy dog"},
        {"abcdefghijklmnopqrstuvwxyz"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void encrypt_vs_cipherText(String inputText) {
        HumanEval_89_Source sourceInstance = new HumanEval_89_Source();
        HumanEval_89_Transformed transformedInstance = new HumanEval_89_Transformed();

        assertEquals(
            sourceInstance.encrypt(inputText),
            transformedInstance.cipherText(inputText)
        );
    }
}