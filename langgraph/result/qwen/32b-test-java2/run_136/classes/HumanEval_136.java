import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_136 {

    // Source Code
    static class HumanEval_136_Source {
        public static Integer[] largestSmallestIntegers(List<Integer> lst) {
            List<Integer> smallest = lst.stream().filter(x -> x < 0).collect(Collectors.toList());
            List<Integer> largest = lst.stream().filter(x -> x > 0).collect(Collectors.toList());

            Integer smallestValue = smallest.isEmpty() ? null : smallest.stream().max(Integer::compareTo).orElse(null);
            Integer largestValue = largest.isEmpty() ? null : largest.stream().min(Integer::compareTo).orElse(null);

            return new Integer[]{smallestValue, largestValue};
        }
    }

    // Transformed Code
    static class HumanEval_136_Transformed {
        public static Pair<Integer, Integer> findExtremeValues(List<Integer> numbers) {
            List<Integer> negativeNumbers = new ArrayList<>();
            List<Integer> positiveNumbers = new ArrayList<>();

            for (Integer num : numbers) {
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

        public static class Pair<T, U> {
            public final T first;
            public final U second;

            public Pair(T first, U second) {
                this.first = first;
                this.second = second;
            }
        }
    }

    // Test Cases
    private static final List<Integer>[] testCases = new List[]{
        Arrays.asList(1, 2, 3, -1, -2, -3),  // Mixed negatives and positives
        Arrays.asList(-5, -4, -3, -2, -1),     // All negatives
        Arrays.asList(5, 4, 3, 2, 1),          // All positives
        Arrays.asList(0, 0, 0),                // Only zeros
        Arrays.asList(),                       // Empty list
        Arrays.asList(-10, 0, 10),             // Single negative and positive
        Arrays.asList(-1, -2, 0, 2, 1),        // Mixed with zero
        Arrays.asList(100),                    // Single positive
        Arrays.asList(-100),                   // Single negative
        Arrays.asList(1, -1, 2, -2, 3, -3)     // Alternating positives and negatives
    };

    @Test
    public void test_0() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[0])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[0]).first, HumanEval_136_Transformed.findExtremeValues(testCases[0]).second}));
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[1])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[1]).first, HumanEval_136_Transformed.findExtremeValues(testCases[1]).second}));
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[2])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[2]).first, HumanEval_136_Transformed.findExtremeValues(testCases[2]).second}));
    }

    @Test
    public void test_3() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[3])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[3]).first, HumanEval_136_Transformed.findExtremeValues(testCases[3]).second}));
    }

    @Test
    public void test_4() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[4])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[4]).first, HumanEval_136_Transformed.findExtremeValues(testCases[4]).second}));
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[5])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[5]).first, HumanEval_136_Transformed.findExtremeValues(testCases[5]).second}));
    }

    @Test
    public void test_6() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[6])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[6]).first, HumanEval_136_Transformed.findExtremeValues(testCases[6]).second}));
    }

    @Test
    public void test_7() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[7])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[7]).first, HumanEval_136_Transformed.findExtremeValues(testCases[7]).second}));
    }

    @Test
    public void test_8() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[8])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[8]).first, HumanEval_136_Transformed.findExtremeValues(testCases[8]).second}));
    }

    @Test
    public void test_9() {
        assertEquals(Arrays.toString(HumanEval_136_Source.largestSmallestIntegers(testCases[9])), 
                     Arrays.toString(new Object[]{HumanEval_136_Transformed.findExtremeValues(testCases[9]).first, HumanEval_136_Transformed.findExtremeValues(testCases[9]).second}));
    }
}