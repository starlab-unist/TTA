import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_115 {

    // Source Code
    static class HumanEval_115_Source {
        public int maxFill(List<List<Integer>> grid, double capacity) {
            int total = 0;
            for (List<Integer> arr : grid) {
                total += Math.ceil(arr.stream().mapToInt(Integer::intValue).sum() / capacity);
            }
            return total;
        }
    }

    // Transformed Code
    static class HumanEval_115_Transformed {
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
    private static final Object[][] testCases = {
        {List.of(List.of(10, 20), List.of(30, 40)), 10.0},
        {List.of(List.of(5, 5), List.of(5, 5)), 5.0},
        {List.of(List.of(1, 1, 1), List.of(2, 2, 2), List.of(3, 3, 3)), 1.0},
        {List.of(List.of(0, 0), List.of(0, 0)), 1.0},
        {List.of(List.of(7, 8, 9), List.of(10, 11, 12)), 5.0},
        {List.of(List.of(100)), 10.0},
        {List.of(List.of(10, 20, 30), List.of(40, 50, 60)), 25.0},
        {List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6)), 3.0},
        {List.of(List.of(15, 15), List.of(15, 15), List.of(15, 15)), 10.0},
        {List.of(List.of(2, 4, 6), List.of(8, 10, 12), List.of(14, 16, 18)), 7.0},
        
        // Additional simple test cases
        {List.of(List.of(5, 5)), 1.0}, // Simple case, should be 10
        {List.of(List.of(10, 10), List.of(10, 10)), 20.0}, // Should be 2
        {List.of(List.of(3, 6, 9), List.of(12, 15, 18)), 3.0}, // Should be 17
        {List.of(List.of(0, 0, 0), List.of(0, 0, 0)), 5.0}, // Edge case with zero values
        {List.of(List.of(25, 25), List.of(25, 25)), 12.5} // Should be 4 (rounding up)
    };

    private static java.util.stream.Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void maxFill_vs_calculateMaxLoad(List<List<Integer>> grid, double capacity) {
        int[][] matrix = grid.stream()
                             .map(l -> l.stream().mapToInt(i -> i).toArray())
                             .toArray(int[][]::new);
        
        int limit = (int) capacity;

        assertEquals(
            HumanEval_115_Source.maxFill(grid, capacity),
            HumanEval_115_Transformed.calculateMaxLoad(matrix, limit)
        );
    }
}