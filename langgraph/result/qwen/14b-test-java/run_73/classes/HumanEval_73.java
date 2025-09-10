import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_73 {

    // Source Code
    static class SourceCode {
        public static int smallestChange(int[] arr) {
            int ans = 0;
            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] != arr[arr.length - i - 1]) {
                    ans += 1;
                }
            }
            return ans;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int minimalAdjustments(int[] sequence) {
            int adjustmentsNeeded = 0;
            int index = 0;
            while (index < sequence.length / 2) {
                if (sequence[index] != sequence[sequence.length - index - 1]) {
                    adjustmentsNeeded += 1;
                }
                index += 1;
            }
            return adjustmentsNeeded;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 2, 1},       // Palindrome with odd length (0 changes needed)
        {1, 2, 3, 4, 5},       // Not a palindrome (2 changes needed)
        {1, 1, 1, 1, 1},       // All elements are the same (0 changes needed)
        {1, 2, 2, 1},          // Palindrome with even length (0 changes needed)
        {1, 2, 3},             // Not a palindrome (1 change needed)
        {},                    // Empty list (0 changes needed)
        {1},                   // Single element (0 changes needed)
        {1, 2},                // Not a palindrome (1 change needed)
        {1, 2, 3, 4},          // Not a palindrome (2 changes needed)
        {1, 2, 2, 3}           // Not a palindrome (1 change needed)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void smallestChange_vs_minimalAdjustments(int[] inputArray) {
        assertEquals(
            SourceCode.smallestChange(inputArray),
            TransformedCode.minimalAdjustments(inputArray)
        );
    }
}