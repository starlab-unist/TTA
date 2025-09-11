import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_136 {

    // Source Code
    public static Pair<Integer, Integer> largestSmallestIntegers(List<Integer> lst) {
        List<Integer> smallest = new ArrayList<>();
        List<Integer> largest = new ArrayList<>();

        for (Integer x : lst) {
            if (x < 0) {
                smallest.add(x);
            } else if (x > 0) {
                largest.add(x);
            }
        }

        Integer maxSmallest = smallest.isEmpty() ? null : Collections.max(smallest);
        Integer minLargest = largest.isEmpty() ? null : Collections.min(largest);

        return new Pair<>(maxSmallest, minLargest);
    }

    // Transformed Code
    public static List<Optional<Integer>> findExtremeValues(List<Integer> numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();
        List<Integer> positiveNumbers = new ArrayList<>();

        for (Integer num : numbers) {
            if (num < 0) {
                negativeNumbers.add(num);
            } else if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        Optional<Integer> maxNegative = negativeNumbers.isEmpty() ? Optional.empty() : Optional.of(negativeNumbers.stream().max(Integer::compare).get());
        Optional<Integer> minPositive = positiveNumbers.isEmpty() ? Optional.empty() : Optional.of(positiveNumbers.stream().min(Integer::compare).get());

        List<Optional<Integer>> result = new ArrayList<>();
        result.add(maxNegative);
        result.add(minPositive);

        return result;
    }

    // Pair class for source code
    public static class Pair<T, U> {
        public final T first;
        public final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            return (first == null ? pair.first == null : first.equals(pair.first)) &&
                   (second == null ? pair.second == null : second.equals(pair.second));
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }

    // Test Cases
    private static final List<Integer>[] testCases = new List[]{
        List.of(1, 2, 3, -1, -2, -3),   // Mixed negatives and positives
        List.of(-5, -4, -3, -2, -1),     // All negatives
        List.of(5, 4, 3, 2, 1),          // All positives
        List.of(0, 0, 0),                // Only zeros
        List.of(),                       // Empty list
        List.of(-10, 0, 10),             // Single negative and positive
        List.of(-1, -2, 0, 2, 1),        // Mixed with zero
        List.of(100),                    // Single positive
        List.of(-100),                   // Single negative
        List.of(1, -1, 2, -2, 3, -3)     // Alternating positives and negatives
    };

    @Test
    public void test_0() {
        assertEquals(largestSmallestIntegers(testCases[0]), convertToPair(findExtremeValues(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(largestSmallestIntegers(testCases[1]), convertToPair(findExtremeValues(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(largestSmallestIntegers(testCases[2]), convertToPair(findExtremeValues(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(largestSmallestIntegers(testCases[3]), convertToPair(findExtremeValues(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(largestSmallestIntegers(testCases[4]), convertToPair(findExtremeValues(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(largestSmallestIntegers(testCases[5]), convertToPair(findExtremeValues(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(largestSmallestIntegers(testCases[6]), convertToPair(findExtremeValues(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(largestSmallestIntegers(testCases[7]), convertToPair(findExtremeValues(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(largestSmallestIntegers(testCases[8]), convertToPair(findExtremeValues(testCases[8])));
    }

    @Test
    public void test_9() {
        assertEquals(largestSmallestIntegers(testCases[9]), convertToPair(findExtremeValues(testCases[9])));
    }

    // Helper method to convert List<Optional<Integer>> to Pair<Integer, Integer>
    private static Pair<Integer, Integer> convertToPair(List<Optional<Integer>> list) {
        Integer first = list.get(0).orElse(null);
        Integer second = list.get(1).orElse(null);
        return new Pair<>(first, second);
    }
}