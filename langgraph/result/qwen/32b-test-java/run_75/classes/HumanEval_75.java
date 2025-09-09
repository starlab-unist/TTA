import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_75 {

    // Source Code
    static class HumanEval_75_Source {
        public static boolean isMultiplyPrime(int a) {
            return isMultiplyPrimeHelper(a);
        }

        private static boolean isMultiplyPrimeHelper(int a) {
            for (int i = 2; i <= 100; i++) {
                if (!isPrime(i)) continue;
                for (int j = 2; j <= 100; j++) {
                    if (!isPrime(j)) continue;
                    for (int k = 2; k <= 100; k++) {
                        if (!isPrime(k)) continue;
                        if (i * j * k == a) return true;
                    }
                }
            }
            return false;
        }

        private static boolean isPrime(int n) {
            for (int j = 2; j < n; j++) {
                if (n % j == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_75_Transformed {
        public boolean checkProductOfThreePrimes(int number) {
            for (int first : primeRange()) {
                if (!primeCheck(first)) {
                    continue;
                }
                for (int second : primeRange()) {
                    if (!primeCheck(second)) {
                        continue;
                    }
                    for (int third : primeRange()) {
                        if (!primeCheck(third)) {
                            continue;
                        }
                        if (first * second * third == number) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean primeCheck(int value) {
            for (int divisor = 2; divisor < value; divisor++) {
                if (value % divisor == 0) {
                    return false;
                }
            }
            return true;
        }

        private int[] primeRange() {
            int[] range = new int[99];
            for (int i = 0; i < range.length; i++) {
                range[i] = i + 2;
            }
            return range;
        }
    }

    // Test Cases
    @ParameterizedTest(name = "Test case {index}: {0}")
    @ValueSource(ints = {30, 60, 105, 231, 385, 500, 770, 969, 1001, 1385})
    void isMultiplyPrime_vs_checkProductOfThreePrimes(int testCase) {
        assertEquals(
            HumanEval_75_Source.isMultiplyPrime(testCase),
            new HumanEval_75_Transformed().checkProductOfThreePrimes(testCase)
        );
    }
}