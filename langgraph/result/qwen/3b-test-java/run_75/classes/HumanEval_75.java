import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_75 {

    // Source Code
    public static boolean isMultiplyPrime(int a) {
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

    // Transformed Code
    public static boolean checkProductOfThreePrimes(int number) {
        // Helper method to check if a number is prime
        boolean isPrime(int value) {
            for (int divisor = 2; divisor < value; divisor++) {
                if (value % divisor == 0) {
                    return false;
                }
            }
            return true;
        }

        // Define the range of prime numbers to check
        int[] primeRange = new int[100];
        int count = 0;
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                primeRange[count++] = i;
            }
        }

        // Iterate through all combinations of three primes
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                for (int k = j + 1; k < count; k++) {
                    if (primeRange[i] * primeRange[j] * primeRange[k] == number) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Test Cases
    private static final int[] testCases = {
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

    @Test
    public void test_0() {
        assertEquals(isMultiplyPrime(testCases[0]), checkProductOfThreePrimes(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(isMultiplyPrime(testCases[1]), checkProductOfThreePrimes(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(isMultiplyPrime(testCases[2]), checkProductOfThreePrimes(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(isMultiplyPrime(testCases[3]), checkProductOfThreePrimes(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(isMultiplyPrime(testCases[4]), checkProductOfThreePrimes(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(isMultiplyPrime(testCases[5]), checkProductOfThreePrimes(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(isMultiplyPrime(testCases[6]), checkProductOfThreePrimes(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(isMultiplyPrime(testCases[7]), checkProductOfThreePrimes(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(isMultiplyPrime(testCases[8]), checkProductOfThreePrimes(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(isMultiplyPrime(testCases[9]), checkProductOfThreePrimes(testCases[9]));
    }
}