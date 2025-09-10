import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_51 {

    // Source Code
    static class SourceCode {
        public static String removeVowels(String text) {
            StringBuilder result = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (!"aeiouAEIOU".contains(String.valueOf(c))) {
                    result.append(c);
                }
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String stripVowels(String inputString) {
            String vowels = "aeiouAEIOU";
            StringBuilder result = new StringBuilder();
            int index = 0;

            while (index < inputString.length()) {
                char ch = inputString.charAt(index);
                if (vowels.indexOf(ch) == -1) {
                    result.append(ch);
                }
                index++;
            }

            return result.toString();
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"Hello, World!", "Hll, Wrld!"},
        {"Python Programming", "Pythn Prgrmmng"},
        {"AEIOUaeiou", ""},
        {"abcdefghijklmnopqrstuvwxyz", "bcdfghjklmnpqrstvwxyz"},
        {"THE quick brown fox JUMPS over the LAZY dog", "TH qck brwn fx JMPS vr th LZY dg"},
        {"1234567890", "1234567890"},
        {"!@#$%^&*()_+", "!@#$%^&*()_+"},
        {"OpenAI", "pnA"},
        {"a b c d e f g h i j", "b d f h j"},
        {"This is a simple test case.", "Ths s  smpl tst cs."}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(t -> Arguments.of(t[0], t[1]));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void removeVowels_vs_stripVowels(String inputText, String expectedOutput) {
        assertEquals(
            SourceCode.removeVowels(inputText),
            new TransformedCode().stripVowels(inputText),
            expectedOutput
        );
    }
}