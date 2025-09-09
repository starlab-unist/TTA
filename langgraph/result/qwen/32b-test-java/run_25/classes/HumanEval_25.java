import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_25 {

    // Source Code
    static List<Integer> factorize(int n) {
        List<Integer> fact = new ArrayList<>();
        int i = 2;
        while (i <= Math.sqrt(n) + 1) {
            if (n % i == 0) {
                fact.add(i);
                n /= i;
            } else {
                i++;
            }
        }

        if (n > 1) {
            fact.add(n);
        }
        return fact;
    }

    // Transformed Code
    static List<Integer> decomposeNumber(int number) {
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

    // Test Cases
    @Test
    public void testFactorize_vs_DecomposeNumber() {
        int[] testCases = {2, 3, 4, 5, 6, 7, 8, 9, 10, 15};

        for (int testCase : testCases) {
            assertEquals(factorize(testCase), decomposeNumber(testCase));
        }
    }
}