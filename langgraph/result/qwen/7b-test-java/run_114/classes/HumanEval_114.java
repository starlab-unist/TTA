import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_114 {

    // Source Code wrapped as a nested static class
    public static class OriginalImpl {
        public static int minSubArraySum(int[] nums) {
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

    // Transformed Code wrapped as a nested static class
    public static class TransformedImpl {
        public static int calculateMinimumSubarraySum(int[] numbers) {
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
                highestNegativeSum = java.util.Arrays.stream(numbers).map(val -> -val).max().orElse(0);
            }

            int minimumSum = -highestNegativeSum;
            return minimumSum;
        }
    }

    // Provide test cases for parameterized tests
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

    // Parameterized test to compare both implementations
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMinSubArraySum(int[] input, int expectedOutput) {
        assertEquals(OriginalImpl.minSubArraySum(input), TransformedImpl.calculateMinimumSubarraySum(input));
    }
}