import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_96 {

    // Source Code
    public static List<Integer> countUpTo(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    // Transformed Code
    public static List<Integer> findPrimesBelow(int limit) {
        List<Integer> primeNumbers = new ArrayList<>();
        int candidate = 2;
        while (candidate < limit) {
            boolean isDivisible = false;
            int divisor = 2;
            while (divisor < candidate) {
                if (candidate % divisor == 0) {
                    isDivisible = true;
                    break;
                }
                divisor++;
            }
            if (!isDivisible) {
                primeNumbers.add(candidate);
            }
            candidate++;
        }
        return primeNumbers;
    }

    // Test Cases
    private static final int[] testCases = {
        10,  // Simple case with multiple primes below the limit
        2,   // Edge case where limit is less than the smallest prime
        3,   // Case where there's only one prime below the limit
        20,  // Larger number to check performance and correctness
        1,   // Edge case where limit is 1
        0,   // Edge case where limit is 0
        5,   // Simple case with multiple primes below the limit
        15,  // Case with some primes but not many
        29,  // Prime number itself as the limit
        30   // Number just above a prime to check if it includes that prime
    };

    @Test
    public void test_0() {
        assertEquals(countUpTo(testCases[0]), findPrimesBelow(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(countUpTo(testCases[1]), findPrimesBelow(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(countUpTo(testCases[2]), findPrimesBelow(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(countUpTo(testCases[3]), findPrimesBelow(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(countUpTo(testCases[4]), findPrimesBelow(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(countUpTo(testCases[5]), findPrimesBelow(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(countUpTo(testCases[6]), findPrimesBelow(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(countUpTo(testCases[7]), findPrimesBelow(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(countUpTo(testCases[8]), findPrimesBelow(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(countUpTo(testCases[9]), findPrimesBelow(testCases[9]));
    }
}