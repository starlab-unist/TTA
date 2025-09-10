import java.util.ArrayList;
import java.util.List;

public class HumanEval_39 {

    public static int find_nth_prime_fibonacci(int index) {
        List<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0);
        fibonacciSequence.add(1);

        while (true) {
            int nextFib = fibonacciSequence.get(fibonacciSequence.size() - 1) + fibonacciSequence.get(fibonacciSequence.size() - 2);
            fibonacciSequence.add(nextFib);
            if (checkPrime(nextFib)) {
                index--;
            }
            if (index == 0) {
                return nextFib;
            }
        }
    }

    private static boolean checkPrime(int number) {
        if (number < 2) {
            return false;
        }
        int limit = Math.min((int) Math.sqrt(number) + 1, number - 1);
        int divisor = 2;
        while (divisor < limit) {
            if (number % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }
}