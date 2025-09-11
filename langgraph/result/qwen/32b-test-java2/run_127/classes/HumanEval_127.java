import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
// Source Code
static class OriginalImpl {
    public static String intersection(int[] interval1, int[] interval2) {
        int l = Math.max(interval1[0], interval2[0]);
        int r = Math.min(interval1[1], interval2[1]);
        int length = r - l;
        if (length > 0 && isPrime(length)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean isPrime(int num) {
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
static class TransformedImpl {
    public static String checkIntervalForPrimeLength(int[] range1, int[] range2) {
        int start = Math.max(range1[0], range2[0]);
        int end = Math.min(range1[1], range2[1]);
        int span = end - start;
        if (span > 0 && primeCheck(span)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean primeCheck(int number) {
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_127 {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 5}, new int[]{3, 7}),   // Overlapping interval with prime length 2
            Arguments.of(new int[]{10, 20}, new int[]{15, 25}), // Overlapping interval with non-prime length 5
            Arguments.of(new int[]{5, 5}, new int[]{5, 5}),     // No overlap
            Arguments.of(new int[]{2, 3}, new int[]{3, 4}),     // No overlap
            Arguments.of(new int[]{0, 1}, new int[]{1, 2}),     // No overlap
            Arguments.of(new int[]{1, 10}, new int[]{5, 6}),    // Overlapping interval with prime length 1
            Arguments.of(new int[]{1, 11}, new int[]{5, 7}),    // Overlapping interval with non-prime length 2
            Arguments.of(new int[]{4, 9}, new int[]{8, 13}),    // Overlapping interval with prime length 1
            Arguments.of(new int[]{1, 20}, new int[]{5, 15}),   // Overlapping interval with non-prime length 10
            Arguments.of(new int[]{7, 11}, new int[]{9, 13})    // Overlapping interval with prime length 2
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testIntersection(int[] interval1, int[] interval2) {
        String originalResult = OriginalImpl.intersection(interval1, interval2);
        String transformedResult = TransformedImpl.checkIntervalForPrimeLength(interval1, interval2);
        assertEquals(originalResult, transformedResult);
    }
}