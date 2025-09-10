// HumanEval_96.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

public class HumanEval_96 {

    // Source Code
    static class SourceCode {
        public List<Integer> countUpTo(int n) {
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
    static class TransformedCode {
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
                    divisor++;
                }
                if (!isDivisible) {
                    primeNumbers.add(candidate);
                }
                candidate++;
            }
            return primeNumbers;
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Compare source and transformed function outputs")
    void countUpTo_vs_findPrimesBelow(Integer input) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();
        assertEquals(
            source.countUpTo(input),
            transformed.findPrimesBelow(input)
        );
    }
}