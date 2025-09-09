import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_72 {

    // Source Code
    static class HumanEval_72 {
        public static boolean willItFly(int[] q, int w) {
            if (sumArray(q) > w) {
                return false;
            }

            int i = 0, j = q.length - 1;
            while (i < j) {
                if (q[i] != q[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        private static int sumArray(int[] array) {
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            return sum;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean canItTakeOff(int[] weights, int maxWeight) {
            int totalWeight = 0;
            for (int weight : weights) {
                totalWeight += weight;
            }

            if (totalWeight > maxWeight) {
                return false;
            }

            int start = 0, end = weights.length - 1;
            while (start < end) {
                if (weights[start] != weights[end]) {
                    return false;
                }
                start++;
                end--;
            }

            return true;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(new int[]{1, 2, 3, 2, 1}, 10),  // Palindrome and within weight limit
        Arguments.of(new int[]{1, 2, 3, 4, 5}, 15),  // Not a palindrome but within weight limit
        Arguments.of(new int[]{1, 1, 1, 1}, 4),      // Symmetric and exactly at weight limit
        Arguments.of(new int[]{1, 2, 2, 1}, 6),      // Palindrome and within weight limit
        Arguments.of(new int[]{1}, 1),                // Single element, within weight limit
        Arguments.of(new int[]{}, 0),                 // Empty array, within weight limit (edge case)
        Arguments.of(new int[]{5, 5, 5, 5}, 20),     // Symmetric and well below weight limit
        Arguments.of(new int[]{5, 5, 5, 5}, 19),     // Symmetric but at max weight limit (edge case)
        Arguments.of(new int[]{1, 2, 3, 4, 3, 2, 1}, 20), // Palindrome and within weight limit
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 28)  // Not a palindrome but exactly at weight limit
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @DisplayName("Check if both functions produce the same output for the same inputs")
    @ParameterizedTest(name = "willItFly({0}, {1}) == canItTakeOff({0}, {1})")
    @MethodSource("provideTestCases")
    void willItFly_vs_canItTakeOff(int[] weights, int maxWeight) {
        assertEquals(
            HumanEval_72.willItFly(weights, maxWeight),
            new TransformedCode().canItTakeOff(weights, maxWeight)
        );
    }
}