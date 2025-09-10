import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_18 {

    // Source Code
    static class SourceCode {
        public static int howManyTimes(String string, String substring) {
            int times = 0;

            for (int i = 0; i <= string.length() - substring.length(); i++) {
                if (string.substring(i, i + substring.length()).equals(substring)) {
                    times++;
                }
            }

            return times;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int countOccurrences(String mainStr, String subStr) {
            int occurrenceCount = 0;
            int index = 0;

            while (index <= mainStr.length() - subStr.length()) {
                if (mainStr.substring(index, index + subStr.length()).equals(subStr)) {
                    occurrenceCount++;
                }
                index++;
            }

            return occurrenceCount;
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"hello", "l"},          // Expected: 2
        {"banana", "na"},        // Expected: 2
        {"aaaa", "aa"},          // Expected: 3
        {"abcde", "f"},          // Expected: 0
        {"mississippi", "issi"}, // Expected: 1
        {"abababa", "aba"},      // Expected: 2
        {"", ""},                // Expected: 1 (empty substring in empty string)
        {"a", ""},               // Expected: 2 (empty substring in non-empty string)
        {"hello world", "o w"},  // Expected: 1
        {"abc", "d"}             // Expected: 0
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void howManyTimes_vs_countOccurrences(String inputString, String inputSubstring) {
        assertEquals(
            SourceCode.howManyTimes(inputString, inputSubstring),
            new TransformedCode().countOccurrences(inputString, inputSubstring)
        );
    }
}