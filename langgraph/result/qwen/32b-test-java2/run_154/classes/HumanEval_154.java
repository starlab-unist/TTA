import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_154 {

    // Source Code
    static class SourceCode {
        public static boolean cycpatternCheck(String a, String b) {
            int l = b.length();
            String pat = b + b;
            for (int i = 0; i <= a.length() - l; i++) {
                for (int j = 0; j <= l; j++) {
                    if (a.substring(i, i + l).equals(pat.substring(j, j + l))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean verifyCyclicPattern(String sequence, String pattern) {
            int patternLength = pattern.length();
            String doubledPattern = pattern + pattern;
            int index = 0;
            
            while (index <= sequence.length() - patternLength) {
                int subIndex = 0;
                while (subIndex <= patternLength) {
                    if (sequence.substring(index, index + patternLength).equals(doubledPattern.substring(subIndex, subIndex + patternLength))) {
                        return true;
                    }
                    subIndex += 1;
                }
                index += 1;
            }
            
            return false;
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"abc", "cab"},  // Should be True (cyclical)
        {"hello", "ell"},  // Should be True (substring match)
        {"abcd", "dabc"},  // Should be True (cyclical)
        {"abcd", "abdc"},  // Should be False (not cyclical)
        {"aaaa", "aa"},    // Should be True (repeated pattern)
        {"abcdefg", "efga"},  // Should be True (cyclical)
        {"abcdefg", "gfedcba"},  // Should be False (reverse not same as cyclic shift)
        {"", ""},  // Should be True (both empty strings)
        {"a", "b"},  // Should be False (no match)
        {"pattern", ""},  // Should be True (empty pattern matches everything in sequence)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("cycpatternCheck vs verifyCyclicPattern equivalence test")
    void cycpatternCheck_vs_verifyCyclicPattern(String inputA, String inputB) {
        assertEquals(
            SourceCode.cycpatternCheck(inputA, inputB),
            new TransformedCode().verifyCyclicPattern(inputA, inputB)
        );
    }
}