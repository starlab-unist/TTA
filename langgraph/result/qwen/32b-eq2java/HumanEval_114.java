public class HumanEval_114 {
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