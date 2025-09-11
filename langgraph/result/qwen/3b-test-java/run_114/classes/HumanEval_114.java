import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_114 {

    // Source Code
    static class HumanEval_114_Source {
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
                maxSum = Arrays.stream(nums).map(i -> -i).max().getAsInt();
            }
            int minSum = -maxSum;
            return minSum;
        }
    }

    // Transformed Code
    static class HumanEval_114_Transformed {
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
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3}, -6},
        {new int[]{-1, -2, -3, -4}, -10},
        {new int[]{5, -1, 5}, -1},
        {new int[]{0, 0, 0}, 0},
        {new int[]{1}, -1},
        {new int[]{-1}, -1},
        {new int[]{1, -1, 1, -1}, -2},
        {new int[]{3, -4, 2, -3, -1, 7, -5}, -6},
        {new int[]{10, -3, 4, -2, -1, 10}, -6},
        {new int[]{}, 0} // Edge case: empty list
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[0][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[1][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[2][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[3][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[4][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[5][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[6][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[7][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[8][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_114_Source.minSubArraySum((int[]) testCases[9][0]), 
                     HumanEval_114_Transformed.calculateMinimumSubarraySum((int[]) testCases[9][0]));
    }
}