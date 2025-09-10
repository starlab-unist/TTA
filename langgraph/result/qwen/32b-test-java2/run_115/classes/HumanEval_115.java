import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_115 {

    // Source Code
    static class SourceCode {
        public int maxFill(List<List<Integer>> grid, double capacity) {
            int total = 0;
            for (List<Integer> arr : grid) {
                total += Math.ceil(arr.stream().mapToInt(Integer::intValue).sum() / capacity);
            }
            return total;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int calculateMaxLoad(int[][] matrix, int limit) {
            int totalLoad = 0;
            for (int[] row : matrix) {
                totalLoad += Math.ceil((double) sumArray(row) / limit);
            }
            return totalLoad;
        }

        private int sumArray(int[] array) {
            int sum = 0;
            for (int value : array) {
                sum += value;
            }
            return sum;
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(Arrays.asList(Arrays.asList(10, 20), Arrays.asList(30, 40)), 10)},
        {Arguments.of(Arrays.asList(Arrays.asList(5, 5), Arrays.asList(5, 5)), 5)},
        {Arguments.of(Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(2, 2, 2), Arrays.asList(3, 3, 3)), 1)},
        {Arguments.of(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 0)), 1)},
        {Arguments.of(Arrays.asList(Arrays.asList(7, 8, 9), Arrays.asList(10, 11, 12)), 5)},
        {Arguments.of(Arrays.asList(Arrays.asList(100)), 10)},
        {Arguments.of(Arrays.asList(Arrays.asList(10, 20, 30), Arrays.asList(40, 50, 60)), 25)},
        {Arguments.of(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6)), 3)},
        {Arguments.of(Arrays.asList(Arrays.asList(15, 15), Arrays.asList(15, 15), Arrays.asList(15, 15)), 10)},
        {Arguments.of(Arrays.asList(Arrays.asList(2, 4, 6), Arrays.asList(8, 10, 12), Arrays.asList(14, 16, 18)), 7)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> args[0]);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test equivalence of maxFill and calculateMaxLoad")
    void testMaxFill_vs_calculateMaxLoad(Arguments arguments) {
        List<List<Integer>> grid = (List<List<Integer>>) arguments.get()[0];
        double capacity = (double) arguments.get()[1];

        int[][] matrix = grid.stream()
                             .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                             .toArray(int[][]::new);
        int limit = (int) capacity;

        assertEquals(
            new SourceCode().maxFill(grid, capacity),
            new TransformedCode().calculateMaxLoad(matrix, limit)
        );
    }
}