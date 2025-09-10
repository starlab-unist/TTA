import java.util.ArrayList;
import java.util.List;

public class HumanEval_96 {
    public List<Integer> findPrimesBelow(int limit) {
        List<Integer> primeNumbers = new ArrayList<>();
        int candidate = 2;
        while (candidate < limit) {
            int divisor = 2;
            boolean isDivisible = false;
            while (divisor < candidate) {
                if (candidate % divisor == 0) {
                    isDivisible = true;
                    break;
                }
                divisor += 1;
            }
            if (!isDivisible) {
                primeNumbers.add(candidate);
            }
            candidate += 1;
        }
        return primeNumbers;
    }
}