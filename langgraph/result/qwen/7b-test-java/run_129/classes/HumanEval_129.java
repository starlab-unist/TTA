import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_129 {

    // Source Code
    static class OriginalImpl {
        public static List<Integer> minPath(int[][] grid, int k) {
            int n = grid.length;
            int val = n * n + 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        List<Integer> temp = Arrays.asList();
                        if (i != 0) {
                            temp = addToList(temp, grid[i - 1][j]);
                        }
                        if (j != 0) {
                            temp = addToList(temp, grid[i][j - 1]);
                        }
                        if (i != n - 1) {
                            temp = addToList(temp, grid[i + 1][j]);
                        }
                        if (j != n - 1) {
                            temp = addToList(temp, grid[i][j + 1]);
                        }
                        val = Math.min(val, temp.stream().min(Integer::compare).orElse(val));
                    }
                }
            }

            List<Integer> ans = Arrays.asList();
            for (int i = 0; i < k; i++) {
                if (i % 2 == 0) {
                    ans = addToList(ans, 1);
                } else {
                    ans = addToList(ans, val);
                }
            }
            return ans;
        }

        private static List<Integer> addToList(List<Integer> list, int value) {
            Integer[] array = list.toArray(new Integer[list.size() + 1]);
            array[array.length - 1] = value;
            return Arrays.asList(array);
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static List<Integer> minPath(int[][] grid, int k) {
            int n = grid.length;
            int val = n * n + 1;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        List<Integer> neighbors = Arrays.asList();
                        if (row > 0) {
                            neighbors = addToList(neighbors, grid[row - 1][col]);
                        }
                        if (col > 0) {
                            neighbors = addToList(neighbors, grid[row][col - 1]);
                        }
                        if (row < n - 1) {
                            neighbors = addToList(neighbors, grid[row + 1][col]);
                        }
                        if (col < n - 1) {
                            neighbors = addToList(neighbors, grid[row][col + 1]);
                        }
                        val = Math.min(val, neighbors.stream().min(Integer::compare).orElse(val));
                    }
                }
            }

            List<Integer> ans = Arrays.asList();
            int index = 0;
            while (index < k) {
                if (index % 2 == 0) {
                    ans = addToList(ans, 1);
                } else {
                    ans = addToList(ans, val);
                }
                index++;
            }

            return ans;
        }

        private static List<Integer> addToList(List<Integer> list, int value) {
            Integer[] array = list.toArray(new Integer[list.size() + 1]);
            array[array.length - 1] = value;
            return Arrays.asList(array);
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[][]{{1, 2}, {3, 4}}, 5),
            Arguments.of(new int[][]{{1, 1}, {1, 1}}, 6),
            Arguments.of(new int[][]{{9, 8}, {7, 1}}, 3),
            Arguments.of(new int[][]{{1, 0}, {0, 1}}, 4),
            Arguments.of(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 5),
            Arguments.of(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}, 7),
            Arguments.of(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 1}}, 8),
            Arguments.of(new int[][]{{1, 0}, {0, 0}}, 1),
            Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9),
            Arguments.of(new int[][]{{1, 0}, {0, 1}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMinPath(int[][] grid, int k) {
        assertEquals(OriginalImpl.minPath(grid, k), TransformedImpl.minPath(grid, k));
    }
}