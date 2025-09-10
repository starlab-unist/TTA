import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_120 {

    // Source Code
    static class SourceCode {
        public List<Integer> maximum(int[] arr, int k) {
            if (k == 0) {
                return new ArrayList<>();
            }
            Arrays.sort(arr);
            List<Integer> ans = new ArrayList<>();
            for (int i = arr.length - k; i < arr.length; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> findTopKElements(List<Integer> sequence, int count) {
            if (count == 0) {
                return new ArrayList<>();
            }

            List<Integer> sortedSequence = new ArrayList<>(sequence);
            Collections.sort(sortedSequence);
            List<Integer> topElements = sortedSequence.subList(sortedSequence.size() - count, sortedSequence.size());

            return topElements;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(new int[]{1, 2, 3, 4, 5}, 3),
        Arguments.of(new int[]{5, 4, 3, 2, 1}, 2),
        Arguments.of(new int[]{10, 9, 8, 7, 6}, 5),
        Arguments.of(new int[]{1, 1, 1, 1, 1}, 3),
        Arguments.of(new int[]{}, 1),
        Arguments.of(new int[]{1, 2, 3}, 0),
        Arguments.of(new int[]{-1, -2, -3, -4}, 2),
        Arguments.of(new int[]{100, 200, 300, 400, 500}, 0),
        Arguments.of(new int[]{5, 5, 5, 5, 5, 5}, 6),
        Arguments.of(new int[]{10, 20, 30, 40, 50}, 1)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test Source and Transformed Methods Equivalence")
    void maximum_vs_findTopKElements(int[] arr, int k) {
        List<Integer> sourceResult = new ArrayList<>();
        if (arr != null) {
            sourceResult = new SourceCode().maximum(arr, k);
        }

        List<Integer> transformedResult = new TransformedCode().findTopKElements(Arrays.stream(arr).boxed().toList(), k);

        assertEquals(sourceResult, transformedResult);
    }
}