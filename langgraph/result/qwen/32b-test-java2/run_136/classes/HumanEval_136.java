// Import statements moved to the top of the file
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HumanEval_136 {

    // Source Code
    static class SourceCode {
        public static Integer[] largestSmallestIntegers(List<Integer> lst) {
            List<Integer> smallest = lst.stream().filter(x -> x < 0).collect(Collectors.toList());
            List<Integer> largest = lst.stream().filter(x -> x > 0).collect(Collectors.toList());

            Integer smallestValue = smallest.isEmpty() ? null : smallest.stream().max(Integer::compareTo).orElse(null);
            Integer largestValue = largest.isEmpty() ? null : largest.stream().min(Integer::compareTo).orElse(null);

            return new Integer[]{smallestValue, largestValue};
        }
    }

    // Transformed Code
    static class TransformedCode {
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
            
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                
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

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(List.of(1, 2, 3, -1, -2, -3)),   // Mixed negatives and positives
        Arguments.of(List.of(-5, -4, -3, -2, -1)),     // All negatives
        Arguments.of(List.of(5, 4, 3, 2, 1)),          // All positives
        Arguments.of(List.of(0, 0, 0)),                // Only zeros
        Arguments.of(List.of()),                       // Empty list
        Arguments.of(List.of(-10, 0, 10)),             // Single negative and positive
        Arguments.of(List.of(-1, -2, 0, 2, 1)),        // Mixed with zero
        Arguments.of(List.of(100)),                    // Single positive
        Arguments.of(List.of(-100)),                   // Single negative
        Arguments.of(List.of(1, -1, 2, -2, 3, -3))     // Alternating positives and negatives
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void largestSmallestIntegers_vs_findExtremeValues(List<Integer> inputList) {
        Integer[] sourceResult = SourceCode.largestSmallestIntegers(inputList);
        TransformedCode.Pair<Integer, Integer> transformedResult = TransformedCode.findExtremeValues(inputList);

        assertEquals(
            new TransformedCode.Pair<>(sourceResult[0], sourceResult[1]),
            transformedResult
        );
    }
}