import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HumanEval_87 {

    // Source Code
    static class OriginalImpl {
        public static List<int[]> getRow(List<List<Integer>> lst, int x) {
            List<int[]> coords = new ArrayList<>();
            
            for (int i = 0; i < lst.size(); i++) {
                for (int j = 0; j < lst.get(i).size(); j++) {
                    if (lst.get(i).get(j) == x) {
                        coords.add(new int[]{i, j});
                    }
                }
            }
            
            // Sort by column descending, then by row ascending
            coords.sort((a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]); // Descending order for columns
                } else {
                    return Integer.compare(a[0], b[0]); // Ascending order for rows
                }
            });
            
            return coords;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static List<int[]> findCoordinates(int[][] matrix, int target) {
            List<int[]> positions = new ArrayList<>();
            
            for (int row_index = 0; row_index < matrix.length; row_index++) {
                for (int col_index = 0; col_index < matrix[row_index].length; col_index++) {
                    if (matrix[row_index][col_index] == target) {
                        positions.add(new int[]{row_index, col_index});
                    }
                }
            }
            
            // Sort by column index in descending order
            positions.sort((pos1, pos2) -> Integer.compare(pos2[1], pos1[1]));
            
            // Then sort by row index in ascending order
            positions.sort((pos1, pos2) -> Integer.compare(pos1[0], pos2[0]));
            
            return positions;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 5),
            Arguments.of(Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1)), 1),
            Arguments.of(Arrays.asList(Arrays.asList(0, 0, 0), Arrays.asList(0, 0, 0), Arrays.asList(0, 0, 0)), 0),
            Arguments.of(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 10),
            Arguments.of(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), Arrays.asList(5, 6, 7)), 3),
            Arguments.of(new int[][]{{10, 20, 30}, {40, 50, 60}, {70, 80, 90}}, 60),
            Arguments.of(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4)), 1),
            Arguments.of(Arrays.asList(Arrays.asList(5, 6), Arrays.asList(7, 8)), 8),
            Arguments.of(new int[][]{{1, 2}, {3, 4}}, 3),
            Arguments.of(Arrays.asList(Arrays.asList(9, 9), Arrays.asList(9, 9)), 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(List<List<Integer>> inputList, int x) {
        List<int[]> originalResult = OriginalImpl.getRow(inputList, x);
        List<int[]> transformedResult = TransformedImpl.findCoordinates(convertToIntArray(inputList), x);

        assertEquals(originalResult.size(), transformedResult.size());
        for (int i = 0; i < originalResult.size(); i++) {
            assertArrayEquals(originalResult.get(i), transformedResult.get(i));
        }
    }

    // Helper method to convert List<List<Integer>> to int[][]
    private static int[][] convertToIntArray(List<List<Integer>> list) {
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

    // Helper method to compare two arrays of integer arrays
    private static void assertArrayEquals(int[] expected, int[] actual) {
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
}