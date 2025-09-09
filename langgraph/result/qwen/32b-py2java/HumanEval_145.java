import java.util.*;

class HumanEval_145 {
    public static List<Integer> orderByPoints(List<Integer> nums) {
        return nums.stream()
                   .sorted(Comparator.comparingInt(HumanEval_145::digitsSum))
                   .collect(Collectors.toList());
    }

    private static int digitsSum(int n) {
        int neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        String[] digits = String.valueOf(n).split("");
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Integer.parseInt(digits[i]);
        }
        sum *= neg;
        return sum;
    }
}