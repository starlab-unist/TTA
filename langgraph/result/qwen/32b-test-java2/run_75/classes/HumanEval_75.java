import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_75 {

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
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
    private static final Integer[] testCases = {
        30,   // 2*3*5
        60,   // 2*2*3*5 (False)
        105,  // 3*5*7
        231,  // 3*7*11
        385,  // 5*7*11
        500,  // 2*2*5*5*5 (False)
        770,  // 2*5*7*11 (False)
        969,  // 3*11*29
        1001, // 7*11*13
        1385  // 5*11*25 (False)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isMultiplyPrime_vs_checkProductOfThreePrimes(int inputNumber) {
        assertEquals(
            SourceCode.isMultiplyPrime(inputNumber),
            new TransformedCode().checkProductOfThreePrimes(inputNumber)
        );
    }
}