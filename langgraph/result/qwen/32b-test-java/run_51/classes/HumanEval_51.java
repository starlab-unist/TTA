import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    private static final String[] testCases = {
        "Hello, World!",
        "Python Programming",
        "AEIOUaeiou",
        "abcdefghijklmnopqrstuvwxyz",
        "THE quick brown fox JUMPS over the LAZY dog",
        "1234567890",
        "!@#$%^&*()_+",
        "OpenAI",
        "a b c d e f g h i j",
        "This is a simple test case.",
        "",
        "NoVowelsHere",
        "AeIoU",
        "123abcABC456defDEF",
        "Symbols!@#",
        "Spaces and    tabs\t",
        "MixedCASEVOWELSaeiouAEIOU"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing equivalence of removeVowels and stripVowels methods")
    void testRemoveVowels_vs_stripVowels(String inputText) {
        assertEquals(
            SourceCode.removeVowels(inputText),
            TransformedCode.stripVowels(inputText)
        );
    }
}