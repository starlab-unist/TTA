import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;  // Added import for Stream

public class HumanEval_34 {

    // Source Code
    static class SourceCode {
        public static List<Integer> unique(List<Integer> l) {
            Set<Integer> set = new HashSet<>(l);
            List<Integer> result = new ArrayList<>(set);
            Collections.sort(result);
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> extractDistinctElements(List<Integer> inputList) {
            Set<Integer> distinctElements = new TreeSet<>(inputList);
            List<Integer> sortedElements = new ArrayList<>(distinctElements);
            return sortedElements;
        }
    }

    // Test Cases
    private static final Integer[][] testCases = {
        {1, 2, 3, 4, 5, 5, 6},
        {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5},
        {}, // Empty list
        {1, 1, 1, 1}, // All elements the same
        {10, 20, 30, 40, 50}, // Already sorted unique elements
        {50, 40, 30, 20, 10}, // Reverse sorted unique elements
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, // Sorted unique elements
        {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, // Reverse sorted elements
        {-1, -2, -3, -4, -5, -5, -6}, // Negative numbers with duplicates
        {100} // Single element list
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void unique_vs_extractDistinctElements(List<Integer> inputList) {
        assertEquals(
            SourceCode.unique(inputList),
            new TransformedCode().extractDistinctElements(inputList)
        );
    }
}