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
    static class HumanEval_96_Source {
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
    }

    // Transformed Code
    static class HumanEval_96_Transformed {
        public List<Integer> findPrimesBelow(int limit) {
            List<Integer> primeNumbers = new ArrayList<>();
            int candidate = 2;
            while (candidate < limit) {
                int divisor = 2;
                boolean isDivisible = false;
                while (divisor < candidate) {
                    if (candidate % divisor == 0) {
                        isDivisible = true;
                        break;
                    }
                    divisor += 1;
                }
                if (!isDivisible) {
                    primeNumbers.add(candidate);
                }
                candidate += 1;
            }
            return primeNumbers;
        }
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
        assertEquals(HumanEval_96_Source.countUpTo(testCases[0]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_96_Source.countUpTo(testCases[1]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_96_Source.countUpTo(testCases[2]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_96_Source.countUpTo(testCases[3]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_96_Source.countUpTo(testCases[4]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_96_Source.countUpTo(testCases[5]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_96_Source.countUpTo(testCases[6]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_96_Source.countUpTo(testCases[7]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_96_Source.countUpTo(testCases[8]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_96_Source.countUpTo(testCases[9]), 
                     new HumanEval_96_Transformed().findPrimesBelow(testCases[9]));
    }
}