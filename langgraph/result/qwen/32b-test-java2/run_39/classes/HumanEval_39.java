import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_39 {

    // Source Code
    static class SourceCode {
        public static int primeFib(int n) {
            List<Integer> f = new ArrayList<>();
            f.add(0);
            f.add(1);

            while (true) {
                int nextFib = f.get(f.size() - 1) + f.get(f.size() - 2);
                f.add(nextFib);
                if (isPrime(nextFib)) {
                    n--;
                }
                if (n == 0) {
                    return nextFib;
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
        public static int findNthPrimeFibonacci(int index) {
            if (index < 1) {
                throw new IllegalArgumentException("Index must be a positive integer.");
            }

            int[] fibonacciSequence = new int[2];
            fibonacciSequence[0] = 0;
            fibonacciSequence[1] = 1;

            int nextFib = 0;
            while (true) {
                nextFib = fibonacciSequence[0] + fibonacciSequence[1];
                fibonacciSequence[0] = fibonacciSequence[1];
                fibonacciSequence[1] = nextFib;

                if (isPrime(nextFib)) {
                    index--;
                }
                if (index == 0) {
                    return nextFib;
                }
            }
        }

        private static boolean isPrime(int number) {
            if (number < 2) {
                return false;
            }
            int limit = Math.min((int) Math.sqrt(number) + 1, number - 1);
            for (int divisor = 2; divisor < limit; divisor++) {
                if (number % divisor == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        1,   // First prime Fibonacci number is 2
        2,   // Second prime Fibonacci number is 3
        3,   // Third prime Fibonacci number is 5
        4,   // Fourth prime Fibonacci number is 13
        5,   // Fifth prime Fibonacci number is 89
        6,   // Sixth prime Fibonacci number is 233
        7,   // Seventh prime Fibonacci number is 1597
        8,   // Eighth prime Fibonacci number is 28657
        9,   // Ninth prime Fibonacci number is 514229
        10   // Tenth prime Fibonacci number is 433494437
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).boxed().map(Arguments::of);
    }

    @ParameterizedTest(name = "primeFib({0}) == findNthPrimeFibonacci({0})")
    @MethodSource("provideTestCases")
    public void primeFib_vs_findNthPrimeFibonacci(int inputIndex) {
        assertEquals(
            SourceCode.primeFib(inputIndex),
            TransformedCode.findNthPrimeFibonacci(inputIndex)
        );
    }
}