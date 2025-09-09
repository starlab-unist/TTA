public class HumanEval_128 {
    public static Integer calculateSignedSum(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        
        int negativeCount = 0;
        boolean containsZero = false;
        
        for (int num : arr) {
            if (num < 0) {
                negativeCount++;
            } else if (num == 0) {
                containsZero = true;
                break;
            }
        }
        
        int sign = containsZero ? 0 : (int) Math.pow(-1, negativeCount);
        int totalSum = 0;
        
        for (int num : arr) {
            totalSum += Math.abs(num);
        }
        
        return sign * totalSum;
    }
}