import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_96 {

    // Source Code
    static class SourceCode {
        public List<Integer> countUpTo(int n) {
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i < n; i++) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes.add(i);
                }
            }
            return primes;
        }
    }

    // Transformed Code
    static class TransformedCode {
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
                    divisor++;
                }
                if (!isDivisible) {
                    primeNumbers.add(candidate);
                }
                candidate++;
            }
            return primeNumbers;
        }
    }

    // Test Cases
    @ParameterizedTest
    @ValueSource(ints = {10, 2, 3, 20, 1, 0, 5, 15, 29, 30})
    void countUpTo_vs_findPrimesBelow(int input) {
        assertEquals(
            SourceCode.countUpTo(input),
            TransformedCode.findPrimesBelow(input)
        );
    }
}