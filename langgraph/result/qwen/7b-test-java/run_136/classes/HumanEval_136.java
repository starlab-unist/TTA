import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_136 {

    // Source Code
    static class HumanEval_136_Source {
        public static Pair<Integer, Integer> largestSmallestIntegers(List<Integer> lst) {
            List<Integer> smallest = new ArrayList<>();
            List<Integer> largest = new ArrayList<>();

            for (int x : lst) {
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

        // Helper class for returning two values
        public static class Pair<T1, T2> {
            private T1 first;
            private T2 second;

            public Pair(T1 first, T2 second) {
                this.first = first;
                this.second = second;
            }

            public T1 getFirst() {
                return first;
            }

            public T2 getSecond() {
                return second;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Pair<?, ?> pair = (Pair<?, ?>) obj;
                return first.equals(pair.first) && second.equals(pair.second);
            }

            @Override
            public int hashCode() {
                return first.hashCode() ^ second.hashCode();
            }
        }
    }

    // Transformed Code
    static class HumanEval_136_Transformed {
        public Pair<Integer, Integer> findExtremeValues(int[] numbers) {
            List<Integer> negativeNumbers = new ArrayList<>();
            List<Integer> positiveNumbers = new ArrayList<>();

            for (int num : numbers) {
                if (num < 0) {
                    negativeNumbers.add(num);
                } else if (num > 0) {
                    positiveNumbers.add(num);
                }
            }

            Integer maxNegative = negativeNumbers.isEmpty() ? null : Collections.max(negativeNumbers);
            Integer minPositive = positiveNumbers.isEmpty() ? null : Collections.min(positiveNumbers);

            return new Pair<>(maxNegative, minPositive);
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, -1, -2, -3},  // Mixed negatives and positives
        {-5, -4, -3, -2, -1},     // All negatives
        {5, 4, 3, 2, 1},          // All positives
        {0, 0, 0},                // Only zeros
        {},                       // Empty list
        {-10, 0, 10},             // Single negative and positive
        {-1, -2, 0, 2, 1},        // Mixed with zero
        {100},                    // Single positive
        {-100},                   // Single negative
        {1, -1, 2, -2, 3, -3}     // Alternating positives and negatives
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[0])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[1])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[2])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[3])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[4])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[5])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[6])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[7])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[8])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_136_Source.largestSmallestIntegers(toList(testCases[9])), 
                     new HumanEval_136_Transformed().findExtremeValues(testCases[9]));
    }

    // Helper method to convert int[] to List<Integer>
    private static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }
}