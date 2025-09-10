import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream; // Added import for Stream
import java.util.Arrays; // Added import for Arrays

public class HumanEval_98 {

    // Source Code
    static class SourceCode {
        public int countUpper(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i += 2) {
                if ("AEIOU".indexOf(s.charAt(i)) != -1) {
                    count++;
                }
            }
            return count;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int tallyEvenIndexVowels(String inputString) {
            int vowelCount = 0;
            int index = 0;
            while (index < inputString.length()) {
                if (index % 2 == 0 && "AEIOU".indexOf(inputString.charAt(index)) != -1) {
                    vowelCount++;
                }
                index++;
            }
            return vowelCount;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of("", 0),
        Arguments.of("A", 1),
        Arguments.of("B", 0),
        Arguments.of("AEIOU", 3), // A at index 0, E at index 2, O at index 4
        Arguments.of("aeiou", 0),
        Arguments.of("AbEcIdOfUg", 2), // A at index 0, I at index 4
        Arguments.of("abcdefgHIJKL", 0),
        Arguments.of("HELLOworld", 1), // E at index 0
        Arguments.of("Python", 0),
        Arguments.of("UPPERlower", 1), // U at index 0
        Arguments.of("AEIOU" + "AEIOU" + "AEIOU" + "AEIOU" + "AEIOU", 8), // AEIOUAEIOUAEIOUAEIOUAEIOU -> A, E, I, O, U at indices 0, 2, 4, 6, 8 (each group of AEIOU contributes 3 vowels)
        Arguments.of("AxBxCxDxExF", 3) // A at index 0, E at index 4, A at index 8
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void countUpper_vs_tallyEvenIndexVowels(String inputText, int expected) {
        SourceCode sourceCodeInstance = new SourceCode();
        TransformedCode transformedCodeInstance = new TransformedCode();

        assertEquals(
            sourceCodeInstance.countUpper(inputText),
            transformedCodeInstance.tallyEvenIndexVowels(inputText),
            "Input: " + inputText
        );
    }
}