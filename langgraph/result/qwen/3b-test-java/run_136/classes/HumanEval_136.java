import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_136 {

    // Source Code
    public static Pair<Integer, Integer> largestSmallestIntegers(List<Integer> lst) {
        List<Integer> smallest = lst.stream()
                                   .filter(x -> x < 0)
                                   .collect(Collectors.toList());
        List<Integer> largest = lst.stream()
                                  .filter(x -> x > 0)
                                  .collect(Collectors.toList());

        Integer smallestValue = smallest.isEmpty() ? null : Collections.max(smallest);
        Integer largestValue = largest.isEmpty() ? null : Collections.min(largest);

        return new Pair<>(smallestValue, largestValue);
    }

    // Transformed Code
    public static int[] findExtremeValues(int[] numbers) {
        int[] result = new int[2];

        int maxNegative = Integer.MIN_VALUE;
        int minPositive = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (num < 0 && num > maxNegative) {
                maxNegative = num;
            }
            if (num > 0 && num < minPositive) {
                minPositive = num;
            }
        }

        if (maxNegative == Integer.MIN_VALUE) {
            result[0] = -1; // Indicate no negative numbers
        } else {
            result[0] = maxNegative;
        }

        if (minPositive == Integer.MAX_VALUE) {
            result[1] = 1; // Indicate no positive numbers
        } else {
            result[1] = minPositive;
        }

        return result;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3, -1, -2, -3)},  // Mixed negatives and positives
        {Arrays.asList(-5, -4, -3, -2, -1)},     // All negatives
        {Arrays.asList(5, 4, 3, 2, 1)},          // All positives
        {Arrays.asList(0, 0, 0)},                // Only zeros
        {Arrays.asList()},                       // Empty list
        {Arrays.asList(-10, 0, 10)},             // Single negative and positive
        {Arrays.asList(-1, -2, 0, 2, 1)},        // Mixed with zero
        {Arrays.asList(100)},                    // Single positive
        {Arrays.asList(-100)},                   // Single negative
        {Arrays.asList(1, -1, 2, -2, 3, -3)}     // Alternating positives and negatives
    };

    @Test
    public void test_0() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[0][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[0][0]))));
    }

    @Test
    public void test_1() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[1][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[1][0]))));
    }

    @Test
    public void test_2() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[2][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[2][0]))));
    }

    @Test
    public void test_3() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[3][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[3][0]))));
    }

    @Test
    public void test_4() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[4][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[4][0]))));
    }

    @Test
    public void test_5() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[5][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[5][0]))));
    }

    @Test
    public void test_6() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[6][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[6][0]))));
    }

    @Test
    public void test_7() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[7][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[7][0]))));
    }

    @Test
    public void test_8() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[8][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[8][0]))));
    }

    @Test
    public void test_9() {
        assertEquals(largestSmallestIntegers((List<Integer>) testCases[9][0]), 
                     arrayToPair(findExtremeValues(listToArray((List<Integer>) testCases[9][0]))));
    }

    private int[] listToArray(List<Integer> lst) {
        return lst.stream().mapToInt(i -> i).toArray();
    }

    private Pair<Integer, Integer> arrayToPair(int[] result) {
        if (result[0] == -1) {
            return new Pair<>(null, result[1]);
        } else if (result[1] == 1) {
            return new Pair<>(result[0], null);
        }
        return new Pair<>(result[0], result[1]);
    }

    // Helper class for storing pairs
    static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (!first.equals(pair.first)) return false;
            return second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            int result = first.hashCode();
            result = 31 * result + second.hashCode();
            return result;
        }
    }
}