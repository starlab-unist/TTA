import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_94 {

    // Source Code
    static class SourceCode {
        public int skjkasdkd(int[] lst) {
            int maxx = 0;
            int i = 0;
            while (i < lst.length) {
                if (lst[i] > maxx && isPrime(lst[i])) {
                    maxx = lst[i];
                }
                i++;
            }
            int result = sumOfDigits(maxx);
            return result;
        }

        private boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private int sumOfDigits(int number) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int findLargestPrimeDigitSum(int[] numbers) {
            boolean isPrime(int number) {
                for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
                    if (number % divisor == 0) {
                        return false;
                    }
                }
                return true;
            }

            int largestPrime = 0;
            int index = 0;
            while (index < numbers.length) {
                if (numbers[index] > largestPrime && isPrime(numbers[index])) {
                    largestPrime = numbers[index];
                }
                index++;
            }

            int digitSum = 0;
            String numberStr = Integer.toString(largestPrime);
            for (char c : numberStr.toCharArray()) {
                digitSum += Character.getNumericValue(c);
            }
            return digitSum;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {3, 5, 7, 2, 8},          // Simple list with primes
        {10, 15, 21, 22},         // No prime numbers
        {29, 31, 37, 41},         // All prime numbers
        {1, 4, 6, 8, 9},          // Only one prime (2)
        {0, -3, -5, -7},          // Negative and zero values
        {11, 13, 17, 19, 23, 29}, // Larger primes
        {2, 3, 5, 7, 11, 13},     // Small consecutive primes
        {41, 37, 31, 29, 23},     // Descending order of primes
        {89, 97, 101, 103},       // Primes greater than 80
        {59, 61, 67, 71, 73}      // Another set of consecutive primes
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index}: {0}")
    @MethodSource("provideTestCases")
    public void skjkasdkd_vs_findLargestPrimeDigitSum(int[] input) {
        assertEquals(
            SourceCode.skjkasdkd(input),
            TransformedCode.findLargestPrimeDigitSum(input)
        );
    }
}