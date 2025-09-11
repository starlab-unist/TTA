import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_94 {

    // Source Code
    public static int skjkasdkd(List<Integer> lst) {
        int max = 0;
        for (int num : lst) {
            if (num > max && isPrime(num)) {
                max = num;
            }
        }
        int result = 0;
        for (char digit : String.valueOf(max).toCharArray()) {
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

    // Transformed Code
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
        for (char digit : String.valueOf(largestPrime).toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        return digitSum;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(3, 5, 7, 2, 8)},          // Simple list with primes
        {Arrays.asList(10, 15, 21, 22)},         // No prime numbers
        {Arrays.asList(29, 31, 37, 41)},         // All prime numbers
        {Arrays.asList(1, 4, 6, 8, 9)},          // Only one prime (2)
        {Arrays.asList(0, -3, -5, -7)},          // Negative and zero values
        {Arrays.asList(11, 13, 17, 19, 23, 29)}, // Larger primes
        {Arrays.asList(2, 3, 5, 7, 11, 13)},     // Small consecutive primes
        {Arrays.asList(41, 37, 31, 29, 23)},     // Descending order of primes
        {Arrays.asList(89, 97, 101, 103)},       // Primes greater than 80
        {Arrays.asList(59, 61, 67, 71, 73)}      // Another set of consecutive primes
    };

    @Test
    public void test_0() {
        assertEquals(skjkasdkd((List<Integer>) testCases[0][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[0][0]).stream().mapToInt(i -> i).toArray()));
    }

    @Test
    public void test_1() {
        assertEquals(skjkasdkd((List<Integer>) testCases[1][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[1][0]).stream().mapToInt(i -> i).toArray()));
    }

    @Test
    public void test_2() {
        assertEquals(skjkasdkd((List<Integer>) testCases[2][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[2][0]).stream().mapToInt(i -> i).toArray()));
    }

    @Test
    public void test_3() {
        assertEquals(skjkasdkd((List<Integer>) testCases[3][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[3][0]).stream().mapToInt(i -> i).toArray()));
    }

    @Test
    public void test_4() {
        assertEquals(skjkasdkd((List<Integer>) testCases[4][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[4][0]).stream().mapToInt(i -> i).toArray()));
    }

    @Test
    public void test_5() {
        assertEquals(skjkasdkd((List<Integer>) testCases[5][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[5][0]).stream().mapToInt(i -> i).toArray()));
    }

    @Test
    public void test_6() {
        assertEquals(skjkasdkd((List<Integer>) testCases[6][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[6][0]).stream().mapToInt(i -> i).toArray()));
    }

    @Test
    public void test_7() {
        assertEquals(skjkasdkd((List<Integer>) testCases[7][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[7][0]).stream().mapToInt(i -> i).toArray()));
    }

    @Test
    public void test_8() {
        assertEquals(skjkasdkd((List<Integer>) testCases[8][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[8][0]).stream().mapToInt(i -> i).toArray()));
    }

    @Test
    public void test_9() {
        assertEquals(skjkasdkd((List<Integer>) testCases[9][0]), 
                     findLargestPrimeDigitSum(((List<Integer>) testCases[9][0]).stream().mapToInt(i -> i).toArray()));
    }
}