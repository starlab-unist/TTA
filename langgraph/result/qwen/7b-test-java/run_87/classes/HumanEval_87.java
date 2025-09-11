import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_87 {

    // Source Code
    static class HumanEval_87_Source {
        public static List<int[]> getRow(List<List<Integer>> lst, int x) {
            List<int[]> coords = new ArrayList<>();
            for (int i = 0; i < lst.size(); i++) {
                for (int j = 0; j < lst.get(i).size(); j++) {
                    if (lst.get(i).get(j) == x) {
                        coords.add(new int[]{i, j});
                    }
                }
            }
            Collections.sort(coords, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] != o2[1]) {
                        return Integer.compare(o2[1], o1[1]);
                    } else {
                        return Integer.compare(o1[0], o2[0]);
                    }
                }
            });
            return coords;
        }
    }

    // Transformed Code
    static class HumanEval_87_Transformed {
        public List<int[]> getRow(List<List<Integer>> lst, int x) {
            List<int[]> coords = new ArrayList<>();
            for (int row_index = 0; row_index < lst.size(); row_index++) {
                for (int col_index = 0; col_index < lst.get(row_index).size(); col_index++) {
                    if (lst.get(row_index).get(col_index) == x) {
                        coords.add(new int[]{row_index, col_index});
                    }
                }
            }

            Collections.sort(coords, new Comparator<int[]>() {
                @Override
                public int compare(int[] pos1, int[] pos2) {
                    return Integer.compare(pos2[1], pos1[1]);
                }
            });

            Collections.sort(coords, new Comparator<int[]>() {
                @Override
                public int compare(int[] pos1, int[] pos2) {
                    return Integer.compare(pos1[0], pos2[0]);
                }
            });

            return coords;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)), 5},
        {List.of(List.of(1, 1, 1), List.of(1, 1, 1), List.of(1, 1, 1)), 1},
        {List.of(List.of(0, 0, 0), List.of(0, 0, 0), List.of(0, 0, 0)), 0},
        {List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)), 10},
        {List.of(List.of(1, 2, 3), List.of(3, 4, 5), List.of(5, 6, 7)), 3},
        {List.of(List.of(10, 20, 30), List.of(40, 50, 60), List.of(70, 80, 90)), 60},
        // Note: The test cases below contain strings which need to be converted to Integer for Java
        {List.of(List.of(1, 2), List.of(3, 4)), 4},
        {List.of(List.of(7, 8), List.of(9, 10), List.of(11, 12)), 7}
    };

    @Test
    public void test_0() {
        assertEquals(toList(HumanEval_87_Source.getRow((List<List<Integer>>) testCases[0][0], (int) testCases[0][1])), 
                     toList(new HumanEval_87_Transformed().getRow((List<List<Integer>>) testCases[0][0], (int) testCases[0][1])));
    }

    @Test
    public void test_1() {
        assertEquals(toList(HumanEval_87_Source.getRow((List<List<Integer>>) testCases[1][0], (int) testCases[1][1])), 
                     toList(new HumanEval_87_Transformed().getRow((List<List<Integer>>) testCases[1][0], (int) testCases[1][1])));
    }

    @Test
    public void test_2() {
        assertEquals(toList(HumanEval_87_Source.getRow((List<List<Integer>>) testCases[2][0], (int) testCases[2][1])), 
                     toList(new HumanEval_87_Transformed().getRow((List<List<Integer>>) testCases[2][0], (int) testCases[2][1])));
    }

    @Test
    public void test_3() {
        assertEquals(toList(HumanEval_87_Source.getRow((List<List<Integer>>) testCases[3][0], (int) testCases[3][1])), 
                     toList(new HumanEval_87_Transformed().getRow((List<List<Integer>>) testCases[3][0], (int) testCases[3][1])));
    }

    @Test
    public void test_4() {
        assertEquals(toList(HumanEval_87_Source.getRow((List<List<Integer>>) testCases[4][0], (int) testCases[4][1])), 
                     toList(new HumanEval_87_Transformed().getRow((List<List<Integer>>) testCases[4][0], (int) testCases[4][1])));
    }

    @Test
    public void test_5() {
        assertEquals(toList(HumanEval_87_Source.getRow((List<List<Integer>>) testCases[5][0], (int) testCases[5][1])), 
                     toList(new HumanEval_87_Transformed().getRow((List<List<Integer>>) testCases[5][0], (int) testCases[5][1])));
    }

    @Test
    public void test_6() {
        assertEquals(toList(HumanEval_87_Source.getRow((List<List<Integer>>) testCases[6][0], (int) testCases[6][1])), 
                     toList(new HumanEval_87_Transformed().getRow((List<List<Integer>>) testCases[6][0], (int) testCases[6][1])));
    }

    @Test
    public void test_7() {
        assertEquals(toList(HumanEval_87_Source.getRow((List<List<Integer>>) testCases[7][0], (int) testCases[7][1])), 
                     toList(new HumanEval_87_Transformed().getRow((List<List<Integer>>) testCases[7][0], (int) testCases[7][1])));
    }

    // Helper method to convert list of int[] to List<List<Integer>> for assertion
    private static List<List<Integer>> toList(List<int[]> listOfArrays) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] array : listOfArrays) {
            List<Integer> row = new ArrayList<>();
            for (int value : array) {
                row.add(value);
            }
            result.add(row);
        }
        return result;
    }
}