import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_129 {

    // Source Code
    static class HumanEval_129_Source {
        public List<Integer> minPath(int[][] grid, int k) {
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
        public List<Integer> findMinimumPathValues(int[][] matrix, int count) {
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
    private static final int[][][] testCases = {
        {{1, 2}, {3, 4}},
        {{1, 1}, {1, 1}},
        {{9, 8}, {7, 1}},
        {{1, 0}, {0, 1}},
        {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}},
        {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 1}},
        {{1, 0}, {0, 0}},
        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
        {{1, 0}, {0, 1}}
    };

    private static final int[] testKValues = {
        5,
        6,
        3,
        4,
        5,
        7,
        8,
        1,
        9,
        2
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[0], testKValues[0]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[0], testKValues[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[1], testKValues[1]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[1], testKValues[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[2], testKValues[2]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[2], testKValues[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[3], testKValues[3]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[3], testKValues[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[4], testKValues[4]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[4], testKValues[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[5], testKValues[5]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[5], testKValues[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[6], testKValues[6]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[6], testKValues[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[7], testKValues[7]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[7], testKValues[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[8], testKValues[8]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[8], testKValues[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_129_Source().minPath(testCases[9], testKValues[9]), 
                     new HumanEval_129_Transformed().findMinimumPathValues(testCases[9], testKValues[9]));
    }
}