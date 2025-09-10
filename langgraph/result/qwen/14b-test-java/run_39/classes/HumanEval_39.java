import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_39 {

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
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
    private static final Integer[] testCases = {
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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index} with input {0}")
    @MethodSource("provideTestCases")
    public void primeFib_vs_find_nth_prime_fibonacci(int n) {
        assertEquals(
            SourceCode.primeFib(n),
            TransformedCode.find_nth_prime_fibonacci(n)
        );
    }
}