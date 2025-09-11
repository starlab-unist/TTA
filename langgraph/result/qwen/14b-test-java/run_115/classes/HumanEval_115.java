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

public class HumanEval_115 {

    // Source Code
    static class HumanEval_115_Source {
        public static int maxFill(List<List<Integer>> grid, double capacity) {
            int total = 0;
            for (List<Integer> arr : grid) {
                double sum = 0;
                for (int num : arr) {
                    sum += num;
                }
                total += Math.ceil(sum / capacity);
            }
            return total;
        }
    }

    // Transformed Code
    static class HumanEval_115_Transformed {
        public static int calculateMaxLoad(int[][] matrix, int limit) {
            int totalLoad = 0;
            for (int[] row : matrix) {
                int sum = 0;
                for (int value : row) {
                    sum += value;
                }
                totalLoad += Math.ceil((double) sum / limit);
            }
            return totalLoad;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(Arrays.asList(10, 20), Arrays.asList(30, 40)), 10},
        {Arrays.asList(Arrays.asList(5, 5), Arrays.asList(5, 5)), 5},
        {Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(2, 2, 2), Arrays.asList(3, 3, 3)), 1},
        {Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 0)), 1},
        {Arrays.asList(Arrays.asList(7, 8, 9), Arrays.asList(10, 11, 12)), 5},
        {Arrays.asList(Arrays.asList(100)), 10},
        {Arrays.asList(Arrays.asList(10, 20, 30), Arrays.asList(40, 50, 60)), 25},
        {Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6)), 3},
        {Arrays.asList(Arrays.asList(15, 15), Arrays.asList(15, 15), Arrays.asList(15, 15)), 10},
        {Arrays.asList(Arrays.asList(2, 4, 6), Arrays.asList(8, 10, 12), Arrays.asList(14, 16, 18)), 7}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[0][0], (double) testCases[0][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[0][0]), (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[1][0], (double) testCases[1][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[1][0]), (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[2][0], (double) testCases[2][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[2][0]), (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[3][0], (double) testCases[3][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[3][0]), (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[4][0], (double) testCases[4][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[4][0]), (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[5][0], (double) testCases[5][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[5][0]), (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[6][0], (double) testCases[6][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[6][0]), (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[7][0], (double) testCases[7][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[7][0]), (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[8][0], (double) testCases[8][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[8][0]), (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[9][0], (double) testCases[9][1]), 
                     HumanEval_115_Transformed.calculateMaxLoad(toArray((List<List<Integer>>) testCases[9][0]), (int) testCases[9][1]));
    }

    private static int[][] toArray(List<List<Integer>> list) {
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            array[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                array[i][j] = row.get(j);
            }
        }
        return array;
    }
}