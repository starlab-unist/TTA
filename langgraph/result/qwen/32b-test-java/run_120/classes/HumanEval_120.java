import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_120 {

    // Source Code
    static class HumanEval_120_Source {
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
    static class HumanEval_120_Transformed {
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
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3, 4, 5}, 3},
        {new int[]{5, 4, 3, 2, 1}, 2},
        {new int[]{10, 9, 8, 7, 6}, 5},
        {new int[]{1, 1, 1, 1, 1}, 3},
        {new int[]{}, 1},
        {new int[]{1, 2, 3}, 0},
        {new int[]{-1, -2, -3, -4}, 2},
        {new int[]{100, 200, 300, 400, 500}, 0},
        {new int[]{5, 5, 5, 5, 5, 5}, 6},
        {new int[]{10, 20, 30, 40, 50}, 1}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void maximum_vs_findTopKElements(Object[] testCase) {
        int[] inputArray = (int[]) testCase[0];
        int k = (int) testCase[1];

        List<Integer> sourceResult = new HumanEval_120_Source().maximum(inputArray, k);
        List<Integer> transformedResult = new HumanEval_120_Transformed().findTopKElements(Arrays.stream(inputArray).boxed().toList(), k);

        assertEquals(sourceResult, transformedResult);
    }
}