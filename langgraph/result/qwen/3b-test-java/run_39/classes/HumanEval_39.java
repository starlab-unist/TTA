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
            if (n <= 0) {
                throw new IllegalArgumentException("n must be a positive integer.");
            }

            int[] fib = new int[n];
            fib[0] = 0;
            fib[1] = 1;

            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];

                if (isPrime(fib[i])) {
                    n--;
                }
            }

            return fib[n - 1];
        }

        private static boolean isPrime(int p) {
            if (p < 2) {
                return false;
            }
            for (int k = 2; k <= Math.sqrt(p); k++) {
                if (p % k == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_39_Transformed {
        public static long findNthPrimeFibonacci(int index) {
            if (index <= 0) {
                throw new IllegalArgumentException("Index must be a positive integer.");
            }

            long a = 0;
            long b = 1;
            int count = 0;

            while (true) {
                long next = a + b;
                a = b;
                b = next;

                if (isPrime(next)) {
                    count++;
                }

                if (count == index) {
                    return next;
                }
            }
        }

        private static boolean isPrime(long number) {
            if (number < 2) {
                return false;
            }

            long limit = Math.min((long) Math.sqrt(number), number - 1);
            long divisor = 2;
            while (divisor <= limit) {
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

    @Test
    public void test_0() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[0]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[1]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[2]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[3]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[4]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[5]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[6]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[7]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[8]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_39_Source.primeFib(testCases[9]), HumanEval_39_Transformed.findNthPrimeFibonacci(testCases[9]));
    }
}