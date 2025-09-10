import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_129 {

    // Source Code
    static class HumanEval_129_Source {
        public static List<Integer> minPath(int[][] grid, int k) {  // Changed to static
            int n = grid.length;
            int val = n * n + 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        List<Integer> temp = new ArrayList<>();
                        if (i != 0) {
                            temp.add(grid[i - 1][j]);
                        }

                        if (j != 0) {
                            temp.add(grid[i][j - 1]);
                        }

                        if (i != n - 1) {
                            temp.add(grid[i + 1][j]);
                        }

                        if (j != n - 1) {
                            temp.add(grid[i][j + 1]);
                        }

                        for (int v : temp) {
                            if (v < val) {
                                val = v;
                            }
                        }
                    }
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (i % 2 == 0) {
                    ans.add(1);
                } else {
                    ans.add(val);
                }
            }
            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_129_Transformed {
        public static List<Integer> findMinimumPathValues(int[][] matrix, int count) {  // Changed to static
            int size = matrix.length;
            int minimumValue = size * size + 1;
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (matrix[row][col] == 1) {
                        List<Integer> neighbors = new ArrayList<>();
                        if (row > 0) {
                            neighbors.add(matrix[row - 1][col]);
                        }

                        if (col > 0) {
                            neighbors.add(matrix[row][col - 1]);
                        }

                        if (row < size - 1) {
                            neighbors.add(matrix[row + 1][col]);
                        }

                        if (col < size - 1) {
                            neighbors.add(matrix[row][col + 1]);
                        }

                        for (int neighbor : neighbors) {
                            if (neighbor < minimumValue) {
                                minimumValue = neighbor;
                            }
                        }
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            int index = 0;
            while (index < count) {
                if (index % 2 == 0) {
                    result.add(1);
                } else {
                    result.add(minimumValue);
                }
                index++;
            }

            return result;
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(new int[][]{{1, 2}, {3, 4}}, 5)},
        {Arguments.of(new int[][]{{1, 1}, {1, 1}}, 6)},
        {Arguments.of(new int[][]{{9, 8}, {7, 1}}, 3)},
        {Arguments.of(new int[][]{{1, 0}, {0, 1}}, 4)},
        {Arguments.of(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 5)},
        {Arguments.of(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}, 7)},
        {Arguments.of(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 1}}, 8)},
        {Arguments.of(new int[][]{{1, 0}, {0, 0}}, 1)},  // Revised test case
        {Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9)},
        {Arguments.of(new int[][]{{1, 0}, {0, 1}}, 2)}   // Additional revised test case
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @ParameterizedTest(name = "{index} => grid={0}, k={1}")
    @MethodSource("provideTestCases")
    void minPath_vs_findMinimumPathValues(int[][] grid, int k) {
        assertEquals(
            HumanEval_129_Source.minPath(grid, k),
            HumanEval_129_Transformed.findMinimumPathValues(grid, k)
        );
    }
}