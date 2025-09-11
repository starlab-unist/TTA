import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_59 {

    // Source Code
    public static int largestPrimeFactor(int n) {
        boolean isPrime(int k) {
            if (k < 2) {
                return false;
            }
            for (int i = 2; i < k - 1; i++) {
                if (k % i == 0) {
                    return false;
                }
            }
            return true;
        }

        int largest = 1;
        for (int j = 2; j <= n; j++) {
            if (n % j == 0 && isPrime(j)) {
                largest = Math.max(largest, j);
            }
        }
        return largest;
    }

    // Transformed Code
    public static int findMaxPrimeDivisor(int number) {
        boolean isPrime(int candidate) {
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

        int maxPrime = 1;
        int factor = 2;
        while (factor <= number) {
            if (number % factor == 0 && isPrime(factor)) {
                maxPrime = factor;
            }
            factor++;
        }
        return maxPrime;
    }

    // Test Cases
    private static final int[] testCases = {
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        20
    };

    @Test
    public void test_0() {
        assertEquals(largestPrimeFactor(testCases[0]), findMaxPrimeDivisor(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(largestPrimeFactor(testCases[1]), findMaxPrimeDivisor(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(largestPrimeFactor(testCases[2]), findMaxPrimeDivisor(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(largestPrimeFactor(testCases[3]), findMaxPrimeDivisor(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(largestPrimeFactor(testCases[4]), findMaxPrimeDivisor(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(largestPrimeFactor(testCases[5]), findMaxPrimeDivisor(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(largestPrimeFactor(testCases[6]), findMaxPrimeDivisor(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(largestPrimeFactor(testCases[7]), findMaxPrimeDivisor(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(largestPrimeFactor(testCases[8]), findMaxPrimeDivisor(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(largestPrimeFactor(testCases[9]), findMaxPrimeDivisor(testCases[9]));
    }

    @Test
    public void test_10() {
        assertEquals(largestPrimeFactor(testCases[10]), findMaxPrimeDivisor(testCases[10]));
    }

    @Test
    public void test_11() {
        assertEquals(largestPrimeFactor(testCases[11]), findMaxPrimeDivisor(testCases[11]));
    }

    @Test
    public void test_12() {
        assertEquals(largestPrimeFactor(testCases[12]), findMaxPrimeDivisor(testCases[12]));
    }

    @Test
    public void test_13() {
        assertEquals(largestPrimeFactor(testCases[13]), findMaxPrimeDivisor(testCases[13]));
    }

    @Test
    public void test_14() {
        assertEquals(largestPrimeFactor(testCases[14]), findMaxPrimeDivisor(testCases[14]));
    }

    @Test
    public void test_15() {
        assertEquals(largestPrimeFactor(testCases[15]), findMaxPrimeDivisor(testCases[15]));
    }

    @Test
    public void test_16() {
        assertEquals(largestPrimeFactor(testCases[16]), findMaxPrimeDivisor(testCases[16]));
    }

    @Test
    public void test_17() {
        assertEquals(largestPrimeFactor(testCases[17]), findMaxPrimeDivisor(testCases[17]));
    }

    @Test
    public void test_18() {
        assertEquals(largestPrimeFactor(testCases[18]), findMaxPrimeDivisor(testCases[18]));
    }

    @Test
    public void test_19() {
        assertEquals(largestPrimeFactor(testCases[19]), findMaxPrimeDivisor(testCases[19]));
    }
}