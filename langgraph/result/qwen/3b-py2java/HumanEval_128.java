public class HumanEval_128 {
    public static Integer prodSigns(int[] arr) {
        if (arr.length == 0) return null;
        
        int zeroCount = 0;
        int negativeCount = 0;
        
        for (int num : arr) {
            if (num == 0) zeroCount++;
            else if (num < 0) negativeCount++;
        }
        
        if (zeroCount > 0) return 0;
        else return (int) Math.pow(-1, negativeCount) * Arrays.stream(arr).map(Math::abs).sum();
    }
}