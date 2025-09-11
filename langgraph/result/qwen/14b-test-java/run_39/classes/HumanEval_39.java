import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_39 {

    // Source Code
    static class HumanEval_39_Source {
        public static int primeFib(int n) {
            List<Integer> f = new ArrayList<>();
            f.add(0);
            f.add(1);

            while (true) {
                f.add(f.get(f.size() - 1) + f.get(f.size() - 2));
                if (isPrime(f.get(f.size() - 1))) {
                    n -= 1;
                }
                if (n == 0) {
                    return f.get(f.size() - 1);
                }
            }
        }

        private static boolean isPrime(int p) {
            if (p < 2) {
                return false;
            }
            for (int k = 2; k <= Math.min((int) Math.sqrt(p), p - 1); k++) {
                if (p % k == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_39_Transformed {
        public static int find_nth_prime_fibonacci(int index) {
            List<Integer> fibonacciSequence = new ArrayList<>();
            fibonacciSequence.add(0);
            fibonacciSequence.add(1);

            while (true) {
                int nextFib = fibonacciSequence.get(fibonacciSequence.size() - 1) + fibonacciSequence.get(fibonacciSequence.size() - 2);
                fibonacciSequence.add(nextFib);
                if (checkPrime(nextFib)) {
                    index--;
                }
                if (index == 0) {
                    return nextFib;
                }
            }
        }

        private static boolean checkPrime(int number) {
            if (number < 2) {
                return false;
            }
            int limit = Math.min((int) Math.sqrt(number) + 1, number - 1);
            int divisor = 2;
            while (divisor < limit) {
                if (number % divisor == 0) {
                    return false;
                }
                divisor++;
            }
            return true;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        1,  // First prime Fibonacci number is 2
        2,  // Second prime Fibonacci number is 3
        3,  // Third prime Fibonacci number is 5
        4,  // Fourth prime Fibonacci number is 13
        5,  // Fifth prime Fibonacci number is 89
        6,  // Sixth prime Fibonacci number is 233
        7,  // Seventh prime Fibonacci number is 1597
        8,  // Eighth prime Fibonacci number is 28657
        9,  // Ninth prime Fibonacci number is 514229
        10  // Tenth prime Fibonacci number is 433494437
    };

    private static final int[] expectedResults = {
        2,
        3,
        5,
        13,
        89,
        233,
        1597,
        28657,
        514229,
        433494437
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[0]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[1]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[2]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[3]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[4]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[5]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[6]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[7]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[8]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[9]), HumanEval_39_Transformed.find_nth_prime_fibonacci(testCases[9]));
    }
}