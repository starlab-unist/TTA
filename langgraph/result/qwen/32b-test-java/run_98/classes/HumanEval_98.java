import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    private static final Object[][] testCases = {
        {"", 0},
        {"A", 1},
        {"B", 0},
        {"AEIOU", 3},
        {"aeiou", 0},
        {"AbEcIdOfUg", 2},
        {"abcdefgHIJKL", 0},
        {"HELLOworld", 1},
        {"Python", 0},
        {"UPPERlower", 1},
        {"AEIOU" + "AEIOU" + "AEIOU" + "AEIOU" + "AEIOU", 8},  // "AEIOUAEIOUAEIOUAEIOUAEIOU"
        {"AxBxCxDxExF", 3}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void countUpper_vs_tallyEvenIndexVowels(String input, int expected) {
        assertEquals(
            SourceCode.countUpper(input),
            TransformedCode.tallyEvenIndexVowels(input)
        );
    }
}