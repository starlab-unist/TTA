import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
        {"hello", "l"},
        {"banana", "na"},
        {"aaaa", "aa"},
        {"abcde", "f"},
        {"mississippi", "issi"},
        {"abababa", "aba"},
        {"", ""},
        {"a", ""},
        {"hello world", "o w"},
        {"abc", "d"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if source and transformed methods produce the same output")
    void howManyTimes_vs_countOccurrences(String inputString, String inputSubstring) {
        assertEquals(
            SourceCode.howManyTimes(inputString, inputSubstring),
            new TransformedCode().countOccurrences(inputString, inputSubstring)
        );
    }
}