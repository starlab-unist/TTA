import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream; // Add this import

public class HumanEval_52 {

    // Source Code
    static class HumanEval_52_Source {
        public static boolean belowThreshold(List<Integer> l, int t) {
            for (int e : l) {
                if (e >= t) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_52_Transformed {
        public static boolean allElementsUnderLimit(int[] elements, int threshold) {
            int index = 0;
            while (index < elements.length) {
                if (elements[index] >= threshold) {
                    return false;
                }
                index += 1;
            }
            return true;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = { // Change this to a single-dimensional array
        Arguments.of(new ArrayList<>(), 10),                     // Empty list
        Arguments.of(Arrays.asList(1, 2, 3, 4), 5),           // All elements below threshold
        Arguments.of(Arrays.asList(10, 20, 30), 10),          // First element equals threshold
        Arguments.of(Arrays.asList(5, 6, 7, 8), 5),           // First element equals threshold
        Arguments.of(Arrays.asList(1, 2, 3, 4, 10), 5),       // One element above threshold
        Arguments.of(Arrays.asList(9, 8, 7, 6, 5), 10),       // All elements below threshold
        Arguments.of(Arrays.asList(10, 9, 8, 7, 6), 10),      // First element equals threshold
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 1),        // Threshold less than all elements
        Arguments.of(Arrays.asList(0, -1, -2, -3), 0),        // Negative numbers below threshold
        Arguments.of(Arrays.asList(-1, -2, -3, 0), 0)         // Negative numbers below threshold with zero
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases); // Directly stream over the testCases array
    }

    @ParameterizedTest(name = "{index} => inputList={0}, threshold={1}")
    @MethodSource("provideTestCases")
    void belowThreshold_vs_allElementsUnderLimit(List<Integer> inputList, int threshold) {
        assertEquals(
            HumanEval_52_Source.belowThreshold(inputList, threshold),
            HumanEval_52_Transformed.allElementsUnderLimit(inputList.stream().mapToInt(Integer::intValue).toArray(), threshold)
        );
    }
}