import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_115 {

    // Source Code
    static class HumanEval_115_Source {
        public static int maxFill(List<List<Integer>> grid, int capacity) {
            int total = 0;
            for (List<Integer> row : grid) {
                double sum = row.stream().mapToInt(Integer::intValue).sum();
                total += Math.ceil(sum / capacity);
            }
            return total;
        }
    }

    // Transformed Code
    static class HumanEval_115_Transformed {
        public int calculateMaxLoad(int[][] matrix, double limit) {
            int totalLoad = 0;
            for (int[] row : matrix) {
                double sum = 0;
                for (int value : row) {
                    sum += value;
                }
                totalLoad += Math.ceil(sum / limit);
            }
            return totalLoad;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(List.of(10, 20), List.of(30, 40)), 10},
        {List.of(List.of(5, 5), List.of(5, 5)), 5},
        {List.of(List.of(1, 1, 1), List.of(2, 2, 2), List.of(3, 3, 3)), 1},
        {List.of(List.of(0, 0), List.of(0, 0)), 1},
        {List.of(List.of(7, 8, 9), List.of(10, 11, 12)), 5},
        {List.of(List.of(100)), 10},
        {List.of(List.of(10, 20, 30), List.of(40, 50, 60)), 25},
        {List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6)), 3},
        {List.of(List.of(15, 15), List.of(15, 15), List.of(15, 15)), 10},
        {List.of(List.of(2, 4, 6), List.of(8, 10, 12), List.of(14, 16, 18)), 7}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[0][0], (int) testCases[0][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[0][0]), (double) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[1][0], (int) testCases[1][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[1][0]), (double) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[2][0], (int) testCases[2][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[2][0]), (double) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[3][0], (int) testCases[3][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[3][0]), (double) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[4][0], (int) testCases[4][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[4][0]), (double) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[5][0], (int) testCases[5][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[5][0]), (double) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[6][0], (int) testCases[6][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[6][0]), (double) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[7][0], (int) testCases[7][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[7][0]), (double) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[8][0], (int) testCases[8][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[8][0]), (double) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_115_Source.maxFill((List<List<Integer>>) testCases[9][0], (int) testCases[9][1]), 
                     new HumanEval_115_Transformed().calculateMaxLoad(convertTo2DArray((List<List<Integer>>) testCases[9][0]), (double) testCases[9][1]));
    }

    private int[][] convertTo2DArray(List<List<Integer>> list) {
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            array[i] = row.stream().mapToInt(Integer::intValue).toArray();
        }
        return array;
    }
}