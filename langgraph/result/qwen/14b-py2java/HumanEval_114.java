public class HumanEval_114 {
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
                maxSum = Math.max(-i, maxSum);
            }
        }
        int minSum = -maxSum;
        return minSum;
    }
}