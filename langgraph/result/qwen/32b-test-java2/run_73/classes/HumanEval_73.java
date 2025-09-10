import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_73 {

    // Source Code
    static class SourceCode {
        public int smallestChange(int[] arr) {
            int ans = 0;
            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] != arr[arr.length - i - 1]) {
                    ans++;
                }
            }
            return ans;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int minimalAdjustments(int[] sequence) {
            int adjustmentsNeeded = 0;
            int index = 0;
            while (index < sequence.length / 2) {
                if (sequence[index] != sequence[sequence.length - index - 1]) {
                    adjustmentsNeeded++;
                }
                index++;
            }
            return adjustmentsNeeded;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 2, 1},       // Palindrome with odd length
        {1, 2, 3, 4, 5},       // Not a palindrome
        {97, 98, 99, 98, 97},  // Palindrome with odd length and strings ('a', 'b', 'c', 'b', 'a')
        {1, 1, 1, 1, 1},       // All elements are the same
        {1, 2, 2, 1},          // Palindrome with even length
        {1, 2, 3},             // Not a palindrome
        {},                    // Empty list
        {1},                   // Single element
        {1, 2},                // Not a palindrome
        {1, 2, 3, 4}           // Not a palindrome
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing smallestChange vs minimalAdjustments equivalence")
    void testSmallestChange_vs_minimalAdjustments(int[] inputArray) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();

        assertEquals(
            source.smallestChange(inputArray),
            transformed.minimalAdjustments(inputArray)
        );
    }
}