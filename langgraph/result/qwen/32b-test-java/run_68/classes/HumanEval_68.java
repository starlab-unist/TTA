import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_68 {

    // Source Code
    static class SourceCode {
        public static List<Integer> pluck(List<Integer> arr) {
            if (arr.isEmpty()) return new ArrayList<>();
            
            List<Integer> evens = new ArrayList<>();
            for (Integer x : arr) {
                if (x % 2 == 0) {
                    evens.add(x);
                }
            }
            
            if (evens.isEmpty()) return new ArrayList<>();
            
            int minEven = Integer.MAX_VALUE;
            for (Integer even : evens) {
                if (even < minEven) {
                    minEven = even;
                }
            }
            
            int index = arr.indexOf(minEven);
            List<Integer> result = new ArrayList<>();
            result.add(minEven);
            result.add(index);
            
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> extractMinEvenAndIndex(List<Integer> sequence) {
            if (sequence.isEmpty()) {
                return new ArrayList<>();
            }

            List<Integer> evenNumbers = new ArrayList<>();
            for (int num : sequence) {
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
    private static final Arguments[] testCases = {
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
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test pluck and extractMinEvenAndIndex methods with various inputs")
    void testPluck_vs_extractMinEvenAndIndex(List<Integer> input, List<Integer> expectedOutput) {
        assertEquals(
            SourceCode.pluck(input),
            new TransformedCode().extractMinEvenAndIndex(input)
        );
    }
}