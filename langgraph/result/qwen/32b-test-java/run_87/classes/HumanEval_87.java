import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_87 {

    // Source Code
    static class HumanEval_87_Source {
        public List<int[]> getRow(List<List<Integer>> lst, int x) {
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
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    } else {
                        return Integer.compare(b[1], a[1]); // Note: Descending order for column index
                    }
                }
            });

            return coords;
        }
    }

    // Transformed Code
    static class HumanEval_87_Transformed {
        public List<int[]> findCoordinates(int[][] matrix, int target) {
            List<int[]> positions = new ArrayList<>();
            for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {
                    if (matrix[rowIndex][colIndex] == target) {
                        positions.add(new int[]{rowIndex, colIndex});
                    }
                }
            }

            // Correct sorting logic to match the source code
            Collections.sort(positions, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    } else {
                        return Integer.compare(b[1], a[1]); // Note: Descending order for column index
                    }
                }
            });

            return positions;
        }
    }

    // Test Cases
    private static final List<Object[]> testCases = Arrays.asList(
        new Object[]{Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 5},
        new Object[]{Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1)), 1},
        new Object[]{Arrays.asList(Arrays.asList(0, 0, 0), Arrays.asList(0, 0, 0), Arrays.asList(0, 0, 0)), 0},
        new Object[]{Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 10},
        new Object[]{Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), Arrays.asList(5, 6, 7)), 3},
        new Object[]{Arrays.asList(Arrays.asList(10, 20, 30), Arrays.asList(40, 50, 60), Arrays.asList(70, 80, 90)), 60},
        new Object[]{Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6)), 4},
        new Object[]{Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)), 2},
        new Object[]{Arrays.asList(Arrays.asList(9, 8, 7), Arrays.asList(6, 5, 4), Arrays.asList(3, 2, 1)), 5},
        new Object[]{Arrays.asList(Arrays.asList(0, 1, 0), Arrays.asList(1, 0, 1), Arrays.asList(0, 1, 0)), 1}
    );

    @Test
    public void test_0() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(0)[0], (int) testCases.get(0)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(0)[0]), (int) testCases.get(0)[1])));
    }

    @Test
    public void test_1() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(1)[0], (int) testCases.get(1)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(1)[0]), (int) testCases.get(1)[1])));
    }

    @Test
    public void test_2() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(2)[0], (int) testCases.get(2)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(2)[0]), (int) testCases.get(2)[1])));
    }

    @Test
    public void test_3() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(3)[0], (int) testCases.get(3)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(3)[0]), (int) testCases.get(3)[1])));
    }

    @Test
    public void test_4() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(4)[0], (int) testCases.get(4)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(4)[0]), (int) testCases.get(4)[1])));
    }

    @Test
    public void test_5() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(5)[0], (int) testCases.get(5)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(5)[0]), (int) testCases.get(5)[1])));
    }

    @Test
    public void test_6() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(6)[0], (int) testCases.get(6)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(6)[0]), (int) testCases.get(6)[1])));
    }

    @Test
    public void test_7() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(7)[0], (int) testCases.get(7)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(7)[0]), (int) testCases.get(7)[1])));
    }

    @Test
    public void test_8() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(8)[0], (int) testCases.get(8)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(8)[0]), (int) testCases.get(8)[1])));
    }

    @Test
    public void test_9() {
        assertEquals(convertTo2DArray(HumanEval_87_Source.getRow((List<List<Integer>>) testCases.get(9)[0], (int) testCases.get(9)[1])),
                     convertTo2DArray(HumanEval_87_Transformed.findCoordinates(convertToListOfIntArrays((List<List<Integer>>) testCases.get(9)[0]), (int) testCases.get(9)[1])));
    }

    // Helper method to convert List<List<Integer>> to int[][]
    private static int[][] convertToListOfIntArrays(List<List<Integer>> lst) {
        return lst.stream()
                  .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                  .toArray(int[][]::new);
    }

    // Helper method to convert List<int[]> to List<int[]>
    private static List<int[]> convertTo2DArray(List<int[]> lst) {
        return new ArrayList<>(lst);
    }
}