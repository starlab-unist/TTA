import java.util.Arrays;
import java.util.List;

public class HumanEval_108 {
    public static int countNums(int[] arr) {
        return (int) Arrays.stream(arr)
                .map(HumanEval_108::digitsSum)
                .filter(x -> x > 0)
                .count();
    }

    private static int digitsSum(int n) {
        int neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        String numStr = Integer.toString(n);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        digits[0] *= neg;
        return Arrays.stream(digits).sum();
    }
}