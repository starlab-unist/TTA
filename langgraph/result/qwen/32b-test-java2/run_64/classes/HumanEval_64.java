import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Necessary imports to resolve compilation errors
import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_64 {

    // Source Code
    static class SourceCode {
        public static int vowelsCount(String s) {
            String vowels = "aeiouAEIOU";
            int nVowels = 0;
            for (char c : s.toCharArray()) {
                if (vowels.indexOf(c) != -1) {
                    nVowels++;
                }
            }
            if (s.endsWith("y") || s.endsWith("Y")) {
                nVowels++;
            }
            return nVowels;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int tallyVowels(String inputString) {
            String vowelSet = "aeiouAEIOU";
            int vowelCounter = 0;

            for (char character : inputString.toCharArray()) {
                if (vowelSet.indexOf(character) != -1) {
                    vowelCounter++;
                }
            }

            if (inputString.endsWith("y") || inputString.endsWith("Y")) {
                vowelCounter++;
            }

            return vowelCounter;
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"hello"},
        {"HELLO"},
        {"sky"},
        {"SYZYGY"},
        {"rhythm"},
        {"AEIOUY"},
        {"abcdefghijklmnopqrstuvwxyz"},
        {"ABCDEFGHIJKLMNOPQRSTUVWXYZ"},
        {"Python"},
        {""},
        {"a"},
        {"Y"},
        {"y"},
        {"bcd"},
        {"aeiou"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing vowelsCount vs tallyVowels equivalence")
    void test_vowelsCount_vs_tallyVowels(String inputText) {
        assertEquals(
            SourceCode.vowelsCount(inputText),
            new TransformedCode().tallyVowels(inputText)
        );
    }
}