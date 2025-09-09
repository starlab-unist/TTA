public class HumanEval_114 {
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