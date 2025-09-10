import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream; // Added import for Stream

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_68 {

    // Source Code
    static class SourceCode {
        public static List<Object> pluck(List<Integer> arr) {
            if (arr.isEmpty()) {
                return new ArrayList<>();
            }
            
            List<Integer> evens = new ArrayList<>();
            for (Integer x : arr) {
                if (x % 2 == 0) {
                    evens.add(x);
                }
            }
            
            if (evens.isEmpty()) {
                return new ArrayList<>();
            }
            
            int minEven = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) % 2 == 0 && arr.get(i) < minEven) {
                    minEven = arr.get(i);
                    minIndex = i;
                }
            }
            
            List<Object> result = new ArrayList<>();
            result.add(minEven);
            result.add(minIndex);
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> extractMinEvenAndIndex(List<Integer> sequence) {
            if (sequence.isEmpty()) {
                return new ArrayList<>();
            }

            List<Integer> evenNumbers = new ArrayList<>();
            for (Integer num : sequence) {
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                }
            }

            if (evenNumbers.isEmpty()) {
                return new ArrayList<>();
            }

            int smallestEven = Integer.MAX_VALUE;
            for (int num : evenNumbers) {
                if (num < smallestEven) {
                    smallestEven = num;
                }
            }

            int positionOfSmallestEven = sequence.indexOf(smallestEven);

            List<Integer> result = new ArrayList<>();
            result.add(smallestEven);
            result.add(positionOfSmallestEven);

            return result;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(2, 1)),
        Arguments.of(Arrays.asList(10, 21, 3, 7, 8), Arrays.asList(8, 4)),
        Arguments.of(Arrays.asList(), new ArrayList<>()),
        Arguments.of(Arrays.asList(1, 3, 5, 7), new ArrayList<>()),
        Arguments.of(Arrays.asList(2, 4, 6, 8), Arrays.asList(2, 0)),
        Arguments.of(Arrays.asList(9, 7, 5, 3, 2, 4, 6, 8), Arrays.asList(2, 4)),
        Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5), Arrays.asList(0, 0)),
        Arguments.of(Arrays.asList(11, 13, 17, 19, 23, 29, 2), Arrays.asList(2, 6)),
        Arguments.of(Arrays.asList(8, 6, 4, 2, 0), Arrays.asList(0, 4)),
        Arguments.of(Arrays.asList(2, 2, 2, 2, 2), Arrays.asList(2, 0))
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test pluck vs extractMinEvenAndIndex equivalence")
    void pluck_vs_extractMinEvenAndIndex(List<Integer> input, List<?> expectedOutput) {
        assertEquals(
            SourceCode.pluck(input),
            TransformedCode.extractMinEvenAndIndex(input)
        );
    }
}