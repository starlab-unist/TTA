import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_118 {

    // Source Code
    static class SourceCode {
        public String getClosestVowel(String word) {
            if (word.length() < 3) {
                return "";
            }

            String vowels = "aeiouAEIOU";
            for (int i = word.length() - 2; i > 0; i--) {
                if (vowels.indexOf(word.charAt(i)) != -1) {
                    if (vowels.indexOf(word.charAt(i + 1)) == -1 && vowels.indexOf(word.charAt(i - 1)) == -1) {
                        return String.valueOf(word.charAt(i));
                    }
                }
            }
            return "";
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String findNearestIsolatedVowel(String sequence) {
            if (sequence.length() < 3) {
                return "";
            }

            String vowels = "aeiouAEIOU";
            int index = sequence.length() - 3;

            while (index > 0) {
                if (vowels.indexOf(sequence.charAt(index)) != -1) {
                    if (vowels.indexOf(sequence.charAt(index + 1)) == -1 && vowels.indexOf(sequence.charAt(index - 1)) == -1) {
                        return String.valueOf(sequence.charAt(index));
                    }
                }
                index--;
            }

            return "";
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "hello",
        "beautiful",
        "sequence",
        "aeiou",
        "bcdfg",
        "aebcdfg",
        "racecar",
        "xylophone",
        "umbrella",
        "algorithm"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing getClosestVowel vs findNearestIsolatedVowel")
    void testGetClosestVowel_vs_findNearestIsolatedVowel(String input) {
        SourceCode sourceCode = new SourceCode();
        TransformedCode transformedCode = new TransformedCode();

        assertEquals(
            sourceCode.getClosestVowel(input),
            transformedCode.findNearestIsolatedVowel(input)
        );
    }
}