import java.util.*;

class HumanEval_145 {
    public static List<Integer> order_by_points(List<Integer> nums) {
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
        String numStr = Integer.toString(n);
        int sum = 0;
        for (char c : numStr.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum * neg;
    }
}