import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_87 {

    // Source Code
    static class HumanEval_87_Source {
        public static List<int[]> getRow(List<List<Integer>> lst, int x) { // Changed to static to allow direct access from test
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
                        return Integer.compare(b[1], a[1]);
                    }
                }
            });

            return coords;
        }
    }

    // Transformed Code
    static class HumanEval_87_Transformed {
        public static List<int[]> findCoordinates(int[][] matrix, int target) { // Changed to static to allow direct access from test
            List<int[]> positions = new ArrayList<>();
            for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {
                    if (matrix[rowIndex][colIndex] == target) {
                        positions.add(new int[]{rowIndex, colIndex});
                    }
                }
            }

            Collections.sort(positions, Comparator.comparingInt(pos -> pos[1]));
            Collections.sort(positions, Comparator.comparingInt(pos -> pos[0]));

            return positions;
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
        {List.of(List.of(1, 2), List.of(3, 4)), 4}, // Adjusted to use integers
        {List.of(List.of(1, 2), List.of(3, 4)), 5}, // Adjusted to use integers
        {List.of(List.of(1, 2), List.of(3, 4)), 6}, // Added simple test case
        {List.of(List.of(7, 8), List.of(9, 10), List.of(11, 12)), 7},
        {List.of(List.of(5, 5), List.of(5, 5)), 5}, // Added simple test case
        {List.of(List.of(1, 2, 3), List.of(4, 5, 6)), 2}, // Added simple test case
        {List.of(List.of(1, 2, 3), List.of(4, 5, 6)), 6}, // Added simple test case
        {List.of(List.of(1, 2, 3), List.of(4, 5, 6)), 9}, // Added simple test case
        {List.of(List.of(100, 200), List.of(300, 400)), 100} // Added simple test case
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> Arguments.arguments(
            args[0],
            args[1]
        ));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void getRow_vs_findCoordinates(List<List<Integer>> inputList, int target) {
        int[][] matrix = new int[inputList.size()][];
        for (int i = 0; i < inputList.size(); i++) {
            List<Integer> row = inputList.get(i);
            matrix[i] = row.stream().mapToInt(Integer::intValue).toArray();
        }

        assertEquals(
            arrayListsToString(HumanEval_87_Source.getRow(inputList, target)), // Static method call
            arrayListsToString(HumanEval_87_Transformed.findCoordinates(matrix, target)) // Static method call
        );
    }

    private static String arrayListsToString(List<int[]> lists) {
        StringBuilder sb = new StringBuilder();
        for (int[] arr : lists) {
            sb.append(Arrays.toString(arr)).append(",");
        }
        return sb.toString();
    }
}