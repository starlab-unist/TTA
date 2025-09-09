import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_108 {
    public static int countNums(int[] arr) {
        List<Integer> filteredList = Arrays.stream(arr)
            .map(HumanEval_108::digitsSum)
            .filter(x -> x > 0)
            .boxed()
            .collect(Collectors.toList());
        return filteredList.size();
    }

    private static int digitsSum(int n) {
        int neg = 1;
        if (n < 0) {
            n *= -1;
            neg = -1;
        }
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum * neg;
    }
}