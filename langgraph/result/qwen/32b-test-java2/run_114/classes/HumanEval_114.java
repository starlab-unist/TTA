import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.Arrays; // Added import for Arrays

public class HumanEval_114 {

    // Source Code
    static class HumanEval_114_Source {
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
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, -6),
            Arguments.of(new int[]{-1, -2, -3, -4}, -10),
            Arguments.of(new int[]{5, -1, 5}, -1),
            Arguments.of(new int[]{0, 0, 0}, 0),
            Arguments.of(new int[]{1}, -1),
            Arguments.of(new int[]{-1}, -1),
            Arguments.of(new int[]{1, -1, 1, -1}, -2),
            Arguments.of(new int[]{3, -4, 2, -3, -1, 7, -5}, -6),
            Arguments.of(new int[]{10, -3, 4, -2, -1, 10}, -6),
            Arguments.of(new int[]{}, 0) // Edge case: empty list
        );
    }

    @ParameterizedTest(name = "Running test case index {index}")
    @MethodSource("provideTestCases")
    void minSubArraySum_vs_calculate_minimum_subarray_sum(int[] inputArray, int expectedOutput) {
        assertEquals(
            new HumanEval_114_Source().minSubArraySum(inputArray), // Non-static method call
            new HumanEval_114_Transformed().calculate_minimum_subarray_sum(inputArray), // Non-static method call
            "Test failed for input: " + Arrays.toString(inputArray)
        );
    }
}