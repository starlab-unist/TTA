import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_31 {

    // Source Code
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int k = 2; k < n; k++) {
            if (n % k == 0) {
                return false;
            }
        }
        return true;
    }

    // Transformed Code
    public static boolean checkPrime(int number) {
        if (number < 2) {
            return false;
        }
        int divisor = 2;
        while (divisor < number - 1) {
            if (number % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }

    // Test Cases
    private static final int[] testCases = {
        0,      // Not prime (less than 2)
        1,      // Not prime (less than 2)
        2,      // Prime
        3,      // Prime
        4,      // Not prime
        5,      // Prime
        9,      // Not prime
        11,     // Prime
        16,     // Not prime
        17,     // Prime
    };

    @Test
    public void test_0() {
        assertEquals(isPrime(testCases[0]), checkPrime(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(isPrime(testCases[1]), checkPrime(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(isPrime(testCases[2]), checkPrime(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(isPrime(testCases[3]), checkPrime(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(isPrime(testCases[4]), checkPrime(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(isPrime(testCases[5]), checkPrime(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(isPrime(testCases[6]), checkPrime(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(isPrime(testCases[7]), checkPrime(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(isPrime(testCases[8]), checkPrime(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(isPrime(testCases[9]), checkPrime(testCases[9]));
    }
}