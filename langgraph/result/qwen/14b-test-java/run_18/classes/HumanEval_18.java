import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        public static int count_occurrences(String main_str, String sub_str) {
            int occurrence_count = 0;
            int index = 0;

            while (index <= main_str.length() - sub_str.length()) {
                if (main_str.substring(index, index + sub_str.length()).equals(sub_str)) {
                    occurrence_count += 1;
                }
                index += 1;
            }

            return occurrence_count;
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
    @DisplayName("Testing howManyTimes and count_occurrences with various inputs")
    void howManyTimes_vs_count_occurrences(String inputText, String inputSubstring) {
        assertEquals(
            SourceCode.howManyTimes(inputText, inputSubstring),
            TransformedCode.count_occurrences(inputText, inputSubstring)
        );
    }
}