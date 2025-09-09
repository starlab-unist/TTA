import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_127 {

    // Source Code
    static class HumanEval_127_Source {
        public String intersection(int[] interval1, int[] interval2) {
            int l = Math.max(interval1[0], interval2[0]);
            int r = Math.min(interval1[1], interval2[1]);
            int length = r - l;
            if (length > 0 && isPrime(length)) {
                return "YES";
            }
            return "NO";
        }

        private boolean isPrime(int num) {
            if (num == 1 || num == 0) {
                return false;
            }
            if (num == 2) {
                return true;
            }
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_127_Transformed {
        public String checkIntervalForPrimeLength(int[] range1, int[] range2) {
            int start = Math.max(range1[0], range2[0]);
            int end = Math.min(range1[1], range2[1]);
            int span = end - start;
            if (span > 0 && primeCheck(span)) {
                return "YES";
            }
            return "NO";
        }

        private boolean primeCheck(int number) {
            if (number == 0 || number == 1) {
                return false;
            }
            if (number == 2) {
                return true;
            }
            for (int divisor = 2; divisor < number; divisor++) {
                if (number % divisor == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Test Cases
    private static final int[][][] testCases = {
        {{1, 5}, {3, 7}},   // Overlapping interval with prime length 2
        {{10, 20}, {15, 25}}, // Overlapping interval with non-prime length 5
        {{5, 5}, {5, 5}},     // No overlap (single point)
        {{2, 3}, {3, 4}},     // No overlap (adjacent intervals)
        {{0, 1}, {1, 2}},     // No overlap (adjacent intervals)
        {{1, 10}, {5, 6}},    // Overlapping interval with non-prime length 1
        {{1, 11}, {5, 7}},    // Overlapping interval with prime length 2
        {{4, 9}, {8, 13}},    // Overlapping interval with prime length 1
        {{1, 20}, {5, 15}},   // Overlapping interval with non-prime length 10
        {{7, 11}, {9, 13}}    // Overlapping interval with prime length 2
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Testing equivalence of intersection and checkIntervalForPrimeLength")
    @ParameterizedTest(name = "Test Case {index}")
    @MethodSource("provideTestCases")
    void intersection_vs_checkIntervalForPrimeLength(int[] interval1, int[] interval2) {
        assertEquals(
            HumanEval_127_Source.intersection(interval1, interval2),
            HumanEval_127_Transformed.checkIntervalForPrimeLength(interval1, interval2)
        );
    }
}