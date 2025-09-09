import java.util.ArrayList;
import java.util.List;

public class HumanEval_25 {

    public static List<Integer> decomposeNumber(int number) {
        List<Integer> factors = new ArrayList<>();
        int divisor = 2;
        while (divisor <= Math.sqrt(number)) {
            if (number % divisor == 0) {
                factors.add(divisor);
                number /= divisor;
            } else {
                divisor += 1;
            }
        }

        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }
}