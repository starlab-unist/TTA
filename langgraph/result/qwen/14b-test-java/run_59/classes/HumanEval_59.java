import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_59 {

    // Source Code
    static class SourceCode {
        public static int largest_prime_factor(int n) {
            int largest = 1;
            for (int j = 2; j <= n; j++) {
                if (n % j == 0 && is_prime(j)) {
                    largest = Math.max(largest, j);
                }
            }
            return largest;
        }

        private static boolean is_prime(int k) {
            if (k < 2) {
                return false;
            }
            for (int i = 2; i < k; i++) {
                if (k % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int findMaxPrimeDivisor(int number) {
            int maxPrime = 1;
            int factor = 2;
            while (factor <= number) {
                if (number % factor == 0 && checkPrime(factor)) {
                    maxPrime = factor;
                }
                factor += 1;
            }
            return maxPrime;
        }

        private static boolean checkPrime(int candidate) {
            if (candidate < 2) {
                return false;
            }
            int divisor = 2;
            while (divisor * divisor <= candidate) {
                if (candidate % divisor == 0) {
                    return false;
                }
                divisor += 1;
            }
            return true;
        }
    }

    // Test Cases
    @ParameterizedTest(name = "Input: {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    void largest_prime_factor_vs_findMaxPrimeDivisor(int inputNumber) {
        assertEquals(
            SourceCode.largest_prime_factor(inputNumber),
            TransformedCode.findMaxPrimeDivisor(inputNumber)
        );
    }
}