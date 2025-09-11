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
    static class HumanEval_31_Source {
        public static boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            for (int k = 2; k <= Math.sqrt(n); k++) {
                if (n % k == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_31_Transformed {
        public static boolean check_prime(int number) {
            if (number < 2) {
                return false;
            }
            int divisor = 2;
            while (divisor < number - 1) {
                if (number % divisor == 0) {
                    return false;
                }
                divisor += 1;
            }
            return true;
        }
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
        assertEquals(HumanEval_31_Source.isPrime(testCases[0]), HumanEval_31_Transformed.check_prime(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_31_Source.isPrime(testCases[1]), HumanEval_31_Transformed.check_prime(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_31_Source.isPrime(testCases[2]), HumanEval_31_Transformed.check_prime(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_31_Source.isPrime(testCases[3]), HumanEval_31_Transformed.check_prime(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_31_Source.isPrime(testCases[4]), HumanEval_31_Transformed.check_prime(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_31_Source.isPrime(testCases[5]), HumanEval_31_Transformed.check_prime(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_31_Source.isPrime(testCases[6]), HumanEval_31_Transformed.check_prime(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_31_Source.isPrime(testCases[7]), HumanEval_31_Transformed.check_prime(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_31_Source.isPrime(testCases[8]), HumanEval_31_Transformed.check_prime(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_31_Source.isPrime(testCases[9]), HumanEval_31_Transformed.check_prime(testCases[9]));
    }
}