import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_114 {

    // Source Code
    static class HumanEval_114 {
        public int minSubArraySum(int[] nums) {
            int maxSum = 0;
            int s = 0;
            for (int num : nums) {
                s += -num;
                if (s < 0) {
                    s = 0;
                }
                maxSum = Math.max(s, maxSum);
            }
            if (maxSum == 0) {
                maxSum = Integer.MIN_VALUE;
                for (int i : nums) {
                    maxSum = Math.max(maxSum, -i);
                }
            }
            int minSum = -maxSum;
            return minSum;
        }
    }

    // Transformed Code
    static class HumanEval_114_Transformed {
        public int calculate_minimum_subarray_sum(int[] numbers) {
            int currentSum = 0;
            int highestNegativeSum = 0;
            for (int value : numbers) {
                currentSum += -value;
                if (currentSum < 0) {
                    currentSum = 0;
                }
                highestNegativeSum = Math.max(currentSum, highestNegativeSum);
            }

            if (highestNegativeSum == 0) {
                highestNegativeSum = Integer.MIN_VALUE;
                for (int val : numbers) {
                    highestNegativeSum = Math.max(highestNegativeSum, -val);
                }
            }

            int minimumSum = -highestNegativeSum;
            return minimumSum;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(new int[]{1, 2, 3}, -6),
        Arguments.of(new int[]{-1, -2, -3, -4}, -10),
        Arguments.of(new int[]{5, -1, 5}, -1),
        Arguments.of(new int[]{0, 0, 0}, 0),
        Arguments.of(new int[]{1}, -1),
        Arguments.of(new int[]{-1}, -1),
        Arguments.of(new int[]{1, -1, 1, -1}, -2),
        Arguments.of(new int[]{3, -4, 2, -3, -1, 7, -5}, -6),
        Arguments.of(new int[]{10, -3, 4, -2, -1, 10}, -6),
        Arguments.of(new int[]{}, 0),  // Edge case: empty list
        Arguments.of(new int[]{2, 3, -9, 1, 2}, -9),
        Arguments.of(new int[]{-5, -3, -1, -4}, -13),
        Arguments.of(new int[]{7, -6, 5, -4, 3, -2, 1}, -6),
        Arguments.of(new int[]{10, 20, -30, 40, -50}, -50),
        Arguments.of(new int[]{1, 1, 1, 1, 1, -10}, -10)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    void minSubArraySum_vs_calculate_minimum_subarray_sum(int[] input, int expected) {
        assertEquals(
            HumanEval_114.minSubArraySum(input),
            HumanEval_114_Transformed.calculate_minimum_subarray_sum(input),
            "The outputs of the original and transformed functions should be equal for input: " + Arrays.toString(input)
        );
    }
}