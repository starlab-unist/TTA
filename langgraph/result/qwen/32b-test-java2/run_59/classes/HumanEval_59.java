{source_code}
{transformed_code}
{test_cases}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_59 {

    // Source Code
    static class SourceCode {
        public static int largestPrimeFactor(int n) {
            int largest = 1;
            for (int j = 2; j <= n; j++) {
                if (n % j == 0 && isPrime(j)) {
                    largest = Math.max(largest, j);
                }
            }
            return largest;
        }

        private static boolean isPrime(int k) {
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
        public int findMaxPrimeDivisor(int number) {
            return findMaxPrimeDivisorHelper(number);
        }

        private boolean checkPrime(int candidate) {
            if (candidate < 2) {
                return false;
            }
            int divisor = 2;
            while (divisor * divisor <= candidate) {
                if (candidate % divisor == 0) {
                    return false;
                }
                divisor++;
            }
            return true;
        }

        private int findMaxPrimeDivisorHelper(int number) {
            int maxPrime = 1;
            int factor = 2;
            while (factor <= number) {
                if (number % factor == 0 && checkPrime(factor)) {
                    maxPrime = factor;
                }
                factor++;
            }
            return maxPrime;
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
        1,   // No prime factors, should return 1
        2,   // Prime number itself, should return 2
        3,   // Prime number itself, should return 3
        4,   // Should return 2 (largest prime factor)
        5,   // Prime number itself, should return 5
        6,   // Should return 3 (largest prime factor)
        7,   // Prime number itself, should return 7
        8,   // Should return 2 (largest prime factor)
        9,   // Should return 3 (largest prime factor)
        10   // Should return 5 (largest prime factor)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Compare largestPrimeFactor and findMaxPrimeDivisor for the same inputs")
    void largestPrimeFactor_vs_findMaxPrimeDivisor(int inputNumber) {
        assertEquals(
            SourceCode.largestPrimeFactor(inputNumber),
            new TransformedCode().findMaxPrimeDivisor(inputNumber)
        );
    }
}