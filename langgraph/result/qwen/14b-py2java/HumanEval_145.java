import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_145 {
    public static int[] orderByPoints(int[] nums) {
        Integer[] numsObj = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsObj, Comparator.comparingInt(HumanEval_145::digitsSum));
        return Arrays.stream(numsObj).mapToInt(Integer::intValue).toArray();
    }

    private static int digitsSum(int n) {
        int neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        String numStr = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            if (i == 0) {
                digit *= neg;
            }
            sum += digit;
        }
        return sum;
    }
}