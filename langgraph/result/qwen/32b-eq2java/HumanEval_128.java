public class HumanEval_128 {
    public static Integer calculateSignedSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        
        int negativeCount = 0;
        boolean containsZero = false;
        
        for (int num : numbers) {
            if (num < 0) {
                negativeCount++;
            }
            if (num == 0) {
                containsZero = true;
            }
        }
        
        int sign = containsZero ? 0 : (negativeCount % 2 == 0) ? 1 : -1;
        int totalSum = 0;
        
        for (int num : numbers) {
            totalSum += Math.abs(num);
        }
        
        return sign * totalSum;
    }
}