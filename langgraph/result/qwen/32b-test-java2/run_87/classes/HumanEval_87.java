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
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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
    static class TransformedImpl {
        public static List<int[]> findCoordinates(int[][] matrix, int target) {
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
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)), 5),
            Arguments.of(List.of(List.of(1, 1, 1), List.of(1, 1, 1), List.of(1, 1, 1)), 1),
            Arguments.of(List.of(List.of(0, 0, 0), List.of(0, 0, 0), List.of(0, 0, 0)), 0),
            Arguments.of(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)), 10),
            Arguments.of(List.of(List.of(1, 2, 3), List.of(3, 4, 5), List.of(5, 6, 7)), 3),
            Arguments.of(List.of(List.of(10, 20, 30), List.of(40, 50, 60), List.of(70, 80, 90)), 60),
            Arguments.of(List.of(List.of(1, 2), List.of(3, 4)), 4),
            Arguments.of(List.of(List.of(7, 8), List.of(9, 10), List.of(11, 12)), 7),
            Arguments.of(List.of(List.of(5, 5, 5), List.of(5, 5, 5), List.of(5, 5, 5)), 5),
            Arguments.of(List.of(List.of(1, 2, 3), List.of(6, 7, 8), List.of(9, 10, 11)), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testBothImplementations(List<List<Integer>> inputMatrix, int target) {
        // Convert List<List<Integer>> to int[][]
        int[][] matrix = toIntMatrix(inputMatrix);

        // Get results from both implementations
        List<int[]> originalResult = OriginalImpl.getRow(inputMatrix, target);
        List<int[]> transformedResult = TransformedImpl.findCoordinates(matrix, target);

        // Assert that the results are equal
        assertArrayEquals(originalResult, transformedResult);
    }

    // Helper method to convert List<List<Integer>> to int[][]
    private static int[][] toIntMatrix(List<List<Integer>> list) {
        int[][] matrix = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> rowList = list.get(i);
            matrix[i] = rowList.stream().mapToInt(Integer::intValue).toArray();
        }
        return matrix;
    }

    // Custom assertion to compare arrays of int[] because assertEquals does not work directly with them
    private static void assertArrayEquals(List<int[]> expected, List<int[]> actual) {
        if (expected.size() != actual.size()) {
            throw new AssertionError("Arrays have different lengths");
        }
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(java.util.Arrays.toString(expected.get(i)), java.util.Arrays.toString(actual.get(i)));
        }
    }
}