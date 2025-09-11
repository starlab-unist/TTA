import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_115 {

    // Source Code
    static class HumanEval_115_Source {
        public static int maxFill(int[][] grid, int capacity) {
            int totalFills = 0;
            for (int[] arr : grid) {
                int sum = 0;
                for (int num : arr) {
                    sum += num;
                }
                totalFills += (int) Math.ceil((double) sum / capacity);
            }
            return totalFills;
        }
    }

    // Transformed Code
    static class HumanEval_115_Transformed {
        public static int calculateMaxLoad(int[][] matrix, int limit) {
            int totalLoad = 0;
            for (int[] row : matrix) {
                totalLoad += (int) Math.ceil((double) Arrays.stream(row).sum() / limit);
            }
            return totalLoad;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[][]{{10, 20}, {30, 40}}, 10},
        {new int[][]{{5, 5}, {5, 5}}, 5},
        {new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}, 1},
        {new int[][]{{0, 0}, {0, 0}}, 1},
        {new int[][]{{7, 8, 9}, {10, 11, 12}}, 5},
        {new int[][]{{100}}, 10},
        {new int[][]{{10, 20, 30}, {40, 50, 60}}, 25},
        {new int[][]{{1, 2}, {3, 4}, {5, 6}}, 3},
        {new int[][]{{15, 15}, {15, 15}, {15, 15}}, 10},
        {new int[][]{{2, 4, 6}, {8, 10, 12}, {14, 16, 18}}, 7}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[0][0], (int) testCases[0][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[1][0], (int) testCases[1][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[2][0], (int) testCases[2][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[3][0], (int) testCases[3][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[4][0], (int) testCases[4][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[5][0], (int) testCases[5][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[6][0], (int) testCases[6][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[7][0], (int) testCases[7][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[8][0], (int) testCases[8][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_115_Source.maxFill((int[][]) testCases[9][0], (int) testCases[9][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad((int[][]) testCases[9][0], (int) testCases[9][1]));
    }
}