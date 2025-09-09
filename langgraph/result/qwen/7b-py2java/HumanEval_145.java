import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_145 {
    public static int[] orderByPoints(int[] nums) {
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return digitsSum(a) - digitsSum(b);
            }
        });
        return nums;
    }

    private static int digitsSum(int n) {
        int neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum * neg;
    }
}