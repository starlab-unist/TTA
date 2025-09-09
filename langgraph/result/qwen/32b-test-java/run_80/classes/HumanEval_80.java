import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_80 {

    // Source Code
    static class HumanEval_80_Source {
        public static boolean isHappy(String s) {
            if (s.length() < 3) {
                return false;
            }

            for (int i = 0; i < s.length() - 2; i++) {
                if (s.charAt(i) == s.charAt(i + 1) || s.charAt(i + 1) == s.charAt(i + 2) || s.charAt(i) == s.charAt(i + 2)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_80_Transformed {
        public boolean checkHappiness(String sequence) {
            if (sequence.length() < 3) {
                return false;
            }

            int index = 0;
            while (index < sequence.length() - 2) {
                if (sequence.charAt(index) == sequence.charAt(index + 1) ||
                    sequence.charAt(index + 1) == sequence.charAt(index + 2) ||
                    sequence.charAt(index) == sequence.charAt(index + 2)) {
                    return false;
                }
                index++;
            }

            return true;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "abc",       // happy
        "aabbcc",    // not happy
        "abac",      // happy
        "aaa",       // not happy
        "abcdefg",   // happy
        "a",         // not happy (less than 3 characters)
        "ab",        // not happy (less than 3 characters)
        "aab",       // not happy
        "abcabc",    // happy
        "aabbba"     // not happy
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test isHappy vs checkHappiness equivalence")
    void isHappy_vs_checkHappiness(String input) {
        assertEquals(
            HumanEval_80_Source.isHappy(input),
            new HumanEval_80_Transformed().checkHappiness(input)
        );
    }
}