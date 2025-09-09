import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_108 {
    public int countNums(List<Integer> arr) {
        return (int) arr.stream()
                .mapToInt(this::digitsSum)
                .filter(x -> x > 0)
                .count();
    }

    private int digitsSum(int n) {
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