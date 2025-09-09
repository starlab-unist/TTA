import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

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
        Arrays.asList(1, -1, 2, -2, 3, -3),    // Alternating positives and negatives

        // Additional simple test cases
        Arrays.asList(-5, 5),                  // One negative one positive
        Arrays.asList(0),                     // Only zero
        Arrays.asList(1, 2, 3, 4, 5, 6),     // Multiple positives
        Arrays.asList(-1, -2, -3, -4, -5),    // Multiple negatives
        Arrays.asList(-10, 0, 10, 20)          // Mixed with zeros and multiple values
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "{index} => input={0}")
    @MethodSource("provideTestCases")
    void largestSmallestIntegers_vs_findExtremeValues(List<Integer> inputList) {
        Integer[] sourceResult = HumanEval_136_Source.largestSmallestIntegers(inputList);
        HumanEval_136_Transformed.Pair<Integer, Integer> transformedResult = HumanEval_136_Transformed.findExtremeValues(inputList);

        assertEquals(
            Arrays.asList(sourceResult[0], sourceResult[1]),
            Arrays.asList(transformedResult.first, transformedResult.second)
        );
    }
}