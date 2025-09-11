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
        for (int i = 2; i < 101; i++) {
            if (!isPrime(i)) continue;
            for (int j = 2; j < 101; j++) {
                if (!isPrime(j)) continue;
                for (int k = 2; k < 101; k++) {
                    if (!isPrime(k)) continue;
                    if (i * j * k == a) return true;
                }
            }
        }
        return false;
    }

    // Transformed Code
    public static boolean checkProductOfThreePrimes(int number) {
        int[] primeRange = new int[98];
        for (int i = 0; i < primeRange.length; i++) {
            primeRange[i] = i + 2;
        }

        for (int first : primeRange) {
            if (!isPrime(first)) {
                continue;
            }
            for (int second : primeRange) {
                if (!isPrime(second)) {
                    continue;
                }
                for (int third : primeRange) {
                    if (!isPrime(third)) {
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

    // Helper Method
    private static boolean isPrime(int n) {
        for (int j = 2; j < n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
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