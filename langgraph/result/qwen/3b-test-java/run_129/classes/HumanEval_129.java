import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_129 {

    // Source Code
    static class HumanEval_129_Source {
        public static int[] minPath(int[][] grid, int k) {
            int n = grid.length;
            int val = n * n + 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int[] temp = new int[4];
                        Arrays.fill(temp, val); // Initialize with val
                        if (i != 0) {
                            temp[0] = grid[i - 1][j];
                        }
                        if (j != 0) {
                            temp[1] = grid[i][j - 1];
                        }
                        if (i != n - 1) {
                            temp[2] = grid[i + 1][j];
                        }
                        if (j != n - 1) {
                            temp[3] = grid[i][j + 1];
                        }

                        val = Arrays.stream(temp).min().orElse(val);
                    }
                }
            }

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                if (i % 2 == 0) {
                    ans[i] = 1;
                } else {
                    ans[i] = val;
                }
            }
            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_129_Transformed {
        public static List<Integer> findMinimumPathValues(int[][] matrix, int count) {
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
                        minimumValue = Collections.min(neighbors);
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
    private static final int[][][] testCasesGrid = {
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

    private static final int[] testCasesK = {
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
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[0], testCasesK[0])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[0], testCasesK[0]).toString());
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[1], testCasesK[1])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[1], testCasesK[1]).toString());
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[2], testCasesK[2])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[2], testCasesK[2]).toString());
    }

    @Test
    public void test_3() {
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[3], testCasesK[3])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[3], testCasesK[3]).toString());
    }

    @Test
    public void test_4() {
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[4], testCasesK[4])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[4], testCasesK[4]).toString());
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[5], testCasesK[5])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[5], testCasesK[5]).toString());
    }

    @Test
    public void test_6() {
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[6], testCasesK[6])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[6], testCasesK[6]).toString());
    }

    @Test
    public void test_7() {
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[7], testCasesK[7])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[7], testCasesK[7]).toString());
    }

    @Test
    public void test_8() {
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[8], testCasesK[8])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[8], testCasesK[8]).toString());
    }

    @Test
    public void test_9() {
        assertEquals(Arrays.toString(HumanEval_129_Source.minPath(testCasesGrid[9], testCasesK[9])),
                     HumanEval_129_Transformed.findMinimumPathValues(testCasesGrid[9], testCasesK[9]).toString());
    }
}