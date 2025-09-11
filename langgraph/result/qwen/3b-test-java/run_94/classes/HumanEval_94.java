import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_94 {

    // Source Code
    static class HumanEval_94_Source {
        public static int skjkasdkd(int[] lst) {
            int maxx = 0;
            int i = 0;

            while (i < lst.length) {
                if (lst[i] > maxx && isPrime(lst[i])) {
                    maxx = lst[i];
                }
                i++;
            }

            int result = 0;
            String maxStr = Integer.toString(maxx);
            for (char digit : maxStr.toCharArray()) {
                result += Character.getNumericValue(digit);
            }

            return result;
        }

        private static boolean isPrime(int n) {
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
    }

    // Transformed Code
    static class HumanEval_94_Transformed {
        public static int findLargestPrimeDigitSum(int[] numbers) {
            int largestPrime = 0;
            int index = 0;
            
            while (index < numbers.length) {
                if (numbers[index] > largestPrime && isPrime(numbers[index])) {
                    largestPrime = numbers[index];
                }
                index++;
            }

            int digitSum = calculateDigitSum(largestPrime);
            return digitSum;
        }

        private static boolean isPrime(int number) {
            for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
                if (number % divisor == 0) {
                    return false;
                }
            }
            return true;
        }

        private static int calculateDigitSum(int number) {
            String numberStr = Integer.toString(number);
            int sum = 0;
            for (char digitChar : numberStr.toCharArray()) {
                sum += Character.getNumericValue(digitChar);
            }
            return sum;
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

    @Test
    public void test_0() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[0]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[1]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[2]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[3]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[4]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[5]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[6]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[7]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[8]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_94_Source.skjkasdkd(testCases[9]), 
                     HumanEval_94_Transformed.findLargestPrimeDigitSum(testCases[9]));
    }
}