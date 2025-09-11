import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Source Code
public class HumanEval_87 {

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
                if (a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]); // Sort by column in descending order
                } else {
                    return Integer.compare(a[0], b[0]); // Sort by row in ascending order
                }
            }
        });
        
        return coords;
    }

    // Transformed Code
    public static List<int[]> findCoordinates(int[][] matrix, int target) {
        List<int[]> positions = new ArrayList<>();

        for (int row_index = 0; row_index < matrix.length; row_index++) {
            for (int col_index = 0; col_index < matrix[row_index].length; col_index++) {
                if (matrix[row_index][col_index] == target) {
                    positions.add(new int[]{row_index, col_index});
                }
            }
        }

        List<int[]> sortedPositions = positions.stream()
                .sorted((pos1, pos2) -> Integer.compare(pos2[1], pos1[1]))
                .collect(java.util.stream.Collectors.toList());

        List<int[]> finalSortedPositions = sortedPositions.stream()
                .sorted((pos1, pos2) -> Integer.compare(pos1[0], pos2[0]))
                .collect(java.util.stream.Collectors.toList());

        return finalSortedPositions;
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HumanEval_87Test {

    // Original Implementation Wrapper
    static class OriginalImpl {
        public static List<int[]> getRow(List<List<Integer>> lst, int x) {
            return HumanEval_87.getRow(lst, x);
        }
    }

    // Transformed Implementation Wrapper
    static class TransformedImpl {
        public static List<int[]> findCoordinates(int[][] matrix, int target) {
            return HumanEval_87.findCoordinates(matrix, target);
        }
    }

    // Test Cases Provider
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
                Arguments.of(List.of(List.of(5, 5), List.of(5, 5), List.of(5, 5)), 5),
                Arguments.of(List.of(List.of(1, 2, 3), List.of(4, 5, 6)), 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testEquivalence(List<List<Integer>> listInput, int target) {
        // Convert List<List<Integer>> to int[][]
        int[][] matrix = listInput.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        // Call both implementations
        List<int[]> originalResult = OriginalImpl.getRow(listInput, target);
        List<int[]> transformedResult = TransformedImpl.findCoordinates(matrix, target);

        // Compare results
        assertArrayEquals(originalResult, transformedResult);
    }

    private void assertArrayEquals(List<int[]> expected, List<int[]> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i));
        }
    }

    private void assertArrayEquals(int[] expected, int[] actual) {
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    private void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Expected: " + expected + ", but was: " + actual);
        }
    }
}