public class HumanEval_128 {
    public static Integer prodSigns(int[] arr) {
        if (arr.length == 0) return null;
        
        int zeroCount = 0;
        int negativeCount = 0;
        int sumOfAbs = 0;
        
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            } else if (num < 0) {
                negativeCount++;
            }
            sumOfAbs += Math.abs(num);
        }
        
        int prod = (zeroCount > 0) ? 0 : ((negativeCount % 2 == 0) ? 1 : -1);
        return prod * sumOfAbs;
    }
}